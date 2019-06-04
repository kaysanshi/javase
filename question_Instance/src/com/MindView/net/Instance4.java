package com.MindView.net;

import java.util.Scanner;

/*
 * finalize();��ʹ�ã�finalize()�����������ֶ���ǿ�Ƶ��սᶯ����
 */
public class Instance4 {
	public int getSum(int m){
		int sum = 0;
		for(int i=0;i<m;i++){
			sum+=i;
		}
		return sum;
		
		
	} 

	public void finalize(){
		try {
			super.finalize();
			System.out.println("������ֹ");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Instance4 i4=new Instance4();
		int m=new Scanner(System.in).nextInt();
		i4.getSum(m);
	
		if(i4.getSum(m)>1000){
			i4.finalize();
			System.gc();
			System.out.println(i4.getSum(m));
		}
	}

}
