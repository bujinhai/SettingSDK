package com.jinshu.settinglibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.LinearLayout;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.adapter.CardListAdapter;
import com.jinshu.settinglibrary.api.SApi;
import com.jinshu.settinglibrary.api.SHostType;
import com.jinshu.settinglibrary.app.SAppConstant;
import com.jinshu.settinglibrary.base.baseapp.SBaseActivity;
import com.jinshu.settinglibrary.base.basebean.SBaseResponse;
import com.jinshu.settinglibrary.base.baserx.SRxSchedulers;
import com.jinshu.settinglibrary.base.baserx.SRxSubscriber;
import com.jinshu.settinglibrary.entity.CardListEntity;
import com.jinshu.settinglibrary.entity.Configure;
import com.jinshu.settinglibrary.recyclerview.irc.IRecyclerView;
import com.jinshu.settinglibrary.recyclerview.irc.OnLoadMoreListener;
import com.jinshu.settinglibrary.recyclerview.irc.OnRefreshListener;
import com.jinshu.settinglibrary.recyclerview.widget.LoadMoreFooterView;
import com.jinshu.settinglibrary.utils.MasterUtils;
import com.jinshu.settinglibrary.utils.SystemUtils;
import com.jinshu.settinglibrary.utils.ToastUtil;
import com.jinshu.settinglibrary.widget.LoadingTip;

import io.reactivex.disposables.Disposable;

/**
 * Create on 2019/10/17 15:26 by bll
 */


public class BankCardListActivity extends SBaseActivity implements OnRefreshListener, OnLoadMoreListener {
    private IRecyclerView mIrc;
    private LoadingTip mLoadingTip;
    private LinearLayout llAddCard;
    private int currentPage = 1;
    private int pageNumber = 10;

    private CardListAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.setting_activity_bank_card_list;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        setTitle("银行卡列表");
        setBackAction();
        mIrc = findViewById(R.id.irc);
        mLoadingTip = findViewById(R.id.loadedTip);
        llAddCard = findViewById(R.id.ll_add_card);
        mAdapter = new CardListAdapter(this, R.layout.setting_adapter_item_card_list);
        mIrc.setLayoutManager(new LinearLayoutManager(this));
        mIrc.setAdapter(mAdapter);
        mIrc.setOnRefreshListener(this);
        mIrc.setOnLoadMoreListener(this);
        setListener();
    }

    @Override
    protected void initData(Intent intent) {
        getMemberCardList(true);
    }

    private void getMemberCardList(final boolean isRefresh) {
        SApi.getDefault(SHostType.BASE_URL)
                .getMemberBankList(MasterUtils.addSessionID(), currentPage, pageNumber, "1")
                .compose(SRxSchedulers.<SBaseResponse<CardListEntity>>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse<CardListEntity>>(mContext) {

                    @Override
                    public void onSubscribe(Disposable d) {
                        if (isRefresh) {
                            mLoadingTip.setLoadingTip(LoadingTip.LoadStatus.loading);
                        }
                    }

                    @Override
                    protected void onSuccess(SBaseResponse<CardListEntity> response) {
                        if (response.header.code != 0) {
                            ToastUtil.showShort(response.header.msg);
                            return;
                        }

                        if (response.body == null || response.body.getData() == null
                                || response.body.getData().getRows() == null) {
                            mLoadingTip.setLoadingTip(LoadingTip.LoadStatus.error);
                            return;
                        }
                        if (isRefresh) {
                            if (response.body.getData().getRows().size() == 0) {
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
                            if (response.body.getData().getRows().size() > 0) {
                                mIrc.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
                            } else {
                                mIrc.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
                            }
                        }
                        if (isRefresh) {
                            mAdapter.replaceAll(response.body.getData().getRows());
                        } else {
                            mAdapter.addAll(response.body.getData().getRows());
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
        getMemberCardList(true);
    }

    @Override
    public void onLoadMore(View loadMoreView) {
        mAdapter.getPageBean().setRefresh(false);
        mIrc.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
        getMemberCardList(false);
    }

    private void setListener() {
        llAddCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString(SAppConstant.BANK_CARD_TYPE, Configure.CREATE.name());
                SystemUtils.jumpActivityForResult(mActivity, CreateBankCardActivity.class, SAppConstant.BANK_CARD_CODE, bundle);
            }
        });

        mAdapter.setOnCardClickListener(new CardListAdapter.OnBankCardClickListener() {
            @Override
            public void onCardEditClick(CardListEntity.DataInfo.RowsInfo info) {
                Bundle bundle = new Bundle();
                bundle.putString(SAppConstant.BANK_CARD_TYPE, Configure.UPDATE.name());
                bundle.putSerializable(SAppConstant.BANK_CARD_ID, info.getMemberBankID());
                SystemUtils.jumpActivityForResult(mActivity, CreateBankCardActivity.class, SAppConstant.BANK_CARD_CODE, bundle);
            }

            @Override
            public void onCardDefaultClick(CardListEntity.DataInfo.RowsInfo info) {
                setDefaultCard(info.getMemberBankID());
            }
        });

        mLoadingTip.setOnReloadListener(new LoadingTip.onReloadListener() {
            @Override
            public void reload() {
                getMemberCardList(true);
            }
        });
    }

    /**
     * 设置默认银行卡
     */
    private void setDefaultCard(String memberBankID) {
        SApi.getDefault(SHostType.BASE_URL)
                .setMyMemberBankDefault(MasterUtils.addSessionID(), memberBankID)
                .compose(SRxSchedulers.<SBaseResponse>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse>(mContext, false) {
                    @Override
                    protected void onSuccess(SBaseResponse response) {
                        if (response.header.code != 0) {
                            ToastUtil.showShort(response.header.msg);
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
        if (requestCode == SAppConstant.BANK_CARD_CODE) {
            if (resultCode == RESULT_OK) {
                onRefresh();
            }
        }
    }
}
