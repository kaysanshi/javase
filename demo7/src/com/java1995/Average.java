package com.java1995;

public class Average <T extends Number>{
//	���Ƕ�����ʱֱ�Ӷ�����
//������Number�Ǳ�ʾ����ֵ��ת��Ϊ������������ƽ̨��ĳ���
//	�������͵ı߽�����ޣ��ô�:���Ͱ�ȫ�������������н�һ���Ĳ���������ʵ��
//	����T��һ����������ʹ��

	T[] t;
	Average(T[] obj){
		this.t=obj;
	}
	double sum=0;
	public int getEverage(){
		for(int i=0;i<t.length;i++){
//		public class Everage <T>{��������ʱ������ʵ�����ֵ�װ��
//		���ͱ߽���ǽ��������װ��
		sum+=t[i].doubleValue();
		}
		return (int) (sum/t.length);
	}
	//ͨ���?���Խ����κε�����
//	/�Ƚ��������Ƿ���ͬ���������Ƚϲ�ͬ���͵Ĳ���,ͨ���;
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
		//����Ҳ������number����
		System.out.println(e.getEverage());
//		
		Integer[] i2={2,3,4,5};
		Average<Integer> e1=new Average<Integer>(i2);
		System.out.println(e1.equalsM(e));
		//double
		Double[] d1={2.0,3.0,5.0,4.0};
		Average<Double> e2=new Average<Double>(d1);
//		e2.equalsM(e1)��ͼ��double��ƽ��ֵ��int�ıȽϻ����Ӧ��ʹ��ͨ��������
		boolean flag=e1.equalsM(e2);
		System.out.println(flag);
		
	}
}
