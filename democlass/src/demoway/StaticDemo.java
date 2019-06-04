package demoway;

public class StaticDemo {
	static int x=0;
//	静态方法
	static{
		x=100;
	}
//	构造器
	StaticDemo(){
		System.out.println(x);
	}
	public static void main(String[] args) {
//		测试哪个先执行static 
		new StaticDemo();
		
	}
}
