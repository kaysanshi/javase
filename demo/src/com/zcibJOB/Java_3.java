package com.zcibJOB;

public class Java_3 {
	  //点的坐标
    int x,y;
    public Java_3() {}
     //*********Found********
    public Java_3(int x,int y){
    	this.x=x;
    	this.y=y;
    	}
    //此处位置不知道是否要进行填写；
    public Java_3(Java_3 p){
    	
    }

   //以对象的形式返回当前点的位置
   public Java_3 getLocation(){
     //*********Found********
      Java_3 p=new Java_3(); //实例化一个Java_3对象p,其坐标是(x,y) 
      //*********Found********
     return p;//返回对象p;
   }

   //返回点的横坐标
   public int getX(){
	   return x;
	   }

   //返回点的纵坐标
   public int getY(){
	   return y;
	   }

  //把当前点移到新的位置(x，y)上
   public void move(int x,int y){
	   this.x = x;
	   this.y = y;
	   }

  //以(x，y)的格式返回点的位置
   public String toString(){
	   return "("+x+","+y+")";
	   }

   //在原有坐标上分别增加x和y 
   public void translate(int x,int y){
	   this.x += x;
	   this.y += y;
	   }

   public static void main(String args[]){
    
      Java_3 p=new Java_3(5,5); //生成一个对象(5,5)
      System.out.println("x="+ p.x+" y="+ p.y); 
      System.out.println("Location is"+ p.toString()); //以(x,y)的方式打印坐标的位置
      Java_3 p1=new Java_3(p.x+3,p.x+4); //在原有位置上增加(3，4)
      System.out.println("x="+ p1.x+" y="+ p1.y); //打印横坐标和纵坐标的值
      System.out.println("Location is"+ p1.toString()); //以(x,y)的方式打印坐标的位置
   }

}
