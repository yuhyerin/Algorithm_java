package com.samsung.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 마법사상어와비바라기 {
	static int N; // 2~50
	static int M; // 1~100
	static int[][] map; // map[i][j] = 0~100
	static boolean[][] visit;
	static int[][] info;
	static ArrayList<Cloud> cloudList;
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 }; // 왼, 왼위, 위, 오위, 오, 오아래, 아래, 왼아래 (8방향)
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		info = new int[M][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end map

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			info[i][0] = Integer.parseInt(st.nextToken()) - 1; // 방향 index 0부터 사용.
			info[i][1] = Integer.parseInt(st.nextToken());
		} // end info

		// 초기 구름 셋팅
//		isCloud[N - 1][0] = true;
//		isCloud[N - 1][1] = true;
//		isCloud[N - 2][0] = true;
//		isCloud[N - 2][1] = true;

		cloudList = new ArrayList<>();
		cloudList.add(new Cloud(N - 1, 0));
		cloudList.add(new Cloud(N - 1, 1));
		cloudList.add(new Cloud(N - 2, 0));
		cloudList.add(new Cloud(N - 2, 1));

		for (int i = 0; i < M; i++) {
			visit = new boolean[N][N];
			int d = info[i][0];
			int s = info[i][1];
			move(d, s); // 구름 이동
			add(); // 물복사
			remove(); // 물양 감소
		}
//		bibaragi();
		int result = getWater();
		System.out.println(result);
	}

	private static void remove() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] >= 2 && !visit[r][c]) {
					map[r][c] -= 2;
					cloudList.add(new Cloud(r, c));
				}
			}
		}
	}

	private static void add() {
		for (Cloud cloud : cloudList) {
			int cy = cloud.y;
			int cx = cloud.x;
			int cnt = 0;
			for (int dir = 1; dir < 8; dir += 2) {
				int ny = cy + dy[dir];
				int nx = cx + dx[dir];
				if (!canGo(ny, nx))
					continue;
				if (map[ny][nx] > 0) {
					cnt++;
				}
			}
			map[cy][cx] += cnt;
		}
		cloudList.clear();
	}

	private static void move(int d, int s) {
		// 1. 모든 구름이 d방향으로 s칸 이동한다.
		for (Cloud cloud : cloudList) {

			int ny = (cloud.y + dy[d] * s + N * 50) % N;
			int nx = (cloud.x + dx[d] * s + N * 50) % N;
			visit[ny][nx] = true;
			map[ny][nx]++; // 2. 물 증가
			cloud.y = ny;
			cloud.x = nx;
		}

	}

	private static int getWater() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += map[i][j];
			}
		}
		return sum;
	}

	static class Cloud {
		int y; // 구름위치
		int x;

		public Cloud(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}

	private static boolean canGo(int y, int x) {
		if (0 <= y && y < N && 0 <= x && x < N) {
			return true;
		}
		return false;
	}

}
