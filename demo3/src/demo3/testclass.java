package demo3;

public class testclass {
//�����������
//	�����е�����
	String name;
    /*private*/ String sex;
	int age;
	String type;
	int num;
//	�Ǿ�̬�޲εķ���ʵ������Ӧ�ã�
	void eat(){
		System.out.println("���ڳԷ�");
	}
	void tea(){
		System.out.println("���ںȲ�");
	}
	public String run(){
		return "�ܲ�";
	}
	public String fly(){
		return "���ڷ�";
	}
	public void eating(String type,int num){
		this.type=type;
		this.num=num;
//		System.out.println("���ڳ�"+type+",����"+num+"��");
	}
}
