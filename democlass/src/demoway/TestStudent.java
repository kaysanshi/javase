package demoway;
/*
 * 对象的使用及如何创建
 */

public class TestStudent {
	public static void main(String[] args) {
		Student p=new Student();//创建对象，p是引用；在栈内存用来操作堆内存的对象；
//第二种创建对象方法;Student p;
//p=new Student();
		p.name="三石磊";
		p.sex="男";
		p.age=20;
		System.out.println(p.name);
		System.out.println(p.sex);
		System.out.println(p.age);
		p.study();
		p.play();
		p.think();
		p.sleep();
	}

}
