package com.jinshu.settinglibrary.entity;

import java.util.List;

/**
 * Create on 2019/10/28 14:14 by bll
 */


public class InvoiceEntity {


    /**
     * data : {"total":2,"currentPage":1,"currentPgeNumber":2,"pageNumber":10,"totalPage":1,"hasNextPage":false,"rows":[{"id":"4c1e8381e4564389878d17bfa0df3a12","memberInvoiceDefineID":"4c1e8381e4564389878d17bfa0df3a12","name":"哈哈","shortName":"1","invoiceType":1,"taxType":1,"taxRate":null,"orderSeq":0,"taxCode":"19464898","address":"上海市","phone":"14949725","bankName":"中国银行","bankAccount":"123443343","isDefault":1}]}
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
         * rows : [{"id":"4c1e8381e4564389878d17bfa0df3a12","memberInvoiceDefineID":"4c1e8381e4564389878d17bfa0df3a12","name":"哈哈","shortName":"1","invoiceType":1,"taxType":1,"taxRate":null,"orderSeq":0,"taxCode":"19464898","address":"上海市","phone":"14949725","bankName":"中国银行","bankAccount":"123443343","isDefault":1}]
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
             * id : 4c1e8381e4564389878d17bfa0df3a12
             * memberInvoiceDefineID : 4c1e8381e4564389878d17bfa0df3a12
             * name : 哈哈
             * shortName : 1
             * invoiceType : 1
             * taxType : 1
             * taxRate : null
             * orderSeq : 0
             * taxCode : 19464898
             * address : 上海市
             * phone : 14949725
             * bankName : 中国银行
             * bankAccount : 123443343
             * isDefault : 1
             */

            private String id;
            private String memberInvoiceDefineID;
            private String name;
            private String shortName;
            private int invoiceType;
            private int taxType;
            private String taxRate;
            private int orderSeq;
            private String taxCode;
            private String address;
            private String phone;
            private String bankName;
            private String bankAccount;
            private int isDefault;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getMemberInvoiceDefineID() {
                return memberInvoiceDefineID;
            }

            public void setMemberInvoiceDefineID(String memberInvoiceDefineID) {
                this.memberInvoiceDefineID = memberInvoiceDefineID;
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

            public int getInvoiceType() {
                return invoiceType;
            }

            public void setInvoiceType(int invoiceType) {
                this.invoiceType = invoiceType;
            }

            public int getTaxType() {
                return taxType;
            }

            public void setTaxType(int taxType) {
                this.taxType = taxType;
            }

            public String getTaxRate() {
                return taxRate;
            }

            public void setTaxRate(String taxRate) {
                this.taxRate = taxRate;
            }

            public int getOrderSeq() {
                return orderSeq;
            }

            public void setOrderSeq(int orderSeq) {
                this.orderSeq = orderSeq;
            }

            public String getTaxCode() {
                return taxCode;
            }

            public void setTaxCode(String taxCode) {
                this.taxCode = taxCode;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getBankName() {
                return bankName;
            }

            public void setBankName(String bankName) {
                this.bankName = bankName;
            }

            public String getBankAccount() {
                return bankAccount;
            }

            public void setBankAccount(String bankAccount) {
                this.bankAccount = bankAccount;
            }

            public int getIsDefault() {
                return isDefault;
            }

            public void setIsDefault(int isDefault) {
                this.isDefault = isDefault;
            }
        }
    }
}
