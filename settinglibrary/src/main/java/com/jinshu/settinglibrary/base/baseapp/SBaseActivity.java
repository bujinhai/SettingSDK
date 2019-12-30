package com.jinshu.settinglibrary.base.baseapp;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.base.baserx.SRxManager;
import com.jinshu.settinglibrary.utils.ToastUtil;
import com.jinshu.settinglibrary.widget.CommonTitleBar;


/**
 * 基类
 */

public abstract class SBaseActivity extends AppCompatActivity {

    public Context mContext;
    public Activity mActivity;
    public SRxManager mRxManager;
    private boolean isConfigChange = false;
    private CommonTitleBar mTitleBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isConfigChange = false;
        mRxManager = new SRxManager();
        doBeforeSetcontentView();
        setContentView(getLayoutId());
        mContext = this;
        mActivity = this;
        this.initView(getIntent(), savedInstanceState);
        this.initData(getIntent());
    }

    /**
     * 设置layout前配置
     */
    private void doBeforeSetcontentView() {
        // 把actvity放到application栈中管理
        SAppManager.getAppManager().addActivity(this);
        // 无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 设置竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    /**
     * 获取布局
     */
    public abstract int getLayoutId();


    /**
     * 初始化view
     */
    public abstract void initView(Intent intent, @Nullable Bundle savedInstanceState);

    /**
     * 请求数据
     */
    protected void initData(Intent intent) {

    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        isConfigChange = true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mRxManager != null) {
            mRxManager.clear();
        }
        if (!isConfigChange) {
            SAppManager.getAppManager().finishActivity(this);
        }
        ToastUtil.cancelToast();
    }

    public CommonTitleBar getTitleBar() {
        if (mTitleBar == null) {
            View barView = findViewById(R.id.tb);
            if (barView instanceof CommonTitleBar) {
                mTitleBar = (CommonTitleBar) barView;
            }
        }
        return mTitleBar;
    }

    public void setBackAction() {
        getTitleBar().setOnBackListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void setTitle(String title) {
        getTitleBar().setTitleText(title);
    }

    public void setIvBackVisible(boolean visible) {
        getTitleBar().setBackVisibility(visible);
    }

    public void setTvRightTitleVisible(boolean visible) {
        getTitleBar().setRightTitleVisibility(visible);
    }

    public void setRightTitle(String text) {
        getTitleBar().setRightTitle(text);
    }

    public void setRightTitleListener(View.OnClickListener listener) {
        getTitleBar().setOnRightTextListener(listener);
    }

    public void setRightImgVisible(boolean visible) {
        getTitleBar().setRightImagVisibility(visible);
    }

    public void setRightImg(int id) {
        getTitleBar().setRightImagSrc(id);
    }

    public void setRightImgListener(View.OnClickListener listener) {
        getTitleBar().setOnRightImgListener(listener);
    }

}
