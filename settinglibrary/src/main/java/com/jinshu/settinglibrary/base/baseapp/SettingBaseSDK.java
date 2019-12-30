package com.jinshu.settinglibrary.base.baseapp;

import android.graphics.Color;

import com.jinshu.settinglibrary.entity.BtnStyleEntity;
import com.jinshu.settinglibrary.entity.CommonTitleStyleEntity;
import com.jinshu.settinglibrary.entity.IdEntity;
import com.jinshu.settinglibrary.entity.MemberEntity;
import com.jinshu.settinglibrary.entity.UserData;
import com.jinshu.settinglibrary.utils.SDKUtils;

/**
 * Create on 2019/9/20 09:24 by bll
 */


public class SettingBaseSDK {

    private static SettingBaseSDK instance;

    public static SettingBaseSDK getInstance() {
        if (instance == null) {
            synchronized (SettingBaseSDK.class) {
                if (instance == null) {
                    instance = new SettingBaseSDK();
                }
            }
        }
        return instance;
    }

    /**
     * 保存登录信息
     *
     * @param entity 用户信息
     */
    public void setUserEntity(UserData entity) {
        if (entity == null) {
            throw new IllegalArgumentException("UserData can not be null");
        }
        SDKUtils.saveUser(entity);
    }

    /**
     * 保存用户信息
     */
    public void setMemberEntity(MemberEntity entity) {
        if (entity == null) {
            throw new IllegalArgumentException("MemberEntity can not be null");
        }
        SDKUtils.saveMember(entity);
    }

    /**
     * 保存文章id
     *
     * @param entity 文章id
     */
    public void setArticleIdEntity(IdEntity entity) {
        if (entity == null) {
            throw new IllegalArgumentException("IdEntity can not be null");
        }
        SDKUtils.saveArticleIDEntity(entity);
    }

    /**
     * 所有按钮的样式
     *
     * @param bgColor   按钮背景颜色
     * @param textColor 字体颜色
     * @param textSize  字体大小
     * @param height    按钮高度
     */
    public static void setBtnStyle(String bgColor, String textColor, float textSize, int height) {
        BtnStyleEntity entity = new BtnStyleEntity();
        entity.setBtnBgColor(getColor(bgColor));
        entity.setBtnTextColor(getColor(textColor));
        entity.setBtnTextSize(textSize);
        entity.setBtnHeight(height);
        SDKUtils.saveBtnEntity(entity);
    }

    /**
     * 顶部标题栏样式
     *
     * @param title   标题
     * @param bgColor 背景颜色
     * @param height  高度
     */
    public static void setTitleBarStyle(String title, String bgColor, int height) {
        CommonTitleStyleEntity styleEntity = new CommonTitleStyleEntity();
        styleEntity.setTitleText(title);
        styleEntity.setTitleBarBgColor(getColor(bgColor));
        styleEntity.setTitleBarHeight(height);
        SDKUtils.saveTitleBarEntity(styleEntity);
    }

    private static int getColor(String lCornerColor) {
        try {
            if (!lCornerColor.startsWith("#")) {
                lCornerColor = "#" + lCornerColor;
            }
            Color.parseColor(lCornerColor);
        } catch (Exception e) {
            return Color.BLACK;
        }
        return Color.parseColor(lCornerColor);
    }
}
