package com.jinshu.settinglibrary.entity;

import java.util.List;

/**
 * Create on 2019/10/21 19:09 by bll
 */


public class BankBranchListEntity {


    /**
     * data : {"total":17,"currentPage":1,"currentPgeNumber":17,"pageNumber":10000,"totalPage":1,"hasNextPage":false,"rows":[{"bankID":"102141013013","parentID":"102","name":"中国工商银行承德业务处理中心","shortName":"中国工商银行承德业务处理中心","bankType":null,"bankTypeName":null,"code":"102141013013","cityID":"28feba630deb4873a522c90054159594","cityName":"承德市","listImage":null}]}
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
         * total : 17
         * currentPage : 1
         * currentPgeNumber : 17
         * pageNumber : 10000
         * totalPage : 1
         * hasNextPage : false
         * rows : [{"bankID":"102141013013","parentID":"102","name":"中国工商银行承德业务处理中心","shortName":"中国工商银行承德业务处理中心","bankType":null,"bankTypeName":null,"code":"102141013013","cityID":"28feba630deb4873a522c90054159594","cityName":"承德市","listImage":null}]
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
             * bankID : 102141013013
             * parentID : 102
             * name : 中国工商银行承德业务处理中心
             * shortName : 中国工商银行承德业务处理中心
             * bankType : null
             * bankTypeName : null
             * code : 102141013013
             * cityID : 28feba630deb4873a522c90054159594
             * cityName : 承德市
             * listImage : null
             */

            private String bankID;
            private String parentID;
            private String name;
            private String shortName;
            private Object bankType;
            private Object bankTypeName;
            private String code;
            private String cityID;
            private String cityName;
            private Object listImage;

            public String getBankID() {
                return bankID;
            }

            public void setBankID(String bankID) {
                this.bankID = bankID;
            }

            public String getParentID() {
                return parentID;
            }

            public void setParentID(String parentID) {
                this.parentID = parentID;
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

            public Object getBankType() {
                return bankType;
            }

            public void setBankType(Object bankType) {
                this.bankType = bankType;
            }

            public Object getBankTypeName() {
                return bankTypeName;
            }

            public void setBankTypeName(Object bankTypeName) {
                this.bankTypeName = bankTypeName;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getCityID() {
                return cityID;
            }

            public void setCityID(String cityID) {
                this.cityID = cityID;
            }

            public String getCityName() {
                return cityName;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public Object getListImage() {
                return listImage;
            }

            public void setListImage(Object listImage) {
                this.listImage = listImage;
            }
        }
    }
}
