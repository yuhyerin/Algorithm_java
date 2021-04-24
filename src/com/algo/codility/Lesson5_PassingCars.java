package com.algo.codility;

public class Lesson5_PassingCars {
	public static void main(String[] args) {
		int[] A = {0,1,0,1,1};
		int result = solution(A);
		System.out.println(result);
	}
	public static int solution(int[] A) {
        // N 개의 정수, 비어있지 않은 배열 A. ( 1<= N <= 100,000 )  // N^2 = 10,000,000,000
		// A의 연속요소는 도로의 연속 자동차를 나타낸다. ( A의 요소는 0 or 1 포함 )
		// 지나가는 차를 세는것. P가 동쪽으로 이동하고--> Q가 서쪽으로 이동할때 <-- 
		// 0<= P < Q < N 인 한쌍의 자동차 (P,Q) 가 있다고 하자.
		// A = { 0,1,0,1,1 }
		// (0,1) (0,3) (0,4) (2,3) (2,4) 5쌍의 추월 차가 있다. 5반환. 
		// 지나가는 자동차쌍의 수를 반환한다. 1,000,000,000 개를 초과하면 -1을 반환하세요. 
		int N = A.length;
		int oneCnt = 0;
		int cumulativeSum = 0;
		for(int i=N-1; i>=0; i--) {
			if(A[i]==1) {
				oneCnt++;
			}
			if(A[i]==0) {
				cumulativeSum+=oneCnt;
			}
			if(cumulativeSum>1000000000) {
				return -1;
			}
		}
		
		
		return cumulativeSum;
    }
}
