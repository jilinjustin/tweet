package com.learn.collection;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {
	public static void main(String[] args) {
		HashSet<String> members = new HashSet<String>();
		
		members.add("jilin");
		members.add("pepper");
		members.add("jelly");
		
		Iterator<String> itr = members.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}

}
