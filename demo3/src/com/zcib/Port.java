package com.zcib;

public interface Port {
//	以下用来测试接口中的方法的修饰符
//	其实所有方法都是public abstract 抽象类型的；
	void println();
	public void println1();
	abstract void println2();
	public abstract void println3();
	abstract public void println4();
//	protect void println4();出错说明修饰符不可以为受保护的；
//	private abstract void println5();不可以为私有的；

}
