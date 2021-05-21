package com.cs.sort;

public class InsertionSort {
	public static void main(String[] args) {
		// 정렬된부분, 정렬안된부분 으로 나눔. 
		//(0번은정렬됬다고 가정)
	}
	
	public static void sort(int[] arr) {
		int n = arr.length;
		for(int i=1; i<n; i++) {
			int key = arr[i]; // i번째 애가 어디로 가야되나?
			int j = i-1; // 정렬된애들중에 젤 마지막원소 
			while(j>=0 && arr[j]>key) { // i번째보다 앞에애가 크면 
				arr[j+1]=arr[j]; //걔를 뒤로 밀어. 
				j--;
			}
			// 뒤로밀다가 이제 내가 더 크면 그자리에 i번째애가 정착하면됨.
			arr[j+1]=key;
		}
	}
	
}
