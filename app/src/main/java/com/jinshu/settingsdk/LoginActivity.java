package com.jinshu.settingsdk;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jinshu.settinglibrary.api.SApi;
import com.jinshu.settinglibrary.api.SHostType;
import com.jinshu.settinglibrary.app.SAppConstant;
import com.jinshu.settinglibrary.base.baseapp.SBaseActivity;
import com.jinshu.settinglibrary.base.baseapp.SettingBaseSDK;
import com.jinshu.settinglibrary.base.basebean.SBaseResponse;
import com.jinshu.settinglibrary.base.baserx.SRxHelper;
import com.jinshu.settinglibrary.base.baserx.SRxSchedulers;
import com.jinshu.settinglibrary.base.baserx.SRxSubscriber;
import com.jinshu.settinglibrary.entity.UserData;
import com.jinshu.settinglibrary.utils.MasterUtils;
import com.jinshu.settinglibrary.utils.SPUtils;
import com.jinshu.settinglibrary.utils.StrUtils;
import com.jinshu.settinglibrary.utils.SystemUtils;
import com.jinshu.settinglibrary.utils.ToastUtil;

/**
 * Create on 2019/9/23 10:09 by bll
 */

public class LoginActivity extends SBaseActivity implements View.OnClickListener {

    private EditText ed_phone;
    private EditText ed_pwd;
    private Button btn_login;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        ed_phone = findViewById(R.id.ed_phone_ac_login);
        ed_pwd = findViewById(R.id.ed_pwd_ac_login);
        btn_login = findViewById(R.id.btn_submit_ac_login);

        btn_login.setOnClickListener(this);

        initAccount();
    }

    private void initAccount() {

        String loginName = SPUtils.getSharedStringData(SAppConstant.USER);
        String loginPsw = SPUtils.getSharedStringData(SAppConstant.PASSWORD);
        if (StrUtils.isNotEmpty(loginName)) {
            ed_phone.setText(loginName);
        }
        if (StrUtils.isNotEmpty(loginPsw)) {
            ed_pwd.setText(loginPsw);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_submit_ac_login:
                login();
                break;
        }
    }

    private void login() {
        String phone = ed_phone.getText().toString();
        String pwd = ed_pwd.getText().toString();
        if (TextUtils.isEmpty(phone)) {
            ToastUtil.showShort("请输入手机号");
            return;
        }
        if (TextUtils.isEmpty(pwd)) {
            ToastUtil.showShort("请输入密码");
            return;
        }

        SApi.getDefault(SHostType.BASE_URL)
                .login(phone, pwd, MasterUtils.addMasterInfo())
                .compose(SRxSchedulers.<SBaseResponse<UserData>>io_main())
                .compose(SRxHelper.<UserData>handleResult())
                .subscribe(new SRxSubscriber<UserData>(this, "登录中...", true) {

                    @Override
                    protected void onSuccess(UserData entity) {
                        SettingBaseSDK.getInstance().setUserEntity(entity);
                        SPUtils.setSharedStringData(SAppConstant.USER, ed_phone.getText().toString());
                        SPUtils.setSharedStringData(SAppConstant.PASSWORD, ed_pwd.getText().toString());
                        SystemUtils.jumpActivity(LoginActivity.this, MainActivity.class);
                        finish();
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }
}
