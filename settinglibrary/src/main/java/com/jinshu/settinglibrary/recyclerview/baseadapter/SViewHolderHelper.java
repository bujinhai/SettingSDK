package com.jinshu.settinglibrary.recyclerview.baseadapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.util.Linkify;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.jinshu.settinglibrary.utils.ImageLoaderUtils;

import java.io.File;

public class SViewHolderHelper extends RecyclerView.ViewHolder {
    private SparseArray<View> mViews;
    private int mPosition;
    private View mConvertView;
    private Context mContext;
    private int mLayoutId;

    public SViewHolderHelper(Context context, View itemView, ViewGroup parent, int position) {
        super(itemView);
        mContext = context;
        mConvertView = itemView;
        mPosition = position;
        mViews = new SparseArray<View>();
        mConvertView.setTag(this);

    }


    public static SViewHolderHelper get(Context context, View convertView,
                                        ViewGroup parent, int layoutId, int position) {
        if (convertView == null) {
            View itemView = LayoutInflater.from(context).inflate(layoutId, parent,
                    false);
            SViewHolderHelper holder = new SViewHolderHelper(context, itemView, parent, position);
            holder.mLayoutId = layoutId;
            return holder;
        } else {
            SViewHolderHelper holder = (SViewHolderHelper) convertView.getTag();
            holder.mPosition = position;
            return holder;
        }
    }


    /**
     * 通过viewId获取控件
     *
     * @param viewId
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getConvertView() {
        return mConvertView;
    }

    /**
     * 设置TextView的值
     *
     * @param viewId
     * @param text
     * @return
     */
    public SViewHolderHelper setText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    public SViewHolderHelper setImageResource(int viewId, int resId) {
        ImageView view = getView(viewId);
        view.setImageResource(resId);
        return this;
    }

    public SViewHolderHelper setImageView(int viewId, String url, int nDeafultImage) {
        ImageView view = getView(viewId);
        if (view != null) {
            view.setVisibility(View.VISIBLE);
            if (url != null) {
                setImageUrl(viewId, url);
            } else {
                view.setImageResource(nDeafultImage);
            }
        }
        return this;
    }

    public SViewHolderHelper setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bitmap);
        return this;
    }

    public SViewHolderHelper setImageUrl(int viewId, String url) {
        ImageView view = getView(viewId);
        ImageLoaderUtils.display(mContext, view, url);
        return this;
    }

    public SViewHolderHelper setCircleImageUrl(int viewId, String url) {
        ImageView view = getView(viewId);
        ImageLoaderUtils.displayCirclePhoto(mContext, view, url);
        return this;
    }

    public SViewHolderHelper setBigImageUrl(int viewId, String url) {
        ImageView view = getView(viewId);
        ImageLoaderUtils.displayBigPhoto(mContext, view, url);
        return this;
    }

    public SViewHolderHelper setSmallImageUrl(int viewId, String url) {
        ImageView view = getView(viewId);
        ImageLoaderUtils.displaySmallPhoto(mContext, view, url);
        return this;
    }

    public SViewHolderHelper setImageFile(int viewId, File url) {
        ImageView view = getView(viewId);
        ImageLoaderUtils.display(mContext, view, url);
        return this;
    }

    public SViewHolderHelper setImageDrawable(int viewId, Drawable drawable) {
        ImageView view = getView(viewId);
        view.setImageDrawable(drawable);
        return this;
    }

    public SViewHolderHelper setBackgroundColor(int viewId, int color) {
        View view = getView(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    public SViewHolderHelper setBackgroundRes(int viewId, int backgroundRes) {
        View view = getView(viewId);
        view.setBackgroundResource(backgroundRes);
        return this;
    }

    public SViewHolderHelper setTextColor(int viewId, int textColor) {
        TextView view = getView(viewId);
        view.setTextColor(textColor);
        return this;
    }

    public SViewHolderHelper setTextColorRes(int viewId, int textColorRes) {
        TextView view = getView(viewId);
        view.setTextColor(mContext.getResources().getColor(textColorRes));
        return this;
    }

    @SuppressLint("NewApi")
    public SViewHolderHelper setAlpha(int viewId, float value) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getView(viewId).setAlpha(value);
        } else {
            // Pre-honeycomb hack to set Alpha value
            AlphaAnimation alpha = new AlphaAnimation(value, value);
            alpha.setDuration(0);
            alpha.setFillAfter(true);
            getView(viewId).startAnimation(alpha);
        }
        return this;
    }

    public SViewHolderHelper setVisible(int viewId, boolean visible) {
        View view = getView(viewId);
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
        return this;
    }

    public SViewHolderHelper linkify(int viewId) {
        TextView view = getView(viewId);
        Linkify.addLinks(view, Linkify.ALL);
        return this;
    }

    public SViewHolderHelper setTypeface(Typeface typeface, int... viewIds) {
        for (int viewId : viewIds) {
            TextView view = getView(viewId);
            view.setTypeface(typeface);
            view.setPaintFlags(view.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
        }
        return this;
    }

    public SViewHolderHelper setProgress(int viewId, int progress) {
        ProgressBar view = getView(viewId);
        view.setProgress(progress);
        return this;
    }

    public SViewHolderHelper setProgress(int viewId, int progress, int max) {
        ProgressBar view = getView(viewId);
        view.setMax(max);
        view.setProgress(progress);
        return this;
    }

    public SViewHolderHelper setMax(int viewId, int max) {
        ProgressBar view = getView(viewId);
        view.setMax(max);
        return this;
    }

    public SViewHolderHelper setRating(int viewId, float rating) {
        RatingBar view = getView(viewId);
        view.setRating(rating);
        return this;
    }

    public SViewHolderHelper setRating(int viewId, float rating, int max) {
        RatingBar view = getView(viewId);
        view.setMax(max);
        view.setRating(rating);
        return this;
    }

    public SViewHolderHelper setTag(int viewId, Object tag) {
        View view = getView(viewId);
        view.setTag(tag);
        return this;
    }

    public SViewHolderHelper setTag(int viewId, int key, Object tag) {
        View view = getView(viewId);
        view.setTag(key, tag);
        return this;
    }

    public SViewHolderHelper setChecked(int viewId, boolean checked) {
        Checkable view = (Checkable) getView(viewId);
        view.setChecked(checked);
        return this;
    }

    /**
     * 关于事件的
     */
    public SViewHolderHelper setOnClickListener(int viewId,
                                                View.OnClickListener listener) {
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }

    public SViewHolderHelper setOnTouchListener(int viewId,
                                                View.OnTouchListener listener) {
        View view = getView(viewId);
        view.setOnTouchListener(listener);
        return this;
    }

    public SViewHolderHelper setOnLongClickListener(int viewId,
                                                    View.OnLongClickListener listener) {
        View view = getView(viewId);
        view.setOnLongClickListener(listener);
        return this;
    }

    public void updatePosition(int position) {
        mPosition = position;
    }

    public int getLayoutId() {
        return mLayoutId;
    }
}
