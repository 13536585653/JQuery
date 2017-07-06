package org.demo.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {
	/**
	 * ����json�ַ���������ʽ������
	 */
	public static String toJson(Object obj){
		return new Gson().toJson(obj);
	}
	/**
	 * ����json��ͬʱ�����ڸ�ʽ��
	 *dateFormat yyyy-MM-dd
	 */
	public static String toJson(Object obj,String dateFormat){
		//�����ʹ��GsonBuilder������Gson����
		//�ڹ���GsonBuilder��ʱ�����ʹ������ָ�����ڵĸ�ʽ��
		//��ͨ��GsonBuilder����������gson�������������л�
		GsonBuilder builder=new GsonBuilder();
		Gson gson=builder.setDateFormat(dateFormat).create();
		return gson.toJson(obj);
	}
}
