package demoway;

public class Finalkeyword {
//	final �������κ㶨��������ԣ������ǲ��ܽ��иı�ģ�
//	�����������ô�д��������¸�ֵ����б���

		public static final String SKIN_COLOR="��ɫ";
		public static final String EYE_COLOR="��ɫ";
		public static int EYE=2;//��Ϊfinal���εı���������һ����̬����
	
	public static void main(String[] args){
		System.out.println(SKIN_COLOR);
		System.out.println(EYE_COLOR);
//		����������ͼ�ı���final���εı����������ᱨ��
//		Finalkeyword.SKIN_COLOR="��ɫ";//�˴��ı�����д���
		System.out.println(SKIN_COLOR);
		
//		����ı�һ��eye�����β�Ϊfinal��ôeye����һ����̬����Ȼ������ͼ�ı�һ������ֵ
//		������new��һ������ı䣬��������е��ǲ��Ͻ�û��Java�еĸı侲̬�����Ĺ��򣻱��뱨��
		Finalkeyword p=new Finalkeyword();
		p.EYE =3;
		System.out.println(p.EYE);
//		���·�������ͨ����̬�����ı�ֵ�÷������иĽ�
		Finalkeyword.EYE =3;
		System.out.println(Finalkeyword.EYE);
		Finalkeyword.EYE=4;
		System.out.println(Finalkeyword.EYE);
		
		
	}
}
