package com.learn.junittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.learn.junitdemo.Calculator;

class BeforeAndAfterTestDemo {

	Calculator calc;

	@BeforeEach
	public void init() {
		calc = new Calculator();
		System.out.println("HAPPINESS");
	}

	@AfterEach
	public void after() {
		System.out.println("AfterEach");
	}

	@Test
	@DisplayName("Adding two positive numbers")
	public void testAddMethod() {
		int sum = calc.add(10, 100);
		assertEquals(110, sum);
		System.out.println("The sum is " + sum);

	}

	@Test
	@DisplayName("Subtracting two positive numbers")
	public void testSubMethod() {
		int sum = calc.substract(10, 100);
		assertEquals(-90, sum);
		System.out.println("The subtraction is " + sum);

	}

	@Test
	@DisplayName("Multiplying two positive numbers")
	public void testProductMethod() {
		int sum = calc.product(10, 100);
		assertEquals(1000, sum);
		System.out.println("The product is " + sum);

	}

}
