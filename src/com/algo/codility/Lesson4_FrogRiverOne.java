package com.algo.codility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Lesson4_FrogRiverOne {
	public static void main(String[] args) {
		int X = 5;
		int[] A = { 1, 3, 1, 4, 2, 3, 5, 4 }; // 7(8-1)초간 잎이 떨어짐.
		int result = solution(X, A);
		System.out.println(result);
	}

	public static int solution(int X, int[] A) {
		// 개구리가 건너가려고 함.
		// 위치0 에서 출발 --> 반대쪽 X+1 에 도달
		// N : 낙엽 갯수 // N,X : 1~100,000
		// A[K] : 시간 K에서 한 잎이 떨어지는 위치를 나타낸다.
		// 개구리가 강 건너편으로 점프할 수 있는 가장 빠른 시간 리턴.
		// 잎 1~X 까지. 강의 흐름속도는 무시. 잎이 강에 떨어지면 위치바뀌지 X

		HashSet<Integer> set = new HashSet<Integer>();
		for (int a : A) {
			set.add(a);
		}
		ArrayList<Integer> list = new ArrayList<Integer>(set);
		Collections.sort(list);
		for (int i = 1; i < X; i++) {
			if (list.get(i - 1) != i) {
				return -1;
			}
		}

		int N = A.length; // 8
		boolean[] check = new boolean[100002];
		int frog = 0;
		int time = 0;
		while (time < N) {
			check[A[time]] = true; // 잎이 떨어짐.
			while (true) {
				if (check[frog + 1]) { // 개구리 앞으로 갈수있음?
					frog++; // 개구리 전진
				} else {
					break;
				}
			}
			if (frog == X) {// 개구리 도착?
				return time;
			}
			time++; // 시간흐름
		}
		return -1;
	}

}
