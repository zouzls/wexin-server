package com.bt.ommvets.rest.test;

import com.bt.ommvets.util.HttpUtil;
import com.bt.ommvets.util.ParseUtil;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author zouzl
 * @create 2017-06-03-20:15
 */
public class TestAlarmController {
    public static void main(String[] args) throws IOException {
        //测试发送信息接口
        //HashMap<String,Object> params=new HashMap<>();
        //params.put("touser","zouzls|hz-09230809|17671786096|saru_Fushimi|maomuS");
        //params.put("content","test45.76.222.18。。。");
        //JsonNode paramNode= ParseUtil.parseObjectToJsonNode(params);
        //String res= HttpUtil.executePost("http://45.76.222.18:8080/v1/weixin/alarm/send",paramNode.toString());
        //System.out.println(res);

        //测试添加报警接收用户接口
        HashMap<String,Object> params=new HashMap<>();
        params.put("weixin_no","maomuS");
        params.put("name","谢丹阳");
        params.put("mobile","13027140159");
        JsonNode paramNode= ParseUtil.parseObjectToJsonNode(params);
        String res= HttpUtil.executePost("http://localhost:8080/v1/weixin/alarm/user/create",paramNode.toString());
        System.out.println(res);

    }
}
