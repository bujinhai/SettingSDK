package com.jinshu.settinglibrary.adapter;

import android.content.Context;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.entity.NavigatorEntity;
import com.jinshu.settinglibrary.recyclerview.baseadapter.SCommonRecycleViewAdapter;
import com.jinshu.settinglibrary.recyclerview.baseadapter.SViewHolderHelper;

/**
 * Create on 2019/11/5 15:26 by bll
 */


public class ArticleAdapter extends SCommonRecycleViewAdapter<NavigatorEntity.DataInfo.RowsInfo> {

    public ArticleAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(SViewHolderHelper helper, NavigatorEntity.DataInfo.RowsInfo rowsInfo, int position) {
        helper.setText(R.id.tv_queston_name, rowsInfo.getTitle());
    }
}
