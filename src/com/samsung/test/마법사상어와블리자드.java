package com.samsung.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 마법사상어와블리자드 {

	static int N; // 3~49 (홀수) 
	static int M; // 1~100
	static int[] dy = {-1,1,0,0}; // 4방향 위,아래,왼,오른 (정해진거!) 
	static int[] dx = {0,0,-1,1};
	static int d; // 1~4 
	static int s; // 1~ (N-1)/2
	static int[][] map; // map[i][j] = 0~100
	static int[] count;
	static ArrayList<Integer> marbles;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		count = new int[4]; // 1번, 2번, 3번구슬 폭파된 갯수 카운팅.
		marbles = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end map
		
		st = new StringTokenizer(br.readLine());
		d = Integer.parseInt(st.nextToken())-1;
		s = Integer.parseInt(st.nextToken());
		// end input 
		
		for(int i=0; i<M; i++) { // M번 시행 
			iceAttack(); // 1. 얼음 던져서 구슬 파괴. 
			
			System.out.println("=== 얼음공격 후 ===");
			printMap(); 
			
			move(); // 2. 이동. 
			
			System.out.println("=== 이동 후 리스트에 담긴 구슬들. ===");
			for(int m: marbles) {
				System.out.print(m+" ");
			}
			System.out.println("=== 이동 후 ===");
			printMap(); 
			
			
			while(true) {
				int groupCnt = getGroupCnt();
				if(groupCnt==0) break;
				groupExplosion(); // 3. 4개이상 연속된 구슬 폭발. 
				move();
			}
			
			// 4.연속된 구슬을 한그룹. --> A,B 2개의 구슬로 변환 
			changeAB();
		}// end for
		int result = 0;
		for(int i=1; i<=3; i++) {
			result += (i*count[i]);
		}
		System.out.println(result);
	}

	private static void changeAB() {
		// TODO Auto-generated method stub
		
	}

	private static void groupExplosion() {
		// TODO Auto-generated method stub
		
	}

	private static int getGroupCnt() {
		
		return 0;
	}

	private static void move() {
		int cnt = 0;
		int size = 1;
		int corner = 0;
		int dir = 2; // 왼쪽방향 부터 시작! 
		int ny = (N-1)/2;
		int nx = (N-1)/2;
		
		int[] dy = {0,1,0,-1}; // 여기서는 왼-아래-오른-위 순서대로 진행한다. 
		int[] dx = {-1,0,1,0}; 
		
		while(true) {
			cnt++;
			ny += dy[dir];
			nx += dx[dir];
			if(ny==0 && nx==0) break;
			
			// 구슬이 있으면 list에 넣기. 
			if(map[ny][nx]!=0) {
				marbles.add(map[ny][nx]);
			}
			
			// 반복횟수만큼 갔으면 다음방향으로 변경.
			if(cnt==size) {
				corner++;
				dir = (dir+1)%4;
				cnt = 0;
			}
			
			// 코너를 2번 돌때마다 반복횟수가 하나씩 증가함.
			if(corner == 2) {
				corner = 0;
				size++;
			}
		}
	}

	// 1. d 방향으로 거리가 s이하인 모든 칸에 얼음을 던져 구슬을 모두 파괴한다.
	private static void iceAttack() {
		int sy = (N-1)/2;
		int sx = (N-1)/2;
		for(int i=1; i<=s; i++) { // s이하인 모든 칸 
			int nsy = sy + dy[d]*i;
			int nsx = sx + dx[d]*i;
			if(!canGo(nsy, nsx)) continue;
			map[nsy][nsx] = 0;
		}
		
	}

	private static boolean canGo(int y, int x) {
		if(0<=y && y<N && 0<= x && x<N) {
			return true;
		}
		return false;
	}
	
	private static void printMap() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.printf("%3d",map[i][j]);
			}
			System.out.println();
		}
	}
}
