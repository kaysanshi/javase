package demo3;
import java.util.Scanner;
public class TestBook {

	public static void main(String[] args) {
		Book p1=new Book();
		p1.name="Java";
		p1.author ="δ֪";
		p1.type="����";
		p1.time =2000;
		p1.price=3505;
		System.out.print("�Ȿ��Ĺ�����£�");
		System.out.println("����:"+p1.getname());
		System.out.println("����:"+p1.getauthor());
		System.out.println("����:"+p1.gettype());
		System.out.println("����ʱ��:"+p1.gettime());
		System.out.println("�۸�:"+p1.getprice());
//	����ķ������ʵ��
		System.out.println("���������������Ϣ��");
		Scanner scan=new Scanner(System.in);
		Book p=new Book();
		System.out.println("������������");
		String name=scan.nextLine();
		System.out.println("���������ߣ�");
		String author=scan.nextLine();
		System.out.println("������������ͣ�");
		String type=scan.nextLine();
		System.out.println("���������ʱ�䣺");
		int time=scan.nextInt();
		System.out.println("������۸�");
		double price=scan.nextDouble();
		scan.close();
		p.book(name, type, author, time, price);
		p.name=name;
		p.author =author;
		p.type=type;
		p.time =time;
		p.price=price;
		System.out.print("�Ȿ��Ĺ�����£�");
		System.out.println("����:"+p.getname());
		System.out.println("����:"+p.getauthor());
		System.out.println("����:"+p.gettype());
		System.out.println("����ʱ��:"+p.gettime());
		System.out.println("�۸�:"+p.getprice());

		
	}

}
