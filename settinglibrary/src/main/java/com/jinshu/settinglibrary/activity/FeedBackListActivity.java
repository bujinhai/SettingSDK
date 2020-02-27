package com.jinshu.settinglibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.adapter.FeedBackAdapter;
import com.jinshu.settinglibrary.api.SApi;
import com.jinshu.settinglibrary.api.SHostType;
import com.jinshu.settinglibrary.app.SAppConstant;
import com.jinshu.settinglibrary.base.baseapp.SBaseActivity;
import com.jinshu.settinglibrary.base.basebean.SBaseResponse;
import com.jinshu.settinglibrary.base.baserx.SRxHelper;
import com.jinshu.settinglibrary.base.baserx.SRxSchedulers;
import com.jinshu.settinglibrary.base.baserx.SRxSubscriber;
import com.jinshu.settinglibrary.entity.FeedListEntity;
import com.jinshu.settinglibrary.recyclerview.animation.ScaleInAnimation;
import com.jinshu.settinglibrary.recyclerview.irc.IRecyclerView;
import com.jinshu.settinglibrary.recyclerview.irc.OnItemClickListener;
import com.jinshu.settinglibrary.recyclerview.irc.OnLoadMoreListener;
import com.jinshu.settinglibrary.recyclerview.irc.OnRefreshListener;
import com.jinshu.settinglibrary.recyclerview.widget.LoadMoreFooterView;
import com.jinshu.settinglibrary.utils.MasterUtils;
import com.jinshu.settinglibrary.utils.SystemUtils;
import com.jinshu.settinglibrary.utils.ToastUtil;
import com.jinshu.settinglibrary.view.Image;
import com.jinshu.settinglibrary.widget.LoadingTip;

import java.util.ArrayList;
import java.util.List;

/**
 * Create on 2019/10/25 16:57 by bll
 */


public class FeedBackListActivity extends SBaseActivity implements OnRefreshListener, OnLoadMoreListener {

    private IRecyclerView mIrc;
    private LoadingTip mLoadingTip;
    private FeedBackAdapter mAdapter;
    private int currentPage = 1;
    private int pageNumber = 10;

    @Override
    public int getLayoutId() {
        return R.layout.setting_activity_feed_back_list;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        setTitle("我的反馈");
        setBackAction();
        mIrc = findViewById(R.id.irc);
        mLoadingTip = findViewById(R.id.loadedTip);
        mAdapter = new FeedBackAdapter(this, R.layout.setting_adapter_item_feed_back_content);
        mAdapter.openLoadAnimation(new ScaleInAnimation());
        mIrc.setLayoutManager(new LinearLayoutManager(this));
        mIrc.setAdapter(mAdapter);
        mIrc.setOnRefreshListener(this);
        mIrc.setOnLoadMoreListener(this);

        setListener();
    }

    private void setListener() {
        mLoadingTip.setOnReloadListener(new LoadingTip.onReloadListener() {
            @Override
            public void reload() {
                getMyFeedList(true);
            }
        });

        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object o, int position) {
                FeedListEntity.DataInfo.RowsInfo info = (FeedListEntity.DataInfo.RowsInfo) o;
                Bundle bundle = new Bundle();
                bundle.putSerializable(SAppConstant.FEED_INFO, info);
                SystemUtils.jumpActivity(mActivity, FeedBackDetailActivity.class, bundle);

                readOneFeedBack(info.getFeedID());
            }
        });
    }

    private void readOneFeedBack(String feedID) {
        SApi.getDefault(SHostType.BASE_URL)
                .readOneFeedback(MasterUtils.addSessionID(), feedID)
                .compose(SRxSchedulers.<SBaseResponse>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse>(mContext, false) {
                    @Override
                    protected void onSuccess(SBaseResponse response) {
                        if (response.faild()) {

                        }
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }


    @Override
    protected void initData(Intent intent) {
        getMyFeedList(true);
    }

    private void getMyFeedList(final boolean isRefresh) {
        SApi.getDefault(SHostType.BASE_URL)
                .getMyFeedList(MasterUtils.addSessionID(), currentPage, pageNumber, "1")
                .compose(SRxHelper.<FeedListEntity>handleResult())
                .compose(SRxSchedulers.<FeedListEntity>io_main())
                .subscribe(new SRxSubscriber<FeedListEntity>(mContext, false) {
                    @Override
                    protected void onSuccess(FeedListEntity entity) {
                        if (entity.getData() == null || entity.getData().getRows() == null) {
                            return;
                        }

                        if (isRefresh) {
                            if (entity.getData().getRows().size() == 0) {
                                mLoadingTip.setLoadingTip(LoadingTip.LoadStatus.empty);
                                return;
                            }
                        }

                        mLoadingTip.setLoadingTip(LoadingTip.LoadStatus.finish);
                        currentPage++;
                        if (mAdapter.getPageBean().isRefresh()) {
                            mIrc.setRefreshing(false);
                            mIrc.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
                        } else {
                            if (entity.getData().getRows().size() > 0) {
                                mIrc.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
                            } else {
                                mIrc.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
                            }
                        }

                        handleData(entity.getData().getRows());

                        if (isRefresh) {
                            mAdapter.replaceAll(entity.getData().getRows());
                        } else {
                            mAdapter.addAll(entity.getData().getRows());
                        }

                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                        mLoadingTip.setLoadingTip(LoadingTip.LoadStatus.error);
                    }
                });

    }

    private void handleData(List<FeedListEntity.DataInfo.RowsInfo> rows) {
        for (FeedListEntity.DataInfo.RowsInfo rowsInfo : rows) {
            List<Image> images = new ArrayList<>();
            for (String url : rowsInfo.getAttachmentList()) {
                Image image = new Image(url, 640, 640);
                images.add(image);
                rowsInfo.setImageList(images);
            }
        }
    }


    @Override
    public void onRefresh() {
        currentPage = 1;
        mAdapter.getPageBean().setRefresh(true);
        mIrc.setRefreshing(true);
        getMyFeedList(true);
    }

    @Override
    public void onLoadMore(View loadMoreView) {
        mAdapter.getPageBean().setRefresh(false);
        mIrc.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
        getMyFeedList(false);
    }
}
