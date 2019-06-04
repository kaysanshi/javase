package demo3;
import java.util.Scanner;
public class student {
	/*
	 * 用来进行区别public private protect
	 */
public static void main(String[] args) {
	testclass p=new testclass();
	p.eat();//默认情况在一个包中可以掉用
	p.fly();
	System.out.println("请输入姓名name:");
	Scanner scan=new Scanner(System.in);
	String name=scan.next();
	scan.close();
	//p.sex();private的只能在本类中可见； 
	//String fly=p.fly;
	System.out.println(name+p.fly ());
//	String type="西瓜";

	//我如何才能掉用class类中的public void eat();含参函数;
	testclass p1=new testclass();
	p1.type ="西瓜";
	p1.num=3;
	System.out.println("正在吃"+p1.type+"吃了"+p1.num+"个");
	}
}
