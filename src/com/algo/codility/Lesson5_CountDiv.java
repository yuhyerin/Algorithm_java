package com.algo.codility;

public class Lesson5_CountDiv {
	public static void main(String[] args) {
		int A=100,B=120,K=2;
		int result = solution(A,B,K);
		System.out.println(result);
	}
	public static int solution(int A, int B, int K) {
        // write your code in Java SE 8
		// 3개의 정수 A,B,K 
		// A~B 범위 내에서 K로 나눌 수 있는 정수의 갯수를 반환.
		// 6~11 => 6,8,10 => 정답:3 
		// A,B : 0~2,000,000,000
		// K : 1~2,000,000,000
		// A <= B 
		
		if(A==0) {
			return B/K + 1 ;
		}else {
			return (B/K+1) - ((A-1)/K+1) ;
		}
    }

}
