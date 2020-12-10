package com.algo.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class L3_가장먼노드 {
	/** n개의 노드가 있는 그래프 
	 * 각 노드는 1~n 번호가 적혀있다.
	 * 1번노드에서 가장 멀리떨어진 노드의 갯수를 구한다! 
	 * */
	public static void main(String[] args) {
		L3_가장먼노드 t = new L3_가장먼노드();
		int n = 6;
		int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		int result = t.solution(n, edge);
		System.out.println(result);
	}
	
	public int solution(int n, int[][] edge) {
        int answer = 0;
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<edge.length; i++) {// 초기화 
        	list.add(new ArrayList<Integer>()); 
        }
        
        for(int i=0; i<edge.length;i++) {// 노드 연결 
        	int a = edge[i][0];
        	int b = edge[i][1];
        	list.get(a).add(b);
        	list.get(b).add(a);
        }
        
        int[] count = new int[n+1]; // 1과의 거리를 저장할 배열 
        boolean[] visited = new boolean[n+1]; //방문체크 
        Queue<Integer> que = new LinkedList<>();
        que.add(1); // 시작점 
        visited[1]=true;
        int cur;
        while(!que.isEmpty()) {
        	cur = que.poll();
        	System.out.print("현재 cur : "+cur+" 과 연결된 노드들 ");
        	for(int v : list.get(cur)) { // 나랑 연결된 노드들 
        		if(!visited[v]) {
        			System.out.print(v);
        			count[v] = count[cur]+1; // 1과의 길이를 저장.
        			System.out.print(" - 거리 "+count[v]+"   ");
        			visited[v]=true;
        			que.add(v);
        		}
        	}
        	System.out.println();
        }
        
        int max = 0;
        for(int cnt: count) {
        	if(max<cnt) {
        		max = cnt;
        		answer = 1;
        	}else if(max == cnt) {
        		answer++;
        	}
        }
        
        return answer;
    }

}
