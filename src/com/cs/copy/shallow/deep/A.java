package com.cs.copy.shallow.deep;

public class A implements Cloneable {
		int i;
		int[] arr;
		String name;

		A(int i, int[] arr,String name) {
			this.i = i;
			this.arr = arr;
			this.name = name;
		}

		A copy() throws CloneNotSupportedException {
			return (A) clone();
		}
	}