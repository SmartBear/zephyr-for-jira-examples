package com.adaptavist.tm4j.cucumberExample.counter;

public class Counter {
	
	private int size = 0;
	
	public void count(String text) {
		size = text.length();
	}
	
	public int getSize() {
		return size;
	}
}
