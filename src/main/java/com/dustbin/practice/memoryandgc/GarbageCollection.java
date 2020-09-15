package com.dustbin.practice.memoryandgc;

import java.util.*;

public class GarbageCollection {

	public static void main(String[] args) {
		
		List<Customer> customers = new ArrayList<>();
		
		while(true) {
			Customer cs = new Customer("Buro",32);
			customers.add(cs);
			
			if(customers.size() > 10000) {
				for(int i=0;i<=5000;i++) {
					customers.remove(0);
				}
			}
		}

	}

}
