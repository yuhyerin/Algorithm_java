package com.algo.codility;

import java.util.Arrays;

public class Lesson6_NumberOfDiscIntersections_hyerin {
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
		int cnt = 0;
        int[] left = new int[N];
        int[] right = new int[N];
        
        for(int i=0; i<N; i++){
            left[i] = i-A[i];
            right[i] = i+A[i];
        }
        
        Arrays.sort(left);
        Arrays.sort(right);
        int l=0;
        for(int r=0; r<N; r++){
        	System.out.println("r: "+r);
        	l=0;
            while(l<N) {
            	if(left[l]<=right[r] && right[l]<=right[r]) {
            		cnt++;
            	}
            	l++;
            }
        }
        System.out.println(cnt);
        if(cnt>10000000){
            return -1;
        }

        return cnt;
    }
}
