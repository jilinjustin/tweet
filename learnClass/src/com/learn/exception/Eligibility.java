package com.learn.exception;

public class Eligibility {
	
	public static void Eligible(Integer experience) {
		if(experience < 10) {
			throw new ArithmeticException("not eligible");
		} else {
			System.out.println("eligible");
		}
	}
	
	public static void main(String[] args) {
		Eligible(20);
	}

}
