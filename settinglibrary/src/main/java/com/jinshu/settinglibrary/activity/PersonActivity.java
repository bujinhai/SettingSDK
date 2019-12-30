package com.jinshu.settinglibrary.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bigkoo.alertview.AlertView;
import com.jinshu.settinglibrary.R;
import com.jinshu.settinglibrary.adapter.PersonAdapter;
import com.jinshu.settinglibrary.api.SApi;
import com.jinshu.settinglibrary.api.SHostType;
import com.jinshu.settinglibrary.app.SAppConstant;
import com.jinshu.settinglibrary.base.baseapp.SBaseActivity;
import com.jinshu.settinglibrary.base.baseapp.SettingBaseSDK;
import com.jinshu.settinglibrary.base.basebean.SBaseResponse;
import com.jinshu.settinglibrary.base.baserx.SRxHelper;
import com.jinshu.settinglibrary.base.baserx.SRxSchedulers;
import com.jinshu.settinglibrary.base.baserx.SRxSubscriber;
import com.jinshu.settinglibrary.entity.ImageEntity;
import com.jinshu.settinglibrary.entity.MemberEntity;
import com.jinshu.settinglibrary.entity.SettingEntity;
import com.jinshu.settinglibrary.entity.UserData;
import com.jinshu.settinglibrary.recyclerview.animation.AlphaInAnimation;
import com.jinshu.settinglibrary.recyclerview.irc.OnItemClickListener;
import com.jinshu.settinglibrary.utils.ImageLoaderUtils;
import com.jinshu.settinglibrary.utils.MasterUtils;
import com.jinshu.settinglibrary.utils.SDKUtils;
import com.jinshu.settinglibrary.utils.SystemUtils;
import com.jinshu.settinglibrary.utils.ToastUtil;
import com.jinshu.settinglibrary.utils.UploadUtil;
import com.jinshu.settinglibrary.widget.DatePickerManage;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * Create on 2019/10/23 13:39 by bll
 */


public class PersonActivity extends SBaseActivity {

    private ImageView ivAvatar;
    private RelativeLayout rlAvatar;
    private PersonAdapter mAdapter;
    private ArrayList<SettingEntity> userList = new ArrayList<>();
    private List<LocalMedia> selectList = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.setting_activity_person;
    }

    @Override
    public void initView(Intent intent, @Nullable Bundle savedInstanceState) {
        setTitle("会员信息");
        setBackAction();
        ivAvatar = findViewById(R.id.iv_avatar);
        RecyclerView rvPerson = findViewById(R.id.rv_person);
        rlAvatar = findViewById(R.id.rl_avatar);
        mAdapter = new PersonAdapter(mContext, R.layout.setting_adapter_item_person);
        mAdapter.openLoadAnimation(new AlphaInAnimation());
        rvPerson.setLayoutManager(new LinearLayoutManager(this));
        rvPerson.setAdapter(mAdapter);

        setListener();
    }

    @Override
    protected void initData(Intent intent) {
//        getOneMemberDetail();
        updateUser();
    }

    /*获取会员信息*/
    private void getOneMemberDetail() {
        UserData data = SDKUtils.getUser();
        if (data == null) {
            return;
        }
        SApi.getDefault(SHostType.BASE_URL)
                .getOneMemberDetail(MasterUtils.addSessionID(), data.getMemberID())
                .compose(SRxHelper.<MemberEntity>handleResult())
                .compose(SRxSchedulers.<MemberEntity>io_main())
                .subscribe(new SRxSubscriber<MemberEntity>(mContext, false) {
                    @Override
                    protected void onSuccess(MemberEntity memberEntity) {
                        SettingBaseSDK.getInstance().setMemberEntity(memberEntity);
                        updateUser();
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }

    /*更新界面*/
    private void updateUser() {
        MemberEntity entity = SDKUtils.getMember();
        String titleArray[] = {"昵称", "手机号", "性别", "出生日期"};
        ImageLoaderUtils.displayCirclePhoto(this, ivAvatar, entity.getAvatarURL());

        userList.clear();

        for (int i = 0; i < titleArray.length; i++) {
            SettingEntity info = new SettingEntity();
            info.setTitle(titleArray[i]);

            switch (i) {
                case 0:
                    info.setDesc(entity.getShortName() == null ? "未填写" : entity.getShortName());
                    break;
                case 1:
                    info.setDesc(entity.getPhone() == null ? "未填写" : entity.getPhone());
                    break;
                case 2:
                    info.setDesc(entity.getTitleName() == null ? "未填写" : entity.getTitleName());
                    break;
                case 3:
                    info.setDesc(entity.getBirthdayStr() == null ? "未填写" : entity.getBirthdayStr());
                    break;
            }
            userList.add(info);
        }
        mAdapter.replaceAll(userList);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mRxManager.on(SAppConstant.UPDATE_USER, new Consumer<Object>() {

            @Override
            public void accept(Object o) throws Exception {
                updateUser();
            }
        });
    }

    private void setListener() {
        mAdapter.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(View view, Object o, int position) {
                SettingEntity entity = (SettingEntity) o;
                switch (position) {
                    case 0://设置昵称
                        Bundle bundle = new Bundle();
                        bundle.putString(SAppConstant.NICK_NAME, entity.getDesc());
                        SystemUtils.jumpActivity(mActivity, ModifyNickActivity.class, bundle);
                        break;
                    case 2://设置性别
                        showGenderDialog();
                        break;
                    case 3://设置出生日期
                        showBirthDayDialog();
                        break;
                }
            }
        });

        rlAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectAvatar();
            }
        });
    }

    private void showGenderDialog() {
        new AlertView("修改性别", null, "取消", null, new String[]{"男", "女"},
                this, AlertView.Style.ActionSheet, new com.bigkoo.alertview.OnItemClickListener() {
            @Override
            public void onItemClick(Object o, int position) {
                switch (position) {
                    case 0:
                        updateMyMemberTitle(SAppConstant.GENDER_TITLE_ID_MALE, 1);
                        break;
                    case 1:
                        updateMyMemberTitle(SAppConstant.GENDER_TITLE_ID_FEMAIL, 2);
                        break;
                }
            }
        }).show();
    }

    /*修改性别*/
    private void updateMyMemberTitle(String titleID, final int type) {
        SApi.getDefault(SHostType.BASE_URL)
                .updateMyMemberTitle(MasterUtils.addSessionID(), titleID)
                .compose(SRxSchedulers.<SBaseResponse>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse>(mContext) {
                    @Override
                    protected void onSuccess(SBaseResponse response) {
                        if (response.header.code != 0) {
                            ToastUtil.showShort(response.header.msg);
                        }
                        MemberEntity entity = SDKUtils.getMember();
                        if (type == 1) {
                            entity.setTitleID("男");
                        } else if (type == 2) {
                            entity.setTitleID("女");
                        }
                        SDKUtils.saveMember(entity);
                        updateUser();
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }

    private void showBirthDayDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) - 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerManage.showDatePickerDialog(mContext, "请选择年月日", year,
                month, day, new DatePickerManage.OnDatePickerListener() {
                    @Override
                    public void onConfirm(int year, int month, int dayOfMonth) {
                        String birthDay = year + "-" + month + "-" + dayOfMonth;
                        updateMyMemberBirthday(birthDay);
                    }

                    @Override
                    public void onCancel() {
                    }
                });
    }

    /*修改生日*/
    private void updateMyMemberBirthday(final String birthDay) {
        SApi.getDefault(SHostType.BASE_URL)
                .updateMyMemberBirthday(MasterUtils.addSessionID(), birthDay)
                .compose(SRxSchedulers.<SBaseResponse>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse>(mContext) {
                    @Override
                    protected void onSuccess(SBaseResponse response) {
                        if (response.header.code != 0) {
                            ToastUtil.showShort(response.header.msg);
                        }
                        MemberEntity member = SDKUtils.getMember();
                        member.setBirthdayStr(birthDay);
                        SDKUtils.saveMember(member);
                        updateUser();
                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }

    private void selectAvatar() {
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
                            uploadFile(path);
                        }
                    }
                    break;
            }
        }
    }

    /*上传头像*/
    private void uploadFile(final String path) {
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
                        if (url == null) {
                            return;
                        }MemberEntity entity = SDKUtils.getMember();

                        entity.setAvatarURL(url);
                        SDKUtils.saveMember(entity);

                        ImageLoaderUtils.displayCirclePhoto(mContext, ivAvatar, url);
                        updateMyMemberAvatar(url);

                        mRxManager.post(SAppConstant.UPDATE_AVATAR, "");

                    }

                    @Override
                    protected void onFail(String message) {
                        ToastUtil.showShort(message);
                    }
                });
    }

    /*修改头像*/
    private void updateMyMemberAvatar(String avatarUrl) {
        SApi.getDefault(SHostType.BASE_URL)
                .updateMyMemberAvatar(MasterUtils.addSessionID(), avatarUrl)
                .compose(SRxSchedulers.<SBaseResponse>io_main())
                .subscribe(new SRxSubscriber<SBaseResponse>(mContext, false) {
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
}
