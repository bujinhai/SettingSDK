package com.jinshu.settinglibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.api.SApi;
import com.jinshu.settinglibrary.api.SHostType;
import com.jinshu.settinglibrary.app.SAppConstant;
import com.jinshu.settinglibrary.base.baseapp.SBaseActivity;
import com.jinshu.settinglibrary.base.baserx.SRxHelper;
import com.jinshu.settinglibrary.base.baserx.SRxSchedulers;
import com.jinshu.settinglibrary.base.baserx.SRxSubscriber;
import com.jinshu.settinglibrary.entity.ArticleMoreEntity;
import com.jinshu.settinglibrary.entity.VersionData;
import com.jinshu.settinglibrary.utils.MasterUtils;
import com.jinshu.settinglibrary.utils.SystemUtils;
import com.jinshu.settinglibrary.utils.ToastUtil;
import com.jinshu.settinglibrary.utils.UpdateUtils;

/**
 * Create on 2019/9/29 16:12 by bll
 * 关于我们
 */


public class AboutUsActivity extends SBaseActivity implements View.OnClickListener, UpdateUtils.OnUpDateClickListener {

    private LinearLayout llChenck, llHelp, llPolicy;
    private String code, version;
    private String navigatorID;
    private TextView tvVersion;
    private WebView mWebView;

    private static final String ARTICLE_ID = "8a2f462a6bf84884016bfda290841c51";

    @Override
    public int getLayoutId() {
        return R.layout.setting_activity_about_us;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        setTitle("关于我们");
        setBackAction();
        llChenck = findViewById(R.id.ll_check_version);
        llHelp = findViewById(R.id.ll_help);
        llPolicy = findViewById(R.id.ll_privacy_policy);
        tvVersion = findViewById(R.id.tv_version);
        mWebView = findViewById(R.id.web_view);
        llChenck.setOnClickListener(this);
        llHelp.setOnClickListener(this);
        llPolicy.setOnClickListener(this);

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    protected void initData(Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            navigatorID = bundle.getString(SAppConstant.NAVIGATOR_ID);
        }
        version = SystemUtils.getAppVersionName(this);
        checkVersion();
        getArticleMoreDetail();
    }

    private void checkVersion() {
        SApi.getDefault(SHostType.BASE_URL)
                .getVersionDetail(MasterUtils.getSiteID())
                .compose(SRxHelper.<VersionData>handleResult())
                .compose(SRxSchedulers.<VersionData>io_main())
                .subscribe(new SRxSubscriber<VersionData>(mContext) {
                    @Override
                    protected void onSuccess(VersionData versionEntity) {
                        if (versionEntity.getData() == null) {
                            return;
                        }
                        code = versionEntity.getData().getCode();
                        if (SystemUtils.getAppVersionName(mContext).equals(code)) {
                            tvVersion.setText("最新版本V" + code);
                        } else {
                            tvVersion.setText("有新版本V" + code);
                        }
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
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
    public void onClick(View v) {
        if (v.getId() == R.id.ll_check_version) {
            UpdateUtils.getVersionData(mActivity, MasterUtils.getSiteID());
            UpdateUtils.setOnUpDateCancelListener(AboutUsActivity.this);
        } else if (v.getId() == R.id.ll_help) {

        } else if (v.getId() == R.id.ll_privacy_policy) {
            SystemUtils.jumpActivity(mActivity, PrivacyPolicyActivity.class);
        }
    }

    @Override
    public void onCancel() {

    }

    @Override
    public void onNew(String versionCode, String versionID) {
        ToastUtil.showShort("当前已是最新版本");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mWebView.destroy();
    }
}
