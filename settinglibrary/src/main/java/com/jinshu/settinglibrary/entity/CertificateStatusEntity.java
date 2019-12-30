package com.jinshu.settinglibrary.entity;

import java.io.Serializable;

/**
 * Create By bll On 2018/9/6  17:40
 */

public class CertificateStatusEntity implements Serializable{
    /**
     * data : {"peopleID":"6478bdf8aa64417e9ed5d52f5f8142af","name":"嘿嘿嘿","approveStatus":0,"approveDescription":null,"approveTime":null,"cardCode":"123456","faceImage":"http://wj.haoju.me/2e6fdbd9269546a194600322570d2f25.JPEG","backImage":"http://wj.haoju.me/ed6470836c524731ae738c77f35f7d56.JPEG","handImage":null,"headImage":null,"agreementImage":null}
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
         * peopleID : 6478bdf8aa64417e9ed5d52f5f8142af
         * name : 嘿嘿嘿
         * approveStatus : 0
         * approveDescription : null
         * approveTime : null
         * cardCode : 123456
         * faceImage : http://wj.haoju.me/2e6fdbd9269546a194600322570d2f25.JPEG
         * backImage : http://wj.haoju.me/ed6470836c524731ae738c77f35f7d56.JPEG
         * handImage : null
         * headImage : null
         * agreementImage : null
         */

        private String peopleID;
        private String name;
        //0=等待认证 1=认证通过 11=姓名和身份证号码通过 12=身份证图片通过 13=手持照片通过 2= 认证不通过
        private int approveStatus;
        private String approveDescription;
        private String approveTime;
        private String cardCode;//：身份证号码
        private String faceImage;//：身份证正面图片
        private String backImage;//：身份证背面
        private String headImage;//：头像图
        private String handImage;//：手持身份证图片
        private String agreementImage;//：协议图片

        public String getPeopleID() {
            return peopleID;
        }

        public void setPeopleID(String peopleID) {
            this.peopleID = peopleID;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getApproveStatus() {
            return approveStatus;
        }

        public void setApproveStatus(int approveStatus) {
            this.approveStatus = approveStatus;
        }

        public Object getApproveDescription() {
            return approveDescription;
        }

        public void setApproveDescription(String approveDescription) {
            this.approveDescription = approveDescription;
        }

        public String getApproveTime() {
            return approveTime;
        }

        public void setApproveTime(String approveTime) {
            this.approveTime = approveTime;
        }

        public String getCardCode() {
            return cardCode;
        }

        public void setCardCode(String cardCode) {
            this.cardCode = cardCode;
        }

        public String getFaceImage() {
            return faceImage;
        }

        public void setFaceImage(String faceImage) {
            this.faceImage = faceImage;
        }

        public String getBackImage() {
            return backImage;
        }

        public void setBackImage(String backImage) {
            this.backImage = backImage;
        }

        public String getHandImage() {
            return handImage;
        }

        public void setHandImage(String handImage) {
            this.handImage = handImage;
        }

        public String getHeadImage() {
            return headImage;
        }

        public void setHeadImage(String headImage) {
            this.headImage = headImage;
        }

        public String getAgreementImage() {
            return agreementImage;
        }

        public void setAgreementImage(String agreementImage) {
            this.agreementImage = agreementImage;
        }
    }





}
