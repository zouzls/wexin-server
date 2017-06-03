package com.bt.ommvets.util;

/**
 * @author zouzl
 * @create 2017-05-18-16:45
 */
public class ResponseCommonCode {

    public static Object[] _200={200,"success","成功"};
    public static Object[] _201={201,"Created!","请勿重复操作!"};
    public static Object[] _203={203,"session is timeout!","会话超时!"};
    public static Object[] _400={400,"Bad Request","请求参数或者格式不对"};
    public static Object[] _403={403,"forbidden","身份验证失败"};
    public static Object[] _404={404,"not found data","找不到对应的数据"};
    public static Object[] _405={405,"no authority","没有access权限"};
    public static Object[] _500={500,"server exception","服务器异常"};
    public static Object[] _504={504,"Gateway Timeout","请求超时"};
}
