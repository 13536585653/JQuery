package com.ms.msspace.util;

import java.security.MessageDigest;

public class MD5Util {

	public static void main(String[] args) {
		String s = MD5Util.MD5("123456");
		System.out.println(s);
	}

	/**
	 * 把密码进行MD5加密码 -> 32位16进制的字符串
	 * 
	 * @param s
	 *            明文
	 * @return
	 */
	public final static String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };

		try {
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("md5");

			// 生成密文
			byte md[] = mdInst.digest(s.getBytes());

			// 把密文转换成32位十六进制的字符串形式
			int len = md.length;
			char str[] = new char[len * 2];

			int k = 0;

			for (int i = 0; i < len; i++) {
				byte byte0 = md[i];
				// 右移四位，取其低四位
				str[k++] = hexDigits[byte0 >>> 4 & 0xF];

				// System.out.println("1:" + byte0);
				// System.out.println("2:" + Integer.toBinaryString(byte0));
				// System.out.println("3:" + Integer.toBinaryString(byte0 >>>
				// 4));
				// System.out.println("4:"
				// + Integer.toBinaryString(byte0 >>> 4 & 0xF));

				// 直接取其低四位
				str[k++] = hexDigits[byte0 & 0xf];
			}

			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
