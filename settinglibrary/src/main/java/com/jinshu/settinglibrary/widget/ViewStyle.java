package com.jinshu.settinglibrary.widget;

import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import android.widget.Button;

import com.jinshu.settinglibrary.entity.BtnStyleEntity;
import com.jinshu.settinglibrary.utils.SDKUtils;

/**
 * Create on 2019/10/23 17:57 by bll
 */


public class ViewStyle {

    public static void setBtnStyle(Button button) {
        BtnStyleEntity entity = SDKUtils.getBtnEntity();
        if (entity != null) {
            //字体颜色
            button.setTextColor(entity.getBtnTextColor());
            //字体大小
            button.setTextSize(entity.getBtnTextSize());
            //按钮高度
            ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
            layoutParams.height = entity.getBtnHeight();
            button.setLayoutParams(layoutParams);
            //按钮背景颜色，按钮圆角
            GradientDrawable drawable = new GradientDrawable();
            drawable.setShape(GradientDrawable.RECTANGLE);
            drawable.setCornerRadius(entity.getBtnCorner());
            drawable.setColor(entity.getBtnBgColor());
            button.setBackground(drawable);
        }
    }
}
