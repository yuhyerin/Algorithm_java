package com.algo.bj.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1707_이분그래프 {
	static int K,V,E;
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		K = Integer.parseInt(br.readLine());
		for(int k=0; k<K; k++) { // 2~5 
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken()); // 정점갯수 1~20,000
			E = Integer.parseInt(st.nextToken()); // 간선갯수 1~200,000
			parent= new int[V+1];
			for(int i=1; i<=V; i++) {
				parent[i]=i;
			}// 부모를 자기자신으로 초기화 
			
			for(int e=0; e<E; e++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()); //1
				int b = Integer.parseInt(st.nextToken()); //3
				find(a,b);
				
			}
		}
	}
	
	private static void find(int a, int b) {
		if(parent[a]<parent[b]) {
			parent[b]=parent[a];
		}else {
			parent[a]=parent[b];
		}
	}
}
