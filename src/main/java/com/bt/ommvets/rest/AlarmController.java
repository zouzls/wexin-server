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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;

@Controller
public class AlarmController extends BaseRestController{

    @Autowired
    private AlarmService alarmService;

    @RequestMapping("/")
    @ResponseBody
    String home(String id ) {

        return "hello world !";
    }

    @RequestMapping("/v1/weixin/alarm/send")
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
            returnMap.put("status", ResponseCommonCode._200[0]);
            returnMap.put("msg",ResponseCommonCode._200[1]);
            returnMap.put("invaliduser",res.path("invaliduser").asText());
            return returnMap;
        }catch (IOException e){
            e.printStackTrace();
            returnMap.put("status", ResponseCommonCode._500[0]);
            returnMap.put("msg",ResponseCommonCode._500[1]);
            return returnMap;
        }
    }

}

