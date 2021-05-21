package com.cs.copy.shallow.deep;

public class Baby implements Cloneable{
	String name;
	int age;
	
	Baby(String name, int age){
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Baby [name=" + name + ", age=" + age + "]";
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
