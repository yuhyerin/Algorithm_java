package com.cs.sort;

public class QuickSort2 {
	
	public static void main(String[] args) {
		
	}
	
	private static void quickSort(int[] arr, int l, int r) {
		if(l<r) {
			int p = partition(arr,l,r);
			quickSort(arr,l,p-1);
			quickSort(arr,l,p+1);
		}
	}
	
	private static int partition(int[] arr, int l, int r) {
		int pivot = arr[r]; // 맨 오른쪽원소를 피봇으로 잡음. 
		int i=(l-1);
		for(int j=l; j<= r-1; j++) {
			if(arr[j]<=pivot) {
				i++;
				swap(arr,i,j);
			}
		}//end for
		swap(arr, i+1, r); // i+1과 피봇위치를 교환.
		return i+1; // 피봇의 인덱스를 리턴.
	}
	
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i]= arr[j];
		arr[j]= tmp;
	}

}
