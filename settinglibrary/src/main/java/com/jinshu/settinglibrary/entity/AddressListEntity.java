package com.jinshu.settinglibrary.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Create on 2019/10/10 16:50 by bll
 */


public class AddressListEntity implements Serializable{

    private DataInfo data;

    public DataInfo getData() {
        return data;
    }

    public void setData(DataInfo data) {
        this.data = data;
    }

    public static class DataInfo implements Serializable{
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

        public static class RowsInfo implements Serializable{
            private String memberAddressID;
            private String name;
            private String shortName;
            private String roomName;
            private String contactName;
            private String contactTitleID;
            private String contactTitleName;
            private String phone;
            private int isDefault;
            private String shopID;
            private String cityID;
            private String cityName;
            private String districtID;
            private String districtName;
            private String mapX;
            private String mapY;
            private String sendTime;
            private String floorNumber;
            private String isElevator;
            private String shengID;
            private String shengName;
            private String shiID;
            private String shiName;
            private String xianID;
            private String xianName;
            private String zhenID;
            private String zhenName;
            private int addType;

            public String getMemberAddressID() {
                return memberAddressID;
            }

            public void setMemberAddressID(String memberAddressID) {
                this.memberAddressID = memberAddressID;
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

            public String getRoomName() {
                return roomName;
            }

            public void setRoomName(String roomName) {
                this.roomName = roomName;
            }

            public String getContactName() {
                return contactName;
            }

            public void setContactName(String contactName) {
                this.contactName = contactName;
            }

            public String getContactTitleID() {
                return contactTitleID;
            }

            public void setContactTitleID(String contactTitleID) {
                this.contactTitleID = contactTitleID;
            }

            public String getContactTitleName() {
                return contactTitleName;
            }

            public void setContactTitleName(String contactTitleName) {
                this.contactTitleName = contactTitleName;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public int getIsDefault() {
                return isDefault;
            }

            public void setIsDefault(int isDefault) {
                this.isDefault = isDefault;
            }

            public String getShopID() {
                return shopID;
            }

            public void setShopID(String shopID) {
                this.shopID = shopID;
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

            public String getDistrictID() {
                return districtID;
            }

            public void setDistrictID(String districtID) {
                this.districtID = districtID;
            }

            public String getDistrictName() {
                return districtName;
            }

            public void setDistrictName(String districtName) {
                this.districtName = districtName;
            }

            public String getMapX() {
                return mapX;
            }

            public void setMapX(String mapX) {
                this.mapX = mapX;
            }

            public String getMapY() {
                return mapY;
            }

            public void setMapY(String mapY) {
                this.mapY = mapY;
            }

            public String getSendTime() {
                return sendTime;
            }

            public void setSendTime(String sendTime) {
                this.sendTime = sendTime;
            }

            public String getFloorNumber() {
                return floorNumber;
            }

            public void setFloorNumber(String floorNumber) {
                this.floorNumber = floorNumber;
            }

            public String getIsElevator() {
                return isElevator;
            }

            public void setIsElevator(String isElevator) {
                this.isElevator = isElevator;
            }

            public String getShengID() {
                return shengID;
            }

            public void setShengID(String shengID) {
                this.shengID = shengID;
            }

            public String getShengName() {
                return shengName;
            }

            public void setShengName(String shengName) {
                this.shengName = shengName;
            }

            public String getShiID() {
                return shiID;
            }

            public void setShiID(String shiID) {
                this.shiID = shiID;
            }

            public String getShiName() {
                return shiName;
            }

            public void setShiName(String shiName) {
                this.shiName = shiName;
            }

            public String getXianID() {
                return xianID;
            }

            public void setXianID(String xianID) {
                this.xianID = xianID;
            }

            public String getXianName() {
                return xianName;
            }

            public void setXianName(String xianName) {
                this.xianName = xianName;
            }

            public String getZhenID() {
                return zhenID;
            }

            public void setZhenID(String zhenID) {
                this.zhenID = zhenID;
            }

            public String getZhenName() {
                return zhenName;
            }

            public void setZhenName(String zhenName) {
                this.zhenName = zhenName;
            }

            public int getAddType() {
                return addType;
            }

            public void setAddType(int addType) {
                this.addType = addType;
            }
        }
    }
}
