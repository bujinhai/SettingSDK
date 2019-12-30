package com.jinshu.settinglibrary.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.api.SApi;
import com.jinshu.settinglibrary.api.SHostType;
import com.jinshu.settinglibrary.app.SAppConstant;
import com.jinshu.settinglibrary.base.baseapp.SBaseActivity;
import com.jinshu.settinglibrary.base.baserx.SRxHelper;
import com.jinshu.settinglibrary.base.baserx.SRxSchedulers;
import com.jinshu.settinglibrary.base.baserx.SRxSubscriber;
import com.jinshu.settinglibrary.entity.Configure;
import com.jinshu.settinglibrary.entity.VersionData;
import com.jinshu.settinglibrary.utils.MasterUtils;
import com.jinshu.settinglibrary.utils.SystemUtils;
import com.jinshu.settinglibrary.utils.ToastUtil;
import com.jinshu.settinglibrary.utils.UpdateUtils;
import com.king.zxing.util.CodeUtils;

/**
 * Create on 2019/9/29 16:12 by bll
 * 关于我们
 */


public class AboutUsActivity extends SBaseActivity implements View.OnClickListener,UpdateUtils.OnUpDateClickListener {

    private ImageView ivLogo, ivCode;
    private Bitmap mBitmap;
    private LinearLayout llChenck, llHelp;
    private String code, version;
    private String navigatorID;
    private TextView tvVersion;

    @Override
    public int getLayoutId() {
        return R.layout.setting_activity_about_us;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        setTitle("关于我们");
        setBackAction();
        ivLogo = findViewById(R.id.iv_logo);
        ivCode = findViewById(R.id.iv_qr_code);
        llChenck = findViewById(R.id.ll_check_version);
        llHelp = findViewById(R.id.ll_help);
        tvVersion = findViewById(R.id.tv_version);

        mBitmap = CodeUtils.createQRCode("http://www.baidu.com", 300, null);
        ivCode.setImageBitmap(mBitmap);

        llChenck.setOnClickListener(this);
        llHelp.setOnClickListener(this);
    }

    @Override
    protected void initData(Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            navigatorID = bundle.getString(SAppConstant.NAVIGATOR_ID);
        }
        version = SystemUtils.getAppVersionName(this);
        checkVersion();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ll_check_version) {
            UpdateUtils.getVersionData(mActivity, MasterUtils.getSiteID());
            UpdateUtils.setOnUpDateCancelListener(AboutUsActivity.this);
        } else if (v.getId() == R.id.ll_help) {
            Bundle bundle = new Bundle();
            bundle.putString(SAppConstant.ARTICLE_TYPE, Configure.HELP.name());
            bundle.putString(SAppConstant.NAVIGATOR_ID, navigatorID);
            SystemUtils.jumpActivity(mActivity, ArticleActivity.class, bundle);
        }
    }

    private void checkVersion() {
        SApi.getDefault(SHostType.BASE_URL)
                .getVersionDetail(MasterUtils.getSiteID())
                .compose(SRxHelper.<VersionData>handleResult())
                .compose(SRxSchedulers.<VersionData>io_main())
                .subscribe(new SRxSubscriber<VersionData>(mContext) {
                    @Override
                    protected void onSuccess(VersionData versionEntity) {
                        if (versionEntity.getData() == null) {
                            return;
                        }
                        code = versionEntity.getData().getCode();
                        if (SystemUtils.getAppVersionName(mContext).equals(code)) {
                            tvVersion.setText("最新版本V" + code);
                        } else {
                            tvVersion.setText("有新版本V" + code);
                        }
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }

    @Override
    public void onCancel() {

    }

    @Override
    public void onNew(String versionCode, String versionID) {
        ToastUtil.showShort("当前已是最新版本");
    }
}
