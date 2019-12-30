package com.jinshu.settinglibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.adapter.ArticleAdapter;
import com.jinshu.settinglibrary.api.SApi;
import com.jinshu.settinglibrary.api.SHostType;
import com.jinshu.settinglibrary.app.SAppConstant;
import com.jinshu.settinglibrary.base.baseapp.SBaseActivity;
import com.jinshu.settinglibrary.base.baserx.SRxHelper;
import com.jinshu.settinglibrary.base.baserx.SRxSchedulers;
import com.jinshu.settinglibrary.base.baserx.SRxSubscriber;
import com.jinshu.settinglibrary.entity.Configure;
import com.jinshu.settinglibrary.entity.NavigatorEntity;
import com.jinshu.settinglibrary.recyclerview.animation.ScaleInAnimation;
import com.jinshu.settinglibrary.recyclerview.irc.OnItemClickListener;
import com.jinshu.settinglibrary.utils.MasterUtils;
import com.jinshu.settinglibrary.utils.SystemUtils;
import com.jinshu.settinglibrary.utils.ToastUtil;

/**
 * Create on 2019/10/24 17:32 by bll
 */


public class ArticleActivity extends SBaseActivity {

    private RecyclerView mRv;
    private ArticleAdapter mAdapter;
    private int currentPage = 1;
    private int pageNumber = 10;

    private String navigatorID;
    private String articleType;

    @Override
    public int getLayoutId() {
        return R.layout.setting_article;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        setBackAction();
        mRv = findViewById(R.id.recycler_view);
        mAdapter = new ArticleAdapter(this, R.layout.setting_adapter_item_article);
        mAdapter.openLoadAnimation(new ScaleInAnimation());
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mRv.setAdapter(mAdapter);

        setListener();
    }

    @Override
    protected void initData(Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            articleType = bundle.getString(SAppConstant.ARTICLE_TYPE);
            navigatorID = bundle.getString(SAppConstant.NAVIGATOR_ID);
            if (Configure.QUESTION.name().equals(articleType)) {
                setTitle("常见问题");
            } else {
                setTitle("使用帮助");
            }
        }
        getNavigatorSimpleArticleList();
    }

    private void getNavigatorSimpleArticleList() {
        SApi.getDefault(SHostType.BASE_URL)
                .getNavigatorSimpleArticleList(MasterUtils.addSessionID(), navigatorID, currentPage, pageNumber, "1")
                .compose(SRxHelper.<NavigatorEntity>handleResult())
                .compose(SRxSchedulers.<NavigatorEntity>io_main())
                .subscribe(new SRxSubscriber<NavigatorEntity>(mContext) {
                    @Override
                    protected void onSuccess(NavigatorEntity navigatorEntity) {
                        if (navigatorEntity.getData() == null || navigatorEntity.getData().getRows() == null) {
                            return;
                        }
                        mAdapter.replaceAll(navigatorEntity.getData().getRows());
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }


    private void setListener() {
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object o, int position) {
                NavigatorEntity.DataInfo.RowsInfo info = (NavigatorEntity.DataInfo.RowsInfo) o;
                Bundle bundle = new Bundle();
                bundle.putString(SAppConstant.ARTICLEID, info.getArticleID());
                if (Configure.QUESTION.name().equals(articleType)) {
                    bundle.putString(SAppConstant.ARTICLE_TYPE, Configure.QUESTION.name());
                } else {
                    bundle.putString(SAppConstant.ARTICLE_TYPE, Configure.HELP.name());
                }
                SystemUtils.jumpActivity(mActivity, ArticleDetailActivity.class, bundle);
            }
        });
    }
}
