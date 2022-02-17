package com.samsung.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 마법사상어와파이어스톰 {

	public static int n, N, Q;
	public static int[][] map;
	public static int[] dy = { 0, -1, 0, 1 }; // 왼 위 오 아래
	public static int[] dx = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		N = (int) Math.pow(2, n);
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end input map

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			int level = Integer.parseInt(st.nextToken());
			divideAndRotate(level); // 분할 & 회전
			printMap();
			melt(); // 녹이기
		}
		int sum = getSum();
		int largeOneSize = getLargeOne();
		System.out.println(sum);
		System.out.println(largeOneSize);
	}

	private static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

	}

	// BFS
	private static int getLargeOne() {
		boolean[][] visit = new boolean[N][N];
		Queue<int[]> que = new LinkedList<int[]>();
		int max = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cnt = 0;
				if (map[i][j] > 0 && !visit[i][j]) { // 얼음이 있고, 방문하지 않음.
					cnt++;
					que.add(new int[] { i, j });

					while (!que.isEmpty()) {
						int[] cur = que.poll();
						visit[cur[0]][cur[1]] = true; // 방문 체크 

						for (int d = 0; d < 4; d++) {
							int ny = cur[0] + dy[d];
							int nx = cur[1] + dx[d];
							if (!canGo(ny, nx))
								continue;

							if (map[ny][nx] > 0 && !visit[ny][nx]) {
								que.add(new int[] { ny, nx });
								visit[ny][nx]=true;
								cnt++;
							}
						}
					} // end while
					max = Math.max(cnt, max);

				}
			}
		}
		return max;
	}

	private static int getSum() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] > 0) {
					sum += map[i][j];
				}
			}
		}
		return sum;
	}

	private static void divideAndRotate(int level) {
		int size = (int)Math.pow(2, level);
		
		for(int startR=0; startR<N; startR+=size) {
			for(int startC =0; startC<N; startC+=size) {
				
				// 회전할 애들 담아 
				List<List<Integer>> list = new ArrayList<>();
				for(int i=startR; i<startR+size; i++	) {
					List<Integer> row = new ArrayList<>();
					for(int j=startC; j<startC+size; j++) {
						row.add(map[i][j]);
					}
					list.add(row);
				}//end 
				
				//회전 
				
				int cIdx = startC + size;
				for(int i=0; i<list.size(); i++) { // list 사이즈만큼 돌면서
					cIdx--;
					int rIdx = startR;
					List<Integer> row = list.get(i);
					for(int j=0; j<row.size(); j++) {
						map[rIdx+j][cIdx]= row.get(j);
					}
					
				}
			}
		}
	}

	private static void melt() {
		boolean[][] check = new boolean[N][N];

		// 녹아야 되는 곳 체크
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cnt = 0;
				if (map[i][j] == 0)
					continue;

				for (int d = 0; d < 4; d++) {
					int ny = i + dy[d];
					int nx = j + dx[d];
					if (!canGo(ny, nx))
						continue;
					if (map[ny][nx] <= 0)
						continue;
					cnt++;
				}
				if (cnt < 3) {
					// 내주변에 얼음갯수가 3개가 안되면
					check[i][j] = true; // 녹일 대상으로 체크
				}
			}
		} // end for

		// 녹이기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (check[i][j]) {
					map[i][j]--;
				}
			}
		}
	}

	private static boolean canGo(int y, int x) {
		if (0 <= y && y < N && 0 <= x && x < N) {
			return true;
		}
		return false;
	}
}
