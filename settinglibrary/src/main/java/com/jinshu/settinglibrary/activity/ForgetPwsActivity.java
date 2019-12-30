package com.jinshu.settinglibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.api.SApi;
import com.jinshu.settinglibrary.api.SHostType;
import com.jinshu.settinglibrary.base.baseapp.SBaseActivity;
import com.jinshu.settinglibrary.base.basebean.SBaseResponse;
import com.jinshu.settinglibrary.base.baserx.SRxSchedulers;
import com.jinshu.settinglibrary.base.baserx.SRxSubscriber;
import com.jinshu.settinglibrary.entity.SmsEntity;
import com.jinshu.settinglibrary.utils.MasterUtils;
import com.jinshu.settinglibrary.utils.StrUtils;
import com.jinshu.settinglibrary.utils.ToastUtil;
import com.jinshu.settinglibrary.widget.ViewStyle;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Create on 2019/9/24 11:21 by bll
 * 忘记登录密码
 */


public class ForgetPwsActivity extends SBaseActivity implements View.OnClickListener {

    private EditText etPhone, etAuthCode, etPsw, etRePsw;
    private TextView tvTimer;
    private Button btnConfirm,btnSendCode;
    private int leftTime = 60;
    private Timer mTimer;
    private String verifyCode;
    private MyTimerTask mTimerTask;

    @Override
    public int getLayoutId() {
        return R.layout.setting_activity_forget_pws;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        setTitle("忘记密码");
        setBackAction();
        etPhone = findViewById(R.id.et_phone);
        etAuthCode = findViewById(R.id.et_auth_code);
        etPsw = findViewById(R.id.et_new_psw);
        etRePsw = findViewById(R.id.et_renew_psw);
        btnSendCode = findViewById(R.id.btn_send_code);
        tvTimer = findViewById(R.id.tv_timer);
        btnConfirm = findViewById(R.id.btn_confirm);

        mTimer = new Timer();

        btnSendCode.setOnClickListener(this);
        btnConfirm.setOnClickListener(this);

        ViewStyle.setBtnStyle(btnSendCode);
        ViewStyle.setBtnStyle(btnConfirm);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_send_code) {
            getAuthCode();
        } else if (v.getId() == R.id.btn_confirm) {
            verify();
        }
    }

    /**
     * 获取验证码
     */
    private void getAuthCode() {
        String phone = etPhone.getText().toString().trim();
        if (StrUtils.isEmpty(phone)) {
            ToastUtil.showShort("请输入手机号");
            return;
        }
        startTimer();
        SApi.getDefault(SHostType.BASE_URL)
                .sendSMSVerifyCode(phone, "2", MasterUtils.addMasterInfo())
                .compose(SRxSchedulers.<SBaseResponse<SmsEntity>>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse<SmsEntity>>(mContext, false) {
                    @Override
                    protected void onSuccess(SBaseResponse<SmsEntity> baseResponse) {
                        if (baseResponse.header.code == 0) {
                            if (baseResponse.body != null) {
                                verifyCode = baseResponse.body.getAuthCode();
                            }
                        } else {
                            ToastUtil.showShort(baseResponse.header.msg);
                        }
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }

    private void startTimer() {
        tvTimer.setVisibility(View.VISIBLE);
        btnSendCode.setVisibility(View.GONE);
        tvTimer.setText(leftTime + "s");

        if (mTimerTask != null) {
            mTimerTask.cancel();
        }

        mTimerTask = new MyTimerTask();
        mTimer.schedule(mTimerTask, 0, 1000);
    }

    class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    --leftTime;
                    if (leftTime > 0) {
                        tvTimer.setText(leftTime + "s");
                    } else {
                        btnSendCode.setVisibility(View.VISIBLE);
                        tvTimer.setVisibility(View.GONE);
                        leftTime = 60;
                    }
                }
            });
        }
    }

    private void verify() {
        String phone = etPhone.getText().toString().trim();
        String authCode = etAuthCode.getText().toString().trim();
        String password = etPsw.getText().toString().trim();
        String rePsw = etRePsw.getText().toString().trim();

        if (!TextUtils.equals(authCode, verifyCode)) {
            ToastUtil.showShort("验证码不正确");
            return;
        }
        if (StrUtils.isEmpty(password)) {
            ToastUtil.showShort("请输入密码");
            return;
        }
        if (!TextUtils.equals(password, rePsw)) {
            ToastUtil.showShort("密码不一致");
            return;
        }
        SApi.getDefault(SHostType.BASE_URL)
                .resetMemberPassword(MasterUtils.addSessionID(), MasterUtils.getSiteID(), phone, authCode, password)
                .compose(SRxSchedulers.<SBaseResponse>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse>(mContext) {
                    @Override
                    protected void onSuccess(SBaseResponse baseResponse) {
                        if (baseResponse.header.code == 0) {
                            ToastUtil.showShort("找回密码成功");
                            finish();
                        }
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mTimer != null) {
            mTimer.cancel();
        }
    }
}
