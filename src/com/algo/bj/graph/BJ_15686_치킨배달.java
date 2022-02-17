package com.algo.bj.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_15686_치킨배달 {
	static int N,M;
	static int[][] map; // 0:빈칸, 2:치킨집, 1: 집
	static int[][] pick;
	static ArrayList<int[]> homes;
	static ArrayList<int[]> chickens;
	static int min;
	
	// 치킨거리 : 집과 가장 가까운 치킨집 사이의 거리. 
	// 도시의 치킨거리는 모든집의 치킨거리의 합!
	// 도시의 치킨거리가 가장 작게될 M개의 치킨집을 고르자! 
	// 출력 : 도시의 치킨거리 최소값 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // N: 2~50 
		M = Integer.parseInt(st.nextToken()); // M: 1~13 
		map = new int[N][N];
		pick = new int[N][N];
		homes = new ArrayList<int[]>();
		chickens = new ArrayList<int[]>();
		min = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) homes.add(new int[] {i,j}); //집이면 리스트에 담기
				if(map[i][j]==2) chickens.add(new int[] {i,j}); //치킨집
			}
		}// end input
		
		if(chickens.size()==M) { // 전체 치킨집 수가 M개일 경우
			int dist = calcChickenDist(chickens);
			if(min>dist) {
				min = dist;
			}
			System.out.println(min);
			return;
		}
		
		ArrayList<int[]> pickChickens = new ArrayList<int[]>();
		pickChicken(0, pickChickens); // 치킨집 M개 고르기.
		System.out.println(min);
		
	}

	private static void pickChicken(int cnt, ArrayList<int[]> pickChickens) {
		if(cnt == M) { // M개의 치킨집을 골랐으면.
			int dist = calcChickenDist(pickChickens); // 치킨거리 계산.
			if(min > dist) {
				min = dist;
			}
			return;
		}
		
		for(int[] chicken : chickens) {
			int cy = chicken[0];
			int cx = chicken[1];
					
			if(pick[cy][cx]==0) { // 치킨집이면
				pick[cy][cx]=2; // 뽑은 치킨집 표시
				pickChickens.add(new int[] {cy,cx});
				pickChicken(cnt+1, pickChickens);
				pick[cy][cx]=0; // 뽑은거 원복.
				pickChickens.remove(pickChickens.size()-1);
			}
		}
		
	}

	private static int calcChickenDist(ArrayList<int[]> pickChickens) {
		int result = 0;
		for(int[] home: homes) {
			int hy = home[0]+1;
			int hx = home[1]+1;
			int minDist = Integer.MAX_VALUE;
			for(int[] chicken : pickChickens) {
				int cy = chicken[0]+1;
				int cx = chicken[1]+1;
				int dist = Math.abs(hy-cy) + Math.abs(hx-cx);
				if(minDist > dist) {
					minDist = dist;
				}
			}// end chicken집 루프 
			result += minDist;
		}// end for 
		
		return result;
		
	}

}
