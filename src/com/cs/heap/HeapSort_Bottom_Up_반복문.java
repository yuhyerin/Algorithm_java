package com.cs.heap;

public class HeapSort_Bottom_Up_반복문 {
	public static void main(String[] args) {
		int[] arr = { 3, 7, 5, 4, 2, 8 }; // 정렬되지 않은 배열
		int N = arr.length; // 10개

		System.out.println("원본 배열 ");
		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println();

		System.out.println("정렬된 배열 ");
		heapsort(arr);
		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public static void heapsort(int[] arr) {
		int N = arr.length;

		// 가장 마지막 노드의 부모노드 인덱스
		int parentIdx = getParent(N - 1);

		// max heap 생성
		for (int i = parentIdx; i >= 0; i--) {
			heapify(arr, i, N - 1); // 부모노드를 1씩줄이면서 최대힙을 구성하도록 재구성.
		}

		// 정렬 과정
		for (int i = N - 1; i > 0; i--) {
			swap(arr, 0, i); // root노드와, 정렬되지 않은 맨뒤의 원소와 자리 바꿈.
			heapify(arr, 0, i - 1);
		}

	}

	public static void heapify(int[] arr, int parentIdx, int lastIdx) {
		int leftChildIdx;
		int rightChildIdx;
		int largestIdx;

		while ((parentIdx * 2) + 1 <= lastIdx) {
			leftChildIdx = (parentIdx * 2) + 1;
			rightChildIdx = (parentIdx * 2) + 2;
			largestIdx = parentIdx;

			if (arr[leftChildIdx] > arr[largestIdx]) {
				largestIdx = leftChildIdx;
			}

			if (rightChildIdx <= lastIdx && arr[rightChildIdx] > arr[largestIdx]) {
				largestIdx = rightChildIdx;
			}

			if (largestIdx != parentIdx) {
				swap(arr, parentIdx, largestIdx);
				parentIdx = largestIdx;
			} else {
				return;
			}
		}
	}

	// 부모인덱스를 얻는 함수
	public static int getParent(int child) {
		return (child - 1) / 2;
	}

	// 두 인덱스의 원소를 교환하는 함수.
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
