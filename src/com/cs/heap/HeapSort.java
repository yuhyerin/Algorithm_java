package com.cs.heap;

public class HeapSort {
	public static void main(String[] args) {
		int[] arr = {3,7,5,4,2,8};
		int N = arr.length;
		
		heapsort(arr);
		
		System.out.println("힙정렬된 arr");
		for(int a:arr) {
			System.out.print(a+" ");
		}
	}

	public static void swap(int[] arr, int a, int b) {
		arr[a] = arr[a]^arr[b];
		arr[b] = arr[a]^arr[b];
		arr[a] = arr[a]^arr[b];
	}
	
	public static int getParentIdx(int childIdx) {
		return (childIdx-1)/2;
	}
	
	private static void heapsort(int[] arr) {
		int N = arr.length;
		int parentIdx = getParentIdx(N-1); // 가장 마지막 노드의 부모노드 인덱스 
		// max heap 생성 
		for(int i=parentIdx; i>=0 ;i--) {
			heapify(arr,i,N-1);
		}
		// 정렬
		for(int i=N-1; i>0; i--) {
			swap(arr,0,i); // root노드랑 정렬되지 않은 맨뒤 원소와 스왑. 
			heapify(arr,0,i-1); // i번째까지 정렬된거고, i-1번째까지 다시 max heap 구성.
		}
	}

	private static void heapify(int[] arr, int parentIdx, int lastIdx) {
		int leftChildIdx = 2*parentIdx + 1;
		int rightChildIdx = 2*parentIdx + 2;
		int maxValueIdx = parentIdx; // 현재 가장큰값을 가진 인덱스를 부모로 초기화. 
		
		
		if(leftChildIdx <= lastIdx && arr[maxValueIdx] < arr[leftChildIdx]) {// 왼쪽자식값이 현재 가장큰값가진인덱스의값보다 크면 갱신 
			maxValueIdx = leftChildIdx;
		}
		if(rightChildIdx <= lastIdx && arr[maxValueIdx]<arr[rightChildIdx]) {
			maxValueIdx = rightChildIdx;
		}
		if(parentIdx != maxValueIdx) { // 부모인덱스가 가장큰값가진인덱스가 아니라는건, 부모보다 큰 자식을 발견한 경우.
			swap(arr, maxValueIdx, parentIdx); // 부모랑 자식 위치 바꾸고 
			heapify(arr, maxValueIdx, lastIdx); // 교환된 자식노드를 부모로삼은 서브트리를 재귀호출 
		}
	}
	
}
