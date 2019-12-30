package com.jinshu.settinglibrary.adapter;

import android.content.Context;
import android.view.View;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.entity.AddressListEntity;
import com.jinshu.settinglibrary.recyclerview.baseadapter.SCommonRecycleViewAdapter;
import com.jinshu.settinglibrary.recyclerview.baseadapter.SViewHolderHelper;

/**
 * Create on 2019/10/9 17:23 by bll
 */

public class AddressAdapter extends SCommonRecycleViewAdapter<AddressListEntity.DataInfo.RowsInfo> {

    private OnEditAddressClickListener mListener;

    public AddressAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(SViewHolderHelper helper, final AddressListEntity.DataInfo.RowsInfo info, int position) {

        helper.setText(R.id.tv_address_name, info.getName());
        helper.setText(R.id.tv_user_name, info.getContactName());
        helper.setText(R.id.tv_user_phone, info.getPhone());
        if (info.getIsDefault() == 1) {
            helper.setVisible(R.id.tv_default, true);
        } else {
            helper.setVisible(R.id.tv_default, false);
        }

        if (info.getAddType() == 1) {
            helper.setVisible(R.id.tv_sign, true);
            helper.setText(R.id.tv_sign, "家");
        } else if (info.getAddType() == 2) {
            helper.setVisible(R.id.tv_sign, true);
            helper.setText(R.id.tv_sign, "公司");
        } else if (info.getAddType() == 3) {
            helper.setVisible(R.id.tv_sign, true);
            helper.setText(R.id.tv_sign, "学校");
        } else {
            helper.setVisible(R.id.tv_sign, false);
        }

        helper.setOnClickListener(R.id.iv_edit_address, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onEditClick(info);
                }
            }
        });
    }

    public interface OnEditAddressClickListener {
        void onEditClick(AddressListEntity.DataInfo.RowsInfo info);
    }

    public void setOnEditAddressClickListener(OnEditAddressClickListener listener) {
        mListener = listener;
    }
}
