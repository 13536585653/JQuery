package com.test.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {
	/*
	 *����json�����ڲ��ø�ʽ�� 
	 */
		public static String toJson(Object obj){
			return new Gson().toJson(obj);
		}
		/*
		 *����json��������Ҫ��ʽ�� 
		 */
		public static String toJson(Object obj,String date){
			
			//�����ʹ��GsonBuilder������Gson�����Ҹ�ʽ������
			//��ͨ��GsonBuilder����������Gson����������л�
			GsonBuilder builder=new GsonBuilder();
			Gson gson=builder.setDateFormat(date).create();
			return gson.toJson(obj);
			
		}
		
			}

