package demo3;
import java.util.Scanner;
public class student {
	/*
	 * ������������public private protect
	 */
public static void main(String[] args) {
	testclass p=new testclass();
	p.eat();//Ĭ�������һ�����п��Ե���
	p.fly();
	System.out.println("����������name:");
	Scanner scan=new Scanner(System.in);
	String name=scan.next();
	scan.close();
	//p.sex();private��ֻ���ڱ����пɼ��� 
	//String fly=p.fly;
	System.out.println(name+p.fly ());
//	String type="����";

	//����β��ܵ���class���е�public void eat();���κ���;
	testclass p1=new testclass();
	p1.type ="����";
	p1.num=3;
	System.out.println("���ڳ�"+p1.type+"����"+p1.num+"��");
	}
}
