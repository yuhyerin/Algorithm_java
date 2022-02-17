package com.cs.copy.shallow.deep;

public class 기본형배열clone복사 {
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5};
		int[] copyarr = arr.clone();
		arr[0]=999;
		for(int a:arr) {
			System.out.print(a+" ");
		}
		System.out.println();
		// 영향 주지 않음. 
		for(int a: copyarr) {
			System.out.print(a+" ");
		}
	}
}
