package com.kaysanshi.testArray;
/**
 * �ݹ�߼�Ӧ�� 
 * ��ŵ��:
 * 		
 * @author leoill
 *@date 2019��4��27��
 */
public class HighFibonacci {
	
	/**
	 * �ƶ�����
	 * @param TopN �ƶ���������
	 * @param from ��ʼ������
	 * @param inter �м�����
	 * @param end Ŀ������
	 */
	public static void doTower(int TopN,char from,char inter,char end){
		if (TopN ==1) {
			System.out.println("����1,��"+from+"��������"+end+"����");
		}else{
			//�Ȱ��������Щ�Ƶ�end��Ŀ��Ϊinter
			doTower(TopN-1, from, end,inter);
			System.out.println("����"+TopN+"��"+from+"��������"+end+"����");
			//�������Ƶ�from,Ȼ��任
			doTower(TopN-1, inter, from, end);
		}
	}
	
	
	public static void main(String[] args) {
		HighFibonacci.doTower(3, 'A', 'B', 'C');
	}

}
