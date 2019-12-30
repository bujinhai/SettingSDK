package com.jinshu.settinglibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.api.SApi;
import com.jinshu.settinglibrary.api.SHostType;
import com.jinshu.settinglibrary.base.baseapp.SBaseActivity;
import com.jinshu.settinglibrary.base.baserx.SRxHelper;
import com.jinshu.settinglibrary.base.baserx.SRxSchedulers;
import com.jinshu.settinglibrary.base.baserx.SRxSubscriber;
import com.jinshu.settinglibrary.entity.CertificateStatusEntity;
import com.jinshu.settinglibrary.utils.ImageLoaderUtils;
import com.jinshu.settinglibrary.utils.MasterUtils;
import com.jinshu.settinglibrary.utils.ToastUtil;
import com.jinshu.settinglibrary.widget.ViewStyle;

/**
 * Create on 2019/10/22 17:38 by bll
 */


public class AuthenticationDetailActivity extends SBaseActivity {

    private TextView tvName, tvIDcard;
    private ImageView ivFront, ivBack;
    private Button btnConfirm;

    @Override
    public int getLayoutId() {
        return R.layout.setting_activity_authentication_detail;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        setTitle("实名信息");
        setBackAction();
        tvName = findViewById(R.id.tv_user_name);
        tvIDcard = findViewById(R.id.tv_id_num);
        ivFront = findViewById(R.id.iv_id_card_front);
        ivBack = findViewById(R.id.iv_id_card_back);
        btnConfirm = findViewById(R.id.btn_confirm);

        ViewStyle.setBtnStyle(btnConfirm);

        setListener();
    }

    @Override
    protected void initData(Intent intent) {
        getMemberRealName();
    }

    private void getMemberRealName() {
        SApi.getDefault(SHostType.BASE_URL)
                .queryMemberRealNameStatus(MasterUtils.addSessionID())
                .compose(SRxHelper.<CertificateStatusEntity>handleResult())
                .compose(SRxSchedulers.<CertificateStatusEntity>io_main())
                .subscribe(new SRxSubscriber<CertificateStatusEntity>(mContext) {
                    @Override
                    protected void onSuccess(CertificateStatusEntity statusEntity) {
                        if (statusEntity != null) {
                            tvName.setText(statusEntity.getData().getName());
                            tvIDcard.setText(statusEntity.getData().getCardCode());
                            ImageLoaderUtils.display(mContext, ivFront, statusEntity.getData().getFaceImage());
                            ImageLoaderUtils.display(mContext, ivBack, statusEntity.getData().getBackImage());
                        }
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }

    private void setListener() {
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
