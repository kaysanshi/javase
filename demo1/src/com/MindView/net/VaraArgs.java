package com.MindView.net;
	class A{}
public class VaraArgs {
//	�ɱ�����б�
	static void printArray(Object[] args){
		for(Object obj:args){
			System.out.print(obj+" ");
			System.out.println();
		}
	}
	public static void main(String[] args) {
		printArray(new Object[]{
				new Integer(47),new Float(2.01),new Double(11.11)
		});
		printArray(new Object[]{"one"});
		printArray(new Object[]{new A()});

	}

}
