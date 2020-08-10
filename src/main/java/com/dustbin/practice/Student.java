package com.dustbin.practice;

public class Student {

	private String name;
	private int age;
	private Address presentAddress;
	private Address permanentAddress;

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Student() {
		
	}

	public Student(String name) {
		this.name = name;
	}

	public Student(int age) {
		this.age = age;
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

	public Address getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(Address presentAddress) {
		this.presentAddress = presentAddress;
	}

	public Address getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(Address permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String studentDetails() {
		return "Student Name- " + getName() + " and age- " + getAge();
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", presentAddress=" + presentAddress + ", permanentAddress="
				+ permanentAddress + "]";
	}
	
	

}
