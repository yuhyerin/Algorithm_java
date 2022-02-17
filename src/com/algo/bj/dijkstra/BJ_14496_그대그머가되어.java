package com.algo.bj.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14496_그대그머가되어 {
	static int a, b;
	static int N,M;
	static int cnt;
	static int MIN = Integer.MAX_VALUE;
	static ArrayList<Integer>[] list;
	static int[] distance;
	
	static class Node implements Comparable<Node>{
		int num;
		int weight;
		public Node(int num, int weight) {
			super();
			this.num = num;
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "Node [num=" + num + ", weight=" + weight + "]";
		}
		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken()); // 바꾸려는 문자 a 를  
		b = Integer.parseInt(st.nextToken()); // b 로 바꾸자 
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // N: 전체 문자의 수 ( 1~1,000 ) 
		M = Integer.parseInt(st.nextToken()); // M: 치환가능한 문자쌍 ( 1~10,000 )
		distance = new int[N+1];
		list = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
			distance[i] = Integer.MAX_VALUE;
		}// list, distance  초기화 
		distance[a]=0;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s); // 양방향 그래프임. 
		}// end Input 
		
		Queue<Node> que = new PriorityQueue<Node>();
		que.offer(new Node(a,0));
		
		while(!que.isEmpty()) {
			Node node = que.poll(); // a빼서 
			System.out.println(node);
			int cur = node.num;
			int d = node.weight;
			if(distance[cur] < d) continue;
			for(int next : list[cur]) {
				if(distance[next] > d+1 ) {
					distance[next] = d+1; // 갱신해주고 
					que.add(new Node(next, d+1));
				}
			}
		}
	
		if(distance[b]==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(distance[b]); // a -> b 바꾸기 위해 필요한 최소 치환 횟수 
		}
	}
}
