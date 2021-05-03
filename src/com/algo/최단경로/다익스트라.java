package com.algo.최단경로;

import java.util.Arrays;

public class 다익스트라 {
	
	static int number = 6;
	static int INF = 10000000;
	static int[][] map;
	static int[] distance;
	static boolean[] check;
	
	public static void main(String[] args) {
		map = new int[][] { 
				{INF,INF,INF,INF,INF,INF,INF},
				{INF,0,2,5,1,INF,INF},
				{INF,2,0,3,2,INF,INF},
				{INF,5,3,0,3,1,5},
				{INF,1,2,3,0,1,INF},
				{INF,INF,INF,1,1,0,2},
				{INF,INF,INF,5,INF,2,0}};
		distance = new int[number+1];
		check = new boolean[number+1];
		Arrays.fill(distance, INF);
		System.out.println("시작정점!!!  ==> "+ 1);
		dijkstra(1);
		for(int i=1; i<=number; i++) {
			System.out.print(distance[i]+" ");
		}
		System.out.println();
	}
	
	public static int getSmallIndex() {
		int min= INF;
		int index = -1;
		for(int i=1; i<= number; i++) {
			if(distance[i] < min && !check[i]) {
				min = distance[i];
				index = i;
			}
		}
		return index;
	}
	
	public static void dijkstra(int start) {
		for(int i=1; i<= number ; i++) {
			distance[i] = map[start][i];
		} // distance 초기화 
		check[start] = true; // 시작점 초기화 
		for(int i=0; i< number-2 ; i++) {
			int cur = getSmallIndex();
			check[cur] = true;
			System.out.println("지금 비용이 최저인 인덱스는 : "+cur);
			for(int j=1; j<=number; j++) {
				if(!check[j] && (distance[cur] + map[cur][j]) < distance[j]) {
					distance[j] = distance[cur] + map[cur][j];
					System.out.println(start+"부터 "+cur+"까지의 거리는 : "+distance[cur]);
					System.out.println(cur+"부터"+j+"까지 거리는"+map[cur][j]);
					System.out.println("그래서 "+distance[j]+"로 갱신됨! ");
				}
			}
		}
	}

}
