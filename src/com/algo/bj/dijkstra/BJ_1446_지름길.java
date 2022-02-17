package com.algo.bj.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Road implements Comparable<Road>{
	int start;
	int end;
	int weight;
	Road(int start, int end, int weight){
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	@Override
	public int compareTo(Road r) {
		return this.start - r.start;
	}
	@Override
	public String toString() {
		return "Road [start=" + start + ", end=" + end + ", weight=" + weight + "]";
	}
	
}

class BJ_1446_지름길{
	static int result = 0;
	static int N,D;
	static ArrayList<Road>[] roadList;
	static int[] distance;
	static int MAX = 10001;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 지름길 갯수 ( 1~12 )
		D = Integer.parseInt(st.nextToken()); // 고속도로 길이 ( 1~10,000 )
		
		roadList = new ArrayList[10001];
		for(int i=0; i<10001; i++) {
			roadList[i] = new ArrayList<Road>();
		}// roadList 초기화 
		
		distance = new int[10001];
		for(int i=0; i<10001; i++) {
			distance[i] = i;
		}// distance 초기화 ( 지름길이 없다면 i만큼 걸리는게 초기값임 ) 
		
		PriorityQueue<Road> tmpPQ = new PriorityQueue<Road>();
		PriorityQueue<Road> pq = new PriorityQueue<Road>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			tmpPQ.add(new Road(start,end,weight));
		}// end input 
		
		while(!tmpPQ.isEmpty()) {
			Road now = tmpPQ.poll();
			pq.offer(now);
			roadList[now.start].add(now);
		}// roadList 값 넣기. 
		
		while(!pq.isEmpty()) {
			Road now = pq.poll(); // 하나 꺼내
			for(Road nextRoad : roadList[now.start]) { // 걔랑 연결된 애들을 하나씩 순회하면서 
				if(distance[nextRoad.end] > distance[nextRoad.start]+nextRoad.weight) { // end 까지의 거리가 // start까지 거리에다 + wieght 더한만큼보다 크면 갱신해주기 
					distance[nextRoad.end] = distance[nextRoad.start]+nextRoad.weight;
					// 초기화
					int start = nextRoad.end;
					for(int i = start+1 ; i<=D; i++) {
						if(distance[i] > distance[start] + (i-start)) {
							distance[i] = distance[start] + (i-start);
						}
					}
				}
			}
		}
		System.out.println(distance[D]);
		
		
		
		
		
	}
}