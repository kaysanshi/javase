package com.zcibJOB;

public class Java_3 {
	  //�������
    int x,y;
    public Java_3() {}
     //*********Found********
    public Java_3(int x,int y){
    	this.x=x;
    	this.y=y;
    	}
    //�˴�λ�ò�֪���Ƿ�Ҫ������д��
    public Java_3(Java_3 p){
    	
    }

   //�Զ������ʽ���ص�ǰ���λ��
   public Java_3 getLocation(){
     //*********Found********
      Java_3 p=new Java_3(); //ʵ����һ��Java_3����p,��������(x,y) 
      //*********Found********
     return p;//���ض���p;
   }

   //���ص�ĺ�����
   public int getX(){
	   return x;
	   }

   //���ص��������
   public int getY(){
	   return y;
	   }

  //�ѵ�ǰ���Ƶ��µ�λ��(x��y)��
   public void move(int x,int y){
	   this.x = x;
	   this.y = y;
	   }

  //��(x��y)�ĸ�ʽ���ص��λ��
   public String toString(){
	   return "("+x+","+y+")";
	   }

   //��ԭ�������Ϸֱ�����x��y 
   public void translate(int x,int y){
	   this.x += x;
	   this.y += y;
	   }

   public static void main(String args[]){
    
      Java_3 p=new Java_3(5,5); //����һ������(5,5)
      System.out.println("x="+ p.x+" y="+ p.y); 
      System.out.println("Location is"+ p.toString()); //��(x,y)�ķ�ʽ��ӡ�����λ��
      Java_3 p1=new Java_3(p.x+3,p.x+4); //��ԭ��λ��������(3��4)
      System.out.println("x="+ p1.x+" y="+ p1.y); //��ӡ��������������ֵ
      System.out.println("Location is"+ p1.toString()); //��(x,y)�ķ�ʽ��ӡ�����λ��
   }

}
