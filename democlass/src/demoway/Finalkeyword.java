package demoway;

public class Finalkeyword {
//	final 用来修饰恒定不变的属性，变量是不能进行改变的；
//	变量名建议用大写，如果重新赋值会进行报错

		public static final String SKIN_COLOR="黄色";
		public static final String EYE_COLOR="黑色";
		public static int EYE=2;//不为final修饰的变量；它是一个静态变量
	
	public static void main(String[] args){
		System.out.println(SKIN_COLOR);
		System.out.println(EYE_COLOR);
//		以下是我试图改变下final修饰的变量编译器会报错；
//		Finalkeyword.SKIN_COLOR="白色";//此处改变会运行错误；
		System.out.println(SKIN_COLOR);
		
//		我如改变一下eye的修饰不为final那么eye就是一个静态变量然后我试图改变一下他的值
//		尝试用new出一个对象改变，程序会运行但是不严谨没按Java中的改变静态变量的规则；编译报错
		Finalkeyword p=new Finalkeyword();
		p.EYE =3;
		System.out.println(p.EYE);
//		以下方法是我通过静态变量改变值得方法进行改进
		Finalkeyword.EYE =3;
		System.out.println(Finalkeyword.EYE);
		Finalkeyword.EYE=4;
		System.out.println(Finalkeyword.EYE);
		
		
	}
}
