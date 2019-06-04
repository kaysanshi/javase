package demoway;

public class SumWay {
	public int sum1(int a,int b){
		return a+b;
	}
//	以下进行方法的重载；
//	其中方法的重载是一个类中有多个同名的方法，但是方法中的参数应不相同
//	判断时可以直接根据方法名字来判断；
//	若调用时只需根据参数的类型，很参数的个数即可以调用
	public static double sum(double a,double b){
		return a+b;
	}
	public static int sum(int c,int d){
		return c+d;
	}
	public static int sum(int a,int b, int c){
		return a+b+c;
		
	}
}
