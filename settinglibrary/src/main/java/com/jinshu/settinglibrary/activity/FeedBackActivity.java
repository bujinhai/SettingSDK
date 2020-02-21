package com.jinshu.settinglibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bigkoo.alertview.AlertView;
import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.adapter.ImageAdapter;
import com.jinshu.settinglibrary.api.SApi;
import com.jinshu.settinglibrary.api.SHostType;
import com.jinshu.settinglibrary.base.baseapp.SBaseActivity;
import com.jinshu.settinglibrary.base.basebean.SBaseResponse;
import com.jinshu.settinglibrary.base.baserx.SRxSchedulers;
import com.jinshu.settinglibrary.base.baserx.SRxSubscriber;
import com.jinshu.settinglibrary.entity.UserData;
import com.jinshu.settinglibrary.utils.MasterUtils;
import com.jinshu.settinglibrary.utils.SDKUtils;
import com.jinshu.settinglibrary.utils.StrUtils;
import com.jinshu.settinglibrary.utils.SystemUtils;
import com.jinshu.settinglibrary.utils.ToastUtil;
import com.jinshu.settinglibrary.view.MyRecyclerView;
import com.jinshu.settinglibrary.widget.PatrolDecoration;
import com.luck.picture.lib.PictureSelectionModel;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.util.ArrayList;
import java.util.List;

/**
 * Create on 2019/10/24 17:31 by bll
 */


public class FeedBackActivity extends SBaseActivity implements View.OnClickListener, ImageAdapter.onAddPicClickListener {

    private EditText etMessage, etPhone;
    private TextView tvNum;
    private Button btnSubmit;
    private List<LocalMedia> mPictureList;
    private MyRecyclerView mRvImage;
    private ImageAdapter mImageAdapter;
    private int themeId;

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
        mRvImage = findViewById(R.id.rv_image);
        etPhone = findViewById(R.id.et_phone);
        btnSubmit = findViewById(R.id.btn_submit);
        mPictureList = new ArrayList<>();

        mRvImage.setHasFixedSize(true);
        mRvImage.setNestedScrollingEnabled(false);
        mRvImage.setLayoutManager(new GridLayoutManager(this, 3));
        mRvImage.addItemDecoration(new PatrolDecoration());
        mImageAdapter = new ImageAdapter(this, this);
        mRvImage.setAdapter(mImageAdapter);

        themeId = R.style.picture_default_style;

        setListener();
    }

    @Override
    protected void initData(Intent intent) {
        UserData userData = SDKUtils.getUser();
        if (userData == null) {
            return;
        }
        etPhone.setText(userData.getPhone());
    }

    private void setListener() {
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
                tvNum.setText(s.length() + "/500");
            }
        });

        mImageAdapter.setOnImageClickListener(new ImageAdapter.OnImageItemClickListener() {
            @Override
            public void onImageItemClick(int pos, View v) {
                if (mPictureList.size() > 0) {
                    PictureSelector.create(FeedBackActivity.this).themeStyle(themeId).openExternalPreview(pos, mPictureList);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_submit) {
            submitFeed();
        }
    }


    @Override
    public void onAddPicClick() {
        showDialog();
    }

    private void showDialog() {
        new AlertView("选择图片", null,
                getString(R.string.setting_common_cancel), null,
                new String[]{getString(R.string.setting_select_image_camera),
                        getString(R.string.setting_select_image_gallery)}, this,
                AlertView.Style.ActionSheet, new com.bigkoo.alertview.OnItemClickListener() {
            @Override
            public void onItemClick(Object o, int position) {
                if (position == 0) {
                    //拍照
                    selectPicture(1);
                } else if (position == 1) {
                    //相册
                    selectPicture(2);
                }
            }
        }).show();
    }

    /**
     * type:1-拍照  2-相册
     */
    private void selectPicture(int type) {
        PictureSelector selector = PictureSelector
                .create(this);
        PictureSelectionModel model;
        if (type == 1) {
            model = selector.openCamera(PictureMimeType.ofImage())
                    .isCamera(true);// 是否显示拍照按钮
        } else {
            model = selector.openGallery(PictureMimeType.ofImage())
                    .isCamera(false);
        }
        model.theme(R.style.picture_default_style)
                .maxSelectNum(3)// 最大图片选择数量 int
                .minSelectNum(1)// 最小选择数量 int
                .imageSpanCount(4)// 每行显示个数 int
                .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                .enableCrop(false)// 是否裁剪
                .compress(true)// 是否压缩
                .circleDimmedLayer(false)// 是否圆形裁剪
                .showCropFrame(true)// 是否显示裁剪矩形边框 圆形裁剪时建议设为false
                .showCropGrid(false)// 是否显示裁剪矩形网格 圆形裁剪时建议设为false
                .withAspectRatio(1, 1)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                .freeStyleCropEnabled(false)// 裁剪框是否可拖拽
                .rotateEnabled(true) // 裁剪是否可旋转图片 true or false
                .scaleEnabled(true)// 裁剪是否可放大缩小图片 true or false
                .minimumCompressSize(100)// 小于100kb的图片不压缩
                .selectionMedia(mPictureList)// 是否传入已选图片
                .forResult(PictureConfig.REQUEST_CAMERA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.REQUEST_CAMERA:
                    mPictureList = PictureSelector.obtainMultipleResult(data);
                    mImageAdapter.setList(mPictureList);
                    mImageAdapter.notifyDataSetChanged();
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
        for (int i = 0; i < mPictureList.size(); i++) {
            if (i == mPictureList.size() - 1) {
                sb.append(mPictureList.get(i).getCompressPath());
            } else {
                sb.append(mPictureList.get(i).getCompressPath() + ",");
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
                        finish();
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }

}
