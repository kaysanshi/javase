package com.kaysanshi.tree;
/**
 * 
 * �������е��������������� 1-10�������ͻ�ֻ�������������Ե�������������࣬
 * ��ʹ��ƽ������µĶ����������ʱ�临�Ӷ�Ϊlogn�����������ּ�������Ļ�����Ҫ��9��λ�þ���Ҫÿһ�ζ�������һ�������������п���ʱ�临�Ӷȱ�Ϊn(��������ͨ��ѯ��ʱ�临�Ӷ���ͬ)
 * 
 * ������������������ƽ����������������Ϊƽ���������һ��
 * ���������Ϊ�˽���������еĳ��ֲ�ƽ������У�
 * 	�ص㣺
 * 		�ڵ��Ǻ�ɫ���ɫ
 * 		���ڵ�һ��Ϊ��ɫ
 * 		ÿ���ڵ㶼�Ǻ�ɫ�Ŀսڵ�
 * 		ÿ����ڵ�������ӽڵ㶼�Ǻ�ɫ��	(��ÿ��Ҷ�ӵ���������·���ϲ��������������ĺ�ڵ�)
 * 		(�����ڲ���˵����NIL�ڵ㣬��ڽڵ��ǽ���ģ���һ���Ǻڽڵ���ô����һ��϶����Ǻ�ڵ㣬��֮һ��)
 * 		����һ�ڵ㵽��ÿ��Ҷ�ӽڵ������·����������ͬ��Ŀ�ĺ�ɫ�ڵ�
 * �����������������ȹ����ô����Ҫ���������Ա�֤������������Ȳ���С
 * �����������������ĸ��������෴
 * ͨ����������������ʵ�ֺ����
 * @author leoill
 *@date 2019��4��29��
 */
public class ReadBlackTree {
	 TreeNode grandParent;
	/**
	 * ������
	 * @param presentNode
	 * @return
	 */
	public TreeNode singleRotateWithLeft(TreeNode presentNode){
	    TreeNode node;        //�µĸ��ڵ�
	    node = presentNode.rightChild;
	    presentNode.rightChild = node.leftChild;
	    node.leftChild = presentNode;
	    return node;
	}
	/**
	 * ����
	 * @param presentNode
	 * @return
	 */
	public TreeNode singleRotateWithRight(TreeNode presentNode){
	    TreeNode node;
	    node = presentNode.leftChild;
	    presentNode.leftChild = node.rightChild;
	    node.rightChild = presentNode;
	    return node;
	}
	/**
	 * ���룺������Ľڵ��Ǹ��ڵ�
	 * @param presentNode
	 */
	public void insert_case1(TreeNode presentNode){
	    if(presentNode.parent == null){
	        presentNode.color = "black";
	    }else{
	        insert_case2(presentNode);
	    }
	}
	/**
	 * ������Ľڵ�ĸ��ڵ��Ǻ�ɫ
	 * @param presentNode
	 */
	public void insert_case2(TreeNode presentNode){
	    if(presentNode.parent.color.equals("black")){
	        // do nothing
	    }else{
	        insert_case3(presentNode);
	    }
	}
	/**
	 * ����ڵ��Ǻ�ɫ
		����ʽ��
		�� "���ڵ�" ��Ϊ��ɫ
		�� "����ڵ�" ��Ϊ��ɫ
		�� "�游�ڵ�" ��Ϊ��ɫ
		�� "�游�ڵ�" ��Ϊ "��ǰ�ڵ�"(��ɫ�ڵ�)��֮������� "��ǰ" ���в�����
	 * 
	 * @param presentNode
	 */
	public void insert_case3(TreeNode presentNode){
	    if(presentNode.uncle != null && presentNode.uncle.color.equals("red")){
	        presentNode.parent.color = "black";
	        presentNode.uncle.color = "black";
	        grandParent.color = "red";
	        insert_case1(grandParent);
	    }else{
	        insert_case4(presentNode);
	    }
	}
	/**
	 * ����ڵ�Ϊ��ɫ��ȱʧ���ҵ�ǰ�ڵ������߱� (�����һ�����)
		����ʽ��
		
		�� "���ڵ�" ��Ϊ "�µĵ�ǰ�ڵ�"
		�� "�µĵ�ǰ�ڵ�" Ϊ֧���������
		���µĵ�ǰ�ڵ�(��ԭ���ĸ��ڵ�)�ٽ��в���
	 */
	public void insert_case4(TreeNode presentNode){
	    if(presentNode == presentNode.parent.rightChild && presentNode.parent == presentNode.grandParent.leftChild){
	        singleRotateWithLeft(presentNode.parent);
	        presentNode = presentNode.leftChild;
	    }else if(presentNode == presentNode.parent.leftChild && presentNode.parent == presentNode.grandParent.rightChild){
	        singleRotateWithRight(presentNode.parent);
	        presentNode = presentNode.rightChild;
	    }
	    insert_case5(presentNode);
	}
	public void insert_case5(TreeNode presentNode){
	    presentNode.parent.color = "black";
	    presentNode.grandParent.color = "red";
	    if(presentNode == presentNode.parent.leftChild && presentNode.parent == presentNode.grandParent.leftChild){
	        singleRotateWithRight(presentNode);
	    }else{
	        singleRotateWithLeft(presentNode);
	    }
	}
	/**
	 * ����ʵ�ֲ������
	 */
	public void insert_case(TreeNode presentNode){

	    while(presentNode != null){
	        if(presentNode.parent == null){
	            presentNode.color = "black";
	            break;
	        }else if(presentNode.parent.color.equals("black")){
	            //do nothing
	            break;
	        }else if(presentNode.uncle != null && presentNode.uncle.color.equals("red")){
	        
	            presentNode.parent.color = "black";
	            presentNode.uncle.color = "black";
	            presentNode.grandParent.color = "red";
	            presentNode = presentNode.grandParent;
	            
	        }else if(presentNode == presentNode.parent.rightChild && presentNode.parent == presentNode.grandParent.leftChild){
	        
	            singleRotateWithLeft(presentNode.parent);
	            presentNode = presentNode.leftChild;
	            
	        }else if(presentNode == presentNode.parent.leftChild && presentNode.parent == presentNode.grandParent.rightChild){
	        
	            singleRotateWithRight(presentNode.parent);
	            presentNode = presentNode.rightChild;
	            
	        }else{
	        
	            presentNode.parent.color = "black";
	            presentNode.grandParent.color = "red";
	            if(presentNode == presentNode.parent.leftChild && presentNode.parent == presentNode.grandParent.leftChild){
	                singleRotateWithRight(presentNode);
	            }else{
	                singleRotateWithLeft(presentNode);
	            }   
	            
	        }
	    }
	}
}
class TreeNode{
    TreeNode leftChild;
    TreeNode rightChild;
    TreeNode parent;
    TreeNode grandParent;
    TreeNode uncle;
    String color;
    public TreeNode(){
        grandParent = this.parent.parent;
        if(this.parent == grandParent.leftChild){
            uncle = grandParent.rightChild;
        }else{
            uncle = grandParent.leftChild;
        }
    }
}
