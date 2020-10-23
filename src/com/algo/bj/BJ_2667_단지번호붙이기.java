package com.algo.bj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2667_단지번호붙이기 {

	static int N;
	static boolean[][] visit;
	static int[] dy = { 0, -1, 0, 1 }; // 좌,상,우,하
	static int[] dx = { -1, 0, 1, 0 };

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = 6;
		visit = new boolean[N][N];
		int[][] map= {
				{0,1,1,0,0,0},
				{0,1,1,0,1,1},
				{0,0,0,0,1,1},
				{0,0,0,0,1,1},
				{1,1,0,0,1,0},
				{1,1,1,0,0,0}
		};

		Queue<int[]> que = new LinkedList<int[]>();
		ArrayList<Integer> list = new ArrayList<>();
		int count = 0;
		int size = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j] && map[i][j] != 0) {
					size=0;
					count++; // 군집 하나 증가
					que.add(new int[] { i, j });
					while (!que.isEmpty()) {
						int[] cur = que.poll();
						visit[cur[0]][cur[1]] = true;
						map[cur[0]][cur[1]] = count;
						size += 1;
						for (int d = 0; d < 4; d++) {
							int ny = cur[0] + dy[d];
							int nx = cur[1] + dx[d];
							if (!canGo(ny, nx))
								continue;
							if (!visit[ny][nx] && map[ny][nx] != 0) {
								que.add(new int[] { ny, nx });
							}
						}

					}// end while
					list.add(size);
				} // end if
			}
		} // end for

		System.out.println("영역의 갯수: " + count);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
		int[] countarr = new int[count+1];
		for(int c=1; c<=N; c++) {
			for(int i=0; i<N; i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]==c) {
						countarr[c]++;
					}
				}
			}
		}
		Arrays.sort(countarr);
		for(int num : countarr) {
			if(num!=0) {
				System.out.print(num+" ");
			}
		}
		System.out.println();

	}

	private static boolean canGo(int ny, int nx) {
		if (0 <= ny && ny < N && 0 <= nx && nx < N) {
			return true;
		}
		return false;
	}

}
