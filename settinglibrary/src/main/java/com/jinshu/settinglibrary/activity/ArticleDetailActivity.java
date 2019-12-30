package com.jinshu.settinglibrary.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.api.SApi;
import com.jinshu.settinglibrary.api.SHostType;
import com.jinshu.settinglibrary.app.SAppConstant;
import com.jinshu.settinglibrary.base.baseapp.SBaseActivity;
import com.jinshu.settinglibrary.base.baserx.SRxHelper;
import com.jinshu.settinglibrary.base.baserx.SRxSchedulers;
import com.jinshu.settinglibrary.base.baserx.SRxSubscriber;
import com.jinshu.settinglibrary.entity.ArticleSimpleEntity;
import com.jinshu.settinglibrary.entity.Configure;
import com.jinshu.settinglibrary.utils.NetUtils;
import com.jinshu.settinglibrary.utils.ToastUtil;
import com.jinshu.settinglibrary.widget.LoadingDialog;

/**
 * Create on 2019/11/5 15:34 by bll
 */


public class ArticleDetailActivity extends SBaseActivity {

    private WebView mWebView;
    private String articleID;
    private String articleType;

    @Override
    public int getLayoutId() {
        return R.layout.setting_activity_article_detail;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        setBackAction();
        mWebView = findViewById(R.id.web_view);
        mWebView.setWebViewClient(new MyWebViewClient());
        setWebView();
    }

    private void setWebView() {
        WebSettings settings = mWebView.getSettings();
        //缓存设置
        if (NetUtils.isNetConnected(getApplicationContext())) {
            settings.setCacheMode(WebSettings.LOAD_DEFAULT);//根据cache-control决定是否从网络上取数据。
        } else {
            settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);//没网，则从本地获取，即离线加载
        }
        //设置自适应屏幕，两者合用
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        //支持缩放，默认为true
        settings.setSupportZoom(true);
        // 设置默认字体大小
        settings.setDefaultFontSize(40);
        //支持自动加载图片
        settings.setLoadsImagesAutomatically(true);

    }

    @Override
    protected void initData(Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            articleID = bundle.getString(SAppConstant.ARTICLEID);
            articleType = bundle.getString(SAppConstant.ARTICLE_TYPE);
            if (Configure.QUESTION.name().equals(articleType)) {
                setTitle("问题详情");
            } else {
                setTitle("帮助详情");
            }
        }

        getArticleSimpleDetail();
    }

    private void getArticleSimpleDetail() {
        SApi.getDefault(SHostType.BASE_URL)
                .getArticleSimpleDetail(articleID)
                .compose(SRxHelper.<ArticleSimpleEntity>handleResult())
                .compose(SRxSchedulers.<ArticleSimpleEntity>io_main())
                .subscribe(new SRxSubscriber<ArticleSimpleEntity>(mContext, false) {
                    @Override
                    protected void onSuccess(ArticleSimpleEntity entity) {
                        if (entity.getApiArticleDto() == null) {
                            return;
                        }
                        mWebView.loadDataWithBaseURL(null, entity.getApiArticleDto().getContentText(), "text/html", "uff-8", null);

                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }

    private class MyWebViewClient extends WebViewClient {

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            LoadingDialog.showDialogForLoading(mActivity);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            LoadingDialog.cancelDialogForLoading();
        }
    }


    @Override
    protected void onDestroy() {
        if (mWebView != null) {
            mWebView.loadDataWithBaseURL(null, "", "text/html", "uff-8", null);
            mWebView.clearHistory();
            ((ViewGroup) mWebView.getParent()).removeView(mWebView);
            mWebView.destroy();
            mWebView = null;
        }
        super.onDestroy();
    }
}
