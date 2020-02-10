package com.jinshu.settinglibrary.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.activity.MessageDetailActivity;
import com.jinshu.settinglibrary.adapter.MessageAdapter;
import com.jinshu.settinglibrary.api.SApi;
import com.jinshu.settinglibrary.api.SHostType;
import com.jinshu.settinglibrary.app.SAppConstant;
import com.jinshu.settinglibrary.base.baseapp.SBaseFragment;
import com.jinshu.settinglibrary.base.basebean.SBaseResponse;
import com.jinshu.settinglibrary.base.baserx.SRxHelper;
import com.jinshu.settinglibrary.base.baserx.SRxSchedulers;
import com.jinshu.settinglibrary.base.baserx.SRxSubscriber;
import com.jinshu.settinglibrary.entity.MessageEntity;
import com.jinshu.settinglibrary.recyclerview.irc.IRecyclerView;
import com.jinshu.settinglibrary.recyclerview.irc.OnItemClickListener;
import com.jinshu.settinglibrary.recyclerview.irc.OnLoadMoreListener;
import com.jinshu.settinglibrary.recyclerview.irc.OnRefreshListener;
import com.jinshu.settinglibrary.recyclerview.widget.LoadMoreFooterView;
import com.jinshu.settinglibrary.utils.MasterUtils;
import com.jinshu.settinglibrary.utils.SDKUtils;
import com.jinshu.settinglibrary.utils.SystemUtils;
import com.jinshu.settinglibrary.utils.ToastUtil;
import com.jinshu.settinglibrary.widget.LoadingTip;

import io.reactivex.disposables.Disposable;

/**
 * Create on 2019/11/6 15:45 by bll
 */


public class MessageFragment extends SBaseFragment implements OnRefreshListener, OnLoadMoreListener {

    private IRecyclerView mIrc;
    private LoadingTip mLoadingTip;

    private int currentPage = 1;
    private int pageNumber = 10;
    private int messageType;

    private MessageAdapter mAdapter;
    private String memberID;

    @Override
    protected int getLayoutResource() {
        return R.layout.setting_fragment_message;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        mIrc = bindView(R.id.irc);
        mLoadingTip = bindView(R.id.loadedTip);
        mAdapter = new MessageAdapter(getContext(), R.layout.setting_adapter_item_message);
        mIrc.setLayoutManager(new LinearLayoutManager(getContext()));
        mIrc.setAdapter(mAdapter);

        mIrc.setOnRefreshListener(this);
        mIrc.setOnLoadMoreListener(this);

        setListener();
    }

    private void setListener() {
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object o, int position) {
                MessageEntity.DataInfo.RowsInfo info = (MessageEntity.DataInfo.RowsInfo) o;
                readOneMessage(info.getMessageID());
                Bundle bundle = new Bundle();
                bundle.putString(SAppConstant.MESSAGE_ID, info.getMessageID());
                SystemUtils.jumpActivity(getActivity(), MessageDetailActivity.class, bundle);
            }
        });
    }

    private void readOneMessage(String messageID) {
        SApi.getDefault(SHostType.BASE_URL)
                .readOneMessage(MasterUtils.addSessionID(), messageID)
                .compose(SRxSchedulers.<SBaseResponse>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse>(getContext(), false) {
                    @Override
                    protected void onSuccess(SBaseResponse sBaseResponse) {
                        if (sBaseResponse.faild()) {
                            ToastUtil.showShort(sBaseResponse.header.msg);
                        }
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        if (bundle != null) {
            messageType = bundle.getInt(SAppConstant.MESSAGE_TYPE);
        }
        memberID = SDKUtils.getUser().getMemberID();

        getMyReceivedMessageList(true);
    }

    private void getMyReceivedMessageList(final boolean isRefresh) {
        SApi.getDefault(SHostType.BASE_URL)
                .getMyReceivedMessageList(MasterUtils.addSessionID(), "8a2f462a698fd5f601698fed139c013c", messageType, currentPage, pageNumber, "1")
                .compose(SRxHelper.<MessageEntity>handleResult())
                .compose(SRxSchedulers.<MessageEntity>io_main())
                .subscribe(new SRxSubscriber<MessageEntity>(getContext()) {

                    @Override
                    public void onSubscribe(Disposable d) {
                        if (isRefresh) {
                            mLoadingTip.setLoadingTip(LoadingTip.LoadStatus.loading);
                        }
                    }

                    @Override
                    protected void onSuccess(MessageEntity messageEntity) {
                        if (messageEntity.getData() == null || messageEntity.getData().getRows() == null) {
                            mLoadingTip.setLoadingTip(LoadingTip.LoadStatus.error);
                            return;
                        }
                        if (isRefresh) {
                            if (messageEntity.getData().getRows().size() == 0) {
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
                            if (messageEntity.getData().getRows().size() > 0) {
                                mIrc.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
                            } else {
                                mIrc.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
                            }
                        }
                        if (isRefresh) {
                            mAdapter.replaceAll(messageEntity.getData().getRows());
                        } else {
                            mAdapter.addAll(messageEntity.getData().getRows());
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
        getMyReceivedMessageList(true);
    }

    @Override
    public void onLoadMore(View loadMoreView) {
        mAdapter.getPageBean().setRefresh(false);
        mIrc.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
        getMyReceivedMessageList(false);
    }

}
