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
        AccessToken accessToken = AccessTokenUtil.getAccessToken(WxConfig.CORPID,WxConfig.CORP_ALARM_SECRET);

        JsonNode resNode=null;
        if (accessToken!=null){
            String msgSendUrl= QyApi.MessageSendUrl.replace("ACCESS_TOKEN",accessToken.getAccess_token());
            String res=HttpUtil.executePost(msgSendUrl,paramNode.toString());
            resNode=ParseUtil.parseStringToJsonNode(res);
        }
        return resNode;
    }

    public JsonNode alarmUserAdd(JsonNode userNode) throws IOException {

        HashMap<String,Object> params=new HashMap<>();
        params.put("userid",userNode.path("weixin_no").asText());
        params.put("name",userNode.path("name").asText());
        params.put("mobile",userNode.path("mobile").asText());
        params.put("department",WxConfig.YC_DEPARTMENT_ID);

        JsonNode paramNode=ParseUtil.parseObjectToJsonNode(params);
        //获取AccessToken
        AccessToken accessToken = AccessTokenUtil.getAccessToken(WxConfig.CORPID,WxConfig.CORP_CONTACT_SECRET);

        JsonNode resNode=null;
        if (accessToken!=null){
            String msgSendUrl= QyApi.UserCreateUrl.replace("ACCESS_TOKEN",accessToken.getAccess_token());
            String res=HttpUtil.executePost(msgSendUrl,paramNode.toString());
            resNode=ParseUtil.parseStringToJsonNode(res);
        }
        return resNode;
    }

    public JsonNode alarmUserDelete(String wexinNo) throws IOException {
        //获取AccessToken
        AccessToken accessToken = AccessTokenUtil.getAccessToken(WxConfig.CORPID,WxConfig.CORP_CONTACT_SECRET);

        JsonNode resNode=null;
        if (accessToken!=null){
            String msgSendUrl= QyApi.UserDeleteUrl.replace("ACCESS_TOKEN",accessToken.getAccess_token()).replace("USERID",wexinNo);
            String res=HttpUtil.executeGet(msgSendUrl);
            resNode=ParseUtil.parseStringToJsonNode(res);
        }
        return resNode;
    }

    public static void main(String[] args) {
        //创建部门
        //AccessToken accessToken = AccessTokenUtil.getAccessToken();
        //String DepartmentListUrl= QyApi.DepartmentCreateUrl.replace("ACCESS_TOKEN",accessToken.getAccess_token());
        //HashMap<String,Object> params=new HashMap<>();
        //params.put("name","test");
        //params.put("parentid",1);
        //JsonNode paramNode= ParseUtil.parseObjectToJsonNode(params);
        //String res= HttpUtil.executePost(DepartmentListUrl,paramNode.toString());

        //删除用户
        //AccessToken accessToken = AccessTokenUtil.getAccessToken(WxConfig.CORPID,WxConfig.CORP_CONTACT_SECRET);
        //String DepartmentListUrl= QyApi.UserDeleteUrl.replace("ACCESS_TOKEN",accessToken.getAccess_token()).replace("USERID","maomuS");
        //String res= HttpUtil.executeGet(DepartmentListUrl);
        //System.out.println(res);

        //创建用户
        //AccessToken accessToken = AccessTokenUtil.getAccessToken(WxConfig.CORPID,WxConfig.CORP_CONTACT_SECRET);
        //String DepartmentListUrl= QyApi.UserCreateUrl.replace("ACCESS_TOKEN",accessToken.getAccess_token());
        //HashMap<String,Object> params=new HashMap<>();
        //params.put("userid","hz-09230809");
        //params.put("name","娄季朝");
        //params.put("mobile","18062108164");
        //params.put("department",WxConfig.YC_DEPARTMENT_ID);
        //JsonNode paramNode= ParseUtil.parseObjectToJsonNode(params);
        //String res= HttpUtil.executePost(DepartmentListUrl,paramNode.toString());
        //System.out.println(res);
    }


}
