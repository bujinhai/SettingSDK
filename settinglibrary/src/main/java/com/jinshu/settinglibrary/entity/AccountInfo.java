package com.jinshu.settinglibrary.entity;

/**
 * Create on 2019/12/3 10:06 by bll
 */


public class AccountInfo {

    /**
     * memberBalanceID : 8a2f462a6c40a90d016c40c701f301e0
     * name : null
     * operateTime : 1564454879000
     * operateTimeStr : 2019-07-30 10:47:59
     * orderSeq : 0
     * balanceType : 1
     * operateMemberID : null
     * operateMemberName : null
     * operateMemberAvatar : null
     * operateType : 会员资金初始化
     * StringDefineID : 8a2f462a5a6026cd015a64fe3e920cef
     * StringID : null
     * StringName : null
     * amount : 0
     * fee : 0
     * balance : 0
     */

    private String memberBalanceID;
    private String name;
    private long operateTime;
    private String operateTimeStr;
    private int orderSeq;
    private int balanceType;
    private String operateMemberID;
    private String operateMemberName;
    private String operateMemberAvatar;
    private String operateType;
    private String StringDefineID;
    private String StringID;
    private String StringName;
    private double amount;
    private int fee;
    private double balance;

    public String getMemberBalanceID() {
        return memberBalanceID;
    }

    public void setMemberBalanceID(String memberBalanceID) {
        this.memberBalanceID = memberBalanceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(long operateTime) {
        this.operateTime = operateTime;
    }

    public String getOperateTimeStr() {
        return operateTimeStr;
    }

    public void setOperateTimeStr(String operateTimeStr) {
        this.operateTimeStr = operateTimeStr;
    }

    public int getOrderSeq() {
        return orderSeq;
    }

    public void setOrderSeq(int orderSeq) {
        this.orderSeq = orderSeq;
    }

    public int getBalanceType() {
        return balanceType;
    }

    public void setBalanceType(int balanceType) {
        this.balanceType = balanceType;
    }

    public String getOperateMemberID() {
        return operateMemberID;
    }

    public void setOperateMemberID(String operateMemberID) {
        this.operateMemberID = operateMemberID;
    }

    public String getOperateMemberName() {
        return operateMemberName;
    }

    public void setOperateMemberName(String operateMemberName) {
        this.operateMemberName = operateMemberName;
    }

    public String getOperateMemberAvatar() {
        return operateMemberAvatar;
    }

    public void setOperateMemberAvatar(String operateMemberAvatar) {
        this.operateMemberAvatar = operateMemberAvatar;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public String getStringDefineID() {
        return StringDefineID;
    }

    public void setStringDefineID(String StringDefineID) {
        this.StringDefineID = StringDefineID;
    }

    public String getStringID() {
        return StringID;
    }

    public void setStringID(String StringID) {
        this.StringID = StringID;
    }

    public String getStringName() {
        return StringName;
    }

    public void setStringName(String StringName) {
        this.StringName = StringName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
