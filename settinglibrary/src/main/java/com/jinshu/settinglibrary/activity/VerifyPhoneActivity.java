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
import com.jinshu.settinglibrary.entity.UserData;
import com.jinshu.settinglibrary.utils.MasterUtils;
import com.jinshu.settinglibrary.utils.SDKUtils;
import com.jinshu.settinglibrary.utils.SystemUtils;
import com.jinshu.settinglibrary.utils.ToastUtil;
import com.jinshu.settinglibrary.widget.ViewStyle;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Create on 2019/9/25 10:50 by bll
 */


public class VerifyPhoneActivity extends SBaseActivity implements View.OnClickListener {

    private EditText etAuthCode;
    private TextView tvTimer, tvPhone;
    private Button btnGetCode, btnNext;
    private Timer mTimer;
    private MyTimerTask mTimerTask;
    private int leftTime = 60;
    private String phone;
    private String verifyCode;

    @Override
    public int getLayoutId() {
        return R.layout.setting_activity_verify_phone;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        setTitle("手机认证");
        setBackAction();

        tvTimer = findViewById(R.id.tv_timer);
        tvPhone = findViewById(R.id.tv_phone);
        etAuthCode = findViewById(R.id.et_auth_code);
        btnGetCode = findViewById(R.id.btn_get_code);
        btnNext = findViewById(R.id.btn_next);

        btnGetCode.setOnClickListener(this);
        btnNext.setOnClickListener(this);

        ViewStyle.setBtnStyle(btnGetCode);
        ViewStyle.setBtnStyle(btnNext);

        UserData data = SDKUtils.getUser();
        if (data != null) {
            phone = data.getPhone();
            if (phone != null) {
                String str = phone.substring(3, 8);
                String newStr = phone.replace(str, "*****");
                tvPhone.setText("请输入" + newStr + "收到的短信验证码");
            }
        }
        mTimer = new Timer();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_get_code) {
            getVerifyCode();
        } else if (v.getId() == R.id.btn_next) {
            String authCode = etAuthCode.getText().toString().trim();
            if (!TextUtils.equals(authCode, verifyCode)) {
                ToastUtil.showShort("验证码不正确");
                return;
            }
            SystemUtils.jumpActivity(mActivity, BindPhoneActivity.class);
            finish();
        }
    }

    private void getVerifyCode() {
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
