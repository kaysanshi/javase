package com.java1995;

public class Average <T extends Number>{
//	这是定义类时直接定义了
//抽象类Number是表示数字值可转换为基本数据类型平台类的超类
//	泛型类型的边界的上限；好处:类型安全，可以让类型有进一步的操作，方法实现
//	现在T当一个数组类型使用

	T[] t;
	Average(T[] obj){
		this.t=obj;
	}
	double sum=0;
	public int getEverage(){
		for(int i=0;i<t.length;i++){
//		public class Everage <T>{这样定义时他不能实现数字的装换
//		类型边界就是解决的是自装换
		sum+=t[i].doubleValue();
		}
		return (int) (sum/t.length);
	}
	//通配符?可以接受任何的类型
//	/比较两对象是否相同可以用来比较不同类型的参数,通配符;
	public boolean equalsM(Average<?> obj){
		if(this.getEverage()==(obj.getEverage())){
			return true;
		}else{
			return false;
		}
		
	}
	
	
	public static void main(String[] args) {
		Integer[] i={1,2,3,5,6};
		Average<Integer> e=new Average<Integer>(i);
		//这里也可以是number类型
		System.out.println(e.getEverage());
//		
		Integer[] i2={2,3,4,5};
		Average<Integer> e1=new Average<Integer>(i2);
		System.out.println(e1.equalsM(e));
		//double
		Double[] d1={2.0,3.0,5.0,4.0};
		Average<Double> e2=new Average<Double>(d1);
//		e2.equalsM(e1)试图用double的平均值与int的比较会出错应该使用通配符来解决
		boolean flag=e1.equalsM(e2);
		System.out.println(flag);
		
	}
}
