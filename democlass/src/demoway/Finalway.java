package demoway;

public class Finalway {
//	��һ������final���ε�������ǲ��ܱ��̳еã�
	class Tree{
		public final void develop(){
			System.out.println("С����������");
		}
	}
//	�̳����ķ����ڽ���������䣻��
		class Oak extends Tree{
			Oak(){
				System.out.println("����Java��ǰ��");
			}
//			�ڴ���Ҫ��дһ�����ķ���ʱ����ͨ����˵��final���εĲ�����д(�����ܼ̳�)��������
//			public void develop(){};
			public void develop(String name){
				System.out.println(name );
			}
		}
//		final���ʹ��
		final class People{
			
		}
//		��Ҫ�̳�peopleʱ�������ᱨ��˵��final������Ϊ�κ���ĸ������еķ�����ȫ������Ϊfinal���ͣ�
//		class Techer extends People{}
//	��������ε��ã�
	public static void main(String[]args){
		
		
	}
	
}

