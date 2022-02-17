package com.samsung.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class 상어중학교 {
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static int maxTotalCnt;
	static int maxRainbowCnt;
	static int jumsu;
	static int[] dy = { -1, 0, 0, 1 }; // 위, 왼, 오, 아래
	static int[] dx = { 0, -1, 1, 0 };

	public static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == (M + 1)) {
					System.out.printf("   |");
				} else {
					System.out.printf("%3d|", map[i][j]);
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 1 <= N <= 20
		M = Integer.parseInt(st.nextToken()); // 1 <= M <= 5 (색깔 갯수)
		map = new int[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end input

		// 블록그룹
		// - 일반 블록이 적어도 하나 있어야 한다.
		// - 일반 블록의 색은 모두 같아야 한다.
		// - 검은 블록을 포함하면 안된다.
		// - 무지개 블록은 갯수 상관 없다.
		// - 블록갯수는 최소 2개이상이어야 한다.
		// - 블록그룹의 기준블록은 일반블록이어야 한다.
		// - 기준블록은 블록중에서 행,열 의 번호가 가장 작은 블록.
		// - 모든 블록들은 인접해있어야 한다.

		// [ 다음 과정은 블록그룹이 존재하는 동안 계속 반복한다. ]
		jumsu = 0;
		while (true) {
			// 1. 크기가 가장 큰 블록그룹을 찾는다.
			ArrayList<int[]> biggestGroup = findBiggestGroup();

			if (biggestGroup.size() == 0)
				break;

			// 2. 위에서 찾은 블록그룹의 모든 블록을 제거한다.
			// 블록그룹에 포함된 블록 갯수 :B -> 점수: B*B
			jumsu += remove(biggestGroup);

			// 3. 중력
			gravity();
			// 4. 반시계방향. 90도 회전.
			rotate();
			// 5. 중력
			gravity();
		} // end while

		System.out.println(jumsu);
	}

	// 회전. 반시계방향. 90도
	private static void rotate() {
		ArrayList<int[]> rowList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int[] row = new int[N];
			for (int j = 0; j < N; j++) {
				row[j] = map[i][j];
			}
			rowList.add(row);
		} // end make rowList

		for (int i = 0; i < N; i++) {
			int[] row = rowList.get(i);
			for (int j = 0; j < N; j++) {
				map[N - j - 1][i] = row[j];
			}
		}
	}

	// 중력
	private static void gravity() {
		// 제일 왼쪽 컬럼부터
		for (int col = 0; col < N; col++) {
			int g = N - 1;
			int r = N - 1;
			while (g > 0 && r >= 0) {
				// g가 빈칸을 찾아 이동
				while (g > 0) {
					if (map[g][col] == M + 1) { // 빈칸 찾으면
						break;
					} else {
						g--;
						r--;
					}
				}

				// g가 빈칸을 찾지 못했으면 종료
				if (g == 0)
					break;

				// g가 빈칸을 찾은 상태
				// r이 떨어트릴 블록을 찾아 이동
				while (r >= 0) {
					if (map[r][col] >= 0 && map[r][col] <= M) { // 블록을 찾으면
						break;
					} else if (map[r][col] == M + 1) { // 빈칸이면
						r--;
					} else if (map[r][col] == -1) { // 검은 블록이면
						break;
					}
				}

				// 떨어질 블록을 못찾으면 종료
				if (r < 0)
					break;
				// 검은블록이면 다시시작
				if (map[r][col] == -1) {
					g = r;
					continue;
				}
				// 떨어질 블록을 찾음
				map[g][col] = map[r][col];
				map[r][col] = M + 1;
				g--;
				r = g;
			}
		}
	}

	// 2. 블록그룹의 모든 블록을 제거한다.
	public static int remove(ArrayList<int[]> group) {
		for (int[] pos : group) {
			map[pos[0]][pos[1]] = M + 1; // M+1 이 공백을 나타내는 숫자.
		}
		return maxTotalCnt * maxTotalCnt;
	}

	// 1. 크기가 가장 큰 블록그룹을 찾는다.
	// 블록그룹
	// - (1) 일반 블록이 적어도 하나 있어야 한다.
	// - (2) 일반 블록의 색은 모두 같아야 한다.
	// - (3) 검은 블록을 포함하면 안된다.
	// - (4) 무지개 블록은 갯수 상관 없다.
	// - (5) 블록갯수는 최소 2개이상이어야 한다.
	// - (6) 블록그룹의 기준블록은 일반블록이어야 한다.
	// - (7) 기준블록은 블록중에서 행,열 의 번호가 가장 작은 블록.
	// - (8) 모든 블록들은 인접해있어야 한다.
	public static ArrayList<int[]> findBiggestGroup() {

		visit = new boolean[N][N];

		maxTotalCnt = 0;
		maxRainbowCnt = 0;
		ArrayList<int[]> biggestGroupBlockList = new ArrayList<>();
		Queue<int[]> que = new LinkedList<int[]>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j])
					continue;
				if (map[i][j] > 0 && map[i][j] <= M) { // (1) 일반 블록, (6) 기준블록은 일반블록, (7) 행,열 번호가 가장 작은거

					Set<int[]> group = new HashSet<>();
					int color = map[i][j];
					int totalCnt = 1;
					int rainbowCnt = 0;
					group.add(new int[] { i, j });
					que.add(new int[] { i, j });
					visit[i][j] = true;

					while (!que.isEmpty()) {
						int[] cur = que.poll();
						for (int d = 0; d < 4; d++) { // (8) 인접한 곳 검사
							int ny = cur[0] + dy[d];
							int nx = cur[1] + dx[d];
							if (!canGo(ny, nx))
								continue;
							if (visit[ny][nx])
								continue;
//							if (map[ny][nx] == -1 || map[ny][nx]==M+1) continue; // (3) 검은 블록 포함X, 빈칸도 안됨. 
							// (4)무지개블록은 상관없이 추가 가능
							// (2) 일반블록이라면 색깔이 같아야 한다.
							if (map[ny][nx] == 0) {
								rainbowCnt++;
								totalCnt++;
								que.add(new int[] { ny, nx });
								group.add(new int[] { ny, nx });
								visit[ny][nx] = true;
							} else if (color == map[ny][nx]) {
								totalCnt++;
								que.add(new int[] { ny, nx });
								group.add(new int[] { ny, nx });
								visit[ny][nx] = true;
							}
						} // end for
					} // end while
						// 무지개블럭은 visit false해줘야댐.
					resetRainbowBlocksVisit();

					int size = group.size();
					if (size >= 2) { // (5) 블록갯수는 최소 2개 이상.
						if (maxTotalCnt < totalCnt) {
							maxTotalCnt = totalCnt;
							maxRainbowCnt = rainbowCnt;
							biggestGroupBlockList.clear();
							for (int[] pos : group) {
								biggestGroupBlockList.add(pos);
							}
						} else if (maxTotalCnt == totalCnt) {
							if (maxRainbowCnt <= rainbowCnt) {
								maxRainbowCnt = rainbowCnt;
								biggestGroupBlockList.clear();
								for (int[] pos : group) {
									biggestGroupBlockList.add(pos);
								}
							}
						}
					}
				}
			}
		}
		return biggestGroupBlockList;
	}

	private static void resetRainbowBlocksVisit() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					visit[i][j] = false;
				}
			}
		}
	}

	public static boolean canGo(int y, int x) {
		if (0 <= y && y < N && 0 <= x && x < N) {
			return true;
		}
		return false;
	}
}
