package com.algo.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class L3_����ճ�� {
	/** n���� ��尡 �ִ� �׷��� 
	 * �� ���� 1~n ��ȣ�� �����ִ�.
	 * 1����忡�� ���� �ָ������� ����� ������ ���Ѵ�! 
	 * */
	public static void main(String[] args) {
		L3_����ճ�� t = new L3_����ճ��();
		int n = 6;
		int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		int result = t.solution(n, edge);
		System.out.println(result);
	}
	
	public int solution(int n, int[][] edge) {
        int answer = 0;
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<edge.length; i++) {// �ʱ�ȭ 
        	list.add(new ArrayList<Integer>()); 
        }
        
        for(int i=0; i<edge.length;i++) {// ��� ���� 
        	int a = edge[i][0];
        	int b = edge[i][1];
        	list.get(a).add(b);
        	list.get(b).add(a);
        }
        
        int[] count = new int[n+1]; // 1���� �Ÿ��� ������ �迭 
        boolean[] visited = new boolean[n+1]; //�湮üũ 
        Queue<Integer> que = new LinkedList<>();
        que.add(1); // ������ 
        visited[1]=true;
        int cur;
        while(!que.isEmpty()) {
        	cur = que.poll();
        	System.out.print("���� cur : "+cur+" �� ����� ���� ");
        	for(int v : list.get(cur)) { // ���� ����� ���� 
        		if(!visited[v]) {
        			System.out.print(v);
        			count[v] = count[cur]+1; // 1���� ���̸� ����.
        			System.out.print(" - �Ÿ� "+count[v]+"   ");
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
