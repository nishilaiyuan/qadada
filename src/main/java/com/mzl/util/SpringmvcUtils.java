package com.mzl.util;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @ClassName: SpringmvcUtils 
 * @Description: TODO 
 * @author 
 * @date 2011-11-26 下午5:21:30 
 * 
 * @version 1.0.0
 */
public class SpringmvcUtils {
	
	private static Logger logger = Logger.getLogger(SpringmvcUtils.class) ;

	// header 常量定义
	private static final String ENCODING_PREFIX = "encoding";
	private static final String NOCACHE_PREFIX = "no-cache";
	private static final String ENCODING_DEFAULT = "UTF-8";
	private static final boolean NOCACHE_DEFAULT = true;

	private SpringmvcUtils() {

	}

	public static void render(final String contentType, final String content, HttpServletResponse response,
			final String... headers) {
		try {
			// 分析headers参数
			String encoding = ENCODING_DEFAULT;
			boolean noCache = NOCACHE_DEFAULT;
			for (String header : headers) {
				String headerName = StringUtils.substringBefore(header, ":");
				String headerValue = StringUtils.substringAfter(header, ":");

				if (StringUtils.equalsIgnoreCase(headerName, ENCODING_PREFIX)) {
					encoding = headerValue;
				} else if (StringUtils.equalsIgnoreCase(headerName,
						NOCACHE_PREFIX)) {
					noCache = Boolean.parseBoolean(headerValue);
				} else
					throw new IllegalArgumentException(headerName
							+ "不是一个合法的header类型");
			}
			
			// 设置headers参数
			String fullContentType = contentType + ";charset=" + encoding;
			response.setContentType(fullContentType);
			if (noCache) {
				response.setHeader("Pragma", "No-cache");
				response.setHeader("Cache-Control", "no-cache");
				response.setDateHeader("Expires", 0);
			}

			Writer out = response.getWriter();
			out.write(content);
			out.flush();
			out.close();

		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	/**
	 * 直接输出文本.
	 * @see #render(String, String, String...)
	 */
	public static void renderText(final String text, HttpServletResponse response, final String... headers) {
		render("text/plain", text, response, headers);
	}

	/**
	 * 直接输出HTML.
	 * @see #render(String, String, String...)
	 */
	public static void renderHtml(final String html, HttpServletResponse response, final String... headers) {
		render("text/html", html, response, headers);
	}

	/**
	 * 直接输出XML.
	 * @see #render(String, String, String...)
	 */
	public static void renderXml(final String xml, HttpServletResponse response, final String... headers) {
		render("text/xml", xml, response, headers);
	}
	
	/**
	 * 直接输出XML.
	 * @see #render(String, String, String...)
	 */
	public static void renderXml(final String xml, HttpServletResponse response) {
		render("text/xml", xml, response, new String[] {"encoding:utf-8"});
	}

	/**
	 * 直接输出JSON.
	 * 
	 * @param string json字符串.
	 * @see #render(String, String, String...)
	 */
	public static void renderJson(final String string, HttpServletResponse response, final String... headers) {
		render("application/json", string,response, headers);
	}
	
	/**
	 * 直接输出JSON.
	 * 
	 * @param string json字符串.
	 * @see #render(String, String, String...)
	 */
	public static void renderJson(final String string, HttpServletResponse response) {
		render("application/json", string, response, new String[] {"encoding:utf-8"});
	}

	/**
	 * 直接输出JSON.
	 * 
	 * @param map Map对象,将被转化为json字符串.
	 * @see #render(String, String, String...)
	 */
	@SuppressWarnings({ "rawtypes" })
	public static void renderJson(final Map map, HttpServletResponse response, final String... headers) {
//		String jsonString = JsonUtil.getJson(map) ;
		String jsonString = JSON.toJSONString( map );
		renderJson(jsonString,response, headers);
	}

	/**
	 * 直接输出JSON.
	 * 
	 * @param object Java对象,将被转化为json字符串.
	 * @see #render(String, String, String...)
	 */
	public static void renderJson(final Object object, HttpServletResponse response, final String... headers) {
//		String jsonString = JsonUtil.getJson(object);
		String jsonString =  JSON.toJSONString(object);
		renderJson(jsonString,response, headers);
	}
	/**
	 * 直接输出JSON.
	 * 
	 * @param list List对象,将被转化为json字符串.
	 * @see #render(String, String, String...)
	 */
	@SuppressWarnings("rawtypes")
	public static void renderJson(final List list, HttpServletResponse response, final String... headers) {
//		String jsonString = JsonUtil.getArrayJson( list );
		String jsonString =  JSON.toJSONString( list );
		renderJson(jsonString,response, headers);
	}
}
