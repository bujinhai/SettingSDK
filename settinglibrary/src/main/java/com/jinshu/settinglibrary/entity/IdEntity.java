package com.jinshu.settinglibrary.entity;

import java.io.Serializable;

/**
 * Create By bll On 2018/9/5  21:35
 * 和文章id有关的类
 */
public class IdEntity implements Serializable {

    private String integral_article_id;//积分等级的文章ID
    private String navigator_id;//常见问题的文章列表导航ID

    public String getIntegral_article_id() {
        return integral_article_id;
    }

    public void setIntegral_article_id(String integral_article_id) {
        this.integral_article_id = integral_article_id;
    }

    public String getNavigator_id() {
        return navigator_id;
    }

    public void setNavigator_id(String navigator_id) {
        this.navigator_id = navigator_id;
    }
}
