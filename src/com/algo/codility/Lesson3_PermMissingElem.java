package com.algo.codility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Lesson3_PermMissingElem {
	public static void main(String[] args) {
		int[] A = {2,3,1,5};
		int result = solution(A);
		System.out.println("정답 : "+result);
	}

	public static int solution(int[] A) {
		// write your code in Java SE 8
		// N개의 정수로 구성된 배열 A
		// 배열은 1~N+1 범위의 정수가 포함되어 있는데, 누락된 요소 한개를 찾아서 반환
		int N = A.length; // 4 
		if(N>0) {
			Set<Integer> set = new HashSet<Integer>();
			for (int i = 0; i < N ; i++) {
				set.add(A[i]);
			}
			ArrayList<Integer> list = new ArrayList(set);
			Collections.sort(list);
			for (int i = 0; i < N; i++) {
				if (list.get(i) != (i+1)) {
					return i+1;
				}
			}
			return N+1;
		}
		return 1;
	}

}
