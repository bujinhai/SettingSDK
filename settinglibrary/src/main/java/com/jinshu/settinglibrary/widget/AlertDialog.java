package com.jinshu.settinglibrary.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.jinshu.settinglibrary.R;


/**
 * Create on 2019/9/10 15:21 by bll
 */


public class AlertDialog extends Dialog implements View.OnClickListener {

    private String title;
    private String message;
    private String describe;
    private String strPositive;
    private String strNegative;
    private OnDialogButtonClickListener listener;
    private boolean cancelable = false;
    private TextView tvTitle;
    private TextView tvMessage;
    private TextView tvDescribe;
    private TextView btnPositive;
    private TextView btnNegative;
    private int isNoLogin;

    /**
     * @param context
     * @param title
     * @param message
     * @param strPositive "确定"类按钮文本
     * @param strNegative "取消"类按钮文本
     * @param listener
     */
    public AlertDialog(Context context, String title, String message, String describe,
                       String strPositive, String strNegative, int isNoLogin, OnDialogButtonClickListener listener) {
        super(context, R.style.MyDialog);

        this.title = title;
        this.message = message;
        this.describe = describe;
        this.strPositive = strPositive;
        this.strNegative = strNegative;
        this.isNoLogin = isNoLogin;
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_file_dialog_custom);
        //alertDialog是否可以点击外围消失
        setCanceledOnTouchOutside(cancelable);
        setCancelable(cancelable);

        tvTitle = findViewById(R.id.tv_title);
        tvMessage = findViewById(R.id.tv_message);
        tvDescribe = findViewById(R.id.tv_describe);
        btnPositive = findViewById(R.id.btn_dialog_positive);
        btnNegative = findViewById(R.id.btn_dialog_negative);

        tvTitle.setVisibility(TextUtils.isEmpty(title) ? View.GONE : View.VISIBLE);
        tvTitle.setText(title);

        if (!TextUtils.isEmpty(strPositive)) {
            btnPositive.setText(strPositive);
        }
        btnPositive.setOnClickListener(this);

        //是否强制更新
        if (isNoLogin == 1) {//强制更新
            btnNegative.setVisibility(View.GONE);
        }

        if (!TextUtils.isEmpty(strNegative)) {
            btnNegative.setText(strNegative);
        }

        btnNegative.setOnClickListener(this);

        tvMessage.setText(message);
        tvDescribe.setText(describe);

        final WindowManager.LayoutParams params = this.getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        this.getWindow().setAttributes(params);
    }

    public void setStrPositive(String str) {
        btnPositive.setText(str);
        btnNegative.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_dialog_positive) {
            listener.onDialogButtonClick(true);
        } else if (v.getId() == R.id.btn_dialog_negative) {
            listener.onDialogButtonClick(false);
            dismiss();
        }
    }

    /**
     * 自定义Dialog监听器
     */
    public interface OnDialogButtonClickListener {

        /**
         * 点击按钮事件的回调方法
         *
         * @param isPositive
         */
        void onDialogButtonClick(boolean isPositive);
    }
}
