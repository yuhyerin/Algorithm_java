package com.algo.codility;

public class Lesson4_MissingInteger {
	public static void main(String[] args) {
		int[] A = {1, 3, 6, 4, 1, 2};
		int result = solution(A);
		System.out.println(result);
	}

	public static int solution(int[] A) {
		// N개의 정수 배열 A 가 주어지면 A에 없는 가장 작은 양의정수를 리턴 
		// A의 요소값은 −1,000,000 .. 1,000,000
		// N 은 1~ 100,000
		int MAX = 1000000;
		boolean isAllMinusVal = true;
		boolean[] check = new boolean[MAX+1];
		for(int a:A) {
			if(a>0) {
				check[a]=true;	
				isAllMinusVal=false;
			}
		}
		if(isAllMinusVal) {
			return 1;
		}
		for(int i=1; i<=MAX; i++) {
			if(!check[i]) {
				return i;
			}
		}
		return MAX;
    }
}
