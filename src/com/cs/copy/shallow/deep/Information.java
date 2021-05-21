package com.cs.copy.shallow.deep;

// 깊은복사를 위해 Cloneable 인터페이스를 구현하고, clone 메소드를 오버라이드 한다. 
public class Information implements Cloneable{
	int height; 
	int weight;
	
	@Override
	public String toString() {
		return "Information [height=" + height + ", weight=" + weight + "]";
	}

	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}
