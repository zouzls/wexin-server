package com.bt.ommvets.service;

import com.bt.ommvets.consts.QyApi;
import com.bt.ommvets.consts.WxConfig;
import com.bt.ommvets.entity.AccessToken;
import com.bt.ommvets.util.AccessTokenUtil;
import com.bt.ommvets.util.HttpUtil;
import com.bt.ommvets.util.ParseUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author zouzl
 * @create 2017-06-03-10:59
 */
@Service
public class AlarmService {

    public JsonNode send(JsonNode alarmNode) throws IOException {
        HashMap<String,Object> params=new HashMap<>();
        params.put("touser",alarmNode.path("touser").asText());
        params.put("msgtype","text");
        params.put("agentid", WxConfig.CORP_AGENTID);
        HashMap<String,String> content=new HashMap<>();
        content.put("content",alarmNode.path("content").asText());
        params.put("text",content);

        JsonNode paramNode=ParseUtil.parseObjectToJsonNode(params);
        //获取AccessToken
        AccessToken accessToken = AccessTokenUtil.getAccessToken();

        JsonNode resNode=null;
        if (accessToken!=null){
            String msgSendUrl= QyApi.MessageSendUrl.replace("ACCESS_TOKEN",accessToken.getAccess_token());
            String res=HttpUtil.executePost(msgSendUrl,paramNode.toString());
            resNode=ParseUtil.parseStringToJsonNode(res);
        }
        return resNode;
    }

    public static void main(String[] args) throws IOException {
        HashMap<String,Object> params=new HashMap<>();
        params.put("touser","zouzls|hz-09230809|17671786096");
        params.put("msgtype","text");
        params.put("agentid", WxConfig.CORP_AGENTID);
        HashMap<String,String> content=new HashMap<>();
        content.put("content","你们这群渣渣哈哈哈哈！");
        params.put("text",content);

        JsonNode paramNode=ParseUtil.parseObjectToJsonNode(params);
        AccessToken accessToken = AccessTokenUtil.getAccessToken();

        JsonNode resNode=null;
        if (accessToken!=null){
            String msgSendUrl= QyApi.MessageSendUrl.replace("ACCESS_TOKEN",accessToken.getAccess_token());
            String res=HttpUtil.executePost(msgSendUrl,paramNode.toString());
            resNode=ParseUtil.parseStringToJsonNode(res);
        }
        System.out.println(resNode.toString());
    }
}
