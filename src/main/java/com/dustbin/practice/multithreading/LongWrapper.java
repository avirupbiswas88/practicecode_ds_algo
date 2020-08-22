package com.dustbin.practice.multithreading;

public class LongWrapper {

	private long value;
	private Object key = new Object();

	public LongWrapper(long l) {
		this.value = l;
	}

	public long getValue() {
		return this.value;
	}

	public void incrementValue() {
		synchronized (key) {
			value = value + 1;
		}
	}

}
