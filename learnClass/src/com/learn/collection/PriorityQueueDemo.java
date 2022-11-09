package com.learn.collection;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
	
	public static void main(String[] args) {
		PriorityQueue<String> members = new PriorityQueue<String>();
		
		members.add("jilin");
		members.add("pepper");
		members.add("jelly");
		
		System.out.println("First one is " + members.peek());
		
		Iterator<String> itr = members.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}

}
