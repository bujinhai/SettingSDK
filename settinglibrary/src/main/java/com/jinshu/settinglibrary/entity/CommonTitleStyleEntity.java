package com.jinshu.settinglibrary.entity;

import java.io.Serializable;

/**
 * Create By bll On 2018/8/29  19:36
 */

public class CommonTitleStyleEntity implements Serializable{

    private int titleBarBgColor;
    private int titleBarHeight;
    private String titleText;

    public int getTitleBarBgColor() {
        return titleBarBgColor;
    }

    public void setTitleBarBgColor(int titleBarBgColor) {
        this.titleBarBgColor = titleBarBgColor;
    }

    public int getTitleBarHeight() {
        return titleBarHeight;
    }

    public void setTitleBarHeight(int titleBarHeight) {
        this.titleBarHeight = titleBarHeight;
    }

    public String getTitleText() {
        return titleText;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }
}
