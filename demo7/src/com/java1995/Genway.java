package com.java1995;

public class Genway {
//	定义泛型方法格式：
//	修饰符  方法类型 <参数类型列表> 返回类型 方法名（参数类列表）
	public static <T> boolean compare(T[] ts,T t){
		//初始时设置
		boolean compare=false;
		for(int i=0;i<ts.length;i++){
			//遍历的时候要给元素的每一个值比较ts[i];
			if(t.equals(ts[i])){
				compare=true;
				break;
			}
		}
		return compare;
	}
	//泛型方法
	
	/*
	 * 泛型的测试在掉用泛型方法时是和其他方法一样的
	 */
	public static void main(String[] args) {
		Integer[] i={1,2,3,5,6};
//	这是在类的定义时声明的泛型时这样处理；
//	GenWay<Integer> s=new Genway<Integer>(i);
		boolean  s=compare( i,6);
		if(s){
			System.out.println("6在这个数组i中");
		}else{
			System.out.println("不在数组i中");
		}
		String[] s1={"hello" ,"you" ,"are very ","beautiful"};
		boolean ss=compare(s1,"beautiful");
		if(ss){
			System.out.println("beautiful在这个数组s1中");
		}else{
			System.out.println("beautiful不在数组s1中");
		}
	}
}
