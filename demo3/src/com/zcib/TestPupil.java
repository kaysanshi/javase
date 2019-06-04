package com.zcib;

public class TestPupil {

	public static void main(String[] args) {
		Pupil1 p=new Pupil1();
		p.Name("liasge");
		System.out.println(p.Name("liasge"));
		System.out.println("所在班级："+Pupil.Class);
		p.eat();
		p.sex();
		p.study();
		
//		父接口自动把定义的变量生成Static变量
//		在此class是静态变量；用：类名.参数  访问；
//		public static finall class;现试图改变class的值；会报错；
//		p.Class=2088;The final field Pupil.Class cannot be assigned
//		System.out.println(p.Class);
		System.out.println("调用父接口中的变量值得实现："+Pupil.name+","+Human.name);

	}

}
