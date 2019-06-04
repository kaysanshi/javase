package demoway;

public class Finalway {
//	若一个类是final修饰的这个类是不能被继承得；
	class Tree{
		public final void develop(){
			System.out.println("小树正在生长");
		}
	}
//	继承树的方法在进行增加语句；类
		class Oak extends Tree{
			Oak(){
				System.out.println("橡树Java的前称");
			}
//			在此想要重写一下树的方法时不能通过；说明final修饰的不能重写(即不能继承)但能重载
//			public void develop(){};
			public void develop(String name){
				System.out.println(name );
			}
		}
//		final类的使用
		final class People{
			
		}
//		我要继承people时编译器会报错说明final不能做为任何类的父类类中的方法会全部定义为final类型；
//		class Techer extends People{}
//	主方法如何调用；
	public static void main(String[]args){
		
		
	}
	
}

