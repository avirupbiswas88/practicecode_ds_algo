package com.dustbin.practice.performance;

import java.util.*;

import com.dustbin.practice.memoryandgc.Customer;
public class ArrayListImpl {

	public static void main(String[] args) {
		
		//initialing arraylist with a value other than default size 10
		List<Customer> customers = new ArrayList<>(1000000);
		
		Date start = new Date();
		for(int i=0;i<1000000;i++) {
			customers.add(new Customer("Buro",32));
		}
		Date end = new Date();
		System.out.println("elapsed time- "+(end.getTime() - start.getTime())+"ms.");
	}

}
