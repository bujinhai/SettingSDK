package com.jinshu.settinglibrary.entity;

import java.io.Serializable;

/**
 * Create By bll On 2018/8/28  16:37
 */

public class BtnStyleEntity implements Serializable{

    private int btnBgColor;//button背景色
    private float btnTextSize;//button字体大小
    private int btnTextColor;//button字体颜色
    private int btnHeight;//button高度
    private float btnCorner;//button圆角

    public int getBtnBgColor() {
        return btnBgColor;
    }

    public void setBtnBgColor(int btnBgColor) {
        this.btnBgColor = btnBgColor;
    }

    public float getBtnTextSize() {
        return btnTextSize;
    }

    public void setBtnTextSize(float btnTextSize) {
        this.btnTextSize = btnTextSize;
    }

    public int getBtnTextColor() {
        return btnTextColor;
    }

    public void setBtnTextColor(int btnTextColor) {
        this.btnTextColor = btnTextColor;
    }

    public int getBtnHeight() {
        return btnHeight;
    }

    public void setBtnHeight(int btnHeight) {
        this.btnHeight = btnHeight;
    }

    public float getBtnCorner() {
        return btnCorner;
    }

    public void setBtnCorner(float btnCorner) {
        this.btnCorner = btnCorner;
    }
}
