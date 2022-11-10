package com.learn.junittest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ParameterizedTestDemo {

//	@ValueSource
//	@EnumSource
//	@MethodSource
//	@CsvSource
//	@CsvFileSource
//	@ArgumentsSource

	@ParameterizedTest(name="{index} - Run with the args = {0}")
	@ValueSource(ints = { 1, 5, 6, 7 })
	public void valueSource(int args) {
		System.out.println(args);
	}
	
	enum TV {
		LG,Samsung,Toshiba;
	}
	
	@ParameterizedTest
	@EnumSource(TV.class)
	public void enumSourceTest(TV tv) {
		System.out.println(tv);
	}
	
	private static String[] cars() {
		return new String[] {"Maruti","Swift","Honda"};
	}
	
	@ParameterizedTest
	@MethodSource("cars")
	public void methodSourceDemo(String cars) {
		System.out.println(cars);
	}
	
	@ParameterizedTest
	@CsvSource({"Jilin","Jil","Jelly"})
	public void csvSourceDemo(String name) {
		System.out.println(name);
	}

}
