package com.jinshu.settinglibrary.entity;

import java.util.List;

/**
 * Create on 2019/10/17 16:28 by bll
 */


public class BankListEntity {


    /**
     * data : {"total":4,"currentPage":1,"currentPgeNumber":4,"pageNumber":10000,"totalPage":1,"hasNextPage":false,"rows":[{"applicationBankID":"8a2f462a6aa17470016aa47bb2330f3a","name":"中国工商银行","bankID":"102","bankName":"中国工商银行","bankType":"6cbcfa6231ac4f6498a3d3e1a06b0cb8","bankListImage":"http://admin.haoju.me:8082/kpbase//group/M00/59/37/00B0-417B-4321-BC5A-3852BF2136EE.png","listImage":"http://admin.haoju.me:8082/kpbase//group/M00/59/37/00B0-417B-4321-BC5A-3852BF2136EE.png"},{"applicationBankID":"8a2f462a6aa17470016aa47bb2520f3b","name":"中国农业银行","bankID":"103","bankName":"中国农业银行","bankType":"6cbcfa6231ac4f6498a3d3e1a06b0cb8","bankListImage":"http://admin.haoju.me:8082/kpbase//group/M00/19/7E/A82B-C768-461D-93E5-41786964CA96.png","listImage":"http://admin.haoju.me:8082/kpbase//group/M00/19/7E/A82B-C768-461D-93E5-41786964CA96.png"},{"applicationBankID":"8a2f462a6aa17470016aa47bb2720f3c","name":"中国银行","bankID":"104","bankName":"中国银行","bankType":"6cbcfa6231ac4f6498a3d3e1a06b0cb8","bankListImage":"http://admin.haoju.me:8082/kpbase//group/M00/77/EC/8E83-AA3D-4148-BAAE-9EBD2F5631E3.png","listImage":"http://admin.haoju.me:8082/kpbase//group/M00/77/EC/8E83-AA3D-4148-BAAE-9EBD2F5631E3.png"},{"applicationBankID":"8a2f462a6aa17470016aa47bb28f0f3d","name":"中国建设银行","bankID":"105","bankName":"中国建设银行","bankType":"6cbcfa6231ac4f6498a3d3e1a06b0cb8","bankListImage":"http://admin.haoju.me:8082/kpbase//group/M00/54/FA/7A6F-F62D-4B8E-9AAD-F98F56E3B32C.png","listImage":"http://admin.haoju.me:8082/kpbase//group/M00/54/FA/7A6F-F62D-4B8E-9AAD-F98F56E3B32C.png"}]}
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
         * total : 4
         * currentPage : 1
         * currentPgeNumber : 4
         * pageNumber : 10000
         * totalPage : 1
         * hasNextPage : false
         * rows : [{"applicationBankID":"8a2f462a6aa17470016aa47bb2330f3a","name":"中国工商银行","bankID":"102","bankName":"中国工商银行","bankType":"6cbcfa6231ac4f6498a3d3e1a06b0cb8","bankListImage":"http://admin.haoju.me:8082/kpbase//group/M00/59/37/00B0-417B-4321-BC5A-3852BF2136EE.png","listImage":"http://admin.haoju.me:8082/kpbase//group/M00/59/37/00B0-417B-4321-BC5A-3852BF2136EE.png"},{"applicationBankID":"8a2f462a6aa17470016aa47bb2520f3b","name":"中国农业银行","bankID":"103","bankName":"中国农业银行","bankType":"6cbcfa6231ac4f6498a3d3e1a06b0cb8","bankListImage":"http://admin.haoju.me:8082/kpbase//group/M00/19/7E/A82B-C768-461D-93E5-41786964CA96.png","listImage":"http://admin.haoju.me:8082/kpbase//group/M00/19/7E/A82B-C768-461D-93E5-41786964CA96.png"},{"applicationBankID":"8a2f462a6aa17470016aa47bb2720f3c","name":"中国银行","bankID":"104","bankName":"中国银行","bankType":"6cbcfa6231ac4f6498a3d3e1a06b0cb8","bankListImage":"http://admin.haoju.me:8082/kpbase//group/M00/77/EC/8E83-AA3D-4148-BAAE-9EBD2F5631E3.png","listImage":"http://admin.haoju.me:8082/kpbase//group/M00/77/EC/8E83-AA3D-4148-BAAE-9EBD2F5631E3.png"},{"applicationBankID":"8a2f462a6aa17470016aa47bb28f0f3d","name":"中国建设银行","bankID":"105","bankName":"中国建设银行","bankType":"6cbcfa6231ac4f6498a3d3e1a06b0cb8","bankListImage":"http://admin.haoju.me:8082/kpbase//group/M00/54/FA/7A6F-F62D-4B8E-9AAD-F98F56E3B32C.png","listImage":"http://admin.haoju.me:8082/kpbase//group/M00/54/FA/7A6F-F62D-4B8E-9AAD-F98F56E3B32C.png"}]
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
             * applicationBankID : 8a2f462a6aa17470016aa47bb2330f3a
             * name : 中国工商银行
             * bankID : 102
             * bankName : 中国工商银行
             * bankType : 6cbcfa6231ac4f6498a3d3e1a06b0cb8
             * bankListImage : http://admin.haoju.me:8082/kpbase//group/M00/59/37/00B0-417B-4321-BC5A-3852BF2136EE.png
             * listImage : http://admin.haoju.me:8082/kpbase//group/M00/59/37/00B0-417B-4321-BC5A-3852BF2136EE.png
             */

            private String applicationBankID;
            private String name;
            private String bankID;
            private String bankName;
            private String bankType;
            private String bankListImage;
            private String listImage;

            public String getApplicationBankID() {
                return applicationBankID;
            }

            public void setApplicationBankID(String applicationBankID) {
                this.applicationBankID = applicationBankID;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getBankID() {
                return bankID;
            }

            public void setBankID(String bankID) {
                this.bankID = bankID;
            }

            public String getBankName() {
                return bankName;
            }

            public void setBankName(String bankName) {
                this.bankName = bankName;
            }

            public String getBankType() {
                return bankType;
            }

            public void setBankType(String bankType) {
                this.bankType = bankType;
            }

            public String getBankListImage() {
                return bankListImage;
            }

            public void setBankListImage(String bankListImage) {
                this.bankListImage = bankListImage;
            }

            public String getListImage() {
                return listImage;
            }

            public void setListImage(String listImage) {
                this.listImage = listImage;
            }
        }
    }
}
