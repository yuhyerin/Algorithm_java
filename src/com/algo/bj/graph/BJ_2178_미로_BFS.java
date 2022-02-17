package com.algo.bj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2178_미로_BFS {
	static int N, M;
	static int[][] map;
	static int[][] answer;
	static boolean[][] visit;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 }; // 상 우 하 좌

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		answer = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = row.charAt(j) - '0';
			}
		} // end Input
		answer[0][0]=1;
		go();

		System.out.println(answer[N - 1][M - 1]);
	}

	private static void go() {

		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] { 0, 0 }); // 시작점 
		visit[0][0] = true;

		while (!que.isEmpty()) {

			int[] cur = que.poll();
			int cy = cur[0];
			int cx = cur[1];

			for (int d = 0; d < 4; d++) {
				int ny = cy + dy[d];
				int nx = cx + dx[d];
				if (!canGo(ny, nx)) continue;
				if(visit[ny][nx]) continue;
				if (map[ny][nx] == 1) {
					que.add(new int[] { ny, nx });
					answer[ny][nx] = answer[cy][cx] + 1;
					visit[ny][nx] = true;
				}
				
			} // end for

		} // end while

	}

	private static boolean canGo(int ny, int nx) {
		if (0 <= ny && ny < N && 0 <= nx && nx < M) {
			return true;
		}
		return false;
	}
}
