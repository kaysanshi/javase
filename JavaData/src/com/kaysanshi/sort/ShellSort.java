package com.kaysanshi.sort;
/**
 * ϣ������
 * 	ͨ���Ӵ����������Ԫ��֮��ļ����������Щ�����Ԫ�أ����в������򣬴Ӷ�ʹ�����ݿ��Դ󸡶��ģ�����ɸü���������ϣ������
 * ��������ݵļ���ڽ����������ν�����ȥ
 * 
 * @author leoill
 *@date 2019��4��27��
 */
public class ShellSort {
	
	
	/**
	 * ��������
	 * ȱ�ݣ������С�������ڿ��Ҷ˵�λ�ã���ôҪ��������������ȷ��λ���ϣ������е��м�����ݶ���Ҫ�����ƶ�
	 * 
	 */
	public static void insertsort(long[]  arry){
		//�������2��λ�ÿ�ʼ i=1;
		long temp=0;
		for(int i=1;i<arry.length;i++){
			temp=arry[i];//ָ��ǰ�����
			int j=i;
			while (j>0 && arry[j]>=temp) {
				arry[j]=arry[j-1];//����
				j--;
			}
			arry[j]=temp;
		}
	}
	/**
	 * ϣ������
	 * @param arry
	 */
	public static void shellsort(long[] arry){
		//��ʼ��һ�����
		int h=1;
		
		//���������
		while(h<arry.length/3 ){
			h=h*3+1;
		}
		
		while(h>0){
			//���в�������
			long temp=0;
			for(int i=h;i<arry.length;i++){
				temp=arry[i];//ָ��ǰ�����
				int j=i;
				while (j> h-1 && arry[j-h]>=temp) {
					arry[j]=arry[j-h];//����
					j-=h;
				}
				arry[j]=temp;
			}	
			//��С���
			h=(h-1)/3;
		}
	}
	
	public static void main(String[] args) {
		long[] arry=new long[5];
		arry[0]=10;
		arry[1]=122;
		arry[2]=123;
		arry[3]=112;
		arry[4]=90;
		System.out.print("[");
		for(long num: arry){
			System.out.print(num + " ");
		}
		System.out.print("]");
		
		//
		ShellSort.shellsort(arry);
		//
		
		System.out.print("[");
		for(long num: arry){
			System.out.print(num + " ");
		}
		System.out.print("]");
	}
}
