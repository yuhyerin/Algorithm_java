package com.cs.copy.shallow.deep;

public class cloneTest2 {
	public static void main(String[] args) {
		int[] original_arr = new int[5];
		int[] deep_copy_arr = original_arr.clone();
		int[] shallow_copy_arr = original_arr;
		original_arr[0]=999;
		printArr(original_arr);
		System.out.println();
		printArr(deep_copy_arr);
		System.out.println();
		printArr(shallow_copy_arr);
	}
	
	public static void printArr(int[] arr) {
		for(int a:arr) {
			System.out.print(a+" ");
		}
		System.out.println();
	}
}
