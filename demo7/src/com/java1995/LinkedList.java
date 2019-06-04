package com.java1995;

/*
 * ʵ���Լ���linkedList;
 */
public class LinkedList {
	private Node head;//ͷ���
	private Node last;//β��㣻
	private int size;
	//��ʼ��ͷβ��㣻
	public LinkedList(){
		head=new Node();
		last=head;
	}
	//���ӵķ���������������ӣ�
	public boolean add(Object obj){
		Node newNode=new Node();
		newNode.setData(obj);
		last.setNext(newNode);
		last=newNode;
		size++;
		return true;
	}
	//ɾ���ķ�����
	public Object remove(int index){
		if(index==0){
			head=head.getNext();
			return null;
		}
		Node before=head;
		for(int i=0;i<index;i++){
			before=before.getNext();
		}
		Node current=before.getNext();
		before.setNext(current.getNext());
		current.setNext(null);
		size--;
		return current.getData();
	}
	//�������ԣ�ɾ����
//	 public Object remove(Object item){     
//		 Node before=head;
//		 Object beforeObj=head.getData();
//		for(int i=0;i<size;i++){
//			if(item.equals(beforeObj)){
//				beforeObj=before.getNext().getData();
//				}
//				before=before.getNext();
//			}
//			Node current=before.getNext();
//			Object currentObj=before.getNext().getData();
//			before.setNext(current.getNext());
//			current.setNext(null);
//			before.setData(null);
//			size--;
//			return currentObj;
//	    } 
	//����ķ�����
	 public void insert(int index,Object obj){  
	     Node node=head;  
	     int j=0;  
	     while(node!=null&&j<index-2){  
	         //���ҵ���index-1��Ԫ��  
	         node=node.getNext();  
	         j++; 
	     }  
	     Node sert=new Node();//������Ľ��  
	     sert.setData(obj);
	     sert.setNext(node.getNext());  
	     node.setNext(sert);
	     size++;
	 }
	 
	//�ı�ָ��λ�õ�Ԫ�� 
	 public void modify(int index,Object obj){  
	     Node node=head;  
	     int j=0;  
	     while(node!=null&&j<=index){  
	         //�ҵ���index�����  
	         node=node.getNext();  
	         j++;  
	     }  
	     node.setData(obj);
	 }
	//���ҵķ�������Ч��
	public Object get(Object obj){
		Node current=head;
		Object objs;
		int j=0;
		while(current.getNext()!=null&&j<=size){
				objs=current.getNext().getData();
				j++;
			if(obj.equals(objs)){
				System.out.println(obj);
				break;
			}else{
				System.out.println("û���������");
				break;
			}
			
		}
		return current.getData();
	}
	//���Ұ����±���ң�
//	public void find(int index){
//		Node current=head;
//		for(int i=0;i<index;i++){
//			if(){
//				
//			}
//		}
//	}
	@Override
	public String toString() {
		StringBuffer sb=new StringBuffer();
		//sb.append("[");
		Node currentNode=head;
		while(true){
			if(currentNode.getNext()!=null){
				currentNode=currentNode.getNext();
				sb.append(currentNode.getData()+" ");
			}else{
//				System.out.println("���Ǹ�������");
				break;
			}
			
		}
		//sb.append("]");
		return sb.toString();
		
	}
	
}
