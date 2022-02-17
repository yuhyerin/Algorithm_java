package com.algo.bj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BJ_2206_벽부수고이동하기 {
	static int N,M;
	static int[][] map; // 0:이동가능, 1:벽  (벽은 1회 부수고 지나갈 수 있음)
	static boolean[][] visit;
	static int[][] answer;
	static int[] dy = {-1,0,1,0};// 상 우 하 좌 
	static int[] dx = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		answer = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String row = br.readLine();
			for(int j=0;j <M; j++) {
				map[i][j] = row.charAt(j)-'0';
			}
		}// end input 
		
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<M;j++) {
//				if(map[i][j]==1) {
//					map[i][j]=0; // 벽미리뿌시기 
//					bfs();
//					map[i][j]=1; // 원상복구 
//				}
//			}
//		}
		System.out.println(bfs());
//		
//		if(min==Integer.MAX_VALUE) {
//			System.out.println(-1);
//		}else {
//			System.out.println(bfs());
//		}
	}
	
	private static int bfs() {
		Queue<int[]> que = new LinkedList<int[]>();
		
		que.add(new int[] {0,0,0});
		answer[0][0]=1;
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int cy = cur[0];
			int cx = cur[1];
			int useChance = cur[2];
			if(cy == N-1 && cx == M-1)
				return answer[cy][cx];
			
			if(!visit[cy][cx]) {
				visit[cy][cx]=true;
				for(int d=0; d<4; d++) {
					int ny = cy+dy[d];
					int nx = cx+dx[d];
					if(canGo(ny,nx) && !visit[ny][nx]) {
						if(map[ny][nx]==0) {// 벽안부수고 이동
							answer[ny][nx] = answer[cy][cx]+1;
							que.add(new int[] {ny,nx, useChance});
						}else {
							if(useChance == 0) {// 벽부수고이동
								answer[ny][nx] = answer[cy][cx]+1;
								que.add(new int[] {ny,nx, 1});
							}
						}
					}
				}
			}
		}// end while 
		return -1;
		
	}

	private static boolean canGo(int ny, int nx) {
		if(0<=ny && ny<N && 0<=nx && nx<M) return true;
		return false;
	}
}
