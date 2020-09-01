package com.algo.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class pdf_두더지굴_bfs {
	/** 푸는법 3가지: 1.리턴이 있는 DFS 2. 리턴이 없는 DFS 3. 리턴이 없는 BFS */
	static int N;
	static int[][] map;
	static int[][] visit;
	static int[] dy = {-1,0,1,0}; // 상, 우, 하, 좌 
	static int[] dx = {0,1,0,-1};
	static ArrayList<Integer> counting;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		visit = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}// end Input
		
		int group = 1;
		int count = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j< N; j++) {
				if(map[i][j] ==1 && visit[i][j]==0) {
					count++;
					bfs(i,j, group+1);
				}
			}
		}
		System.out.println(count);
		
		int[] cnt = new int[2+count];
		for(int c =2; c< 2+count; c++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(visit[i][j]==c) {
						cnt[c]++;
					}
				}
			}
		}
		for(int i=2; i<2+count; i++) {
			System.out.println(cnt[i]);
		}
		
	}
	
	private static void bfs(int y, int x, int group) {
		
		// <int[]> 하면 크기가 글 경우 터지는 상황이 가끔 발생! 
		Queue<Loc> que = new LinkedList<>();
		que.offer(new Loc(y,x));
		visit[y][x] = group;
		
		while(!que.isEmpty()) {
			Loc curr = que.poll();
			int cy = curr.y;
			int cx = curr.x;
			
			for(int d=0; d<4; d++) {
				int ny = cy+dy[d];
				int nx = cx+dx[d];
				if(!canGo(ny,nx)) continue;
				if(map[ny][nx]==1 && visit[ny][nx]==0) {
					visit[ny][nx]=group;
					que.offer(new Loc(ny,nx));
				}
			}
		}
		
	}

	private static boolean canGo(int ny, int nx) {
		if(0<= ny && ny <N && 0<= nx && nx < N) {
			return true;
		}
		return false;
	}
	
	public static class Loc{
		int y;
		int x;
		public Loc(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

}
