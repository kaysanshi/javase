package com.kaysanshi.java8;

/**
 * @Author kay三石
 * @date:2020/5/2
 */
public class Employee {
    private String name;
    private Integer age;
    private String address;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSealary() {
        return sealary;
    }

    public void setSealary(String sealary) {
        this.sealary = sealary;
    }

    private String sealary;

    public String getName() {
        return name;
    }

    public Employee(String name, Integer age, String address, String sealary) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.sealary = sealary;
    }

    public Employee() {
        System.out.print("null");
    }
    public Employee(String name) {
        this.name=name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", sealary='" + sealary + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
}
