package com.kaysanshi.testArray;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

/**
 * 
 * �����ܹ����ٵĲ���������Ͳ��������ɾ��������
 * ���ĸ��
 * ·����˳�����ӽڵ�ıߴ�һ���ڵ㵽��һ���ڵ㣬�������Ľڵ�˳��
 * ���ڵ㣺��������Ľڵ��Ϊ���ڵ㣬һ����ֻ��һ���������Ҹ����κ�һ���ڵ�����ֻ��һ��·��
 * ���ڵ㣺ÿ���ڵ㶼��һ�����������ӵ���һ���ڵ㣬����ڵ�ͳ�������Ľڵ�ĸ��ڵ�
 * �ӽڵ㣺ÿ���ڵ㶼��һ�����������ӵ���һ���ڵ㣬����Ľڵ��Ϊ�ýڵ���ӽڵ�
 * Ҷ�ӽڵ㣺û���ӽڵ�Ľڵ��ΪҶ�ӽڵ�
 * ������ÿ���ڵ㶼������Ϊһ�������ĸ������������е��ӽڵ㣬�ӽڵ�Ľڵ������������һ������
 * �������������򣬺���
 * ǰ��1.���ʸ��ڵ�,2����������3.������
 * ������ ������ ��
 * ���� ���ң���
 * ���ʣ�����һ���ڵ���Ϊ��������ڵ���ִ��һЩ��������鿴�ڵ�������������������Ǿ���һ���ڵ㣬����Ϊ�Ƿ���������ڵ�
 * ��:һ���ڵ�Ĳ�����ָ�Ӹ��ڵ㿪ʼ������ڵ��ж��ٴ�
 * ��������
 * ���Ľڵ�����������ӽڵ㣬��Ϊ������
 * @author leoill
 *@date 2019��4��28��
 */
public class Tree {
	//��
	private TreeNode root;
	
	/**
	 * ����ڵ㣺
	 * �Ӹ��ڵ㿪ʼ����һ����Ӧ�Ľڵ㣬����ڵ㽫��Ϊ�²���Ľڵ�ĸ��ڵ㡣
	 * �����ڵ��ҵ���ͨ���ж��½ڵ�ֵ�Ĵ�С������������ڵ㻹���ҽڵ�
	 * @param value
	 */
	public void insert(long value){
		//��װ�ڵ�
		TreeNode node=new TreeNode(value);
		//���õ�ǰ�ڵ�
		TreeNode current=root;
		//���ø��ڵ�
		
		TreeNode parent;
		//���rootΪnull��Ҳ���ǵ�һ�������ʱ��
		if (root==null) {
			root=node;
			return;
		}else{
			while(true){
				//���ڵ�ָ��ǰ�Ľڵ�
				parent=current;
				//�����ǰ��ָ��Ľڵ�����ݱȲ���Ĵ���������
				if(current.data>value){
					current=current.leftChild;
					if (current==null) {
						parent.leftChild=node;
						return;
					}
				}else{
					current=current.rightChild;
					if (current==null) {
						parent.rightChild=node;
						return;
					}
				}
				
			}
		}
	}
	/**
	 * ����������
	 * @param value
	 */
	public void insert(long value,String string){
		//��װ�ڵ�
		TreeNode node=new TreeNode(value,string);
		//���õ�ǰ�ڵ�
		TreeNode current=root;
		//���ø��ڵ�
		
		TreeNode parent;
		//���rootΪnull��Ҳ���ǵ�һ�������ʱ��
		if (root==null) {
			root=node;
			return;
		}else{
			while(true){
				//���ڵ�ָ��ǰ�Ľڵ�
				parent=current;
				//�����ǰ��ָ��Ľڵ�����ݱȲ���Ĵ���������
				if(current.data>value){
					current=current.leftChild;
					if (current==null) {
						parent.leftChild=node;
						return;
					}
				}else{
					current=current.rightChild;
					if (current==null) {
						parent.rightChild=node;
						return;
					}
				}
				
			}
		}
	}
	
	/**
	 * ���ҽڵ�
	 * @param value
	 */
	public TreeNode find(long value){
		//����һ����ǰ�ڵ㣬�Ӹ��ڵ㿪ʼ
		TreeNode current=root;
		//ѭ����ֻҪ���ҵĽڵ㲻���ڵ�ǰ�ڵ��������
		while(current.data !=value){
			//���бȽϣ�С��value�������������ң���������߲���
			if (current.data >value) {
				current=current.leftChild;
			}else {
				current=current.rightChild;
			}
			if (current==null) {
				return null;
			}
		}
		return current;
	}
	/**
	 * ɾ���������ڵ� 
	 * ɾ��֮ǰ����Ҫ����Ҫɾ�Ľڵ㣬�ҵ��ڵ�����ɾ���Ľڵ�������������
	 * 1.�ýڵ���Ҷ�ӽڵ㣬û���ӽڵ㣺Ҫɾ��Ҷ�ڵ㣬ֻ��ı�ýڵ�ĸ��ڵ�����ã���ָ��ýڵ����������Ϊnull�Ϳ�����
	 * 2.�ýڵ���һ���ӽڵ㣺�ı丸�ڵ�����ã�����ָ��Ҫɾ���Ľڵ���ӽڵ㡢
	 * 3.�ýڵ��������ӽڵ㣬Ҫɾ���������ӽڵ�Ľڵ㣬����Ҫʹ������������������ýڵ�
	 * 
	 * @param value
	 * @return 
	 */
	public boolean delete(long value){
		//���õ�ǰ�ڵ㣬�Ӹ��ڵ㿪ʼ
		TreeNode current=root;
		//Ӧ�õ�ǰ�ڵ�ĸ��ڵ�
		TreeNode parent =root;
		//�Ƿ�Ϊ��ڵ�
		boolean isLeftNode=true;
		while(current.data !=value){
			parent=current;
			//�����ǱȽϵ�ǰ��ֵ�͵�ǰ�ڵ�Ĵ�С
			if (current.data>value) {
				//�����ǰֵ����ɾ����ֵ���������������
				current=current.leftChild;
				isLeftNode=true;
			}else{
				//�����ǰֵС��ɾ����ֵ����������ң�ֱ���ҵ�
				current=current.rightChild;
				isLeftNode=false;
			}
			//����Ҳ���
			if (current==null) {
				return false;
			}
		}
		//ɾ��Ҷ�ӽڵ㣬Ҳ���Ǹýڵ�û���ӽڵ�
		if (current.leftChild == null && current.rightChild ==null ) {
			//����Ǹ�
			if (current ==root) {
				root=null;
				//��� ���Ǹ��ڵ�����ӽڵ�
			}else if (isLeftNode) {
				parent.leftChild=null;
			}else{
				parent.rightChild=null;
			}
			
		//ɾ���Ľڵ�ֻ�����ӽڵ�	
		}else if (current.rightChild==null) {
			if (current ==root) {
				root=current.leftChild;
			}else if (isLeftNode) {
				parent.leftChild=current.leftChild;
			}else {
				parent.rightChild=current.leftChild;
			}
		//ɾ���Ľڵ�ֻ�����ӽڵ�
		}else if (current.leftChild == null) {
			if (current ==root) {
				root=current.rightChild;
			}else if (isLeftNode) {
				parent.leftChild=current.rightChild;
			}else {
				parent.rightChild=current.rightChild;
			}
		//ɾ���Ľڵ�
		}else{
			TreeNode successor=getSuccessor(current);
			if (current==root) {
				root=successor;
			}else if (isLeftNode) {
				parent.leftChild=successor;
			}else {
				parent.rightChild=successor;
			}
			successor.leftChild=current.leftChild;
		}
		
		//��ʾɾ���ɹ�
		return true;
		
	}
	/**
	 * �����̽ڵ㣬
	 * @param delNode
	 * @return
	 */
	public TreeNode getSuccessor(TreeNode delNode){
		TreeNode successor=delNode;
		TreeNode successorParent=delNode;
		TreeNode current=delNode.rightChild;
		while (current !=null) {
			successorParent=successor;
			successor=current;
			current=current.leftChild;
			
		}
		if (successor!= delNode.rightChild) {
			successorParent.leftChild=successor.rightChild;
			successor.rightChild=delNode.rightChild;
		}
		
		return successor;
	}
	/**
	 * ǰ�����:ǰ��1.���ʸ��ڵ�,2����������3.������
	 * ʹ�õݹ����
	 * @param localNode
	 */
	public void frontTraversal(TreeNode localNode){
		if (localNode !=null) {
			//���ʸ��ڵ�
			System.out.println(localNode.data+","+localNode.sdata);
			//ǰ�����������
			frontTraversal(localNode.leftChild);
			//ǰ�����������
			frontTraversal(localNode.rightChild);
		}
	}
	/**
	 * �������
	 * �ݹ����
	 * ������ ������ ��
	 * ���ǻ��С����һ������
	 * @param localNode
	 */
	public void centerTraversal(TreeNode localNode){
		//���������������
		if (localNode !=null) {
			//�������������
			centerTraversal(localNode.leftChild);
			//���ʸ��ڵ�
			System.out.println(localNode.data+","+localNode.sdata);
			//�������������
			centerTraversal(localNode.rightChild);
		}
	}
	/**
	 * �������:
	 * 		�� ,��,��
	 * @param localNode
	 */
	public void lastTraversal(TreeNode localNode){
		if (localNode!=null) {
			//�������������
			lastTraversal(localNode.leftChild);
			//�������������
			lastTraversal(localNode.rightChild);
			//���ʸ��ڵ�
			System.out.println(localNode.data+"," +localNode.sdata);
		}
	}
	
	
	/**
	 * ����
	 * @param args
	 */
	public static void main(String[] args) {
		Tree tree=new Tree();
		tree.insert(1,"zhang");
		tree.insert(12,"ASD");
		tree.insert(13,"BHD");
		tree.insert(14,"HUA");
		tree.insert(10,"DOS");
		tree.insert(11,"NOD");
		tree.centerTraversal(tree.root);
		//ɾ���ӽڵ�û��
		tree.delete(1);
		System.out.println();
		tree.centerTraversal(tree.root);
		System.out.println();
		//ɾ��ɾ���ýڵ���һ���ӽڵ�
		tree.delete(11);
		tree.centerTraversal(tree.root);
		System.out.println();
		//ɾ��
		tree.delete(14);
		tree.centerTraversal(tree.root);
	}

}
/**
 * �������ڵ�
 * @author leoill
 *@date 2019��4��28��
 */
class TreeNode{
	//������
	public long data;
	//������
	public String sdata; 
	//���ӽڵ�
	public TreeNode leftChild;
	//���ӽڵ�
	
	public TreeNode rightChild;
	
	public TreeNode (long data ,String sdata) {
		this.data=data;
		this.sdata=sdata;
	}
	public TreeNode (long data ){

		this.data=data;
	}
	
}
