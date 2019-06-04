package com.java1995;

public class ArrayList {
	//定义Object[]数组；
	private Object[] objs;
	
	public 	ArrayList(){
		//初始容量
		objs=new Object[10];
	}
	public ArrayList(int size){
		objs=new Object[size];
	}
	//增加的方法
	public boolean add(Object obj){
		int index=-1;
		for(int i=0;i<objs.length;i++){
			if(objs[i]==null){//未放数据；
				index=i;
				break;
			}
		}
		if(index==-1){//要扩容；
			int oldlen=objs.length;
			//创建新的数组；
			Object[] objs2=new Object[objs.length*2];
//			老数组的数据复制到新的数组中；
			System.arraycopy(obj, 0, objs2, 0, objs.length);
			objs=objs2;
			objs[oldlen]=obj;
		}else{
			objs[index]=obj;
		}
		return true;
	}
	//删除的方法；
	public Object remove(int index){
		Object obj=objs[index];
		objs[index]=null;
		return obj;
	}
	//修改的方法；
	public Object set(int index,Object newobj){
		Object oldobj=objs[index];
		objs[index]=newobj;
		return oldobj;
		
	}
	//查找的方法；
	public Object get(int index){
		return objs[index];
	}
	@Override
	public String toString() {
		StringBuffer sb=new StringBuffer();
		//sb.append("[");
		for(Object obj: objs){
			if(obj==null)continue;
			sb.append(obj+" ");
		}
		//sb.append("]");
		return sb.toString();
	}
	
}
