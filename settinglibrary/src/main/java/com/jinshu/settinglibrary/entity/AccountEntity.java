package com.jinshu.settinglibrary.entity;

import java.util.List;

/**
 * Create on 2019/12/3 10:18 by bll
 */


public class AccountEntity {


    /**
     * data : {"total":100,"currentPage":1,"currentPgeNumber":10,"pageNumber":10,"totalPage":10,"hasNextPage":true,"rows":[{"memberBalanceID":"8a2f462a6c40a90d016c40c701f301e0","name":null,"operateTime":1564454879000,"operateTimeStr":"2019-07-30 10:47:59","orderSeq":0,"balanceType":1,"operateMemberID":null,"operateMemberName":null,"operateMemberAvatar":null,"operateType":"会员资金初始化","objectDefineID":"8a2f462a5a6026cd015a64fe3e920cef","objectID":null,"objectName":null,"amount":0,"fee":0,"balance":0},{"memberBalanceID":"8a2f462a6c40a90d016c40c7020501e1","name":null,"operateTime":1564454879000,"operateTimeStr":"2019-07-30 10:47:59","orderSeq":1,"balanceType":999,"operateMemberID":null,"operateMemberName":null,"operateMemberAvatar":null,"operateType":"13162617992购买商品，平级奖获取","objectDefineID":null,"objectID":"8a2f462a6c3c1fdd016c40c6d25500cb","objectName":"D20190730104702000","amount":200,"fee":0,"balance":200},{"memberBalanceID":"8a2f462a6c40a90d016c40c8cce20206","name":null,"operateTime":1564454997000,"operateTimeStr":"2019-07-30 10:49:57","orderSeq":2,"balanceType":999,"operateMemberID":null,"operateMemberName":null,"operateMemberAvatar":null,"operateType":"13162617992购买商品，平级奖获取","objectDefineID":null,"objectID":"8a2f462a6c3c1fdd016c40c893c300d0","objectName":"D20190730104902003","amount":150,"fee":0,"balance":350},{"memberBalanceID":"8a2f462a6c40a90d016c40c8cd23020e","name":null,"operateTime":1564454997000,"operateTimeStr":"2019-07-30 10:49:57","orderSeq":3,"balanceType":999,"operateMemberID":null,"operateMemberName":null,"operateMemberAvatar":null,"operateType":"13162617992购买商品，平级奖获取","objectDefineID":null,"objectID":"8a2f462a6c3c1fdd016c40c893c300d0","objectName":"D20190730104902003","amount":150,"fee":0,"balance":500},{"memberBalanceID":"8a2f462a6c40a90d016c40cbf4270269","name":null,"operateTime":1564455203000,"operateTimeStr":"2019-07-30 10:53:23","orderSeq":4,"balanceType":999,"operateMemberID":null,"operateMemberName":null,"operateMemberAvatar":null,"operateType":"13162617994购买商品，平级奖获取","objectDefineID":null,"objectID":"8a2f462a6c3c1fdd016c40cba9c000d5","objectName":"D20190730105302005","amount":100,"fee":0,"balance":600},{"memberBalanceID":"8a2f462a6c40a90d016c40dc8f1b028a","name":null,"operateTime":1564456292000,"operateTimeStr":"2019-07-30 11:11:32","orderSeq":5,"balanceType":999,"operateMemberID":null,"operateMemberName":null,"operateMemberAvatar":null,"operateType":"13162617992购买商品，平级奖获取","objectDefineID":null,"objectID":"8a2f462a6c3c1fdd016c40dc361c00da","objectName":"D20190730111102006","amount":100,"fee":0,"balance":700},{"memberBalanceID":"8a2f462a6c40a90d016c40dc8f880292","name":null,"operateTime":1564456292000,"operateTimeStr":"2019-07-30 11:11:32","orderSeq":6,"balanceType":999,"operateMemberID":null,"operateMemberName":null,"operateMemberAvatar":null,"operateType":"13162617992购买商品，平级奖获取","objectDefineID":null,"objectID":"8a2f462a6c3c1fdd016c40dc361c00da","objectName":"D20190730111102006","amount":100,"fee":0,"balance":800},{"memberBalanceID":"8a2f462a6c40a90d016c40dc8fc6029a","name":null,"operateTime":1564456292000,"operateTimeStr":"2019-07-30 11:11:32","orderSeq":7,"balanceType":999,"operateMemberID":null,"operateMemberName":null,"operateMemberAvatar":null,"operateType":"13162617992购买商品，平级奖获取","objectDefineID":null,"objectID":"8a2f462a6c3c1fdd016c40dc361c00da","objectName":"D20190730111102006","amount":100,"fee":0,"balance":900},{"memberBalanceID":"8a2f462a6c40fe11016c40fec4d70029","name":null,"operateTime":1564458534000,"operateTimeStr":"2019-07-30 11:48:54","orderSeq":8,"balanceType":999,"operateMemberID":null,"operateMemberName":null,"operateMemberAvatar":null,"operateType":"13162617992购买商品，平级奖获取","objectDefineID":null,"objectID":"8a2f462a6c3c1fdd016c40fe79b900df","objectName":"D20190730114802008","amount":100,"fee":0,"balance":1000},{"memberBalanceID":"8a2f462a6c410e91016c410f8fc80021","name":null,"operateTime":1564459634000,"operateTimeStr":"2019-07-30 12:07:14","orderSeq":9,"balanceType":999,"operateMemberID":null,"operateMemberName":null,"operateMemberAvatar":null,"operateType":"13162617992购买商品，平级奖获取","objectDefineID":null,"objectID":"8a2f462a6c3c1fdd016c410f815a00e4","objectName":"D20190730120702010","amount":100,"fee":0,"balance":1100}]}
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
         * total : 100
         * currentPage : 1
         * currentPgeNumber : 10
         * pageNumber : 10
         * totalPage : 10
         * hasNextPage : true
         * rows : [{"memberBalanceID":"8a2f462a6c40a90d016c40c701f301e0","name":null,"operateTime":1564454879000,"operateTimeStr":"2019-07-30 10:47:59","orderSeq":0,"balanceType":1,"operateMemberID":null,"operateMemberName":null,"operateMemberAvatar":null,"operateType":"会员资金初始化","objectDefineID":"8a2f462a5a6026cd015a64fe3e920cef","objectID":null,"objectName":null,"amount":0,"fee":0,"balance":0},{"memberBalanceID":"8a2f462a6c40a90d016c40c7020501e1","name":null,"operateTime":1564454879000,"operateTimeStr":"2019-07-30 10:47:59","orderSeq":1,"balanceType":999,"operateMemberID":null,"operateMemberName":null,"operateMemberAvatar":null,"operateType":"13162617992购买商品，平级奖获取","objectDefineID":null,"objectID":"8a2f462a6c3c1fdd016c40c6d25500cb","objectName":"D20190730104702000","amount":200,"fee":0,"balance":200},{"memberBalanceID":"8a2f462a6c40a90d016c40c8cce20206","name":null,"operateTime":1564454997000,"operateTimeStr":"2019-07-30 10:49:57","orderSeq":2,"balanceType":999,"operateMemberID":null,"operateMemberName":null,"operateMemberAvatar":null,"operateType":"13162617992购买商品，平级奖获取","objectDefineID":null,"objectID":"8a2f462a6c3c1fdd016c40c893c300d0","objectName":"D20190730104902003","amount":150,"fee":0,"balance":350},{"memberBalanceID":"8a2f462a6c40a90d016c40c8cd23020e","name":null,"operateTime":1564454997000,"operateTimeStr":"2019-07-30 10:49:57","orderSeq":3,"balanceType":999,"operateMemberID":null,"operateMemberName":null,"operateMemberAvatar":null,"operateType":"13162617992购买商品，平级奖获取","objectDefineID":null,"objectID":"8a2f462a6c3c1fdd016c40c893c300d0","objectName":"D20190730104902003","amount":150,"fee":0,"balance":500},{"memberBalanceID":"8a2f462a6c40a90d016c40cbf4270269","name":null,"operateTime":1564455203000,"operateTimeStr":"2019-07-30 10:53:23","orderSeq":4,"balanceType":999,"operateMemberID":null,"operateMemberName":null,"operateMemberAvatar":null,"operateType":"13162617994购买商品，平级奖获取","objectDefineID":null,"objectID":"8a2f462a6c3c1fdd016c40cba9c000d5","objectName":"D20190730105302005","amount":100,"fee":0,"balance":600},{"memberBalanceID":"8a2f462a6c40a90d016c40dc8f1b028a","name":null,"operateTime":1564456292000,"operateTimeStr":"2019-07-30 11:11:32","orderSeq":5,"balanceType":999,"operateMemberID":null,"operateMemberName":null,"operateMemberAvatar":null,"operateType":"13162617992购买商品，平级奖获取","objectDefineID":null,"objectID":"8a2f462a6c3c1fdd016c40dc361c00da","objectName":"D20190730111102006","amount":100,"fee":0,"balance":700},{"memberBalanceID":"8a2f462a6c40a90d016c40dc8f880292","name":null,"operateTime":1564456292000,"operateTimeStr":"2019-07-30 11:11:32","orderSeq":6,"balanceType":999,"operateMemberID":null,"operateMemberName":null,"operateMemberAvatar":null,"operateType":"13162617992购买商品，平级奖获取","objectDefineID":null,"objectID":"8a2f462a6c3c1fdd016c40dc361c00da","objectName":"D20190730111102006","amount":100,"fee":0,"balance":800},{"memberBalanceID":"8a2f462a6c40a90d016c40dc8fc6029a","name":null,"operateTime":1564456292000,"operateTimeStr":"2019-07-30 11:11:32","orderSeq":7,"balanceType":999,"operateMemberID":null,"operateMemberName":null,"operateMemberAvatar":null,"operateType":"13162617992购买商品，平级奖获取","objectDefineID":null,"objectID":"8a2f462a6c3c1fdd016c40dc361c00da","objectName":"D20190730111102006","amount":100,"fee":0,"balance":900},{"memberBalanceID":"8a2f462a6c40fe11016c40fec4d70029","name":null,"operateTime":1564458534000,"operateTimeStr":"2019-07-30 11:48:54","orderSeq":8,"balanceType":999,"operateMemberID":null,"operateMemberName":null,"operateMemberAvatar":null,"operateType":"13162617992购买商品，平级奖获取","objectDefineID":null,"objectID":"8a2f462a6c3c1fdd016c40fe79b900df","objectName":"D20190730114802008","amount":100,"fee":0,"balance":1000},{"memberBalanceID":"8a2f462a6c410e91016c410f8fc80021","name":null,"operateTime":1564459634000,"operateTimeStr":"2019-07-30 12:07:14","orderSeq":9,"balanceType":999,"operateMemberID":null,"operateMemberName":null,"operateMemberAvatar":null,"operateType":"13162617992购买商品，平级奖获取","objectDefineID":null,"objectID":"8a2f462a6c3c1fdd016c410f815a00e4","objectName":"D20190730120702010","amount":100,"fee":0,"balance":1100}]
         */

        private int total;
        private int currentPage;
        private int currentPgeNumber;
        private int pageNumber;
        private int totalPage;
        private boolean hasNextPage;
        private List<AccountInfo> rows;

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

        public List<AccountInfo> getRows() {
            return rows;
        }

        public void setRows(List<AccountInfo> rows) {
            this.rows = rows;
        }
    }
}
