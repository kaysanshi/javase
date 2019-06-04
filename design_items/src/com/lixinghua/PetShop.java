package com.lixinghua;
//代理模式:(自认为);
public class PetShop {
	private Pet[] pets;//保存多个属性
	private int foot;//保存数据的位置;
	//有多少个宠物开辟多少空间;
	public PetShop(int len) {
		if (len>0) {
			this.pets=new Pet[len];
		}else{
			this.pets=new Pet[1];//至少开辟一个空间
		}
	}
	//判断是否要增加数据保存的位置及就是数组的长度;
	public boolean add(Pet pets){
		if(this.foot<this.pets.length){
			this.pets[this.foot]=pets;
			foot++;
			return true;
		}else{
			return false;
		}
	}
	//在pet数组中来搜索是否含有某一个关键字;
	public Pet[] search(String keyWord){
		Pet p[]=null;
		int count=0;
		//确认开辟空间的大小
//		是否有可以查寻得indexOf()索引字符串得出现
		for(int i=0;i<this.pets.length;i++){
			if(this.pets[i]!=null){
				if(this.pets[i].getName().indexOf(keyWord)!=-1||
						this.pets[i].getColor().indexOf(keyWord)!=-1){
					count++;
				}
			}
		}
		p=new Pet[count];
		//把符合的对象加到数组中;
		int f=0;
		for(int i=0;i<this.pets.length;i++){
			if(this.pets[i]!=null){
				if(this.pets[i].getName().indexOf(keyWord)!=-1||
						this.pets[i].getColor().indexOf(keyWord)!=-1){
					p[f]=this.pets[i];//符合条件的信息保存;
					f++;
				}
			}
		}
		return p;
	}

}
