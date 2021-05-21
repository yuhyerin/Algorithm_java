package com.algo.bj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_4195_친구네트워크 {
	
	static int[] parent;
	static int[] rank;
	static int[] count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 수 
		for(int t=0; t<T; t++) {
			Map<String, Integer> map = new HashMap<>();
			int F = Integer.parseInt(br.readLine()); // 친구관계 수 (100,000)
			parent = new int[100001];
			count = new int[100001];
			rank = new int[100001];
			for(int i=1; i<=100000; i++) {
				parent[i]=i;
				count[i]=1;
				rank[i]=0;
			}// 초기화 
			int cnt = 1;
			for(int f=0; f<F; f++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String name1 = st.nextToken();
				String name2 = st.nextToken();
				if(!map.containsKey(name1)) {
					map.put(name1, cnt++);
				}
				if(!map.containsKey(name2)) {
					map.put(name2, cnt++);
				}
				int a = map.get(name1);
				int b = map.get(name2);
				if(!isSameParent(a,b)) {
					union(a,b);
				}
			}
			int debug = 1;
		}
		
	}
	
	private static boolean isSameParent(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b) return true;
		return false;
	}

	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b) return;
		if(rank[a]>=rank[b]) {
			parent[b]=a;
			count[a]= count[a]+count[b];
			rank[a]++;
			System.out.println(count[a]);
		}else {
			parent[a]=b;
			count[b]= count[a]+count[b];
			rank[b]++;
			System.out.println(count[b]);
		}
//		for(int i = 1; i <= 4; i++)
//			System.out.print(count[i]);
//		System.out.println();
	}
	
	public static int find(int a) {
		while(parent[a]!=a) {
			a = parent[a];
		}
		return a;
	}
	
	public static void printArr() {
		for(int i=1; i<rank.length; i++) {
			if(rank[i]!=0) {
				System.out.println(i+" 의 rank는 "+rank[i]);
			}
		}
		System.out.println();
	}
}
