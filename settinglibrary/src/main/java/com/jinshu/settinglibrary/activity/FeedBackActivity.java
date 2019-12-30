package com.jinshu.settinglibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.api.SApi;
import com.jinshu.settinglibrary.api.SHostType;
import com.jinshu.settinglibrary.base.baseapp.SBaseActivity;
import com.jinshu.settinglibrary.base.basebean.SBaseResponse;
import com.jinshu.settinglibrary.base.baserx.SRxSchedulers;
import com.jinshu.settinglibrary.base.baserx.SRxSubscriber;
import com.jinshu.settinglibrary.utils.ImageLoaderUtils;
import com.jinshu.settinglibrary.utils.MasterUtils;
import com.jinshu.settinglibrary.utils.StrUtils;
import com.jinshu.settinglibrary.utils.SystemUtils;
import com.jinshu.settinglibrary.utils.ToastUtil;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.tools.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Create on 2019/10/24 17:31 by bll
 */


public class FeedBackActivity extends SBaseActivity implements View.OnClickListener {

    private EditText etMessage, etPhone;
    private TextView tvNum;
    private Button btnSubmit;
    private List<LocalMedia> selectList;
    private LinearLayout llRoot;
    private ImageView ivCamera;

    @Override
    public int getLayoutId() {
        return R.layout.setting_activity_feed_back;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        setTitle("意见反馈");
        setBackAction();
        setRightTitle("反馈列表");

        etMessage = findViewById(R.id.et_message);
        tvNum = findViewById(R.id.tv_text_number);
        etPhone = findViewById(R.id.et_phone);
        llRoot = findViewById(R.id.ll_img_root);
        btnSubmit = findViewById(R.id.btn_submit);
        ivCamera = findViewById(R.id.iv_camera);

        selectList = new ArrayList<>();

        setListener();
    }

    private void setListener() {
        ivCamera.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);

        setRightTitleListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SystemUtils.jumpActivity(mActivity, FeedBackListActivity.class);
            }
        });

        etMessage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                tvNum.setText(s.length() + "/300");
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_submit) {
            submitFeed();
        } else if (v.getId() == R.id.iv_camera) {
            selectPicture();
        }
    }

    private void selectPicture() {
        PictureSelector
                .create(this)
                .openGallery(PictureMimeType.ofImage())
                .theme(R.style.picture_default_style)
                .maxSelectNum(3)
                .minSelectNum(1)
                .imageSpanCount(4)
                .selectionMode(PictureConfig.MULTIPLE)
                .isCamera(true)
                .enableCrop(false)
                .compress(true)
                .minimumCompressSize(100)
                .selectionMedia(selectList)// 是否传入已选图片
                .forResult(PictureConfig.CHOOSE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    selectList = PictureSelector.obtainMultipleResult(data);
                    if (selectList.size() > 0) {
                        if (selectList.size() == 3) {
                            ivCamera.setVisibility(View.GONE);
                        } else {
                            ivCamera.setVisibility(View.VISIBLE);
                        }
                        llRoot.removeAllViews();
                        llRoot.addView(ivCamera);
                    }

                    for (int i = 0; i < selectList.size(); i++) {
                        ImageView imageView = new ImageView(mContext);
                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                                ScreenUtils.dip2px(mContext, 80),
                                ScreenUtils.dip2px(mContext, 80));
                        params.rightMargin = 20;
                        ImageLoaderUtils.display(mContext, imageView, selectList.get(i).getCompressPath());
                        llRoot.addView(imageView, i, params);
                    }
                    break;
            }
        }
    }

    private void submitFeed() {
        String content = etMessage.getText().toString();
        String phone = etPhone.getText().toString();

        if (StrUtils.isEmpty(content)) {
            ToastUtil.showShort("请输入反馈内容");
            return;
        }
        if (StrUtils.isEmpty(phone)) {
            ToastUtil.showShort("请输入手机号");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < selectList.size(); i++) {
            if (i == selectList.size() - 1) {
                sb.append(selectList.get(i).getCompressPath());
            } else {
                sb.append(selectList.get(i).getCompressPath() + ",");
            }
        }

        SApi.getDefault(SHostType.BASE_URL)
                .submitOneFeed(MasterUtils.addSessionID(), content, content, phone, sb.toString())
                .compose(SRxSchedulers.<SBaseResponse>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse>(mContext) {
                    @Override
                    protected void onSuccess(SBaseResponse response) {
                        if (response.header.code != 0) {
                            ToastUtil.showShort(response.header.msg);
                            return;
                        }
                        SystemUtils.jumpActivity(mActivity, FeedBackListActivity.class);
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }
}
