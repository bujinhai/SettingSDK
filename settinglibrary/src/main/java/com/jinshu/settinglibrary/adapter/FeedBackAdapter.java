package com.jinshu.settinglibrary.adapter;

import android.content.Context;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.entity.FeedListEntity;
import com.jinshu.settinglibrary.recyclerview.baseadapter.SCommonRecycleViewAdapter;
import com.jinshu.settinglibrary.recyclerview.baseadapter.SViewHolderHelper;
import com.jinshu.settinglibrary.view.NineGridlayout;

/**
 * Create on 2019/10/25 18:11 by bll
 */


public class FeedBackAdapter extends SCommonRecycleViewAdapter<FeedListEntity.DataInfo.RowsInfo> {

    public FeedBackAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(SViewHolderHelper helper, FeedListEntity.DataInfo.RowsInfo info, int position) {
        setItemValues(helper, info);
    }

    private void setItemValues(SViewHolderHelper helper, FeedListEntity.DataInfo.RowsInfo info) {
        helper.setText(R.id.tv_content, info.getContent());
        helper.setText(R.id.tv_date, info.getSubmitTimeStr());
        NineGridlayout gridlayout = helper.getView(R.id.iv_grid_layout);
        if (info.getAttachmentList().size() == 0) {
            helper.setVisible(R.id.feed_back_photo_iv_group, false);
        } else {
            helper.setVisible(R.id.feed_back_photo_iv_group, true);
            gridlayout.setImagesData(info.getImageList());
        }
    }
}
