package com.wangluo.question;

import java.util.Random;
import java.util.Scanner;

public class Game {
	public static void main(String[] args) 
	{
		int x = 0;//�û��ķ���
		int y = 0;//���Եķ���
		int z = 0;//�ܹ���ľ���

	System.out.println("��ȭ��Ϸ���ڿ�ʼ��׼��������");  
        System.out.println("===========��Ϸ����===========");  
        System.out.println("    ʤ����һ�֣����򲻼ӷ�    ");  
        System.out.println("    ����Ϸ����ʱ�ָ���Ϊʤ    ");  
        System.out.println("==============================");  
	System.out.println("��ѡ�����ֳ�ȭ��"); 
	System.out.println("1 ʯͷ     2 ����     3 ��     0 �˳�"); 
	while(true)
	{
		Scanner s = new Scanner(System.in);//��ȡ�û����������
		int a = s.nextInt();
		if(a==1||a==2||a==3||a==0){
		if (a == 1)
		{
			System.out.println("�ҳ�ʯͷ");
		} else if (a == 2)
		{
			System.out.println("�ҳ�����");
		} else if (a == 3)
		{
			System.out.println("�ҳ���");
		} else if (a == 0)//�û��˳����Ƚ��û��ܵ÷ֺ͵��Ե��ܵ÷�
		{
			System.out.println("�Ҳ���������ˣ������������");

			System.out.println("��ս�Ĵ�����" + z );
			System.out.println("���Ե��ܵ÷֣�"+y);
			System.out.println("�ҵ��ܵ÷֣�"+x);

			if ( x > y)//�û��ķ����ȵ��Եķ�����
			{
				System.out.println("��Ү����ʤ���ԣ�");
			} else if (x < y)
			{
				System.out.println("�������ˣ���������������");
			}else{
				System.out.println("�˴˱˴ˣ�ˮƽ����");
			}
			break;//������ѭ��
		}

		Random r = new Random();//��ȡ�����
		int b = r.nextInt(3) + 1;//0 ~ 2.999999 --> 1 ~ 3
		switch (b)
		{
		case 1:
			System.out.println("���Գ�ʯͷ");
			break;
		case 2:
			System.out.println("���Գ�����");
			break;
		case 3:
			System.out.println("���Գ���");
			break;
		}
		if (a != 0)//�û�û���˳������Ƚ�
		{
			if (a == b)
			{
				System.out.println("ƽ��");
			}else if ((a==1&&b==2) || (a==2&&b==3) || (a==3&&b==1))
			{
				System.out.println("�û�Ӯ��");
				x = x + 1;//x += 1; //�û�Ӯ�˼�һ��
			}else 
			{
				System.out.println("����Ӯ��");	
				y = y + 1;//y += 1; //����Ӯ�˼�һ��
			}
			z = z + 1;//�ܾ�����1
		}
	}else{
		System.out.println("�밴��ʾ���룺");
	}	
	}
	}
}
