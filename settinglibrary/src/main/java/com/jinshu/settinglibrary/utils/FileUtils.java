package com.jinshu.settinglibrary.utils;

import android.os.Environment;

import java.io.File;
import java.io.IOException;

/**
 * Create on 2019/9/10 15:06 by bll
 */


public class FileUtils {

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
     * 检测SD卡是否存在
     */
    public static boolean checkSDcard() {
        return Environment.MEDIA_MOUNTED.equals(Environment
                .getExternalStorageState());
    }
}
