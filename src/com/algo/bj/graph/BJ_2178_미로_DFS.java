package com.algo.bj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2178_미로_DFS {
	static int N,M;
	static int[][] map;
	static boolean[][] visit;
	static int answerMin;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1}; // 상 우 하 좌 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		answerMin = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			String row = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = row.charAt(j)-'0';
			}
		}//end Input 
		visit[0][0] = true;
		go(0,0,1);
		System.out.println(answerMin);
	}
	private static void go(int y, int x, int cnt) {
		
		if(y==N-1 && x == M-1) { //도착!
			if(cnt < answerMin) { // 최소값 갱신
				answerMin = cnt;
			}
			return;
		} 
		visit[y][x]=true;
        
		for(int d=0; d<4; d++) { // 4방탐색 
			int ny = y+dy[d];
			int nx = x+dx[d];
			if(!canGo(ny,nx)) continue; // 범위체크
			if(visit[ny][nx]) continue;
			if(map[ny][nx]==1) {
				visit[ny][nx] = true;
				go(ny,nx,cnt+1);
				visit[ny][nx] = false;
			}
		}// end for 
		
		
	}
	
	private static boolean canGo(int ny, int nx) {
		if(0<= ny && ny<N && 0<= nx && nx<M) {
			return true;
		}
		return false;
	}
}
