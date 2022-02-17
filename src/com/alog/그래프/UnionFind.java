package com.alog.그래프;

public class UnionFind {
	
	static int[] parent = new int[1000001];
	
	public static void main(String[] args) {
		for(int i=1; i<=8; i++) {
			parent[i]=i;
		}// parent 초기화 
		
		union(1,2); // 1번노드, 2번노드 연결 
		union(2,3); // 2번노드, 3번노드 연결 
		System.out.println("1번이랑 3번 연결 되어있나요? "+isSameParent(1,3));
	}
	
	public static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		if(x==y) {
			return true;
		}
		return false;
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y) {
			parent[y]=x; // (x < y 라는것을 가정) 
		}
	}
	
	public static int find(int x) {
		if(x==parent[x]) {
			return x;
		}else {
			parent[x]= find(parent[x]);
			return parent[x];
		}
		
	}
}
