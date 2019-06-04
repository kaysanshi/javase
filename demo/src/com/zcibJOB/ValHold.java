package com.zcibJOB;

	public class ValHold {
	    public int i = 10;
//	}
//	public class ObParm{
//	public static void main(String argv[]){
//	    ObParm o = new ObParm();
//	    o.amethod();
//	}
	public void amethod(){
	    int i = 99;
	    ValHold v = new ValHold();
	    v.i=30;
	    another(v,i);
	    System.out.print( v.i );
	} 
	public void another(ValHold v, int i){
	    i=0;
	    v.i = 20;
	    ValHold vh = new ValHold();
	    v =  vh;
	    System.out.print(v.i);
	    System.out.print(i);
	
	} 

}
