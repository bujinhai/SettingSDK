package com.jinshu.settinglibrary.entity;

import java.io.Serializable;

public class UserData implements Serializable {


    /**
     * majorID : null
     * avatarURL : http://admin.haoju.me:8082/kpbase//group/M00/10/E0/ABA5-C696-4F92-91A9-BFB460BCDD73.png
     * weixinToken : null
     * sessionID : EA0A079E936C09D2A0C314A054000A15
     * recommandCode : 00030
     * phone : 17674305293
     * rankID : 8a2f462a6325807801632a82c1ec1556
     * loginName : 17674305293
     * rankName : 第一级
     * name : 李振华
     * majorName : null
     * shortName : 李某
     * memberID : 8a2f462a6d24dcc0016d37e799941fd7
     */

    private String majorID;
    private String avatarURL;
    private String weixinToken;
    private String sessionID;
    private String recommandCode;
    private String phone;
    private String rankID;
    private String loginName;
    private String rankName;
    private String name;
    private String majorName;
    private String shortName;
    private String memberID;
    private String peopleID;

    public String getMajorID() {
        return majorID;
    }

    public void setMajorID(String majorID) {
        this.majorID = majorID;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public String getWeixinToken() {
        return weixinToken;
    }

    public void setWeixinToken(String weixinToken) {
        this.weixinToken = weixinToken;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public String getRecommandCode() {
        return recommandCode;
    }

    public void setRecommandCode(String recommandCode) {
        this.recommandCode = recommandCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRankID() {
        return rankID;
    }

    public void setRankID(String rankID) {
        this.rankID = rankID;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getPeopleID() {
        return peopleID;
    }

    public void setPeopleID(String peopleID) {
        this.peopleID = peopleID;
    }
}
