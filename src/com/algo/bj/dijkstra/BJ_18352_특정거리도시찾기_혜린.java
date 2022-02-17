package com.algo.bj.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_18352_특정거리도시찾기_혜린 {
	
	static int N,M,K,X;
	static ArrayList<Integer>[] list;
	static int[] distance;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 도시 수 (2~300,000) 
		M = Integer.parseInt(st.nextToken()); // 도로 수 (1~1,000,000)
		K = Integer.parseInt(st.nextToken()); // 거리정보 (1~300,000)
		X = Integer.parseInt(st.nextToken()); // 시작도시 (1~N)
		list = new ArrayList[N+1];
		distance = new int[N+1];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
		}// list 초기화 
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[start].add(end);
		}// end input 
		
		distance[X]=0;
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.offer(X);
		
		while(!pq.isEmpty()) {
			int cur = pq.poll(); // 하나꺼내서 
			for(int node : list[cur]) { // 꺼낸애랑 연결된 애들 하나씩 순회 
				if(distance[node] > distance[cur]+1) { // 연결된애들의 거리가 , 현재까지의 거리에 + 1한것보다 크면 갱신해주기 
					distance[node] = distance[cur]+1;
					pq.offer(node);
				}
			}
		}
		
		boolean check = false;
		for(int i=1; i<=N; i++) {
			if(distance[i]==K) {
				check = true;
				System.out.println(i);
			}
		}
		if(!check) {
			System.out.println(-1);
		}
		
	}

}
