package demoway;
/*
 * 对象类型的参数传递 Java中有基本类型传递，用的时候直接使用；
 * 引用数据类型时，操作的引用指向的堆内存的对象；
 */
public class TestAnnamal {
//	
	public static void main(String[] args) {
		Annamal p=new Annamal();
		p.name="uu";
		p.skin="huang";
		p.type="man";
		Annamal.println(p);//静态类型static的 方法的调用：类名.方法名(引用);
	}

}
