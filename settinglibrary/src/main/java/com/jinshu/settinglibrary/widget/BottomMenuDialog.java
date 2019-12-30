package com.jinshu.settinglibrary.widget;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.jinshu.settinglibrary.R;
import com.luck.picture.lib.tools.ScreenUtils;

/**
 * Create on 2019/10/13 17:24 by bll
 */


public abstract class BottomMenuDialog extends DialogFragment {

    protected View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window = getDialog().getWindow();
        if (window != null){
            //去掉dialog默认的padding
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams lp = window.getAttributes();
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = ScreenUtils.dip2px(getContext(), 400);
            //设置dialog的位置在底部
            lp.gravity = Gravity.BOTTOM;
            //设置dialog的动画
            lp.windowAnimations = R.style.BottomDialogAnimation;
            window.setAttributes(lp);
            window.setBackgroundDrawable(new ColorDrawable());
        }

        if (rootView == null) {
            rootView = inflater.inflate(getLayoutResource(), container, false);
        }
        getDialog().setCanceledOnTouchOutside(false);
        initView(savedInstanceState);
        initData(savedInstanceState);
        return rootView;
    }

    /**
     * 获取布局文件
     */
    protected abstract int getLayoutResource();

    /**
     * 初始化view
     */
    protected abstract void initView(@Nullable Bundle savedInstanceState);

    /**
     * 初始化数据
     */
    protected abstract void initData(@Nullable Bundle savedInstanceState);

    /**
     * 绑定view
     */
    protected <T extends View> T bindView(int nResId) {
        return (T) rootView.findViewById(nResId);
    }

}
