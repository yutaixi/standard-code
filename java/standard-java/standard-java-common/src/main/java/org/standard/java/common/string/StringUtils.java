package org.standard.java.common.string;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 字符串处理工具类
 * 
 * @author jiang.li
 * @date 2013-12-18 11:22
 */
public class StringUtils {
	
	private static final String RANDOM_STRING_RANGE="abcdefghijkmnpqrstuvwxyzABCDEFGHIJKLMNPQRSTUVWXYXZ";
	private static final String RANDOM_NUM_RANGE="123456789";
	private static final String RANDOM_STRING_AND_NUM_RANGE="23456789abcdefghijkmnpqrstuvwxyzABCDEFGHIJKLMNPQRSTUVWXYXZ";

	public static boolean isBlank(final CharSequence cs) {
		int strLen;
		if (cs == null || (strLen = cs.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if (!Character.isWhitespace(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 检查字符串是否为空
	 * 
	 * @param str 字符串
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str == null) {
			return true;
		} else if (str.trim().length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 检查字符串是否为空
	 * 
	 * @param str 字符串
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		if (str == null) {
			return false;
		} else if (str.length() == 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 把字符串按分隔符转换为数组
	 * 
	 * @param str  字符串
	 * @param expr 分隔符
	 * @return
	 */
	public static String[] stringToArray(String str, String expr) {
		return str.split(expr);
	}

	/**
	 * 将数组按照给定的分隔转化成字符串
	 * 
	 * @param arr
	 * @param expr
	 * @return
	 */
	public static String arrayToString(String[] arr, String expr) {
		String strInfo = null;
		if (arr != null && arr.length > 0) {
			StringBuffer sf = new StringBuffer();
			for (String str : arr) {
				sf.append(str);
				sf.append(expr);
			}
			strInfo = sf.substring(0, sf.length() - 1);
		}
		return strInfo;
	}

	/**
	 * 将集合按照给定的分隔转化成字符串
	 * 
	 * @param arr
	 * @param expr
	 * @return
	 */
	public static String listToString(List<String> list, String expr) {
		String strInfo = "";
		if (list != null && list.size() > 0) {
			StringBuffer sf = new StringBuffer();
			for (String str : list) {
				sf.append(str);
				sf.append(expr);
			}
			strInfo = sf.substring(0, sf.length() - 1);
		}
		return strInfo;
	}

	// 中文字符转unicode
	public static String stringToUnicode(String s) {
		return JSON.toJSONString(s, SerializerFeature.BrowserCompatible);
	}

	public static String stringToUnicode(char s) {
		return JSON.toJSONString(s, SerializerFeature.BrowserCompatible);
	}

	public static String getUnicodeFormatString(String s) {
		if (s == null || s.trim().length() == 0) {
			return "";
		}
		return StringUtils.stringToUnicode(s).replaceAll("\"", "").replaceAll("\\\\u", "");
	}

	// 生成uuid
	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

	/**
	 * 生成随机指定位数的字母和数字组合
	 * @param num
	 * @return
	 */
	public static String getRandomCode(int num) {
		return getRandomString(num,RANDOM_STRING_AND_NUM_RANGE);
	}
	/**
	 * 生成指定位数纯字母组合，区分大小写
	 * @param num
	 * @return
	 */
	public static String getRandomString(int num)
	{
		return getRandomString(num,RANDOM_STRING_RANGE);
	}
	/**
	 * 生成指定位数纯数字组合
	 * @param num
	 * @return
	 */
	public static String getRandomNum(int num)
	{
		return getRandomString(num,RANDOM_NUM_RANGE);
	}
	
	/**
	 * 随机生成固定7位密码，数字和字母组合
	 * @return
	 */
	public static String getRandomPassword()
	{
		return getRandomString(3)+getRandomNum(4);
	}

	public static String getRandomString(int num,String range)
	{
		if(num<1 || StringUtils.isBlank(range))
		{
			return null;
		}
		 
		StringBuffer result = new StringBuffer();
		Random random = ThreadLocalRandom.current();
		int maxIndex=range.length();
		for (int i = 0; i < num; i++) {
			result.append(range.charAt(random.nextInt(maxIndex)));
		}
		return result.toString();
	}
	
//	public static void main(String[] args)
//	{
////		System.out.println(getRandomPassword());
//		
//		System.out.println(getRandomCode(1));
//		
////		System.out.println(getRandomString(4));
//		
////		System.out.println(getRandomNum(5));
//	}
}
