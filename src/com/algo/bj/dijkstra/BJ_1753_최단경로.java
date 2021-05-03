package com.algo.bj.dijkstra;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_1753_최단경로 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt(); // 정점 갯수 ( 1 <= V <= 20,000 )
		int E = sc.nextInt(); // 간선 갯수 ( 1 <= E <= 300,000 )
		int K = sc.nextInt(); // 시작정점 번호 ( 1 <= K <= V )

		int[][] map = new int[V + 1][V + 1]; // 방향그래프
		int[] distance = new int[V + 1]; // 최단거리
		boolean[] check = new boolean[V + 1]; // 방문체크

		for (int i = 0; i < E; i++) {
			int u = sc.nextInt(); // u에서
			int v = sc.nextInt(); // v로 가는
			int w = sc.nextInt(); // 가중치 w 인 간선 (10이하의 자연수)
			map[u][v] = w;
		} // end input

		int MAX_VAL = 11;
		Arrays.fill(distance, MAX_VAL); // 최대값으로 초기화

		// 시작노드값 초기화
		distance[K] = 0;
		check[K] = true;

		// 연결된노드 distance 갱신
		for (int i = 1; i <= V; i++) {
			if (!check[i] && map[K][i] != 0) { // 방문하지 않았으면서, 연결된 간선이 있는 노드들
				distance[i] = map[K][i];
			}
		}

		for (int i = 0; i < V - 1; i++) {// 나빼고 나머지 정점갯수만큼 반복
			int min = MAX_VAL;
			int min_idx = -1;

			// 최소값 찾기
			for (int j = 1; j <= V; j++) {
				if (!check[j] && distance[j] < min) {
					min = distance[j];
					min_idx = j;
					check[min_idx] = true;
				}
			}
			
			if(min_idx != -1) {
				for (int j = 1; j <= V; j++) {
					if (!check[j] && map[min_idx][j] != 0) { // 아직 방문하지 않았으면서, 연결된 간선이 존재하고, 
						if (distance[j] > distance[min_idx] + map[min_idx][j]) { // ( j까지 거리 ) > ( min까지의 거리 + min~j까지 거리 ) 이면 갱신
							distance[j] = distance[min_idx] + map[min_idx][j];
						}
					}
				}
			}
		}

		// 결과 출력
		for (int i = 1; i <= V; i++) {
			if(distance[i]==MAX_VAL) {
				System.out.println("INF");
			}else {
				System.out.println(distance[i]);
			}
		}

	}

}
