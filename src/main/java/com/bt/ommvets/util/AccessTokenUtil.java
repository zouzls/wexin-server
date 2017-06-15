package com.bt.ommvets.util;

import com.bt.ommvets.consts.QyApi;
import com.bt.ommvets.entity.AccessToken;

/**
 * @author zouzl
 * @create 2017-06-03-12:24
 */
public class AccessTokenUtil {


    public static AccessToken getAccessToken(String corpid,String secret) {
        String url= QyApi.GetAccessTokenUrl.replace("CORPID", corpid).replace("CORP_ALARM_SECRET", secret);
        String resultContent = HttpUtil.executeGet(url);
        return AccessToken.fromJson(resultContent);
    }
}
