package com.cloudwave.fwcore.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author DolphinBoy
 * 2013年8月30日 下午2:58:01
 * 正则验证工具类
 */

public class RegexUtils {
	public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	public static final String REGEX_PHONE_NUMBER = "^(13[4,5,6,7,8,9]|15[0,8,9,1,7]|188|187)\\d{8}$";
	// number, character, underline
	public static final String REGEX_NCU = "[^a-zA-Z0-9._-]";
	
	public static boolean isEmail(String email) {
		Pattern regex = Pattern.compile(REGEX_EMAIL);
		Matcher matcher = regex.matcher(email);
		return matcher.matches();
	}
	
	
	public static boolean isPhoneNumber(String phoneNumber) {
		Pattern regex = Pattern.compile(REGEX_PHONE_NUMBER);
		Matcher matcher = regex.matcher(phoneNumber);
		return matcher.matches();

	}
	
	public static boolean isNcu(String value) {
		Pattern regex = Pattern.compile(REGEX_NCU);
		Matcher matcher = regex.matcher(value);
		return matcher.matches();
	}
	
	/**
	 * 过滤掉全部非[数字,字母,下划线]的字符
	 * @param value
	 * @return
	 */
	public static String filtUnNcu(String value) {
		Pattern regex = Pattern.compile(REGEX_NCU);
		Matcher matcher = regex.matcher(value);
		return matcher.replaceAll("");
	}
	
	public static void main(String[] args) {
//		System.out.println(isEmail("fwe_qq.com"));
		System.out.println(isNcu("fwe_qq.com"));
	}
}
