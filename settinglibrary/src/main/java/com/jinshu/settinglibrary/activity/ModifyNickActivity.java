package com.jinshu.settinglibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.api.SApi;
import com.jinshu.settinglibrary.api.SHostType;
import com.jinshu.settinglibrary.app.SAppConstant;
import com.jinshu.settinglibrary.base.baseapp.SBaseActivity;
import com.jinshu.settinglibrary.base.basebean.SBaseResponse;
import com.jinshu.settinglibrary.base.baserx.SRxSchedulers;
import com.jinshu.settinglibrary.base.baserx.SRxSubscriber;
import com.jinshu.settinglibrary.entity.MemberEntity;
import com.jinshu.settinglibrary.utils.MasterUtils;
import com.jinshu.settinglibrary.utils.SDKUtils;
import com.jinshu.settinglibrary.utils.StrUtils;
import com.jinshu.settinglibrary.utils.ToastUtil;

/**
 * Create on 2019/10/23 19:28 by bll
 */


public class ModifyNickActivity extends SBaseActivity {

    private EditText etNickName;
    private ImageView ivDelete;

    @Override
    public int getLayoutId() {
        return R.layout.setting_activity_modify_nick;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        setTitle("修改昵称");
        setBackAction();
        setRightTitle("确定");
        etNickName = findViewById(R.id.et_nick_name);
        ivDelete = findViewById(R.id.iv_delete_nick);

        setListener();
    }

    @Override
    protected void initData(Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            etNickName.setText(bundle.getString(SAppConstant.NICK_NAME));
        }
    }

    private void setListener() {
        ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNickName.setText("");
            }
        });

        setRightTitleListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateMyMemberShortName();
            }
        });
    }

    private void updateMyMemberShortName() {
        final String nickName = etNickName.getText().toString();
        if (StrUtils.isEmpty(nickName)) {
            ToastUtil.showShort("请输入昵称");
            return;
        }

        SApi.getDefault(SHostType.BASE_URL)
                .updateMyMemberShortname(MasterUtils.addSessionID(), nickName)
                .compose(SRxSchedulers.<SBaseResponse>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse>(mContext) {
                    @Override
                    protected void onSuccess(SBaseResponse response) {
                        if (response.header.code != 0) {
                            ToastUtil.showShort(response.header.msg);
                            return;
                        }
                        MemberEntity entity = SDKUtils.getMember();
                        entity.setShortName(nickName);
                        SDKUtils.saveMember(entity);
                        mRxManager.post(SAppConstant.UPDATE_USER, "");
                        finish();
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }
}
