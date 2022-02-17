package com.cs.copy.shallow.deep;

public class 깊은복사테스트 {
	public static void main(String[] args) {
		B b1,b2=null;
		b1 = new B(10, new int[] {1,2,3});
		try {
			b2 = b1.copy();
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		b1.i = 99;
		b1.arr[0] = 99;
		
		System.out.println(b1.i);
		System.out.println(b2.i);
		
		System.out.println("====");
		
		System.out.println(b1.arr[0]);
		System.out.println(b2.arr[0]);
	}
}
