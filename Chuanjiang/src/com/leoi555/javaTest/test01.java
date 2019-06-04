package com.leoi555.javaTest;

public class test01 {

	/**
	 * 
		1.简述对JVM,JRE,JDK的理解。
			-jvm,全称虚拟机，jvm是整个java实现跨平台的 最核心的部分，
			所有的java程序会首先被编译为.class的类文件，这种类文件可 以在虚拟机上执行，
			也就是说class并不直接与机器的操作系统相对应，而是经过虚拟机间接与操作系统交互，
			由虚拟机将程序解 释给本地系统执行。
			-jre是指java运行环境。光有JVM还不能成功执行class文件，
			因为在解释class的时候JVM需要调用解释所需要的类库lib。
			-jdk是java开发工具包，jdk中往往包含jre
		2.简述环境变量path和classpath的作用?
			-path，指定命令搜索路径 在命令行下面执行命令如javac编译java程序时，它会到PATH变量所指定的路径中查找看是否能找到相应的命令程序。
					我们需要把jdk安装目录下的bin目录增加到现有的PATH变量中，bin目录中包含经常要用到的可执行文件如javac/java/javadoc等待，设置好PATH变量后，就可以在任何目录下执行javac/java等工具了。
			-classpath，指定类搜索路径 包含了一个或多个目录，它们作为一种特殊的“根”使用，从这里展开对.class 文件的搜索。从那个根开始，解释器会寻找包名，
						并将每个点号（句点）替换成一个斜杠，从而生成从CLASSPATH 根开始的一个路径名
						如你引入了import Java util *,这个包中编译器要去寻找这个类在哪个地方，设置的clsspath设置了jdk的目录就会去寻找这个目录
		3.独立编写hello world程序，编译并运行。
			-见代码xx行
		4.java语言是否区分大小写? javacjava的作用?
			-java语言区分大小写
			-javac:编译Java文件为class类文件
			-java：执行class文件---》run
		5.简述main方法(是什么，什么特点，怎么用，何时用? )
			-是类中的一段代码，可以让程序独立运行
			-写在类中，格式固定， 一个类中只能有一个main方法，main方法可以让类单独运行
		
	 */
	public static void main(String[] args) {
		System.out.println("**********************************************");
		System.out.println("3.独立编写hello world程序，编译并运行");
		System.out.println("结果：");
		System.out.println("hello world!");
	}

}
