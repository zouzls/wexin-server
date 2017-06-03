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
        HashMap<String,Object> params=new HashMap<>();
        params.put("touser","zouzls|hz-09230809|17671786096|saru_Fushimi|maomuS");
        params.put("content","公元2017年6月3号，这是来自地球遥测运维系统-微信消息发送service的信息，你收到了，很幸运，你见证了这一刻。。。");
        JsonNode paramNode=ParseUtil.parseObjectToJsonNode(params);
        String res=HttpUtil.executePost("http://192.168.4.148:8080//v1/weixin/alarm/send",paramNode.toString());
        System.out.println(res);
    }
}
