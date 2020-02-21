package com.jinshu.settinglibrary.adapter;

import android.content.Context;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.recyclerview.baseadapter.SCommonRecycleViewAdapter;
import com.jinshu.settinglibrary.recyclerview.baseadapter.SViewHolderHelper;
import com.luck.picture.lib.entity.LocalMedia;

/**
 * Created on 2020-02-20 by bll
 */

public class FeedBackDetailImageAdapter extends SCommonRecycleViewAdapter<LocalMedia> {

    public FeedBackDetailImageAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(SViewHolderHelper helper, LocalMedia media, int position) {
        helper.setImageUrl(R.id.fiv, media.getPath());
    }
}
