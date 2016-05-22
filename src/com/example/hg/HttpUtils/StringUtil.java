package com.example.hg.HttpUtils;

import android.widget.Toast;

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
	/** 替换手机号中间4位 */
	public static String replacephoneStrinsg(String phone) {
		String sub = "";
		try {
			
			sub = phone.substring(0, 3);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i<4; i++) {
				sb = sb.append("*");
			}
			sub += sb.toString();
			sub+=phone.substring(7,phone.length());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sub;
	}
	public static String replacephoneString(String tel) {
		return tel.replace(tel.substring(4,8),"****");
	}
	

}
