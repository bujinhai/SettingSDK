package com.jinshu.settinglibrary.recyclerview.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 分页信息 默认一页10条
 */
public  class SPageBean implements Parcelable {
    private int page=0;
    private int rows=10;
    private int totalCount;
    private int totalPage;
    private boolean refresh=true;


    public int getLoadPage() {
        if(refresh){
            return  page=1;
        }
        return ++page;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public boolean isRefresh() {
        return refresh;
    }

    public void setRefresh(boolean refresh) {
        this.refresh = refresh;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.page);
        dest.writeInt(this.rows);
        dest.writeInt(this.totalCount);
        dest.writeInt(this.totalPage);
        dest.writeByte(refresh ? (byte) 1 : (byte) 0);
    }

    public SPageBean() {
    }

    protected SPageBean(Parcel in) {
        this.page = in.readInt();
        this.rows = in.readInt();
        this.totalCount = in.readInt();
        this.totalPage = in.readInt();
        this.refresh = in.readByte() != 0;
    }

    public static final Creator<SPageBean> CREATOR = new Creator<SPageBean>() {
        @Override
        public SPageBean createFromParcel(Parcel source) {
            return new SPageBean(source);
        }

        @Override
        public SPageBean[] newArray(int size) {
            return new SPageBean[size];
        }
    };
}