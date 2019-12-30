package com.jinshu.settinglibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.api.SApi;
import com.jinshu.settinglibrary.api.SHostType;
import com.jinshu.settinglibrary.base.baseapp.SBaseActivity;
import com.jinshu.settinglibrary.base.basebean.SBaseResponse;
import com.jinshu.settinglibrary.base.baserx.SRxSchedulers;
import com.jinshu.settinglibrary.base.baserx.SRxSubscriber;
import com.jinshu.settinglibrary.utils.MasterUtils;
import com.jinshu.settinglibrary.utils.StrUtils;
import com.jinshu.settinglibrary.utils.ToastUtil;
import com.jinshu.settinglibrary.view.PasswordView;
import com.jinshu.settinglibrary.widget.ViewStyle;

/**
 * Create on 2019/9/25 16:49 by bll
 */


public class ModifyTradePswActivity extends SBaseActivity implements View.OnClickListener{

    private PasswordView mOldPswView, mNewPswView;
    private Button btnConfirm;
    private String mOldPassword, mNewPassword;

    @Override
    public int getLayoutId() {
        return R.layout.setting_activity_modify_trade_psw;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        setTitle("修改支付密码");
        setBackAction();

        mOldPswView = findViewById(R.id.old_password_view);
        mNewPswView = findViewById(R.id.new_password_view);
        btnConfirm = findViewById(R.id.btn_confirm);

        ViewStyle.setBtnStyle(btnConfirm);

        mOldPswView.setPasswordListener(new PasswordView.PasswordListener() {
            @Override
            public void passwordChange(String changeText) {
            }

            @Override
            public void passwordComplete(String password) {
                mOldPassword = password;
            }

            @Override
            public void keyEnterPress(String password, boolean isComplete) {
            }
        });

        mNewPswView.setPasswordListener(new PasswordView.PasswordListener() {
            @Override
            public void passwordChange(String changeText) {
            }

            @Override
            public void passwordComplete(String password) {
                mNewPassword = password;
            }

            @Override
            public void keyEnterPress(String password, boolean isComplete) {
            }
        });
        btnConfirm.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (StrUtils.isEmpty(mOldPassword)) {
            ToastUtil.showShort("请输入原支付密码");
            return;
        }
        if (StrUtils.isEmpty(mNewPassword)) {
            ToastUtil.showShort("请输入新的支付密码");
            return;
        }
        setTradePassword();
    }

    /**
     * 设置交易密码
     */
    private void setTradePassword() {
        SApi.getDefault(SHostType.BASE_URL)
                .setTradePassword(MasterUtils.addSessionID(), mOldPassword, mNewPassword)
                .compose(SRxSchedulers.<SBaseResponse>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse>(mContext) {
                    @Override
                    protected void onSuccess(SBaseResponse baseResponse) {
                        if (baseResponse.header.code == 0) {
                            ToastUtil.showShort("修改成功");
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
