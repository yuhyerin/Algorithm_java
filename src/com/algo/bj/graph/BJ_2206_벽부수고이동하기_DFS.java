package com.algo.bj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJ_2206_벽부수고이동하기_DFS {
	static int N,M;
	static int[][] map; // 0:이동가능, 1:벽  (벽은 1회 부수고 지나갈 수 있음)
	static boolean[][] visit;
	static int[][] answer;
	static int[] dy = {-1,0,1,0};// 상 우 하 좌 
	static int[] dx = {0,1,0,-1};
	static boolean useChance;
	static int min;
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
		min = Integer.MAX_VALUE;
		answer[0][0]=1;
		visit[0][0]=true;
		useChance = false;
		go(0,0,1);
		if(min==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
	}
	
	private static void go(int y, int x, int cnt) {
		
		if(y==N-1 && x==M-1) {
			//도착 
			if(cnt<min) {
				min = cnt;
			}
			return;
		}

		for(int d=0;d<4;d++) {
			int ny = y+dy[d];
			int nx = x+dx[d];
			if(!canGo(ny,nx)) continue;
			if(visit[ny][nx]) continue;
			if(map[y][x]==1) { // 벽 
				if(!useChance) { // 찬스쓸수있음. 
					useChance = true;
					visit[ny][nx] = true;
					go(ny,nx,cnt+1);
					useChance = false;
					visit[ny][nx] = false;
					
				}else { //이미썼음.
					continue;
				}
				
			}else { // 길
				visit[ny][nx] = true;
				go(ny,nx,cnt+1);
				visit[ny][nx] = false;
			}
		}
		
	}

	private static boolean canGo(int ny, int nx) {
		if(0<=ny && ny<N && 0<=nx && nx<M) return true;
		return false;
	}
}
