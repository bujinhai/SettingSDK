package com.jinshu.settinglibrary.base.baserx;

import android.app.Activity;
import android.content.Context;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.utils.NetUtils;
import com.jinshu.settinglibrary.utils.SDKUtils;
import com.jinshu.settinglibrary.widget.LoadingDialog;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;


/**
 * des:订阅封装
 * Created by xsf
 * on 2016.09.10:16
 */

/********************使用例子********************/
/*_apiService.login(mobile, verifyCode)
        .//省略
        .subscribe(new SRxSubscriber<User user>(mContext,false) {
@Override
public void _onNext(User user) {
        // 处理user
        }

@Override
public void _onError(String msg) {
        ToastUtil.showShort(mActivity, msg);
        });*/
public abstract class SRxSubscriber<T> implements Observer<T> {

    private Context mContext;
    private String msg;
    private boolean showDialog = true;

    /**
     * 是否显示浮动dialog
     */
    public void showDialog() {
        this.showDialog = true;
    }

    public void hideDialog() {
        this.showDialog = true;
    }

    public SRxSubscriber(Context context, String msg, boolean showDialog) {
        this.mContext = context;
        this.msg = msg;
        this.showDialog = showDialog;
    }

    public SRxSubscriber(Context context) {
        this(context, SDKUtils.getAppContext().getString(R.string.setting_loading), true);
    }

    public SRxSubscriber(Context context, boolean showDialog) {
        this(context, SDKUtils.getAppContext().getString(R.string.setting_loading), showDialog);
    }

    @Override
    public void onComplete() {
        if (showDialog)
            LoadingDialog.cancelDialogForLoading();
    }

    @Override
    public void onSubscribe(Disposable d) {
        if (showDialog) {
            try {
                LoadingDialog.showDialogForLoading((Activity) mContext, msg, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
        if (showDialog)
            LoadingDialog.cancelDialogForLoading();
    }

    @Override
    public void onError(Throwable e) {
        if (showDialog) {
            LoadingDialog.cancelDialogForLoading();
        }
        e.printStackTrace();
        if (!NetUtils.isNetConnected(SDKUtils.getAppContext())) {
            //网络
            onFail(SDKUtils.getAppContext().getString(R.string.setting_no_net));
        } else if (e instanceof HttpException) {
            onFail("正在链接服务器，请稍候...");
        } else if (e instanceof RuntimeException) {
            onFail(e.getMessage());
        } else {
            //其它
            onFail("正在链接服务器，请稍候...");
        }
    }

    protected abstract void onSuccess(T t);

    protected abstract void onFail(String message);

}
