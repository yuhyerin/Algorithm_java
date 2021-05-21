package com.cs.sort;

public class BubbleSort {

	public static void main(String[] args) {
		//int[] arr = {1,7,5,6,3,2,4};
		int[] arr = randomArray();
		BubbleSort b = new BubbleSort();
		b.sort(arr);
		System.out.println("버블정렬 후");
		for(int a:arr) {
			System.out.print(a+" ");
		}
		System.out.println();
	}
	
	public int[] sort(int[] arr) {
		int N = arr.length;
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<N-2-i;j++) {
				if(arr[j]>arr[j+1]) {
					swap(arr,j,j+1);
				}
			}
		}
		return arr;
	}
	
	public void swap(int[] arr, int a_idx, int b_idx) {
		int tmp = arr[a_idx];
		arr[a_idx] = arr[b_idx];
		arr[b_idx] = tmp;
	}
	
	public void printArr(int[] arr) {
		for(int a: arr) {
			System.out.print(a+" ");
		}
		System.out.println();
	}
	
	private static int[] randomArray(){
        int[] arr = new int[10];
        for(int i = 0; i < 10; i++){
            arr[i] = (int)(Math.random() * 30);
        }
        return arr;
    }
}
