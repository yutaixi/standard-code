package org.standard.java.common.string;

public class ByteToBinary {
	/**
	 * 把byte数组转化成2进制字符串
	 * 
	 * @param bArr
	 * @return
	 */
	public static String getBinaryStrFromByteArr(byte[] bArr) {
		StringBuffer result=new StringBuffer();
		for (byte b : bArr) {
			result.append(getBinaryStrFromByte(b));
		}
		return result.toString();
	}

	/**
	 * 把byte转化成2进制字符串
	 * 
	 * @param b
	 * @return
	 */
//	public static  String getBinaryStrFromByte(byte b) {
//		String result = "";
//		byte a = b;
//		;
//		for (int i = 0; i < 8; i++) {
//			byte c = a;
//			a = (byte) (a >> 1);// 每移一位如同将10进制数除以2并去掉余数。
//			a = (byte) (a << 1);
//			if (a == c) {
//				result = "0" + result;
//			} else {
//				result = "1" + result;
//			}
//			a = (byte) (a >> 1);
//		}
//		return result;
//	}
	
	public static  String getBinaryStrFromByte(byte b) {
		StringBuffer result=new StringBuffer();
		byte a = b;
		;
		for (int i = 0; i < 8; i++) {
			byte c = a;
			a = (byte) (a >> 1);// 每移一位如同将10进制数除以2并去掉余数。
			a = (byte) (a << 1);
			if (a == c) {
				result.insert(0, "0"); 
			} else {
				result.insert(0, "1"); 
			}
			a = (byte) (a >> 1);
		}
		return result.toString();
	}

	/**
	 * 把byte转化成2进制字符串
	 * 
	 * @param b
	 * @return
	 */
	public static  String getBinaryStrFromByte2(byte b) {
		String result = "";
		byte a = b;
		;
		for (int i = 0; i < 8; i++) {
			result = (a % 2) + result;
			a = (byte) (a >> 1);
		}
		return result;
	}

	/**
	 * 把byte转化成2进制字符串
	 * 
	 * @param b
	 * @return
	 */
	public static  String getBinaryStrFromByte3(byte b) {
		String result = "";
		byte a = b;
		;
		for (int i = 0; i < 8; i++) {
			result = (a % 2) + result;
			a = (byte) (a / 2);
		}
		return result;
	}
}