package beans;

import java.io.Serializable;

public class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String sex;
	private String city;
	private String career;//ְҵ��
	
	public Person() {
		// TODO Auto-generated constructor stub
		name="����";
		age=52;
		sex="Ů";
		city="����";
		career="��ʦ";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}
	public static void main(String[] args) {
		Person person =new Person();
		System.out.println("��ã�"+person.getName());
	}
}
