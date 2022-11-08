package com.learn.exception;

public class TestingFinally {
	
	public static void main(String[] args) {
		try {
			System.out.println("Inside try ");
			int num = 100/0;
			System.out.println("num" + num);
		} catch (NullPointerException e) {
			System.out.println("Inside catch " + e);
		}
		finally {
			System.out.println("In finally ");
		}
		System.out.println("ending");
	}

}
