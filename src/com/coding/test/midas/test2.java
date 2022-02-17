package com.coding.test.midas;

import java.util.ArrayList;

public class test2 {

	public static void main(String[] args) {
		test2 t = new test2();
		int n = 10; // 학생수 (1~10,000)
		int[] v1 = { 1, 10, 6, 5, 6, 9 }; // 팀1
		int[] v2 = { 3, 7, 2, 8, 7, 3 }; // 팀2
		int[] num = { 3, 4, 5, 1, 8, 7, 9, 2 }; // 상벌점 부여 집계
		int[] amount = { 10, 5, 6, -6, -8, 2, -2, 5 };
		int result = t.solution(n, v1, v2, num, amount); // 상벌점 누계가 가장 높은팀의 대표학생번호 리턴.
		// 누계가 같으면, 대표학생번호가 더 낮은팀을 리턴.
		System.out.println(result);
	}

	// 동수네 반에서 상벌점을 팀단위로 공유.
	// 팀구성에 인원제한 없음. (1인팀 가능)
	// 상점은 음수도 가능.
	// 10명의 학생 (1~10번 번호)
	// 팀 A,B,C,D
	// 각 팀의 대표는 가장 작은번호를 가진 학생.

	private static int[] parents;
	private static int[] scores;
	private static int[] root;

	private static int findSet(int x) {
		while (parents[x] != 0) {
			x = parents[x];
		}
		return x;
	}

	private static void union(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		if (x != y) {
			if (x < y) {
				parents[y] = x;
			} else {
				parents[x] = y;
			}
		}
	}

	public int solution(int n, int[] v1, int[] v2, int[] num, int[] amount) {
		// n: 학생 수
		// v1: 팀의 구성
		// v2: 팀의 구성
		// num: 상벌점 부여 집계
		// amount: 상벌점 부여 집계
		parents = new int[n + 1]; // 1 ~ n
		scores = new int[n + 1]; // 1 ~ n
		int vLen = v1.length;
		int sLen = num.length;
		for (int i = 0; i < vLen; i++) {
			union(v1[i], v2[i]);
		}
		ArrayList<Integer> teams = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (parents[i] == 0) {
				teams.add(i);
			}
		}
		for (int i = 0; i < sLen; i++) {
			int x = findSet(num[i]);
			scores[x] += amount[i];
		}
		int maxScore = scores[teams.get(0)];
		int maxIdx = 0;
		for (int i = 1; i < teams.size(); i++) {
			int tmp = scores[teams.get(i)];
			if (maxScore < tmp) {
				maxScore = tmp;
				maxIdx = i;
			}
		}
		return teams.get(maxIdx);
	}
}
