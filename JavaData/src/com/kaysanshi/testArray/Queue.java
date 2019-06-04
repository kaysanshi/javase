package com.kaysanshi.testArray;

/**
 * ����
 * @author leoill
 *@date 2019��4��24��
 */
public class Queue {
	//�ײ�Ҳ��ͬ����ʹ������
	
	private long[] arry;
	//��Ч���ݵĴ�С
	private int elements;
	
	//��ͷ
	private int front;
	
	//��β
	private int end;
	
	public Queue(){
		arry=new long[10];
		elements=0;
		front=0;
		end=-1;
	}
	/**
	 * 
	 * @param maxsize
	 */
	public Queue(int maxsize){
		arry=new long[maxsize];
		elements=0;
		front=0;
		end=-1;
	}
	/**
	 * �������
	 * 
	 */
	public void insert(long value){
		//endָ�����һ��Ԫ��ʱ
		if (end ==arry.length-1) {
			end=-1;
		}
		arry[++end]=value;
		elements++;
	}
	/**
	 * ɾ�����ݣ��Ӷ�ͷɾ��
	 * @return
	 */
	public long remove(){
		
		long value=arry[front++];
		//�ж�front�ĳ���
		if (front==arry.length) {
			front=0;
		}
		elements--;
		return value;
	}
	/**
	 * �鿴����
	 */
	public long peek(){
		return arry[front];
	}
	/**
	 * �ж��Ƿ�Ϊ��
	 */
	public boolean isEmpty(){
		return elements==0;
	}
	/**
	 * �ж��Ƕ���
	 * @return
	 */
	public boolean isFull(){
		return arry.length==elements;
	}
	/**
	 * ��ʾ����
	 */
	public void display(){
		
		while(!isEmpty()){
			System.out.println(peek());
		}
	}
}
