package demoway;
/*
 * �����ʹ�ü���δ���
 */

public class TestStudent {
	public static void main(String[] args) {
		Student p=new Student();//��������p�����ã���ջ�ڴ������������ڴ�Ķ���
//�ڶ��ִ������󷽷�;Student p;
//p=new Student();
		p.name="��ʯ��";
		p.sex="��";
		p.age=20;
		System.out.println(p.name);
		System.out.println(p.sex);
		System.out.println(p.age);
		p.study();
		p.play();
		p.think();
		p.sleep();
	}

}
