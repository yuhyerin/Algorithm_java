package com.algo.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_4179_บา {

	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static Queue<int[]> man = new LinkedList<>();
	static Queue<int[]> fire = new LinkedList<>();
	static int min = Integer.MAX_VALUE;
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
				if (map[i][j] == 'J') {
					visited[i][j] = true;
					map[i][j] = '.';
					man.add(new int[] { i, j });
				} else if (map[i][j] == 'F') {
					visited[i][j] = true;
					fire.add(new int[] { i, j });
				}
			}
		}

		int cnt = 0;
		loop: while (!man.isEmpty()) {
			// fire
			int fs = fire.size();

			for (int s = 0; s < fs; s++) {
				int[] cur = fire.poll();

				for (int i = 0; i < 4; i++) {
					int ny = cur[0] + dy[i];
					int nx = cur[1] + dx[i];

					if (!isRange(ny, nx) || map[ny][nx] != '.')
						continue;
					map[ny][nx] = 'F';
					fire.add(new int[] { ny, nx });
				}
			}

			// man
			int ms = man.size();

			for (int s = 0; s < ms; s++) {
				int[] cur = man.poll();

				for (int i = 0; i < 4; i++) {
					int ny = cur[0] + dy[i];
					int nx = cur[1] + dx[i];

					if (!isRange(ny, nx)) {
						min = ++cnt;
						break loop;
					}

					if (visited[ny][nx] || map[ny][nx] != '.')
						continue;
					visited[ny][nx] = true;
					man.add(new int[] { ny, nx });
				}
			}
			cnt++;
		}
		System.out.println(min == Integer.MAX_VALUE ? "IMPOSSIBLE" : min);
	}

	static boolean isRange(int y, int x) {
		if (0 <= y && y < R && 0 <= x && x < C)
			return true;
		return false;
	}

}