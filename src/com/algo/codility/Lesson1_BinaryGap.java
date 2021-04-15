package com.algo.codility;

public class Lesson1_BinaryGap {
	/** 문제 차근차근 읽기 ! */
	public static void main(String[] args) {
		int result = solution(1041);
		System.out.println(result);
	}
	
	static int solution(int N) {
		String binary = Integer.toBinaryString(N);
		int len = binary.length();
		int max = 0;
		int cnt = 0;
		for(int i=0; i<len; i++) {
			if(binary.charAt(i) == '1') {
				if(cnt > max ) {
					max = cnt;
				}
				cnt=0;
			}else {
				cnt++;
			}
		}
		return max;
	}
}
