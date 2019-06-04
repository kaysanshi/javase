package demoway;

public class People {
//构造方法；
	String name;
	String sex;
	int age;
//	其无参的方法：
	People(){
		
	};
//	people(){系统内部操作 其方法的名字和类的名字是一致的 ，并将变量初始化；
//	String name=null;
//	String sex=null;
//	int age=0;}
/**
 * 有参的构造方法需要进行传值；
 * @param args
 */
	People(String name,String sex,int age){
		this.name=name;
		this.sex=sex;
		this.age=age;
	}
//也可利用方法的重载；即利用构造某一个方法；其也需要进行传值；
	People(String name){
		this.name=name;
	}
	People(String sex,int age){
		this.sex=sex;
		this.age=age;
	}
	public static void main(String[] args) {
//		这里的p是在栈内存中的一个引用；用来操作堆内存中的对象people;
//		并且把p的地指向堆内存的对象地址
		People p=new People();//当使用这个无参构造方法时系统会自动用下面的方法
		System.out.println(p.name);
		System.out.println(p.sex);
		System.out.println(p.age);
		People p1=new People("芦凯磊","男",20);//有参方法进行传值；
		System.out.println(p1.name+","+p1.sex+","+p1.age);
		People p2=new People("san");
		People p3=new People("男",20);
		System.out.println(p2.name);
		System.out.println(p3.sex+","+p3.age);
	}
}
