package com.MindView.net;
class B{}
public class NewVaraArgs {
//	java SE5֮�����ʽ���ɱ�������������ʽ
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
//	��֮ǰ�����Ա�
	printArray(new Object[]{"One",new Integer(1)});
	printArray();

	}
}
