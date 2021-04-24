package com.algo.codility;

import java.util.Arrays;

public class Lesson6_MaxProductOfThree {
	public static void main(String[] args) {
		int[] A = { -3, 1, 2, -2, 5, 6 }; // N = 6
		int result = solution(A);
		System.out.println(result);
	}

	public static int solution(int[] A) {
		// write your code in Java SE 8
		// 비어있지 않은 배열 A
		// 삼중항 ( P,Q,R )의 곱 = A[P]*A[Q]*A[R]
		// 삼중항의 최대곱을 찾는것입니다!!!
		int N = A.length; // N : 3~100,000 , 각 요소는 -1000~1000 정수.
		Arrays.sort(A);
		// (- - -) (+ + +)
		int gop1 = A[N-1]*A[N-2]*A[N-3];
		// (- - +)
		int gop2 = A[0]*A[1]*A[N-1];
		// 나머지 
		int gop3 = A[0]*A[1]*A[2];
		int max = gop1;
		if(max<gop2) {
			max = gop2;
		}
		if(max<gop3) {
			max=gop3;
		}
		
		return max;
	}

}
