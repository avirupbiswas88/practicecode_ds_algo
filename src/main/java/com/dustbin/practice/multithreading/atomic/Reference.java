package com.dustbin.practice.multithreading.atomic;

import java.util.concurrent.atomic.AtomicReference;

public class Reference {

	public static void main(String[] args) {
		
		String name = "Avirup";
		String petName = "Buro";
		
		AtomicReference<String> atomicReference = new AtomicReference<>(petName);
		System.out.println(atomicReference.get());
		
		if(atomicReference.compareAndSet(petName, name)) {
			System.out.println(atomicReference.get());
		}

	}

}
