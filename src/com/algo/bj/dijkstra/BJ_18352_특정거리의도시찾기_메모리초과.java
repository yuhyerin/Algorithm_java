package com.algo.bj.dijkstra;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_18352_특정거리의도시찾기_메모리초과 {

	public static int INF = Integer.MAX_VALUE;
	public static int N, M, K, X;
	public static int[][] map;
	public static int[] distance;
	public static boolean[] check;

	public static void main(String[] args) {
		// 1~N 번 도시
		// M개의 단방향 도로 ( 모든 도로의 거리는 1 )
		// 특정도시 X 부터출발해서 최단거리가 정확히 K 인 도시들의 번호를 출력
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 노드갯수 : 4 ( N:2~300,000)
		M = sc.nextInt(); // 도로갯수 : 4 ( M:1~1,000,000)
		K = sc.nextInt(); // 최단거리 : 2 ( K:1~300,000)
		X = sc.nextInt(); // 출발노드 : 1 ( X:1~N )

		map = new int[N + 1][N + 1];
		distance = new int[N + 1];
		check = new boolean[N + 1];
		
		for(int i=0; i<=N; i++) {
			Arrays.fill(map[i], INF);
		}// map 최대값으로 초기화 
		
		for(int i=0; i<M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			map[A][B]=1;
		}//end input
		
		Arrays.fill(distance, INF);
		for(int i=1; i<= N ; i++) {
			distance[i] = map[X][i];
		} // distance 초기화 
		
		check[X] = true; // 시작점 초기화 
		
		dijkstra(X);
		
		for(int i=1; i<=N; i++) {
			if(distance[i]==K) {
				System.out.println(i);
			}
		}

	}

	public static int getSmallIndex() {
		int min= INF;
		int index = -1;
		for(int i=1; i<= N; i++) {
			if(distance[i] < min && !check[i]) {
				min = distance[i];
				index = i;
			}
		}
		return index;
	}
	
	public static void dijkstra(int start) {
		
		for(int i=0; i< N-2 ; i++) {
			int cur = getSmallIndex();
			if(cur==-1) continue;
			check[cur] = true;
			for(int j=1; j<=N; j++) {
				if(!check[j] && map[cur][j]!= INF && (distance[cur] + map[cur][j]) < distance[j]) {
					distance[j] = distance[cur] + map[cur][j];
				}
			}
		}
	}
	
	public static void printDistance() {
		for(int i=1; i<=N; i++) {
			System.out.print(distance[i]+" ");
		}
		System.out.println();
	}

}
