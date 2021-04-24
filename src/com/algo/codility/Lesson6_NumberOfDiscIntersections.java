package com.algo.codility;

import java.util.Arrays;

public class Lesson6_NumberOfDiscIntersections {
	public static void main(String[] args) {
		int[] A = {1,5,2,1,4,0}; // 11을 반환해야 함. 
		int result = solution(A);
		System.out.println(result);
	}
	public static int solution(int[] A) {
        // write your code in Java SE 8
		// N개의 디스크를 그린다.
		// 디스크에는 0~N-1 번호가 매겨진다.
		// 디스크의 반경을 지정하는 음이 아닌 정수 N 개의 배열 A가 제공된다. A[J] = K (반지름) J!=K 
		// N: 0~100,000 , 각 요소는 0~2147483647 
		// J번째 디스크의 중심이 (J,0) 
		// 교차하는 디스크의 쌍 수를 반환해라. 10,000,000개를 초과하면 -1을 반환해라. 
		
		int N = A.length;
		long[] lower = new long[N];
		long[] upper = new long[N];
		
		for(int i=0; i<N; i++) {
			lower[i] = i-(long)A[i];
			upper[i] = i+(long)A[i];
			System.out.println(i+"] lower: "+lower[i]+", upper: "+upper[i]);
		}
		
		Arrays.sort(lower);
		Arrays.sort(upper);
		System.out.println("=== 정렬후 === ");
		for(int i=0; i<N; i++) {
			System.out.println(i+"] lower: "+lower[i]+", upper: "+upper[i]);
		}
		
		int intersection = 0; // number of intersections
		int j=0; // lower point
		
		// scan the upper point
		for(int i=0; i<N; i++) {// i는 오른쪽점, j는 왼쪽점을 나타내는 인덱스. 
			System.out.println("오른쪽점 위치: "+i);
			while(j < N && upper[i] >= lower[j]) {
				System.out.print("  왼쪽점 위치: "+j+"    ");
				System.out.println(j+" 더한다!");
				intersection = intersection + j; // add j intersections
				intersection = intersection - i; // minus "i" (avoid double count) 
				j++;
			}
			System.out.println("============");
		}
		
		if(intersection > 10000000) {
			return -1;
		}
		
		return intersection;
    }
}
