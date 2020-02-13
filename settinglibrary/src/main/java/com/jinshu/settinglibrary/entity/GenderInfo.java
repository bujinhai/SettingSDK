package com.jinshu.settinglibrary.entity;

/**
 * Created on 2020-02-12 by bll
 */

public class GenderInfo {

    /**
     * categoryID : 1d88af067fff4d6e95575e77f7365029
     * name : 先生
     * shortName : mister
     * parentID : ab2907ce6db142d2abb64d0adef5bc69
     * largeIcon : null
     * smallIcon : null
     * orderSeq : 0
     * depth : 3
     * isLeaf : 1
     * parameter1 : null
     * parameter2 : null
     * parameter3 : 1
     * industryNum : 0
     */

    private String categoryID;
    private String name;
    private String shortName;
    private String parentID;
    private String largeIcon;
    private String smallIcon;
    private int orderSeq;
    private int depth;
    private int isLeaf;
    private String parameter1;
    private String parameter2;
    private String parameter3;
    private int industryNum;

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

    public String getLargeIcon() {
        return largeIcon;
    }

    public void setLargeIcon(String largeIcon) {
        this.largeIcon = largeIcon;
    }

    public String getSmallIcon() {
        return smallIcon;
    }

    public void setSmallIcon(String smallIcon) {
        this.smallIcon = smallIcon;
    }

    public int getOrderSeq() {
        return orderSeq;
    }

    public void setOrderSeq(int orderSeq) {
        this.orderSeq = orderSeq;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(int isLeaf) {
        this.isLeaf = isLeaf;
    }

    public String getParameter1() {
        return parameter1;
    }

    public void setParameter1(String parameter1) {
        this.parameter1 = parameter1;
    }

    public String getParameter2() {
        return parameter2;
    }

    public void setParameter2(String parameter2) {
        this.parameter2 = parameter2;
    }

    public String getParameter3() {
        return parameter3;
    }

    public void setParameter3(String parameter3) {
        this.parameter3 = parameter3;
    }

    public int getIndustryNum() {
        return industryNum;
    }

    public void setIndustryNum(int industryNum) {
        this.industryNum = industryNum;
    }
}
