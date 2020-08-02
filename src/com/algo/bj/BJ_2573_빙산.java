package com.algo.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class BJ_2573_���� {
	/**
	 * 4���� 0�� �ִ¼���ŭ �پ���. 
	 * ������ �ε�� �̻����� �и��Ǵ� ������ ��(�ð�)�� ??? 
	 * �ٳ�Ҵµ���, �ε�� �̻����� �и����� �ʴ´ٸ�, 0 ��� 
	 * */
	static int N,M; //��, �� : 3~300 
	static int[][] map;
	static int[][] checkmap;
	static int[] dy = {-1,0,1,0}; //��, ��, ��, �� 
	static int[] dx = {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		checkmap = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}// end Input
		
		int day = 0;
		
		while(true) {
			day++;
			for(int y=0; y<N; y++) {
				for(int x=0; x<M; x++) {
					if(map[y][x]!=0) {
						go(y,x);
					}
				}
			}
			
			if(isTwo(checkmap)) {
				break;
			}
			if(allZero(checkmap)) {
				day=0;
				break;
			}
		}
		
		System.out.println(day);
		
		
	}
	private static boolean allZero(int[][] checkmap) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(checkmap[i][j]!=0) {
					return false;
				}
			}
		}
		return true;
	}
	// �ε���� �������� ?
	private static boolean isTwo(int[][] checkmap) {
		int[] dy = {0, 1, 1, 1, 0, -1, -1, -1}; // ��, �»�, ��, ���, ��, ����, ��, ���� 
		int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
		int gun = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(checkmap[i][j]!=0) {
					gun++;
					if(gun>=2) {
						return true;
					}
					for(int d=0; d<8; d++) {
						int ny = i+ dy[d];
						int nx = j+dx[d];
						if( !canGo(ny,nx) ) continue;
						if( checkmap[ny][nx] !=0 ) {
							checkmap[ny][nx] = 0;
						}
					}
				}
			}
		}
		
		if(gun>=2) {
			return true;
		}else {
			return false;
		}
	}
	
	private static void go(int y, int x) {

		int cnt=0;
		for(int d=0; d<4; d++) {
			int ny = y+dy[d];
			int nx = x+dx[d];
			if( !canGo(ny,nx) ) continue;
			if(map[ny][nx]==0) {
				cnt++;
			}
		}
		if(map[y][x]-cnt <0) {
			checkmap[y][x]=0;
		}else {
			checkmap[y][x]= map[y][x] - cnt;
		}
	}
	
	private static boolean canGo(int ny, int nx) {
		if(0<=ny && ny<N && 0<= nx && nx<M ) {
			return true;
		}
		return false;
	}
}
