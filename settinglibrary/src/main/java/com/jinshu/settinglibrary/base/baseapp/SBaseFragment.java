package com.jinshu.settinglibrary.base.baseapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.base.baserx.SRxManager;
import com.jinshu.settinglibrary.utils.ToastUtil;
import com.jinshu.settinglibrary.widget.CommonTitleBar;


/**
 * des:基类fragment
 * Created by xsf
 * on 2016.07.12:38
 */

public abstract class SBaseFragment extends Fragment {
    protected View rootView;
    public SRxManager mRxManager;
    private CommonTitleBar mTitleBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null)
            rootView = inflater.inflate(getLayoutResource(), container, false);
        mRxManager = new SRxManager();
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
     * 请求数据
     */
    protected abstract void initData(@Nullable Bundle savedInstanceState);

    protected <T extends View> T bindView(int nResId) {
        return (T) rootView.findViewById(nResId);
    }

    protected <T extends View> T bindView(View pView, int nResId) {
        return (T) pView.findViewById(nResId);
    }


    @Nullable
    public FragmentManager getChildSafeFragmentManager() {
        if (this.getContext() == null) {
            return null;
        }
        return this.getChildFragmentManager();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ToastUtil.cancelToast();
    }

    public CommonTitleBar getTitleBar() {
        if (mTitleBar == null) {
            View barView = bindView(R.id.tb);
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
                getActivity().finish();
            }
        });
    }

    public void setTitle(String title) {
        getTitleBar().setTitleText(title);
    }

    public void setIvBackVisible(boolean visible) {
        getTitleBar().setBackVisibility(visible);
    }

    public void setLeftImg(int id) {
        getTitleBar().setLeftImagSrc(id);
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
