package com.kaysanshi.testArray;
/**
 * ��������ÿ�����ͽ����������ɵ�����
 * @author leoill
 *@date 2019��4��25��
 */
public class LinkList {
	//�����ͷ���
	private Node first;
	
	public LinkList(){
		first=null;
	}
	/**
	 * ����ڵ㣺��ͷ������в���
	 * @param value
	 */
	public void insert(long value){
		Node node=new Node(value);
			//����һ���ڵ��ָ����ӵĽڵ�
			node.next=first;
			//Ȼ���ֵ��first
			first=node;
		
	}
	/**
	 * ɾ��һ���ڵ㣬ɾ���ĵ�һ���ڵ�
	 * @return
	 */
	public Node deleteFisrt(){
		//����һ���ڵ������
		Node temp=first;
		//Ȼ�������ڵ�ָ���һ���ڵ�
		first=temp.next;
		return temp;
	}
	/**
	 * ��ʾ�ķ���
	 */
	public void display(){
		Node current=first;
		//��ǰ�Ľڵ㲻Ϊnull
		while(current!=null){
			current.display();
			current=current.next;
		}
	}
	/**
	 * ����
	 * @param value
	 * @return
	 */
	public Node find(long value){
		Node current=first;
		while(current.data!=value){
			//��һ��û������ֹ
			if (current.next==null) {
				return null;
			}
			//ָ����һ��Ԫ��
			current=current.next;
		}
		return current;
	}
	/**
	 * ɾ���ķ���������ɾ��������
	 * @param value
	 * @return
	 */
	public Node delete(long value){
		//��ǰ�Ľڵ�
		Node current=first;
		//ǰһ���ڵ�
		Node previous=first;
		while(current.data != value){
			if (current.next==null) {
				return null;
			}
			previous=current;
			current=current.next;
		}
		if (current==first) {
			
			first=first.next;
			
		}else{
			
			previous.next=current.next;
		}
		return current;
	}
}
/**
 * ����ÿ���ڵ���
 * @author leoill
 *@date 2019��4��25��
 */
class Node{
	//������
	public long data;
	
	//�����
	//ָ����
	public Node next;
	
	//ǰһ��ָ����
	public Node privious;
	
	public Node(long value){
		this.data=value;
	}
	/**
	 * ��ʾ�ķ���
	 */
	public void display(){
		System.out.println(data+" ");
	}
}
