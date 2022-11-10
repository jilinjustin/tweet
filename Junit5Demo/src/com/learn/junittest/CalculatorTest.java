package com.learn.junittest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.learn.junitdemo.Calculator;

public class CalculatorTest {

	@Test
	@DisplayName("Adding two positive numbers")
	public void testAddMethod() {
		Calculator calc = new Calculator();
		int sum = calc.add(10, 100);
		assertEquals(110, sum);
		System.out.println("The sum is " + sum);

	}
	
	@Test
	@DisplayName("Subtracting two positive numbers")
	public void testSubMethod() {
		Calculator calc = new Calculator();
		int sum = calc.substract(10, 100);
		assertEquals(-90, sum);
		System.out.println("The subtraction is " + sum);

	}
	
	@Test
	@DisplayName("Multiplying two positive numbers")
	public void testProductMethod() {
		Calculator calc = new Calculator();
		int sum = calc.product(10, 100);
		assertEquals(1000, sum);
		System.out.println("The product is " + sum);

	}

}
