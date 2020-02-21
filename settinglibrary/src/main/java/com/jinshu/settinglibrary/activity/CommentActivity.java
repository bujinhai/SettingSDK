package com.jinshu.settinglibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.adapter.CommentAdapter;
import com.jinshu.settinglibrary.api.SApi;
import com.jinshu.settinglibrary.api.SHostType;
import com.jinshu.settinglibrary.app.SAppConstant;
import com.jinshu.settinglibrary.base.baseapp.SBaseActivity;
import com.jinshu.settinglibrary.base.basebean.SBaseResponse;
import com.jinshu.settinglibrary.base.baserx.SRxSchedulers;
import com.jinshu.settinglibrary.base.baserx.SRxSubscriber;
import com.jinshu.settinglibrary.entity.CommentEntity;
import com.jinshu.settinglibrary.entity.Configure;
import com.jinshu.settinglibrary.recyclerview.animation.ScaleInAnimation;
import com.jinshu.settinglibrary.recyclerview.irc.IRecyclerView;
import com.jinshu.settinglibrary.recyclerview.irc.OnLoadMoreListener;
import com.jinshu.settinglibrary.recyclerview.irc.OnRefreshListener;
import com.jinshu.settinglibrary.recyclerview.widget.LoadMoreFooterView;
import com.jinshu.settinglibrary.utils.MasterUtils;
import com.jinshu.settinglibrary.utils.SystemUtils;
import com.jinshu.settinglibrary.utils.ToastUtil;
import com.jinshu.settinglibrary.widget.LoadingTip;

import io.reactivex.disposables.Disposable;

public class CommentActivity extends SBaseActivity implements OnRefreshListener, OnLoadMoreListener, CommentAdapter.OnBtnClickListener {

    private IRecyclerView mIrc;
    private LoadingTip mLoadingTip;
    private CommentAdapter mAdapter;
    private int currentPage = 1;
    private int pageNumber = 10;
    private String objectID;
    private String name;
    private String objectName;
    private String objectDefineID;

    @Override
    public int getLayoutId() {
        return R.layout.setting_activity_comment;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        setTitle("评论列表");
        setRightTitle("发表评论");
        setBackAction();

        mIrc = findViewById(R.id.irc);
        mLoadingTip = findViewById(R.id.loadedTip);
        mAdapter = new CommentAdapter(this, R.layout.setting_adapter_item_comment_title);
        mAdapter.openLoadAnimation(new ScaleInAnimation());
        mAdapter.setOnBtnClickListener(this);
        mIrc.setLayoutManager(new LinearLayoutManager(this));
        mIrc.setAdapter(mAdapter);
        mIrc.setOnRefreshListener(this);
        mIrc.setOnLoadMoreListener(this);

        setListener();
    }

    @Override
    protected void initData(Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            objectID = bundle.getString(SAppConstant.OBJECT_ID);
            name = bundle.getString(SAppConstant.COMMENT_NAME);
            objectName = bundle.getString(SAppConstant.OBJECT_NAME);
            objectDefineID = bundle.getString(SAppConstant.OBJECT_DEFINE_ID);
            getObjectDiscussList(true);
        }
    }

    private void setListener() {
        setRightTitleListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString(SAppConstant.OBJECT_ID, objectID);
                bundle.putString(SAppConstant.COMMENT_NAME, name);
                bundle.putString(SAppConstant.OBJECT_NAME, objectName);
                bundle.putString(SAppConstant.OBJECT_DEFINE_ID, objectDefineID);
                bundle.putString(SAppConstant.COMMENT_TYPE, Configure.PUBLISH.name());
                SystemUtils.jumpActivityForResult(mActivity, PublishCommentActivity.class, SAppConstant.COMMENT_REQUEST_CODE, bundle);
            }
        });

        mLoadingTip.setOnReloadListener(new LoadingTip.onReloadListener() {
            @Override
            public void reload() {
                getObjectDiscussList(true);
            }
        });
    }

    private void getObjectDiscussList(final boolean isRefresh) {
        SApi.getDefault(SHostType.BASE_URL)
                .getObjectDiscussList(MasterUtils.addSessionID(), currentPage, pageNumber, objectID, "1")
                .compose(SRxSchedulers.<SBaseResponse<CommentEntity>>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse<CommentEntity>>(mContext, false) {

                    @Override
                    public void onSubscribe(Disposable d) {
                        if (isRefresh) {
                            mLoadingTip.setLoadingTip(LoadingTip.LoadStatus.loading);
                        }
                    }

                    @Override
                    protected void onSuccess(SBaseResponse<CommentEntity> entity) {
                        if (entity.header.code == 10000) {
                            ToastUtil.showShort("登录过期，请重新登录");
                            return;
                        }
                        if (entity.body == null || entity.body.getData() == null
                                || entity.body.getData().getRows() == null) {
                            mLoadingTip.setLoadingTip(LoadingTip.LoadStatus.error);
                            return;
                        }
                        if (isRefresh) {
                            if (entity.body.getData().getRows().size() == 0) {
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
                            if (entity.body.getData().getRows().size() > 0) {
                                mIrc.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
                            } else {
                                mIrc.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
                            }
                        }

                        if (isRefresh) {
                            mAdapter.replaceAll(entity.body.getData().getRows());
                        } else {
                            mAdapter.addAll(entity.body.getData().getRows());
                        }
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                        mLoadingTip.setLoadingTip(LoadingTip.LoadStatus.error);
                    }
                });
    }

    @Override
    public void onRefresh() {
        currentPage = 1;
        mAdapter.getPageBean().setRefresh(true);
        mIrc.setRefreshing(true);
        getObjectDiscussList(true);
    }

    @Override
    public void onLoadMore(View loadMoreView) {
        mAdapter.getPageBean().setRefresh(false);
        mIrc.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
        getObjectDiscussList(false);
    }

    @Override
    public void onEditClick(CommentEntity.DataInfo.RowsInfo info) {
        Bundle bundle = new Bundle();
        bundle.putString(SAppConstant.OBJECT_ID, objectID);
        bundle.putString(SAppConstant.COMMENT_NAME, name);
        bundle.putString(SAppConstant.OBJECT_NAME, objectName);
        bundle.putString(SAppConstant.OBJECT_DEFINE_ID, objectDefineID);
        bundle.putSerializable(SAppConstant.COMMENT_INFO, info);
        bundle.putString(SAppConstant.COMMENT_TYPE, Configure.MODIFY.name());
        SystemUtils.jumpActivityForResult(mActivity, PublishCommentActivity.class, SAppConstant.COMMENT_REQUEST_CODE, bundle);
    }

    @Override
    public void onDeleteClick(CommentEntity.DataInfo.RowsInfo info) {
        SApi.getDefault(SHostType.BASE_URL)
                .deleteOneDiscuss(info.getDiscussID(), MasterUtils.addMasterInfo())
                .compose(SRxSchedulers.<SBaseResponse>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse>(mContext) {
                    @Override
                    protected void onSuccess(SBaseResponse baseResponse) {
                        if (baseResponse.header.code == 0) {
                            onRefresh();
                        }
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SAppConstant.COMMENT_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                onRefresh();
            }
        }
    }
}
