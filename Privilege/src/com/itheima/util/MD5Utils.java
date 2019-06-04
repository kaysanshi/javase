package com.itheima.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//��MessageDigest��ΪӦ�ó����ṩ��ϢժҪ�㷨�Ĺ��ܣ���SHA-1��SHA-256�� 
//��ϢժҪ�ǲ��������С�����ݲ�����̶�����ɢ��ֵ�İ�ȫ����ɢ�к�����
public class MD5Utils {
    /**
	 * ʹ��md5���㷨���м���
	 */
	public static String md5(String plainText) {
		byte[] secretBytes = null;
		try {
			//����ʵ��ָ��ժҪ�㷨��MessageDigest���� 
			secretBytes = MessageDigest.getInstance("md5").digest(
					plainText.getBytes());
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("û��md5����㷨��");
		}
		String md5code = new BigInteger(1, secretBytes).toString(16);
		for (int i = 0; i < 32 - md5code.length(); i++) {
			md5code = "0" + md5code;
		}
		return md5code;
	}
}
