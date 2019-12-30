package com.jinshu.settinglibrary.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.content.FileProvider;

import java.io.File;
import java.io.IOException;

/**
 * Create on 2019/9/10 15:06 by bll
 */


public class LibraryFileUtils {

    public static File getFile(String destFileName) throws IOException {
        File dirFile = new File(getDestFileDir());
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        File file = new File(dirFile, destFileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    /**
     * 目标文件存储的文件夹路径,存放在sd卡下面，不会随应用卸载而删除
     */
    public static String getDestFileDir() {
        if (checkSDcard()) {
            return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath()
                    + File.separator + "M_DEFAULT_DIR";
        }

        return "";
    }

    /**
     * 检测SD卡是否存在
     */
    public static boolean checkSDcard() {
        return Environment.MEDIA_MOUNTED.equals(Environment
                .getExternalStorageState());
    }

    /**
     * 安装apk
     *
     * @param context
     * @param file
     */
    public static void installApk(Context context, File file) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        setIntentDataAndType(context, intent, "application/vnd.android.package-archive",
                file, true);
        context.startActivity(intent);
    }


    /**
     * 获取File Uri from 安卓7及以上版本
     *
     * @param context
     * @param file
     * @return
     */
    public static Uri getUriForFile24(Context context, File file) {
        Uri fileUri = FileProvider.getUriForFile(context,
                context.getApplicationContext().getPackageName() + ".provider", file);
        return fileUri;
    }

    /**
     * 用户安装apk场景
     *
     * @param context
     * @param intent
     * @param type
     * @param file
     * @param writeAble
     */
    public static void setIntentDataAndType(Context context,
                                            Intent intent,
                                            String type,
                                            File file,
                                            boolean writeAble) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.setDataAndType(getUriForFile24(context, file), type);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            if (writeAble) {
                intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            }
        } else {
            intent.setDataAndType(Uri.fromFile(file), type);
        }
    }

}
