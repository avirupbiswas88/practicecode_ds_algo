package com.dustbin.practice.multithreading;

public class SingletonClass {

	private static volatile SingletonClass instance;

	private SingletonClass() {
	};

	private static Object key = new Object();

	/*
	 * public static synchronized SingletonClass getInstance(){ if(instance == null)
	 * { instance = new SingletonClass(); }
	 * 
	 * return instance; }
	 */

	public static SingletonClass getInstance() {
		if (instance != null) {
			return instance;
		} else {
			synchronized (key) {
				if (instance == null) {
					instance = new SingletonClass();
				}
			}

		}
		return instance;
	}

}
