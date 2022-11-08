package com.learn.oops.abstraction;

public class CSK extends IPL{

	void play() {
		System.out.println("CSK is playing");
		
	}
	
	public static void main(String[] args) {
		CSK obj1 = new CSK();
		obj1.play();
	}

}
