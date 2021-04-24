package com.algo.codility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lesson4_PermCheck {
	public static void main(String[] args) {
		int[] A = {1, 1};
		int result = solution(A);
		System.out.println(result);
	}

	public static int solution(int[] A) {
		// N개의 정수로 구성된 배열 A ( 중복O )
		// 1~N 까지의 요소를 포함해야 순열임. 하나라도 없으면 순열이 아님.
		// 순열이면 ->1반환, 아니면 ->0 반환.
		// N : 1~100,000
		// A의 요소는 : 1~1,000,000,000
		int N = A.length; // 2 
		Set<Integer> set = new HashSet<Integer>();
		for (int a : A) { //중복 제거 
			set.add(a);
		}
		List<Integer> list = new ArrayList<Integer>(set);
		Collections.sort(list); //정렬
		if(list.size()!=N) {
			return 0;
		}
		for(int i=1; i<= N; i++) {
			if(list.get(i-1)!=i) {
				return 0;
			}
		}
		return 1;
		
	}
}
