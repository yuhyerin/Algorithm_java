package com.algo.codility;

import java.util.ArrayList;
import java.util.List;

public class Lesson3_TapeEquilibrium {
	public static void main(String[] args) {
		int[] A = { 100, -100 };
//		int[] A ={3,1,2,4,3};
		
		int result = solution(A);
		System.out.println(result);
	}

	// N개의 정수로 구성된 비어있지 않은 배열 A
	// 0 < P < N 인 정수 P는 두부분으로 분할한다.
	// A[0]~A[P-1] / A[P]~A[N-1]
	// | 앞에덩어리합 - 뒤에덩어리합 | 절댓값이 최소인 P를 리턴한다.
	// A= {3,1,2,4,3} 이면 P=3 일때 | (3+1+2) - (4+3) | = 1
	// N 은 2~100,000
	// 각 요소는 - 1000 ~ 1000 정수.

	public static int solution(int[] A) {
		int N = A.length;
		int min = Integer.MAX_VALUE;
		int totalSum = 0;
		int leftSum = 0;
		int rightSum= 0;
		for(int a : A) {
			totalSum += a;
		}
		if (N > 2) {
			List<Integer> sumList = new ArrayList<Integer>();
			for(int i=0; i<N-1; i++) {
				leftSum += A[i];
				rightSum = totalSum - leftSum;
				if(min > Math.abs(leftSum - rightSum)) {
					min = Math.abs(leftSum - rightSum);
				}
			}
		}else {
			return Math.abs(A[0]-A[1]);
		}
		return min;
	}

}
