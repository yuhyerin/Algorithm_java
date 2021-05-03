package com.algo.bj.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_18352_특정거리의도시찾기_그리디방식으로 {

	public static int INF = Integer.MAX_VALUE;
	public static int N, M, K, X;
	public static int[] distance;
	public static List<Integer>[] list;

	public static void main(String[] args) throws IOException {
		// 1~N 번 도시
		// M개의 단방향 도로 ( 모든 도로의 거리는 1 )
		// 특정도시 X 부터출발해서 최단거리가 정확히 K 인 도시들의 번호를 출력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken()); // 노드갯수 : 4 ( N:2~300,000)
		M = Integer.parseInt(st.nextToken()); // 도로갯수 : 4 ( M:1~1,000,000)
		K = Integer.parseInt(st.nextToken()); // 최단거리 : 2 ( K:1~300,000)
		X = Integer.parseInt(st.nextToken()); // 출발노드 : 1 ( X:1~N )

		list = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		// distance MAX 값으로 초기화 
		distance = new int[N + 1];
		Arrays.fill(distance, INF);
				
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());;
			int B = Integer.parseInt(st.nextToken());;
			list[A].add(B);
		}//end input
		
		// 시작점 초기화 
		distance[X] = 0;
		
		// 우선순위 큐 생성 
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.offer(X);
		
		while(!pq.isEmpty()) {
			int cur = pq.poll();
			for(int node : list[cur]) {
				if(distance[node] > distance[cur]+1) {
					distance[node] = distance[cur]+1;
					pq.offer(node);
				}
			}
		}// end while
		
		boolean flag = false;
		for(int i=1; i<=N; i++) {
			if(distance[i]==K) {
				flag = true;
				System.out.println(i);
			}
		}
		if(!flag) {
			System.out.println(-1);
		}

	}
	
	public static void printDistance() {
		System.out.println("===print distance[ ]====");
		for(int i=1; i<=N; i++) {
			System.out.print(distance[i]+" ");
		}
		System.out.println();
	}
}
