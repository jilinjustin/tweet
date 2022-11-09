package com.learn.collection;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo {
	
	public static void main(String[] args) {
		TreeSet<String> members = new TreeSet<String>();
		
		members.add("jilin");
		members.add("pepper");
		members.add("jelly");
		
		Iterator<String> itr = members.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
