package com.algo.bj.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_4195_친구네트워크 {
	
	static int[] parent;
	static int[] rank;
	static int[] count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 수 
		for(int t=0; t<T; t++) {
			Map<String, Integer> map = new HashMap<>();
			int F = Integer.parseInt(br.readLine()); // 친구관계 수 (100,000)
			parent = new int[2*F+1];
			count = new int[2*F+1];
			rank = new int[2*F+1];
			for(int i=1; i<=2*F; i++) {
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
					sb.append(union(a,b)+"\n");
				}
			}
		}
		bw.write(sb.toString());
		bw.flush();
        bw.close();
        br.close();
	}
	
	private static boolean isSameParent(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b) return true;
		return false;
	}

	public static int union(int a, int b) {
		a = find(a);
		b = find(b);
		if(rank[a]>=rank[b]) {
			parent[b]=a;
			count[a]= count[a]+count[b];
			rank[a]++;
			return count[a];
		}else {
			parent[a]=b;
			count[b]= count[a]+count[b];
			rank[b]++;
			return count[b];
		}
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
