package com.jinshu.settinglibrary.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jinshu.settinglibrary.utils.SDKUtils;

/**
 * Create on 2019/7/19 14:14 by bll
 */


public class PatrolDecoration extends RecyclerView.ItemDecoration {

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        if (position % 3 == 0) {
            outRect.right = dip2px(2f);
        } else if (position % 3 == 1) {
            outRect.left = dip2px(2f);
            outRect.right = dip2px(2f);
        } else if (position % 3 == 2) {
            outRect.left = dip2px(2f);
        }

        if (position / 3 == 0) {
            outRect.bottom = dip2px(4f);
        }
    }

    /**
     * 将dip或dp值转换为px值，保证尺寸大小不变
     *
     * @param dipValue （DisplayMetrics类中属性density）
     * @return
     */
    public static int dip2px(float dipValue) {
        final float scale = SDKUtils.getAppContext().getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}
