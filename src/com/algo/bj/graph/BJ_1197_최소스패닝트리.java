package com.algo.bj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_1197_최소스패닝트리 {
	/** input : 
	 * 첫째 줄에 정점의 개수 V(1 ≤ V ≤ 10,000)와 간선의 개수 E(1 ≤ E ≤ 100,000)가 주어진다. 
	 * 다음 E개의 줄에는 각 간선에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다. 
	 * 이는 A번 정점과 B번 정점이 가중치 C인 간선으로 연결되어 있다는 의미이다. 
	 * C는 음수일 수도 있으며, 절댓값이 1,000,000을 넘지 않는다.
	 * 그래프의 정점은 1번부터 V번까지 번호가 매겨져 있고, 임의의 두 정점 사이에 경로가 있다. 
	 * 최소 스패닝 트리의 가중치가 -2,147,483,648보다 크거나 같고, 2,147,483,647보다 작거나 같은 데이터만 입력으로 주어진다.*/
	
	/** 
	 	3 3
		1 2 1
		2 3 2
		1 3 3
	*/
	
	// output : 첫째 줄에 최소 스패닝 트리의 가중치를 출력한다.
	
	static int[][] edges;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken()); // V(1 ≤ V ≤ 10,000)
		int E = Integer.parseInt(st.nextToken()); // E(1 ≤ E ≤ 100,000)
		edges = new int[E][3]; // 간선 갯수만큼만 정보 저장 
		parent = new int[V+1];
		for(int i=1; i<=V; i++) {
			parent[i]=i;
		}//parent 초기화
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			edges[i][0] = A;
			edges[i][1] = B;
			edges[i][2] = C;
		}// end input 
		
		// 가중치 순서대로 정렬하기. 
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		
		// 가중치가 낮은 간선부터 선택해 나가기.
		int sum = 0;
		for(int i=0; i<E; i++) {
			int a = edges[i][0];
			int b = edges[i][1];
			if(!isSameParent(a,b)) {
				union(a,b);
				sum+= edges[i][2];
			}
		}
		System.out.println(sum);
		
	}
	
	public static boolean isSameParent(int a, int b) {
		System.out.println("====isSameParent( "+a+" , "+b+" )");
		a = find(a);
		b = find(b);
		System.out.println("a: "+a+", b: "+b);
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
	
	public static void union(int a,int b) {
		System.out.println("=====union( "+a+" , "+b+" )");
		a = find(a);
		b = find(b);
		System.out.println("a: "+a+", b: "+b);
		if(a==b) return;
		parent[b]=a;
		printParent();
	}
	
	public static void printParent() {
		System.out.print("=== parent[] : ");
		for(int i=1; i< parent.length; i++) {
			System.out.print(parent[i]+" ");
		}
		System.out.println();
	}
}
