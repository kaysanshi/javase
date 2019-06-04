package com.java1995;

public class ArrayList {
	//����Object[]���飻
	private Object[] objs;
	
	public 	ArrayList(){
		//��ʼ����
		objs=new Object[10];
	}
	public ArrayList(int size){
		objs=new Object[size];
	}
	//���ӵķ���
	public boolean add(Object obj){
		int index=-1;
		for(int i=0;i<objs.length;i++){
			if(objs[i]==null){//δ�����ݣ�
				index=i;
				break;
			}
		}
		if(index==-1){//Ҫ���ݣ�
			int oldlen=objs.length;
			//�����µ����飻
			Object[] objs2=new Object[objs.length*2];
//			����������ݸ��Ƶ��µ������У�
			System.arraycopy(obj, 0, objs2, 0, objs.length);
			objs=objs2;
			objs[oldlen]=obj;
		}else{
			objs[index]=obj;
		}
		return true;
	}
	//ɾ���ķ�����
	public Object remove(int index){
		Object obj=objs[index];
		objs[index]=null;
		return obj;
	}
	//�޸ĵķ�����
	public Object set(int index,Object newobj){
		Object oldobj=objs[index];
		objs[index]=newobj;
		return oldobj;
		
	}
	//���ҵķ�����
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
