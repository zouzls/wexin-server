package com.bt.ommvets.service;


import com.bt.ommvets.consts.MsgType;
import com.bt.ommvets.consts.XmlResp;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Map;

/**
 * 回调业务处理
 */
@Service
@Validated
public class CallbackService {
	
	// 针对不同类型的消息和事件进行处理
	public String handle(Map<String, String> reqMap) throws Exception {
		String msgType = reqMap.get("MsgType");
		String fromUser = reqMap.get("FromUserName"); 
		String toUser = reqMap.get("ToUserName");// deviceType


		// 文本消息
		if (MsgType.TEXT.equals(msgType)) {
			// 可以在此处进行关键字自动回复
			String content = "收到文本消息：" + reqMap.get("Content");
			return XmlResp.buildText(fromUser, toUser, content);
		}
		
		// 基础事件推送，关注公众号和取消关注、菜单点击事件
		if (MsgType.EVENT.equals(msgType)) {
			String event = reqMap.get("Event");
			// 关注公众号
			if (MsgType.Event.SUBSCRIBE.equals(event)) {
				// 回复欢迎语
				return XmlResp.buildText(fromUser, toUser, "欢迎关注设备公众号！");
			}
		}
		// 未处理的情况返回空字符串
		return "";
	}
}
