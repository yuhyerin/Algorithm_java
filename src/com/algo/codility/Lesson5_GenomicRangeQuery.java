package com.algo.codility;

import java.util.HashMap;
import java.util.Map;

public class Lesson5_GenomicRangeQuery {

	public static void main(String[] args) {
		// A C G T
		// 1 2 3 4
		// S는 인덱스 0부터.
//		String S = "CAGCCTA"; // N = 7 (1~100,000)
		String S = "AC"; // N = 7 (1~100,000)
//		int[] P = { 2, 5, 0 }; // M = 3 (1~50,000)
		int[] P = { 0,0,1}; // M = 3 (1~50,000)
//		int[] Q = { 4, 5, 6 };
		int[] Q = { 0,1,1};
		int[] result = solution(S, P, Q); // { 2, 4, 1 }
		for (int r : result) {
			System.out.print(r + " ");
		}
		System.out.println();
	}

	public static int[] solution(String S, int[] P, int[] Q) {
		// DNA 서열은 A,C,G,T 로 이루어져있음.
		// 1, 2, 3, 4 영향계수를 갖는다.
		// S : 길이 N 비어있지 않은 문자열. ( N: 1~100,000 )
		// P,Q : 비어있지 않은 배열. 각각 M개의 정수로 구성. ( M : 1~50,000)
		// P[K] ~ Q[K] 사이의 DNA 시퀀스에 포함된 뉴클레오타이드의 최소영향계수 찾기.

		int N = S.length();// 문자열 길이 N
		char[] charArr = S.toCharArray();
		int M = P.length; // 배열길이 M
		int[] result = new int[M]; // 정답길이 M

		int[] A = new int[N + 1];
		int[] C = new int[N + 1];
		int[] G = new int[N + 1];
		int[] T = new int[N + 1];

		// 영향계수
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('A', 1);
		map.put('C', 2);
		map.put('G', 3);
		map.put('T', 4);

		for (int i = 0; i < N; i++) {
			if (charArr[i] == 'A') {
				A[i+1]++;
			} else if (charArr[i] == 'C') {
				C[i+1]++;
			} else if (charArr[i] == 'G') {
				G[i+1]++;
			} else {
				T[i+1]++;
			}
			A[i + 1] += A[i];
			C[i + 1] += C[i];
			G[i + 1] += G[i];
			T[i + 1] += T[i];
		}

		for (int i = 0; i < M; i++) {
			int start = P[i];
			int end = Q[i];
			if (start == end) {
				result[i] = map.get(charArr[start]);
			} else {
				// 우선순위때문에 if-else if문 사용. A먼저 검사 ->그다음 C, G, T 
				if (A[start] != A[end+1]) {
					result[i] = map.get('A');
				} else if (C[start] != C[end]) {
					result[i] = map.get('C');
				} else if (G[start] != G[end]) {
					result[i] = map.get('G');
				} else if (T[start] != T[end]) {
					result[i] = map.get('T');
				}

			}
		}

		return result;
	}
}
