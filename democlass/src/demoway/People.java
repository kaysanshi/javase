package demoway;

public class People {
//���췽����
	String name;
	String sex;
	int age;
//	���޲εķ�����
	People(){
		
	};
//	people(){ϵͳ�ڲ����� �䷽�������ֺ����������һ�µ� ������������ʼ����
//	String name=null;
//	String sex=null;
//	int age=0;}
/**
 * �вεĹ��췽����Ҫ���д�ֵ��
 * @param args
 */
	People(String name,String sex,int age){
		this.name=name;
		this.sex=sex;
		this.age=age;
	}
//Ҳ�����÷��������أ������ù���ĳһ����������Ҳ��Ҫ���д�ֵ��
	People(String name){
		this.name=name;
	}
	People(String sex,int age){
		this.sex=sex;
		this.age=age;
	}
	public static void main(String[] args) {
//		�����p����ջ�ڴ��е�һ�����ã������������ڴ��еĶ���people;
//		���Ұ�p�ĵ�ָ����ڴ�Ķ����ַ
		People p=new People();//��ʹ������޲ι��췽��ʱϵͳ���Զ�������ķ���
		System.out.println(p.name);
		System.out.println(p.sex);
		System.out.println(p.age);
		People p1=new People("«����","��",20);//�вη������д�ֵ��
		System.out.println(p1.name+","+p1.sex+","+p1.age);
		People p2=new People("san");
		People p3=new People("��",20);
		System.out.println(p2.name);
		System.out.println(p3.sex+","+p3.age);
	}
}
