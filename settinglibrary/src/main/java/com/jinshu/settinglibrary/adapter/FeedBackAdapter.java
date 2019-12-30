package com.jinshu.settinglibrary.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.entity.FeedListEntity;
import com.jinshu.settinglibrary.recyclerview.baseadapter.SCommonRecycleViewAdapter;
import com.jinshu.settinglibrary.recyclerview.baseadapter.SViewHolderHelper;
import com.luck.picture.lib.tools.ScreenUtils;

import java.util.List;

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

        setItemPhotoValues(helper, info);
    }

    private void setItemPhotoValues(SViewHolderHelper helper, FeedListEntity.DataInfo.RowsInfo info) {
        int PhotoThreeHeight = ScreenUtils.dip2px(mContext, 90);
        int PhotoTwoHeight = ScreenUtils.dip2px(mContext, 110);
        int PhotoOneHeight = ScreenUtils.dip2px(mContext, 130);
        String imgSrcLeft = null;
        String imgSrcMiddle = null;
        String imgSrcRight = null;
        LinearLayout photo_iv_group = helper.getView(R.id.feed_back_photo_iv_group);
        ViewGroup.LayoutParams layoutParams = photo_iv_group.getLayoutParams();
        List<String> attachmentList = info.getAttachmentList();
        if (attachmentList != null) {
            int size = attachmentList.size();
            if (size == 0) {
                photo_iv_group.setVisibility(View.GONE);
                return;
            } else {
                photo_iv_group.setVisibility(View.VISIBLE);
            }
            if (size >= 3) {
                imgSrcLeft = attachmentList.get(0);
                imgSrcMiddle = attachmentList.get(1);
                imgSrcRight = attachmentList.get(2);
                layoutParams.height = PhotoThreeHeight;
            } else if (size >= 2) {
                imgSrcLeft = attachmentList.get(0);
                imgSrcMiddle = attachmentList.get(1);
                layoutParams.height = PhotoTwoHeight;
            } else if (size >= 1) {
                imgSrcLeft = attachmentList.get(0);
                layoutParams.height = PhotoOneHeight;
            }
        }

        setPhotoImageView(helper, imgSrcLeft, imgSrcMiddle, imgSrcRight);
    }


    private void setPhotoImageView(SViewHolderHelper helper, String imgSrcLeft, String imgSrcMiddle, String imgSrcRight) {
        if (imgSrcLeft != null) {
            helper.setVisible(R.id.feed_back_photo_iv_left, true);
            helper.setImageUrl(R.id.feed_back_photo_iv_left, imgSrcLeft);
        } else {
            helper.setVisible(R.id.feed_back_photo_iv_left, false);
        }
        if (imgSrcMiddle != null) {
            helper.setVisible(R.id.feed_back_photo_iv_middle, true);
            helper.setImageUrl(R.id.feed_back_photo_iv_middle, imgSrcMiddle);
        } else {
            helper.setVisible(R.id.feed_back_photo_iv_middle, false);
        }
        if (imgSrcRight != null) {
            helper.setVisible(R.id.feed_back_photo_iv_right, true);
            helper.setImageUrl(R.id.feed_back_photo_iv_right, imgSrcRight);
        } else {
            helper.setVisible(R.id.feed_back_photo_iv_right, false);
        }
    }
}
