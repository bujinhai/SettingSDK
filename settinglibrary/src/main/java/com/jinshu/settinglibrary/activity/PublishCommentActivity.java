package com.jinshu.settinglibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.EditText;

import com.bigkoo.alertview.AlertView;
import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.adapter.ImageAdapter;
import com.jinshu.settinglibrary.api.SApi;
import com.jinshu.settinglibrary.api.SHostType;
import com.jinshu.settinglibrary.app.SAppConstant;
import com.jinshu.settinglibrary.base.baseapp.SBaseActivity;
import com.jinshu.settinglibrary.base.basebean.SBaseResponse;
import com.jinshu.settinglibrary.base.baserx.SRxSchedulers;
import com.jinshu.settinglibrary.base.baserx.SRxSubscriber;
import com.jinshu.settinglibrary.entity.CommentEntity;
import com.jinshu.settinglibrary.entity.Configure;
import com.jinshu.settinglibrary.utils.MasterUtils;
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
 * Create on 2019/9/20 12:47 by bll
 */


public class PublishCommentActivity extends SBaseActivity implements ImageAdapter.onAddPicClickListener {

    private EditText etComment;
    private MyRecyclerView mRvPicture;
    private ImageAdapter mImageAdapter;
    protected List<LocalMedia> pictureList;
    private int themeId;
    private String objectID;
    private String name;
    private String objectName;
    private String objectDefineID = "8af5993a4fba5335014fbb0c8e7e00b0";
    private String commentType;//1.发表评论  2.修改评论
    private CommentEntity.DataInfo.RowsInfo info;

    @Override
    public int getLayoutId() {
        return R.layout.setting_activity_publish_comment;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        setTitle("发表评论");
        setBackAction();
        setRightTitle("发表");

        etComment = findViewById(R.id.et_comment);
        mRvPicture = findViewById(R.id.rv_image);
        pictureList = new ArrayList<>();
        mRvPicture.setLayoutManager(new GridLayoutManager(this, 3));
        mRvPicture.addItemDecoration(new PatrolDecoration());
        mImageAdapter = new ImageAdapter(this, this);
        mRvPicture.setAdapter(mImageAdapter);
        themeId = R.style.picture_default_style;
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
            commentType = bundle.getString(SAppConstant.COMMENT_TYPE);
            info = (CommentEntity.DataInfo.RowsInfo) bundle.getSerializable(SAppConstant.COMMENT_INFO);
            if (Configure.MODIFY.name().equals(commentType)) {
                etComment.setText(info.getShowContent());
                for (CommentEntity.DataInfo.RowsInfo.AttachmentDtosInfo dtosInfo : info.getAttachmentDtos()) {
                    LocalMedia media = new LocalMedia();
                    media.setCompressPath(dtosInfo.getUrl());
                    pictureList.add(media);
                }
                mImageAdapter.setList(pictureList);
                mImageAdapter.notifyDataSetChanged();
            }
        }
    }

    private void setListener() {
        setRightTitleListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Configure.PUBLISH.name().equals(commentType)) {
                    submitOneDiscuss();
                } else if (Configure.MODIFY.name().equals(commentType)) {
                    updateOneDiscuss();
                }
            }
        });

        mImageAdapter.setOnImageClickListener(new ImageAdapter.OnImageItemClickListener() {
            @Override
            public void onImageItemClick(int pos, View v) {
                if (pictureList.size() > 0) {
                    PictureSelector.create(PublishCommentActivity.this).themeStyle(themeId).openExternalPreview(pos, pictureList);
                }
            }
        });
    }

    /**
     * 发表一个评论
     */
    private void submitOneDiscuss() {
        SApi.getDefault(SHostType.BASE_URL)
                .submitOneDiscuss(name, objectName, objectID, objectDefineID, etComment.getText().toString(),
                        MasterUtils.addMasterInfo())
                .compose(SRxSchedulers.<SBaseResponse>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse>(mContext, false) {
                    @Override
                    protected void onSuccess(SBaseResponse baseResponse) {
                        if (baseResponse.header.code == 0) {
                            if (pictureList.size() > 0) {
                                submitObjectAttachment();
                            } else {
                                ToastUtil.showShort("发表成功");
                                setResult(RESULT_OK);
                                finish();
                            }
                        }
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }

    private void updateOneDiscuss() {
        SApi.getDefault(SHostType.BASE_URL)
                .updateOneDiscuss(info.getName(), info.getDiscussID(), etComment.getText().toString(), MasterUtils.addMasterInfo())
                .compose(SRxSchedulers.<SBaseResponse>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse>(mContext, false) {
                    @Override
                    protected void onSuccess(SBaseResponse baseResponse) {
                        if (baseResponse.header.code == 0) {
                            if (pictureList.size() > 0) {
                                submitObjectAttachment();
                            } else {
                                ToastUtil.showShort("修改成功");
                                setResult(RESULT_OK);
                                finish();
                            }
                        }
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }

    /**
     * 上传一个对象附件
     */
    private void submitObjectAttachment() {
        for (LocalMedia media : pictureList) {
            SApi.getDefault(SHostType.BASE_URL)
                    .submObjectAttachment(MasterUtils.addSessionID(), objectName, objectID, objectDefineID, media.getCompressPath())
                    .compose(SRxSchedulers.<SBaseResponse>io_main())
                    .subscribe(new SRxSubscriber<SBaseResponse>(this) {
                        @Override
                        protected void onSuccess(SBaseResponse baseResponse) {
                            if (baseResponse != null || baseResponse.header.code == 0) {
                                ToastUtil.showShort("发表成功");
                                setResult(RESULT_OK);
                                finish();
                            }
                        }

                        @Override
                        protected void onFail(String message) {
                            ToastUtil.showShort(message);
                        }
                    });
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
                } else {
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
        PictureSelectionModel model = null;
        if (type == 1) {
            model = selector.openCamera(PictureMimeType.ofImage())
                    .isCamera(true);// 是否显示拍照按钮
        } else {
            model = selector.openGallery(PictureMimeType.ofImage())
                    .isCamera(false);
        }
        model.theme(R.style.picture_default_style)
                .maxSelectNum(1)// 最大图片选择数量 int
                .minSelectNum(1)// 最小选择数量 int
                .imageSpanCount(4)// 每行显示个数 int
                .selectionMode(PictureConfig.SINGLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                .enableCrop(true)// 是否裁剪
                .compress(true)// 是否压缩
                .circleDimmedLayer(false)// 是否圆形裁剪
                .showCropFrame(true)// 是否显示裁剪矩形边框 圆形裁剪时建议设为false
                .showCropGrid(false)// 是否显示裁剪矩形网格 圆形裁剪时建议设为false
                .withAspectRatio(1, 1)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                .freeStyleCropEnabled(false)// 裁剪框是否可拖拽
                .rotateEnabled(true) // 裁剪是否可旋转图片 true or false
                .scaleEnabled(true)// 裁剪是否可放大缩小图片 true or false
                .minimumCompressSize(100)// 小于100kb的图片不压缩
                .selectionMedia(pictureList)// 是否传入已选图片
                .forResult(PictureConfig.REQUEST_CAMERA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片、视频、音频选择结果回调
                    pictureList = PictureSelector.obtainMultipleResult(data);
                    mImageAdapter.setList(pictureList);
                    mImageAdapter.notifyDataSetChanged();
                    break;
            }
        }
    }
}
