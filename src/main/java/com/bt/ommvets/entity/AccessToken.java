package com.bt.ommvets.entity;

import com.bt.ommvets.util.ParseUtil;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * @author zouzl
 * @create 2017-06-03-11:02
 */
public class AccessToken {
    private String access_token;// 令牌
    private long expires_in;// 有效时长 单位秒
    private long createTime;// 创建时间 单位毫秒

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(long expires_in) {
        this.expires_in = expires_in;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public static AccessToken fromJson(String json){
        JsonNode jsonNode = null;
        try {
            jsonNode = ParseUtil.parseStringToJsonNode(json);
            String access_token=jsonNode.path("access_token").asText();
            Integer expires_in=jsonNode.path("expires_in").asInt();
            AccessToken token =  new AccessToken();
            token.setAccess_token(access_token);
            token.setCreateTime(expires_in);
            token.setCreateTime(System.currentTimeMillis());
            return token;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
