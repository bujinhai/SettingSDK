package com.jinshu.settinglibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.base.baseapp.SBaseActivity;
import com.jinshu.settinglibrary.utils.SystemUtils;

/**
 * Create on 2019/10/22 20:33 by bll
 */


public class AccountSecurityActivity extends SBaseActivity implements View.OnClickListener{

    private RelativeLayout rl_authentication, rl_bind_phone, rl_modify_login_psw;

    @Override
    public int getLayoutId() {
        return R.layout.setting_activity_account_security;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        setTitle("账户与安全");
        setBackAction();
        rl_authentication = findViewById(R.id.rl_authentication);
        rl_bind_phone = findViewById(R.id.rl_bind_phone);
        rl_modify_login_psw = findViewById(R.id.rl_modify_login_psw);

        rl_authentication.setOnClickListener(this);
        rl_bind_phone.setOnClickListener(this);
        rl_modify_login_psw.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.rl_authentication){
            SystemUtils.jumpActivity(this, NameAuthenticationActivity.class);
        } else if (v.getId() == R.id.rl_bind_phone) {
            SystemUtils.jumpActivity(this, VerifyPhoneActivity.class);
        } else if (v.getId() == R.id.rl_modify_login_psw) {
            SystemUtils.jumpActivity(this, ModifyPswActivity.class);
        }
    }
}
