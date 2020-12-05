package com.kaysanshi;

/**
 * 构造一个自己实现的数组
 * @Author kay三石
 * @date:2019/5/7
 */
public class MyArrayList {

    private  Object[] objs;
    /**
     * 初始化默认大小为10
     */
    public  MyArrayList(){
        objs=new Object[10];
    }
    public  MyArrayList(int maxsize){
        objs=new Object[maxsize];
    }

    /**
     * 添加的方法
     * @param obj
     * @return
     */
    public boolean add(Object obj) {
        int index = -1;
        for (int i = 0; i < objs.length; i++) {
            //未放数据的情况下
            if (objs[i] == null) {
                index = i;
                break;
            }
        }
        if (index == -1) {//要扩容；
            int oldlen = objs.length;
            //创建新的数组；
            Object[] objs2 = new Object[objs.length * 2];
//			老数组的数据复制到新的数组中；
//            System.arraycopy(obj, 0, objs2, 0, objs.length);
//            objs = objs2;
//            objs[oldlen] = obj;

            for (int i=0;i<objs.length;i++){
                objs2[i]=objs[i];
            }
            objs = objs2;
            objs[oldlen] = obj;
        } else {
            objs[index] = obj;
        }
        return true;
    }
    //删除的方法；
    public Object remove(int index){
        Object obj=objs[index];
        objs[index]=null;
        return obj;
    }
    //清除的方法：
    public void clear(){
         objs=new Object[10];
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
    public static void main(String[] args){
        MyArrayList arrayList=new MyArrayList();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("6");
        arrayList.add("7");
        arrayList.add("8");
        arrayList.add("9");
        arrayList.add("10");
        arrayList.add("11");
        arrayList.add("12");
        arrayList.add("13");

        //arrayList.clear();
        //System.out.print(arrayList);
        System.out.print(arrayList.toString());
    }
}
