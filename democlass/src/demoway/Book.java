package demoway;

public class Book {
	String name;
	int date;
	String author;
//	�в��еĴ�ֵ�ķ������Ǿ�̬���У�
//	��̬���в�����this��ֵ�������� return���з���ֵ����ֱ�������
	Book (String name){
		this.name=name;
	}
	Book(int date){
		this.date=date;
	}
	
	public static void main(String[] args){
	Book p=new Book("java");
	System.out.println(p.name);
	Book p1=new Book(2000);
	System.out.println(p1.date);
	}
}
