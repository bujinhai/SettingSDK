package com.jinshu.settinglibrary.entity;

/**
 * Create on 2019/10/28 14:14 by bll
 */


public class InvoiceDetailEntity {


    /**
     * memberInvoiceDefineDto : {"id":"ddd99e593415422b8092f0cc4ef1a407","memberInvoiceDefineID":"ddd99e593415422b8092f0cc4ef1a407","name":"测试","shortName":"测试","invoiceType":1,"taxType":1,"taxRate":null,"orderSeq":0,"taxCode":null,"address":null,"phone":null,"bankName":null,"bankAccount":null,"isDefault":0}
     */

    private MemberInvoiceDefineDtoInfo memberInvoiceDefineDto;

    public MemberInvoiceDefineDtoInfo getMemberInvoiceDefineDto() {
        return memberInvoiceDefineDto;
    }

    public void setMemberInvoiceDefineDto(MemberInvoiceDefineDtoInfo memberInvoiceDefineDto) {
        this.memberInvoiceDefineDto = memberInvoiceDefineDto;
    }

    public static class MemberInvoiceDefineDtoInfo {
        /**
         * id : ddd99e593415422b8092f0cc4ef1a407
         * memberInvoiceDefineID : ddd99e593415422b8092f0cc4ef1a407
         * name : 测试
         * shortName : 测试
         * invoiceType : 1
         * taxType : 1
         * taxRate : null
         * orderSeq : 0
         * taxCode : null
         * address : null
         * phone : null
         * bankName : null
         * bankAccount : null
         * isDefault : 0
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
