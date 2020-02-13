package com.jinshu.settinglibrary.entity;

import java.util.List;

/**
 * Created on 2020-02-12 by bll
 */

public class GenderEntity {


    /**
     * data : {"total":2,"currentPage":1,"currentPgeNumber":2,"pageNumber":10,"totalPage":1,"hasNextPage":false,"rows":[{"categoryID":"1d88af067fff4d6e95575e77f7365029","name":"先生","shortName":"mister","parentID":"ab2907ce6db142d2abb64d0adef5bc69","largeIcon":null,"smallIcon":null,"orderSeq":0,"depth":3,"isLeaf":1,"parameter1":null,"parameter2":null,"parameter3":"1","industryNum":0},{"categoryID":"384aba23a5ac4344b5848250d793cd64","name":"女士","shortName":"lady","parentID":"ab2907ce6db142d2abb64d0adef5bc69","largeIcon":null,"smallIcon":null,"orderSeq":1,"depth":3,"isLeaf":1,"parameter1":null,"parameter2":null,"parameter3":null,"industryNum":0}]}
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
         * rows : [{"categoryID":"1d88af067fff4d6e95575e77f7365029","name":"先生","shortName":"mister","parentID":"ab2907ce6db142d2abb64d0adef5bc69","largeIcon":null,"smallIcon":null,"orderSeq":0,"depth":3,"isLeaf":1,"parameter1":null,"parameter2":null,"parameter3":"1","industryNum":0},{"categoryID":"384aba23a5ac4344b5848250d793cd64","name":"女士","shortName":"lady","parentID":"ab2907ce6db142d2abb64d0adef5bc69","largeIcon":null,"smallIcon":null,"orderSeq":1,"depth":3,"isLeaf":1,"parameter1":null,"parameter2":null,"parameter3":null,"industryNum":0}]
         */

        private int total;
        private int currentPage;
        private int currentPgeNumber;
        private int pageNumber;
        private int totalPage;
        private boolean hasNextPage;
        private List<GenderInfo> rows;

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

        public List<GenderInfo> getRows() {
            return rows;
        }

        public void setRows(List<GenderInfo> rows) {
            this.rows = rows;
        }
    }
}
