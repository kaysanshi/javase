package com.hansunping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MonkeySort {
	public static void main(String[] args) {
		int size=5;
	Monkey[] monkeys=new Monkey[size];
	InputStreamReader is=new InputStreamReader(System.in);	
	BufferedReader br=new BufferedReader(is);
	
		try {	
			for(int i=0;i<monkeys.length;i++){
				String height;
				System.out.println("请输入第"+(i+1)+"只猴子的高度");
				height = br.readLine();
				monkeys[i]=new Monkey((i+1)+"",Float.parseFloat(height));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				br.close();
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			Monkey oldmonkeys=new Monkey("11",1.2f);
			//冒泡排序
			//oldmonkeys.Sort(monkeys);
			//oldmonkeys.ChoseSort(monkeys);
			oldmonkeys.InsertSort(monkeys);
			oldmonkeys.show(monkeys);
			

	}

}
class Monkey{
	private String number;
	private float height;
	public Monkey(String number,float height){
		this.height=height;
		this.number=number;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public float getString() {
		return height;
	}
	public void setString(float string) {
		height = string;
	}
	//冒泡排序思想
	public void Sort(Monkey[] monkeys){
		float tempheight;
		String tempNu;
		for(int i=0;i<monkeys.length-1;i++){
			for(int j=0;j<monkeys.length-i-1;j++){
				if(monkeys[j].height>monkeys[j+1].height){
					tempheight=monkeys[j].height;
					monkeys[j].height=monkeys[j+1].height;
					monkeys[j+1].height=tempheight;
					
					tempNu=monkeys[j].number;
					monkeys[j].number=monkeys[j+1].number;
					monkeys[j+1].number=tempNu;
				}
			}
		}
	} 
	//选择排序法
	public void ChoseSort(Monkey[] monkeys){
		float tempheight;
		String tempNu;
		for(int i=0;i<monkeys.length;i++){
			int minheight=i;
			for(int j=i+1;j<monkeys.length;j++){
				if(monkeys[j].height<monkeys[minheight].height){
					minheight=j;
				}
			}
			if(minheight!=i){
				tempheight=monkeys[i].height;
				monkeys[i].height=monkeys[minheight].height;
				monkeys[minheight].height=tempheight;
				
				tempNu=monkeys[i].number;
				monkeys[i].number=monkeys[minheight].number;
				monkeys[minheight].number=tempNu;
			}
		}
	}
	//插入排序实现
	public void InsertSort(Monkey[] monkeys){
		for(int i=1;i<monkeys.length;i++){
			//先记录猴子的身高
			float insertHeight=monkeys[i].height;
			String insertNum=monkeys[i].number;
			int insertIndex=i-1;
			while(insertIndex>=0 && monkeys[insertIndex].height>insertHeight){
				monkeys[insertIndex+1].height=monkeys[insertIndex].height;
				monkeys[insertIndex+1].number=monkeys[insertIndex].number;
				insertIndex--;
			}
			//插入
			monkeys[insertIndex+1].height=insertHeight;
			monkeys[insertIndex+1].number=insertNum;
		}
	}
	public void show(Monkey[] monkeys){
		for(int i=0;i<monkeys.length;i++){
			System.out.println("编号"+monkeys[i].number+",身高："+monkeys[i].height);
		}
	}
}
