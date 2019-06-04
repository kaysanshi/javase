package com.java1995;
/**
 * 静态final是不可以改变的不可以二次的赋值；final就是不可变的。
 * 当数据是基本类型时，意味着这是一个永不改变的编译时常量，一个在运行时被初始化的值，你不希望它改变。
 *当数据是引用类型时，用static和final修饰表示这是只占据一块不能改变的内存空间
 * 静态的可以进行赋值
 * @author Kay三石
 *@date 2018年12月24日
 */
public class StringTest {
	public static String string="ANC";
	public static int str=122;
	public final static String string2="111";
	public static void main(String[] args) {
		str=StringTest.str+1;//在静态中添加  添加final类型的肯定都是错误的。
		System.out.println(str);
		string=StringTest.string+"adb";//在静态中追加
		System.out.println(string);
		String string="123";
		System.out.println(string);//输出的为123
		string=StringTest.string+"adc";
		System.out.println(string);
		//报错：final是不可变的
//		string2=StringTest.string2+"222";
//		System.out.println(string2);
		/**
		 * 字符串的基本操作：
		 * String类代表字符串。 Java程序中的所有字符串文字（例如"abc" ）都被实现为此类的实例。
		字符串不变; 它们的值在创建后不能被更改。 字符串缓冲区支持可变字符串。
		 因为String对象是不可变的，它们可以被共享。 例如：
	     String str = "abc";相当于：
	     char data[] = {'a', 'b', 'c'};
	     String str = new String(data);
		 */
		String str1 = "Lance";//在常量池中申请的，就是堆中保存值栈中保存变量然后引用指向堆。
        String str2 = new String("Lance");//这个是无论常量池中有没有都会在堆中进行新建出一个实例，
        String str3 = str2; //引用传递，str3直接指向st2的堆内存地址
        String str4 = "Lance";
        /**
         *  ==:
         * 基本数据类型：比较的是基本数据类型的值是否相同
         * 引用数据类型：比较的是引用数据类型的地址值是否相同
         * 所以在这里的话：String类对象==比较，比较的是地址，而不是内容
         */
         System.out.println(str1==str2);//false
         System.out.println(str1==str3);//false
         System.out.println(str3==str2);//true
         System.out.println(str1==str4);//true
		
		
	}
}
