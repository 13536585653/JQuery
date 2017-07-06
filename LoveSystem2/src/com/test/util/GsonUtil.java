package com.test.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {
	/*
	 *返回json，日期不用格式化 
	 */
		public static String toJson(Object obj){
			return new Gson().toJson(obj);
		}
		/*
		 *返回json，日期需要格式化 
		 */
		public static String toJson(Object obj,String date){
			
			//否则就使用GsonBuilder来创建Gson对象并且格式化日期
			//在通过GsonBuilder创建出来的Gson对象进行序列化
			GsonBuilder builder=new GsonBuilder();
			Gson gson=builder.setDateFormat(date).create();
			return gson.toJson(obj);
			
		}
		
			}

