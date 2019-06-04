package demo3;

public class Book {
//定义一个book类来进行自定义类的初始化和测试；
	String name;
	int time;
	String author;
	double price;
	String type;
	public void book(String name,String type,String author,
						int time,double price){
		this.name=name;
		this.author =author;
		this.type =type;
		this.time =time;
		this.price =price;	
	}
	public String getname(){
		return name;
	}
	public String getauthor(){
		return author;
	}
	public String gettype(){
		return type;
	}
	public double getprice(){
		return price;
	}
	public int gettime(){
		return time;
	}
}
