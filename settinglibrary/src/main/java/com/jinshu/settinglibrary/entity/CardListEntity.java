package com.jinshu.settinglibrary.entity;

import java.util.List;

/**
 * Create on 2019/10/17 17:52 by bll
 */


public class CardListEntity {

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
         * rows : [{"id":"3843582995e54108ae46fc043837f3a2","memberBankID":"3843582995e54108ae46fc043837f3a2","name":"黄杰","memberID":"8a2f462a6d1e0d64016d1e2f4709004c","bankID":null,"bankName":"中国工商银行股份有限公司上海市普安路支行","shortName":"中国工商银行","cardCode":"123456789","isDefault":1,"cityID":null,"cityName":null,"phoneNumber":"13646148888","idCard":null,"bankCardName":null,"debitType":null,"bindingMode":"1","bindingDate":1571714795000,"bindingDateStr":"2019-10-22 11:26:35","firstPayDate":null,"firstPayDateStr":null,"lastPayDate":null,"lastPayDateStr":null,"firstWithdrawDate":null,"firstWithdrawDateStr":null,"lastWithDrawDate":null,"lastWithDrawDateStr":null}]
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
             * id : b6715f2640c94dfb8c595c3c7c1be23b
             * memberBankID : b6715f2640c94dfb8c595c3c7c1be23b
             * name : 哈喇子
             * memberID : 8a2f462a6d1e0d64016d1e2f4709004c
             * bankID : null
             * bankName : 中国银行
             * bankListImage : null
             * bankFaceImage : null
             * shortName : 中国银行上海市中银大厦支行
             * cardCode : 12547851369854
             * isDefault : 1
             * cityID : null
             * cityName : null
             * phoneNumber : 13646148888
             * idCard : null
             * bankCardName : null
             * debitType : null
             * bindingMode : 1
             * bindingDate : 1572234094000
             * bindingDateStr : 2019-10-28 11:41:34
             * firstPayDate : null
             * firstPayDateStr : null
             * lastPayDate : null
             * lastPayDateStr : null
             * firstWithdrawDate : null
             * firstWithdrawDateStr : null
             * lastWithDrawDate : null
             * lastWithDrawDateStr : null
             */

            private String id;
            private String memberBankID;
            private String name;
            private String memberID;
            private String bankID;
            private String bankName;
            private String bankListImage;
            private String bankFaceImage;
            private String shortName;
            private String cardCode;
            private int isDefault;
            private String cityID;
            private String cityName;
            private String phoneNumber;
            private String idCard;
            private String bankCardName;
            private String debitType;
            private String bindingMode;
            private long bindingDate;
            private String bindingDateStr;
            private String firstPayDate;
            private String firstPayDateStr;
            private String lastPayDate;
            private String lastPayDateStr;
            private String firstWithdrawDate;
            private String firstWithdrawDateStr;
            private String lastWithDrawDate;
            private String lastWithDrawDateStr;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getMemberBankID() {
                return memberBankID;
            }

            public void setMemberBankID(String memberBankID) {
                this.memberBankID = memberBankID;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getMemberID() {
                return memberID;
            }

            public void setMemberID(String memberID) {
                this.memberID = memberID;
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

            public String getBankListImage() {
                return bankListImage;
            }

            public void setBankListImage(String bankListImage) {
                this.bankListImage = bankListImage;
            }

            public String getBankFaceImage() {
                return bankFaceImage;
            }

            public void setBankFaceImage(String bankFaceImage) {
                this.bankFaceImage = bankFaceImage;
            }

            public String getShortName() {
                return shortName;
            }

            public void setShortName(String shortName) {
                this.shortName = shortName;
            }

            public String getCardCode() {
                return cardCode;
            }

            public void setCardCode(String cardCode) {
                this.cardCode = cardCode;
            }

            public int getIsDefault() {
                return isDefault;
            }

            public void setIsDefault(int isDefault) {
                this.isDefault = isDefault;
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

            public String getPhoneNumber() {
                return phoneNumber;
            }

            public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
            }

            public String getIdCard() {
                return idCard;
            }

            public void setIdCard(String idCard) {
                this.idCard = idCard;
            }

            public String getBankCardName() {
                return bankCardName;
            }

            public void setBankCardName(String bankCardName) {
                this.bankCardName = bankCardName;
            }

            public String getDebitType() {
                return debitType;
            }

            public void setDebitType(String debitType) {
                this.debitType = debitType;
            }

            public String getBindingMode() {
                return bindingMode;
            }

            public void setBindingMode(String bindingMode) {
                this.bindingMode = bindingMode;
            }

            public long getBindingDate() {
                return bindingDate;
            }

            public void setBindingDate(long bindingDate) {
                this.bindingDate = bindingDate;
            }

            public String getBindingDateStr() {
                return bindingDateStr;
            }

            public void setBindingDateStr(String bindingDateStr) {
                this.bindingDateStr = bindingDateStr;
            }

            public String getFirstPayDate() {
                return firstPayDate;
            }

            public void setFirstPayDate(String firstPayDate) {
                this.firstPayDate = firstPayDate;
            }

            public String getFirstPayDateStr() {
                return firstPayDateStr;
            }

            public void setFirstPayDateStr(String firstPayDateStr) {
                this.firstPayDateStr = firstPayDateStr;
            }

            public String getLastPayDate() {
                return lastPayDate;
            }

            public void setLastPayDate(String lastPayDate) {
                this.lastPayDate = lastPayDate;
            }

            public String getLastPayDateStr() {
                return lastPayDateStr;
            }

            public void setLastPayDateStr(String lastPayDateStr) {
                this.lastPayDateStr = lastPayDateStr;
            }

            public String getFirstWithdrawDate() {
                return firstWithdrawDate;
            }

            public void setFirstWithdrawDate(String firstWithdrawDate) {
                this.firstWithdrawDate = firstWithdrawDate;
            }

            public String getFirstWithdrawDateStr() {
                return firstWithdrawDateStr;
            }

            public void setFirstWithdrawDateStr(String firstWithdrawDateStr) {
                this.firstWithdrawDateStr = firstWithdrawDateStr;
            }

            public String getLastWithDrawDate() {
                return lastWithDrawDate;
            }

            public void setLastWithDrawDate(String lastWithDrawDate) {
                this.lastWithDrawDate = lastWithDrawDate;
            }

            public String getLastWithDrawDateStr() {
                return lastWithDrawDateStr;
            }

            public void setLastWithDrawDateStr(String lastWithDrawDateStr) {
                this.lastWithDrawDateStr = lastWithDrawDateStr;
            }
        }
    }
}
