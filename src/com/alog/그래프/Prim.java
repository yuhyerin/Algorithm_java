package com.alog.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Prim {
	
	public static class Edge implements Comparable<Edge>{
		int node;
		double dis;
		public Edge(int node, double dis) {
			this.node = node;
			this.dis = dis;
		}
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.dis, o.dis);
		}
	}
	static int V,E, answer = 0, cnt=0;
	static ArrayList<ArrayList<Edge>> graph;
	static boolean[] visit;
	static PriorityQueue<Edge> que;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		que = new PriorityQueue<>();
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for(int i=0; i<V; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Edge(b,dis));
			graph.get(b).add(new Edge(a,dis));
		}
		que.add(new Edge(0,0)); // 임의의 정점 0부터 시작. 
		
		while(!que.isEmpty()) {
			Edge cur = que.poll();
			if(visit[cur.node]) continue; 
			visit[cur.node]=true; //방문처리 
			answer+=cur.dis;
			for(Edge next: graph.get(cur.node)) { // 연결된 노드들을 돌면서 방문하지 않았으면 큐에 넣기 
				if(visit[next.node]) {
					que.add(next);
				}
			}
			if(cnt++==V) {
				break;
			}
		}
		System.out.println(answer);
		
	}
}
