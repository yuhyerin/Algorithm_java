package com.cs.copy.shallow.deep;

public class B implements Cloneable{
	int i;
	int[] arr;
	
	B(int i){
		this.i = i;
	}
	
	B(int i, int[] arr){
		this.i=i;
		this.arr = arr;
	}
	
	B copy() throws CloneNotSupportedException{
		B copyObj = (B)clone();
		int[] copyArr = (int[])this.arr.clone();
		copyObj.arr = copyArr;
		return copyObj;
	}
	
}
