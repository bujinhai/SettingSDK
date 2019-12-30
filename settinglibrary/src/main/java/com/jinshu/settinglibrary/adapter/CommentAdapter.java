package com.jinshu.settinglibrary.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.entity.CommentEntity;
import com.jinshu.settinglibrary.recyclerview.baseadapter.SCommonRecycleViewAdapter;
import com.jinshu.settinglibrary.recyclerview.baseadapter.SViewHolderHelper;
import com.jinshu.settinglibrary.utils.TimeUtil;
import com.luck.picture.lib.tools.ScreenUtils;

import java.util.List;

/**
 * Create on 2019/9/19 11:00 by bll
 */


public class CommentAdapter extends SCommonRecycleViewAdapter<CommentEntity.DataInfo.RowsInfo> {


    public CommentAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(SViewHolderHelper helper, CommentEntity.DataInfo.RowsInfo info, int position) {
        setItemValues(helper, info);
    }

    private void setItemValues(SViewHolderHelper helper, final CommentEntity.DataInfo.RowsInfo info) {
        helper.setCircleImageUrl(R.id.iv_avatar, info.getMemberAvatar());
        helper.setText(R.id.tv_name, info.getMemberName());
        helper.setText(R.id.tv_date, TimeUtil.formatData(TimeUtil.dateFormat, info.getDiscussTime()));
        helper.setText(R.id.content, info.getShowContent());
        helper.setOnClickListener(R.id.tv_edit, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onEditClick(info);
                }
            }
        });

        helper.setOnClickListener(R.id.tv_delete, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onDeleteClick(info);
                }
            }
        });

        setItemPhotoValues(helper, info);
    }

    private void setItemPhotoValues(SViewHolderHelper helper, CommentEntity.DataInfo.RowsInfo info) {
        int PhotoThreeHeight = ScreenUtils.dip2px(mContext, 90);
        int PhotoTwoHeight = ScreenUtils.dip2px(mContext, 120);
        int PhotoOneHeight = ScreenUtils.dip2px(mContext, 150);
        String imgSrcLeft = null;
        String imgSrcMiddle = null;
        String imgSrcRight = null;
        LinearLayout photo_iv_group = helper.getView(R.id.feed_back_photo_iv_group);
        ViewGroup.LayoutParams layoutParams = photo_iv_group.getLayoutParams();
        List<CommentEntity.DataInfo.RowsInfo.AttachmentDtosInfo> attachmentList = info.getAttachmentDtos();
        if (attachmentList != null) {
            int size = attachmentList.size();
            if (size == 0) {
                photo_iv_group.setVisibility(View.GONE);
                return;
            } else {
                photo_iv_group.setVisibility(View.VISIBLE);
            }
            if (size >= 3) {
                imgSrcLeft = attachmentList.get(0).getUrl();
                imgSrcMiddle = attachmentList.get(1).getUrl();
                imgSrcRight = attachmentList.get(2).getUrl();
                layoutParams.height = PhotoThreeHeight;
            } else if (size >= 2) {
                imgSrcLeft = attachmentList.get(0).getUrl();
                imgSrcMiddle = attachmentList.get(1).getUrl();
                layoutParams.height = PhotoTwoHeight;
            } else if (size >= 1) {
                imgSrcLeft = attachmentList.get(0).getUrl();
                layoutParams.height = PhotoOneHeight;
            }
        }

        setPhotoImageView(helper, imgSrcLeft, imgSrcMiddle, imgSrcRight);
    }


    private void setPhotoImageView(SViewHolderHelper helper, String imgSrcLeft, String imgSrcMiddle, String imgSrcRight) {
        if (imgSrcLeft != null) {
            helper.setVisible(R.id.comment_photo_iv_left, true);
            helper.setImageUrl(R.id.comment_photo_iv_left, imgSrcLeft);
        } else {
            helper.setVisible(R.id.comment_photo_iv_left, false);
        }
        if (imgSrcMiddle != null) {
            helper.setVisible(R.id.comment_photo_iv_middle, true);
            helper.setImageUrl(R.id.comment_photo_iv_middle, imgSrcMiddle);
        } else {
            helper.setVisible(R.id.comment_photo_iv_middle, false);
        }
        if (imgSrcRight != null) {
            helper.setVisible(R.id.comment_photo_iv_right, true);
            helper.setImageUrl(R.id.comment_photo_iv_right, imgSrcRight);
        } else {
            helper.setVisible(R.id.comment_photo_iv_right, false);
        }
    }

    private OnBtnClickListener mListener;

    public interface OnBtnClickListener {
        void onEditClick(CommentEntity.DataInfo.RowsInfo info);

        void onDeleteClick(CommentEntity.DataInfo.RowsInfo info);
    }

    public void setOnBtnClickListener(OnBtnClickListener listener) {
        mListener = listener;
    }
}
