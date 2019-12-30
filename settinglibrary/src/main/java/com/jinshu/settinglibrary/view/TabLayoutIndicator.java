package com.jinshu.settinglibrary.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jinshu.settinglibrary.R;
import com.luck.picture.lib.tools.ScreenUtils;

import java.lang.reflect.Field;

/**
 * @author bll
 * @date 2018/4/20  13:47
 * @describe 自定义TabLayout实现线的宽度和字的宽度一样（自定义线的颜色）
 */


public class TabLayoutIndicator extends TabLayout {

    private float tabMargin;
    private boolean matchParent;


    public TabLayoutIndicator(Context context) {
        this(context, null);
    }

    public TabLayoutIndicator(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TabLayoutIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs == null) {
            tabMargin = ScreenUtils.dip2px(context, 10);
            return;
        }
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.TabLayoutIndicator);
        tabMargin = a.getDimension(R.styleable.TabLayoutIndicator_tabMargin, ScreenUtils.dip2px(context, 10));
        matchParent = a.getBoolean(R.styleable.TabLayoutIndicator_matchParent, false);
        a.recycle();
    }

    @Override
    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        super.setupWithViewPager(viewPager);//了解源码得知 线的宽度是根据 tabView的宽度来设置的
        //运用lambda表达式
        post(new Runnable() {
            @Override
            public void run() {
                try {
                    //拿到tabLayout的mTabStrip属性
                    Field mTabStripField = TabLayout.class.getDeclaredField("mTabStrip");
                    mTabStripField.setAccessible(true);

                    LinearLayout mTabStrip = (LinearLayout) mTabStripField.get(TabLayoutIndicator.this);

                    final int tabCount = mTabStrip.getChildCount();
                    for (int i = 0; i < tabCount; i++) {
                        final View tabView = mTabStrip.getChildAt(i);

                        //拿到tabView的mTextView属性
                        Field mTextViewField = tabView.getClass().getDeclaredField("mTextView");
                        mTextViewField.setAccessible(true);

                        TextView mTextView = (TextView) mTextViewField.get(tabView);

                        tabView.setPadding(0, 0, 0, 0);

                        //因为我想要的效果是   字多宽线就多宽，所以测量mTextView的宽度
                        int width;
                        width = mTextView.getWidth();
                        if (width == 0) {
                            mTextView.measure(0, 0);
                            width = mTextView.getMeasuredWidth();
                        }

                        //设置tab左右间距为10dp  注意这里不能使用Padding 因为源码中线的宽度是根据 tabView的宽度来设置的
                        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tabView.getLayoutParams();
                        params.width = width;
                        if (matchParent) {
                            int margin = (int) ((getWidth() / (float) tabCount - width) / 2);
                            params.leftMargin = margin;
                            params.rightMargin = margin;
                            tabView.post(new Runnable() {
                                @Override
                                public void run() {
                                    LinearLayout.LayoutParams params1 = (LinearLayout.LayoutParams) tabView.getLayoutParams();
                                    if (tabView != null && tabView.getWidth() != getWidth()) {
                                        int margin1 = (int) ((getWidth() / (float) tabCount - params1.width) / 2);
                                        params1.leftMargin = margin1;
                                        params1.rightMargin = margin1;
                                        tabView.setLayoutParams(params1);
                                        tabView.invalidate();
                                    }
                                }
                            });
                        } else {
                            params.leftMargin = (int) tabMargin;
                            params.rightMargin = (int) tabMargin;
                        }
                        tabView.setLayoutParams(params);

                        tabView.invalidate();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
