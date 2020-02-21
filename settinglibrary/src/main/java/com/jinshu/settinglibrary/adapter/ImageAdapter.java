package com.jinshu.settinglibrary.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.utils.ImageLoaderUtils;
import com.luck.picture.lib.entity.LocalMedia;

import java.util.ArrayList;
import java.util.List;

/**
 * Create on 2019/7/18 16:48 by bll
 */


public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    public static final int TYPE_CAMERA = 1;
    public static final int TYPE_PICTURE = 2;

    private Context mContext;
    private LayoutInflater mInflater;
    private List<LocalMedia> mediaList = new ArrayList<>();

    /**
     * 点击添加图片跳转
     */
    private onAddPicClickListener mOnAddPicClickListener;

    public interface onAddPicClickListener {
        void onAddPicClick();
    }

    public ImageAdapter(Context mContext, onAddPicClickListener mOnAddPicClickListener) {
        this.mContext = mContext;
        this.mInflater = LayoutInflater.from(mContext);
        this.mOnAddPicClickListener = mOnAddPicClickListener;
    }

    @Override
    public int getItemCount() {
        if (mediaList.size() < 3) {
            return mediaList.size() + 1;
        } else {
            return mediaList.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (isShowAddItem(position)) {
            return TYPE_CAMERA;
        } else {
            return TYPE_PICTURE;
        }
    }

    private boolean isShowAddItem(int position) {
        int size = mediaList.size() == 0 ? 0 : mediaList.size();
        return position == size;
    }


    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.setting_adapter_item_image, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ImageViewHolder holder, final int position) {
        if (getItemViewType(position) == TYPE_CAMERA) {
            holder.ivImage.setImageResource(R.drawable.setting_add_photo);
            holder.ivImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnAddPicClickListener != null) {
                        mOnAddPicClickListener.onAddPicClick();
                    }
                }
            });
            holder.llDel.setVisibility(View.GONE);
        } else {
            holder.llDel.setVisibility(View.VISIBLE);
            holder.llDel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int index = holder.getAdapterPosition();
                    if (index != RecyclerView.NO_POSITION) {
                        mediaList.remove(index);
                        notifyItemRemoved(index);
                        notifyItemRangeChanged(index, mediaList.size());
                    }
                }
            });
            LocalMedia media = mediaList.get(position);
            ImageLoaderUtils.display(mContext, holder.ivImage, media.getCompressPath());
        }

        if (mListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onImageItemClick(position, v);
                }
            });
        }
    }

    public void setList(List<LocalMedia> selectList) {
        mediaList = selectList;
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivImage;
        private LinearLayout llDel;

        public ImageViewHolder(View itemView) {
            super(itemView);

            ivImage = itemView.findViewById(R.id.fiv);
            llDel = itemView.findViewById(R.id.ll_del);
        }
    }

    private OnImageItemClickListener mListener;

    public interface OnImageItemClickListener {
        void onImageItemClick(int pos, View v);
    }

    public void setOnImageClickListener(OnImageItemClickListener listener) {
        mListener = listener;
    }

}
