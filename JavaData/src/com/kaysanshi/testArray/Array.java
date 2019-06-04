package com.kaysanshi.testArray;
/***
 * ����һ�������Լ�������
 * @author leoill
 *@date 2019��4��23��
 */
public class Array {
	
	private long[] arry;//����һ������
	
	private int elements;//����������Ч����
	
	public Array(){
		arry=new long[50];//����50����
	}
	
	public Array(int maxsize){
		arry=new long[maxsize];
	}
	/**
	 * ��������ݵ����
	 */
	public void insert(long value){
		arry[elements]=value;
		elements++;	
	}
	/**
	 * ��ʾ����
	 */
	public void display(){
		System.out.println("[");
		for(int i=0;i<arry.length;i++){
			System.out.println(arry[i]+ " ");
		}
		System.out.println("]");
	}
	/**
	 * ����ֵ����value
	 */
	public int search(long value){
		int i;
		for(i=0;i<elements;i++){
			if (value==arry[i]) {
				break;
			}
		}
		if (i==elements) {
			return -1;
		}else{
			return i;
		}
	}
	/**
	 * ���Բ���
	 * �������ݸ���������
	 */
	public long get(int index){
		if (index >=elements || index <0) {
			throw new ArrayIndexOutOfBoundsException();
		}else{
			return arry[index];
		}
	}
	/**
	 * ɾ������
	 */
	public void delete(int index ){
		if (index >=elements || index <0) {
			throw new ArrayIndexOutOfBoundsException();
		}else{
			for(int i=0;i<elements;i++)
			arry[index]=arry[index+1];
			elements--;
		}
	}
	/**
	 * ����
	 * @param index
	 * @param newvalue
	 */
	public void update(int index, long newvalue){
		if (index >=elements || index <0) {
			throw new ArrayIndexOutOfBoundsException();
		}else{
			arry[index]=newvalue;
		}
	}
	///////////////////////////
	// ��������������Ĳ���                ///
	//                      //
	//                     ///
	//////////////////////////
	/**
	 * �������
	 * @param value
	 */
	public void sortinsert(long value){
		int i;
		for(i=0;i<elements;i++){
			if (arry[i]>value) {
				break;
			}
		}
		//���������һ��Ԫ�ظ�ֵ��ǰһ��Ԫ�أ�ͬʱ���¼����Ԫ�ظ���ֵ���±�i;Ԫ������+1��
		for(int j=elements;j>i;j--){
			arry[j]=arry[j-1];
		}
		arry[i]=value;
		elements++;
	}
	/**
	 * ���ֲ���:ǰ���Ǳ��������������
	 * @return
	 */
	public int binarysearch(long value){
		int middle=0;
		int low=0;
		int pow=elements;//����±�
		while(true){
			middle=(pow+low)/2;
			if (arry[middle] == value) {
				return middle;
				
			}else if (low >pow) {
				return -1;
			}else {
				if (arry[middle]>value) {
					pow =middle-1;
				}else{
					low =middle+1;
				}
			}
		}
	}
	
	
	/***
	 * ����
	 * @param args
	 */
	public static void main(String[] args){
		
	} 
}
