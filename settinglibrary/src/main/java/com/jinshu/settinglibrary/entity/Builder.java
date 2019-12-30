package com.jinshu.settinglibrary.entity;

import android.content.Context;

import com.jinshu.settinglibrary.app.SAppConstant;
import com.jinshu.settinglibrary.utils.SDKUtils;
import com.jinshu.settinglibrary.utils.SPUtils;

/**
 * Create on 2019/9/23 11:11 by bll
 */


public class Builder {

    public Builder(Context context) {
        SDKUtils.setAppContext(context);
    }

    public Builder setSiteID(String siteID) {
        SPUtils.setSharedStringData(SAppConstant.SITE_ID, siteID);
        return this;
    }

    public Builder setApplicationID(String applicationID) {
        SPUtils.setSharedStringData(SAppConstant.APPLICATION_ID, applicationID);
        return this;
    }

    public Builder build() {
        return this;
    }
}
