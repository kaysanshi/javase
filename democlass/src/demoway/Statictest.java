package demoway;
/*
 * ���ڲ��Ծ�̬��������ͨ������
 */
public class Statictest {
	int commonint=0;//��ͨ�ı���
	static int staticint=0;//��̬�ı���
	Statictest(int x){
		this.commonint =x;
	}
	public static void  main(String[] args){
		Statictest p=new Statictest(1);
		Statictest p1=new Statictest(2);
		System.out.println(p.commonint );
		System.out.println(p1.commonint );
//�ı侲̬�������������ĸ�������ʾ�̬���������䣻
		p.staticint =3;
		System.out.println(p.staticint );
		System.out.println(p1.staticint );
//		�ٴθı侲̬����
		p1.staticint =12;
		System.out.println(p.staticint );
		System.out.println(p1.staticint );

	}
}
