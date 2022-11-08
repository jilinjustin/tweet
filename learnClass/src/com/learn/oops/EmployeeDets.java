package com.learn.oops;

public class EmployeeDets { // parent class
	Integer baseSalary = 50000;
	Integer bonus = 80;
	
	void totalSalary(Integer BS, Integer Bonus) {
		Integer total = BS + Bonus;
		System.out.println(total);
		
	}
	
	//overloading
	void totalSalary(Integer BS, Integer Bonus, Integer Incentive) {
		Integer total = BS + Bonus + Incentive;
		System.out.println(total);
		
	}
	
	void working() {
		System.out.println("Employee working :P");
	}

}
