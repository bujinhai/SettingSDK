package com.jinshu.settinglibrary.widget;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.widget.DatePicker;

import com.jinshu.settinglibrary.utils.TimeUtil;

/**
 * Create on 2019/10/24 15:03 by bll
 */


public class DatePickerManage {

    private static DatePickerDialog mDatePickerDialog;//日期选择器


    /**
     * 显示日期选择器, 默认白色背景
     */
    public static void showDatePickerDialog(Context context, String title, int year, int month, int day, OnDatePickerListener onDateTimePickerListener) {
        showDatePickerDialog(context, AlertDialog.THEME_HOLO_LIGHT, title, year, month, day, onDateTimePickerListener);
    }


    /**
     * 显示日期选择器
     */
    private static void showDatePickerDialog(Context context, int themeId, String title, int year, int month, int day,
                                             final OnDatePickerListener onDateTimePickerListener) {
        mDatePickerDialog = new DatePickerDialog(context, themeId, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;//月份加一
                if (onDateTimePickerListener != null) {
                    onDateTimePickerListener.onConfirm(year, month, dayOfMonth);
                }
                mDatePickerDialog.dismiss();
            }

        }, year, month - 1, day);//月份减一

        mDatePickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                if (onDateTimePickerListener != null) {
                    onDateTimePickerListener.onCancel();
                }
                mDatePickerDialog.dismiss();
            }
        });

        if (!TextUtils.isEmpty(title)) {
            mDatePickerDialog.setTitle(title);
        }
        //设置起始日期和结束日期
        DatePicker datePicker = mDatePickerDialog.getDatePicker();
        datePicker.setMinDate(TimeUtil.getDatelongMills(TimeUtil.dateFormatYMD, "1964-12-12"));//起始日期1964年12月12日
        datePicker.setMaxDate(TimeUtil.getDatelongMills(TimeUtil.dateFormatYMD, "2000-12-12"));//结束日期2000年12月12日

        mDatePickerDialog.show();
    }

    /**
     * 日期选择器监听
     */
    public interface OnDatePickerListener {
        void onConfirm(int year, int month, int dayOfMonth);

        void onCancel();
    }
}
