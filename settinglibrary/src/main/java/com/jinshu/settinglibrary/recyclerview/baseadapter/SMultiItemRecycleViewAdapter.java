package com.jinshu.settinglibrary.recyclerview.baseadapter;

import android.content.Context;
import android.view.ViewGroup;

public abstract class SMultiItemRecycleViewAdapter<T> extends SCommonRecycleViewAdapter<T> {

    protected SMultiItemTypeSupport<T> mMultiItemTypeSupport;

    public SMultiItemRecycleViewAdapter(Context context, SMultiItemTypeSupport<T> multiItemTypeSupport) {
        super(context, -1);
        mMultiItemTypeSupport = multiItemTypeSupport;

        if (mMultiItemTypeSupport == null)
            throw new IllegalArgumentException("the mMultiItemTypeSupport can not be null.");
    }

    @Override
    public int getItemViewType(int position) {
        if (mMultiItemTypeSupport != null)
            return mMultiItemTypeSupport.getItemViewType(position, mDatas.get(position));
        return super.getItemViewType(position);
    }

    @Override
    public SViewHolderHelper onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mMultiItemTypeSupport == null) return super.onCreateViewHolder(parent, viewType);

        int layoutId = mMultiItemTypeSupport.getLayoutId(viewType);
        SViewHolderHelper holder = SViewHolderHelper.get(mContext, null, parent, layoutId, -1);
//        setListener(parent, holder, viewType);
        return holder;
    }

}
