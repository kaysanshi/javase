package com.zcib;

public class TestPupil {

	public static void main(String[] args) {
		Pupil1 p=new Pupil1();
		p.Name("liasge");
		System.out.println(p.Name("liasge"));
		System.out.println("���ڰ༶��"+Pupil.Class);
		p.eat();
		p.sex();
		p.study();
		
//		���ӿ��Զ��Ѷ���ı�������Static����
//		�ڴ�class�Ǿ�̬�������ã�����.����  ���ʣ�
//		public static finall class;����ͼ�ı�class��ֵ���ᱨ��
//		p.Class=2088;The final field Pupil.Class cannot be assigned
//		System.out.println(p.Class);
		System.out.println("���ø��ӿ��еı���ֵ��ʵ�֣�"+Pupil.name+","+Human.name);

	}

}
