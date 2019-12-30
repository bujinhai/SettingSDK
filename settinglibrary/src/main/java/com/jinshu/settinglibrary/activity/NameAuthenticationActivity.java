package com.jinshu.settinglibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.api.SApi;
import com.jinshu.settinglibrary.api.SHostType;
import com.jinshu.settinglibrary.base.baseapp.SBaseActivity;
import com.jinshu.settinglibrary.base.basebean.SBaseResponse;
import com.jinshu.settinglibrary.base.baserx.SRxHelper;
import com.jinshu.settinglibrary.base.baserx.SRxSchedulers;
import com.jinshu.settinglibrary.base.baserx.SRxSubscriber;
import com.jinshu.settinglibrary.entity.CertificateStatusEntity;
import com.jinshu.settinglibrary.entity.Configure;
import com.jinshu.settinglibrary.entity.ImageEntity;
import com.jinshu.settinglibrary.entity.MemberEntity;
import com.jinshu.settinglibrary.utils.ImageLoaderUtils;
import com.jinshu.settinglibrary.utils.MasterUtils;
import com.jinshu.settinglibrary.utils.SDKUtils;
import com.jinshu.settinglibrary.utils.StrUtils;
import com.jinshu.settinglibrary.utils.SystemUtils;
import com.jinshu.settinglibrary.utils.ToastUtil;
import com.jinshu.settinglibrary.utils.UploadUtil;
import com.jinshu.settinglibrary.widget.ViewStyle;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.util.ArrayList;
import java.util.List;

/**
 * Create on 2019/9/25 10:49 by bll
 */


public class NameAuthenticationActivity extends SBaseActivity implements View.OnClickListener {

    private EditText etUserName, etUserCardNum;
    private LinearLayout llValidate, llCardImg;
    private TextView tvIDcard, tvVerifyResult;
    private ImageView ivUploadFront, ivUploadBack, ivVerifyImg;
    private Button btnNext, btnConfirm, btnBackHome, btnCheckInformation;
    private RelativeLayout rlResult;

    private List<LocalMedia> selectList = new ArrayList<>();
    private List<String> imgUrlList = new ArrayList<>();
    private String idCardType;
    private String userName;//真实姓名
    private String idCardNum;//身份证号

    @Override
    public int getLayoutId() {
        return R.layout.setting_activity_name_authentication;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        setTitle("实名认证");
        setBackAction();
        llValidate = findViewById(R.id.ll_validate);
        etUserName = findViewById(R.id.et_user_name);
        etUserCardNum = findViewById(R.id.et_user_card_number);
        btnNext = findViewById(R.id.btn_next);

        llCardImg = findViewById(R.id.ll_id_card_img);
        tvIDcard = findViewById(R.id.tv_upload_id_card);
        ivUploadBack = findViewById(R.id.iv_upload_back);
        ivUploadFront = findViewById(R.id.iv_upload_front);
        btnConfirm = findViewById(R.id.btn_confirm);

        rlResult = findViewById(R.id.rl_verify_result);
        btnBackHome = findViewById(R.id.btn_return_home);
        btnCheckInformation = findViewById(R.id.btn_check_information);
        tvVerifyResult = findViewById(R.id.tv_verify_result);
        ivVerifyImg = findViewById(R.id.iv_verify_image);

        ViewStyle.setBtnStyle(btnNext);
        ViewStyle.setBtnStyle(btnBackHome);
        ViewStyle.setBtnStyle(btnCheckInformation);
        ViewStyle.setBtnStyle(btnConfirm);

        setListener();
    }

    @Override
    protected void initData(Intent intent) {
        MemberEntity data = SDKUtils.getMember();
        if (data != null) {
            String id = "请上传<font color='#0000ff'>" + data.getName() + "</font>本人身份证照片";
            tvIDcard.setText(Html.fromHtml(id));
        }

        //查看实名认证状态
        queryMemberRealNameStatus();
    }

    private void queryMemberRealNameStatus() {
        SApi.getDefault(SHostType.BASE_URL)
                .queryMemberRealNameStatus(MasterUtils.addSessionID())
                .compose(SRxHelper.<CertificateStatusEntity>handleResult())
                .compose(SRxSchedulers.<CertificateStatusEntity>io_main())
                .subscribe(new SRxSubscriber<CertificateStatusEntity>(mContext) {
                    @Override
                    protected void onSuccess(CertificateStatusEntity statusEntity) {
                        if (statusEntity != null) {
                            if (statusEntity.getData().getPeopleID() == null) {
                                llValidate.setVisibility(View.VISIBLE);
                                llCardImg.setVisibility(View.GONE);
                                rlResult.setVisibility(View.GONE);
                            } else {
                                llValidate.setVisibility(View.GONE);
                                llCardImg.setVisibility(View.GONE);
                                rlResult.setVisibility(View.VISIBLE);

                                if (statusEntity.getData().getApproveStatus() == 0) {
                                    ivVerifyImg.setBackgroundResource(R.drawable.setting_authentication_send);
                                    tvVerifyResult.setText(getString(R.string.setting_authentication_result));
                                    btnCheckInformation.setText("查看信息");
                                } else if (statusEntity.getData().getApproveStatus() == 2) {
                                    ivVerifyImg.setBackgroundResource(R.drawable.setting_authentication_fail);
                                    tvVerifyResult.setText(getString(R.string.setting_authentication_result_fail));
                                    btnCheckInformation.setText("重新上传");
                                } else if (statusEntity.getData().getApproveStatus() == 1) {
                                    ivVerifyImg.setBackgroundResource(R.drawable.setting_authentication_success);
                                    tvVerifyResult.setText(getString(R.string.setting_authentication_result_success));
                                    btnCheckInformation.setText("查看详情");
                                }
                            }
                        }
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }

    private void setListener() {
        ivUploadFront.setOnClickListener(this);
        ivUploadBack.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnConfirm.setOnClickListener(this);
        btnBackHome.setOnClickListener(this);
        btnCheckInformation.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_upload_front) {
            idCardType = Configure.FRONT.name();
            getCardImg();
        } else if (v.getId() == R.id.iv_upload_back) {
            idCardType = Configure.BACK.name();
            getCardImg();
        } else if (v.getId() == R.id.btn_next) {
            if (check()) {
                llValidate.setVisibility(View.GONE);
                llCardImg.setVisibility(View.VISIBLE);
            }
        } else if (v.getId() == R.id.btn_confirm) {
            applyRealNameVerify();
        } else if (v.getId() == R.id.btn_return_home) {
            if (mListener != null) {
                mListener.onReturnHomeClick();
            }
        } else if (v.getId() == R.id.btn_check_information) {
            SystemUtils.jumpActivity(mActivity, AuthenticationDetailActivity.class);
            finish();
        }
    }

    private void getCardImg() {
        PictureSelector
                .create(this)
                .openGallery(PictureMimeType.ofImage())
                .theme(R.style.picture_default_style)
                .maxSelectNum(1)
                .minSelectNum(1)
                .imageSpanCount(4)
                .selectionMode(PictureConfig.SINGLE)
                .isCamera(true)
                .enableCrop(true)
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
                    if (selectList != null && selectList.size() > 0) {
                        if (selectList.get(0).isCompressed()) {
                            String path = selectList.get(0).getCompressPath();
                            if (idCardType.equals(Configure.FRONT.name())) {
                                ImageLoaderUtils.display(mContext, ivUploadFront, path);
                            } else {
                                ImageLoaderUtils.display(mContext, ivUploadBack, path);
                            }
                            uploadFile(path);
                        }
                    }
                    break;
            }
        }
    }

    private void uploadFile(String path) {
        UploadUtil
                .uploadImg(path)
                .compose(SRxSchedulers.<SBaseResponse<ImageEntity>>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse<ImageEntity>>(mContext) {
                    @Override
                    protected void onSuccess(SBaseResponse<ImageEntity> response) {
                        if (response.header.code != 0) {
                            ToastUtil.showShort(response.header.msg);
                            return;
                        }
                        String url = response.body.getUrl();
                        if (idCardType.equals(Configure.FRONT.name())) {
                            imgUrlList.add(0, url);
                        } else if (idCardType.equals(Configure.BACK.name())) {
                            imgUrlList.add(1, url);
                        }
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }

    private boolean check() {
        userName = etUserName.getText().toString();
        idCardNum = etUserCardNum.getText().toString();
        if (StrUtils.isEmpty(userName)) {
            ToastUtil.showShort("请输入真实姓名");
            return false;
        }
        if (StrUtils.isEmpty(idCardNum)) {
            ToastUtil.showShort("请输入真实身份证号码");
            return false;
        }
        return true;
    }


    private void applyRealNameVerify() {
        if (imgUrlList.size() < 2) {
            ToastUtil.showShort("身份证照片不完整");
            return;
        }
        String frontUrl = imgUrlList.get(0);
        String backUrl = imgUrlList.get(1);

        SApi.getDefault(SHostType.BASE_URL)
                .applyRealNameVerify(MasterUtils.addSessionID(), userName, idCardNum, frontUrl, backUrl)
                .compose(SRxSchedulers.<SBaseResponse>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse>(mContext) {
                    @Override
                    protected void onSuccess(SBaseResponse response) {
                        if (response.header.code != 0) {
                            ToastUtil.showShort(response.header.msg);
                            return;
                        }
                        llCardImg.setVisibility(View.GONE);
                        rlResult.setVisibility(View.VISIBLE);
                        ivVerifyImg.setBackgroundResource(R.drawable.setting_authentication_send);
                        tvVerifyResult.setText(getString(R.string.setting_authentication_result));
                        btnCheckInformation.setText("查看信息");
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }

    private static OnGoHomeClickListener mListener;

    public static void setOnGoHomeClickListener(OnGoHomeClickListener listener) {
        mListener = listener;
    }

    public interface OnGoHomeClickListener {
        void onReturnHomeClick();
    }
}
