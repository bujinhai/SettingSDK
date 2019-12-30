package com.jinshu.settinglibrary.adapter;

import android.content.Context;
import android.view.View;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.entity.InvoiceEntity;
import com.jinshu.settinglibrary.recyclerview.baseadapter.SCommonRecycleViewAdapter;
import com.jinshu.settinglibrary.recyclerview.baseadapter.SViewHolderHelper;

/**
 * Create on 2019/10/29 13:40 by bll
 */


public class InvoiceAdapter extends SCommonRecycleViewAdapter<InvoiceEntity.DataInfo.RowsInfo> {

    public InvoiceAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(SViewHolderHelper helper, final InvoiceEntity.DataInfo.RowsInfo info, int position) {
        if (info.getIsDefault() == 1) {
            helper.setVisible(R.id.tv_default, true);
        } else {
            helper.setVisible(R.id.tv_default, false);
        }
        if (info.getInvoiceType() == 1) {
            helper.setText(R.id.tv_name, info.getName());
            helper.setText(R.id.tv_tax_type, info.getTaxType() == 1 ? "普通发票" : "专用发票");
        } else if (info.getInvoiceType() == 2) {
            helper.setText(R.id.tv_company_name, info.getName());
            helper.setText(R.id.tv_tax_type, info.getTaxType() == 1 ? "普通发票" : "专用发票");
            helper.setText(R.id.tv_register_address, info.getAddress());
        }

        helper.setOnClickListener(R.id.tv_edit, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onEdit(info);
                }
            }
        });

        helper.setOnClickListener(R.id.tv_delete, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onDelete(info);
                }
            }
        });
    }

    private OnInvoiceClickListener mListener;

    public interface OnInvoiceClickListener {

        void onDelete(InvoiceEntity.DataInfo.RowsInfo info);

        void onEdit(InvoiceEntity.DataInfo.RowsInfo info);

    }

    public void setOnInvoiceClickListener(OnInvoiceClickListener listener) {
        mListener = listener;
    }
}
