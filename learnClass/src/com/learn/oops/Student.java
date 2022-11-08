package com.learn.oops;

public class Student {
	
	Integer id;
	String name;
	Address address;
	
	void addStudent(Integer i, String n, Address a) {
		this.id = i;
		this.name = n;
		this.address = a;
	}
	
	void displayStuden() {
		System.out.println(name + address.city + address.country);
	}
	
	public static void main(String[] args) {
		Address johnadd = new Address("Chennai", "TamilNadu", "India");
		
		Student john = new Student();
		john.addStudent(1001, "John Abraham", johnadd);
//		john.id = 1;
//		john.name = "John";
//		john.address = johnadd;
		john.displayStuden();
	}

}
