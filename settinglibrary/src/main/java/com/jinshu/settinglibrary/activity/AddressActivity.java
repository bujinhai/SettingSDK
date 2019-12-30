package com.jinshu.settinglibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.LinearLayout;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.adapter.AddressAdapter;
import com.jinshu.settinglibrary.api.SApi;
import com.jinshu.settinglibrary.api.SHostType;
import com.jinshu.settinglibrary.app.SAppConstant;
import com.jinshu.settinglibrary.base.baseapp.SBaseActivity;
import com.jinshu.settinglibrary.base.basebean.SBaseResponse;
import com.jinshu.settinglibrary.base.baserx.SRxSchedulers;
import com.jinshu.settinglibrary.base.baserx.SRxSubscriber;
import com.jinshu.settinglibrary.entity.AddressListEntity;
import com.jinshu.settinglibrary.entity.Configure;
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
 * Create on 2019/9/24 10:25 by bll
 */


public class AddressActivity extends SBaseActivity implements OnRefreshListener, OnLoadMoreListener {

    private IRecyclerView mIrc;
    private LoadingTip mLoadingTip;
    private LinearLayout llAdd;
    private AddressAdapter mAdapter;
    private int currentPage = 1;
    private int pageNumber = 10;

    private String memberId;
    private boolean isGoods = false;

    @Override
    public int getLayoutId() {
        return R.layout.setting_activity_address;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        setTitle("地址管理");
        setBackAction();

        mIrc = findViewById(R.id.irc);
        mLoadingTip = findViewById(R.id.loadedTip);
        llAdd = findViewById(R.id.ll_add_address);
        mAdapter = new AddressAdapter(this, R.layout.setting_adapter_item_address);
        mIrc.setLayoutManager(new LinearLayoutManager(this));
        mIrc.setAdapter(mAdapter);
        mIrc.setOnRefreshListener(this);
        mIrc.setOnLoadMoreListener(this);

        memberId = SDKUtils.getUser().getMemberID();
        setListener();
    }

    @Override
    protected void initData(Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            isGoods = bundle.getBoolean(SAppConstant.IS_GOODS);
        }
        getMemberAddressList(true);
    }

    private void getMemberAddressList(final boolean isRefresh) {
        SApi.getDefault(SHostType.BASE_URL)
                .getMemberAddressList(MasterUtils.addSessionID(), memberId, currentPage, pageNumber, "1")
                .compose(SRxSchedulers.<SBaseResponse<AddressListEntity>>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse<AddressListEntity>>(mContext) {

                    @Override
                    public void onSubscribe(Disposable d) {
                        if (isRefresh) {
                            mLoadingTip.setLoadingTip(LoadingTip.LoadStatus.loading);
                        }
                    }

                    @Override
                    protected void onSuccess(SBaseResponse<AddressListEntity> response) {
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

    private void setListener() {
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object o, int position) {
                if (isGoods) {
                    AddressListEntity.DataInfo.RowsInfo info = (AddressListEntity.DataInfo.RowsInfo) o;
                    Bundle bundle = new Bundle();
                    bundle.putString(SAppConstant.MEMBER_ADDRESS_ID, info.getMemberAddressID());
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });

        llAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString(SAppConstant.ADDRESS_FLAG, Configure.CREATE.name());
                SystemUtils.jumpActivityForResult(mActivity, CreateAddressActivity.class, SAppConstant.ADDRESS_CODE, bundle);
            }
        });

        mAdapter.setOnEditAddressClickListener(new AddressAdapter.OnEditAddressClickListener() {
            @Override
            public void onEditClick(AddressListEntity.DataInfo.RowsInfo info) {
                Bundle bundle = new Bundle();
                bundle.putSerializable(SAppConstant.ADDRESS_INFO, info);
                bundle.putString(SAppConstant.ADDRESS_FLAG, Configure.UPDATE.name());
                SystemUtils.jumpActivityForResult(mActivity, CreateAddressActivity.class, SAppConstant.ADDRESS_CODE, bundle);
            }
        });
    }

    @Override
    public void onRefresh() {
        currentPage = 1;
        mAdapter.getPageBean().setRefresh(true);
        mIrc.setRefreshing(true);
        getMemberAddressList(true);
    }

    @Override
    public void onLoadMore(View loadMoreView) {
        mAdapter.getPageBean().setRefresh(false);
        mIrc.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
        getMemberAddressList(false);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SAppConstant.ADDRESS_CODE) {
            if (resultCode == RESULT_OK) {
                onRefresh();
            }
        }
    }
}
