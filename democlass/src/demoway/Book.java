package demoway;

public class Book {
	String name;
	int date;
	String author;
//	有参中的传值的方法；非静态类中；
//	静态类中不能用this传值，可以用 return进行返回值，和直接输出；
	Book (String name){
		this.name=name;
	}
	Book(int date){
		this.date=date;
	}
	
	public static void main(String[] args){
	Book p=new Book("java");
	System.out.println(p.name);
	Book p1=new Book(2000);
	System.out.println(p1.date);
	}
}
