package com.jinshu.settinglibrary.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.jinshu.settinglibrary.R;

public final class SystemUtils {


    /**
     * 获取当前应用程序的版本号
     */
    public static String getAppVersionName(Context context) {
        String version = "0";
        try {
            version = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            throw new RuntimeException(SystemUtils.class.getName()
                    + "the application not found");
        }
        return version;
    }

    /**
     * 获取当前应用程序的版本号
     */
    public static int getAppVersionCode(Context context) {
        PackageManager manager = context.getPackageManager();
        PackageInfo packageInfo = null;
        try {
            packageInfo = manager.getPackageInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }

        if (packageInfo != null) {
            return packageInfo.versionCode;
        } else {
            return 1;
        }
    }

    public static void jumpActivity(final Activity context, Class cls) {
        jumpActivity(context, cls, null);
    }

    public static void jumpActivity(final Activity context, Class cls,
                                    Bundle bundle) {
        jumpActivity(context, cls, bundle, false);
    }

    public static void jumpActivity(final Activity context, Class cls,
                                    Bundle bundle, boolean bTop) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }

        intent.setClass(context, cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        context.startActivity(intent);
        context.overridePendingTransition(R.anim.setting_fade_in, R.anim.setting_fade_out);

    }

    public static void jumpActivityForResult(final Activity context, Class cls,
                                             int requestCode) {
        jumpActivityForResult(context, cls, requestCode, null);
    }

    public static void jumpActivityForResult(final Activity context, Class cls,
                                             int requestCode, Bundle bundle) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }

        intent.setClass(context, cls);

        context.startActivityForResult(intent, requestCode);
        context.overridePendingTransition(R.anim.setting_fade_in, R.anim.setting_fade_out);
    }

    /**
     * 判断App是否安装
     *
     * @param packageName 包名
     * @return {@code true}: 已安装<br>{@code false}: 未安装
     */
    public static boolean isInstallApp(Context context, String packageName) {
        return !isSpace(packageName) && getLaunchAppIntent(context, packageName) != null;
    }

    private static boolean isSpace(String s) {
        if (s == null) return true;
        for (int i = 0, len = s.length(); i < len; ++i) {
            if (!Character.isWhitespace(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取打开App的意图
     *
     * @param packageName 包名
     * @return intent
     */
    private static Intent getLaunchAppIntent(Context context, String packageName) {
        return context.getPackageManager().getLaunchIntentForPackage(packageName);
    }


    /**
     * 打卡软键盘
     *
     * @param mEditText 输入框
     */
    public static void openKeybord(EditText mEditText, Activity aty) {
        InputMethodManager imm = (InputMethodManager) aty.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            mEditText.requestFocus();
            imm.showSoftInput(mEditText, InputMethodManager.SHOW_FORCED);
            imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, InputMethodManager.HIDE_IMPLICIT_ONLY);
        }
    }

    /**
     * 隐藏系统键盘
     * <p>
     * <br>
     * <b>警告</b> 必须是确定键盘显示时才能调用
     */
    public static void hideKeyBoard(Activity aty) {
        View v = aty.getCurrentFocus();
        if (v != null) {
            InputMethodManager imm = (InputMethodManager) aty.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null && imm.isActive()) {
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        }
    }
}