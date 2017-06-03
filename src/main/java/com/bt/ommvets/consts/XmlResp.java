package com.bt.ommvets.consts;


/**
 * Xml协议响应
 */
public class XmlResp {

	/**
	 * 文本消息响应格式
	 */
	public static final String TEXT = new StringBuilder()
			.append("<xml>")
			.append("<ToUserName><![CDATA[%s]]></ToUserName>")
			.append("<FromUserName><![CDATA[%s]]></FromUserName>")
			.append("<CreateTime>%s</CreateTime>")
			.append("<MsgType><![CDATA[%s]]></MsgType>")
			.append("<Content><![CDATA[%s]]></Content>")
			.append("</xml>").toString();
	
	/**
	 * 构造文本消息响应
	 */
	public static final String buildText(String toUser, String fromUser, String content) {
		return String.format(TEXT, toUser, fromUser, time(), MsgType.TEXT, content);
	}
	
	/**
	 * 设备消息响应格式
	 */
	public static final String DEVICE_TEXT = new StringBuilder()
			.append("<xml>")
			.append("<ToUserName><![CDATA[%s]]></ToUserName>")
			.append("<FromUserName><![CDATA[%s]]></FromUserName>")
			.append("<CreateTime>%s</CreateTime>")
			.append("<MsgType><![CDATA[%s]]></MsgType>")
			.append("<DeviceType><![CDATA[%s]]></DeviceType>")
			.append("<DeviceID><![CDATA[%s]]></DeviceID>")
			.append("<SessionID>%s</SessionID>")
			.append("<Content><![CDATA[%s]]></Content>")
			.append("</xml>").toString();
	
	/**
	 * 构造设备消息响应
	 */
	public static final String buildDeviceText(String fromUser, String toUser,
			String deviceType, String deviceID, String content, String sessionID) {
		return String.format(DEVICE_TEXT, fromUser, toUser, time(),
				MsgType.DEVICE_TEXT, deviceType, deviceID, sessionID, content);
	}

	/**
	 * 秒级时间戳
	 */
	private static String time(){
		return String.valueOf(System.currentTimeMillis() / 1000);
	}

}
