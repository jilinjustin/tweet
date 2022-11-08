package com.learn.exception;

import java.io.IOException;

class Car1 {
	void breakdown() throws IOException {
		throw new IOException("car down");
	}
}

public class RiskyCarThrow {
	
	public static void main(String[] args) {
		try {
			Car1 car = new Car1();
			car.breakdown();
		} catch (Exception e) {
			System.out.println("Exception handled " + e);
		}
		System.out.println("continue");
	}

}
