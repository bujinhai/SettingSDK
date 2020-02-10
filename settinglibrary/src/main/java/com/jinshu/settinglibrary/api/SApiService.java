package com.jinshu.settinglibrary.api;


import com.jinshu.settinglibrary.base.basebean.SBaseResponse;
import com.jinshu.settinglibrary.entity.AccountEntity;
import com.jinshu.settinglibrary.entity.AddressDetailEntity;
import com.jinshu.settinglibrary.entity.AddressEntity;
import com.jinshu.settinglibrary.entity.AddressListEntity;
import com.jinshu.settinglibrary.entity.ArticleMoreEntity;
import com.jinshu.settinglibrary.entity.ArticleSimpleEntity;
import com.jinshu.settinglibrary.entity.BankBranchListEntity;
import com.jinshu.settinglibrary.entity.BankDetailEntity;
import com.jinshu.settinglibrary.entity.BankListEntity;
import com.jinshu.settinglibrary.entity.CardListEntity;
import com.jinshu.settinglibrary.entity.CertificateStatusEntity;
import com.jinshu.settinglibrary.entity.CommentEntity;
import com.jinshu.settinglibrary.entity.FeedListEntity;
import com.jinshu.settinglibrary.entity.ImageEntity;
import com.jinshu.settinglibrary.entity.InvoiceDetailEntity;
import com.jinshu.settinglibrary.entity.InvoiceEntity;
import com.jinshu.settinglibrary.entity.MemberEntity;
import com.jinshu.settinglibrary.entity.MessageDetailEntity;
import com.jinshu.settinglibrary.entity.MessageEntity;
import com.jinshu.settinglibrary.entity.NavigatorEntity;
import com.jinshu.settinglibrary.entity.SmsEntity;
import com.jinshu.settinglibrary.entity.UserData;
import com.jinshu.settinglibrary.entity.VersionData;
import com.jinshu.settinglibrary.entity.WalletEntity;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Create on 2019/9/10 15:10 by bll
 */


public interface SApiService {

    /**
     * 登录
     */
    @GET("memberLogin.json")
    Observable<SBaseResponse<UserData>> login(
            @Query("loginName") String loginName,
            @Query("password") String password,
            @QueryMap Map<String, String> map);

    /**
     * 获取会员的评论列表
     */
    @FormUrlEncoded
    @POST("getObjectDiscussList.json")
    Observable<SBaseResponse<CommentEntity>> getObjectDiscussList(
            @Field("currentPage") int currentPage,
            @Field("pageNumber") int pageNumber,
            @Field("objectID") String objectID,
            @Field("sortTypeTime") String sortTypeTime,
            @FieldMap Map<String, String> map);

    /**
     * 发布一个评论
     */
    @FormUrlEncoded
    @POST("submitOneDiscuss.json")
    Observable<SBaseResponse> submitOneDiscuss(
            @Field("name") String name,
            @Field("objectName") String objectName,
            @Field("objectID") String objectID,
            @Field("objectDefineID") String objectDefineID,
            @Field("conTent") String conTent,
            @FieldMap Map<String, String> map);

    /**
     * 删除一个评论
     */
    @FormUrlEncoded
    @POST("deleteOneDiscuss.json")
    Observable<SBaseResponse> deleteOneDiscuss(
            @Field("discussID") String discussID,
            @FieldMap Map<String, String> map);

    /**
     * 修改一个评论
     */
    @FormUrlEncoded
    @POST("updateOneDiscuss.json")
    Observable<SBaseResponse> updateOneDiscuss(
            @Field("name") String name,
            @Field("discussID") String discussID,
            @Field("conTent") String conTent,
            @FieldMap Map<String, String> map);

    /**
     * 上传对象的附件
     */
    @FormUrlEncoded
    @POST("submObjectAttachment.json")
    Observable<SBaseResponse> submObjectAttachment(
            @Field("sessionID") String sessionID,
            @Field("objectName") String objectName,
            @Field("objectID") String objectID,
            @Field("objectDefineID") String objectDefineID,
            @Field("imageUrl") String imageUrl);

    /**
     * 修改登录密码
     */
    @FormUrlEncoded
    @POST("setMemberPassword.json")
    Observable<SBaseResponse> setMemberPassword(
            @Field("sessionID") String sessionID,
            @Field("oldPassword") String oldPassword,
            @Field("newPassword") String newPassword);

    /**
     * 忘记密码找回
     */
    @FormUrlEncoded
    @POST("resetMemberPassword.json")
    Observable<SBaseResponse> resetMemberPassword(
            @Field("sessionID") String sessionID,
            @Field("siteID") String siteID,
            @Field("phone") String phone,
            @Field("authCode") String authCode,
            @Field("password") String password);


    /**
     * 设置交易密码支付密码
     */
    @FormUrlEncoded
    @POST("setTradePassword.json")
    Observable<SBaseResponse> setTradePassword(
            @Field("sessionID") String sessionID,
            @Field("oldTradePassword") String oldTradePassword,
            @Field("newTradePassword") String newTradePassword);//6位数字


    /**
     * 忘记交易密码支付密码
     */
    @FormUrlEncoded
    @POST("forgetTradePassword.json")
    Observable<SBaseResponse> forgetTradePassword(
            @Field("sessionID") String sessionID,
            @Field("newTradePassword") String newTradePassword,
            @Field("phone") String phone,
            @Field("authCode") String authCode);


    /**
     * 会员绑定手机号
     */
    @FormUrlEncoded
    @POST("memberBandingPhone.json")
    Observable<SBaseResponse> memberBandingPhone(
            @Field("sessionID") String sessionID,
            @Field("phone") String phone,
            @Field("verifyCode") String verifyCode);

    /**
     * 发送短信验证码
     */
    @FormUrlEncoded
    @POST("sendSMSVerifyCode.json")
    Observable<SBaseResponse<SmsEntity>> sendSMSVerifyCode(
            @Field("phone") String phone,
            @Field("sendType") String sendType,
            @FieldMap Map<String, String> map);

    /**
     * 获取会员地址列表
     */
    @GET("getMemberAddressList.json")
    Observable<SBaseResponse<AddressListEntity>> getMemberAddressList(
            @Query("sessionID") String sessionID,
            @Query("memberID") String memberID,
            @Query("currentPage") int currentPage,
            @Query("pageNumber") int pageNumber,
            @Query("sortTypeOrder") String sortTypeOrder);

    /**
     * 获取会员地址详情
     */
    @GET("getOneMemberAddressDetail.json")
    Observable<SBaseResponse<AddressDetailEntity>> getOneMemberAddressDetail(
            @Query("sessionID") String sessionID,
            @Query("memberAddressID") String memberAddressID);


    /**
     * 创建会员地址
     */
    @GET("createMemberAddress.json")
    Observable<SBaseResponse> createMemberAddress(
            @Query("sessionID") String sessionID,
            @Query("name") String name,
            @Query("contactName") String contactName,
            @Query("isDefault") int isDefault,
            @Query("addType") int addType,//1= 家  2= 公司  3=其他
            @Query("phone") String phone,
            @Query("shengID") String shengID,
            @Query("shengName") String shengName,
            @Query("shiID") String shiID,
            @Query("shiName") String shiName,
            @Query("xianID") String xianID,
            @Query("xianName") String xianName,
            @Query("zhenID") String zhenID,
            @Query("zhenName") String zhenName,
            @Query("mapX") String mapX,
            @Query("mapY") String mapY);

    /**
     * 修改会员地址
     */
    @GET("updateMemberAddress.json")
    Observable<SBaseResponse> updateMemberAddress(
            @Query("sessionID") String sessionID,
            @Query("name") String name,
            @Query("phone") String phone,
            @Query("isDefault") int isDefault,
            @Query("addType") int addType,//1= 家  2= 公司  3=其他
            @Query("memberAddressID") String memberAddressID,
            @Query("shengID") String shengID,
            @Query("shengName") String shengName,
            @Query("shiID") String shiID,
            @Query("shiName") String shiName,
            @Query("xianID") String xianID,
            @Query("xianName") String xianName,
            @Query("zhenID") String zhenID,
            @Query("zhenName") String zhenName,
            @Query("mapX") String mapX,
            @Query("mapY") String mapY);


    /**
     * 设置会员地址为默认
     */
    @GET("setMemberAddressIsDefault.json")
    Observable<SBaseResponse> setMemberAddressIsDefault(
            @Query("sessionID") String sessionID,
            @Query("memberAddressID") String memberAddressID);

    /**
     * 删除会员地址
     */
    @GET("deleteMyMemberAddress.json")
    Observable<SBaseResponse> deleteMyMemberAddress(
            @Query("sessionID") String sessionID,
            @Query("memberAddressID") String memberAddressID);

    /**
     * 获取省市县数据列表
     */
    @GET("getCityList.json")
    Observable<SBaseResponse<AddressEntity>> getCityList(
            @Query("sessionID") String sessionID,
            @Query("currentPage") int currentPage,
            @Query("pageNumber") int pageNumber,
            @Query("depth") String depth,
            @Query("cityID") String cityID);

    /**
     * 获取我的银行卡列表
     */
    @GET("getMemberBankList.json")
    Observable<SBaseResponse<CardListEntity>> getMemberBankList(
            @Query("sessionID") String sessionID,
            @Query("currentPage") int currentPage,
            @Query("pageNumber") int pageNumber,
            @Query("sortTypeName") String sortTypeName);


    /**
     * 创建一个新的会员银行卡
     */
    @GET("submitOneMemberBank.json")
    Observable<SBaseResponse> submitOneMemberBank(
            @Query("sessionID") String sessionID,
            @Query("name") String name,//持卡人姓名
            @Query("bankID") String bankID,//总行id
            @Query("bankName") String bankName,//总行名称
            @Query("shortName") String shortName,//支行名称
            @Query("cardCode") String cardCode,
            @Query("phoneNumber") String phoneNumber);

    /**
     * 修改一个会员银行卡
     */
    @GET("updateMyMemberBank.json")
    Observable<SBaseResponse> updateMyMemberBank(
            @Query("sessionID") String sessionID,
            @Query("name") String name,//持卡人姓名
            @Query("bankName") String bankName,//总行名称
            @Query("shortName") String shortName,//支行名称
            @Query("cardCode") String cardCode,//卡号
            @Query("memberBankID") String memberBankID,
            @Query("phoneNumber") String phoneNumber);


    /**
     * 获取银行卡的详细信息
     */
    @GET("getMemberBankDetail.json")
    Observable<SBaseResponse<BankDetailEntity>> getMemberBankDetail(
            @Query("sessionID") String sessionID,
            @Query("memberBankID") String memberBankID);

    /**
     * 删除我的银行卡
     */
    @GET("deleteOneMemberBank.json")
    Observable<SBaseResponse> deleteOneMemberBank(
            @Query("sessionID") String sessionID,
            @Query("memberBankID") String memberBankID);

    /**
     * 设置我的银行卡为默认 默认isDefault=1
     */
    @GET("setMyMemberBankDefault.json")
    Observable<SBaseResponse> setMyMemberBankDefault(
            @Query("sessionID") String sessionID,
            @Query("memberBankID") String memberBankID);

    /**
     * 获取应用银行列表
     */
    @GET("getApplicationBankList.json")
    Observable<SBaseResponse<BankListEntity>> getApplicationBankList(
            @Query("sessionID") String sessionID,
            @Query("currentPage") int currentPage,
            @Query("pageNumber") int pageNumber,
            @Query("sortType") String sortType);


    /**
     * 获取支行列表
     */
    @GET("getBankList.json")
    Observable<SBaseResponse<BankBranchListEntity>> getBankList(
            @Query("sessionID") String sessionID,
            @Query("currentPage") int currentPage,
            @Query("pageNumber") int pageNumber,
            @Query("parentID") String parentID,
            @Query("cityID") String cityID,
            @Query("sortTypeCode") String sortTypeCode,
            @Query("showType") String showType);


    /**
     * 标准通用的申请实名认证
     */
    @GET("applyRealNameVerify.json")
    Observable<SBaseResponse> applyRealNameVerify(
            @Query("sessionID") String sessionID,
            @Query("name") String name,
            @Query("idNumber") String idNumber,
            @Query("faceImage") String faceImage,
            @Query("backImage") String backImage);


    /**
     * 查询会员实名认证的状态
     */
    @GET("queryMemberRealNameStatus.json")
    Observable<SBaseResponse<CertificateStatusEntity>> queryMemberRealNameStatus(
            @Query("sessionID") String sessionID);


    /**
     * 获取一个会员的信息
     */
    @GET("getOneMemberDetail.json")
    Observable<SBaseResponse<MemberEntity>> getOneMemberDetail(
            @Query("sessionID") String sessionID,
            @Query("memberID") String memberID);

    /**
     * 更新头像url
     */
    @GET("updateMyMemberAvatar.json")
    Observable<SBaseResponse> updateMyMemberAvatar(
            @Query("sessionID") String sessionID,
            @Query("avatarURL") String avatarURL);

    /**
     * 设置我的昵称
     */
    @GET("updateMyMemberShortname.json")
    Observable<SBaseResponse> updateMyMemberShortname(
            @Query("sessionID") String sessionID,
            @Query("shortName") String shortName);

    /**
     * 设置我的性别称谓
     */
    @GET("updateMyMemberTitle.json")
    Observable<SBaseResponse> updateMyMemberTitle(
            @Query("sessionID") String sessionID,
            @Query("titleID") String titleID);

    /**
     * 设置我的生日
     */
    @GET("updateMyMemberBirthday.json")
    Observable<SBaseResponse> updateMyMemberBirthday(
            @Query("sessionID") String sessionID,
            @Query("birthday") String birthday);


    /**
     * 会员退出清除session
     */
    @GET("loginOut.json")
    Observable<SBaseResponse> loginOut(
            @Query("sessionID") String sessionID);

    /**
     * 提交一个意见
     */
    @GET("submitOneFeed.json")
    Observable<SBaseResponse> submitOneFeed(
            @Query("sessionID") String sessionID,
            @Query("title") String title,
            @Query("content") String content,
            @Query("contact") String contact,
            @Query("attachmentList") String attachmentList);

    /**
     * 获取我的历史反馈列表
     */
    @GET("getMyFeedList.json")
    Observable<SBaseResponse<FeedListEntity>> getMyFeedList(
            @Query("sessionID") String sessionID,
            @Query("currentPage") int currentPage,
            @Query("pageNumber") int pageNumber,
            @Query("sortTypeTime") String sortTypeTime);


    /**
     * 提交一个会员发票定义
     */
    @GET("submitOneMemberInvoiceDefine.json")
    Observable<SBaseResponse> submitOneMemberInvoiceDefine(
            @Query("sessionID") String sessionID,
            @Query("invoiceType") int invoiceType,//1=个人，2=公司
            @Query("name") String name,
            @Query("taxType") int taxType,//1=普通，2=专用
            @Query("taxCode") String taxCode,
            @Query("address") String address,
            @Query("phone") String phone,
            @Query("bankName") String bankName,
            @Query("bankAccount") String bankAccount,
            @Query("isDefault") int isDefault);

    /**
     * 修改一个会员发票定义
     */
    @GET("updateMemberInvoiceDefine.json")
    Observable<SBaseResponse> updateMemberInvoiceDefine(
            @Query("sessionID") String sessionID,
            @Query("memberInvoiceDefineID") String memberInvoiceDefineID,
            @Query("invoiceType") int invoiceType,
            @Query("name") String name,
            @Query("taxType") int taxType,
            @Query("taxCode") String taxCode,
            @Query("address") String address,
            @Query("phone") String phone,
            @Query("bankName") String bankName,
            @Query("bankAccount") String bankAccount,
            @Query("isDefault") int isDefault);


    /**
     * 获取一个会员发票定义的详细信息
     */
    @GET("getMemberInvoiceDefineDetail.json")
    Observable<SBaseResponse<InvoiceDetailEntity>> getMemberInvoiceDefineDetail(
            @Query("sessionID") String sessionID,
            @Query("memberInvoiceDefineID") String memberInvoiceDefineID);

    /**
     * 设置会员发票定义为默认
     */
    @GET("setDefaultMemberInvoiceDefine.json")
    Observable<SBaseResponse> setDefaultMemberInvoiceDefine(
            @Query("sessionID") String sessionID,
            @Query("memberInvoiceDefineID") String memberInvoiceDefineID);

    /**
     * 获取会员发票定义列表
     */
    @GET("getMemberInvoiceDefineList.json")
    Observable<SBaseResponse<InvoiceEntity>> getMemberInvoiceDefineList(
            @Query("sessionID") String sessionID,
            @Query("invoiceType") int invoiceType,
            @Query("currentPage") int currentPage,
            @Query("pageNumber") int pageNumber,
            @Query("sortTypeTime") String sortTypeTime);

    /**
     * 删除一个会员发票定义
     */
    @GET("deleteOneMemberInvoiceDefine.json")
    Observable<SBaseResponse> deleteOneMemberInvoiceDefine(
            @Query("sessionID") String sessionID,
            @Query("memberInvoiceDefineID") String memberInvoiceDefineID);


    /**
     * 根据导航获取文章-简化列表
     */
    @GET("getNavigatorSimpleArticleList.json")
    Observable<SBaseResponse<NavigatorEntity>> getNavigatorSimpleArticleList(
            @Query("sessionID") String sessionID,
            @Query("navigatorID") String navigatorID,
            @Query("currentPage") int currentPage,
            @Query("pageNumber") int pageNumber,
            @Query("sortTypeTime") String sortTypeTime);

    /**
     * 获取文章简化详细信息
     */
    @GET("getArticleSimpleDetail.json")
    Observable<SBaseResponse<ArticleSimpleEntity>> getArticleSimpleDetail(
            @Query("articleID") String articleID);

    /**
     * 根据导航获取文章-复杂列表
     */
    @GET("getNavigatorArticleList.json")
    Observable<SBaseResponse<NavigatorEntity>> getNavigatorArticleList(
            @Query("sessionID") String sessionID,
            @Query("navigatorID") String navigatorID,
            @Query("currentPage") int currentPage,
            @Query("pageNumber") int pageNumber,
            @Query("sortTypeTime") String sortTypeTime);

    /**
     * 获取文章的详细信息
     */
    @GET("getArticleMoreDetail.json")
    Observable<SBaseResponse<ArticleMoreEntity>> getArticleMoreDetail(
            @Query("sessionID") String sessionID,
            @Query("articleID") String articleID);


    /**
     * 阅读一个文章
     */
    @GET("readingOneArticle.json")
    Observable<SBaseResponse> readingOneArticle(
            @Query("sessionID") String sessionID,
            @Query("articleID") String articleID);

    /**
     * 会员点赞一个对象
     */
    @GET("submitOnePraise.json")
    Observable<SBaseResponse> submitOnePraise(
            @Query("sessionID") String sessionID,
            @Query("objectDefineID") String objectDefineID,
            @Query("objectID") String objectID,
            @Query("objectName") String objectName);

    /**
     * 会员取消1个点赞
     */
    @GET("cancelOnePraise.json")
    Observable<SBaseResponse> cancelOnePraise(
            @Query("sessionID") String sessionID,
            @Query("praiseID") String praiseID);

    /**
     * 取消一个对象的收藏
     */
    @GET("deleteOneCollect.json")
    Observable<SBaseResponse> deleteOneCollect(
            @Query("sessionID") String sessionID,
            @Query("collectID") String collectID);


    /**
     * 获取版本的详细信息
     */
    @GET("getVersionDetail.json")
    Observable<SBaseResponse<VersionData>> getVersionDetail(
            @Query("siteID") String siteID);


    /**
     * 获取我收到的消息列表
     */
    @GET("getMyReceivedMessageList.json")
    Observable<SBaseResponse<MessageEntity>> getMyReceivedMessageList(
            @Query("sessionID") String sessionID,
            @Query("receiverMemberID") String receiverMemberID,
            @Query("listType") int listType,
            @Query("currentPage") int currentPage,
            @Query("pageNumber") int pageNumber,
            @Query("sortTypeOrder") String sortTypeOrder);

    /**
     * 获取消息的详细信息
     */
    @GET("getMessageDetail.json")
    Observable<SBaseResponse<MessageDetailEntity>> getMessageDetail(
            @Query("sessionID") String sessionID,
            @Query("messageID") String messageID);

    /**
     * 阅读一个消息
     */
    @GET("readOneMessage.json")
    Observable<SBaseResponse> readOneMessage(
            @Query("sessionID") String sessionID,
            @Query("messageID") String messageID);


    /**
     * 获取会员钱包统计数据
     */
    @GET("getMemberStatisticsWallet.json")
    Observable<SBaseResponse<WalletEntity>> getMemberStatisticsWallet(
            @Query("sessionID") String sessionID);

    /**
     * 获取会员资金变动余额记录列表
     */
    @GET("getMemberBalanceList.json")
    Observable<SBaseResponse<AccountEntity>> getMemberBalanceList(
            @Query("sessionID") String sessionID,
            @Query("currentPage") int currentPage,
            @Query("pageNumber") int pageNumber,
            @Query("sortTypeTime") int sortTypeTime);


    /**
     * 上传单张图片
     *
     * @param file 文件
     * @return ResponseBody
     */
    @Multipart
    @POST("uploadQiniu.json")
    Observable<SBaseResponse<ImageEntity>> uploadImg(@Part MultipartBody.Part file);

    /**
     * 上传多张图片
     *
     * @param files 文件
     * @return ResponseBody
     */
    @Multipart
    @POST("umps/test/getPictureAndVideo")
    Observable<ResponseBody> uploadImgs(@PartMap Map<String, RequestBody> files);

    /**
     * 图文混传（json格式）
     *
     * @param files 文件
     * @return ResponseBody
     */
    @Multipart
    @POST("report/patrol/addPatrolReport")
    Observable<ResponseBody> uploadFileWithJson(@Part("json") RequestBody body,
                                                @Part List<MultipartBody.Part> files);

    /**
     * 图文混传（map格式）
     *
     * @param files 文件
     * @return ResponseBody
     */
    @Multipart
    @POST("report/patrol/addPatrolReport")
    Observable<ResponseBody> uploadFileWithMap(@Part List<MultipartBody.Part> files);

    /**
     * 下载文件
     *
     * @return
     */
    @Streaming
    @GET
    Observable<ResponseBody> downLoadFile(@Url String url);
}
