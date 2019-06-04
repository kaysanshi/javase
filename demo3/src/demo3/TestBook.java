package demo3;
import java.util.Scanner;
public class TestBook {

	public static void main(String[] args) {
		Book p1=new Book();
		p1.name="Java";
		p1.author ="未知";
		p1.type="文献";
		p1.time =2000;
		p1.price=3505;
		System.out.print("这本书的规格如下：");
		System.out.println("书名:"+p1.getname());
		System.out.println("作者:"+p1.getauthor());
		System.out.println("类型:"+p1.gettype());
		System.out.println("出版时间:"+p1.gettime());
		System.out.println("价格:"+p1.getprice());
//	输入的方法如何实现
		System.out.println("请依次输入各个信息：");
		Scanner scan=new Scanner(System.in);
		Book p=new Book();
		System.out.println("请输入姓名：");
		String name=scan.nextLine();
		System.out.println("请输入作者：");
		String author=scan.nextLine();
		System.out.println("请输入书的类型：");
		String type=scan.nextLine();
		System.out.println("请输入出版时间：");
		int time=scan.nextInt();
		System.out.println("请输入价格：");
		double price=scan.nextDouble();
		scan.close();
		p.book(name, type, author, time, price);
		p.name=name;
		p.author =author;
		p.type=type;
		p.time =time;
		p.price=price;
		System.out.print("这本书的规格如下：");
		System.out.println("书名:"+p.getname());
		System.out.println("作者:"+p.getauthor());
		System.out.println("类型:"+p.gettype());
		System.out.println("出版时间:"+p.gettime());
		System.out.println("价格:"+p.getprice());

		
	}

}
