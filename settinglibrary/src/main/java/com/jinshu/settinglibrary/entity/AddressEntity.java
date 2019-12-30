package com.jinshu.settinglibrary.entity;

import java.util.List;

/**
 * Create on 2019/10/9 17:23 by bll
 */


public class AddressEntity {


    /**
     * data : {"total":10,"currentPage":1,"currentPgeNumber":10,"pageNumber":10,"totalPage":1,"hasNextPage":false,"rows":[{"cityID":"04a90cc0ab62433081c112f39247ca9e","parentID":"0a75298e0df441f4b5d89d1ecb7428e2","name":"钦州市","shortName":"钦州市","orderSeq":318,"standardCode":"20","myCode":"1224","airCode":null,"mapX":"108.6387980564235","mapY":"21.973350465312727","isLeaf":0},{"cityID":"09cca63bf9b24b958cfc27639ba62d15","parentID":"0a75298e0df441f4b5d89d1ecb7428e2","name":"贵港市","shortName":"贵港市","orderSeq":315,"standardCode":"20","myCode":"1225","airCode":null,"mapX":"109.61370755657885","mapY":"23.10337316440881","isLeaf":0},{"cityID":"0f0865bdc632493c9a48fcf450017f76","parentID":"0a75298e0df441f4b5d89d1ecb7428e2","name":"南宁市","shortName":"南宁市","orderSeq":308,"standardCode":"20","myCode":"1218","airCode":null,"mapX":"108.29723355586638","mapY":"22.80649293560261","isLeaf":0},{"cityID":"3c6712afc6b649ee87c857fe7a5e4ad2","parentID":"0a75298e0df441f4b5d89d1ecb7428e2","name":"崇左市","shortName":"崇左市","orderSeq":309,"standardCode":"20","myCode":"1231","airCode":null,"mapX":"107.35732203836824","mapY":"22.415455296546437","isLeaf":0},{"cityID":"4ecdb674fb624c4bb60d0554a14c1fa4","parentID":"0a75298e0df441f4b5d89d1ecb7428e2","name":"桂林市","shortName":"桂林市","orderSeq":312,"standardCode":"20","myCode":"1220","airCode":null,"mapX":"110.26092014748276","mapY":"25.262901245955238","isLeaf":0},{"cityID":"56b4f2daa8d647a9b5716ae131a25b21","parentID":"0a75298e0df441f4b5d89d1ecb7428e2","name":"柳州市","shortName":"柳州市","orderSeq":311,"standardCode":"20","myCode":"1219","airCode":null,"mapX":"109.42240181015114","mapY":"24.329053352467223","isLeaf":0},{"cityID":"573809e4fc55468a871b046629cf4f6d","parentID":"0a75298e0df441f4b5d89d1ecb7428e2","name":"贺州市","shortName":"贺州市","orderSeq":314,"standardCode":"20","myCode":"1228","airCode":null,"mapX":"111.5525941788367","mapY":"24.41105354711281","isLeaf":0},{"cityID":"6afdd3d9f49e497ca176f110a6c52638","parentID":"0a75298e0df441f4b5d89d1ecb7428e2","name":"防城港市","shortName":"防城港市","orderSeq":307,"standardCode":"20","myCode":"1223","airCode":null,"mapX":"108.35179115286083","mapY":"21.61739847047181","isLeaf":0},{"cityID":"746c0dfa681a495e90e6a193b4b6e8f0","parentID":"0a75298e0df441f4b5d89d1ecb7428e2","name":"玉林市","shortName":"玉林市","orderSeq":316,"standardCode":"20","myCode":"1226","airCode":null,"mapX":"110.15167631614493","mapY":"22.643973608377276","isLeaf":0},{"cityID":"9b4883276da94902b96fef079248687a","parentID":"0a75298e0df441f4b5d89d1ecb7428e2","name":"北海市","shortName":"北海市","orderSeq":320,"standardCode":"20","myCode":"1222","airCode":null,"mapX":"109.12262791919323","mapY":"21.472718235009687","isLeaf":0}]}
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
         * total : 10
         * currentPage : 1
         * currentPgeNumber : 10
         * pageNumber : 10
         * totalPage : 1
         * hasNextPage : false
         * rows : [{"cityID":"04a90cc0ab62433081c112f39247ca9e","parentID":"0a75298e0df441f4b5d89d1ecb7428e2","name":"钦州市","shortName":"钦州市","orderSeq":318,"standardCode":"20","myCode":"1224","airCode":null,"mapX":"108.6387980564235","mapY":"21.973350465312727","isLeaf":0},{"cityID":"09cca63bf9b24b958cfc27639ba62d15","parentID":"0a75298e0df441f4b5d89d1ecb7428e2","name":"贵港市","shortName":"贵港市","orderSeq":315,"standardCode":"20","myCode":"1225","airCode":null,"mapX":"109.61370755657885","mapY":"23.10337316440881","isLeaf":0},{"cityID":"0f0865bdc632493c9a48fcf450017f76","parentID":"0a75298e0df441f4b5d89d1ecb7428e2","name":"南宁市","shortName":"南宁市","orderSeq":308,"standardCode":"20","myCode":"1218","airCode":null,"mapX":"108.29723355586638","mapY":"22.80649293560261","isLeaf":0},{"cityID":"3c6712afc6b649ee87c857fe7a5e4ad2","parentID":"0a75298e0df441f4b5d89d1ecb7428e2","name":"崇左市","shortName":"崇左市","orderSeq":309,"standardCode":"20","myCode":"1231","airCode":null,"mapX":"107.35732203836824","mapY":"22.415455296546437","isLeaf":0},{"cityID":"4ecdb674fb624c4bb60d0554a14c1fa4","parentID":"0a75298e0df441f4b5d89d1ecb7428e2","name":"桂林市","shortName":"桂林市","orderSeq":312,"standardCode":"20","myCode":"1220","airCode":null,"mapX":"110.26092014748276","mapY":"25.262901245955238","isLeaf":0},{"cityID":"56b4f2daa8d647a9b5716ae131a25b21","parentID":"0a75298e0df441f4b5d89d1ecb7428e2","name":"柳州市","shortName":"柳州市","orderSeq":311,"standardCode":"20","myCode":"1219","airCode":null,"mapX":"109.42240181015114","mapY":"24.329053352467223","isLeaf":0},{"cityID":"573809e4fc55468a871b046629cf4f6d","parentID":"0a75298e0df441f4b5d89d1ecb7428e2","name":"贺州市","shortName":"贺州市","orderSeq":314,"standardCode":"20","myCode":"1228","airCode":null,"mapX":"111.5525941788367","mapY":"24.41105354711281","isLeaf":0},{"cityID":"6afdd3d9f49e497ca176f110a6c52638","parentID":"0a75298e0df441f4b5d89d1ecb7428e2","name":"防城港市","shortName":"防城港市","orderSeq":307,"standardCode":"20","myCode":"1223","airCode":null,"mapX":"108.35179115286083","mapY":"21.61739847047181","isLeaf":0},{"cityID":"746c0dfa681a495e90e6a193b4b6e8f0","parentID":"0a75298e0df441f4b5d89d1ecb7428e2","name":"玉林市","shortName":"玉林市","orderSeq":316,"standardCode":"20","myCode":"1226","airCode":null,"mapX":"110.15167631614493","mapY":"22.643973608377276","isLeaf":0},{"cityID":"9b4883276da94902b96fef079248687a","parentID":"0a75298e0df441f4b5d89d1ecb7428e2","name":"北海市","shortName":"北海市","orderSeq":320,"standardCode":"20","myCode":"1222","airCode":null,"mapX":"109.12262791919323","mapY":"21.472718235009687","isLeaf":0}]
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
             * cityID : 04a90cc0ab62433081c112f39247ca9e
             * parentID : 0a75298e0df441f4b5d89d1ecb7428e2
             * name : 钦州市
             * shortName : 钦州市
             * orderSeq : 318
             * standardCode : 20
             * myCode : 1224
             * airCode : null
             * mapX : 108.6387980564235
             * mapY : 21.973350465312727
             * isLeaf : 0
             */

            private String cityID;
            private String parentID;
            private String name;
            private String shortName;
            private int orderSeq;
            private String standardCode;
            private String myCode;
            private Object airCode;
            private String mapX;
            private String mapY;
            private int isLeaf;
            public String addressType;//1：省/市  2：市  3：区/县  4：街道/乡

            public String getCityID() {
                return cityID;
            }

            public void setCityID(String cityID) {
                this.cityID = cityID;
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

            public int getOrderSeq() {
                return orderSeq;
            }

            public void setOrderSeq(int orderSeq) {
                this.orderSeq = orderSeq;
            }

            public String getStandardCode() {
                return standardCode;
            }

            public void setStandardCode(String standardCode) {
                this.standardCode = standardCode;
            }

            public String getMyCode() {
                return myCode;
            }

            public void setMyCode(String myCode) {
                this.myCode = myCode;
            }

            public Object getAirCode() {
                return airCode;
            }

            public void setAirCode(Object airCode) {
                this.airCode = airCode;
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

            public int getIsLeaf() {
                return isLeaf;
            }

            public void setIsLeaf(int isLeaf) {
                this.isLeaf = isLeaf;
            }
        }
    }
}
