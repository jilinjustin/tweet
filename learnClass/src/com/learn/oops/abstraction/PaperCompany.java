package com.learn.oops.abstraction;

public class PaperCompany implements ITcompanies{

	
	public void working() {
		System.out.println("Working :P");
		
	}
	
	public static void main(String[] args) {
		PaperCompany pc = new PaperCompany();
		pc.working();
	}

}
