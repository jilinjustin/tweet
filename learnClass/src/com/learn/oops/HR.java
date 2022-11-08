package com.learn.oops;

public class HR extends EmployeeDets {
	Integer Bonus = 20000;
	Integer total = Bonus + baseSalary;
	
	public static void main(String[] args) {
		HR Anisha = new HR();
		System.out.println("total salary" + Anisha.total);
		Anisha.totalSalary(Anisha.baseSalary,Anisha.bonus);
	}

}
