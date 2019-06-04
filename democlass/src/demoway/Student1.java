package demoway;

public class Student1 {
//	访问静态变量
//	用；；类名.静态变量
	int id=0;
	static int num =0;
//一个构造器；
	Student1(int id){
		this.id=id;
		num++;
	}
	public static void main(String[] args){
		Student1 p=new Student1(10001);
		Student1 p1=new Student1(10002);
		Student1 p2=new Student1(10003);
		Student1 p3=new Student1(10004);
		System.out.println(p.id );
		System.out.println(p1.id );
		System.out.println(p2.id );
		System.out.println(p3.id );
//		在此用：：类名.静态变量      来访问静态变量；
		System.out.println("学生数量："+Student1.num );
		
	}

}
