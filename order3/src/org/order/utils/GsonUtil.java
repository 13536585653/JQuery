package org.order.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {
	/*
	 * ����json�ַ���������ʽ����
	 * 
	 * */
	public static String toJson(Object obj){
		return new Gson().toJson(obj);
	}
	
	/*
	 * ����json�ַ���������ʽ����
	 * 
	 * */
	
	public static String toJson(Object obj,String dateFormat){

		GsonBuilder builder=new GsonBuilder();
		Gson gson=builder.setDateFormat(dateFormat).create();
		return gson.toJson(obj);
		
	}
	
	public static String toJson2(Object obj,String dateFormat){
		//否则就创建一个GsonBuilder，进行格式化
		GsonBuilder builder=new GsonBuilder();
		Gson gson=builder.setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		return gson.toJson(obj);
	}

}
