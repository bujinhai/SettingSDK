package com.jinshu.settinglibrary.adapter;

import android.content.Context;
import android.view.View;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.entity.CardListEntity;
import com.jinshu.settinglibrary.recyclerview.baseadapter.SCommonRecycleViewAdapter;
import com.jinshu.settinglibrary.recyclerview.baseadapter.SViewHolderHelper;

/**
 * Create on 2019/10/17 16:27 by bll
 */


public class CardListAdapter extends SCommonRecycleViewAdapter<CardListEntity.DataInfo.RowsInfo> {

    private OnBankCardClickListener mListener;

    public CardListAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(SViewHolderHelper helper, final CardListEntity.DataInfo.RowsInfo info, int position) {

        helper.setText(R.id.tv_card_name, info.getBankName());
        helper.setText(R.id.tv_user_name, info.getName());
        helper.setCircleImageUrl(R.id.iv_card_brand, info.getBankListImage());
        String str;
        if (info.getCardCode().length() > 4) {
            str = "**** **** **** " + info.getCardCode().substring(info.getCardCode().length() - 4, info.getCardCode().length());
        } else {
            str = "**** **** **** " + info.getCardCode();
        }
        helper.setText(R.id.tv_card_number, str);

        if (info.getIsDefault() == 1) {
            helper.setChecked(R.id.cb_default_card, true);
        } else {
            helper.setChecked(R.id.cb_default_card, false);
        }

        helper.setOnClickListener(R.id.cb_default_card, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onCardDefaultClick(info);
                }
            }
        });

        helper.setOnClickListener(R.id.iv_edit_bank_card, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onCardEditClick(info);
                }
            }
        });
    }


    public interface OnBankCardClickListener {
        void onCardEditClick(CardListEntity.DataInfo.RowsInfo info);

        void onCardDefaultClick(CardListEntity.DataInfo.RowsInfo info);
    }

    public void setOnCardClickListener(OnBankCardClickListener listener) {
        this.mListener = listener;
    }
}
