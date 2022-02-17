package com.algo.kakao.internship;
import java.util.LinkedList;
import java.util.Queue;

public class test2 {
	public static void main(String[] args) {
		test2 t = new test2();
		String[][] places = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
				{ "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX" },
				{ "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };
		int[] result = t.solution(places);
		for (int a : result) {
			System.out.print(a);
		}
		System.out.println();
	}

	public int[] solution(String[][] places) {
		// 대기실 5개. 각 대기실은 5x5크기.
		// 맨허튼거리 2이하로 앉지 말기.
		// 응시자 사이에 파티션으로 막혀있다면, 허용.
		// P: 앉아있는 자리.
		// 0: 빈자리
		// X: 파티션
		// 거리두기하고있으면 1리턴, 못하면 0리턴
		int[] answer = new int[5];
		// 4방위
		int[] dr = { -1, 0, 1, 0, -2, 0, 2, 0 };
		int[] dc = { 0, 1, 0, -1, 0, 2, 0, -2 };
		// 대각
		int[] ddr = { -1, -1, 1, 1 };
		int[] ddc = { -1, 1, 1, -1 };
		for (int i = 0; i < 5; i++) {
			int result = 1;
			char[][] map = new char[5][5];
			for (int j = 0; j < 5; j++) {
				map[j] = places[i][j].toCharArray();
			} // end input

			Queue<int[]> que = new LinkedList<int[]>();
			for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					if (map[r][c] == 'P') {
						que.add(new int[] { r, c });
					}
				}
			} // end input que

			loop1: while (!que.isEmpty()) {
				int[] cur = que.poll();
				int r = cur[0];
				int c = cur[1];
				// 1. 4방위 검사
				for (int d = 0; d < 8; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if (!canGo(nr, nc))
						continue;
					if (map[nr][nc] != 'P') {
						continue;
					} else if (map[nr][nc] == 'P') {// 파티션있는지 검사.
						if (d < 4) {// 바로 붙어있으면 종료.
							result = 0;
							break loop1;
						} else { // 떨어져있으면 떨어져있는 애 방향으로 파티션 있는지 검사.
							int ckr = r;
							int ckc = c;
							if (r > nr && c == nc) { // 내 위에
								ckr = r - 1;
							} else if (r == nr && c < nc) { // 내 오른쪽
								ckc = c + 1;
							} else if (r < nr && c == nc) {// 내 아래
								ckr = r + 1;
							} else if (r == nr && c > nc) { // 내 왼쪽
								ckc = c - 1;
							}
							if (!canGo(ckr, ckc))
								continue;
							if (map[ckr][ckc] != 'X') { // 4방에 파티션 없으면 종료.
								result = 0;
								break loop1;
							}
						}
					}
				}
				// 2. 대각검사
				for (int d = 0; d < 4; d++) {
					int nr = r + ddr[d];
					int nc = c + ddc[d];
					if (!canGo(nr, nc))
						continue;
					if (map[nr][nc] != 'P') {
						continue;
					} else if (map[nr][nc] == 'P') {
						if (r > nr && c > nc) { // 내 왼쪽위 
							if(map[r][c-1]!='X' || map[r-1][c]!='X') {
								result = 0;
								break loop1;
							}
						} else if (r > nr && c < nc) { // 내 오른쪽위 
							if(map[r-1][c]!='X' || map[r][c+1]!='X') {
								result = 0;
								break loop1;
							}
						} else if (r < nr && c < nc) {// 내 오른쪽아래 
							if(map[r][c+1]!='X' || map[r+1][c]!='X') {
								result = 0;
								break loop1;
							}
						} else if (r < nr && c > nc) { // 내 왼쪽아래 
							if(map[r+1][c]!='X' || map[r][c-1]!='X') {
								result = 0;
								break loop1;
							}
						}
					}
				}

			}
			answer[i] = result;
		}
		return answer;
	}

	private void printmap(char[][] map) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	public boolean canGo(int r, int c) {
		if (0 <= r && r < 5 && 0 <= c && c < 5) {
			return true;
		}
		return false;
	}
}
