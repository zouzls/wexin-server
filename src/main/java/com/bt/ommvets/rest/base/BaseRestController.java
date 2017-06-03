package com.bt.ommvets.rest.base;
import com.bt.ommvets.util.ResponseCommonCode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zouzl
 * @create 2017-05-18-16:33
 */
public class BaseRestController {
    /**
     * 解析数据格式,如果解析失败返回Map对象,成功返回JsonNode
     * @param body
     * @return
     */
    public Object parseBody(String body){

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode=null;
        HashMap<Object, Object> returnMap = new HashMap<Object, Object>();
        try {
            rootNode = mapper.readTree(body);
        } catch (JsonProcessingException e) {
            returnMap.put("status", ResponseCommonCode._400[0]);
            returnMap.put("msg",ResponseCommonCode._400[1]);
            return returnMap;
        } catch (IOException e) {
            returnMap.put("status", ResponseCommonCode._500[0]);
            returnMap.put("msg",ResponseCommonCode._500[1]);
            return returnMap;
        }
        return rootNode;
    }

    /**
     * 校验权限,如果权限通过则返回空的字符串,不通过返回map
     * @param request
     * @return
     */
    protected Object checkAuthority(HttpServletRequest request){
        Map returnMap=new HashMap();
        String XAccessId = request.getHeader("X-AccessId");
        String XContentMD5 = request.getHeader("X-ContentMD5");
        String XSign = request.getHeader("X-Sign");
        String dateStr = request.getHeader("X-Date");

        return "";
    }
    /**
     * 校验格式和权限,如果返回全部通过则返回null,如果存在错误则返回Map
     * @param body
     * @param request
     * @return
     */
    protected HashMap<Object,Object> checkAuthorityAndFormat(String body, HttpServletRequest request){
        Object obj=parseBody(body);
        if (obj instanceof HashMap) {
            return (HashMap) obj;
        }
        //obj=checkAuthority(request);
        //if (obj instanceof HashMap) {
        //    return (HashMap) obj;
        //}
        return null;
    }
}

