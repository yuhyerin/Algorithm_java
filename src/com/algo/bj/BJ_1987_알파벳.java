package com.algo.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1987_알파벳 {
	static int R, C;
	static char[][] map;
	static boolean[] check;
	static int[] dy = { -1, 0, 1, 0 }; // 상,우,하,좌
	static int[] dx = { 0, 1, 0, -1 };
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		check = new boolean[26]; // 밟았는지 확인
		max = Integer.MIN_VALUE;
		for (int i = 0; i < R; i++) {
			String row = in.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = row.charAt(j);
			}
		} // end Input

		dfs(0, 0, 1); // 1개
		System.out.println(max);
	}

	private static void dfs(int y, int x, int count) {

		if (max < count) {
			max = count;
		}

		check[map[y][x] - 'A'] = true;
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (!canGo(ny, nx))
				continue;
			if (check[map[ny][nx] - 'A'])
				continue;
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
