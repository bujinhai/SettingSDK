package com.jinshu.settinglibrary.entity;

/**
 * Create on 2019/12/2 18:05 by bll
 */


public class WalletEntity {

    /**
     * memberID
     name
     cashBalance 现金余额
     cashTotalRecharge 充值总额
     cashTotalCashBonus 现金奖励总额
     cashTotalConsumer 消费总额
     cashTotalWithdraw 提现总额
     cashTotalWithdrawProcess 提现中总额
     cashTotalIncome 收入总额
     giveTotalIncome 兑现收入
     noGiveTotalIncome 未兑现收入
     point 现实积分余额
     pointTotal：累计获取积分
     pointTotalUsed：累计消耗积分
     bean
     beanTotal
     beanTotalUsed
     golden
     goldenTotal
     goldenTotalUsed
     goldenToken
     goldenTokenTotal
     goldenTokenTotalUsed
     lifeInstanceTotal 生命实体个数
     lifeValue 现实生命值
     lifeValueTotalGet 累计获得生命值
     lifeValueTotalUsed 累计消耗 生命值
     deposit 押金
     depositSaveTotal
     depositLockTotal
     depositReturnTotal
     depositDoneTotal
     bonusCanUse 当前可以用的红包个数
     bonusgetTimes：累计获得个数
     bonusTotal：累计获得金额
     bonusUsedTimes：累计使用个数
     bonusUsedTotal：累计使用金额
     salesAll ：个人总业绩
     salesTotal：总的部门业绩
     salesTotalNext：个人直推业绩
     salesTotalLittle：小部门业绩
     amountDay：今天有效的提现金额
     lockedCash：锁定金额
     */

    /**
     * memberStatisticsDto : {"id":"8a2f462a6c187f2d016c3c46856a351c","name":"会员13162617998的资金统计","memberID":"bdbab7dd39134b1bb2cf786e7b300674","applicationID":"8a2f462a6aa17470016aa47baa1c0f24","point":1581,"pointTotal":6002,"pointTotalUsed":4124,"cashBalance":245.85,"giveTotalIncome":0,"noGiveTotalIncome":2311.66,"rebateBalance":0,"cashTotalIncome":2311.66,"cashTotalConsumer":1660.17,"cashTotalWithdraw":0,"cashTotalWithdrawProcess":-2000,"salesTotal":7.05,"salesTotalNext":6,"salesTotalLittle":7.05,"cardNumber":0,"cardTotalPrice":0,"stockTotal":263004,"cardUsedTimes":0,"stockGetTimes":8,"creditScore":10,"creditScoreTotal":10,"creditScoreUsed":0,"lifeInstanceTotal":0,"lifeValue":600,"lifeValueTotalGet":600,"lifeValueTotalUsed":0,"golden":600,"goldenTotal":600,"goldenTotalUsed":0,"goldenToken":0,"goldenTokenTotal":0,"goldenTokenTotalUsed":0,"goldenBankBalance":0,"goldenBankTotal":0,"goldenBankBuy":0,"goldenBankInterest":0,"goldenBankWithdraw":0,"bean":600,"beanTotal":600,"beanTotalUsed":0,"creditBalance":0,"creditInterestTotal":0,"creditTotalGive":0,"creditTotalUsed":0,"flexibleBalance":0,"flexibleInterestTotal":0,"flexibleTotalOrder":0,"flexibleTotalclosing":0,"bankBillBalance":0,"bankBillTotalOrder":0,"bankBillTotalClosing":0,"bankBillInterest":0,"regularBalance":0,"regularTotalOrder":0,"regularTotalClosing":0,"regularInterest":0,"businessBillBalance":0,"businessBillTotalOrder":0,"businessBillTotalClosing":0,"businessBillInterest":0,"cashTotalRecharge":0,"cashTotalCashBonus":0,"cashTotalInterest":0,"taxTotal":0,"deposit":0,"depositSaveTotal":0,"depositLockTotal":0,"depositReturnTotal":0,"depositDoneTotal":0,"depositShop":0,"depositSaveTotalShop":0,"depositLockTotalShop":0,"depositReturnTotalShop":0,"depositDoneTotalShop":0,"cashTotalTransfer":0,"planPayBalance":0,"planPayTotal":0,"planGetBlance":0,"planGetTotal":0,"prePayBalance":0,"perPayTotal":0,"prePayTotalUsed":0,"freezeBalance":0,"freezeTotal":0,"freezeTotalUsed":0,"bankBalance":0,"rebateTotal":0,"rebateTotalUsed":0,"bonusTotal":60,"bonusUsedTotal":0,"divineApplyNumber":0,"divineApplyAmount":0,"divineDoneNumber":0,"divineDoneAmount":0,"rewardApplyNumber":0,"rewardApplyAmount":0,"rewardDoneNumber":0,"rewardDoneAmount":0,"scoreNumber":0,"scoreTotal":460,"scoreGoodTimes":0,"livevideoTimes":0,"livevideoHours":0,"joinLivevideoTimes":0,"joinLivevideoHours":0,"crowdTimes":0,"crowdAmount":0,"joinCrowdProjects":0,"joinCrowdPhases":0,"joinCrowdTimes":0,"joinCrowdAmount":0,"joinTeamAmount":0,"joinAllAmont":0,"recommendMembers":0,"zhixiaofee":0,"invoiceNeedAmount":0,"salesAll":1666.89,"invoicePrintedAmount":0,"invoiceNoAmount":0,"signinTimes":8,"signinDays":8,"signinLongTimes":0,"signinLongDays":0,"raffleGiveTotal":0,"raffleUsedTotal":0,"lastsigninTime":null,"yujAmount":0,"amountDay":0,"bonusCanUse":2,"bonusgetTimes":2,"bonusUsedTimes":0,"lifeDefineID":"8a2f462a6b7a1078016b83672c3e2de0","lockedCash":0,"lifeInstanceLifeValue":0,"finishBrowseTask":false,"finishShareTask":false,"focusWechart":false}
     */

    private MemberStatisticsDtoInfo memberStatisticsDto;

    public MemberStatisticsDtoInfo getMemberStatisticsDto() {
        return memberStatisticsDto;
    }

    public void setMemberStatisticsDto(MemberStatisticsDtoInfo memberStatisticsDto) {
        this.memberStatisticsDto = memberStatisticsDto;
    }

    public static class MemberStatisticsDtoInfo {
        /**
         * id : 8a2f462a6c187f2d016c3c46856a351c
         * name : 会员13162617998的资金统计
         * memberID : bdbab7dd39134b1bb2cf786e7b300674
         * applicationID : 8a2f462a6aa17470016aa47baa1c0f24
         * point : 1581
         * pointTotal : 6002
         * pointTotalUsed : 4124
         * cashBalance : 245.85
         * giveTotalIncome : 0
         * noGiveTotalIncome : 2311.66
         * rebateBalance : 0
         * cashTotalIncome : 2311.66
         * cashTotalConsumer : 1660.17
         * cashTotalWithdraw : 0
         * cashTotalWithdrawProcess : -2000
         * salesTotal : 7.05
         * salesTotalNext : 6
         * salesTotalLittle : 7.05
         * cardNumber : 0
         * cardTotalPrice : 0
         * stockTotal : 263004
         * cardUsedTimes : 0
         * stockGetTimes : 8
         * creditScore : 10
         * creditScoreTotal : 10
         * creditScoreUsed : 0
         * lifeInstanceTotal : 0
         * lifeValue : 600
         * lifeValueTotalGet : 600
         * lifeValueTotalUsed : 0
         * golden : 600
         * goldenTotal : 600
         * goldenTotalUsed : 0
         * goldenToken : 0
         * goldenTokenTotal : 0
         * goldenTokenTotalUsed : 0
         * goldenBankBalance : 0
         * goldenBankTotal : 0
         * goldenBankBuy : 0
         * goldenBankInterest : 0
         * goldenBankWithdraw : 0
         * bean : 600
         * beanTotal : 600
         * beanTotalUsed : 0
         * creditBalance : 0
         * creditInterestTotal : 0
         * creditTotalGive : 0
         * creditTotalUsed : 0
         * flexibleBalance : 0
         * flexibleInterestTotal : 0
         * flexibleTotalOrder : 0
         * flexibleTotalclosing : 0
         * bankBillBalance : 0
         * bankBillTotalOrder : 0
         * bankBillTotalClosing : 0
         * bankBillInterest : 0
         * regularBalance : 0
         * regularTotalOrder : 0
         * regularTotalClosing : 0
         * regularInterest : 0
         * businessBillBalance : 0
         * businessBillTotalOrder : 0
         * businessBillTotalClosing : 0
         * businessBillInterest : 0
         * cashTotalRecharge : 0
         * cashTotalCashBonus : 0
         * cashTotalInterest : 0
         * taxTotal : 0
         * deposit : 0
         * depositSaveTotal : 0
         * depositLockTotal : 0
         * depositReturnTotal : 0
         * depositDoneTotal : 0
         * depositShop : 0
         * depositSaveTotalShop : 0
         * depositLockTotalShop : 0
         * depositReturnTotalShop : 0
         * depositDoneTotalShop : 0
         * cashTotalTransfer : 0
         * planPayBalance : 0
         * planPayTotal : 0
         * planGetBlance : 0
         * planGetTotal : 0
         * prePayBalance : 0
         * perPayTotal : 0
         * prePayTotalUsed : 0
         * freezeBalance : 0
         * freezeTotal : 0
         * freezeTotalUsed : 0
         * bankBalance : 0
         * rebateTotal : 0
         * rebateTotalUsed : 0
         * bonusTotal : 60
         * bonusUsedTotal : 0
         * divineApplyNumber : 0
         * divineApplyAmount : 0
         * divineDoneNumber : 0
         * divineDoneAmount : 0
         * rewardApplyNumber : 0
         * rewardApplyAmount : 0
         * rewardDoneNumber : 0
         * rewardDoneAmount : 0
         * scoreNumber : 0
         * scoreTotal : 460
         * scoreGoodTimes : 0
         * livevideoTimes : 0
         * livevideoHours : 0
         * joinLivevideoTimes : 0
         * joinLivevideoHours : 0
         * crowdTimes : 0
         * crowdAmount : 0
         * joinCrowdProjects : 0
         * joinCrowdPhases : 0
         * joinCrowdTimes : 0
         * joinCrowdAmount : 0
         * joinTeamAmount : 0
         * joinAllAmont : 0
         * recommendMembers : 0
         * zhixiaofee : 0
         * invoiceNeedAmount : 0
         * salesAll : 1666.89
         * invoicePrintedAmount : 0
         * invoiceNoAmount : 0
         * signinTimes : 8
         * signinDays : 8
         * signinLongTimes : 0
         * signinLongDays : 0
         * raffleGiveTotal : 0
         * raffleUsedTotal : 0
         * lastsigninTime : null
         * yujAmount : 0
         * amountDay : 0
         * bonusCanUse : 2
         * bonusgetTimes : 2
         * bonusUsedTimes : 0
         * lifeDefineID : 8a2f462a6b7a1078016b83672c3e2de0
         * lockedCash : 0
         * lifeInstanceLifeValue : 0
         * finishBrowseTask : false
         * finishShareTask : false
         * focusWechart : false
         */

        private String id;
        private String name;
        private String memberID;
        private String applicationID;
        private int point;
        private int pointTotal;
        private int pointTotalUsed;
        private double cashBalance;
        private int giveTotalIncome;
        private double noGiveTotalIncome;
        private int rebateBalance;
        private double cashTotalIncome;
        private double cashTotalConsumer;
        private int cashTotalWithdraw;
        private int cashTotalWithdrawProcess;
        private double salesTotal;
        private int salesTotalNext;
        private double salesTotalLittle;
        private int cardNumber;
        private int cardTotalPrice;
        private int stockTotal;
        private int cardUsedTimes;
        private int stockGetTimes;
        private int creditScore;
        private int creditScoreTotal;
        private int creditScoreUsed;
        private int lifeInstanceTotal;
        private int lifeValue;
        private int lifeValueTotalGet;
        private int lifeValueTotalUsed;
        private int golden;
        private int goldenTotal;
        private int goldenTotalUsed;
        private int goldenToken;
        private int goldenTokenTotal;
        private int goldenTokenTotalUsed;
        private int goldenBankBalance;
        private int goldenBankTotal;
        private int goldenBankBuy;
        private int goldenBankInterest;
        private int goldenBankWithdraw;
        private int bean;
        private int beanTotal;
        private int beanTotalUsed;
        private int creditBalance;
        private int creditInterestTotal;
        private int creditTotalGive;
        private int creditTotalUsed;
        private int flexibleBalance;
        private int flexibleInterestTotal;
        private int flexibleTotalOrder;
        private int flexibleTotalclosing;
        private int bankBillBalance;
        private int bankBillTotalOrder;
        private int bankBillTotalClosing;
        private int bankBillInterest;
        private int regularBalance;
        private int regularTotalOrder;
        private int regularTotalClosing;
        private int regularInterest;
        private int businessBillBalance;
        private int businessBillTotalOrder;
        private int businessBillTotalClosing;
        private int businessBillInterest;
        private int cashTotalRecharge;
        private int cashTotalCashBonus;
        private int cashTotalInterest;
        private int taxTotal;
        private int deposit;
        private int depositSaveTotal;
        private int depositLockTotal;
        private int depositReturnTotal;
        private int depositDoneTotal;
        private int depositShop;
        private int depositSaveTotalShop;
        private int depositLockTotalShop;
        private int depositReturnTotalShop;
        private int depositDoneTotalShop;
        private int cashTotalTransfer;
        private int planPayBalance;
        private int planPayTotal;
        private int planGetBlance;
        private int planGetTotal;
        private int prePayBalance;
        private int perPayTotal;
        private int prePayTotalUsed;
        private int freezeBalance;
        private int freezeTotal;
        private int freezeTotalUsed;
        private int bankBalance;
        private int rebateTotal;
        private int rebateTotalUsed;
        private int bonusTotal;
        private int bonusUsedTotal;
        private int divineApplyNumber;
        private int divineApplyAmount;
        private int divineDoneNumber;
        private int divineDoneAmount;
        private int rewardApplyNumber;
        private int rewardApplyAmount;
        private int rewardDoneNumber;
        private int rewardDoneAmount;
        private int scoreNumber;
        private int scoreTotal;
        private int scoreGoodTimes;
        private int livevideoTimes;
        private int livevideoHours;
        private int joinLivevideoTimes;
        private int joinLivevideoHours;
        private int crowdTimes;
        private int crowdAmount;
        private int joinCrowdProjects;
        private int joinCrowdPhases;
        private int joinCrowdTimes;
        private int joinCrowdAmount;
        private int joinTeamAmount;
        private int joinAllAmont;
        private int recommendMembers;
        private int zhixiaofee;
        private int invoiceNeedAmount;
        private double salesAll;
        private int invoicePrintedAmount;
        private int invoiceNoAmount;
        private int signinTimes;
        private int signinDays;
        private int signinLongTimes;
        private int signinLongDays;
        private int raffleGiveTotal;
        private int raffleUsedTotal;
        private Object lastsigninTime;
        private int yujAmount;
        private int amountDay;
        private int bonusCanUse;
        private int bonusgetTimes;
        private int bonusUsedTimes;
        private String lifeDefineID;
        private int lockedCash;
        private int lifeInstanceLifeValue;
        private boolean finishBrowseTask;
        private boolean finishShareTask;
        private boolean focusWechart;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public String getApplicationID() {
            return applicationID;
        }

        public void setApplicationID(String applicationID) {
            this.applicationID = applicationID;
        }

        public int getPoint() {
            return point;
        }

        public void setPoint(int point) {
            this.point = point;
        }

        public int getPointTotal() {
            return pointTotal;
        }

        public void setPointTotal(int pointTotal) {
            this.pointTotal = pointTotal;
        }

        public int getPointTotalUsed() {
            return pointTotalUsed;
        }

        public void setPointTotalUsed(int pointTotalUsed) {
            this.pointTotalUsed = pointTotalUsed;
        }

        public double getCashBalance() {
            return cashBalance;
        }

        public void setCashBalance(double cashBalance) {
            this.cashBalance = cashBalance;
        }

        public int getGiveTotalIncome() {
            return giveTotalIncome;
        }

        public void setGiveTotalIncome(int giveTotalIncome) {
            this.giveTotalIncome = giveTotalIncome;
        }

        public double getNoGiveTotalIncome() {
            return noGiveTotalIncome;
        }

        public void setNoGiveTotalIncome(double noGiveTotalIncome) {
            this.noGiveTotalIncome = noGiveTotalIncome;
        }

        public int getRebateBalance() {
            return rebateBalance;
        }

        public void setRebateBalance(int rebateBalance) {
            this.rebateBalance = rebateBalance;
        }

        public double getCashTotalIncome() {
            return cashTotalIncome;
        }

        public void setCashTotalIncome(double cashTotalIncome) {
            this.cashTotalIncome = cashTotalIncome;
        }

        public double getCashTotalConsumer() {
            return cashTotalConsumer;
        }

        public void setCashTotalConsumer(double cashTotalConsumer) {
            this.cashTotalConsumer = cashTotalConsumer;
        }

        public int getCashTotalWithdraw() {
            return cashTotalWithdraw;
        }

        public void setCashTotalWithdraw(int cashTotalWithdraw) {
            this.cashTotalWithdraw = cashTotalWithdraw;
        }

        public int getCashTotalWithdrawProcess() {
            return cashTotalWithdrawProcess;
        }

        public void setCashTotalWithdrawProcess(int cashTotalWithdrawProcess) {
            this.cashTotalWithdrawProcess = cashTotalWithdrawProcess;
        }

        public double getSalesTotal() {
            return salesTotal;
        }

        public void setSalesTotal(double salesTotal) {
            this.salesTotal = salesTotal;
        }

        public int getSalesTotalNext() {
            return salesTotalNext;
        }

        public void setSalesTotalNext(int salesTotalNext) {
            this.salesTotalNext = salesTotalNext;
        }

        public double getSalesTotalLittle() {
            return salesTotalLittle;
        }

        public void setSalesTotalLittle(double salesTotalLittle) {
            this.salesTotalLittle = salesTotalLittle;
        }

        public int getCardNumber() {
            return cardNumber;
        }

        public void setCardNumber(int cardNumber) {
            this.cardNumber = cardNumber;
        }

        public int getCardTotalPrice() {
            return cardTotalPrice;
        }

        public void setCardTotalPrice(int cardTotalPrice) {
            this.cardTotalPrice = cardTotalPrice;
        }

        public int getStockTotal() {
            return stockTotal;
        }

        public void setStockTotal(int stockTotal) {
            this.stockTotal = stockTotal;
        }

        public int getCardUsedTimes() {
            return cardUsedTimes;
        }

        public void setCardUsedTimes(int cardUsedTimes) {
            this.cardUsedTimes = cardUsedTimes;
        }

        public int getStockGetTimes() {
            return stockGetTimes;
        }

        public void setStockGetTimes(int stockGetTimes) {
            this.stockGetTimes = stockGetTimes;
        }

        public int getCreditScore() {
            return creditScore;
        }

        public void setCreditScore(int creditScore) {
            this.creditScore = creditScore;
        }

        public int getCreditScoreTotal() {
            return creditScoreTotal;
        }

        public void setCreditScoreTotal(int creditScoreTotal) {
            this.creditScoreTotal = creditScoreTotal;
        }

        public int getCreditScoreUsed() {
            return creditScoreUsed;
        }

        public void setCreditScoreUsed(int creditScoreUsed) {
            this.creditScoreUsed = creditScoreUsed;
        }

        public int getLifeInstanceTotal() {
            return lifeInstanceTotal;
        }

        public void setLifeInstanceTotal(int lifeInstanceTotal) {
            this.lifeInstanceTotal = lifeInstanceTotal;
        }

        public int getLifeValue() {
            return lifeValue;
        }

        public void setLifeValue(int lifeValue) {
            this.lifeValue = lifeValue;
        }

        public int getLifeValueTotalGet() {
            return lifeValueTotalGet;
        }

        public void setLifeValueTotalGet(int lifeValueTotalGet) {
            this.lifeValueTotalGet = lifeValueTotalGet;
        }

        public int getLifeValueTotalUsed() {
            return lifeValueTotalUsed;
        }

        public void setLifeValueTotalUsed(int lifeValueTotalUsed) {
            this.lifeValueTotalUsed = lifeValueTotalUsed;
        }

        public int getGolden() {
            return golden;
        }

        public void setGolden(int golden) {
            this.golden = golden;
        }

        public int getGoldenTotal() {
            return goldenTotal;
        }

        public void setGoldenTotal(int goldenTotal) {
            this.goldenTotal = goldenTotal;
        }

        public int getGoldenTotalUsed() {
            return goldenTotalUsed;
        }

        public void setGoldenTotalUsed(int goldenTotalUsed) {
            this.goldenTotalUsed = goldenTotalUsed;
        }

        public int getGoldenToken() {
            return goldenToken;
        }

        public void setGoldenToken(int goldenToken) {
            this.goldenToken = goldenToken;
        }

        public int getGoldenTokenTotal() {
            return goldenTokenTotal;
        }

        public void setGoldenTokenTotal(int goldenTokenTotal) {
            this.goldenTokenTotal = goldenTokenTotal;
        }

        public int getGoldenTokenTotalUsed() {
            return goldenTokenTotalUsed;
        }

        public void setGoldenTokenTotalUsed(int goldenTokenTotalUsed) {
            this.goldenTokenTotalUsed = goldenTokenTotalUsed;
        }

        public int getGoldenBankBalance() {
            return goldenBankBalance;
        }

        public void setGoldenBankBalance(int goldenBankBalance) {
            this.goldenBankBalance = goldenBankBalance;
        }

        public int getGoldenBankTotal() {
            return goldenBankTotal;
        }

        public void setGoldenBankTotal(int goldenBankTotal) {
            this.goldenBankTotal = goldenBankTotal;
        }

        public int getGoldenBankBuy() {
            return goldenBankBuy;
        }

        public void setGoldenBankBuy(int goldenBankBuy) {
            this.goldenBankBuy = goldenBankBuy;
        }

        public int getGoldenBankInterest() {
            return goldenBankInterest;
        }

        public void setGoldenBankInterest(int goldenBankInterest) {
            this.goldenBankInterest = goldenBankInterest;
        }

        public int getGoldenBankWithdraw() {
            return goldenBankWithdraw;
        }

        public void setGoldenBankWithdraw(int goldenBankWithdraw) {
            this.goldenBankWithdraw = goldenBankWithdraw;
        }

        public int getBean() {
            return bean;
        }

        public void setBean(int bean) {
            this.bean = bean;
        }

        public int getBeanTotal() {
            return beanTotal;
        }

        public void setBeanTotal(int beanTotal) {
            this.beanTotal = beanTotal;
        }

        public int getBeanTotalUsed() {
            return beanTotalUsed;
        }

        public void setBeanTotalUsed(int beanTotalUsed) {
            this.beanTotalUsed = beanTotalUsed;
        }

        public int getCreditBalance() {
            return creditBalance;
        }

        public void setCreditBalance(int creditBalance) {
            this.creditBalance = creditBalance;
        }

        public int getCreditInterestTotal() {
            return creditInterestTotal;
        }

        public void setCreditInterestTotal(int creditInterestTotal) {
            this.creditInterestTotal = creditInterestTotal;
        }

        public int getCreditTotalGive() {
            return creditTotalGive;
        }

        public void setCreditTotalGive(int creditTotalGive) {
            this.creditTotalGive = creditTotalGive;
        }

        public int getCreditTotalUsed() {
            return creditTotalUsed;
        }

        public void setCreditTotalUsed(int creditTotalUsed) {
            this.creditTotalUsed = creditTotalUsed;
        }

        public int getFlexibleBalance() {
            return flexibleBalance;
        }

        public void setFlexibleBalance(int flexibleBalance) {
            this.flexibleBalance = flexibleBalance;
        }

        public int getFlexibleInterestTotal() {
            return flexibleInterestTotal;
        }

        public void setFlexibleInterestTotal(int flexibleInterestTotal) {
            this.flexibleInterestTotal = flexibleInterestTotal;
        }

        public int getFlexibleTotalOrder() {
            return flexibleTotalOrder;
        }

        public void setFlexibleTotalOrder(int flexibleTotalOrder) {
            this.flexibleTotalOrder = flexibleTotalOrder;
        }

        public int getFlexibleTotalclosing() {
            return flexibleTotalclosing;
        }

        public void setFlexibleTotalclosing(int flexibleTotalclosing) {
            this.flexibleTotalclosing = flexibleTotalclosing;
        }

        public int getBankBillBalance() {
            return bankBillBalance;
        }

        public void setBankBillBalance(int bankBillBalance) {
            this.bankBillBalance = bankBillBalance;
        }

        public int getBankBillTotalOrder() {
            return bankBillTotalOrder;
        }

        public void setBankBillTotalOrder(int bankBillTotalOrder) {
            this.bankBillTotalOrder = bankBillTotalOrder;
        }

        public int getBankBillTotalClosing() {
            return bankBillTotalClosing;
        }

        public void setBankBillTotalClosing(int bankBillTotalClosing) {
            this.bankBillTotalClosing = bankBillTotalClosing;
        }

        public int getBankBillInterest() {
            return bankBillInterest;
        }

        public void setBankBillInterest(int bankBillInterest) {
            this.bankBillInterest = bankBillInterest;
        }

        public int getRegularBalance() {
            return regularBalance;
        }

        public void setRegularBalance(int regularBalance) {
            this.regularBalance = regularBalance;
        }

        public int getRegularTotalOrder() {
            return regularTotalOrder;
        }

        public void setRegularTotalOrder(int regularTotalOrder) {
            this.regularTotalOrder = regularTotalOrder;
        }

        public int getRegularTotalClosing() {
            return regularTotalClosing;
        }

        public void setRegularTotalClosing(int regularTotalClosing) {
            this.regularTotalClosing = regularTotalClosing;
        }

        public int getRegularInterest() {
            return regularInterest;
        }

        public void setRegularInterest(int regularInterest) {
            this.regularInterest = regularInterest;
        }

        public int getBusinessBillBalance() {
            return businessBillBalance;
        }

        public void setBusinessBillBalance(int businessBillBalance) {
            this.businessBillBalance = businessBillBalance;
        }

        public int getBusinessBillTotalOrder() {
            return businessBillTotalOrder;
        }

        public void setBusinessBillTotalOrder(int businessBillTotalOrder) {
            this.businessBillTotalOrder = businessBillTotalOrder;
        }

        public int getBusinessBillTotalClosing() {
            return businessBillTotalClosing;
        }

        public void setBusinessBillTotalClosing(int businessBillTotalClosing) {
            this.businessBillTotalClosing = businessBillTotalClosing;
        }

        public int getBusinessBillInterest() {
            return businessBillInterest;
        }

        public void setBusinessBillInterest(int businessBillInterest) {
            this.businessBillInterest = businessBillInterest;
        }

        public int getCashTotalRecharge() {
            return cashTotalRecharge;
        }

        public void setCashTotalRecharge(int cashTotalRecharge) {
            this.cashTotalRecharge = cashTotalRecharge;
        }

        public int getCashTotalCashBonus() {
            return cashTotalCashBonus;
        }

        public void setCashTotalCashBonus(int cashTotalCashBonus) {
            this.cashTotalCashBonus = cashTotalCashBonus;
        }

        public int getCashTotalInterest() {
            return cashTotalInterest;
        }

        public void setCashTotalInterest(int cashTotalInterest) {
            this.cashTotalInterest = cashTotalInterest;
        }

        public int getTaxTotal() {
            return taxTotal;
        }

        public void setTaxTotal(int taxTotal) {
            this.taxTotal = taxTotal;
        }

        public int getDeposit() {
            return deposit;
        }

        public void setDeposit(int deposit) {
            this.deposit = deposit;
        }

        public int getDepositSaveTotal() {
            return depositSaveTotal;
        }

        public void setDepositSaveTotal(int depositSaveTotal) {
            this.depositSaveTotal = depositSaveTotal;
        }

        public int getDepositLockTotal() {
            return depositLockTotal;
        }

        public void setDepositLockTotal(int depositLockTotal) {
            this.depositLockTotal = depositLockTotal;
        }

        public int getDepositReturnTotal() {
            return depositReturnTotal;
        }

        public void setDepositReturnTotal(int depositReturnTotal) {
            this.depositReturnTotal = depositReturnTotal;
        }

        public int getDepositDoneTotal() {
            return depositDoneTotal;
        }

        public void setDepositDoneTotal(int depositDoneTotal) {
            this.depositDoneTotal = depositDoneTotal;
        }

        public int getDepositShop() {
            return depositShop;
        }

        public void setDepositShop(int depositShop) {
            this.depositShop = depositShop;
        }

        public int getDepositSaveTotalShop() {
            return depositSaveTotalShop;
        }

        public void setDepositSaveTotalShop(int depositSaveTotalShop) {
            this.depositSaveTotalShop = depositSaveTotalShop;
        }

        public int getDepositLockTotalShop() {
            return depositLockTotalShop;
        }

        public void setDepositLockTotalShop(int depositLockTotalShop) {
            this.depositLockTotalShop = depositLockTotalShop;
        }

        public int getDepositReturnTotalShop() {
            return depositReturnTotalShop;
        }

        public void setDepositReturnTotalShop(int depositReturnTotalShop) {
            this.depositReturnTotalShop = depositReturnTotalShop;
        }

        public int getDepositDoneTotalShop() {
            return depositDoneTotalShop;
        }

        public void setDepositDoneTotalShop(int depositDoneTotalShop) {
            this.depositDoneTotalShop = depositDoneTotalShop;
        }

        public int getCashTotalTransfer() {
            return cashTotalTransfer;
        }

        public void setCashTotalTransfer(int cashTotalTransfer) {
            this.cashTotalTransfer = cashTotalTransfer;
        }

        public int getPlanPayBalance() {
            return planPayBalance;
        }

        public void setPlanPayBalance(int planPayBalance) {
            this.planPayBalance = planPayBalance;
        }

        public int getPlanPayTotal() {
            return planPayTotal;
        }

        public void setPlanPayTotal(int planPayTotal) {
            this.planPayTotal = planPayTotal;
        }

        public int getPlanGetBlance() {
            return planGetBlance;
        }

        public void setPlanGetBlance(int planGetBlance) {
            this.planGetBlance = planGetBlance;
        }

        public int getPlanGetTotal() {
            return planGetTotal;
        }

        public void setPlanGetTotal(int planGetTotal) {
            this.planGetTotal = planGetTotal;
        }

        public int getPrePayBalance() {
            return prePayBalance;
        }

        public void setPrePayBalance(int prePayBalance) {
            this.prePayBalance = prePayBalance;
        }

        public int getPerPayTotal() {
            return perPayTotal;
        }

        public void setPerPayTotal(int perPayTotal) {
            this.perPayTotal = perPayTotal;
        }

        public int getPrePayTotalUsed() {
            return prePayTotalUsed;
        }

        public void setPrePayTotalUsed(int prePayTotalUsed) {
            this.prePayTotalUsed = prePayTotalUsed;
        }

        public int getFreezeBalance() {
            return freezeBalance;
        }

        public void setFreezeBalance(int freezeBalance) {
            this.freezeBalance = freezeBalance;
        }

        public int getFreezeTotal() {
            return freezeTotal;
        }

        public void setFreezeTotal(int freezeTotal) {
            this.freezeTotal = freezeTotal;
        }

        public int getFreezeTotalUsed() {
            return freezeTotalUsed;
        }

        public void setFreezeTotalUsed(int freezeTotalUsed) {
            this.freezeTotalUsed = freezeTotalUsed;
        }

        public int getBankBalance() {
            return bankBalance;
        }

        public void setBankBalance(int bankBalance) {
            this.bankBalance = bankBalance;
        }

        public int getRebateTotal() {
            return rebateTotal;
        }

        public void setRebateTotal(int rebateTotal) {
            this.rebateTotal = rebateTotal;
        }

        public int getRebateTotalUsed() {
            return rebateTotalUsed;
        }

        public void setRebateTotalUsed(int rebateTotalUsed) {
            this.rebateTotalUsed = rebateTotalUsed;
        }

        public int getBonusTotal() {
            return bonusTotal;
        }

        public void setBonusTotal(int bonusTotal) {
            this.bonusTotal = bonusTotal;
        }

        public int getBonusUsedTotal() {
            return bonusUsedTotal;
        }

        public void setBonusUsedTotal(int bonusUsedTotal) {
            this.bonusUsedTotal = bonusUsedTotal;
        }

        public int getDivineApplyNumber() {
            return divineApplyNumber;
        }

        public void setDivineApplyNumber(int divineApplyNumber) {
            this.divineApplyNumber = divineApplyNumber;
        }

        public int getDivineApplyAmount() {
            return divineApplyAmount;
        }

        public void setDivineApplyAmount(int divineApplyAmount) {
            this.divineApplyAmount = divineApplyAmount;
        }

        public int getDivineDoneNumber() {
            return divineDoneNumber;
        }

        public void setDivineDoneNumber(int divineDoneNumber) {
            this.divineDoneNumber = divineDoneNumber;
        }

        public int getDivineDoneAmount() {
            return divineDoneAmount;
        }

        public void setDivineDoneAmount(int divineDoneAmount) {
            this.divineDoneAmount = divineDoneAmount;
        }

        public int getRewardApplyNumber() {
            return rewardApplyNumber;
        }

        public void setRewardApplyNumber(int rewardApplyNumber) {
            this.rewardApplyNumber = rewardApplyNumber;
        }

        public int getRewardApplyAmount() {
            return rewardApplyAmount;
        }

        public void setRewardApplyAmount(int rewardApplyAmount) {
            this.rewardApplyAmount = rewardApplyAmount;
        }

        public int getRewardDoneNumber() {
            return rewardDoneNumber;
        }

        public void setRewardDoneNumber(int rewardDoneNumber) {
            this.rewardDoneNumber = rewardDoneNumber;
        }

        public int getRewardDoneAmount() {
            return rewardDoneAmount;
        }

        public void setRewardDoneAmount(int rewardDoneAmount) {
            this.rewardDoneAmount = rewardDoneAmount;
        }

        public int getScoreNumber() {
            return scoreNumber;
        }

        public void setScoreNumber(int scoreNumber) {
            this.scoreNumber = scoreNumber;
        }

        public int getScoreTotal() {
            return scoreTotal;
        }

        public void setScoreTotal(int scoreTotal) {
            this.scoreTotal = scoreTotal;
        }

        public int getScoreGoodTimes() {
            return scoreGoodTimes;
        }

        public void setScoreGoodTimes(int scoreGoodTimes) {
            this.scoreGoodTimes = scoreGoodTimes;
        }

        public int getLivevideoTimes() {
            return livevideoTimes;
        }

        public void setLivevideoTimes(int livevideoTimes) {
            this.livevideoTimes = livevideoTimes;
        }

        public int getLivevideoHours() {
            return livevideoHours;
        }

        public void setLivevideoHours(int livevideoHours) {
            this.livevideoHours = livevideoHours;
        }

        public int getJoinLivevideoTimes() {
            return joinLivevideoTimes;
        }

        public void setJoinLivevideoTimes(int joinLivevideoTimes) {
            this.joinLivevideoTimes = joinLivevideoTimes;
        }

        public int getJoinLivevideoHours() {
            return joinLivevideoHours;
        }

        public void setJoinLivevideoHours(int joinLivevideoHours) {
            this.joinLivevideoHours = joinLivevideoHours;
        }

        public int getCrowdTimes() {
            return crowdTimes;
        }

        public void setCrowdTimes(int crowdTimes) {
            this.crowdTimes = crowdTimes;
        }

        public int getCrowdAmount() {
            return crowdAmount;
        }

        public void setCrowdAmount(int crowdAmount) {
            this.crowdAmount = crowdAmount;
        }

        public int getJoinCrowdProjects() {
            return joinCrowdProjects;
        }

        public void setJoinCrowdProjects(int joinCrowdProjects) {
            this.joinCrowdProjects = joinCrowdProjects;
        }

        public int getJoinCrowdPhases() {
            return joinCrowdPhases;
        }

        public void setJoinCrowdPhases(int joinCrowdPhases) {
            this.joinCrowdPhases = joinCrowdPhases;
        }

        public int getJoinCrowdTimes() {
            return joinCrowdTimes;
        }

        public void setJoinCrowdTimes(int joinCrowdTimes) {
            this.joinCrowdTimes = joinCrowdTimes;
        }

        public int getJoinCrowdAmount() {
            return joinCrowdAmount;
        }

        public void setJoinCrowdAmount(int joinCrowdAmount) {
            this.joinCrowdAmount = joinCrowdAmount;
        }

        public int getJoinTeamAmount() {
            return joinTeamAmount;
        }

        public void setJoinTeamAmount(int joinTeamAmount) {
            this.joinTeamAmount = joinTeamAmount;
        }

        public int getJoinAllAmont() {
            return joinAllAmont;
        }

        public void setJoinAllAmont(int joinAllAmont) {
            this.joinAllAmont = joinAllAmont;
        }

        public int getRecommendMembers() {
            return recommendMembers;
        }

        public void setRecommendMembers(int recommendMembers) {
            this.recommendMembers = recommendMembers;
        }

        public int getZhixiaofee() {
            return zhixiaofee;
        }

        public void setZhixiaofee(int zhixiaofee) {
            this.zhixiaofee = zhixiaofee;
        }

        public int getInvoiceNeedAmount() {
            return invoiceNeedAmount;
        }

        public void setInvoiceNeedAmount(int invoiceNeedAmount) {
            this.invoiceNeedAmount = invoiceNeedAmount;
        }

        public double getSalesAll() {
            return salesAll;
        }

        public void setSalesAll(double salesAll) {
            this.salesAll = salesAll;
        }

        public int getInvoicePrintedAmount() {
            return invoicePrintedAmount;
        }

        public void setInvoicePrintedAmount(int invoicePrintedAmount) {
            this.invoicePrintedAmount = invoicePrintedAmount;
        }

        public int getInvoiceNoAmount() {
            return invoiceNoAmount;
        }

        public void setInvoiceNoAmount(int invoiceNoAmount) {
            this.invoiceNoAmount = invoiceNoAmount;
        }

        public int getSigninTimes() {
            return signinTimes;
        }

        public void setSigninTimes(int signinTimes) {
            this.signinTimes = signinTimes;
        }

        public int getSigninDays() {
            return signinDays;
        }

        public void setSigninDays(int signinDays) {
            this.signinDays = signinDays;
        }

        public int getSigninLongTimes() {
            return signinLongTimes;
        }

        public void setSigninLongTimes(int signinLongTimes) {
            this.signinLongTimes = signinLongTimes;
        }

        public int getSigninLongDays() {
            return signinLongDays;
        }

        public void setSigninLongDays(int signinLongDays) {
            this.signinLongDays = signinLongDays;
        }

        public int getRaffleGiveTotal() {
            return raffleGiveTotal;
        }

        public void setRaffleGiveTotal(int raffleGiveTotal) {
            this.raffleGiveTotal = raffleGiveTotal;
        }

        public int getRaffleUsedTotal() {
            return raffleUsedTotal;
        }

        public void setRaffleUsedTotal(int raffleUsedTotal) {
            this.raffleUsedTotal = raffleUsedTotal;
        }

        public Object getLastsigninTime() {
            return lastsigninTime;
        }

        public void setLastsigninTime(Object lastsigninTime) {
            this.lastsigninTime = lastsigninTime;
        }

        public int getYujAmount() {
            return yujAmount;
        }

        public void setYujAmount(int yujAmount) {
            this.yujAmount = yujAmount;
        }

        public int getAmountDay() {
            return amountDay;
        }

        public void setAmountDay(int amountDay) {
            this.amountDay = amountDay;
        }

        public int getBonusCanUse() {
            return bonusCanUse;
        }

        public void setBonusCanUse(int bonusCanUse) {
            this.bonusCanUse = bonusCanUse;
        }

        public int getBonusgetTimes() {
            return bonusgetTimes;
        }

        public void setBonusgetTimes(int bonusgetTimes) {
            this.bonusgetTimes = bonusgetTimes;
        }

        public int getBonusUsedTimes() {
            return bonusUsedTimes;
        }

        public void setBonusUsedTimes(int bonusUsedTimes) {
            this.bonusUsedTimes = bonusUsedTimes;
        }

        public String getLifeDefineID() {
            return lifeDefineID;
        }

        public void setLifeDefineID(String lifeDefineID) {
            this.lifeDefineID = lifeDefineID;
        }

        public int getLockedCash() {
            return lockedCash;
        }

        public void setLockedCash(int lockedCash) {
            this.lockedCash = lockedCash;
        }

        public int getLifeInstanceLifeValue() {
            return lifeInstanceLifeValue;
        }

        public void setLifeInstanceLifeValue(int lifeInstanceLifeValue) {
            this.lifeInstanceLifeValue = lifeInstanceLifeValue;
        }

        public boolean isFinishBrowseTask() {
            return finishBrowseTask;
        }

        public void setFinishBrowseTask(boolean finishBrowseTask) {
            this.finishBrowseTask = finishBrowseTask;
        }

        public boolean isFinishShareTask() {
            return finishShareTask;
        }

        public void setFinishShareTask(boolean finishShareTask) {
            this.finishShareTask = finishShareTask;
        }

        public boolean isFocusWechart() {
            return focusWechart;
        }

        public void setFocusWechart(boolean focusWechart) {
            this.focusWechart = focusWechart;
        }
    }
}
