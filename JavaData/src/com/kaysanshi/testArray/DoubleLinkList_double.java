package com.kaysanshi.testArray;
/**
 * ˫������
 * @author leoill
 *@date 2019��4��26��
 */
public class DoubleLinkList_double {
	//�����ͷ���
			private Node first;
			//β�ڵ�
			private Node last;
			
			public DoubleLinkList_double() {
				// TODO Auto-generated constructor stub
				first=null;
				last=null;
			}
			/**
			 * ��ͷ������в��� Ҫ�������жϣ��ж��Ƿ�weinul�����weinull.������β���Ϊ����ӵĽ�㣻�������Ϊnull
			 * ����ͷ����ǰһ�����Ϊ����ӵĽ��
			 * @param value
			 */
			public void insert(long value){
				Node node=new Node(value);
				if (isEmpty()) {
					//��β�ڵ�Ϊ��һ����ӵ�
					last=node;
				}else{
					first.privious=node;
				}
				node.next=first;
				first=node;
			}
			/**
			 * ��β�ڵ���в��룺�������Ϊnull��ֱ������ͷ���Ϊ����ӵĽ�㣬��������β���ĺ�һ�����Ϊ����ӽ��
			 * ͬʱ��������ӵĽڵ��ǰһ�����Ϊβ���
			 */
			public void insertLast(long value){
				Node node=new Node(value);
				if (isEmpty()) {
					first=node;
				}else{
					last.next=node;
					node.privious=last;
				}
				last=node;
			}
			/**
			 * ��ͷ��ɾ���ĵ�һ���ڵ�:�ж�ͷ����Ƿ�����һ����㣬���û��������β�ڵ�Ϊnull,��������ͷ������һ������
			 * previousΪnull;
			 * @return
			 */
			public Node deleteFisrt(){
				//����һ���ڵ������
				Node temp=first;
				if (first.next == null) {
					last=null;
				}else{
					first.next.privious=null;
				}
				first=temp.next;
				return temp;
			}
			/**
			 * ɾ���ڵ� ��β��ɾ��
			 * �ж�ͷ����Ƿ�����һ����㣬���û��������ͷ�ڵ�Ϊnull,��������β������һ������
			 * nextΪnull;
			 */
			public Node deleteLast(){
				Node temp=last;
				if (first.next==null) {
					first=null;
				}else{
					last.privious.next=null;
					
				}
				last=last.privious;
				return last;
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

				while(current.data != value){
					if (current.next==null) {
						return null;
					}
					
					current=current.next;
				}
				if (current==first) {
					
					first=first.next;
					
				}else{
					current.privious.next=current.next;
				}
				return current;
			}
			/**
			 * �ж�weinull
			 * @return
			 */
			public boolean isEmpty(){
				return (first==null);
			}
}
