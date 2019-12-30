package com.jinshu.settinglibrary.entity;

import java.util.List;

/**
 * Create on 2019/11/6 15:54 by bll
 */


public class MessageEntity {


    /**
     * data : {"total":2,"currentPage":1,"currentPgeNumber":2,"pageNumber":10,"totalPage":1,"hasNextPage":false,"rows":[{"messageID":"1e7ea605235d4f91b4cab65ad50bdc37","name":"你修改了一个废弃物处理申请","shortName":null,"sendDate":null,"receivedDate":null,"readTime":1558350901000,"code":null,"sendCompanyID":null,"sendCompanyName":null,"senderMemberID":null,"senderMemberName":null,"senderMemberAvatar":null,"senderEmployeeID":null,"senderEmployeeName":null,"objectDefineID":"8a2f462a6ace4644016ad3aafe1e1a9d","objectDefineName":"废弃物","objectID":"8a2f462a6ace4644016ad3b941591ae9","objectName":"测测测","tableName":"wastesProcess"},{"messageID":"701b4ab0f87e4c4daadc2bc23abed61d","name":"lzl测试消息消息","shortName":null,"sendDate":1558347909000,"receivedDate":null,"readTime":1558350901000,"code":null,"sendCompanyID":null,"sendCompanyName":null,"senderMemberID":"8a2f462a698fd5f601698fed139c013c","senderMemberName":"刘宗霖","senderMemberAvatar":"http://thirdwx.qlogo.cn/mmopen/bkps5Tqvhe8NjiartFqpRZcpsagD7AmCsghDFdY8k5Kf5MAFWVMYASmXGeib9ibZ5uJuvIvkhBbFuegI6Qg4fLice3dYSrIaT4So/132","senderEmployeeID":null,"senderEmployeeName":null,"objectDefineID":null,"objectDefineName":null,"objectID":null,"objectName":null,"tableName":null}]}
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
         * total : 2
         * currentPage : 1
         * currentPgeNumber : 2
         * pageNumber : 10
         * totalPage : 1
         * hasNextPage : false
         * rows : [{"messageID":"1e7ea605235d4f91b4cab65ad50bdc37","name":"你修改了一个废弃物处理申请","shortName":null,"sendDate":null,"receivedDate":null,"readTime":1558350901000,"code":null,"sendCompanyID":null,"sendCompanyName":null,"senderMemberID":null,"senderMemberName":null,"senderMemberAvatar":null,"senderEmployeeID":null,"senderEmployeeName":null,"objectDefineID":"8a2f462a6ace4644016ad3aafe1e1a9d","objectDefineName":"废弃物","objectID":"8a2f462a6ace4644016ad3b941591ae9","objectName":"测测测","tableName":"wastesProcess"},{"messageID":"701b4ab0f87e4c4daadc2bc23abed61d","name":"lzl测试消息消息","shortName":null,"sendDate":1558347909000,"receivedDate":null,"readTime":1558350901000,"code":null,"sendCompanyID":null,"sendCompanyName":null,"senderMemberID":"8a2f462a698fd5f601698fed139c013c","senderMemberName":"刘宗霖","senderMemberAvatar":"http://thirdwx.qlogo.cn/mmopen/bkps5Tqvhe8NjiartFqpRZcpsagD7AmCsghDFdY8k5Kf5MAFWVMYASmXGeib9ibZ5uJuvIvkhBbFuegI6Qg4fLice3dYSrIaT4So/132","senderEmployeeID":null,"senderEmployeeName":null,"objectDefineID":null,"objectDefineName":null,"objectID":null,"objectName":null,"tableName":null}]
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
             * messageID : 1e7ea605235d4f91b4cab65ad50bdc37
             * name : 你修改了一个废弃物处理申请
             * shortName : null
             * sendDate : null
             * receivedDate : null
             * readTime : 1558350901000
             * code : null
             * sendCompanyID : null
             * sendCompanyName : null
             * senderMemberID : null
             * senderMemberName : null
             * senderMemberAvatar : null
             * senderEmployeeID : null
             * senderEmployeeName : null
             * objectDefineID : 8a2f462a6ace4644016ad3aafe1e1a9d
             * objectDefineName : 废弃物
             * objectID : 8a2f462a6ace4644016ad3b941591ae9
             * objectName : 测测测
             * tableName : wastesProcess
             */

            private String messageID;
            private String name;
            private String shortName;
            private long sendDate;
            private String receivedDate;
            private long readTime;
            private String code;
            private String sendCompanyID;
            private String sendCompanyName;
            private String senderMemberID;
            private String senderMemberName;
            private String senderMemberAvatar;
            private String senderEmployeeID;
            private String senderEmployeeName;
            private String objectDefineID;
            private String objectDefineName;
            private String objectID;
            private String objectName;
            private String tableName;

            public String getMessageID() {
                return messageID;
            }

            public void setMessageID(String messageID) {
                this.messageID = messageID;
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

            public long getSendDate() {
                return sendDate;
            }

            public void setSendDate(long sendDate) {
                this.sendDate = sendDate;
            }

            public String getReceivedDate() {
                return receivedDate;
            }

            public void setReceivedDate(String receivedDate) {
                this.receivedDate = receivedDate;
            }

            public long getReadTime() {
                return readTime;
            }

            public void setReadTime(long readTime) {
                this.readTime = readTime;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getSendCompanyID() {
                return sendCompanyID;
            }

            public void setSendCompanyID(String sendCompanyID) {
                this.sendCompanyID = sendCompanyID;
            }

            public String getSendCompanyName() {
                return sendCompanyName;
            }

            public void setSendCompanyName(String sendCompanyName) {
                this.sendCompanyName = sendCompanyName;
            }

            public String getSenderMemberID() {
                return senderMemberID;
            }

            public void setSenderMemberID(String senderMemberID) {
                this.senderMemberID = senderMemberID;
            }

            public String getSenderMemberName() {
                return senderMemberName;
            }

            public void setSenderMemberName(String senderMemberName) {
                this.senderMemberName = senderMemberName;
            }

            public String getSenderMemberAvatar() {
                return senderMemberAvatar;
            }

            public void setSenderMemberAvatar(String senderMemberAvatar) {
                this.senderMemberAvatar = senderMemberAvatar;
            }

            public String getSenderEmployeeID() {
                return senderEmployeeID;
            }

            public void setSenderEmployeeID(String senderEmployeeID) {
                this.senderEmployeeID = senderEmployeeID;
            }

            public String getSenderEmployeeName() {
                return senderEmployeeName;
            }

            public void setSenderEmployeeName(String senderEmployeeName) {
                this.senderEmployeeName = senderEmployeeName;
            }

            public String getObjectDefineID() {
                return objectDefineID;
            }

            public void setObjectDefineID(String objectDefineID) {
                this.objectDefineID = objectDefineID;
            }

            public String getObjectDefineName() {
                return objectDefineName;
            }

            public void setObjectDefineName(String objectDefineName) {
                this.objectDefineName = objectDefineName;
            }

            public String getObjectID() {
                return objectID;
            }

            public void setObjectID(String objectID) {
                this.objectID = objectID;
            }

            public String getObjectName() {
                return objectName;
            }

            public void setObjectName(String objectName) {
                this.objectName = objectName;
            }

            public String getTableName() {
                return tableName;
            }

            public void setTableName(String tableName) {
                this.tableName = tableName;
            }
        }
    }
}
