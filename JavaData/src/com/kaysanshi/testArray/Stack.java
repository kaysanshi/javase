package com.kaysanshi.testArray;
/**
 * ջ�Ĺ��켰��ʹ�ã�
 * ����ȳ�
 * @author leoill
 *@date 2019��4��24��
 */
public class Stack {
	//�ײ��ʵ����һ������
	private long[] arry;
	
	private int top;//ջ��Ԫ��
	
	public Stack(){
		arry=new long[10];
		top=-1;
		
	}
	/**
	 * �вι����ʼ��
	 * @param maxsize
	 */
	public Stack(int maxsize){
		arry=new long[maxsize];
		top=-1;
	}
	/**
	 * �������
	 */
	public void push(int value){
		arry[++top]=value;
	}
	/**
	 * �Ƴ�����
	 * @return
	 */
	public long pop(){
		return arry[top--];
	}
	/**
	 * �鿴ջ������
	 */
	public long peek(){
		return arry[top];
	}
	/**
	 * �ж��Ƿ�Ϊ��
	 */
	public boolean isEmpty(){
		return top==-1;
	}
	/**
	 *�ж��Ƿ���
	 * @return
	 */
	public boolean isFull(){
		return top==arry.length-1;
	}
	
}
