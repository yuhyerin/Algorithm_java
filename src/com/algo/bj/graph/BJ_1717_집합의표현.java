package com.algo.bj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Union Find 알고리즘 

public class BJ_1717_집합의표현 {

	static int[] parent = new int[1000001];
	static int[] rank = new int[1000001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // n(1 ≤ n ≤ 1,000,000)
		int m = Integer.parseInt(st.nextToken()); // m(1 ≤ m ≤ 100,000)
		
		for(int i=1; i<=n; i++) {
			parent[i]=i;
		}//초기화 
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int exp = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(exp==0) {
				union(a,b);
			}else {
				if(isSameParent(a,b)) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
		}
	}
	
	private static boolean isSameParent(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b) {
			return true;
		}
		return false;
	}

	public static int find(int a) {
		while(parent[a]!=a) {
			a = parent[a];
		}
		return a;
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
        if(a==b) return;
		if(parent[a]!=parent[b]) {
			parent[b]=a;
		}
	}
}