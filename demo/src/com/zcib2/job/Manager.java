package com.zcib2.job;

import java.util.ArrayList;
import java.util.TreeMap;


//分别创建对象实例化;
public class Manager {
	ArrayList<Student> list=null;
	ArrayList<Course> list1=null;
	ArrayList<Grade> list2=null;
	public Manager(){
		Student stu=new Student("s001","张三", "02");
		Student stu1=new Student("s002","张二", "04");
		Student stu2=new Student("s003","张一", "03");
		Student stu3=new Student("s004","张日无", "01");
		Course course=new Course("k001", "物理");
		Course course1=new Course("k002", "化学");
		Course course2=new Course("k003", "Java");
		Course course3=new Course("k004", "c语言");
		Grade grade=new Grade("s001", "k001", 90);
		Grade grade1=new Grade("s002", "k002", 98);
		Grade grade2=new Grade("s003", "k003", 88);
		Grade grade3=new Grade("s004", "k004", 99);
		
		
		Student stu11=new Student("s005","张si", "02");
		Student stu12=new Student("s006","张5", "04");
		Course course11=new Course("k001", "物理");
		Course course12=new Course("k002", "化学");
		Grade grade11=new Grade("s005", "k001", 70);
		Grade grade12=new Grade("s006", "k002", 88);
		 list=new ArrayList<Student>();
		 list1=new ArrayList<Course>();
		 //分数
		 list2=new ArrayList<Grade>();
		list.add(stu);
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		list.add(stu11);
		list.add(stu12);
		
		list1.add(course);
		list1.add(course1);
		list1.add(course2);
		list1.add(course3);
		list1.add(course11);
		list1.add(course12);
		
		list2.add(grade);
		list2.add(grade1);
		list2.add(grade2);
		list2.add(grade3);
		list2.add(grade11);
		list2.add(grade12);
	}
	//外层循环中嵌套才会导致循环的次数比上次的增加的更多;
	//查看
	public void print(){
		System.out.println("学号"+"\t"+"姓名"+"\t"+"班级"+"\t"+"课程编号"+"\t"+"课程名称"+"\t"+"成绩");
		for(Grade g:list2){
			for(Student s:list){
				for(Course c:list1){
					if(g.getsId().equals(s.getStuId())){
					if(g.getcId().equals(c.getCourseId())){	
							System.out.println(s.getStuId()+"\t"+s.getStuName()+"\t"+s.getStuclass()+"\t"+
							g.getcId()+"\t"+c.getCourseName()+"\t"+g.getScore());
						}
					}
				}
			
			}
		}	
	}
	//计算成绩总分的平均值:
	public void everage(){
		double sum=0;
		int count=0;
		for(int i=0;i<list1.size();i++){
		for(int j=0;j<list2.size();j++){
			if (list2.get(j).getcId().equals(list1.get(i).getCourseId())){
				count++;
				//分数
				sum+=list2.get(i).getScore();
			}	
		}
		System.out.println(sum/count);
	}
	}

	public static void main(String[] args) {
		
		Manager m=new Manager();
		m.print();
		System.out.println("所有成绩的总分的平均分");
		m.everage();
		
	}
	

}
