package com.MindView.net;

import java.util.Iterator;
/*
 * 泛型的简单应用
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
    private int n;
	public IterableFibonacci(int count) {
		n=count;
	}
	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<Integer>(){

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return  n>0;
			}

			@Override
			public Integer next() {
				// TODO Auto-generated method stub
				n--;
				return IterableFibonacci.this.next();
			}
			public void remove(){
				throw new UnsupportedOperationException();
			}
			
		};
	}
		public static void main(String[] args) {
		for(int i:new IterableFibonacci(50)){
			System.out.print(i+" ");
		}

	}
}
class Fibonacci{
	private int count=0;
	public Integer next(){
		return fib(count++);
		
	}
	private Integer fib(int i) {
		if(i<2)return 1;
		return fib(i-2)+(i-1);
	}
}