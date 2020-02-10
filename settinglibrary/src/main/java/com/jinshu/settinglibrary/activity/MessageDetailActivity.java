package com.jinshu.settinglibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.api.SApi;
import com.jinshu.settinglibrary.api.SHostType;
import com.jinshu.settinglibrary.app.SAppConstant;
import com.jinshu.settinglibrary.base.baseapp.SBaseActivity;
import com.jinshu.settinglibrary.base.baserx.SRxHelper;
import com.jinshu.settinglibrary.base.baserx.SRxSchedulers;
import com.jinshu.settinglibrary.base.baserx.SRxSubscriber;
import com.jinshu.settinglibrary.entity.MessageDetailEntity;
import com.jinshu.settinglibrary.utils.ImageLoaderUtils;
import com.jinshu.settinglibrary.utils.MasterUtils;
import com.jinshu.settinglibrary.utils.ToastUtil;

/**
 * Created on 2020-02-10 by bll
 */

public class MessageDetailActivity extends SBaseActivity {

    private TextView tvName, tvDate, tvContent;
    private ImageView ivAvatar;

    private String messageID;

    @Override
    public int getLayoutId() {
        return R.layout.setting_activity_message_detail;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        tvName = findViewById(R.id.tv_name);
        tvDate = findViewById(R.id.tv_date);
        tvContent = findViewById(R.id.tv_content);
        ivAvatar = findViewById(R.id.iv_avatar);
    }

    @Override
    protected void initData(Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            messageID = bundle.getString(SAppConstant.MESSAGE_ID);
        }
        getMessageDetail();
    }

    private void getMessageDetail() {
        SApi.getDefault(SHostType.BASE_URL)
                .getMessageDetail(MasterUtils.addSessionID(), messageID)
                .compose(SRxHelper.<MessageDetailEntity>handleResult())
                .compose(SRxSchedulers.<MessageDetailEntity>io_main())
                .subscribe(new SRxSubscriber<MessageDetailEntity>(mContext, true) {
                    @Override
                    protected void onSuccess(MessageDetailEntity messageDetailEntity) {
                        if (messageDetailEntity.getData() == null) {
                            return;
                        }
                        MessageDetailEntity.DataInfo info = messageDetailEntity.getData();
                        tvName.setText(info.getSenderMemberName());
                        tvDate.setText(info.getSendDateStr());
                        tvContent.setText(info.getDescription());
                        ImageLoaderUtils.display(mContext, ivAvatar, info.getSenderMemberAvatar());
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }
}
