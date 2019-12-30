package com.jinshu.settinglibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.api.SApi;
import com.jinshu.settinglibrary.api.SHostType;
import com.jinshu.settinglibrary.app.SAppConstant;
import com.jinshu.settinglibrary.base.baseapp.SBaseActivity;
import com.jinshu.settinglibrary.base.basebean.SBaseResponse;
import com.jinshu.settinglibrary.base.baserx.SRxSchedulers;
import com.jinshu.settinglibrary.base.baserx.SRxSubscriber;
import com.jinshu.settinglibrary.entity.SmsEntity;
import com.jinshu.settinglibrary.entity.UserData;
import com.jinshu.settinglibrary.utils.MasterUtils;
import com.jinshu.settinglibrary.utils.SDKUtils;
import com.jinshu.settinglibrary.utils.StrUtils;
import com.jinshu.settinglibrary.utils.SystemUtils;
import com.jinshu.settinglibrary.utils.ToastUtil;
import com.jinshu.settinglibrary.widget.ViewStyle;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Create on 2019/9/25 16:49 by bll
 */


public class ForgetTradePswActivity extends SBaseActivity {

    private RelativeLayout rlVerify;
    private TextView tvVerify, tvTimer, tvSend;
    private String phone;
    private Button btnConfirm;
    private EditText etCode;
    private LinearLayout llVerify;
    private String verifyCode;
    private int leftTime = 60;
    private Timer mTimer;
    private boolean isClick;
    private MyTimerTask mTimerTask;

    @Override
    public int getLayoutId() {
        return R.layout.setting_activity_forget_trade_psw;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        setTitle("手机号验证");
        setBackAction();

        rlVerify = findViewById(R.id.rl_verify_phone);
        tvVerify = findViewById(R.id.tv_verify_phone);
        etCode = findViewById(R.id.et_code);
        btnConfirm = findViewById(R.id.btn_confirm);
        llVerify = findViewById(R.id.ll_verify);
        tvTimer = findViewById(R.id.tv_timer);
        tvSend = findViewById(R.id.tv_send);

        ViewStyle.setBtnStyle(btnConfirm);

        mTimer = new Timer();
        setListener();
    }

    @Override
    protected void initData(Intent intent) {
        UserData entity = SDKUtils.getUser();
        if (entity != null) {
            phone = entity.getPhone();
        }
        tvVerify.setText("[" + phone + "]验证绑定手机信息");
    }

    private void setListener() {
        rlVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isClick) {
                    if (StrUtils.isEmpty(phone)) {
                        ToastUtil.showShort("手机号不正确");
                        return;
                    }
                    isClick = true;
                    getAuthCode();
                    llVerify.setVisibility(View.VISIBLE);
                } else {
                    ToastUtil.showShort("正在获取验证码...");
                }
            }
        });

        tvSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAuthCode();
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = etCode.getText().toString().trim();
                if (!TextUtils.equals(code, verifyCode)) {
                    ToastUtil.showShort("验证码不正确");
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString(SAppConstant.PHONE, phone);
                bundle.putString(SAppConstant.AUTH_CODE, code);
                SystemUtils.jumpActivity(mActivity, ResetTradePswActivity.class, bundle);
            }
        });
    }

    /**
     * 获取验证码
     */
    private void getAuthCode() {
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
        tvSend.setVisibility(View.GONE);
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
                        tvSend.setVisibility(View.VISIBLE);
                        tvTimer.setVisibility(View.GONE);
                        tvSend.setText("重新获取");
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
