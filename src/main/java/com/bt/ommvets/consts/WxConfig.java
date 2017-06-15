package com.bt.ommvets.consts;

/**
 * 微信公众账号开发者配置
 */
public abstract class WxConfig {
	//订阅号
	public static  String APPID="wxf0dfdfd617122046";
	public static  String APPSECRET="b7dfed4efdd22501a5f554a33daf4a4d";
	public static  String APP_TOKEN ="weixinserver";

	//企业号
	public static  String CORPID="wxbd63dd957e639c34";

	//企业号-遥测运维报警应用
	public static  String CORP_ALARM_SECRET ="0UTLSVhl-kSuFBqfNpLuL8CzawMpzdcSAre72IbigOc";
	public static  int CORP_AGENTID=1000002;

	//企业号-通信录同步工具
	public static String CORP_CONTACT_SECRET ="98EcJyjEjEys_qwD8096X-7Z8CnL4uzwl2nzXifUHK4";

	//遥测运维报警接收用户组ID
	public static int [] YC_DEPARTMENT_ID= {2};

}
