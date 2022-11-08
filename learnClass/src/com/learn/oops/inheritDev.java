package com.learn.oops;

// class Employee {
//	 Integer baseSalary = 50000;
//
//}

public class inheritDev extends EmployeeDets {
	Integer bonus = 25000;
	Integer total = bonus  + baseSalary;
	
	public static void main(String[] args) {
		inheritDev jil = new inheritDev();
		System.out.println("Total " + jil.total);
		
	}

}
