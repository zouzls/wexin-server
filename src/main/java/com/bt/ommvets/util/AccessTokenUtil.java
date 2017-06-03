package com.bt.ommvets.util;

import com.bt.ommvets.consts.QyApi;
import com.bt.ommvets.consts.WxConfig;
import com.bt.ommvets.entity.AccessToken;

/**
 * @author zouzl
 * @create 2017-06-03-12:24
 */
public class AccessTokenUtil {

    public static AccessToken getAccessToken() {
        String url= QyApi.GetAccessTokenUrl.replace("CORPID", WxConfig.CORPID).replace("CORPSECRET", WxConfig.CORPSECRET);
        String resultContent = HttpUtil.executeGetToken(url);
        return AccessToken.fromJson(resultContent);
    }
}
