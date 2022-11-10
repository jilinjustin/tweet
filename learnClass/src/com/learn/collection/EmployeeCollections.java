package com.learn.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class EmployeeCollections {
	
	public static void main(String[] args) {
		try {
			//add,remove,removeall - QUEUE		
			System.out.println("-----QUEUE");
			PriorityQueue<String> members = new PriorityQueue<String>();		
			members.add("jilin");
			members.add("pepper");
			members.add("jelly");
			
			Iterator<String> itr11 = members.iterator();		
			while(itr11.hasNext()) {
				System.out.println(itr11.next());
			}
			System.out.println("-----remove 1");
			members.remove("jelly");		
			Iterator<String> itr12 = members.iterator();
			while(itr12.hasNext()) {
				System.out.println(itr12.next());
			}		
			members.removeAll(members);
			Iterator<String> itr13 = members.iterator();
			System.out.println("-----removeAll");//		
			while(itr13.hasNext()) {
				System.out.println(itr13.next());
			}
			
			//HASHMAP - add,remove,removeall
			System.out.println("-----HASHMAP");
			HashMap<Integer, String> colors = new HashMap<Integer,String>();
			colors.put(1, "Red");
			colors.put(2, "orange");
			
			colors.remove(2);
			colors.clear();
//			Iterator<String> itr1 = colors.
//			while(itr1.hasNext()) {
//				System.out.println(itr.next());
//			}
			
			
			//linkedlist -  - add,remove,removeall
			System.out.println("-----LINKEDLIST");
			LinkedList<String> flowers = new LinkedList<String>();
			flowers.add("Violet");
			flowers.add("Tulip");
			flowers.add("Rose");
			flowers.add("Sunflower");
			
			Iterator<String> itr21 = flowers.iterator();		
			while(itr21.hasNext()) {
				System.out.println(itr21.next());
			}
			
			flowers.removeFirst();
			System.out.println("-----remove 1");
			Iterator<String> itr22 = flowers.iterator();
			while(itr22.hasNext()) {
				System.out.println(itr22.next());
			}
			
			System.out.println("------removeall");
			flowers.removeAll(flowers);
			Iterator<String> itr23 = flowers.iterator();
			while(itr23.hasNext()) {
				System.out.println(itr23.next());
			}
			
			
			//arraylist
			System.out.println("-----ARRAYLIST");
			ArrayList<String> character = new ArrayList<String>();
			character.add("elmo");
			character.add("ernie");
			character.add("bird");
			character.add(1, "big bird");
			
			Iterator<String> itr31 = character.iterator();		
			while(itr31.hasNext()) {
				System.out.println(itr31.next());
			}
			
			character.remove(1);
			Iterator<String> itr32 = character.iterator();
			System.out.println("------remove 1");
			while(itr32.hasNext()) {
				System.out.println(itr32.next());
			}
			
			System.out.println("------removeall");
			Iterator<String> itr33 = character.iterator();
			character.removeAll(character);
			while(itr33.hasNext()) {
				System.out.println(itr33.next());
			}			
		} catch(Exception e) {
			e.printStackTrace();
		}
				
	}

}
