package com.learn.oops;

public class Television {

	// defining fields of TV
	String brand;
	String modelName;
	Integer screenSize;
	Integer price;
	String color;
	String displayType;

	void insertData(String b, String m, Integer s, Integer p, String c, String d) {
		brand = b;
		modelName = m;
		screenSize = s;
		price = p;
		color = c;
		displayType = d;
	}
	
	void displayData() {
		System.out.println(brand + " " + modelName);
				
	}

	// defining the main method
	public static void main(String[] args) {

		Television lgOled = new Television();
		Television samsungFrame = new Television();

		lgOled.brand = "LG";
		lgOled.modelName = "4k oled 75' tv";
		lgOled.screenSize = 75;
		lgOled.price = 100000;
		lgOled.color = "white";
		lgOled.displayType = "OLED";

		samsungFrame.insertData("Samsung", "85' TV", 85, 120000, "Black", "LED");

		System.out.println(lgOled.brand + " " + lgOled.modelName);
		samsungFrame.displayData();

	}

}
