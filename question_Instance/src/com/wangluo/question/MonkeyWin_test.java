package com.wangluo.question;


/*
 * һ���Ӻ��ӱ����ӵ��������ӿ�ʼ��������13�ĺ����˳�ȥ��Ȼ����һ�����Ӵ��±����������ƣ����
 * һ�����Ӿ��Ǵ�����
 */
public class MonkeyWin_test {
//???????
	public static void main(String[] args) {
		int sum=100;
		
		for(int i=2;i<sum;i++){
			if(i%13==0){
				sum-=i;
				System.out.println(sum);
				}	
			
		}

	}

}
