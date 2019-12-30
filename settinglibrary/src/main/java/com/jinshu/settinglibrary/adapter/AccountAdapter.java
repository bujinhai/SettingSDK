package com.jinshu.settinglibrary.adapter;

import android.content.Context;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.entity.AccountInfo;
import com.jinshu.settinglibrary.recyclerview.baseadapter.SCommonRecycleViewAdapter;
import com.jinshu.settinglibrary.recyclerview.baseadapter.SViewHolderHelper;
import com.jinshu.settinglibrary.utils.StrUtils;

/**
 * Create on 2019/12/3 10:05 by bll
 */


public class AccountAdapter extends SCommonRecycleViewAdapter<AccountInfo> {

    public AccountAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(SViewHolderHelper helper, AccountInfo accountInfo, int position) {
        helper.setText(R.id.tv_operateType, accountInfo.getOperateType());
        helper.setText(R.id.tv_date, accountInfo.getOperateTimeStr());
        helper.setText(R.id.tv_amount, "¥" + StrUtils.formatMoney(accountInfo.getAmount()));
    }
}
