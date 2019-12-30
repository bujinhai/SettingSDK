package com.jinshu.settinglibrary.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.widget.Toast;

import com.jinshu.settinglibrary.api.SApi;
import com.jinshu.settinglibrary.api.SHostType;
import com.jinshu.settinglibrary.base.basebean.SBaseResponse;
import com.jinshu.settinglibrary.base.baserx.SRxSchedulers;
import com.jinshu.settinglibrary.base.baserx.SRxSubscriber;
import com.jinshu.settinglibrary.download.DownloadManager;
import com.jinshu.settinglibrary.download.FileCallback;
import com.jinshu.settinglibrary.entity.VersionData;
import com.jinshu.settinglibrary.widget.AlertDialog;

import java.io.File;
import java.io.IOException;

/**
 * Create on 2019/9/10 19:39 by bll
 * 版本更新
 */


public class UpdateUtils {

    private static String destFileName = "healthy.apk";
    private static AlertDialog dialog;
    private static boolean isClick;//下载期间不允许再次点击

    public static void getVersionData(final Context context, String siteID) {
        SApi.getDefault(SHostType.BASE_URL)
                .getVersionDetail(siteID)
                .compose(SRxSchedulers.<SBaseResponse<VersionData>>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse<VersionData>>(context) {

                    @Override
                    protected void onSuccess(SBaseResponse<VersionData> data) {
                        if (data == null || data.body == null || data.body.getData() == null) {
                            return;
                        }
                        String versionCode = getAppVersionName(context);
                        if (!versionCode.equals(data.body.getData().getCode())) {
                            showVersionDialog(context, data.body.getData());
                        } else {
                            if (mListener != null) {
                                mListener.onNew(data.body.getData().getCode(),data.body.getData().getVersionID());
                            }
                        }
                    }

                    @Override
                    protected void onFail(String message) {
                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private static void showVersionDialog(final Context context, final VersionData.DataInfo info) {
        dialog = new AlertDialog(context, "新版本V" + info.getCode() + ",邀您体验", info.getTipsUpgrade(), info.getDescription(), "立即升级", "下次提醒", info.getIsNoLogin(), new AlertDialog.OnDialogButtonClickListener() {
            @Override
            public void onDialogButtonClick(boolean isPositive) {
                if (isPositive) {
                    if (!isClick) {
                        download(context, info.getFileURL(), info.getFileSizeK() * 1000);
                        isClick = true;
                    } else {
                        Toast.makeText(context, "正在下载...", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (mListener != null) {
                        mListener.onCancel();
                    }
                }
            }
        });
        dialog.show();
    }

    private static void download(final Context context, String url, final long fileSize) {
        DownloadManager manager = new DownloadManager();
        FileCallback callback = new FileCallback(destFileName) {
            @Override
            public void onSuccess(Object o) {
                isClick = false;
                File file = null;
                try {
                    file = LibraryFileUtils.getFile(destFileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                LibraryFileUtils.installApk(context, file);
            }

            @Override
            public void onLoading(long progress, long total) {
                int pro;
                if (total == -1) {
                    pro = (int) ((progress * 1.0 / fileSize) * 100);
                } else {
                    pro = (int) ((progress * 1.0 / total) * 100);
                }
                dialog.setStrPositive(pro + "%");
            }

            @Override
            public void onCompleted() {
                dialog.dismiss();
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                isClick = false;
            }
        };
        manager.load(url, callback);
    }

    private static String getAppVersionName(Context context) {
        String version = "0";

        try {
            version = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            return version;
        } catch (PackageManager.NameNotFoundException var3) {
            var3.printStackTrace();
        }
        return version;
    }


    public interface OnUpDateClickListener {
        void onCancel();

        void onNew(String versionCode, String versionID);
    }

    private static OnUpDateClickListener mListener;

    public static void setOnUpDateCancelListener(OnUpDateClickListener listener) {
        mListener = listener;
    }
}
