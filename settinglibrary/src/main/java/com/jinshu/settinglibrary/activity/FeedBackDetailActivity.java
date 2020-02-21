package com.jinshu.settinglibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.adapter.FeedBackDetailImageAdapter;
import com.jinshu.settinglibrary.adapter.ReplyAdapter;
import com.jinshu.settinglibrary.api.SApi;
import com.jinshu.settinglibrary.api.SHostType;
import com.jinshu.settinglibrary.app.SAppConstant;
import com.jinshu.settinglibrary.base.baseapp.SBaseActivity;
import com.jinshu.settinglibrary.base.baserx.SRxHelper;
import com.jinshu.settinglibrary.base.baserx.SRxSchedulers;
import com.jinshu.settinglibrary.base.baserx.SRxSubscriber;
import com.jinshu.settinglibrary.entity.FeedListEntity;
import com.jinshu.settinglibrary.entity.OneFeedListEntity;
import com.jinshu.settinglibrary.entity.OneFeedListInfo;
import com.jinshu.settinglibrary.recyclerview.irc.OnItemClickListener;
import com.jinshu.settinglibrary.utils.MasterUtils;
import com.jinshu.settinglibrary.utils.ToastUtil;
import com.jinshu.settinglibrary.view.MyRecyclerView;
import com.jinshu.settinglibrary.widget.PatrolDecoration;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2020-02-20 by bll
 */

public class FeedBackDetailActivity extends SBaseActivity {

    private FeedListEntity.DataInfo.RowsInfo mInfo;
    private TextView tvContent;
    private MyRecyclerView mRvPicture, mRvReplyList;
    private FeedBackDetailImageAdapter mImageAdapter;
    private ReplyAdapter mReplyAdapter;
    private int themeId;
    private List<LocalMedia> imageList;

    @Override
    public int getLayoutId() {
        return R.layout.setting_act_feed_back_detail;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        setTitle("反馈详情");
        setBackAction();
        tvContent = findViewById(R.id.tv_content);
        mRvPicture = findViewById(R.id.rv_picture);
        mRvReplyList = findViewById(R.id.rv_reply_list);
        imageList = new ArrayList<>();

        mRvPicture.setHasFixedSize(true);
        mRvPicture.setNestedScrollingEnabled(false);
        mRvPicture.setLayoutManager(new GridLayoutManager(this, 3));
        mRvPicture.addItemDecoration(new PatrolDecoration());
        mImageAdapter = new FeedBackDetailImageAdapter(this, R.layout.setting_adapter_item_feed_back_detail);
        mRvPicture.setAdapter(mImageAdapter);

        mRvReplyList.setHasFixedSize(true);
        mRvReplyList.setNestedScrollingEnabled(false);
        mRvReplyList.setLayoutManager(new LinearLayoutManager(this));
        mReplyAdapter = new ReplyAdapter(this, R.layout.setting_adapter_item_feed_back_replay);
        mRvReplyList.setAdapter(mReplyAdapter);

        themeId = R.style.picture_default_style;

        setListener();
    }

    @Override
    protected void initData(Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            mInfo = (FeedListEntity.DataInfo.RowsInfo) bundle.getSerializable(SAppConstant.FEED_INFO);
            if (mInfo == null) {
                return;
            }
            for (int i = 0; i < mInfo.getAttachmentList().size(); i++) {
                LocalMedia media = new LocalMedia();
                media.setPath(mInfo.getAttachmentList().get(i));
                imageList.add(media);
            }
            mImageAdapter.replaceAll(imageList);
            tvContent.setText(mInfo.getContent());

            getOneFeedBackList();
        }
    }

    private void getOneFeedBackList() {
        SApi.getDefault(SHostType.BASE_URL)
                .getOneFeedBackList(MasterUtils.addSessionID(), mInfo.getFeedID(), 1, 1000, "1")
                .compose(SRxHelper.<OneFeedListEntity>handleResult())
                .compose(SRxSchedulers.<OneFeedListEntity>io_main())
                .subscribe(new SRxSubscriber<OneFeedListEntity>(mContext, true) {
                    @Override
                    protected void onSuccess(OneFeedListEntity oneFeedListEntity) {
                        if (oneFeedListEntity.getData() == null || oneFeedListEntity.getData().getRows() == null) {
                            return;
                        }
                        List<OneFeedListInfo> info = oneFeedListEntity.getData().getRows();
                        mReplyAdapter.replaceAll(info);
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }

    private void setListener() {
        mImageAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object o, int position) {
                if (imageList.size() > 0) {
                    PictureSelector.create(FeedBackDetailActivity.this).themeStyle(themeId).openExternalPreview(position, imageList);
                }
            }
        });
    }
}
