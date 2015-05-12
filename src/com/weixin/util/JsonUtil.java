package com.weixin.util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.DefaultValueProcessor;
import net.sf.json.processors.JsDateJsonBeanProcessor;
import net.sf.json.processors.JsonBeanProcessor;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.processors.PropertyNameProcessor;
import net.sf.json.util.CycleDetectionStrategy;
import net.sf.json.util.PropertyFilter;

public class JsonUtil {
	/**
	 * 从一个JSON 对象字符格式中得到一个java对象
	 * 
	 * @param jsonStr
	 * @param beanClass
	 * @return pojo
	 */
	public static Object getObjectFromJsonStr(String jsonStr, Class beanClass) {
		JSONObject jsonObject = JSONObject.fromObject(jsonStr);
		Object pojo = JSONObject.toBean(jsonObject, beanClass);
		return pojo;
	}

	/**
	 * 从一个JSON 对象字符格式中得到一个java对象,对象有集合属性
	 * 
	 * @param jsonStr
	 * @param beanClass
	 * @param classMap
	 * @param pojo
	 * @return
	 */
	public static Object getObjectFromJsonStr(String jsonStr, Class beanClass,
			Map classMap) {
		JSONObject jsonObject = JSONObject.fromObject(jsonStr);
		Object pojo = JSONObject.toBean(jsonObject, beanClass, classMap);
		return pojo;
	}

	public static List getListFromJsonStr(String jsonStr, Class beanClass) {
		JSONArray jsonList = JSONArray.fromObject(jsonStr);
		List list = (List) JSONArray.toList(jsonList, beanClass);
		return list;
	}

	public static List getListFromJsonStr(String jsonStr, Class beanClass,
			Map classMap) {
		JSONArray jsonList = JSONArray.fromObject(jsonStr);
		List list = (List) JSONArray.toList(jsonList, beanClass, classMap);
		return list;
	}

	public static JSONObject getJSONObjectFromObj(Object obj) {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);// 保证不会死循环
		//jsonConfig.setIgnoreDefaultExcludes(true);// 保证不会丢失key  fasle可能会丢失
		JSONObject json = JSONObject.fromObject(obj, jsonConfig);
		return json;
	}

}
