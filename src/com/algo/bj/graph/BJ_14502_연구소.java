package com.algo.bj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class BJ_14502_연구소 {
	// map ---> 0: 빈칸, 1:벽, 2:바이러스 
	// 1. 3개의 벽을 반드시 세워야 함.
	// 2. 바이러스가 퍼질 수 없는곳을 안전영역. 
	// 3. 바이러스 갯수는 2개 이상. 10개 이하. 
	// 4. 빈칸수는 3개 이상.
	// 안전영역의 최대값 구하기. 
	
	static int N,M;
	static int[][] map;
	static int[][] copy;
	static List<int[]> virusList;
	static List<int[]> empty;
	static int len;
	static boolean[] visit;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 3~8 
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		virusList = new ArrayList<>(); // 바이러스 좌표 저장할 리스트
		empty = new ArrayList<>(); // 빈공간(== 벽을 세울 수 있는 공간)좌표 저장할 리스트
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) virusList.add(new int[] {i,j}); // 바이러스 좌표 저장.
				if(map[i][j]==0) empty.add(new int[] {i,j}); // 빈칸 좌표 저장.
			}
		}// end input
		
		len = empty.size(); // 빈칸 갯수
		visit = new boolean[len];
		max = 0;
		// 1. 벽3개 세우기.
		int[][] wall = new int[3][2];
		buildWall(-1, 0, wall);
		System.out.println(max);
		
	}
	
	// 벽 세우기
	private static void buildWall(int idx, int cnt, int[][] wall) {
		
		if(cnt==3) { // 3개의 벽을 세웠으면
			copy = new int[N][M];
			for(int i=0; i<N; i++) {
				copy[i] = map[i].clone();
			} // 카피본을 하나 준비. 
			
			for(int d=0; d<3; d++) {
				int y = wall[d][0];
				int x = wall[d][1];
				copy[y][x] = 1;
			}
			spreadVirus(); // 바이러스 전파
			maxSafeArea(); // 안전영역 최대값 갱신하기
			return;
		}
		
		for(int i=idx+1; i<len; i++) {
			if(!visit[i]) {
				visit[i] = true;
				wall[cnt][0] = empty.get(i)[0];
				wall[cnt][1] = empty.get(i)[1];
				buildWall(i, cnt+1, wall);
				visit[i] = false;
			}
		}
		
	}
	// 최대 안전영역값 갱신 
	private static void maxSafeArea() {
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(copy[i][j]==0) {
					cnt++;
				}
			}
		}// end for 
		
		if(max < cnt) {
			max = cnt;
		}
	}

	static int[] dy = {-1,1,0,0}; //상 하 좌 우 
	static int[] dx = {0,0,-1,1}; //상 하 좌 우
	// 바이러스 퍼뜨리기
	private static void spreadVirus() {
		boolean[][] sVisit = new boolean[N][M];
		Queue<int[]> virus = new LinkedList<>();
		for(int idx=0; idx<virusList.size(); idx++) {
			virus.add(new int[] {virusList.get(idx)[0],virusList.get(idx)[1]});
		}
		
		while(!virus.isEmpty()) {
			int[] v = virus.poll();
			int vy = v[0];
			int vx = v[1];
			
			if(!sVisit[vy][vx]) {
				sVisit[vy][vx] = true;
				
				for(int d=0; d<4; d++) { // 4방향탐색
					int ny = vy + dy[d];
					int nx = vx + dx[d];
					if(!canGo(ny,nx)) continue;
					if(copy[ny][nx]==0) {
						copy[ny][nx]=2; //바이러스 전파
						virus.add(new int[] {ny,nx});
					}
				}// end for 
			}// end if 
		}// end while 
		
	}

	private static boolean canGo(int y, int x) {
		if(0<= y && y<N && 0<= x && x<M) return true;
		return false;
	}
}
