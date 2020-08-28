package com.algo.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class pdf_미로_BFS {
	/**
	 * 
5 5
#S###
#...#
#.#.#
#....
###G#

*/
	static int H,W;
	static char[][] map;
	static int[][] visited;
	static int sy, sx, gy, gx;
	static int[] dy = {-1,0,1,0}; // 상,우,하,좌
	static int[] dx = {0,1,0,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new char[H][W];
		visited = new int[H][W];
//		for(int i=0; i<H; i++) {
//			map[i] = in.readLine().toCharArray();
//		}
		for(int i=0; i<H; i++) {
			String row = in.readLine();
			for(int j=0; j<W; j++) {
				map[i][j] = row.charAt(j);
				if(map[i][j]=='S') {
					sy=i;
					sx=j;
				}else if(map[i][j]=='G') {
					gy=i;
					gx=j;
				}
			}
		}
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[]{sy,sx});
		visited[sy][sx]=0; // distance
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int cy = cur[0];
			int cx = cur[1];
			if(cy == gy && cx == gx) {
				break;
			}
			for(int d=0; d<4; d++) {
				int ny = cy+dy[d];
				int nx = cx + dx[d];
				if(!canGo(ny,nx)) continue;
				if(visited[ny][nx]!=0) continue;
				if(map[ny][nx]=='.' || map[ny][nx]=='G') {
					visited[ny][nx]= visited[cy][cx]+1;
					que.add(new int[] {ny,nx});
				}
			}
		}
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				System.out.print(visited[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(visited[gy][gx]);
		
	}
	private static boolean canGo(int ny, int nx) {
		if(0<= ny&& ny < H && 0<= nx && nx < W) {
			return true;
		}
		return false;
	}

}
