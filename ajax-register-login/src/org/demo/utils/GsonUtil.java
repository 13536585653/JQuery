package org.demo.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {
	/**
	 * 返回json字符串，不格式化日期
	 */
	public static String toJson(Object obj){
		return new Gson().toJson(obj);
	}
	/**
	 * 返回json，同时带日期格式化
	 *dateFormat yyyy-MM-dd
	 */
	public static String toJson(Object obj,String dateFormat){
		//否则就使用GsonBuilder来构建Gson对象，
		//在构建GsonBuilder的时候可以使用它来指定日期的格式化
		//再通过GsonBuilder创建出来的gson对象来进行序列化
		GsonBuilder builder=new GsonBuilder();
		Gson gson=builder.setDateFormat(dateFormat).create();
		return gson.toJson(obj);
	}
}
