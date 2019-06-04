package demoway;
/*
 * 用于测试静态变量和普通变量；
 */
public class Statictest {
	int commonint=0;//普通的变量
	static int staticint=0;//静态的变量
	Statictest(int x){
		this.commonint =x;
	}
	public static void  main(String[] args){
		Statictest p=new Statictest(1);
		Statictest p1=new Statictest(2);
		System.out.println(p.commonint );
		System.out.println(p1.commonint );
//改变静态变量后无论用哪个对象访问静态变量都不变；
		p.staticint =3;
		System.out.println(p.staticint );
		System.out.println(p1.staticint );
//		再次改变静态变量
		p1.staticint =12;
		System.out.println(p.staticint );
		System.out.println(p1.staticint );

	}
}
