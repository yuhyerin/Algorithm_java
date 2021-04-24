package com.algo.codility;

public class Lesson4_MaxCounters {
	public static void main(String[] args) {
		int[] A = { 3, 4, 4, 6, 1, 4, 4 };
//		int[] A = {2,1,1,2,1};
		int N = 5;
		int[] result = solution(N, A);
		for (int r : result) {
			System.out.print(r + " ");
		}
		System.out.println();
	}

	public static int[] solution(int N, int[] A) {
		// write your code in Java SE 8
		// 처음에 0 으로 채워진 N개의 카운터 제공. 2가지 기능 존재.
		// 1. 카운터 X가 1씩 증가.
		// 2. 모든 카운터를 모든 카운터의 최대값으로 설정한다.
		// N : 1..100,000
		// A의 원소는 1~N+1
		int[] result = new int[N]; // 5
		int maxVal = 0;
		int tmpVal = 0;
		for (int a : A) {
			if (a == N + 1) {
				maxVal = tmpVal;
			} else {
				if (result[a - 1] < maxVal) {
					result[a - 1] = maxVal;
				}
				result[a - 1]++;
				if (result[a - 1] > tmpVal) {
					tmpVal = result[a - 1];
				}
			}
		}// end for
		if(maxVal > 0) {
			for(int i=0; i<N; i++) {
				if(result[i]< maxVal) {
					result[i] = maxVal;
				}
			}
		}
		return result;
	}

	public static void printArray(int[] result) {
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
	}
}
