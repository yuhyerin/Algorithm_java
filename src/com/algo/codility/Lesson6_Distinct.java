package com.algo.codility;

import java.util.HashSet;
import java.util.Set;

public class Lesson6_Distinct {

	public static void main(String[] args) {
		int[] A = {2,1,1,2,3,1};
		int result = solution(A);
		System.out.println(result);
	}
	public static int solution(int[] A) {
        // write your code in Java SE 8
		// N개의 정수로 구성된 배열 A
		// 고유값 갯수를 리턴. 
		Set<Integer> set = new HashSet<Integer>();
		for(int a:A) {
			set.add(a);
		}
		return set.size();
    }
}
