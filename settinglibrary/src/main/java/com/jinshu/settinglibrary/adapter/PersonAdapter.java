package com.jinshu.settinglibrary.adapter;

import android.content.Context;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.entity.SettingEntity;
import com.jinshu.settinglibrary.recyclerview.baseadapter.SCommonRecycleViewAdapter;
import com.jinshu.settinglibrary.recyclerview.baseadapter.SViewHolderHelper;

/**
 * Create on 2019/10/23 13:55 by bll
 */


public class PersonAdapter extends SCommonRecycleViewAdapter<SettingEntity> {

    public PersonAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(SViewHolderHelper helper, SettingEntity userInfo, int position) {
        helper.setText(R.id.item_name, userInfo.getTitle());
        helper.setText(R.id.item_desc, userInfo.getDesc());
    }
}
