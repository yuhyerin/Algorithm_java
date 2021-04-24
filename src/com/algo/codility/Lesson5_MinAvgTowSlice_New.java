package com.algo.codility;

public class Lesson5_MinAvgTowSlice_New {
	public static void main(String[] args) {
		int[] A = { 4, 2, 2, 5, 1, 5, 8 };
		int result = solution(A);
		System.out.println(result);
	}

	public static int solution(int[] A) {
		// 비어있지 않은 배열, N 개의 정수로 구성된 A (N: 2~100,000), 배열의요소 (-10,000~10,000)
		// 0 <= P < Q < N 인 정수쌍 (P,Q) 을 배열A의 슬라이스라고 한다.
		// 슬라이스에 최소 2개의 요소가 포함되어 있음.
		// 슬라이스의 평균은 A[P]+A[P+1]+...+A[Q]/ 슬라이스길이
		// 평균이 최소값인 슬라이스의 시작위치를 리턴하세요!!!
		// 7 (0,1) (0,2) (0,3) (0,4) (0,5) (0,6) (1,2) (2,3) ... (5,6) // 7C2 ??
		int N = A.length;
		double min_avg = (A[0]+A[1])/2.0;
		int min_idx = 0;
		for(int i=0; i<N-2; i++) {
			double avg = (A[i]+A[i+1]+A[i+2])/3.0;
			if(avg < min_avg) {
				min_avg = avg;
				min_idx = i;
			}
			
			avg = (A[i+1]+A[i+2])/2.0;
			if(avg < min_avg) {
				min_avg = avg;
				min_idx = i+1;
			}
			
		}
		
		return min_idx;
	}
}
