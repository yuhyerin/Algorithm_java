package com.algo.swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D5_오나의여신님_큐2개 {
	static int T, R, C, min;
	static char[][] map;
	static int Dr, Dc;
	static int[] dy = { -1, 0, 1, 0 }; // 상,우,하,좌
	static int[] dx = { 0, 1, 0, -1 };
	static Queue<int[]> player;
	static Queue<int[]> devil;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			R = sc.nextInt();
			C= sc.nextInt();
			map = new char[R][C];
			player = new LinkedList<int[]>();
			devil = new LinkedList<int[]>();
			for(int i=0; i<R; i++) {
				char[] ccc = sc.next().toCharArray();
				for(int j=0; j<C; j++) {
					map[i][j] = ccc[j];
					if(map[i][j]=='D') {
						Dr = i;
						Dc = j;
					}
					if(map[i][j]=='S') {
						player.add(new int[] {i,j,0});
					}
					if(map[i][j]=='*'){
						devil.add(new int[] {i,j,0});
					}
				}
			}// end Input
			
			while(true) {
				if(player.size() == 0) {
					System.out.println("#"+t+" GAME OVER");
					break;
				}
				bfsDevil(); //악마먼저 이동.
				int count = bfsPlayer(); // 수연이 Go!
				if(count >0) {
					System.out.println("#"+t+" "+count);
					break;
				}
			}
		}
		
	}

	private static int bfsPlayer() {
		int size = player.size();
		while(size-- >0){
			int[] curr = player.poll();
			int cy = curr[0];
			int cx = curr[1];
			int depth = curr[2];
			for(int d=0; d<4; d++) {
				int ny = cy+dy[d];
				int nx = cx+dx[d];
				if(!canGo(ny,nx)) continue;
				if(map[ny][nx]=='D') { //여신만나면 끝!
					return depth+1;
				}else if(map[ny][nx]== '.') {
					//map[cy][cx]='.'; 이거 안해줘도 돼요~ 악마가 S일때도 *표시하게 해둬서!
					map[ny][nx]='S'; // 수연이가 지나간 길.
					player.add(new int[] {ny, nx,depth+1});
				}
			}
		}
		return -1;
	}

	private static void bfsDevil() {
		int size = devil.size();
		while(size-- >0){ // !devil.isEmpty() 하면 안돼. 지나간길이 계속 큐에 쌓여서 안끝나...
			int[] curr = devil.poll();
			int cy = curr[0];
			int cx = curr[1];
			int depth = curr[2];
			for(int d=0; d<4; d++) {
				int ny = cy+dy[d];
				int nx = cx+dx[d];
				if(!canGo(ny,nx)) continue;
				if(map[ny][nx]== '.' || map[ny][nx]=='S') {
					map[ny][nx]='*'; // 지나간 길
					devil.add(new int[] {ny, nx,depth+1});
				}
			}
		}
		
	}
	
	private static boolean canGo(int ny, int nx) {
		if(0<= ny&& ny < R && 0<= nx && nx < C) {
			return true;
		}
		return false;
	}

}
