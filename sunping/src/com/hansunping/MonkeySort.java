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
				System.out.println("�������"+(i+1)+"ֻ���ӵĸ߶�");
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
			//ð������
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
	//ð������˼��
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
	//ѡ������
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
	//��������ʵ��
	public void InsertSort(Monkey[] monkeys){
		for(int i=1;i<monkeys.length;i++){
			//�ȼ�¼���ӵ����
			float insertHeight=monkeys[i].height;
			String insertNum=monkeys[i].number;
			int insertIndex=i-1;
			while(insertIndex>=0 && monkeys[insertIndex].height>insertHeight){
				monkeys[insertIndex+1].height=monkeys[insertIndex].height;
				monkeys[insertIndex+1].number=monkeys[insertIndex].number;
				insertIndex--;
			}
			//����
			monkeys[insertIndex+1].height=insertHeight;
			monkeys[insertIndex+1].number=insertNum;
		}
	}
	public void show(Monkey[] monkeys){
		for(int i=0;i<monkeys.length;i++){
			System.out.println("���"+monkeys[i].number+",��ߣ�"+monkeys[i].height);
		}
	}
}
