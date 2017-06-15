package com.bt.ommvets.consts;

/**
 * @author zouzl
 * @create 2017-06-01-16:52
 */
public class QyApi {
    public static String GetAccessTokenUrl="https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=CORPID&corpsecret=CORP_ALARM_SECRET";
    public static String MessageSendUrl="https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=ACCESS_TOKEN";

    public static String UserCreateUrl="https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token=ACCESS_TOKEN";
    public static String UserDeleteUrl="https://qyapi.weixin.qq.com/cgi-bin/user/delete?access_token=ACCESS_TOKEN&userid=USERID";
    public static String DepartmentCreateUrl="https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token=ACCESS_TOKEN";
    public static String DepartmentListUrl="https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=ACCESS_TOKEN&id=ID";
}
