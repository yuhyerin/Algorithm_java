package com.cs.sort;

public class MergeSort {
	public static void main(String[] args) {
		int[] arr = {5,4,3,2,1};
		int len = arr.length;
		// 쪼개는 작업, 합치는 작업 , 얘가 빠르긴함. O(nlogn) . 근데 원본배열, 복사배열 써서 메모리가 2배들음.
		divide(arr,0,len-1);
		
	}
	
	public static void merge(int[] arr,int l, int m, int r){
		int leftCnt = m-l+1;
		int rightCnt = r-m;
		
		int[] L = new int[leftCnt];
		int[] R = new int[rightCnt];
		
		for(int i=0; i<leftCnt; i++) {
			L[i] = arr[l+i];
		}
		for(int i=0; i<rightCnt; i++) {
			R[i] = arr[m+1+i];
		}
		
		int k = l; //  k가 원본배열 쓸곳 위치 
		
		int i=0, j=0;// i는 완쪽배열 가리키는애, j는 오른쪽배열 가리키는애 
		//
		while(i<leftCnt && j < rightCnt) {
			if(L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			}else {
				arr[k]=R[j];
				j++;
			}
			k++;
		}// end while
		
		
		
	}
	
	public static void divide(int arr[], int l, int r) {
		if(l<r) {
			int m = l+ (r-l)/2; // 중간 인덱스 
			
			divide(arr,l,m);//왼쪽반절 
			divide(arr,m+1, r); //오른쪽반절 
			
			merge(arr,l,m,r);
			
		}
	}
}
