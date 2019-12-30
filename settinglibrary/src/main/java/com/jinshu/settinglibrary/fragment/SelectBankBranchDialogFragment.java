package com.jinshu.settinglibrary.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.adapter.BankBranchListAdapter;
import com.jinshu.settinglibrary.api.SApi;
import com.jinshu.settinglibrary.api.SHostType;
import com.jinshu.settinglibrary.app.SAppConstant;
import com.jinshu.settinglibrary.base.basebean.SBaseResponse;
import com.jinshu.settinglibrary.base.baserx.SRxSchedulers;
import com.jinshu.settinglibrary.base.baserx.SRxSubscriber;
import com.jinshu.settinglibrary.entity.BankBranchListEntity;
import com.jinshu.settinglibrary.recyclerview.irc.OnItemClickListener;
import com.jinshu.settinglibrary.utils.MasterUtils;
import com.jinshu.settinglibrary.utils.ToastUtil;
import com.jinshu.settinglibrary.widget.BottomMenuDialog;

/**
 * Create on 2019/10/21 17:59 by bll
 */


public class SelectBankBranchDialogFragment extends BottomMenuDialog {

    private BankBranchListAdapter mAdapter;
    private String parentID, cityID;
    private ImageView ivDelete;

    public static SelectBankBranchDialogFragment newInstance(String parentID, String cityID) {
        Bundle args = new Bundle();
        args.putString(SAppConstant.BANK_PARENT_ID, parentID);
        args.putString(SAppConstant.CITY_ID, cityID);
        SelectBankBranchDialogFragment dialogFragment = new SelectBankBranchDialogFragment();
        dialogFragment.setArguments(args);
        return dialogFragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.setting_fragment_dialog_select_bank;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        RecyclerView mRecyclerView = bindView(R.id.recycler_view);
        ivDelete = bindView(R.id.iv_delete);
        mAdapter = new BankBranchListAdapter(getContext(), R.layout.setting_adapter_item_bank_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);
        setListener();
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        parentID = bundle.getString(SAppConstant.BANK_PARENT_ID);
        cityID = bundle.getString(SAppConstant.CITY_ID);
        getBankList();
    }

    private void getBankList() {
        SApi.getDefault(SHostType.BASE_URL)
                .getBankList(MasterUtils.addSessionID(), 1, 10000,
                        parentID, cityID, "1", "1")
                .compose(SRxSchedulers.<SBaseResponse<BankBranchListEntity>>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse<BankBranchListEntity>>(getContext()) {
                    @Override
                    protected void onSuccess(SBaseResponse<BankBranchListEntity> response) {
                        if (response.header.code != 0) {
                            ToastUtil.showShort(response.header.msg);
                            return;
                        }
                        if (response.body == null || response.body.getData() == null) {
                            return;
                        }
                        mAdapter.replaceAll(response.body.getData().getRows());
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }

    private void setListener() {
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object o, int position) {
                BankBranchListEntity.DataInfo.RowsInfo info = (BankBranchListEntity.DataInfo.RowsInfo) o;
                if (mListener != null) {
                    mListener.onSelectBankBranchClick(info);
                }
                dismiss();
            }
        });

        ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }


    public interface OnSelectBankBranchFinishClickListener {
        void onSelectBankBranchClick(BankBranchListEntity.DataInfo.RowsInfo info);
    }

    private OnSelectBankBranchFinishClickListener mListener;

    public void setOnSelectBankFinishClickListener(OnSelectBankBranchFinishClickListener listener) {
        this.mListener = listener;
    }
}
