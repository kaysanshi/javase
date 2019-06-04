package com.itheima.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//该MessageDigest类为应用程序提供消息摘要算法的功能，如SHA-1或SHA-256。 
//消息摘要是采用任意大小的数据并输出固定长度散列值的安全单向散列函数。
public class MD5Utils {
    /**
	 * 使用md5的算法进行加密
	 */
	public static String md5(String plainText) {
		byte[] secretBytes = null;
		try {
			//返回实现指定摘要算法的MessageDigest对象。 
			secretBytes = MessageDigest.getInstance("md5").digest(
					plainText.getBytes());
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("没有md5这个算法！");
		}
		String md5code = new BigInteger(1, secretBytes).toString(16);
		for (int i = 0; i < 32 - md5code.length(); i++) {
			md5code = "0" + md5code;
		}
		return md5code;
	}
}
