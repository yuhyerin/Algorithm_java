package com.algo.bj.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_5972_택배배송 {
	static int N; // N개의 헛간 ( 1~50,000)
	static int M; // M개의 양방향 길 ( 1~50,000) 
	// 각 길은 C_i (0~1,000) 마리의 소가 있다. 
	// 현서는 1에 있고, 찬홍이는 N에 있다. 
	// 최소 여물비용 출력. 
	static ArrayList<Hut>[] list;
	static int[] distance;
	static class Hut implements Comparable<Hut>{
		int start;
		int end;
		int weight;
		public Hut(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Hut o) {
			return this.start - o.start;
		}
		@Override
		public String toString() {
			return "Hut [start=" + start + ", end=" + end + ", weight=" + weight + "]";
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 6
		M = Integer.parseInt(st.nextToken()); // 8
		distance= new int[N+1];
		list = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<Hut>();
			distance[i] = Integer.MAX_VALUE;
		}//초기화
		distance[1]=0;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e= Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[s].add(new Hut(s,e,w));
			list[e].add(new Hut(e,s,w));
		}// end input 
		
		Queue<Integer> sortQue = new PriorityQueue<Integer>();
		sortQue.offer(1);
		
		while(!sortQue.isEmpty()) {
			int cur = sortQue.poll();
			for(Hut next : list[cur]){
				if(distance[next.end] > distance[next.start]+ next.weight) {
					distance[next.end] = distance[next.start] + next.weight; //갱신 
					sortQue.offer(next.end);
				}
			}
		}
		
		System.out.println(distance[N]);
		
		
		
		
		
	}
}
