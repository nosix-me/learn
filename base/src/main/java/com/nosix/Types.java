package com.nosix;

public enum Types {
	
	One("one","1"),
	Two("Two","2");
	
	private String name;
	private String  age;
	
	private Types(String name, String age) {
		this.name = name;
		this.age = age;
	}
}
