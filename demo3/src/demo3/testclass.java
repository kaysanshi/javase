package demo3;

public class testclass {
//测试人这个类
//	人类中的属性
	String name;
    /*private*/ String sex;
	int age;
	String type;
	int num;
//	非静态无参的方法实例，及应用；
	void eat(){
		System.out.println("正在吃饭");
	}
	void tea(){
		System.out.println("正在喝茶");
	}
	public String run(){
		return "跑步";
	}
	public String fly(){
		return "正在飞";
	}
	public void eating(String type,int num){
		this.type=type;
		this.num=num;
//		System.out.println("正在吃"+type+",吃了"+num+"个");
	}
}
