package com.cs.sort;

public class QuickSort {
	public static void main(String[] args) {
		//            0  1  2  3  4  5
		int[] arr = {10, 7, 8, 9, 1, 5};
		int n = arr.length;
		QuickSort.sort(arr, 0, n-1);
		printArr(arr);
	}
	
	public static void sort(int[] arr, int low, int high) {
		if(low >= high) return;
		int mid = partition(arr, low, high);
		sort(arr, low, mid-1);
		sort(arr,mid,high);
	}
	
	public static int partition(int[] arr, int i, int j) {
		int pivot = arr[(i+j)/2]; // 가운데값을 피봇으로 설정
		
		while(i <= j) { // 엇갈릴때까지 반복 
			while(arr[i]<pivot) i++;
			while(arr[j]>pivot) j--;
			if(i<=j) {
				swap(arr,i,j);
				i++;
				j--;
			}
		}
		return i;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i]= arr[j];
		arr[j]= tmp;
	}
	
	public static void printArr(int[] arr) {
		for(int a:arr) {
			System.out.print(a+" ");
		}
		System.out.println();
	}
}
