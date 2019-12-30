package com.jinshu.settinglibrary.utils;


import com.jinshu.settinglibrary.app.SAppConstant;
import com.jinshu.settinglibrary.entity.UserData;

import java.util.HashMap;

public class MasterUtils {

    public static boolean isLogin() {
        UserData model = SDKUtils.getUser();
        if (model != null) {
            return true;
        }

        return false;
    }

    public static HashMap<String, String> addMasterInfo() {

        HashMap<String, String> params = new HashMap<>();

//        String deviceID = PreferenceHelper.getString(SApiConstants.DEVICE_ID);
//        if (!TextUtils.isEmpty(deviceID)) {
//            params.put("deviceID", deviceID);
//        }
        params.put("deviceID", "8a2f462a60de32290160de81d31f0141");
        String siteID = getSiteID();
        if (siteID != null) {
            params.put("siteID", siteID);
        }

        return params;
    }

    public static String getSiteID() {
        String siteID = SPUtils.getSharedStringData(SAppConstant.SITE_ID);
        if (siteID != null) {
            return siteID;
        }
        return null;
    }


    public static String addSessionID() {
        UserData model = SDKUtils.getUser();
        if (model != null && model.getSessionID() != null) {
            return model.getSessionID();
        }
        return null;
    }
}
