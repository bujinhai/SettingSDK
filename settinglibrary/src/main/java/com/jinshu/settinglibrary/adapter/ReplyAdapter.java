package com.jinshu.settinglibrary.adapter;

import android.content.Context;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.entity.OneFeedListInfo;
import com.jinshu.settinglibrary.recyclerview.baseadapter.SCommonRecycleViewAdapter;
import com.jinshu.settinglibrary.recyclerview.baseadapter.SViewHolderHelper;
import com.jinshu.settinglibrary.utils.TimeUtil;

/**
 * Created on 2020-02-20 by bll
 */

public class ReplyAdapter extends SCommonRecycleViewAdapter<OneFeedListInfo> {

    public ReplyAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(SViewHolderHelper helper, OneFeedListInfo oneFeedListInfo, int position) {
        helper.setText(R.id.tv_fb_name, oneFeedListInfo.getUserName());
        helper.setText(R.id.tv_fb_date, TimeUtil.formatData(TimeUtil.dateFormat, oneFeedListInfo.getBackdate()));
        helper.setText(R.id.tv_fb_content, oneFeedListInfo.getContent());
    }
}
