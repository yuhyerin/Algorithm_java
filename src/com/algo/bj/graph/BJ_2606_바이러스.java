package com.algo.bj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2606_바이러스 {
	/** input 
	 * 첫째 줄에는 컴퓨터의 수가 주어진다. 
	 * 컴퓨터의 수는 100 이하이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다. 
	 * 둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다. 
	 * 이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.*/
	
	/** output 
	 * 1번 컴퓨터가 웜 바이러스에 걸렸을 때, 
	 * 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다. */
	
	static int[] parent = new int[101];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine()); // 컴퓨터 수 
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=100; i++) {
			parent[i]=i;
		}// parent 초기화 
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(!isSameParent(a,b)) {
				union(a,b);
			}
		}
		int count=0;
		for(int i=2; i<=100; i++) {
			if(find(i)==1) {
				count++;
			}
		}
		System.out.println(count);
		
	}
	private static int find(int a) {
		while(parent[a]!=a) {
			a = parent[a];
		}
		return a;
	}
	
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b) return;
		if(a<b) {
			parent[b]=a;
		}else {
			parent[a]=b;
		}
		
	}
	private static boolean isSameParent(int a, int b) {
		a=find(a);
		b=find(b);
		if(a==b) return true;
		return false;
	}
}
