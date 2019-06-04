package demoway;

public class TestSumway {
	public static void main(String[] args){
//		通过非静态方法时需要用new出一个对象传值
		SumWay p=new SumWay();
		int sum1=p.sum1(3,4);
		System.out.println(sum1);
//		通过静态static方法时可以直接根据:类名.方法名（ 参数）来调用；
		double sum2=SumWay.sum(3.5, 5.5);
		System.out.println(sum2);
		int sum3=SumWay.sum(2, 5);
		System.out.println(sum3);
		int sum4=SumWay.sum(2,4,6);
		System.out.println(sum4);
	}

}
