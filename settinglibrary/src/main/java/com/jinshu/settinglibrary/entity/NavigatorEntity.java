package com.jinshu.settinglibrary.entity;

import java.util.List;

/**
 * Create on 2019/11/1 13:47 by bll
 */


public class NavigatorEntity {


    private DataInfo data;

    public DataInfo getData() {
        return data;
    }

    public void setData(DataInfo data) {
        this.data = data;
    }

    public static class DataInfo {

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
             * articleID : 8a2f462a6e013022016e0188b8680000
             * categoryID : null
             * categoryName : null
             * sourceID : null
             * sourceName : null
             * sourceURL : null
             * title : 【重大突破】老年痴呆药横空出世！明年上市！全球首例！
             * subTitle : null
             * author : null
             * keywords :
             * description : null
             * content : <h1 style="font-size: 28px; margin: 0px; border: 0px; padding: 0px; line-height: 38px; color: rgb(25, 25, 25);">【重大突破】老年痴呆药横空出世！明年上市！全球首例！&nbsp;<span class="article-tag" style="border: 0px; margin: 0px; padding: 0px; display: inline-block; font-weight: 400; position: relative; top: -4px;"></span></h1><p><span class="time" id="news-time" data-val="1571864400000" style="border: 0px; margin: 0px; padding: 0px;">2019-10-24 05:00</span></p><p><article class="article" id="mp-editor" style="border: 0px; margin: 0px; padding: 5px 0px 0px; color: rgb(25, 25, 25); line-height: 1.9; overflow: hidden auto; box-sizing: border-box; outline: 0px; tab-size: 4; overflow-wrap: break-word; width: 640px; font-family: &quot;PingFang SC&quot;, Arial, 微软雅黑, 宋体, simsun, sans-serif; white-space: normal; background-color: rgb(255, 255, 255);"><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">每过3秒钟，全世界就会有一个人，走入阿尔茨海默症世界。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">然而令无数病患家庭心碎的是，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">医学界对此病突破寥寥。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">阿尔兹海默症又称老年痴呆，是一种剥夺精神的疾病，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">与其说它是疾病，不如说它是酷刑，</span><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">一种类似凌迟的酷刑。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0; text-align: center;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/3afe172a36c64aebad497c30a9632126.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">今天，世界上的千万患病者看到了希望，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">阿尔兹海默症首席研究科学家David Reynolds博士说：</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">“这是一场涉及千万人的医疗革命。</span><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">”</span></span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0; text-align: center;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/f9200e5c549a46f4ad21cf1ef82a8500.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">Aducanumab横空出世</span><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;"></span></span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">药，是治疗一种疾病的救命稻草，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">倘若一种疾病有药来应对，我们就可以面面俱到，对症下药。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">但是阿尔兹海默病，无药可医，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">患者都是陷入深渊的人，而崖壁却湿滑无比，</span><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">他怎么也爬不上来。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0; text-align: center;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/c660a57a6770498a808b6b6f8e9e6383.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">每一天，都有250名老人被剥夺了对世界的认识，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">在这一年，有42.5万个父母将忘记自己含辛茹苦抚养成人的孩子的姓名，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">哪怕这将是他们最后忘掉的一件事。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">在没有药物依靠的阿尔兹海默症患者的世界里，黑暗一望无边，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">连缓解症状都成奢望，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">更别说斩草除根。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">老人们在这世上最后的时光里，在经历了无助和绝望的折磨之后，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">再慢慢地撒手人寰。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0; text-align: center;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/c9db83c9d8e64885918a1bbcb99c626a.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">人们总说，希望还是要有的，万一成功了呢，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">没错，热情与执念还是要有的，因为今天，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">曙光到来了。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/3439d27891644721aa0b708fd6996aca.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">Dailymail：首款延缓阿尔兹海默症药物即将推向市场。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">深渊是存在的，但无底深渊不多见，地球不会随便就把什么玩意吃到肚子里。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">阿尔兹海默症，你到头了。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0; text-align: center;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/1473e90dcd4b4d8096815e41073d2fae.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">据《Daily Mail》报道，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">药物巨头Biogen在2019年10月21日当天作出重大宣布，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">医学界集体大震动，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">全世界有史以来第一款延缓阿尔兹海默症即将造福千万人！</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">Biogen这个公司靠不靠谱呢？</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">经常有药物信息虎头蛇尾，Biogen公司是不是也是博眼球之举？</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">我们先看一下Biogen公司在2017年时的状况——</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/c18811eac03b4b0eaa6b6a368ed2dd71.png" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">营业收入11448.8百万美元，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">你没看错，单位是“百万美元”！</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">Biogen是全球生物领域巨头公司，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">科技有谷歌，手机有苹果，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">到了制药，就轮到Biogen说了算了。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/3b784095bdbb4ef688ba459c0f06013c.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">帽子扣好了，小伙伴们也安心了一些，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">我们来仔细看看这款药物吧。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">据报道，这是第一种对阿尔兹海默症有具体疗效的药物，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">千万患者即将因此受益。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">它的名字叫——</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">Aducanumab。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0; text-align: center;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/aaecd705bbc34cc88a462d5bf753e7a0.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">Biogen在STM上的研究</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">在此之前，全世界的生物科学研究人员曾多次尝试开发阿尔兹海默症药物，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">尽管最初噱头满满，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">承诺三年内、五年内、十年内研制出药物，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">但最终的结果往往不如人意，</span><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">或仅停留在“小鼠”阶段，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">就好比朋友电话里表示“马上到！”，却迟迟不出现。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">然而这一次，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">却不再是一个空响炮。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0; text-align: center;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/be158a30d9ea41d982f90a5ccd69813d.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">专家称，Aducanumab是一种“变革性发现”，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">称之为“发现”，而不再只是药物。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">Biogen公司表示，Aducanumab的抗药实验数据非常强大，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">强大到足够在明年年初通过美国、欧洲和日本的药品申请许可。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">对全世界阿尔兹海默病患者来说，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">这无疑是一个里程碑。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0; text-align: center;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/ad2e6e3882f2497cab738caad6f1fd15.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">Aducanumab与阿尔兹海默症</span><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;"></span></span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">想要了解Aducanumab，我们先得稍稍了解阿尔兹海默症，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">了解一下它是如何成为人类无情的杀手的。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">阿尔兹海默症发病是缘由脑内</span><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">β-淀粉样蛋白</span><span style="border: 0px; margin: 0px; padding: 0px;">和</span><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">Tau蛋白</span><span style="border: 0px; margin: 0px; padding: 0px;">出现异常的结果，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">这两种蛋白都是阿尔兹海默症的标志性蛋白，他们在人脑内共同作用，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">损坏学习和记忆所必需的脑细胞。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0; text-align: center;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/98edfff8b1ef4cbd89a72778b5fad0ca.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">其中，β-淀粉样蛋白，是阿尔茨海默病患者认知能力下降和记忆力减退的重要源头。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">于是乎，必须出现一种药物彻底根治β-淀粉样蛋白和Tau蛋白在人脑中的破坏，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">才可以延缓阿兹海默综合症！</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0; text-align: center;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/61d9876575a14097a4f1753992a4c2c7.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">所以目标已经很明确了，找到β-淀粉样蛋白并KO它，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">就成了全世界研究阿尔兹海默症科学家的共同目标！</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">这一目标，现在被Biogen搞定了。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0; text-align: center;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/516e9a9c926a47a6b241462a3408a89e.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">Biogen公司通过靶向定位“β-淀粉样蛋白”，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">成功突破了阿尔兹海默症难关，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">科学家们针对脑部斑块粘性β淀粉样蛋白，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">靶向定位技术</span><span style="border: 0px; margin: 0px; padding: 0px;">，消除β淀粉样蛋白对大脑的影响，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">从而抑制阿尔兹海默症。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0; text-align: center;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/d1cb68a0494540e3a6246add014f5b72.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">理论上是成功了，做出来的药效果如何呢？</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">药物好不好，不看广告，看疗效。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">让人欣喜的是，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">Aducanumab临床了！</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0; text-align: center;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/5ebf9b0a3cbf4747991b21c27aa43f62.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">反复试验，终修成正果</span><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;"></span></span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">起初，在今年3月份，Aducanumab其实并不被看好，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">初步试验结果显示，Aducanumab好像效果甚微，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">但Biogen没有放弃，继续进行着试验。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0; text-align: center;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/ac7bdfd5b7ec430bafc2aef06a9c9be0.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">Biogen公司为了测试Aducanumab的疗效，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">请来了3285名患者做临床试验，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">实验如下：</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">研究人员将这3285名患者分为两组，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">按照规矩——实验组和对照组。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">实验组人数为2000人，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">对照组人数为1285人。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0; text-align: center;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/b788050a7ea14629a35ee812d72968a4.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">实验组的2000名患者每天坚持服用Aducanumab，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">为时18个月。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">而对照组的患者则没有那么好的待遇，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">他们每天服用安慰剂，时长相同。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">随后，研究人员对这两组试验者展开了体检。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0; text-align: center;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/365392961f2748d1ad0d45500a231aac.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">实验组数据表明，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">服用最大剂量药物的患者，疗效最明显，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">病情也几乎没有恶化。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">而对照组则不尽人意，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">1000余名患者依旧是老样子，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">既没有加速恶化，也没有一丝好转。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0; text-align: center;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/ea57491716504e18ae1a78a976965c34.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">实验结果表明，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">Aducanumab可显着减慢阿尔兹海默症的进程，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">这个无底深渊，终于看到头了。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">Biogen的首席执行官米歇尔·沃纳佐斯（Michel Vounatsos）表示，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">该药物已经获得了美国</span><span style="border: 0px; margin: 0px; padding: 0px;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">FDA的明确支持，</span></span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">他说，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">“由于这种毁灭性疾病影响了全世界数以千万计的人，今天的宣布确实令人振奋。”</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">英国阿尔兹海默症研究机构的希拉里·埃文斯（Hilary Evans）则表示，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">“我们正在等待进一步的数据，但这可能是15年来阿尔茨海默氏病的首个新疗法，因此有可能成为一种变革性发现。”</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0; text-align: center;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/6c61fbefdd024a6c9972557ce444378d.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">如今，阿尔兹海默症的黑暗终于即将散去，曙光终于照耀进来，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">在2020年，Biogen公司便计划将Aducanumab打入市场</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">并且表示，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">价格不会很高哦~</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/4effbf1cd5d94581a09ba79c94fa0d11.png" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0; text-align: center;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/ce3f0d237ece4d0db36b9bf7ce7562d3.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">注意饮食，也有益于阿尔兹海默症</span><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;"></span></span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">明年，这款药物即将出现在市场上，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">那么在这之前，家里有患者的小伙伴们，就要注意搭配饮食了！</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">我们来看看哪些</span><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">饮食方法</span><span style="border: 0px; margin: 0px; padding: 0px;">有益于阿尔兹海默症。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0; text-align: center;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/d046a83f29564b35a7e2f534c29e24ee.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">地中海饮食</span></span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">地中海式饮食，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">Mediterranean-DASH Diet Intervention for Neurodegenerative Delay，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">简称：MIND diet</span><span style="border: 0px; margin: 0px; padding: 0px;">，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">是指有利于健康的，简单、清淡以及富含营养的饮食。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/b628eac5f87148a58420e64963c6190e.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">这种特殊的饮食结构强调多吃蔬菜、水果、鱼、海鲜、豆类、坚果类食物，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">其次才是谷类，并且烹饪时要用</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">植物油（含不饱合脂肪酸）</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">来代替动物油（含饱合脂肪酸），</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">尤其提倡用橄榄油。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">过去的几十年里，它已被推广为全世界</span><span style="border: 0px; margin: 0px; padding: 0px;">最健康的饮食模式之一，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">对慢性病和长寿方面一直是有益的。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/7bf40c4769df4bc58ccf64b381b779fb.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">地中海饮食适用于绝大部分成人，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">但是儿童和孕妇的饮食需要某些</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">额外的营养补充。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">不过地中海式饮食，是否适用于老年痴呆症患者呢？</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">答案是肯定的。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/62f21a8c1eb44ff9bb716841b05d3710.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">这样的饮食方式，也能帮助抗击由化学变化引发的大脑炎症，降低胆固醇水平，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">最新研究显示，胆固醇水平也与</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">记忆和思考有关。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/0a6abcb95a7745f892b6f8e2f6edb611.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">美国芝加哥的Rush University去年发表的研究发现，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">长者若如实执行“地中海式饮食”，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">可大幅降低脑退化症的罹患风险达3至5成之多。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">这样高纤维、低脂肪的地中海式饮食习惯将</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">减缓老年痴呆症的病情恶化！</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/cfafd09d684d4367b68352245adfcd8c.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">另一方面，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">据新加坡《联合早报》报道，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">美国哥伦比亚大学医疗中心的医生斯卡米斯在最新一期的《神经病学》杂志上说，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">老年痴呆症患者在进食的时候越严格遵照地中海式饮食，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0; text-align: center;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">生命就能延长越久。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/a0e6f2bfdea44338860b3e8c01d6ed14.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">刚发表的报告是以192名老年痴呆症患者为研究对象，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">目的在了解饮食如何影响病情的演变。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/95f6ee56e6674e638c13067a00ad27b8.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">医生按照这些确诊病人接近地中海式饮食的程度而分成3组，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">然后跟进他们的病情发展长达4.4年。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">在这段研究期间，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">85%的病人逝世。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/966d33ea579346bfa982dcda692a1989.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">研究发现，第二组患者比第三组病人的死亡率少了35%，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">换句话说，第二组人多活了1.33年。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">第一组(最接近地中海式饮食)痴呆病患的死亡风险减少了73%，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">他们多活了将近4年。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">地中海式饮食也因此获得</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">“老年痴呆症福音”的称号！</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/f01a758f1bd543b59699d93bcafd3474.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">椰子油</span></span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">老人痴呆很像第一类或第二类糖尿病，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">它的起因是胰岛素不平衡。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/499063f39e084a1e9102778817bd11cb.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">因为胰岛素出了问题，阻止了脑细胞吸收葡萄糖(glucose)，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">脑细胞所需的能量几乎完全来自葡萄糖</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">没有了葡萄糖，脑细胞就死了。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">那从什么地方找葡萄糖替代品？</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">脑细胞的替代营养是酮(ketones)，</span></span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/6634eda9887c4ab5986f2788240c8930.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">在缺乏糖供应时，脑组织也能利用酮提供的能量，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">但酮不能从维他命中提取、吸收，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">它需要通过中链甘油三酯（Medium Chain Triglycerides，MCT），转移到肝脏中，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">在肝脏中被代谢为酮，</span></span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/0ac4fffbd57d434ea2ac72e4a993ee3c.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">这就是脑细胞的替代营养品！</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">然而，一种平时在货架上就可购买到的食物，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">竟含有大量的MCT，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;"><span style="border: 0px; margin: 0px; padding: 0px;">它就是椰子油！</span></span><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;"><span style="border: 0px; margin: 0px; padding: 0px;">！</span></span></span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/27b561e806cc4fc39122baab90e39d52.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">曾经就有阿兹海默病患者家属用椰子油给患者进行治疗，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">而仅仅才两个星期，该患者再去医院做画钟测试时，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">看到了十分令人惊喜的进步。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/64837a4825734250b6b215cf76b5227e.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">三个星期后，该患者第三次去做智能画钟测试，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">他已经可以画出完整钟表的图案了！</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/1e0aa2b98bf347a181763a316141b17f.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">而这个进步不单单体现在智力方面，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">他的抑郁情绪也有所缓解，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">体力也有了进步。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/a4723e191e92497aa6a80ae160ec5abf.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">在服用了14个月的椰子油后，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">该患者在老年痴呆症测试中，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">认知能力提升了6个百分点，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">日常生活能力也提升了14个百分点！</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/ad17987acde04756ac42a4ecba3e4b26.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">相比下，那些未服用过椰子油的患者，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">这些能力测试，却同比下降了！</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">这名患者家属名叫Mary，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">她在2011年，推出了一本名为《如果老年痴呆症有疗方》(Alzheimer’s Disease: What If There Was A Cure?)的书籍，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">书中记录了老公与老年痴呆症战斗的过程。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/6b7f496cc3234055a98caef306028e7c.gif" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">这个例子也让更多人相信，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">椰子油可以在一定程度上，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">战胜阿兹海默病。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0; text-align: center;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/17291d858e1841359d8ba0344c8d9ce0.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">大家常在说：“家有一老，如有一宝”，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">而跟实际行动的却往往和口中所说</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0; text-align: center;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">不尽相同。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">父母将自己从小无怨无悔慢慢的养大，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">不知道投入了多少的金钱与青春岁月陪伴，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">至他们老时，有些父母却因老年痴呆而被嫌弃，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0; text-align: center;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">甚至被抛弃。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><img src="http://5b0988e595225.cdn.sohucs.com/images/20191024/efb2ffc49653449885fed9a09b4c73e7.jpeg" style="border: 0px; margin: 10px auto 0px; padding: 0px; display: block; max-width: 100%; height: auto;"/></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">而现在，Aducanumab的出现让患者有了新的希望，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">明年，2020年，这款药物即将进入市场，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">希望它能像试验中那样，</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0; text-align: center;"><span style="font-weight: 700; border: 0px; margin: 0px; padding: 0px;">给患者带来新的曙光。</span></p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;">来源：微悉尼</p><p style="border: 0px; margin-top: 0.63em; margin-bottom: 1.8em; padding: 0px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0;"><span style="border: 0px; margin: 0px; padding: 0px;">免责声明：本文著作权属原创者所有，不代表本微信号立场。我们转载此文出于传播更多资讯之目的，如涉著作权事宜请联系删除。</span></p></article></p>
             * publisURL : null
             * listImage : http://wj.haoju.me/829a46754fa24826b66faaa412ab643b.jpeg
             * faceImage : null
             * videoURL : null
             * isRead : 0
             * accessType : null
             * pointPrice : null
             * goldenPrice : null
             * cashPrice : null
             * beanPrice : null
             * rebatePrice : null
             * companyID : null
             * companyName : null
             * readTimes : null
             * browseTimes : null
             * isPublish : 1
             * isValid : 1
             * createdTime : 1571983767000
             * createdTimeStr : 2019-10-25 14:09:27
             * cityFullName : null
             * startdate : 1572598330000
             * startdateStr : 2019-11-01
             * endDate : 1575190330000
             * endDateStr : 2019-12-01
             * isTop : 0
             * isDiscuss : 0
             * isGood : 0
             * parentNavigators : null
             * parentNavigatorsName : null
             * orderSeq : 100
             * isMeDiscuss : 0
             * isMeRead : 0
             * isMeCollect : 0
             * isMePraise : 0
             * isMeShare : 0
             * isMeTodayBrowse : null
             * isMeBrowse : null
             * praiseTotal : null
             * todayBrowseTotal : null
             */

            private String articleID;
            private Object categoryID;
            private Object categoryName;
            private Object sourceID;
            private Object sourceName;
            private Object sourceURL;
            private String title;
            private Object subTitle;
            private Object author;
            private String keywords;
            private Object description;
            private String content;
            private Object publisURL;
            private String listImage;
            private Object faceImage;
            private Object videoURL;
            private int isRead;
            private Object accessType;
            private Object pointPrice;
            private Object goldenPrice;
            private Object cashPrice;
            private Object beanPrice;
            private Object rebatePrice;
            private Object companyID;
            private Object companyName;
            private Object readTimes;
            private Object browseTimes;
            private int isPublish;
            private int isValid;
            private long createdTime;
            private String createdTimeStr;
            private Object cityFullName;
            private long startdate;
            private String startdateStr;
            private long endDate;
            private String endDateStr;
            private int isTop;
            private int isDiscuss;
            private int isGood;
            private Object parentNavigators;
            private Object parentNavigatorsName;
            private int orderSeq;
            private int isMeDiscuss;
            private int isMeRead;
            private int isMeCollect;
            private int isMePraise;
            private int isMeShare;
            private Object isMeTodayBrowse;
            private Object isMeBrowse;
            private Object praiseTotal;
            private Object todayBrowseTotal;

            public String getArticleID() {
                return articleID;
            }

            public void setArticleID(String articleID) {
                this.articleID = articleID;
            }

            public Object getCategoryID() {
                return categoryID;
            }

            public void setCategoryID(Object categoryID) {
                this.categoryID = categoryID;
            }

            public Object getCategoryName() {
                return categoryName;
            }

            public void setCategoryName(Object categoryName) {
                this.categoryName = categoryName;
            }

            public Object getSourceID() {
                return sourceID;
            }

            public void setSourceID(Object sourceID) {
                this.sourceID = sourceID;
            }

            public Object getSourceName() {
                return sourceName;
            }

            public void setSourceName(Object sourceName) {
                this.sourceName = sourceName;
            }

            public Object getSourceURL() {
                return sourceURL;
            }

            public void setSourceURL(Object sourceURL) {
                this.sourceURL = sourceURL;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public Object getSubTitle() {
                return subTitle;
            }

            public void setSubTitle(Object subTitle) {
                this.subTitle = subTitle;
            }

            public Object getAuthor() {
                return author;
            }

            public void setAuthor(Object author) {
                this.author = author;
            }

            public String getKeywords() {
                return keywords;
            }

            public void setKeywords(String keywords) {
                this.keywords = keywords;
            }

            public Object getDescription() {
                return description;
            }

            public void setDescription(Object description) {
                this.description = description;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public Object getPublisURL() {
                return publisURL;
            }

            public void setPublisURL(Object publisURL) {
                this.publisURL = publisURL;
            }

            public String getListImage() {
                return listImage;
            }

            public void setListImage(String listImage) {
                this.listImage = listImage;
            }

            public Object getFaceImage() {
                return faceImage;
            }

            public void setFaceImage(Object faceImage) {
                this.faceImage = faceImage;
            }

            public Object getVideoURL() {
                return videoURL;
            }

            public void setVideoURL(Object videoURL) {
                this.videoURL = videoURL;
            }

            public int getIsRead() {
                return isRead;
            }

            public void setIsRead(int isRead) {
                this.isRead = isRead;
            }

            public Object getAccessType() {
                return accessType;
            }

            public void setAccessType(Object accessType) {
                this.accessType = accessType;
            }

            public Object getPointPrice() {
                return pointPrice;
            }

            public void setPointPrice(Object pointPrice) {
                this.pointPrice = pointPrice;
            }

            public Object getGoldenPrice() {
                return goldenPrice;
            }

            public void setGoldenPrice(Object goldenPrice) {
                this.goldenPrice = goldenPrice;
            }

            public Object getCashPrice() {
                return cashPrice;
            }

            public void setCashPrice(Object cashPrice) {
                this.cashPrice = cashPrice;
            }

            public Object getBeanPrice() {
                return beanPrice;
            }

            public void setBeanPrice(Object beanPrice) {
                this.beanPrice = beanPrice;
            }

            public Object getRebatePrice() {
                return rebatePrice;
            }

            public void setRebatePrice(Object rebatePrice) {
                this.rebatePrice = rebatePrice;
            }

            public Object getCompanyID() {
                return companyID;
            }

            public void setCompanyID(Object companyID) {
                this.companyID = companyID;
            }

            public Object getCompanyName() {
                return companyName;
            }

            public void setCompanyName(Object companyName) {
                this.companyName = companyName;
            }

            public Object getReadTimes() {
                return readTimes;
            }

            public void setReadTimes(Object readTimes) {
                this.readTimes = readTimes;
            }

            public Object getBrowseTimes() {
                return browseTimes;
            }

            public void setBrowseTimes(Object browseTimes) {
                this.browseTimes = browseTimes;
            }

            public int getIsPublish() {
                return isPublish;
            }

            public void setIsPublish(int isPublish) {
                this.isPublish = isPublish;
            }

            public int getIsValid() {
                return isValid;
            }

            public void setIsValid(int isValid) {
                this.isValid = isValid;
            }

            public long getCreatedTime() {
                return createdTime;
            }

            public void setCreatedTime(long createdTime) {
                this.createdTime = createdTime;
            }

            public String getCreatedTimeStr() {
                return createdTimeStr;
            }

            public void setCreatedTimeStr(String createdTimeStr) {
                this.createdTimeStr = createdTimeStr;
            }

            public Object getCityFullName() {
                return cityFullName;
            }

            public void setCityFullName(Object cityFullName) {
                this.cityFullName = cityFullName;
            }

            public long getStartdate() {
                return startdate;
            }

            public void setStartdate(long startdate) {
                this.startdate = startdate;
            }

            public String getStartdateStr() {
                return startdateStr;
            }

            public void setStartdateStr(String startdateStr) {
                this.startdateStr = startdateStr;
            }

            public long getEndDate() {
                return endDate;
            }

            public void setEndDate(long endDate) {
                this.endDate = endDate;
            }

            public String getEndDateStr() {
                return endDateStr;
            }

            public void setEndDateStr(String endDateStr) {
                this.endDateStr = endDateStr;
            }

            public int getIsTop() {
                return isTop;
            }

            public void setIsTop(int isTop) {
                this.isTop = isTop;
            }

            public int getIsDiscuss() {
                return isDiscuss;
            }

            public void setIsDiscuss(int isDiscuss) {
                this.isDiscuss = isDiscuss;
            }

            public int getIsGood() {
                return isGood;
            }

            public void setIsGood(int isGood) {
                this.isGood = isGood;
            }

            public Object getParentNavigators() {
                return parentNavigators;
            }

            public void setParentNavigators(Object parentNavigators) {
                this.parentNavigators = parentNavigators;
            }

            public Object getParentNavigatorsName() {
                return parentNavigatorsName;
            }

            public void setParentNavigatorsName(Object parentNavigatorsName) {
                this.parentNavigatorsName = parentNavigatorsName;
            }

            public int getOrderSeq() {
                return orderSeq;
            }

            public void setOrderSeq(int orderSeq) {
                this.orderSeq = orderSeq;
            }

            public int getIsMeDiscuss() {
                return isMeDiscuss;
            }

            public void setIsMeDiscuss(int isMeDiscuss) {
                this.isMeDiscuss = isMeDiscuss;
            }

            public int getIsMeRead() {
                return isMeRead;
            }

            public void setIsMeRead(int isMeRead) {
                this.isMeRead = isMeRead;
            }

            public int getIsMeCollect() {
                return isMeCollect;
            }

            public void setIsMeCollect(int isMeCollect) {
                this.isMeCollect = isMeCollect;
            }

            public int getIsMePraise() {
                return isMePraise;
            }

            public void setIsMePraise(int isMePraise) {
                this.isMePraise = isMePraise;
            }

            public int getIsMeShare() {
                return isMeShare;
            }

            public void setIsMeShare(int isMeShare) {
                this.isMeShare = isMeShare;
            }

            public Object getIsMeTodayBrowse() {
                return isMeTodayBrowse;
            }

            public void setIsMeTodayBrowse(Object isMeTodayBrowse) {
                this.isMeTodayBrowse = isMeTodayBrowse;
            }

            public Object getIsMeBrowse() {
                return isMeBrowse;
            }

            public void setIsMeBrowse(Object isMeBrowse) {
                this.isMeBrowse = isMeBrowse;
            }

            public Object getPraiseTotal() {
                return praiseTotal;
            }

            public void setPraiseTotal(Object praiseTotal) {
                this.praiseTotal = praiseTotal;
            }

            public Object getTodayBrowseTotal() {
                return todayBrowseTotal;
            }

            public void setTodayBrowseTotal(Object todayBrowseTotal) {
                this.todayBrowseTotal = todayBrowseTotal;
            }
        }
    }
}
