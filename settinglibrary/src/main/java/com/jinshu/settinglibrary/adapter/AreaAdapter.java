package com.jinshu.settinglibrary.adapter;

import android.content.Context;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.entity.AddressEntity;
import com.jinshu.settinglibrary.recyclerview.baseadapter.SCommonRecycleViewAdapter;
import com.jinshu.settinglibrary.recyclerview.baseadapter.SViewHolderHelper;

/**
 * Create on 2019/10/14 21:09 by bll
 */


public class AreaAdapter extends SCommonRecycleViewAdapter<AddressEntity.DataInfo.RowsInfo> {


    public AreaAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(SViewHolderHelper helper, AddressEntity.DataInfo.RowsInfo info, int position) {
        helper.setText(R.id.tv_name, info.getName());
    }


}
