package douban.kotlin.annarm.android_retrofitrxjava_dome_2019_04_22.ligong;

/**
 * author: created by LiGong on 2019/4/10
 * description: 服务器接口地址
 */
public class Api {
    //测试环境：39.106.136.132   正式环境：39.96.90.150
    public static final String API_BASE = "http://39.96.90.150";

    /*启动页  此接口后台暂未添加*/
    public static final String SPLASH = API_BASE + "/api/adv";
    /*渠道统计标识*/
    public static final String CHANNEL_FLAG = API_BASE + "/az/market";
    /*登录*/
    public static final String LOGIN = API_BASE + "/az/valiLogin";
    /*忘记密码*/
    public static final String FORGET_PWD = API_BASE + "/az/changeForget";
    /*手机号是否已注册*/
    public static final String isRegister = API_BASE + "";
    /*获取验证码*/
    public static final String GET_VERIFICA_CODE = API_BASE + "/az/getVerify";
    /* 还款短信验证*/
    public static final String GET_VERIFICA_REPAYMENT = API_BASE + "/az/newpropay";
    /*注册*/
    public static final String REGISTER = API_BASE + "/az/register";
    /*上传用户当前位置*/
    public static final String SUBMIT_CURR_LOCATION = API_BASE + "";
    /*上传身份证正面*/
    public static final String UPLOAD_ID = API_BASE + "/az/fileUpload";
    /*上传身份证正面路径 */
    public static final String UPLOAD_ID_PATH = API_BASE + "/az/userInfo1";
    /*上传身份证反面*/
    public static final String UPLOAD_ID_B = API_BASE + "/az/fileUpload";
    /*上传身份证反面路径 */
    public static final String UPLOAD_ID_B_PATH = API_BASE + "/az/userInfo2";
    /*上传银行卡照*/
    public static final String UPLOAD_BANK_CARD = API_BASE + "/az/fileUpload";
    /*上传银行卡照 路径*/
    public static final String UPLOAD_ID_BANK_PATH = API_BASE + "/az/userInfo3";
    /* 活体验证*/
    public static final String LIVING_VERIFY = API_BASE + "/az/face";
    /*上传紧急联系人*/
    public static final String SUBMIT_EMERG_CONTACT = API_BASE + "/az/userInfo4";
    /*采集/服务密码*/
    public static final String OPERATORN_SERVICE_PWD = API_BASE + "/az/collection";
    /* 获取采集码1*/
    public static final String OBTAIN_ACQ_1 = API_BASE + "/az/userInfo5";
    /*获取采集码2*/
    public static final String OBTAIN_ACQ_2 = API_BASE + "/az/userInfo6";
    /*完善注册个人信息*/
    public static final String FILL_REGISTER_INFO = API_BASE + "";
    /*获取首页数据*/
    public static final String HOME_PAGE_INFO = API_BASE + "/az/index";
    /* 去验证是否实名通过*/
    public static final String TO_VERIFY_REAL_NAME = API_BASE + "/az/testing";
    /* 统计扫描次数*/
    public static final String TO_SCANNING_NUMS = API_BASE + "/az/riskNumber";
    /*定位和联系人是否获取成功*/
    public static final String TO_LOCATE_CONTACTS = API_BASE + "/az/openLocation";
    /*是否身份认证（身份证正反面/银行卡 ）*/
    public static final String TO_AUTH_REAL_NAME = API_BASE + "/az/realName";
    /*获取申请借款信息*/
    public static final String GET_LOAN_INFO = API_BASE + "/az/quota";
    /* 立即申请贷款  提交*/
    public static final String TO_APPLICATION_LOAN = API_BASE + "/az/bill";
    /* 提交还款信息*/
    public static final String TO_SUBMIT_LOAN_INFO = API_BASE + "/az/oldpropay";
    /*修改密码*/
    public static final String CHANGE_PWD = API_BASE + "/az/modifyForget";
    /* 更多产品 */
    public static final String MORE_PRODUCTS = API_BASE + "";
    /*分享*/
    public static final String SHARE = API_BASE + "";
    /* 订单 进行中*/
    public static final String BILL_HAVE_IN_DATA = API_BASE + "/az/billList";
    /* 订单  已完成*/
    public static final String BILL_COMLETED_DATA = API_BASE + "/az/billList";
    /*订单详情*/
    public static final String BILL_DETAIL_INFO = API_BASE + "/az/billDetails";
    /*还款*/
    public static final String BILL_TO_REPAY = API_BASE + "/az/repayment";
    /* 消息 list */
    public static final String NEWS_LIST = API_BASE + "/az/messageList";
    /* 消息 详情*/
    public static final String NEWS_DETAIL = API_BASE + "/az/messageInfo";
    /* 攻略 详情*/
    public static final String TRATEGY_DETAIL = API_BASE + "";
    /*攻略 list */
    public static final String STRATEGY_LIST = API_BASE + "";
    /*个人中心*/
    public static final String MY = API_BASE + "/az/personal";
    /*注册认证状态*/
    public static final String AUTHENTICATION_STATE = API_BASE + "/az/authentication";
    /*判断分控单双渠道*/
    public static final String IS_JUDGE_CHANNEL = API_BASE + "/az/judgeChannel";
    /*运营商验证  http://39.96.90.150/az/getMxurl?uid=【用户Id】*/
    public static final String OPERATOR_VERIFICATION = API_BASE + "/az/getMxurl";
    /*回显身份证正面数据*/
    public static final String USER_DETAILS1 = API_BASE + "/az/userDetails1";
    /*回显身份证反面数据*/
    public static final String USER_DETAILS2 = API_BASE + "/az/userDetails2";
    /*回显银行卡数据*/
    public static final String USER_DETAILS3 = API_BASE + "/az/userDetails3";
    /*父母联系人*/
    public static final String USER_DETAILS4 = API_BASE + "/az/userDetails4";
    /*活体验证 回显数据 */
    public static final String USER_DETAILS5 = API_BASE + "/az/userDetails5";
    /*上传通讯录*/
    public static final String ADDRESS_LIST = API_BASE + "/az/addressList";
    /*定位信息*/
    public static final String LOCATION_INFO = API_BASE + "/az/position";
    /*贷款超市列表*/
    public static final String MORE_PRODUCT_LIST = API_BASE + "/az/shopList";
    /*贷款超市详情*/
    public static final String MORE_PRODUCT_DETAIL = API_BASE + "/az/shopDetails";
    /*特别声明*/
    public static final String HOME_HE_TONG = API_BASE + "/home/hetong";
    /*使用说明*/
    public static final String HOME_SHI_YONG = API_BASE + "/home/shiyong";
    /*分享 链接*/
    public static final String HOME_SHI_SHARE = API_BASE + "/home/share";
    /* 其他认证*/
    public static final String OTHER_AUTH = API_BASE + "/az/userInfo7";
    /*其他认证 回显数据*/
    public static final String USER_DETAILS7 = API_BASE + "/az/userDetails7";
    /*验证码得到授权，从银行卡扣钱*/
    public static final String BANK_CODE = API_BASE + "/az/bankCode";
    /*app强制更新*/
    public static final String APP_UPDATE = API_BASE + "/az/replace";
    /*个人信息授权书  /home/warrant?id= */
    public static final String EMERGENCY_CERTIFICATE_OF_AUTH = API_BASE + "/home/warrant?id=";
    /*认证服务协议*/
    public static final String EMERGENCY_AUTH_SERVICE_PROTOCOL = API_BASE + "/home/service?id=";
}
