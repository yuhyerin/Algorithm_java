package com.samsung.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 메모리 초과 */
public class 마법사상어와파이어볼 {

	static int N, M, K;
	static ArrayList<FireBall>[][] map;
	static Queue<int[]> que;

	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 }; // 8방향
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

	// 파이어볼
	public static class FireBall {
		int m; // 질량
		int s; // 속력
		int d; // 방향

		public FireBall(int m, int s, int d) {
			super();
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 격자 크기 N (4 <= N <= 50)
		M = Integer.parseInt(st.nextToken()); // 파이어볼 갯수 M (0 <= M <= N^2)
		K = Integer.parseInt(st.nextToken()); // 이동횟수 K (1 <= K <= 1000)

		map = new ArrayList[N][N];
		que = new LinkedList<int[]>(); // 이번 턴에 이동할 파이어볼 좌표를 저장하는 큐

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<FireBall>();
			}
		} // 초기화

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken()); // 1 <= m <= 1000
			int s = Integer.parseInt(st.nextToken()); // 1<= s <= 1000
			int d = Integer.parseInt(st.nextToken()); // 0<= d <= 7

			map[r - 1][c - 1].add(new FireBall(m, s, d));
			que.add(new int[] { r - 1, c - 1 });

		} // end Input

		int cnt = 0;
		while (cnt < K) {
			cnt++;
			move(); // 1. 모든 공 이동.
			sumAndDivide(); // 2. 2개이상 있으면 합치고, 4개로 나누기
		}
		int sum = getSum(); // 3. 상어가 K번 명령 후, 남아있는 파이어볼 질량의 합 출력!
		System.out.println(sum);
	}

	private static void move() {
		// 1. 모든 파이어볼이 d방향으로 속력s칸만큼 이동한다.
		int queSize = que.size();
		for (int q = 0; q < queSize; q++) { // 초기 큐 사이즈만큼 반복
			int[] rc = que.poll();
			int i = rc[0];
			int j = rc[1];
			if (map[i][j].size() >= 1) {

				for (int b = 0; b < map[i][j].size(); b++) {
					FireBall ball = map[i][j].get(b);
					int cur_s = ball.s % N; // s가 격자크기인 N보다 클 수 있음. (행, 열이 연결되어있다는 조건 참고 )

					int nr = i + dr[ball.d] * cur_s;
					int nc = j + dc[ball.d] * cur_s;

					// 범위를 벗어난 경우. 반대방향으로 나온다.
					if (nr < 0) {
						nr = nr + N;
					} else if (nr >= N) {
						nr = nr - N;
					}

					if (nc < 0) {
						nc = nc + N;
					} else if (nc >= N) {
						nc = nc - N;
					}
					
					map[i][j].remove(b);// 그전꺼 제거
					map[nr][nc].add(ball); // 이동
					que.add(new int[] { nr, nc });

				} // end for
			} // end if
		} // end que for

	}

	private static void sumAndDivide() {
		// 2개이상의 파이어볼이 있는 칸에서 다음과 같은 일이 일어난다.
		// - 같은 칸에 있는 파이어볼은 모두 하나로 합쳐진다.
		// - 파이어볼은 4개의 파이어볼로 나눠진다.
		// - 나눠진 파이어볼
		// 질량 : (합쳐진 파이어볼 질량 합)/5
		// 속력 : (합쳐진 파이어볼 속력 합)/(합쳐진 파이어볼 갯수)
		// 방향 : (모두홀수거나 모두짝수면) ==> 0,2,4,6 / (그외) ==> 1,3,5,7
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int len = map[i][j].size(); // 파이어볼 갯수
				if (len >= 2) {
					int all_m = 0; // 파이어볼들 질량 합
					int all_s = 0; // 파이어볼들 속력 합
					boolean isEven = true, isOdd = true; // 모두 짝수인지 홀수인지 판단
					for (int b = 0; b < len; b++) {
						FireBall ball = map[i][j].get(b);
						all_m += ball.m;
						all_s += ball.s;
						if (ball.d % 2 == 0) {
							isOdd = false;
						} else {
							isEven = false;
						}
					}
					int m = all_m / 5;
					int s = all_s / len;

					map[i][j].clear(); // 기존 파이어볼들 모두 제거.
					// 3. 질량이 0인 파이어볼은 소멸되서 사라진다.
					if (m == 0)
						continue;

					if (isEven || isOdd) { // 모두 짝수거나 홀수 방향
						int[] dir = { 0, 2, 4, 6 };
						for (int d = 0; d < 4; d++) {
							map[i][j].add(new FireBall(m, s, dir[d]));
						}
					} else {
						int[] dir = { 1, 3, 5, 7 };
						for (int d = 0; d < 4; d++) {
							map[i][j].add(new FireBall(m, s, dir[d]));
						}
					}
					que.add(new int[] { i, j });
				} // end if
			}
		} // end for
	}

	private static int getSum() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j].size() > 0) {
					for (FireBall ball : map[i][j]) {
						sum += ball.m;
					}
				}
			}
		} // end for
		return sum;
	}
}
