package com.jinshu.settinglibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.adapter.AccountAdapter;
import com.jinshu.settinglibrary.api.SApi;
import com.jinshu.settinglibrary.api.SHostType;
import com.jinshu.settinglibrary.base.baseapp.SBaseActivity;
import com.jinshu.settinglibrary.base.baserx.SRxHelper;
import com.jinshu.settinglibrary.base.baserx.SRxSchedulers;
import com.jinshu.settinglibrary.base.baserx.SRxSubscriber;
import com.jinshu.settinglibrary.entity.AccountEntity;
import com.jinshu.settinglibrary.recyclerview.irc.IRecyclerView;
import com.jinshu.settinglibrary.recyclerview.irc.OnLoadMoreListener;
import com.jinshu.settinglibrary.recyclerview.irc.OnRefreshListener;
import com.jinshu.settinglibrary.recyclerview.widget.LoadMoreFooterView;
import com.jinshu.settinglibrary.utils.MasterUtils;
import com.jinshu.settinglibrary.utils.ToastUtil;
import com.jinshu.settinglibrary.widget.LoadingTip;

import io.reactivex.disposables.Disposable;

/**
 * Create on 2019/11/28 17:48 by bll
 */


public class AccountActivity extends SBaseActivity implements OnRefreshListener, OnLoadMoreListener {

    private IRecyclerView mIrc;
    private LoadingTip mLoadingTip;

    private int currentPage = 1;
    private int pageNumber = 10;

    private AccountAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.setting_act_account;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        setTitle("我的账单");
        setBackAction();
        mIrc = findViewById(R.id.irc);
        mLoadingTip = findViewById(R.id.loadedTip);
        mAdapter = new AccountAdapter(this, R.layout.setting_adapter_item_account);
        mIrc.setLayoutManager(new LinearLayoutManager(this));
        mIrc.setAdapter(mAdapter);

        mIrc.setOnRefreshListener(this);
        mIrc.setOnLoadMoreListener(this);
    }

    @Override
    protected void initData(Intent intent) {
        getMemberBalanceList(true);
    }

    private void getMemberBalanceList(final boolean isRefresh) {
        SApi.getDefault(SHostType.BASE_URL)
                .getMemberBalanceList(MasterUtils.addSessionID(), currentPage, pageNumber, 1)
                .compose(SRxHelper.<AccountEntity>handleResult())
                .compose(SRxSchedulers.<AccountEntity>io_main())
                .subscribe(new SRxSubscriber<AccountEntity>(mContext, false) {

                    @Override
                    public void onSubscribe(Disposable d) {
                        if (isRefresh) {
                            mLoadingTip.setLoadingTip(LoadingTip.LoadStatus.loading);
                        }
                    }

                    @Override
                    protected void onSuccess(AccountEntity accountEntity) {
                        if (accountEntity.getData() == null || accountEntity.getData().getRows() == null) {
                            mLoadingTip.setLoadingTip(LoadingTip.LoadStatus.error);
                            return;
                        }

                        if (isRefresh) {
                            if (accountEntity.getData().getRows().size() == 0) {
                                mLoadingTip.setLoadingTip(LoadingTip.LoadStatus.empty);
                                return;
                            }
                        }
                        currentPage++;
                        mLoadingTip.setLoadingTip(LoadingTip.LoadStatus.finish);
                        if (mAdapter.getPageBean().isRefresh()) {
                            mIrc.setRefreshing(false);
                            mIrc.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
                        } else {
                            if (accountEntity.getData().getRows().size() > 0) {
                                mIrc.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
                            } else {
                                mIrc.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
                            }
                        }
                        if (isRefresh) {
                            mAdapter.replaceAll(accountEntity.getData().getRows());
                        } else {
                            mAdapter.addAll(accountEntity.getData().getRows());
                        }
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }

    @Override
    public void onRefresh() {
        currentPage = 1;
        mAdapter.getPageBean().setRefresh(true);
        mIrc.setRefreshing(true);
        getMemberBalanceList(true);
    }

    @Override
    public void onLoadMore(View loadMoreView) {
        mAdapter.getPageBean().setRefresh(false);
        mIrc.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
        getMemberBalanceList(false);
    }
}
