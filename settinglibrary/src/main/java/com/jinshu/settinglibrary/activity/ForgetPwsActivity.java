package com.jinshu.settinglibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
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
 * Create on 2019/9/24 11:21 by bll
 * 忘记登录密码
 */


public class ForgetPwsActivity extends SBaseActivity implements View.OnClickListener {

    private EditText etAuthCode, etPsw, etRePsw;
    private TextView tvPhone, tvTimer;
    private Button btnConfirm,btnSendCode;
    private int leftTime = 120;
    private Timer mTimer;
    private String verifyCode;
    private MyTimerTask mTimerTask;
    private String phone;

    @Override
    public int getLayoutId() {
        return R.layout.setting_activity_forget_pws;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        setTitle("手机短线找回密码");
        setBackAction();
        tvPhone = findViewById(R.id.tv_phone);
        etAuthCode = findViewById(R.id.et_auth_code);
        etPsw = findViewById(R.id.et_new_psw);
        etRePsw = findViewById(R.id.et_renew_psw);
        btnSendCode = findViewById(R.id.btn_send_code);
        tvTimer = findViewById(R.id.tv_timer);
        btnConfirm = findViewById(R.id.btn_confirm);

        mTimer = new Timer();

        etAuthCode.setFocusable(false);
        etAuthCode.setFocusableInTouchMode(false);
        etPsw.setFocusable(false);
        etPsw.setFocusableInTouchMode(false);
        etRePsw.setFocusable(false);
        etRePsw.setFocusableInTouchMode(false);

        btnConfirm.setEnabled(false);
        btnConfirm.setBackgroundResource(R.drawable.setting_bg_enable_btn);

        UserData data = SDKUtils.getUser();
        if (data != null) {
            phone = data.getPhone();
            if (phone != null) {
                String str = phone.substring(3, 8);
                String newStr = phone.replace(str, "*****");
                tvPhone.setText("请输入" + newStr + "收到的短信验证码");
            }
        }

        ViewStyle.setBtnStyle(btnSendCode);
        ViewStyle.setBtnStyle(btnConfirm);

        setListener();
    }

    private void setListener() {
        btnSendCode.setOnClickListener(this);
        btnConfirm.setOnClickListener(this);

        etAuthCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                etPsw.setFocusable(true);
                etPsw.setFocusableInTouchMode(true);
                etRePsw.setFocusable(true);
                etRePsw.setFocusableInTouchMode(true);

            }
        });

        etAuthCode.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                SystemUtils.openKeybord(etAuthCode, mActivity);
            }
        });

        etPsw.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean focus) {
                SystemUtils.openKeybord(etPsw, mActivity);
            }
        });

        etRePsw.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean focus) {
                SystemUtils.openKeybord(etRePsw, mActivity);
            }
        });

        etRePsw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                btnConfirm.setEnabled(true);
                btnConfirm.setBackgroundResource(R.drawable.setting_bg_normal_btn);
            }
        });
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
        SApi.getDefault(SHostType.BASE_URL)
                .sendSMSVerifyCode(phone, "2", MasterUtils.addMasterInfo())
                .compose(SRxSchedulers.<SBaseResponse<SmsEntity>>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse<SmsEntity>>(mContext, false) {
                    @Override
                    protected void onSuccess(SBaseResponse<SmsEntity> baseResponse) {
                        if (baseResponse.header.code == 0) {
                            if (baseResponse.body != null) {
                                verifyCode = baseResponse.body.getAuthCode();
                                startTimer();
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
        String authCode = etAuthCode.getText().toString().trim();
        String password = etPsw.getText().toString().trim();
        String rePsw = etRePsw.getText().toString().trim();

        if (!TextUtils.equals(authCode, verifyCode)) {
            ToastUtil.showShort("验证码不正确");
            return;
        }
        if (password.length() < 6) {
            ToastUtil.showShort("密码应为6～20位的数字或者字母");
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
