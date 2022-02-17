package com.cs.heap;

public class HeapSort_Top_down_재귀방식 {

	public static void main(String[] args) {
		int[] arr = {3,7,5,4,2,8}; //정렬되지 않은 배열 
		int N = arr.length; // 10개 
		
		System.out.println("원본 배열 ");
		for(int a:arr) {
			System.out.print(a+" ");
		}
		System.out.println();
		
		System.out.println("정렬된 배열 ");
		heapsort(arr);
		for(int a:arr) {
			System.out.print(a+" ");
		}
		System.out.println();
	}
	
	public static void heapsort(int[] arr) {
		int N = arr.length;
		
		// 가장 마지막 노드의 부모노드 인덱스 
		int parentIdx = getParent(N-1);
		
		// max heap 생성 
		for(int i=parentIdx ; i>=0 ; i--) {
			heapify(arr, i, N-1); //부모노드를 1씩줄이면서 최대힙을 구성하도록 재구성. 
		}
		
		// 정렬 과정 
		for(int i=N-1; i>0; i--) {
			swap2(arr, 0, i); // root노드와, 정렬되지 않은 맨뒤의 원소와 자리 바꿈. 
			heapify(arr,0,i-1);
		}
		
	}
	
	public static void heapify(int[] arr, int parentIdx, int lastIdx) {
		//현재 트리에서 부모노드의 자식노드 인덱스를 각각 구해준다.
		//현재 부모인덱스를 가장큰 값을 갖고있다고 가정한다. 
		int leftChildIdx = 2*parentIdx + 1;
		int rightChildIdx = 2*parentIdx + 2;
		int largestIdx = parentIdx;
		
		// left Child 노드와 비교 
		// 자식노드 인덱스가 끝의 원소 인덱스를 넘어가지 않으면서, 
		// 현재 가장 큰 인덱스보다 왼쪽자식노드 값이 더 클경우 
		// 가장큰 인덱스를 가리키는 largestIdx를 왼쪽자식노드 인덱스로 바꿔준다. 
		
		if(leftChildIdx <= lastIdx && arr[largestIdx] < arr[leftChildIdx]) {
			largestIdx = leftChildIdx;
		}
		
		// right Child 노드와 비교 
		// 자식노드 인덱스가 끝의원소 인덱스를 넘어가지 않으면서, 
		// 현재 가장 큰 인덱스보다 오른쪽자식노드의 값이 더 클경우 
		// 가장 큰 인덱스를 가리키는 largestIdx를 오른쪽 자식노드 인덱스로 바꿔준다.
		if(rightChildIdx <= lastIdx && arr[largestIdx]<arr[rightChildIdx]) {
			largestIdx = rightChildIdx;
		}
		
		// largestIdx와 부모노드가 같지 않다는 것은, 
		// 위에서 한 자식노드 비교과정에서 현재 부모노드보다 큰 노드가 존재한다는 뜻이다. 
		// 그럴경우 해당자식노드와 부모노드를 교환해주고, 
		// 교환 된 자식노드를 부모노드로 삼은 서브트리를 검사하도록 재귀호출 한다. 
		if(parentIdx != largestIdx) {
			swap(arr, largestIdx, parentIdx);
			heapify(arr, largestIdx, lastIdx);
		}
	}
	
	// 부모인덱스를 얻는 함수 
	public static int getParent(int child) {
		return (child-1)/2;
	}
	// 두 인덱스의 원소를 교환하는 함수. 
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i]=arr[j];
		arr[j] = tmp;
	}
	
	public static void swap2(int[] arr, int a, int b) {
		arr[a] = arr[a]^arr[b];
		arr[b] = arr[a]^arr[b];
		arr[a] = arr[a]^arr[b];
	}
}
