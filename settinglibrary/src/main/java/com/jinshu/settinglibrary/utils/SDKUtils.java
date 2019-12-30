package com.jinshu.settinglibrary.utils;


import android.annotation.SuppressLint;
import android.content.Context;

import com.jinshu.settinglibrary.app.SAppConstant;
import com.jinshu.settinglibrary.entity.BtnStyleEntity;
import com.jinshu.settinglibrary.entity.Builder;
import com.jinshu.settinglibrary.entity.CommonTitleStyleEntity;
import com.jinshu.settinglibrary.entity.IdEntity;
import com.jinshu.settinglibrary.entity.MemberEntity;
import com.jinshu.settinglibrary.entity.UserData;

public class SDKUtils {

    @SuppressLint("StaticFieldLeak")
    private static Context mContext;

    public static void init(Builder builder) {
        if (builder == null) {
            throw new IllegalArgumentException("Bankcard builder can not be initialized with null.");
        }
    }

    public static void setAppContext(Context context){
        mContext = context;
    }

    public static Context getAppContext() {
        return mContext;
    }

    //保存登录信息
    public static void saveUser(UserData model) {
        clearUser();
        SPUtils.putBean(SAppConstant.USER_MODEL, model);
    }

    public static void clearUser() {
        SPUtils.remove(SAppConstant.USER_MODEL);
    }

    public static UserData getUser() {
        UserData userData = (UserData) SPUtils.getBean(SAppConstant.USER_MODEL);
        return userData;
    }

    //保存会员信息
    public static void saveMember(MemberEntity entity) {
        clearMember();
        SPUtils.putBean(SAppConstant.MEMBER_ENTITY, entity);
    }

    public static void clearMember() {
        SPUtils.remove(SAppConstant.MEMBER_ENTITY);
    }

    public static MemberEntity getMember() {
        MemberEntity entity = (MemberEntity) SPUtils.getBean(SAppConstant.MEMBER_ENTITY);
        return entity;
    }

    //button按钮
    public static void saveBtnEntity(BtnStyleEntity entity) {
        clearBtnEntity();
        SPUtils.putBean(SAppConstant.BASE_BTN_ENTITY, entity);
    }

    public static void clearBtnEntity() {
        SPUtils.remove(SAppConstant.BASE_BTN_ENTITY);
    }

    public static BtnStyleEntity getBtnEntity() {
        BtnStyleEntity entity = (BtnStyleEntity) SPUtils.getBean(SAppConstant.BASE_BTN_ENTITY);
        return entity;
    }

    //顶部标题栏
    public static void saveTitleBarEntity(CommonTitleStyleEntity entity) {
        clearTitleBarEntity();
        SPUtils.putBean(SAppConstant.TITLE_BAR_ENTITY, entity);
    }

    public static void clearTitleBarEntity() {
        SPUtils.remove(SAppConstant.TITLE_BAR_ENTITY);
    }

    public static CommonTitleStyleEntity getTitleBarEntity() {
        CommonTitleStyleEntity entity = (CommonTitleStyleEntity) SPUtils.getBean(SAppConstant.TITLE_BAR_ENTITY);
        return entity;
    }

    //文章ID
    public static void saveArticleIDEntity(IdEntity entity) {
        clearArticleIdEntity();
        SPUtils.putBean(SAppConstant.ARTICLEID, entity);
    }

    public static void clearArticleIdEntity() {
        SPUtils.remove(SAppConstant.ARTICLEID);
    }

    public static IdEntity getArticleIdEntity() {
        IdEntity entity = (IdEntity) SPUtils.getBean(SAppConstant.ARTICLEID);
        return entity;
    }

}
