package com.MindView.net;

/*
 * ��Ѫ�����֣�ָ��λ��ΪΪż�������֣�����һ��������ˣ�������Щ����������д���ָ�����һ���λ����
 * ���ִ���˼����Ե����в���֮��
 */

public class Instance1 {
	public void getBloodMath(){
		for(int i=1000;i<10000;i++){
			int ge=i%10;
			int shi=i/10%10;
			int bai=i/10/10%10;
			int qian=i/10/10/10%10;
		if((shi*10+ge)*(bai*10+qian)==i||(shi*10+qian)*(bai*10+ge)==i||(shi*10+qian)*(qian*10+ge)==i
				)
			System.out.print(i+" ");
		}
	}

	public static void main(String[] args) {
		Instance1 q=new Instance1();
		q.getBloodMath();
	}

}
