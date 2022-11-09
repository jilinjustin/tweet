package com.learn.collection;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetDemo {
	public static void main(String[] args) {
		LinkedHashSet<String> members = new LinkedHashSet<String>();
		
		members.add("jelly");
		members.add("jelly");
		members.add("jilin");
		members.add("pepper");
		members.add("jelly");
		
		Iterator<String> itr = members.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
