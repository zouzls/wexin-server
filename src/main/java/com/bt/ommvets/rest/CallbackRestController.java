package com.bt.ommvets.rest;

import com.bt.ommvets.consts.WxConfig;
import com.bt.ommvets.service.CallbackService;
import com.bt.ommvets.util.SHA1;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




@Controller
public class CallbackRestController {
	@Autowired
	private CallbackService callbackService;

	
	/**
	 * 微信公众平台验证URL地址接口
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value="/weixin-server",method=RequestMethod.GET)
	protected void checkURL(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			// 开发者接入验证
			String timestamp = req.getParameter("timestamp");
			String nonce = req.getParameter("nonce");
			String signature = req.getParameter("signature");
			String echostr = req.getParameter("echostr");

			if (signature.equals(SHA1.gen(WxConfig.APP_TOKEN, timestamp, nonce))) {
				out(echostr, resp);
			} else {
				out("", resp);
			}
		} catch (Throwable e) {
			e.printStackTrace();
			out("", resp);
		}
	}
	/**
	 * 微信服务器与第三方厂商服务器通信的入口
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping(value="/weixin-server",method=RequestMethod.POST)
	protected void open(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		try {
			// 编码格式
			req.setCharacterEncoding("UTF-8");
			System.out.println("hello,iotxlink!");
			Map<String, String[]> paramMap = req.getParameterMap();
			for(String key: paramMap.keySet()){
				System.out.println(key+"："+paramMap.get(key));
			}
			// 验证签名
			String timestamp = req.getParameter("timestamp");
			String nonce = req.getParameter("nonce");
			String signature = req.getParameter("signature");
			System.out.println("signatrue:"+signature);
			System.out.println("sha1 sign:"+SHA1.gen(WxConfig.APP_TOKEN, timestamp, nonce));
			if (!signature.equals(SHA1.gen(WxConfig.APP_TOKEN, timestamp, nonce))) {
				out("", resp);
				return ;
			}

			// 解析xml
			Map<String, String> reqMap = parseXml(req.getInputStream());
			System.out.println("reqMap=" + reqMap);

			// 处理请求
			String xmlStr = callbackService.handle(reqMap);

			System.out.println("xmlStr=" + xmlStr);

			// null 转为空字符串
			xmlStr = xmlStr == null ? "" : xmlStr;

			out(xmlStr, resp);
		} catch (Throwable e) {
			e.printStackTrace();
			// 异常时响应空串
			out("", resp);
		}
	}

	/**
	 * 输出字符串
	 */
	protected void out(String str, HttpServletResponse response) {
		Writer out = null;
		try {
			response.setContentType("text/xml;charset=UTF-8");
			out = response.getWriter();
			out.append(str);
			out.flush();
		} catch (IOException e) {
			// ignore
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}
	}

	/**
	 * 解析请求中的xml元素为Map
	 */
	@SuppressWarnings("unchecked")
	private static Map<String, String> parseXml(InputStream in)
			throws DocumentException, IOException {
		Map<String, String> map = new HashMap<String, String>();
		SAXReader reader = new SAXReader();
		Document document = reader.read(in);
		Element root = document.getRootElement();
		List<Element> elementList = root.elements();
		for (Element e : elementList) {
			map.put(e.getName(), e.getText());
		}
		return map;
	}
}
