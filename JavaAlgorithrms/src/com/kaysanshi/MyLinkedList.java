package com.kaysanshi;

/**
 * @Author kay三石
 * @date:2019/5/7
 */
public class MyLinkedList {
    private Node head;//头结点
    private Node last;//尾结点；
    private int size;
    //初始化头尾结点；
    public MyLinkedList(){
        head=new Node();
        last=head;
    }
    //增加的方法；在链表后增加；
    public boolean add(Object obj){
        Node newNode=new Node();
        newNode.setData(obj);
        last.setNext(newNode);
        last=newNode;
        size++;
        return true;
    }
    //删除的方法；
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
    //按照属性；删除；
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
    //插入的方法；
    public void insert(int index,Object obj){
        Node node=head;
        int j=0;
        while(node!=null&&j<index-2){
            //查找到第index-1个元素
            node=node.getNext();
            j++;
        }
        Node sert=new Node();//被插入的结点
        sert.setData(obj);
        sert.setNext(node.getNext());
        node.setNext(sert);
        size++;
    }

    //改变指定位置的元素
    public void modify(int index,Object obj){
        Node node=head;
        int j=0;
        while(node!=null&&j<=index){
            //找到第index个结点
            node=node.getNext();
            j++;
        }
        node.setData(obj);
    }
    //查找的方法：无效；
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
                System.out.println("没有这个数据");
                break;
            }

        }
        return current.getData();
    }
    //查找按造下标查找；
//	public Object find(int index){
//		Node current=head;
//      Object obj;
//		while(current.getNext()!=null&& index<=size){
//          if(current.getNext==index){
//               obj=current.getNext.getData();
//                    return obj;
//          }else{
//              return null;
//          }
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
//				System.out.println("这是个空链表");
                break;
            }

        }
        //sb.append("]");
        return sb.toString();

    }
}
