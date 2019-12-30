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


public class PaymentActivity extends SBaseActivity implements View.OnClickListener {

    private RelativeLayout rl_setting_payment_psw, rl_modify_payment_psw, rl_forget_payment_psw, rl_bank_manage, rl_help;

    @Override
    public int getLayoutId() {
        return R.layout.setting_activity_payment;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        setTitle("支付设置");
        setBackAction();
        rl_setting_payment_psw = findViewById(R.id.rl_setting_payment_psw);
        rl_modify_payment_psw = findViewById(R.id.rl_modify_payment_psw);
        rl_forget_payment_psw = findViewById(R.id.rl_forget_payment_psw);
        rl_bank_manage = findViewById(R.id.rl_bank_manage);
        rl_help = findViewById(R.id.rl_help);

        rl_setting_payment_psw.setOnClickListener(this);
        rl_modify_payment_psw.setOnClickListener(this);
        rl_forget_payment_psw.setOnClickListener(this);
        rl_bank_manage.setOnClickListener(this);
        rl_help.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.rl_setting_payment_psw) {
            SystemUtils.jumpActivity(this, SetTradePswActivity.class);
        } else if (v.getId() == R.id.rl_modify_payment_psw) {
            SystemUtils.jumpActivity(this, ModifyTradePswActivity.class);
        } else if (v.getId() == R.id.rl_forget_payment_psw) {
            SystemUtils.jumpActivity(this, ForgetTradePswActivity.class);
        } else if (v.getId() == R.id.rl_bank_manage) {
            SystemUtils.jumpActivity(this, BankCardListActivity.class);
        } else if (v.getId() == R.id.rl_help) {

        }
    }
}
