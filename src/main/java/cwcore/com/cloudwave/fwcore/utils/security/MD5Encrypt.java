/**********************************************************************
 * Copyright (C) 2006 ShenZhen SKY TECH.CO.,LTD.
 *
 * Class name : com.sky.frame.system.MD5Encrypt
 *
 * Description :
 *
 * Create tag : HibernateCat 2006-5-30
 *
 * Modify tag : HibernateCat 2006-5-30
 *
 * Modified Description :
 *********************************************************************/

package com.cloudwave.fwcore.utils.security;

import java.security.MessageDigest;

/**
 * Md5加密公用类
 * 
 * @author Tom Koo
 * @since 1.0
 */
public class MD5Encrypt {

	private final static String enCoding = "utf-8";

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	public static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0) {
			n = 256 + n;
		}
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	/**
	 * 对输入的源字符串进行Md5加密，返回加密后的32位字符串
	 * 
	 * @param origin
	 *            加密源字符串
	 * @return
	 */
	public static String encrypt(String origin) {
		String resultString = null;

		try {
			resultString = origin;
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest(resultString
					.getBytes(enCoding)));
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return resultString;
	}

	public static void main(String[] args) {

		String encryptPwd = MD5Encrypt.encrypt(MD5Encrypt.encrypt("1111"
				+ "1234")
				+ "1234");
		System.out.println(encryptPwd);
	}
}
