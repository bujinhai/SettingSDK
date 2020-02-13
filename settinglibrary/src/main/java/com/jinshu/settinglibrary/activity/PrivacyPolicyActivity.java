package com.jinshu.settinglibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.api.SApi;
import com.jinshu.settinglibrary.api.SHostType;
import com.jinshu.settinglibrary.base.baseapp.SBaseActivity;
import com.jinshu.settinglibrary.base.baserx.SRxHelper;
import com.jinshu.settinglibrary.base.baserx.SRxSchedulers;
import com.jinshu.settinglibrary.base.baserx.SRxSubscriber;
import com.jinshu.settinglibrary.entity.ArticleMoreEntity;
import com.jinshu.settinglibrary.utils.MasterUtils;
import com.jinshu.settinglibrary.utils.ToastUtil;

/**
 * Created on 2020-02-13 by bll
 */

public class PrivacyPolicyActivity extends SBaseActivity {

    private static final String ARTICLE_ID = "8a2f462a6b6a893c016b6e4fca1a14ab";
    private WebView mWebView;

    @Override
    public int getLayoutId() {
        return R.layout.setting_act_privacy_policy;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        setTitle("隐私政策");
        setBackAction();
        mWebView = findViewById(R.id.web_view);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    protected void initData(Intent intent) {
        getArticleMoreDetail();
    }

    private void getArticleMoreDetail() {
        SApi.getDefault(SHostType.BASE_URL)
                .getArticleMoreDetail(MasterUtils.addSessionID(), ARTICLE_ID)
                .compose(SRxHelper.<ArticleMoreEntity>handleResult())
                .compose(SRxSchedulers.<ArticleMoreEntity>io_main())
                .subscribe(new SRxSubscriber<ArticleMoreEntity>(mContext, false) {
                    @Override
                    protected void onSuccess(ArticleMoreEntity entity) {
                        if (entity.getArticleDto() == null) {
                            return;
                        }
                        if (entity.getArticleDto().getContent() == null) {
                            ToastUtil.showShort("无可跳转链接");
                            return;
                        }
                        String data = entity.getArticleDto().getContent();
                        mWebView.loadDataWithBaseURL(null, data, "text/html", "utf-8", null);
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mWebView.destroy();
    }
}
