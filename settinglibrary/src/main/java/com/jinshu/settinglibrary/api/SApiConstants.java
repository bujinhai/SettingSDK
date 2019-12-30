package com.jinshu.settinglibrary.api;

/**
 * Create on 2019/9/10 15:11 by bll
 */


public class SApiConstants {

    /**
     * 服务器地址
     */
    public static final String HostUrl = "https://www.haoju.me/interface-server/api/";

    /**
     * 获取对应的host
     *
     * @param hostType host类型
     * @return host
     */
    public static String getHost(int hostType) {
        String host;
        switch (hostType) {
            case SHostType.BASE_URL:
                host = HostUrl;
                break;
            case SHostType.TEST_URL:
                host = "";
                break;
            default:
                host = "";
                break;
        }
        return host;
    }
}
