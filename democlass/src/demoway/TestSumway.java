package demoway;

public class TestSumway {
	public static void main(String[] args){
//		ͨ���Ǿ�̬����ʱ��Ҫ��new��һ������ֵ
		SumWay p=new SumWay();
		int sum1=p.sum1(3,4);
		System.out.println(sum1);
//		ͨ����̬static����ʱ����ֱ�Ӹ���:����.�������� �����������ã�
		double sum2=SumWay.sum(3.5, 5.5);
		System.out.println(sum2);
		int sum3=SumWay.sum(2, 5);
		System.out.println(sum3);
		int sum4=SumWay.sum(2,4,6);
		System.out.println(sum4);
	}

}
