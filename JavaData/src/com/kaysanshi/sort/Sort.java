package com.kaysanshi.sort;


/**
 * ð������
 * @author leoill
 *@date 2019��4��23��
 */
public class Sort {
	/**
	 * ð������˼�����ҶԱȣ�Ȼ���Ƕ�Ӧ�������Ļ�������  
	 * @param arry
	 */
	public static void bubblesort(long [] arry){
		for(int i=0;i<arry.length;i++){
			for(int j=arry.length-1;j>i;j--){
				if (arry[j]<arry[j-1]) {
					//���н���
					long temp;
					temp=arry[j];
					arry[j]=arry[j-1];
					arry[j-1]=temp;
				}
			} 
		}
	}
	/**
	 * ��������:ͨ��һ�����黮��Ϊ���ɸ������飬Ȼ��ͨ���ݹ��������Ϊÿһ����������п�������
	 * �趨�ؼ��ֱȹؼ��ִ���趨Ϊһ�飬�ȹؼ���С�ķ�Ϊһ�飬�����������Ҷ˵�����Ϊ�ؼ���
	 * @param arry
	 */
	public static void quicklySort(long[] arry,int left,int right){
		if (right-left<=0) {
			return;
		}else{
			//����ʹ�õݹ�ϵ��õķ�ʽ
			
			//�趨point:�ؼ���
			long point=arry[right];
			//��ȡ�е�
			int partition=partition(arry, left, right, point);
			//���������������п�������
			quicklySort(arry, left, partition-1);
			//���������������п�������
			quicklySort(arry, partition+1, right);
			
		}
		
		
	}
	/**
	 * Ϊ�������򻮷�����
	 * @param arry
	 * @param left
	 * @param right
	 * @param point
	 */
	public static int partition(long[] arry,int left,int right,long point){
		int leftPtr=left-1;//��ָ��
		int rightPtr=right+1;//��ָ��
		//��֤��ߵ�����������С
		while(true){
			//ѭ��:���ȹؼ���С���������
			while(leftPtr <rightPtr && arry[++leftPtr]<point);
			//ѭ�������ȹؼ��ִ�������Ҷ�
			while(rightPtr >leftPtr && arry[--rightPtr]>point);
			if (leftPtr>=rightPtr) {
				break; 
			}else {
				long temp=arry[leftPtr];
				arry[leftPtr]=arry[rightPtr];
				arry[rightPtr]=temp;
			}
		}
		//���ؼ��ֺ͵�ǰ����ָ��leftPtr��ָ�Ľ��н���
		long temp=arry[leftPtr];
		arry[leftPtr]=arry[right];
		arry[right]=temp;
		return leftPtr;
	}
	
	/**
	 * ѡ�����򣺴�δ�ŵ���������������С��Ԫ�أ���������е���ʼλ�ã�Ȼ���ٴ�ʣ���δ����Ԫ���м���Ѱ����С��(��)��Ԫ��
	 * Ȼ��ŵ����������е�ĩλ
	 */
	public static void selectSort(long[] arry){
		int k=0;
		long temp=0;
		for(int i=0;i<arry.length-1;i++){
			k=i;//kָ��ÿ��ѭ�����׸���
			for(int j=i;j<arry.length;j++){
				if (arry[j]<arry[k]) {
					k=j;
				}
			}
			//ָ���Ϊ��С������
			temp=arry[i];
			arry[i]=arry[k];
			arry[k]=temp;
		}
	}
	/**
	 * ��������
	 *  ͨ������һ���������У�����δ�����������������������н�����ǰɨ�裬�ҵ���Ӧ��λ�ò��룬ͨ������in-place��������ڴӺ���ǰɨ������У���Ҫ����
                ��������Ԫ�������Ųλ��Ϊ�µ�Ԫ���ṩ����Ŀռ䡣
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
	
	
}
