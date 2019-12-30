package com.jinshu.settinglibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
import com.jinshu.settinglibrary.widget.ViewStyle;

/**
 * Create on 2019/9/24 16:50 by bll
 * 修改登录密码
 */
public class ModifyPswActivity extends SBaseActivity {

    private EditText et_old_psw, et_new_psw, et_renew_psw;
    private Button btnConfirm;

    @Override
    public int getLayoutId() {
        return R.layout.setting_activity_modify_psw;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        setTitle("修改登录密码");
        setBackAction();
        et_old_psw = findViewById(R.id.et_old_psw);
        et_new_psw = findViewById(R.id.et_new_psw);
        et_renew_psw = findViewById(R.id.et_renew_psw);
        btnConfirm = findViewById(R.id.btn_confirm);

        ViewStyle.setBtnStyle(btnConfirm);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valid();
            }
        });
    }

    private void valid() {
        String oldPsw = et_old_psw.getText().toString().trim();
        String newPsw = et_new_psw.getText().toString().trim();
        String renewPsw = et_renew_psw.getText().toString().trim();
        if (StrUtils.isEmpty(oldPsw)) {
            ToastUtil.showShort("请输入原密码");
            return;
        }
        if (StrUtils.isEmpty(newPsw)) {
            ToastUtil.showShort("请输入新密码");
            return;
        }
        if (StrUtils.isEmpty(renewPsw) || !TextUtils.equals(newPsw, renewPsw)) {
            ToastUtil.showShort("两次密码不一致");
            return;
        }

        SApi.getDefault(SHostType.BASE_URL)
                .setMemberPassword(MasterUtils.addSessionID(), oldPsw, newPsw)
                .compose(SRxSchedulers.<SBaseResponse>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse>(mContext) {
                    @Override
                    protected void onSuccess(SBaseResponse baseResponse) {
                        if (baseResponse.header.code == 0) {
                            ToastUtil.showShort("修改密码成功");
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
