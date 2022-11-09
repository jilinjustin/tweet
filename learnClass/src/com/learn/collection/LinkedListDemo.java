package com.learn.collection;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDemo {
	
	public static void main(String[] args) {
		LinkedList<String> fruits = new LinkedList<String>();
		fruits.add("Mango");
		fruits.add("Apple");
		fruits.add("Orange");
		
		Iterator<String> itr = fruits.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
