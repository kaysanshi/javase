package com.java1995;

public class Gen<T> {//T可以是对象类
//泛型类：泛型是将类型参数化
//	构造方法
	T obj;
	Gen(T obj){
		this.obj=obj;	
	}
	
	public T getObj(){
		return obj;
	}
	public void Show(){
		System.out.println("类型信息："+obj.getClass().getName());
	}
		/*
		 * 泛型的使用测试：如果将不同类型的对象传入时会报错
		 * 
		 */
			public static void main(String[] args) {
				Integer i1= new Integer(1);
				Gen<Integer> g1=new Gen<Integer>(i1);
				System.out.println(g1.getObj());
				g1.Show();
				String s1=new String("java genericity");
				Gen<String> s=new Gen<String>(s1);
				System.out.println(s.getObj());
				s.Show();
			}
}
