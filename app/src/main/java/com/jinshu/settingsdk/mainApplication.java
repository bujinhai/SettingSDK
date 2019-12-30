package com.jinshu.settingsdk;

import android.app.Application;

import com.jinshu.settinglibrary.entity.Builder;
import com.jinshu.settinglibrary.utils.SDKUtils;

/**
 * Create on 2019/9/19 18:56 by bll
 */


public class mainApplication extends Application {

    private String siteID = "8a2f462a6aa17470016aa47bac8f0f32";
    private String applicationID = "8a2f462a6aa17470016aa47baa1c0f24";

    @Override
    public void onCreate() {
        super.onCreate();
        SDKUtils.init(new Builder(this).setSiteID(siteID).setApplicationID(applicationID).build());

    }
}
