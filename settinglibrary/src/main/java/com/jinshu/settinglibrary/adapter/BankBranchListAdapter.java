package com.jinshu.settinglibrary.adapter;

import android.content.Context;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.entity.BankBranchListEntity;
import com.jinshu.settinglibrary.recyclerview.baseadapter.SCommonRecycleViewAdapter;
import com.jinshu.settinglibrary.recyclerview.baseadapter.SViewHolderHelper;

/**
 * Create on 2019/10/21 18:05 by bll
 */


public class BankBranchListAdapter extends SCommonRecycleViewAdapter<BankBranchListEntity.DataInfo.RowsInfo> {

    public BankBranchListAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(SViewHolderHelper helper, BankBranchListEntity.DataInfo.RowsInfo info, int position) {
        helper.setText(R.id.tv_name, info.getName());
    }
}
