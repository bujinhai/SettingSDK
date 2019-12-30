package com.jinshu.settinglibrary.base.basebean;

import java.io.Serializable;

/**
 * des:封装服务器返回数据
 * Created by xsf
 * on 2016.09.9:47
 */
public class SBaseResponse<T> implements Serializable {

    public headerBean header;

    public static class headerBean {
        public int code;
        public String msg;

    }

    public T body;

    public boolean success() {
        return header.code == 0;
    }

    public boolean faild(){
        return header.code == 10000;
    }

}
