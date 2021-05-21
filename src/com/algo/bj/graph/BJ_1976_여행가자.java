package com.algo.bj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJ_1976_여행가자 {
	static int[] parent;
	static int[] plan;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= null;
		int N = Integer.parseInt(br.readLine()); // N개의 도시 (200이하)
		int M = Integer.parseInt(br.readLine()); // 여행계획에 속한 도시들의 수 : M (1000이하) 
		parent = new int[N+1];
		plan = new int[M];
		for(int i=1; i<=N; i++) {
			parent[i]=i;
		}//초기화 
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				if(Integer.parseInt(st.nextToken())==1) {
					if(!isSameParent(i,j)) {
						union(i,j);
					}
				}
			}
		}// end for
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			plan[i] = Integer.parseInt(st.nextToken());
		}// end 여행계획 
		
		boolean isSuccess = true;
		for(int i=0; i<M-1; i++) {
			if(!isSameParent(plan[i],plan[i+1])) {
				isSuccess = false;
				System.out.println("NO");
				break;
			}
		}
		if(isSuccess) {
			System.out.println("YES");
		}
	}
	
	public static boolean isSameParent(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b) return true;
		return false;
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b) return;
		parent[b]=a;
	}
	
	public static int find(int a) {
		while(parent[a]!=a) {
			a=parent[a];
		}
		return a;
	}
}
