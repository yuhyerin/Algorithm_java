package com.cs.sort;

public class SelectionSort {
	public static void main(String[] args) {
		int[] arr = {7,5,1,6,3,2,4};
		SelectionSort s = new SelectionSort();
		s.sort(arr);
		System.out.println("선택정렬 후");
		for(int a:arr) {
			System.out.print(a+" ");
		}
		System.out.println();
	}
	
	public void sort(int[] arr) {
		// i번째 위치에 와야할 원소를 찾아서 넣는다. 
		int n = arr.length;
		for(int i=0; i<n-1; i++) {
			int min_idx = i;
			for(int j=i+1; j<n; j++) {
				if(arr[min_idx]>arr[j]) {
					min_idx = j;
				}
			}
			swap(arr,min_idx,i); 
		}// end for
	}
	
	public void swap(int[] arr, int a_idx, int b_idx) {
		int tmp = arr[a_idx];
		arr[a_idx] = arr[b_idx];
		arr[b_idx] = tmp;
	}
}
