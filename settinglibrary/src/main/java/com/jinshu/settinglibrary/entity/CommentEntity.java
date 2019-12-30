package com.jinshu.settinglibrary.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Create on 2019/9/19 11:02 by bll
 */


public class CommentEntity implements Serializable{

    private DataInfo data;

    public DataInfo getData() {
        return data;
    }

    public void setData(DataInfo data) {
        this.data = data;
    }

    public static class DataInfo implements Serializable{
        /**
         * total : 1
         * currentPage : 1
         * currentPgeNumber : 1
         * pageNumber : 10
         * totalPage : 1
         * hasNextPage : false
         * rows : [{"discussID":"8a2f462a6a4e23b5016a4e6e9f6b0258","memberID":"8a2f462a638069ef016380786655012e","memberName":"刘宗霖","memberAvatar":"http://thirdwx.qlogo.cn/mmopen/6KrRBXESXt5I8ShyGAic7Fo6YyojKcNvoqeVvfJ1QzWCliaCX5bZzxe48UYu32QwpSMMSwfeHWTRph33cQjq2a6rXoXyyuHpz8/132","memberShortName":"刘宗霖","parentID":"8a2f462a550ed56901551040f67e4041","score":100,"isAnonymous":0,"name":"刘宗霖评论","showContent":"二人","discussTime":1556094033000,"attachmentDtos":[{"id":"8a2f462a6af8d75a016af94d9653026b","orderSeq":20,"name":"刘宗霖测试附件","url":"http://admin.haoju.me:8082/kpbase//group/M00/41/B7/7778-2246-4404-AD3A-23B07302A8E4.jpg"}]}]
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

        public static class RowsInfo implements Serializable{
            /**
             * discussID : 8a2f462a6a4e23b5016a4e6e9f6b0258
             * memberID : 8a2f462a638069ef016380786655012e
             * memberName : 刘宗霖
             * memberAvatar : http://thirdwx.qlogo.cn/mmopen/6KrRBXESXt5I8ShyGAic7Fo6YyojKcNvoqeVvfJ1QzWCliaCX5bZzxe48UYu32QwpSMMSwfeHWTRph33cQjq2a6rXoXyyuHpz8/132
             * memberShortName : 刘宗霖
             * parentID : 8a2f462a550ed56901551040f67e4041
             * score : 100
             * isAnonymous : 0
             * name : 刘宗霖评论
             * showContent : 二人
             * discussTime : 1556094033000
             * attachmentDtos : [{"id":"8a2f462a6af8d75a016af94d9653026b","orderSeq":20,"name":"刘宗霖测试附件","url":"http://admin.haoju.me:8082/kpbase//group/M00/41/B7/7778-2246-4404-AD3A-23B07302A8E4.jpg"}]
             */

            private String discussID;
            private String memberID;
            private String memberName;
            private String memberAvatar;
            private String memberShortName;
            private String parentID;
            private int score;
            private int isAnonymous;
            private String name;
            private String showContent;
            private long discussTime;
            private List<AttachmentDtosInfo> attachmentDtos;

            public String getDiscussID() {
                return discussID;
            }

            public void setDiscussID(String discussID) {
                this.discussID = discussID;
            }

            public String getMemberID() {
                return memberID;
            }

            public void setMemberID(String memberID) {
                this.memberID = memberID;
            }

            public String getMemberName() {
                return memberName;
            }

            public void setMemberName(String memberName) {
                this.memberName = memberName;
            }

            public String getMemberAvatar() {
                return memberAvatar;
            }

            public void setMemberAvatar(String memberAvatar) {
                this.memberAvatar = memberAvatar;
            }

            public String getMemberShortName() {
                return memberShortName;
            }

            public void setMemberShortName(String memberShortName) {
                this.memberShortName = memberShortName;
            }

            public String getParentID() {
                return parentID;
            }

            public void setParentID(String parentID) {
                this.parentID = parentID;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public int getIsAnonymous() {
                return isAnonymous;
            }

            public void setIsAnonymous(int isAnonymous) {
                this.isAnonymous = isAnonymous;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getShowContent() {
                return showContent;
            }

            public void setShowContent(String showContent) {
                this.showContent = showContent;
            }

            public long getDiscussTime() {
                return discussTime;
            }

            public void setDiscussTime(long discussTime) {
                this.discussTime = discussTime;
            }

            public List<AttachmentDtosInfo> getAttachmentDtos() {
                return attachmentDtos;
            }

            public void setAttachmentDtos(List<AttachmentDtosInfo> attachmentDtos) {
                this.attachmentDtos = attachmentDtos;
            }

            public static class AttachmentDtosInfo implements Serializable{
                /**
                 * id : 8a2f462a6af8d75a016af94d9653026b
                 * orderSeq : 20
                 * name : 刘宗霖测试附件
                 * url : http://admin.haoju.me:8082/kpbase//group/M00/41/B7/7778-2246-4404-AD3A-23B07302A8E4.jpg
                 */

                private String id;
                private int orderSeq;
                private String name;
                private String url;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public int getOrderSeq() {
                    return orderSeq;
                }

                public void setOrderSeq(int orderSeq) {
                    this.orderSeq = orderSeq;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }
}
