package com.kaysanshi.tree;

import java.math.BigInteger;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

/**
 * hash�����ײ���������ʵ�ֵ�
 * @author leoill
 *@date 2019��5��5��
 */
public class Hash {
	  private Info[] arry;
	  
	  
	  public Hash(){
		  arry=new Info[100];
	  }
	  /**
	   * ָ������Ĵ�С
	   */
	  public Hash(Integer maxSize){
		  arry=new Info[maxSize];
	  }
	  /**
	   * ��������
	   * @param info
	   */
	  public void insert(Info info){
		  arry[info.getKey()]=info;
		  //��ȡ�ؼ���
		  //�ؼ�������Ӧ��hash��
	  }
	  /**
	   * ��������
	   */
	  public Info find(int key ){
		  return arry[key];
	  }
	  /**
	   * �������Ϊ��String���͵�Ҫ����ת��Ϊ��ϣcode
	   * ͨ������ĸ��Ascll����ۼ�����ĵ����кܴ���ظ������磺abc bbb cba���ǵ�hash���붼����ͬ��
	   */
	  public int hashCode(String key){
		  int hashVal=0;
		  for(int i=key.length()-1;i>=0;i--){
			  int letter=key.charAt(i)-96;//A:97����һֱ��ȥ
			  hashVal+=letter;
		  }
		  return hashVal;
	  }
	  /**
	   * ͨ���ݵ����˽�����ϵ�����:
	   * ������Ҫ������ĳ�ʼ��ֵ�Ӵ�Ӷ����䲻����Խ��
	   */
	  public int Hashcode(String keyy){
		  int hashValue=0;
		  int pow27=1;
		  for(int i=keyy.length()-1;i>=0;i--){
			 int letter=keyy.charAt(i)-96;
			 hashValue+=letter*pow27;
			 pow27*=27;
		  }
		  return hashValue;
		  
	  }
	  /**
	   * ʹ��ѹ���ռ�ʹ�ò�Խ��,Ҫʹ��Biginteger����������
	   * �п��ܻ��أ���һ������ӳ�䵽�հ׵ĵ�ַ��            
	   *
	   */
	  public int hashcode(String keyyy){
		  BigInteger hashValue=new BigInteger("0");
		  BigInteger pow27=new BigInteger("1");
		//  int pow27=1
		  for(int i=keyyy.length()-1;i>=0;i--){
			 int letter=keyyy.charAt(i)-96;
			 BigInteger letterB=new BigInteger(String.valueOf(letter));
			 hashValue=hashValue.add(letterB.multiply(pow27));
			 pow27=pow27.multiply(new BigInteger(String.valueOf(27)));
		  }
		  return hashValue.mod(new BigInteger(String.valueOf(arry.length))).intValue();
		  
	  } 
	  /**
	   * ���ҵ�ʱֱ���ã�arry[hashCode(key)]=info
	   * 
	   * 
	   */
	  /////////////////////////////////
	  ////
	  ////�����ÿ��ŵ�ַ������ʹ�ã�
	  ////
	  ////
	  ////
	  /////
	  /////////////////////////////////
	  /**
	   * ���϶��������ͻ
	   * ����ʹ�ÿ��ŵ�ַ����
	   * ��������ͻ����ʱ��ͨ�����������һ����λ�������������룬��������hash�����õ��������±�
	   */
	  public void insertBy(Info info){
		  //��ùؼ���
		  String key =info.getKey1();
		  //�ؼ�����������Զ����hash��
		  int hascode=hashcode(key);
		  while (arry[hascode] !=null && arry[hascode].getValue()!=null) {
			//���еݼ�
			  ++hascode;
			  //ѭ��
			  hascode%=arry.length;
			
		}
		  arry[hascode]=info;  
	  }
	  /////////////////////////////
	  ///
	  ///������������ַ����
	  ///���ڹ�ϣ����ÿ����Ԫ������������ĳ��������Ĺؼ��ֻ�����ͨ��һ����ӳ�䵽hash���еĵ�Ԫ�У���������������뵽��Ԫ�е�������
	  ///
	  ///
	  ///
	  /////////////////////////////
	  
	  
	  /**
	   * ����
	   * @param key
	   * @return
	   */
	  public Info findByy(String key ){
		int hashVal=hashcode(key);
		while(arry[hashVal] !=null){
			if (arry[hashVal].getKey1().equals(key)) {
				return arry[hashVal];
			}
			++hashVal;
			hashVal%=arry.length;
		}
		return null;
	  }
	  /**
	   * ɾ������
	   * @param key
	   * @return
	   */
	  public Info delete(String key){
		  int hashVal=hashcode(key);
		  while(arry[hashVal]!=null){
			  if (arry[hashVal].getKey1().equals(key)) {
				Info temp=arry[hashVal];
				temp.setValue(null);
				return temp;
				
			}
			  ++hashVal;
			  hashVal%=arry.length;
		  }
		  
		return null;
		  
	  }

}

class Info{
	
	private Integer  key;
	
	private String key1;
	public String getKey1() {
		return key1;
	}

	public void setKey1(String key1) {
		this.key1 = key1;
	}

	private String value;

	public Info(Integer  key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
	public Info(String  key1, String value) {
		super();
		this.key1 = key1;
		this.value = value;
	}

	public Info() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}