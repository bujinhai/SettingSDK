package com.jinshu.settinglibrary.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.activity.InvoiceActivity;
import com.jinshu.settinglibrary.adapter.InvoiceAdapter;
import com.jinshu.settinglibrary.api.SApi;
import com.jinshu.settinglibrary.api.SHostType;
import com.jinshu.settinglibrary.app.SAppConstant;
import com.jinshu.settinglibrary.base.baseapp.SBaseFragment;
import com.jinshu.settinglibrary.base.basebean.SBaseResponse;
import com.jinshu.settinglibrary.base.baserx.SRxHelper;
import com.jinshu.settinglibrary.base.baserx.SRxSchedulers;
import com.jinshu.settinglibrary.base.baserx.SRxSubscriber;
import com.jinshu.settinglibrary.entity.Configure;
import com.jinshu.settinglibrary.entity.InvoiceEntity;
import com.jinshu.settinglibrary.entity.UserData;
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
 * Create on 2019/10/29 10:19 by bll
 */


public class InvoiceFragment extends SBaseFragment implements OnRefreshListener, OnLoadMoreListener {

    private IRecyclerView mIrc;
    private LoadingTip mLoadingTip;

    private int currentPage = 1;
    private int pageNumber = 10;
    private int invoiceType;
    private InvoiceAdapter mAdapter;

    private boolean isGoods = false;
    private String memberID;

    @Override
    protected int getLayoutResource() {
        return R.layout.setting_fragment_invoice;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        mIrc = bindView(R.id.irc);
        mLoadingTip = bindView(R.id.loadedTip);

        mIrc.setLayoutManager(new LinearLayoutManager(getContext()));
        mIrc.setOnRefreshListener(this);
        mIrc.setOnLoadMoreListener(this);
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        if (bundle != null) {
            invoiceType = bundle.getInt(SAppConstant.INVOICE_TYPE);
            isGoods = bundle.getBoolean(SAppConstant.IS_GOODS);
            if (invoiceType == 1) {
                mAdapter = new InvoiceAdapter(getContext(), R.layout.setting_adapter_item_personal_invoice);
                mIrc.setAdapter(mAdapter);
            } else if (invoiceType == 2) {
                mAdapter = new InvoiceAdapter(getContext(), R.layout.setting_adapter_item_company_invoice);
                mIrc.setAdapter(mAdapter);
            }
        }
        UserData userData = SDKUtils.getUser();
        if (userData == null) {
            return;
        }
        memberID = userData.getMemberID();

        setListener();
        getInvoice(true);
    }

    private void getInvoice(final boolean isRefresh) {
        SApi.getDefault(SHostType.BASE_URL)
                .getMemberInvoiceDefineList(MasterUtils.addSessionID(), memberID, invoiceType,
                        currentPage, pageNumber, "1")
                .compose(SRxHelper.<InvoiceEntity>handleResult())
                .compose(SRxSchedulers.<InvoiceEntity>io_main())
                .subscribe(new SRxSubscriber<InvoiceEntity>(getContext()) {

                    @Override
                    public void onSubscribe(Disposable d) {
                        if (isRefresh) {
                            mLoadingTip.setLoadingTip(LoadingTip.LoadStatus.loading);
                        }
                    }

                    @Override
                    protected void onSuccess(InvoiceEntity invoiceEntity) {

                        if (invoiceEntity.getData() == null || invoiceEntity.getData().getRows() == null) {
                            mLoadingTip.setLoadingTip(LoadingTip.LoadStatus.error);
                            return;
                        }

                        if (isRefresh) {
                            if (invoiceEntity.getData().getRows().size() == 0) {
                                mLoadingTip.setLoadingTip(LoadingTip.LoadStatus.empty);
                                return;
                            }
                        }

                        mLoadingTip.setLoadingTip(LoadingTip.LoadStatus.finish);
                        if (mAdapter.getPageBean().isRefresh()) {
                            mIrc.setRefreshing(false);
                            mIrc.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
                        } else {
                            if (invoiceEntity.getData().getRows().size() > 0) {
                                mIrc.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
                            } else {
                                mIrc.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
                            }
                        }
                        if (isRefresh) {
                            mAdapter.replaceAll(invoiceEntity.getData().getRows());
                        } else {
                            mAdapter.addAll(invoiceEntity.getData().getRows());
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
        getInvoice(true);
    }

    @Override
    public void onLoadMore(View loadMoreView) {
        currentPage++;
        mAdapter.getPageBean().setRefresh(false);
        mIrc.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
        getInvoice(false);
    }

    private void setListener() {
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object o, int position) {
                if (isGoods) {
                    InvoiceEntity.DataInfo.RowsInfo info = (InvoiceEntity.DataInfo.RowsInfo) o;
                    Bundle bundle = new Bundle();
                    bundle.putString(SAppConstant.MEMBER_INVOICE_DEFINE_ID, info.getMemberInvoiceDefineID());
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    getActivity().setResult(getActivity().RESULT_OK, intent);
                    getActivity().finish();
                }
            }
        });


        mAdapter.setOnInvoiceClickListener(new InvoiceAdapter.OnInvoiceClickListener() {

            @Override
            public void onDelete(InvoiceEntity.DataInfo.RowsInfo info) {
                deleteOneMemberInvoiceDefine(info);
            }

            @Override
            public void onEdit(InvoiceEntity.DataInfo.RowsInfo info) {
                Bundle bundle = new Bundle();
                bundle.putString(SAppConstant.INVOICE_FLAG, Configure.UPDATE.name());
                bundle.putString(SAppConstant.MEMBER_INVOICE_DEFINE_ID, info.getMemberInvoiceDefineID());
                SystemUtils.jumpActivityForResult(getActivity(), InvoiceActivity.class, SAppConstant.INVOICE_CODE, bundle);
            }
        });

        mLoadingTip.setOnReloadListener(new LoadingTip.onReloadListener() {
            @Override
            public void reload() {
                getInvoice(true);
            }
        });
    }

    private void deleteOneMemberInvoiceDefine(final InvoiceEntity.DataInfo.RowsInfo info) {
        SApi.getDefault(SHostType.BASE_URL)
                .deleteOneMemberInvoiceDefine(MasterUtils.addSessionID(), info.getMemberInvoiceDefineID())
                .compose(SRxSchedulers.<SBaseResponse>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse>(getContext()) {
                    @Override
                    protected void onSuccess(SBaseResponse response) {
                        if (response.header.code != 0) {
                            ToastUtil.showShort(response.header.msg);
                            return;
                        }
                        mAdapter.remove(info);
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case SAppConstant.INVOICE_CODE:
                onRefresh();
                break;
        }
    }
}
