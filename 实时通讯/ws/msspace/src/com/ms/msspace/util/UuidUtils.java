package com.ms.msspace.util;

import java.util.UUID;

public class UuidUtils {
	public static String uuid(){
		//返回一个不重复的字符串
		return UUID.randomUUID().toString().replace("-", "").toUpperCase() ; 
		
		
	}
}
