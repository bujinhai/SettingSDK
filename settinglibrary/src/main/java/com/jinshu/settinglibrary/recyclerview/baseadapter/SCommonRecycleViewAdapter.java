package com.jinshu.settinglibrary.recyclerview.baseadapter;

import android.animation.Animator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

import com.jinshu.settinglibrary.recyclerview.animation.AlphaInAnimation;
import com.jinshu.settinglibrary.recyclerview.animation.BaseAnimation;
import com.jinshu.settinglibrary.recyclerview.bean.SPageBean;
import com.jinshu.settinglibrary.recyclerview.irc.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Update by bll on 19/8/28.
 */
public abstract class SCommonRecycleViewAdapter<T> extends RecyclerView.Adapter<SViewHolderHelper> implements SDataIO<T> {
    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas = new ArrayList<>();
    protected LayoutInflater mInflater;

    private OnItemClickListener mOnItemClickListener;


    //动画
    private int mLastPosition = -1;
    private boolean mOpenAnimationEnable = true;
    private Interpolator mInterpolator = new LinearInterpolator();
    private int mDuration = 300;
    private SPageBean pageBean;
    private BaseAnimation mSelectAnimation = new AlphaInAnimation();

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public SCommonRecycleViewAdapter(Context context, int layoutId) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        pageBean = new SPageBean();
    }

    public SCommonRecycleViewAdapter(Context context, int layoutId, List<T> mDatass) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = mDatass;
        pageBean = new SPageBean();
    }

    @Override
    public SViewHolderHelper onCreateViewHolder(final ViewGroup parent, int viewType) {
        SViewHolderHelper viewHolder = SViewHolderHelper.get(mContext, null, parent, mLayoutId, -1);
        return viewHolder;
    }

    protected int getPosition(RecyclerView.ViewHolder viewHolder) {
        return viewHolder.getAdapterPosition();
    }

    protected boolean isEnabled(int viewType)
    {
        return true;
    }


    protected void setListener(final SViewHolderHelper viewHolder, final int position) {

        viewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(v, mDatas.get(position), position);
                }
            }
        });


//        viewHolder.getConvertView().setOnLongClickListener(new View.OnLongClickListener()
//        {
//            @Override
//            public boolean onLongClick(View v)
//            {
//                if (mOnItemClickListener != null)
//                {
//                    int position = getPosition(viewHolder);
//                    return mOnItemClickListener.onItemLongClick(parent, v, mDatas.get(position), position);
//                }
//                return false;
//            }
//        });
    }

    @Override
    public void onBindViewHolder(SViewHolderHelper holder, int position) {
        holder.updatePosition(position);
        //添加动画
        addAnimation(holder);
        //添加点击事件
        setListener(holder, position);
        convert(holder, mDatas.get(position), position);
    }

    public abstract void convert(SViewHolderHelper helper, T t, int position);


    /**
     * add animation when you want to show time
     *
     * @param holder
     */
    public void addAnimation(RecyclerView.ViewHolder holder) {
        if (mOpenAnimationEnable) {
            if (holder.getLayoutPosition() > mLastPosition) {
                BaseAnimation animation = null;
                if (mSelectAnimation != null) {
                    animation = mSelectAnimation;
                }
                for (Animator anim : animation.getAnimators(holder.itemView)) {
                    startAnim(anim, holder.getLayoutPosition());
                    Log.d("animline", mLastPosition + "");
                }
                mLastPosition = holder.getLayoutPosition();
            }
        }
    }

    /**
     * set anim to start when loading
     *
     * @param anim
     * @param index
     */
    protected void startAnim(Animator anim, int index) {
        anim.setDuration(mDuration).start();
        anim.setInterpolator(mInterpolator);
    }

    /**
     * 设置动画
     *
     * @param animation ObjectAnimator
     */
    public void openLoadAnimation(BaseAnimation animation) {
        this.mOpenAnimationEnable = true;
        this.mSelectAnimation = animation;
    }

    /**
     * 关闭动画
     */
    public void closeLoadAnimation() {
        this.mOpenAnimationEnable = false;
    }


    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public void add(T elem) {
        mDatas.add(elem);
        notifyDataSetChanged();
    }

    @Override
    public void addAt(int location, T elem) {
        mDatas.add(location, elem);
        notifyDataSetChanged();
    }

    @Override
    public void addAll(List<T> elements) {
        mDatas.addAll(elements);
        notifyDataSetChanged();
    }

    @Override
    public void addAllAt(int location, List<T> elements) {
        mDatas.addAll(location, elements);
        notifyDataSetChanged();
    }

    @Override
    public void remove(T elem) {
        mDatas.remove(elem);
        notifyDataSetChanged();
    }

    @Override
    public void removeAt(int index) {
        mDatas.remove(index);
        notifyDataSetChanged();
    }

    @Override
    public void removeAll(List<T> elements) {
        mDatas.removeAll(elements);
        notifyDataSetChanged();
    }

    @Override
    public void clear() {
        if (mDatas != null && mDatas.size() > 0) {
            mDatas.clear();
            notifyDataSetChanged();
        }
    }

    @Override
    public void replace(T oldElem, T newElem) {
        replaceAt(mDatas.indexOf(oldElem), newElem);
    }

    @Override
    public void replaceAt(int index, T elem) {
        mDatas.set(index, elem);
        notifyDataSetChanged();
    }

    @Override
    public void replaceAll(List<T> elements) {
        if (mDatas.size() > 0) {
            mDatas.clear();
        }
        mDatas.addAll(elements);
        notifyDataSetChanged();
    }

    @Override
    public T get(int position) {
        if (position >= mDatas.size())
            return null;
        return mDatas.get(position);
    }

    @Override
    public List<T> getAll() {
        return mDatas;
    }

    @Override
    public int getSize() {
        return mDatas.size();
    }

    @Override
    public boolean contains(T elem) {
        return mDatas.contains(elem);
    }

    /**
     * 分页
     *
     * @return
     */
    public SPageBean getPageBean() {
        return pageBean;
    }
}
