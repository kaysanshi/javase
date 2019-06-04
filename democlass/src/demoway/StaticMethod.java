package demoway;

public class StaticMethod {
//在这个类中调用自己写静态方法；
	
	public static void main(String[] args) {
		// 用来测试静态方法1.静态方法不可以访问非静态变量2.非静态方法可以访问静态方法；
	//静态方法或属性在类加载时产生的。非静态方法是在new中产生的
//	调用静态方法的格式：：类名.静态方法名(参数)；
		MyMethod.printInt(5);
		MyMethod.printString("hello xiao na ");
	}
}
//创建一个类，在这个类中写静态方法
//这个类中只是写方法。并有以上的主函数调用；
		class MyMethod{
			static void printString(String i){
				System.out.println(i);
			}
			static void printInt(int x){
				System.out.println(x);
			}
	}

