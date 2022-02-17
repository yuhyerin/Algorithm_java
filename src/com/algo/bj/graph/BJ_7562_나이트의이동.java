//package com.algo.bj.graph;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//
//public class BJ_7562_나이트의이동 {
//	static int T,N;
//	static boolean[][] visit;
//	static int[][] answer;
//	static int[] dy = {-1,-2,-2,-1,1,2,2,1}; //  좌상 우상 우하 좌하 
//	static int[] dx = {-2,-1,1,2,2,1,-1,-2};
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = null;
//		T = Integer.parseInt(br.readLine());
//		for(int t=0; t<T; t++) {
//			N = Integer.parseInt(br.readLine());
//			visit = new boolean[N][N];
//			answer = new int[N][N];
//			st = new StringTokenizer(br.readLine());
//			int sy = Integer.parseInt(st.nextToken());
//			int sx = Integer.parseInt(st.nextToken());
//			st = new StringTokenizer(br.readLine());
//			int ey = Integer.parseInt(st.nextToken());
////			int ex = Integer.parseInt(st.nextToken());
//			// end Input 
//			
//			move(sy,sx,ey,ex);
//			System.out.println(answer[ey][ex]);
//			
//		}// end test case
//	}
//	
//	private static void move(int sy, int sx, int ey, int ex) {
//		Queue<int[]> que = new LinkedList<int[]>();
//		que.add(new int[] {sy,sx});
//		answer[sy][sx]=0;
//		
//		while(!que.isEmpty()) {
//			int[] cur = que.poll();
//			int cy = cur[0];
//			int cx = cur[1];
//			
//			if(cy==ey && cx==ex) {
//				return;
//			}
//			
//			if(!visit[cy][cx]) {
//				visit[cy][cx] = true;
//				
//				for(int d=0; d<8; d++) {
//					int ny = cy+dy[d];
//					int nx = cx+dx[d];
//					if(!canGo(ny,nx)) continue;
//					
//					if(!visit[ny][nx]) {
//						que.add(new int[] {ny,nx});
//						answer[ny][nx] = answer[cy][cx]+1;
//					}
//					
//				}// end for 
//			}
//			
//		}
//		
//	}
//
//	private static boolean canGo(int ny, int nx) {
//		if(0<= ny && ny<N && 0<= nx && nx<N) return true;
//		return false;
//	}
//}
