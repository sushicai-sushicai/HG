package com.example.hg.HttpUtils;


import com.alibaba.fastjson.JSONObject;



public class StringUtil {
	/** 判断是不是合法的json对象 */
	public static boolean isJSONObejcet(String str) {
		try {
			JSONObject.parse(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public static String replacephoneString(String tel) {
		return tel.replace(tel.substring(4,8),"****");
	}
	

}
