package com.learn.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo {
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("jil");
		list.add("jilin");
		list.add("jill");
		list.add("jilbil");
		list.add(1, "1jil");
		System.out.println(list);
		
		Iterator itr = list.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}

}
