package com.MindView.net;
class B{}
public class NewVaraArgs {
//	java SE5之后的形式；可变参数的数组的形式
	static void printArray(Object... args){
		for(Object obj:args){
			System.out.print(obj+" ");
			System.out.println();
		}
	}
	public static void main(String[] args) {
		printArray(
		new Integer(47),new Float(2.01),new Double(11.11)
		);
		printArray("one");
		printArray(new B());
//	与之前的做对比
	printArray(new Object[]{"One",new Integer(1)});
	printArray();

	}
}
