package com.jinshu.settinglibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.api.SApi;
import com.jinshu.settinglibrary.api.SHostType;
import com.jinshu.settinglibrary.app.SAppConstant;
import com.jinshu.settinglibrary.base.baseapp.SBaseActivity;
import com.jinshu.settinglibrary.base.basebean.SBaseResponse;
import com.jinshu.settinglibrary.base.baserx.SRxSchedulers;
import com.jinshu.settinglibrary.base.baserx.SRxSubscriber;
import com.jinshu.settinglibrary.utils.MasterUtils;
import com.jinshu.settinglibrary.utils.ToastUtil;
import com.jinshu.settinglibrary.view.PasswordView;
import com.jinshu.settinglibrary.widget.ViewStyle;

/**
 * Create on 2019/9/26 09:41 by bll
 */


public class ResetTradePswActivity extends SBaseActivity implements PasswordView.PasswordListener, View.OnClickListener {

    private PasswordView mPswView;
    private Button btnConfirm;
    private String mPassword;
    private String phone;
    private String authCode;

    @Override
    public int getLayoutId() {
        return R.layout.setting_activity_set_trade_psw;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        setTitle("找回支付密码");
        setBackAction();

        mPswView = findViewById(R.id.password_view);
        btnConfirm = findViewById(R.id.btn_confirm);

        mPswView.setPasswordListener(this);
        btnConfirm.setOnClickListener(this);

        ViewStyle.setBtnStyle(btnConfirm);
    }

    @Override
    protected void initData(Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle == null) {
            return;
        }
        phone = bundle.getString(SAppConstant.PHONE);
        authCode = bundle.getString(SAppConstant.AUTH_CODE);
    }

    @Override
    public void onClick(View v) {
        forgetTradePassword();
    }

    @Override
    public void passwordChange(String changeText) {

    }

    @Override
    public void passwordComplete(String password) {
        mPassword = password;
    }

    @Override
    public void keyEnterPress(String password, boolean isComplete) {

    }

    /**
     * 设置交易密码
     */
    private void forgetTradePassword() {
        SApi.getDefault(SHostType.BASE_URL)
                .forgetTradePassword(MasterUtils.addSessionID(), mPassword, phone, authCode)
                .compose(SRxSchedulers.<SBaseResponse>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse>(mContext) {
                    @Override
                    protected void onSuccess(SBaseResponse baseResponse) {
                        if (baseResponse.header.code == 0) {
                            ToastUtil.showShort("设置成功");
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
