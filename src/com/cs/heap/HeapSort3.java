package com.cs.heap;

import java.util.ArrayList;

public class HeapSort3 {
	public static int[] arr = {3,9,2,4,8,1,7,5,6};
	public static void main(String[] args) {
		ArrayList<Integer> heap = new ArrayList<Integer>();
		for(int i=0; i<arr.length; i++) {
			push(heap,arr[i]);
		}
		System.out.println("만들어진 최대힙 ");
		for(int e:heap) {
			System.out.print(e+" ");
		}
		System.out.println();
	}
	
	public static boolean isChildBigger(int child, int parent) {
		if(child>parent) {
			return true;
		}
		return false;
	}
	
	public static void swap(ArrayList<Integer> heap, int parentIdx, int childIdx) {
		int tmp = heap.get(parentIdx);
		heap.remove(parentIdx);
		heap.add(parentIdx, heap.get(childIdx));
		heap.remove(childIdx);
		heap.add(childIdx, tmp);
	}
	
	public static void push(ArrayList<Integer> heap, int new_value) {
		// 힙의 맨 끝에 new Value를 삽입한다.
		heap.add(new_value);
		int cur_idx = heap.size()-1; // 현재 new Value의 위치
		// root노드에 도달하거나, new_value 보다큰 부모를 만날때까지 반복. 
		while(cur_idx > 0 && heap.get((cur_idx-1)/2) < heap.get(cur_idx)) { 
			swap(heap, cur_idx, (cur_idx-1)/2); // 자식이 더 클경우, 자식이 부모자리로 올라감. 
			cur_idx = (cur_idx-1)/2; // 부모를 가리키게 함.
		}
	}
	
	public static void pop(ArrayList<Integer> heap) {
		// 힙의 맨 끝에서 값을 가져와서 루트자리에 덮어 씌운다. 
		heap.add(0,heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		int here = 0;
		while(true) {
			int left = here*2 + 1;
			int right = here*2 + 2;
			// 리프에 도달한 경우 
			if(left >= heap.size()) {
				break;
			}
			// heap[here] 가 내려갈 위치를 찾는다. 
			int next = here;
			if(heap.get(next) < heap.get(left)) {
				next = left;
			}
			if(right<heap.size() && heap.get(next) < heap.get(right)) {
				next = right;
			}
			if(next == here) break;
			swap(heap, heap.get(here), heap.get(next));
			here = next;
		}
	}
	
	public static void printHeap(ArrayList<Integer> heap) {
		for(int e:heap) {
			System.out.print(e+" ");
		}
		System.out.println();
		System.out.println("========");
	}
	
	
	
}
