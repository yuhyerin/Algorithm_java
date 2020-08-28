package com.algo.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class pdf_¹Ì·Î_DFS{
	static int h,w;
	static int[] dy = {0,0,1,-1};
	static int[] dx = {1,-1,0,0};
	static int min;
	static int sy,sx; // start
	static int gy,gx; // goal
	static char[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		map = new char[h][w];
		visit = new boolean[h][w];
		for(int i=0; i<h; i++) {
			String row = in.readLine();
			for(int j=0; j<w; j++) {
				map[i][j] = row.charAt(j);
				if(map[i][j]=='S') {
					sy = i;
					sx = j;
				}else if(map[i][j]=='G') {
					gy=i;
					gx=j;
				}
			}
		}// end Input
		min = Integer.MAX_VALUE;
		dfs(sy,sx,0);
		System.out.println(min);

	}
	private static void dfs(int y, int x, int count) {
		
		if(y== gy && x == gx) {
			min = Math.min(min, count);
			return;
		}
		
		visit[y][x]=true;
		for(int d=0; d<4; d++) {
			int ny = y+dy[d];
			int nx = x+dx[d];
			if(!canGo(ny,nx)) continue;
			if(map[ny][nx]=='#') continue;
			if( (map[ny][nx]=='.' || map[ny][nx]=='G') && !visit[ny][nx]) {
				dfs(ny, nx, count+1);
			}
		}
		visit[y][x]=false;
	}
	private static boolean canGo(int ny, int nx) {
		if(0<=ny && ny <h && 0<= nx && nx < w)
			return true;
		return false;
	}
}
