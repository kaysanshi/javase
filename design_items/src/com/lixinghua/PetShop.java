package com.lixinghua;
//����ģʽ:(����Ϊ);
public class PetShop {
	private Pet[] pets;//����������
	private int foot;//�������ݵ�λ��;
	//�ж��ٸ����￪�ٶ��ٿռ�;
	public PetShop(int len) {
		if (len>0) {
			this.pets=new Pet[len];
		}else{
			this.pets=new Pet[1];//���ٿ���һ���ռ�
		}
	}
	//�ж��Ƿ�Ҫ�������ݱ����λ�ü���������ĳ���;
	public boolean add(Pet pets){
		if(this.foot<this.pets.length){
			this.pets[this.foot]=pets;
			foot++;
			return true;
		}else{
			return false;
		}
	}
	//��pet�������������Ƿ���ĳһ���ؼ���;
	public Pet[] search(String keyWord){
		Pet p[]=null;
		int count=0;
		//ȷ�Ͽ��ٿռ�Ĵ�С
//		�Ƿ��п��Բ�Ѱ��indexOf()�����ַ����ó���
		for(int i=0;i<this.pets.length;i++){
			if(this.pets[i]!=null){
				if(this.pets[i].getName().indexOf(keyWord)!=-1||
						this.pets[i].getColor().indexOf(keyWord)!=-1){
					count++;
				}
			}
		}
		p=new Pet[count];
		//�ѷ��ϵĶ���ӵ�������;
		int f=0;
		for(int i=0;i<this.pets.length;i++){
			if(this.pets[i]!=null){
				if(this.pets[i].getName().indexOf(keyWord)!=-1||
						this.pets[i].getColor().indexOf(keyWord)!=-1){
					p[f]=this.pets[i];//������������Ϣ����;
					f++;
				}
			}
		}
		return p;
	}

}
