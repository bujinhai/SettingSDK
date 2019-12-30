package com.jinshu.settinglibrary.entity;

/**
 * Create on 2019/11/6 11:10 by bll
 */


public class ParamData {

    //评论
    private String objectID;
    private String name;
    private String objectName;
    private String objectDefineID;
    //文章导航
    private String navigator_question_ID;
    private String navigator_help_ID;

    public ParamData() {
    }
    //文章导航id
    public ParamData(String navigator_question_ID, String navigator_help_ID) {
        this.navigator_question_ID = navigator_question_ID;
        this.navigator_help_ID = navigator_help_ID;
    }
    //评论需要的参数
    public ParamData(String objectID, String name, String objectName, String objectDefineID) {
        this.objectID = objectID;
        this.name = name;
        this.objectName = objectName;
        this.objectDefineID = objectDefineID;
    }

    public ParamData(String objectID, String name, String objectName, String objectDefineID, String navigator_question_ID, String navigator_help_ID) {
        this.objectID = objectID;
        this.name = name;
        this.objectName = objectName;
        this.objectDefineID = objectDefineID;
        this.navigator_question_ID = navigator_question_ID;
        this.navigator_help_ID = navigator_help_ID;
    }


    public String getObjectID() {
        return objectID;
    }

    public String getName() {
        return name;
    }

    public String getObjectName() {
        return objectName;
    }

    public String getObjectDefineID() {
        return objectDefineID;
    }

    public String getNavigator_question_ID() {
        return navigator_question_ID;
    }

    public String getNavigator_help_ID() {
        return navigator_help_ID;
    }
}
