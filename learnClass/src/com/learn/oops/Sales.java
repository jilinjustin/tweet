package com.learn.oops;

public class Sales extends EmployeeDets{
	Integer bonus = 10000;
	Integer incentive;
	
	//overriding
	void working() {
		System.out.println("Sales working :P");
	}
	
	public static void main(String[] args) {
		Sales jill = new Sales();
		jill.incentive = 2000;
		jill.totalSalary(jill.baseSalary, jill.bonus, jill.incentive);
		jill.working();
	}

}
