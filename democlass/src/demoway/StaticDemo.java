package demoway;

public class StaticDemo {
	static int x=0;
//	��̬����
	static{
		x=100;
	}
//	������
	StaticDemo(){
		System.out.println(x);
	}
	public static void main(String[] args) {
//		�����ĸ���ִ��static 
		new StaticDemo();
		
	}
}
