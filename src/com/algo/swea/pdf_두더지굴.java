package com.algo.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class pdf_두더지굴 {
	/** 푸는법 3가지: 1.리턴이 있는 DFS 2. 리턴이 없는 DFS 3. 리턴이 없는 BFS */
	static int N;
	static int[][] map;
	static int[] dy = {-1,0,1,0}; // 상, 우, 하, 좌 
	static int[] dx = {0,1,0,-1};
	static ArrayList<Integer> counting;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}// end Input
		
		int depth = 1;
		int count = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j< N; j++) {
				if(map[i][j] ==1) {
					count++;
					dfs(i,j, depth+1);
				}
			}
		}
		System.out.println(count);
		depth = 2;
		counting = new ArrayList<>();
		
	}
	
	private static void dfs(int y, int x, int depth) {
		
		map[y][x]=depth;
		for(int d=0; d<4; d++) {
			int ny = y+ dy[d];
			int nx = x + dx[d];
			if(!canGo(ny,nx)) continue;
			if(map[ny][nx]==1) {
				dfs(ny,nx,depth);
			}
		}
	}

	private static boolean canGo(int ny, int nx) {
		if(0<= ny && ny <N && 0<= nx && nx < N) {
			return true;
		}
		return false;
	}

}
