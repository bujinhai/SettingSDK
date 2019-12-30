package com.jinshu.settinglibrary.entity;

/**
 * Create on 2019/9/11 09:55 by bll
 */


public class VersionData {


    /**
     * header : {"code":0,"msg":"getVersionDetail success"}
     * body : {"data":{"versionID":"8a2f462a6aa17470016aa48512660f86","name":"氧寿健康Android开发版本","code":"0.12","description":"这是开发的","logoURL":null,"publishURL":null,"codeURL":null,"fileURL":null,"appType":11,"tipsUpgrade":null,"isDefaultUpgrade":1,"isNoLogin":1,"fileSizeK":2222,"status":1,"modifiedTime":1557538345000,"modifiedTimeStr":"2019-05-11 09:32:25"}}
     */

    private DataInfo data;

    public DataInfo getData() {
        return data;
    }

    public void setData(DataInfo data) {
        this.data = data;
    }

    public static class DataInfo {
        /**
         * versionID : 8a2f462a6aa17470016aa48512660f86
         * name : 氧寿健康Android开发版本
         * code : 0.12
         * description : 这是开发的
         * logoURL : null
         * publishURL : null
         * codeURL : null
         * fileURL : null
         * appType : 11
         * tipsUpgrade : null
         * isDefaultUpgrade : 1
         * isNoLogin : 1
         * fileSizeK : 2222
         * status : 1
         * modifiedTime : 1557538345000
         * modifiedTimeStr : 2019-05-11 09:32:25
         */

        private String versionID;
        private String name;
        private String code;
        private String description;
        private String logoURL;
        private String publishURL;
        private String codeURL;
        private String fileURL;
        private int appType;
        private String tipsUpgrade;
        private int isDefaultUpgrade;
        private int isNoLogin;
        private long fileSizeK;
        private int status;
        private long modifiedTime;
        private String modifiedTimeStr;

        public String getVersionID() {
            return versionID;
        }

        public void setVersionID(String versionID) {
            this.versionID = versionID;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getLogoURL() {
            return logoURL;
        }

        public void setLogoURL(String logoURL) {
            this.logoURL = logoURL;
        }

        public String getPublishURL() {
            return publishURL;
        }

        public void setPublishURL(String publishURL) {
            this.publishURL = publishURL;
        }

        public String getCodeURL() {
            return codeURL;
        }

        public void setCodeURL(String codeURL) {
            this.codeURL = codeURL;
        }

        public String getFileURL() {
            return fileURL;
        }

        public void setFileURL(String fileURL) {
            this.fileURL = fileURL;
        }

        public int getAppType() {
            return appType;
        }

        public void setAppType(int appType) {
            this.appType = appType;
        }

        public String getTipsUpgrade() {
            return tipsUpgrade;
        }

        public void setTipsUpgrade(String tipsUpgrade) {
            this.tipsUpgrade = tipsUpgrade;
        }

        public int getIsDefaultUpgrade() {
            return isDefaultUpgrade;
        }

        public void setIsDefaultUpgrade(int isDefaultUpgrade) {
            this.isDefaultUpgrade = isDefaultUpgrade;
        }

        public int getIsNoLogin() {
            return isNoLogin;
        }

        public void setIsNoLogin(int isNoLogin) {
            this.isNoLogin = isNoLogin;
        }

        public long getFileSizeK() {
            return fileSizeK;
        }

        public void setFileSizeK(long fileSizeK) {
            this.fileSizeK = fileSizeK;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public long getModifiedTime() {
            return modifiedTime;
        }

        public void setModifiedTime(long modifiedTime) {
            this.modifiedTime = modifiedTime;
        }

        public String getModifiedTimeStr() {
            return modifiedTimeStr;
        }

        public void setModifiedTimeStr(String modifiedTimeStr) {
            this.modifiedTimeStr = modifiedTimeStr;
        }
    }
}
