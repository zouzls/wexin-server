package com.bt.ommvets.rest;


import com.bt.ommvets.rest.base.BaseRestController;
import com.bt.ommvets.service.AlarmService;
import com.bt.ommvets.util.ParseUtil;
import com.bt.ommvets.util.ResponseCommonCode;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;

@Controller
public class AlarmRestController extends BaseRestController{

    @Autowired
    private AlarmService alarmService;

    @RequestMapping("/")
    @ResponseBody
    String home(String id ) {

        return "hello world !";
    }

    @RequestMapping(value = "/v1/weixin/alarm/send",method = RequestMethod.POST)
    @ResponseBody
    public HashMap<Object, Object> alarmSend(@RequestBody String body, HttpServletRequest request) {
        HashMap<Object,Object> returnMap=checkAuthorityAndFormat(body, request);
        if(returnMap!=null){
            return returnMap;
        }
        returnMap=new HashMap<Object, Object>();
        try {
            JsonNode alarmNode= ParseUtil.parseStringToJsonNode(body);
            JsonNode res=alarmService.send(alarmNode);
            if (res.path("errcode").asInt()==0){
                returnMap.put("status", ResponseCommonCode._200[0]);
                returnMap.put("msg",ResponseCommonCode._200[1]);
                returnMap.put("invaliduser",res.path("invaliduser").asText());
            }else {
                returnMap.put("status", ResponseCommonCode._500[0]);
                returnMap.put("msg",res.path("errmsg").asText());
            }
            return returnMap;
        }catch (IOException e){
            e.printStackTrace();
            returnMap.put("status", ResponseCommonCode._500[0]);
            returnMap.put("msg",ResponseCommonCode._500[1]);
            return returnMap;
        }
    }

    @RequestMapping(value = "/v1/weixin/alarm/user/create",method = RequestMethod.POST)
    @ResponseBody
    public HashMap<Object, Object> alarmUserAdd(@RequestBody String body, HttpServletRequest request) {
        HashMap<Object,Object> returnMap=checkAuthorityAndFormat(body, request);
        if(returnMap!=null){
            return returnMap;
        }
        returnMap=new HashMap<Object, Object>();
        try {
            JsonNode userNode= ParseUtil.parseStringToJsonNode(body);
            JsonNode res=alarmService.alarmUserAdd(userNode);
            if (res.path("errcode").asInt()==0){
                returnMap.put("status", ResponseCommonCode._200[0]);
                returnMap.put("msg",res.path("errmsg").asText());
            }else {
                returnMap.put("status", ResponseCommonCode._500[0]);
                returnMap.put("msg",res.path("errmsg").asText());
            }
            return returnMap;
        }catch (IOException e){
            e.printStackTrace();
            returnMap.put("status", ResponseCommonCode._500[0]);
            returnMap.put("msg",ResponseCommonCode._500[1]);
            return returnMap;
        }
    }

    @RequestMapping(value = "/v1/weixin/alarm/user/delete",method = RequestMethod.GET)
    @ResponseBody
    public HashMap<Object, Object> alarmUserDelete(String wechatno, HttpServletRequest request) {

        HashMap<Object, Object> returnMap=new HashMap<Object, Object>();
        try {

            JsonNode res=alarmService.alarmUserDelete(wechatno);
            if (res.path("errcode").asInt()==0){
                returnMap.put("status", ResponseCommonCode._200[0]);
                returnMap.put("msg",ResponseCommonCode._200[1]);
            }else {
                returnMap.put("status", ResponseCommonCode._500[0]);
                returnMap.put("msg",res.path("errmsg").asText());
            }
            return returnMap;
        }catch (IOException e){
            e.printStackTrace();
            returnMap.put("status", ResponseCommonCode._500[0]);
            returnMap.put("msg",ResponseCommonCode._500[1]);
            return returnMap;
        }
    }
}

