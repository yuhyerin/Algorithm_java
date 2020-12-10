package com.algo.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_수지의수지맞는여행 {

	static int T, R, C, max;
	static char[][] map;
	static boolean[] check = new boolean[26];
	static int[] dy = { -1, 0, 1, 0 }; // 상,우,하,좌
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(in.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			for (int i = 0; i < R; i++) {
				map[i] = in.readLine().toCharArray();

			} // end Input
			max = Integer.MIN_VALUE;
			// (0,0)부터시작. 현재 여행지갯수 1.
			dfs(0, 0, 1);
			System.out.println(max);
		} // end Testcase

	}

	private static void dfs(int y, int x, int count) {

		if (max < count) {
			max = count;
		}

		// 밟았다고 체크
		check[map[y][x] - 'A'] = true;

		for (int d = 0; d < 4; d++) { // 주변 탐색
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (!canGo(ny, nx)) continue;
			if (check[map[ny][nx] - 'A']) continue;
			dfs(ny, nx, count + 1);
		}
		check[map[y][x] - 'A'] = false;
	}

	private static boolean canGo(int ny, int nx) {
		if (0 <= ny && ny < R && 0 <= nx && nx < C) {
			return true;
		}
		return false;
	}
}
