package com.jinshu.settinglibrary.entity;

import java.util.List;

/**
 * Create on 2019/10/25 17:14 by bll
 */


public class FeedListEntity {


    /**
     * data : {"total":1,"currentPage":1,"currentPgeNumber":1,"pageNumber":10,"totalPage":1,"hasNextPage":false,"rows":[{"feedID":"2d89ea16177841d58d0d3f4f8d47a054","title":"测试","content":"测试","contact":"123456","memberID":"8a2f462a6d1e0d64016d1e2f4709004c","memberName":"嘿嘿嘿","memberShortName":"Perfect","memberAvatar":null,"submitTime":1571997483000,"submitTimeStr":"2019-10-25 17:58:03","attachmentList":["/storage/emulated/0/stmap_changdiData_DFC/stconfig/res/RGD.png","/storage/emulated/0/stmap_changdiData_DFC/stconfig/res/G4.png","/storage/emulated/0/stmap_changdiData_DFC/stconfig/res/S1.png"]}]}
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
         * total : 1
         * currentPage : 1
         * currentPgeNumber : 1
         * pageNumber : 10
         * totalPage : 1
         * hasNextPage : false
         * rows : [{"feedID":"2d89ea16177841d58d0d3f4f8d47a054","title":"测试","content":"测试","contact":"123456","memberID":"8a2f462a6d1e0d64016d1e2f4709004c","memberName":"嘿嘿嘿","memberShortName":"Perfect","memberAvatar":null,"submitTime":1571997483000,"submitTimeStr":"2019-10-25 17:58:03","attachmentList":["/storage/emulated/0/stmap_changdiData_DFC/stconfig/res/RGD.png","/storage/emulated/0/stmap_changdiData_DFC/stconfig/res/G4.png","/storage/emulated/0/stmap_changdiData_DFC/stconfig/res/S1.png"]}]
         */

        private int total;
        private int currentPage;
        private int currentPgeNumber;
        private int pageNumber;
        private int totalPage;
        private boolean hasNextPage;
        private List<RowsInfo> rows;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public int getCurrentPgeNumber() {
            return currentPgeNumber;
        }

        public void setCurrentPgeNumber(int currentPgeNumber) {
            this.currentPgeNumber = currentPgeNumber;
        }

        public int getPageNumber() {
            return pageNumber;
        }

        public void setPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public boolean isHasNextPage() {
            return hasNextPage;
        }

        public void setHasNextPage(boolean hasNextPage) {
            this.hasNextPage = hasNextPage;
        }

        public List<RowsInfo> getRows() {
            return rows;
        }

        public void setRows(List<RowsInfo> rows) {
            this.rows = rows;
        }

        public static class RowsInfo {
            /**
             * feedID : 2d89ea16177841d58d0d3f4f8d47a054
             * title : 测试
             * content : 测试
             * contact : 123456
             * memberID : 8a2f462a6d1e0d64016d1e2f4709004c
             * memberName : 嘿嘿嘿
             * memberShortName : Perfect
             * memberAvatar : null
             * submitTime : 1571997483000
             * submitTimeStr : 2019-10-25 17:58:03
             * attachmentList : ["/storage/emulated/0/stmap_changdiData_DFC/stconfig/res/RGD.png","/storage/emulated/0/stmap_changdiData_DFC/stconfig/res/G4.png","/storage/emulated/0/stmap_changdiData_DFC/stconfig/res/S1.png"]
             */

            private String feedID;
            private String title;
            private String content;
            private String contact;
            private String memberID;
            private String memberName;
            private String memberShortName;
            private Object memberAvatar;
            private long submitTime;
            private String submitTimeStr;
            private int multipleType;
            private List<String> attachmentList;

            public String getFeedID() {
                return feedID;
            }

            public void setFeedID(String feedID) {
                this.feedID = feedID;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getContact() {
                return contact;
            }

            public void setContact(String contact) {
                this.contact = contact;
            }

            public String getMemberID() {
                return memberID;
            }

            public void setMemberID(String memberID) {
                this.memberID = memberID;
            }

            public String getMemberName() {
                return memberName;
            }

            public void setMemberName(String memberName) {
                this.memberName = memberName;
            }

            public String getMemberShortName() {
                return memberShortName;
            }

            public void setMemberShortName(String memberShortName) {
                this.memberShortName = memberShortName;
            }

            public Object getMemberAvatar() {
                return memberAvatar;
            }

            public void setMemberAvatar(Object memberAvatar) {
                this.memberAvatar = memberAvatar;
            }

            public long getSubmitTime() {
                return submitTime;
            }

            public void setSubmitTime(long submitTime) {
                this.submitTime = submitTime;
            }

            public String getSubmitTimeStr() {
                return submitTimeStr;
            }

            public void setSubmitTimeStr(String submitTimeStr) {
                this.submitTimeStr = submitTimeStr;
            }

            public int getMultipleType() {
                return multipleType;
            }

            public void setMultipleType(int multipleType) {
                this.multipleType = multipleType;
            }

            public List<String> getAttachmentList() {
                return attachmentList;
            }

            public void setAttachmentList(List<String> attachmentList) {
                this.attachmentList = attachmentList;
            }
        }
    }
}
