package com.zcib;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Test {
	//静态方法：
	public static void myprint(){
		System.out.println("请确认你要执行的任务：");
		System.out.println("------------------------");
		System.out.println("- 新增请输入：1         -");
		System.out.println("- 查询请输入:2          -");
		System.out.println("- 删除请输入：3         -");
		System.out.println("- 查找请输入：4         -");
		System.out.println("- 修改信息输入：5       -");
		System.out.println("- 退出请输入：0         -");
		System.out.println("-----------------------");
	}
	public static void main(String[] args) {
		System.out.println("欢迎来的查巡系统成绩：请你设置你的密码：");
		Scanner scan=new Scanner(System.in);
			ArrayList<Student> list=new ArrayList<Student>();
			StuManager manager=new StuManager(list);
			Student stu=new Student();
			String password=scan.nextLine();
			stu.setPassword(password);
			System.out.println("请输入你的密码:");
			String Mima=scan.nextLine();
			stu.getMima(Mima);
		if(stu.getMima(Mima).equals(password)){
			Test.myprint();
			
			Student stu1=new Student("201601014224","刘伟","男",20,"河南","信息技术系",299,"大一","c语言", 95 );
			Student stu2=new Student("201601014222","李磊","男",22,"北京","网络工程",292,"大二","Java", 98 );
			Student stu3=new Student("201601010001","李华","女",20,"广州","经济管理学",295,"大三","经济学",85);
			Student stu4=new Student("201601010002","李彬","男",22,"新疆","物联网工程",292,"大二","计算机基础", 95 );
			Student stu5=new Student("201601010003","赵宇","女",23,"上海","管理学",295,"大三","管理学",85);
//			添加学生
			
			manager.getList().add(stu1);
			manager.getList().add(stu2);
			manager.getList().add(stu3);
			manager.getList().add(stu4);
			manager.getList().add(stu5);
			
			int m=scan.nextInt();
			while(true){
			if(m==1){
				Student stu11=new Student();
//				System.out.println("请输入添加学生的个数：");
				System.out.println("请输入你的学号：2016开头");
				String number=scan.next();
				stu11.setNumber(number);
				System.out.println("请输入姓名");
				String name=scan.next();
				stu11.setName(name);
				System.out.println("请输入性别");
				String sex=scan.next();
				if(sex.equals("男")||sex.equals("女")){
					stu11.setSex(sex);
				}else{
					System.out.println("你输入的不合法");
				}
				System.out.println("请输入你的年龄：");
				int age=scan.nextInt();
				stu11.setAge(age);
				System.out.println("请输入你的地址:");
				String address=scan.next();
				stu11.setAddress(address);
				System.out.println("请输入系别：");
				String department=scan.next();
				stu11.setDepartment(department);
				System.out.println("请输入年级：");
				String grade =scan.next();
				stu11.setGrade(grade);
				System.out.println("请输入总成绩：");
				double score=scan.nextDouble();
				stu11.setScore(score);
			System.out.println("请输入专业课科目名");
			String subject=scan.next();
			stu11.getSubject(subject);
			System.out.println("请输入科目："+stu11.getSubject(subject)+"的成绩");
			float score3=scan.nextFloat();
			stu11.getsubscore(score3);
			System.out.println(stu11.getSubject(subject)+stu11.getsubscore(score3));
				manager.getList().add(stu11);
				System.out.print(list);
				System.out.println("请输入你要执行的序号："); 
				m=scan.nextInt();
			}
		if(m==2){
		System.out.println("学生信息列表如下：");
		System.out.println(list);
		System.out.println("请输入你要执行的序号："); 
			m=scan.nextInt();
		}
//		删除
		if(m==3){
		manager.Delete(list);
		System.out.println("请输入你要执行的序号："); 
		 	m=scan.nextInt();
		}
//		查找
		if(m==4){
		System.out.println("按照学号搜索输入：1.姓名搜索按 2：");
		int s=scan.nextInt();
		if(s==1){
		manager.Search(list);}
		if(s==2){
			System.out.println("搜索结果为：");
			manager.SearchName(list);
		}
			System.out.println("请输入你要执行的序号："); 
			m=scan.nextInt();
		}
//		修改
		if(m==5){
			manager.Modify(list);
			System.out.println("学生信息如下：");
			System.out.println(list);
			System.out.println("请输入你要执行的序号："); 
			m=scan.nextInt();
		}
		if(m==0){
			System.out.println("你已退出");
			System.exit(0);
		}
			}
		}else{
			System.out.println("你的密码不正确！！！请重新输入密码：");
		}
	}

}
