package com.cs.heap;

public class HeapSort2 {
	public static void main(String[] args) {
		int[] arr = { 3, 7, 5, 4, 2, 8 };
		heapSort(arr);
		System.out.println("힙정렬된 arr");
		for (int a : arr) {
			System.out.print(a + " ");
		}
	}

	public static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	public static int getParentIdx(int childIdx) {
		return (childIdx - 1) / 2;
	}

	public static void heapify(int[] arr, int parentIdx, int lastIdx) {
		int leftChildIdx;
		int rightChildIdx;
		int maxValueIdx;

		while (true) {
			if ((parentIdx * 2) + 1 > lastIdx)
				break;

			leftChildIdx = (parentIdx * 2) + 1;
			rightChildIdx = (parentIdx * 2) + 2;
			maxValueIdx = parentIdx;

			if (arr[leftChildIdx] > arr[maxValueIdx]) {
				maxValueIdx = leftChildIdx;
			}
			if (rightChildIdx <= lastIdx && arr[rightChildIdx] > arr[maxValueIdx]) {
				maxValueIdx = rightChildIdx;
			}
			if (maxValueIdx != parentIdx) {
				swap(arr, parentIdx, maxValueIdx);
				parentIdx = maxValueIdx;
			} else {
				return;
			}
		}

	}

	public static void heapSort(int[] arr) {
		int N = arr.length;
		// 가장 마지막노드의 부모노드 인덱스 
		int parentIdx = getParentIdx(N - 1);
		// 최대힙 생성 
		for (int i = parentIdx; i >= 0; i--) {
			heapify(arr, i, N - 1);
		}
		// 정렬
		for (int i = N - 1; i > 0; i--) {
			swap(arr, 0, i); // root노드랑 정렬되지 않은 맨뒤 원소와 스왑.
			heapify(arr, 0, i - 1); // i번째까지 정렬된거고, i-1번째까지 다시 max heap 구성.
		}
	}

}
