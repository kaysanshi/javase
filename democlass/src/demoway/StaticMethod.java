package demoway;

public class StaticMethod {
//��������е����Լ�д��̬������
	
	public static void main(String[] args) {
		// �������Ծ�̬����1.��̬���������Է��ʷǾ�̬����2.�Ǿ�̬�������Է��ʾ�̬������
	//��̬�����������������ʱ�����ġ��Ǿ�̬��������new�в�����
//	���þ�̬�����ĸ�ʽ��������.��̬������(����)��
		MyMethod.printInt(5);
		MyMethod.printString("hello xiao na ");
	}
}
//����һ���࣬���������д��̬����
//�������ֻ��д�������������ϵ����������ã�
		class MyMethod{
			static void printString(String i){
				System.out.println(i);
			}
			static void printInt(int x){
				System.out.println(x);
			}
	}

