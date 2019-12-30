package com.jinshu.settinglibrary.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.alertview.AlertView;
import com.bigkoo.alertview.OnItemClickListener;
import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.api.SApi;
import com.jinshu.settinglibrary.api.SHostType;
import com.jinshu.settinglibrary.app.SAppConstant;
import com.jinshu.settinglibrary.base.baseapp.SAppManager;
import com.jinshu.settinglibrary.base.baseapp.SBaseActivity;
import com.jinshu.settinglibrary.base.basebean.SBaseResponse;
import com.jinshu.settinglibrary.base.baserx.SRxSchedulers;
import com.jinshu.settinglibrary.base.baserx.SRxSubscriber;
import com.jinshu.settinglibrary.entity.Configure;
import com.jinshu.settinglibrary.entity.ParamData;
import com.jinshu.settinglibrary.utils.CacheUtils;
import com.jinshu.settinglibrary.utils.MasterUtils;
import com.jinshu.settinglibrary.utils.SDKUtils;
import com.jinshu.settinglibrary.utils.SystemUtils;
import com.jinshu.settinglibrary.utils.ToastUtil;

import io.reactivex.functions.Consumer;

/**
 * Create on 2019/10/22 18:23 by bll
 */


public class SettingActivity extends SBaseActivity implements View.OnClickListener {

    private RelativeLayout rl_private_information, rl_address_manage, rl_my_comment, rl_security, rl_payment,
            rl_receipt, rl_clear_cache, rl_feedback, rl_question, rl_qr_code, rl_about_us;
    private TextView tvCache;
    private String objectID;
    private String name;
    private String objectName;
    private String objectDefineID;
    private Button btnLoginOut;

    private static ParamData mParam;

    public static void startActivity(Activity context, ParamData data) {
        Bundle bundle = new Bundle();
        if (data != null) {
            mParam = data;
            bundle.putString(SAppConstant.OBJECT_ID, data.getObjectID());
            bundle.putString(SAppConstant.COMMENT_NAME, data.getName());
            bundle.putString(SAppConstant.OBJECT_NAME, data.getObjectName());
            bundle.putString(SAppConstant.OBJECT_DEFINE_ID, data.getObjectDefineID());
        }
        SystemUtils.jumpActivity(context, SettingActivity.class, bundle);
    }

    @Override
    public int getLayoutId() {
        return R.layout.setting_activity;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        setTitle("设置");
        setBackAction();
        rl_private_information = findViewById(R.id.rl_private_information);
        rl_address_manage = findViewById(R.id.rl_address_manage);
        rl_my_comment = findViewById(R.id.rl_my_comment);
        rl_security = findViewById(R.id.rl_security);
        rl_payment = findViewById(R.id.rl_payment);
        rl_receipt = findViewById(R.id.rl_receipt);
        rl_clear_cache = findViewById(R.id.rl_clear_cache);
        rl_feedback = findViewById(R.id.rl_feedback);
        rl_question = findViewById(R.id.rl_question);
        rl_qr_code = findViewById(R.id.rl_qr_code);
        rl_about_us = findViewById(R.id.rl_about_us);
        tvCache = findViewById(R.id.tv_cache);
        btnLoginOut = findViewById(R.id.btn_logout);

        setListener();
    }

    @Override
    protected void initData(Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            objectID = bundle.getString(SAppConstant.OBJECT_ID);
            name = bundle.getString(SAppConstant.COMMENT_NAME);
            objectName = bundle.getString(SAppConstant.OBJECT_NAME);
            objectDefineID = bundle.getString(SAppConstant.OBJECT_DEFINE_ID);
        }
        String total = CacheUtils.getTotalCacheSize(this);
        tvCache.setText(total);
    }

    @Override
    public void onStart() {
        super.onStart();
        mRxManager.on(SAppConstant.UPDATE_AVATAR, new Consumer<Object>() {

            @Override
            public void accept(Object o) throws Exception {
                if (mListener != null) {
                    mListener.onUpdateAvatar();
                }
            }
        });
    }

    private void setListener() {
        rl_private_information.setOnClickListener(this);
        rl_address_manage.setOnClickListener(this);
        rl_my_comment.setOnClickListener(this);
        rl_security.setOnClickListener(this);
        rl_payment.setOnClickListener(this);
        rl_receipt.setOnClickListener(this);
        rl_clear_cache.setOnClickListener(this);
        rl_feedback.setOnClickListener(this);
        rl_question.setOnClickListener(this);
        rl_qr_code.setOnClickListener(this);
        rl_about_us.setOnClickListener(this);
        btnLoginOut.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.rl_private_information) {
            SystemUtils.jumpActivity(this, PersonActivity.class);
        } else if (v.getId() == R.id.rl_address_manage) {
            SystemUtils.jumpActivity(this, AddressActivity.class);
        } else if (v.getId() == R.id.rl_my_comment) {
            Bundle bundle = new Bundle();
            bundle.putString(SAppConstant.OBJECT_ID, objectID);
            bundle.putString(SAppConstant.COMMENT_NAME, name);
            bundle.putString(SAppConstant.OBJECT_NAME, objectName);
            bundle.putString(SAppConstant.OBJECT_DEFINE_ID, objectDefineID);
            SystemUtils.jumpActivity(this, CommentActivity.class, bundle);
        } else if (v.getId() == R.id.rl_security) {
            SystemUtils.jumpActivity(this, AccountSecurityActivity.class);
        } else if (v.getId() == R.id.rl_payment) {
            SystemUtils.jumpActivity(this, PaymentActivity.class);
        } else if (v.getId() == R.id.rl_receipt) {
            SystemUtils.jumpActivity(this, InvoiceListActivity.class);
        } else if (v.getId() == R.id.rl_clear_cache) {
            CacheUtils.clearAllCache(this);
            String caches = CacheUtils.getTotalCacheSize(mContext);
            tvCache.setText(caches);
        } else if (v.getId() == R.id.rl_feedback) {
            SystemUtils.jumpActivity(this, FeedBackActivity.class);
        } else if (v.getId() == R.id.rl_question) {
            Bundle bundle = new Bundle();
            bundle.putString(SAppConstant.ARTICLE_TYPE, Configure.QUESTION.name());
            bundle.putString(SAppConstant.NAVIGATOR_ID, mParam.getNavigator_question_ID());
            SystemUtils.jumpActivity(this, ArticleActivity.class, bundle);
        } else if (v.getId() == R.id.rl_qr_code) {
            SystemUtils.jumpActivity(this, QRCodeActivity.class);
        } else if (v.getId() == R.id.rl_about_us) {
            Bundle bundle = new Bundle();
            bundle.putString(SAppConstant.NAVIGATOR_ID, mParam.getNavigator_help_ID());
            SystemUtils.jumpActivity(this, AboutUsActivity.class, bundle);
        } else if (v.getId() == R.id.btn_logout) {
            new AlertView("提示", "确定要退出登录吗？", "取消", new String[]{"确定"},
                    null, this, AlertView.Style.Alert, new OnItemClickListener() {
                @Override
                public void onItemClick(Object o, int position) {
                    if (position == 0) {
                        SDKUtils.clearUser();
                        SAppManager.getAppManager().finishAllActivity();
                        loginOut();
                        if (mListener != null) {
                            mListener.onLoginOutClick();
                        }
                    }
                }
            }).show();
        }
    }

    private void loginOut() {
        SApi.getDefault(SHostType.BASE_URL)
                .loginOut(MasterUtils.addSessionID())
                .compose(SRxSchedulers.<SBaseResponse>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse>(mContext) {
                    @Override
                    protected void onSuccess(SBaseResponse response) {
                        if (response.header.code != 0) {
                            ToastUtil.showShort(response.header.msg);
                        }
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }

    private static OnLoginOutClickListener mListener;

    public interface OnLoginOutClickListener {
        void onLoginOutClick();
        void onUpdateAvatar();
    }

    public static void setOnLoginOutClickListener(OnLoginOutClickListener listener) {
        mListener = listener;
    }
}
