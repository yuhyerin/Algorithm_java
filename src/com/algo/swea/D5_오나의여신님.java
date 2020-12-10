package com.algo.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 수연이위치: S 여신의공간: D -> 부식X 돌의 위치: X -> 돌 못밟는다. 부식X 악마 : * -> 스킬사용. 매초 상하좌우 인접영역
 * 부식시키며 확장. 평범한지역: . 여신한테 도착하는 최소시간 출력
 */

public class D5_오나의여신님 {
	// 출력을 모아서 하기위해서!!
	static StringBuilder sb = new StringBuilder();
	static int T, R, C, min;
	static char[][] map;
	// 사방탐색.
	static int[] dy = { -1, 0, 1, 0 }; // 상,우,하,좌
	static int[] dx = { 0, 1, 0, -1 };
	static Queue<Point> points;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(in.readLine());
			R = Integer.parseInt(st.nextToken()); // 2<= N,M <= 50
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			points = new LinkedList<>();
			Point suyeon = null;
			for (int i = 0; i < R; i++) {
				String data = in.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = data.charAt(j);
					if (map[i][j] == '*') {
						points.add(new Point(i, j, 0, true));
					}
					if (map[i][j] == 'S') {
						suyeon = new Point(i, j, 0, false);
					}
				}
			} // end Input
			points.add(suyeon);
			min = Integer.MAX_VALUE;
			outer: while (!points.isEmpty()) {
				Point front = points.poll();
				for (int d = 0; d < 4; d++) {
					int nr = front.row + dy[d];
					int nc = front.col + dx[d];
					if (!canGo(nr, nc))
						continue;
					if (front.isDevil) {// 악마
						if (map[nr][nc] == '.' || map[nr][nc] == 'S') {
							map[nr][nc] = '*';
							points.add(new Point(nr, nc, front.depth + 1, true));
						}
					} else {// 수연
						if (map[nr][nc] == 'D') {
							min = front.depth + 1;
							break outer;
						} else if (map[nr][nc] == '.') {
							map[nr][nc] = 'S';
							points.offer(new Point(nr, nc, front.depth + 1, false));
						}
					}
				}

			}
			sb.append(min == Integer.MAX_VALUE ? "GAME OVER" : min);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static boolean canGo(int nr, int nc) {
		if (0 <= nr && nr < R && 0 <= nc && nc < C) {
			return true;
		}
		return false;
	}

	static class Point {
		int row, col, depth;
		boolean isDevil;

		public Point(int row, int col, int depth, boolean isDevil) {
			super();
			this.row = row;
			this.col = col;
			this.depth = depth;
			this.isDevil = isDevil;
		}

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + ", depth=" + depth + " ,isDevil=" + isDevil + "]";
		}
	}
}
