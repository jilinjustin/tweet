package com.learn.start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.learn.start.student.Student;

public class Start {
	
	public static void main(String[] args) throws IOException {
		System.out.println("Hello World");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("1. Add student");
			System.out.println("2. Delete student");
			System.out.println("3. Display student");
			System.out.println("4. exit");
			int choice = Integer.parseInt(br.readLine());
			
			if(choice == 1) {
				System.out.println("Fullname: ");
				String name = br.readLine();
				
				System.out.println("Phonenumber: ");
				String phone = br.readLine();
				
				System.out.println("City: ");
				String city = br.readLine();
				
				Student st = new Student(name,phone,city);
				
				System.out.println(st);
				
			} else if(choice == 2) {
				
			} else if(choice == 3 ) {
				
			} else if(choice == 4) {
				
			} else {
				
			}
			System.out.println("The End");
		}
	}

}
