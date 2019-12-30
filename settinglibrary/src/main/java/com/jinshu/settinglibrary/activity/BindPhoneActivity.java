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
 * Create on 2019/9/25 10:50 by bll
 */


public class BindPhoneActivity extends SBaseActivity implements View.OnClickListener {

    private EditText etPhone, etAuthCode;
    private TextView tvTimer;
    private Button btnGetCode, btnSubmit;
    private Timer mTimer;
    private MyTimerTask mTimerTask;
    private int leftTime = 60;
    private String phone;
    private String verifyCode;

    @Override
    public int getLayoutId() {
        return R.layout.setting_activity_bind_phone;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        setTitle("手机绑定");
        setBackAction();

        tvTimer = findViewById(R.id.tv_timer);
        etPhone = findViewById(R.id.et_phone);
        etAuthCode = findViewById(R.id.et_auth_code);
        btnGetCode = findViewById(R.id.btn_get_code);
        btnSubmit = findViewById(R.id.btn_submit);

        btnGetCode.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);

        ViewStyle.setBtnStyle(btnGetCode);
        ViewStyle.setBtnStyle(btnSubmit);

        mTimer = new Timer();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_get_code) {
            getVerifyCode();
        } else if (v.getId() == R.id.btn_submit) {
            String authCode = etAuthCode.getText().toString().trim();
            if (!TextUtils.equals(authCode, verifyCode)) {
                ToastUtil.showShort("验证码不正确");
                return;
            }
            SApi.getDefault(SHostType.BASE_URL)
                    .memberBandingPhone(MasterUtils.addSessionID(), phone, authCode)
                    .compose(SRxSchedulers.<SBaseResponse>io_main())
                    .subscribe(new SRxSubscriber<SBaseResponse>(mContext) {
                        @Override
                        protected void onSuccess(SBaseResponse baseResponse) {
                            if (baseResponse.header.code == 0) {
                                ToastUtil.showShort("绑定成功");
                                finish();
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
    }

    private void getVerifyCode() {
        phone = etPhone.getText().toString().trim();
        if (StrUtils.isEmpty(phone)) {
            ToastUtil.showShort("请输入手机号");
            return;
        }
        startTimer();
        SApi.getDefault(SHostType.BASE_URL)
                .sendSMSVerifyCode(phone, "3", MasterUtils.addMasterInfo())
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
        btnGetCode.setVisibility(View.GONE);
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
                        btnGetCode.setVisibility(View.VISIBLE);
                        tvTimer.setVisibility(View.GONE);
                        btnGetCode.setText("重新获取");
                        leftTime = 60;
                    }
                }
            });
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mTimer.cancel();
    }
}
