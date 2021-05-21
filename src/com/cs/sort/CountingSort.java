package com.cs.sort;

public class CountingSort {

	// DAT : Direct Address Table
	
	public static void main(String[] args) {
		int[] arr = {1,7,5,6,3,2,4};
		CountingSort s = new CountingSort(); // 중복된 수가 많으면서 원소가 많을때 유용한 정렬.
		s.sort(arr);
		System.out.println("선택정렬 후");
		for(int a:arr) {
			System.out.print(a+" ");
		}
		System.out.println();
	}
	
	public void sort(int[] arr) {
		
	}
	
	public void swap(int[] arr, int a_idx, int b_idx) {
		int tmp = arr[a_idx];
		arr[a_idx] = arr[b_idx];
		arr[b_idx] = tmp;
	}

}
