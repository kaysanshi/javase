package com.java1995;
/**
 * ��̬final�ǲ����Ըı�Ĳ����Զ��εĸ�ֵ��final���ǲ��ɱ�ġ�
 * �������ǻ�������ʱ����ζ������һ�������ı�ı���ʱ������һ��������ʱ����ʼ����ֵ���㲻ϣ�����ı䡣
 *����������������ʱ����static��final���α�ʾ����ֻռ��һ�鲻�ܸı���ڴ�ռ�
 * ��̬�Ŀ��Խ��и�ֵ
 * @author Kay��ʯ
 *@date 2018��12��24��
 */
public class StringTest {
	public static String string="ANC";
	public static int str=122;
	public final static String string2="111";
	public static void main(String[] args) {
		str=StringTest.str+1;//�ھ�̬�����  ���final���͵Ŀ϶����Ǵ���ġ�
		System.out.println(str);
		string=StringTest.string+"adb";//�ھ�̬��׷��
		System.out.println(string);
		String string="123";
		System.out.println(string);//�����Ϊ123
		string=StringTest.string+"adc";
		System.out.println(string);
		//����final�ǲ��ɱ��
//		string2=StringTest.string2+"222";
//		System.out.println(string2);
		/**
		 * �ַ����Ļ���������
		 * String������ַ����� Java�����е������ַ������֣�����"abc" ������ʵ��Ϊ�����ʵ����
		�ַ�������; ���ǵ�ֵ�ڴ������ܱ����ġ� �ַ���������֧�ֿɱ��ַ�����
		 ��ΪString�����ǲ��ɱ�ģ����ǿ��Ա����� ���磺
	     String str = "abc";�൱�ڣ�
	     char data[] = {'a', 'b', 'c'};
	     String str = new String(data);
		 */
		String str1 = "Lance";//�ڳ�����������ģ����Ƕ��б���ֵջ�б������Ȼ������ָ��ѡ�
        String str2 = new String("Lance");//��������۳���������û�ж����ڶ��н����½���һ��ʵ����
        String str3 = str2; //���ô��ݣ�str3ֱ��ָ��st2�Ķ��ڴ��ַ
        String str4 = "Lance";
        /**
         *  ==:
         * �����������ͣ��Ƚϵ��ǻ����������͵�ֵ�Ƿ���ͬ
         * �����������ͣ��Ƚϵ��������������͵ĵ�ֵַ�Ƿ���ͬ
         * ����������Ļ���String�����==�Ƚϣ��Ƚϵ��ǵ�ַ������������
         */
         System.out.println(str1==str2);//false
         System.out.println(str1==str3);//false
         System.out.println(str3==str2);//true
         System.out.println(str1==str4);//true
		
		
	}
}
