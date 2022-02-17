package com.algo.kakao.internship;
import java.util.Comparator;
import java.util.PriorityQueue;

public class test4 {
	public static void main(String[] args) {
		test4 t = new test4();
		int n =4;
		int start = 1;
		int end = 4;
//		int[][] roads = {{1, 2, 2}, {3, 2, 3}};
		int[][] roads = {{1, 2, 1}, {3, 2, 1}, {2, 4, 1}};
//		int[] traps = {2};
		int[] traps = {2,3};
		int result = t.solution(n, start, end, roads, traps);
		System.out.println(result);
	}

	int[][] edges = new int[1001][1001];
	boolean[] is_trap = new boolean[1001];
	class MyComparator implements Comparator<int[]> {
		@Override
		public int compare(int[] o1, int[] o2) {
			return o1[1] - o2[1];
		}
	}
	PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new MyComparator());

	void active_trap(int size, int n){ // swap
	    for(int i = 1; i <= size; i++){
	        edges[n][i] = edges[n][i] ^ edges[i][n];
	        edges[i][n] = edges[n][i] ^ edges[i][n];
	        edges[n][i] = edges[n][i] ^ edges[i][n];
	    }
	}

	int solution(int n, int start, int end, int[][] roads, int[] traps) {
	    int answer = 0;
	    for(int i = 0; i < roads.length; i++){
	        if(edges[roads[i][0]][roads[i][1]] == 0) {
	            edges[roads[i][0]][roads[i][1]] = roads[i][2];
	        }
	        else{
	            if(roads[i][2] < edges[roads[i][0]][roads[i][1]]){
	                edges[roads[i][0]][roads[i][1]] = roads[i][2];
	            }
	        }
	    }//end input 
	    
	    for(int i = 0; i < traps.length; i++){
	        is_trap[traps[i]] = true;
	    }// trap 

	    pq.offer(new int[] {start, 0}); 
	    while(!pq.isEmpty()){
	        int cur = pq.peek()[0];
	        int weight = pq.peek()[1];
	        pq.poll();
	        if(cur == end){
	            answer = weight;
	            break;
	        }
	        if(is_trap[cur]){ //트랩밟음 
	            active_trap(n, cur);
	        }
	        
	        for(int i = 1; i <= n; i++){
	            if(edges[cur][i] > 0){ // 연결되있으면 
	                pq.offer(new int[] {i, weight + edges[cur][i]});
	            }
	        }
	    }
	    return answer;
	}
	
	void printEdges(int n) {
		for(int i=1; i<=n; i++) {
			for(int j=1;j<=n; j++) {
				System.out.print(edges[i][j]+" ");
			}
			System.out.println();
		}
	}
}
