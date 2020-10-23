package com.algo.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D4_음식배달 {
	/**
	 * 0:빈칸 2이상 : 음식배달집 및 운영비 , 1: 집 배달거리 : 집과 가장가까운 음식배달집 사이의 거리
	 */
	static int T, N;
	static int[][] map;
	static boolean[][] visit;
	static int[] dy = { 0, -1, 0, 1 };// 좌,상,우,하
	static int[] dx = { -1, 0, 1, 0 };
	static int[] ddy = { -1, -1, 1, 1 }; // 좌상, 우상, 우하, 좌하
	static int[] ddx = { -1, 1, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // end input

			Queue<int[]> que = new LinkedList<int[]>();
			int result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1) { // 집을 만나면
						que.add(new int[] { i, j, 0 }); // 집좌표 + 거리
					}
					while (!que.isEmpty()) {
						int[] cur = que.poll();
						boolean flag = true;
						for (int d = 0; d < 4; d++) { // 정4방향
							int ny = cur[0] + dy[d];
							int nx = cur[1] + dx[d];
							int dist = cur[2] + 1;
							if (!canGo(ny, nx))
								continue;
							if (map[ny][nx] >= 2) {// 가게를 만나면
								result += dist;
								flag = false;
								visit[ny][nx] = true; // 가게좌표 저장.
								que = new LinkedList<>();
								break;
							}
						}
						for (int d = 0; flag && d < 4; d++) { // 대각선방
							int ny = cur[0] + ddy[d];
							int nx = cur[1] + ddx[d];
							int dist = cur[2] + 2;
							if (!canGo(ny, nx))
								continue;
							if (map[ny][nx] >= 2) {
								result += dist;
								flag = false;
								visit[ny][nx] = true; // 가게좌표 저장.
								que = new LinkedList<>();
								break;
							}
						}
						if(flag) {// 주변8방에 가게가 없음.
							for(int k=0; k<4; k++) {
								int ny = cur[0]+dy[k];
								int nx = cur[1]+dx[k];
								int dist = cur[2]+1;
								if(!canGo(ny,nx)) continue;
								que.add(new int[] {ny, nx, dist});
							}
                            for(int k=0; k<4; k++) {
								int nny = cur[0]+ddy[k];
								int nnx = cur[1]+ddx[k];
								int dist = cur[2]+2;
								if(!canGo(nny,nnx)) continue;
								que.add(new int[] {nny, nnx,dist});
							}
						}


					}//end while 

				}
			} // end for
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(visit[i][j]) {
						result+= map[i][j];
					}
				}
			}
			System.out.println("#" + t + " " + result);

		} // end testcase
	}

	private static boolean canGo(int ny, int nx) {
		if (0 <= ny && ny < N && 0 <= nx && nx < N) {
			return true;
		}
		return false;
	}
}
