package com.jinshu.settinglibrary.adapter;

import android.content.Context;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.entity.MessageEntity;
import com.jinshu.settinglibrary.recyclerview.baseadapter.SCommonRecycleViewAdapter;
import com.jinshu.settinglibrary.recyclerview.baseadapter.SViewHolderHelper;
import com.jinshu.settinglibrary.utils.TimeUtil;

/**
 * Create on 2019/11/6 15:52 by bll
 */


public class MessageAdapter extends SCommonRecycleViewAdapter<MessageEntity.DataInfo.RowsInfo>{

    public MessageAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(SViewHolderHelper helper, MessageEntity.DataInfo.RowsInfo info, int position) {
        helper.setCircleImageUrl(R.id.iv_avatar, info.getSenderMemberAvatar());
        helper.setText(R.id.tv_name, info.getSenderMemberName());
        helper.setText(R.id.tv_date, TimeUtil.formatData(TimeUtil.dateFormat,info.getSendDate()));
        helper.setText(R.id.tv_content, info.getName());
    }

}
