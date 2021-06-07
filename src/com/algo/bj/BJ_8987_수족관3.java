package com.algo.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_8987_수족관3 {
	static int N; //꼭짓점 갯수 (4~300,000) 
	static int K; //뚫어야할 구멍 갯수 (1~N/2)
	static List<long[]> list;
	static List<long[]> hole;
	static long[] height;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		list = new ArrayList<long[]>();
		hole = new ArrayList<long[]>();
		long answer = 0; // 최대로 배출되는 물의양.
		N = Integer.parseInt(br.readLine());
		int maxR = 0;
		int maxC = 0;
		st = new StringTokenizer(br.readLine());
		// 꼭지점은 항상 (0,0)으로 시작해서, (A,0)으로 끝난다.
		list.add(new long[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())}); //(0,0) 
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(r>maxR) {
				maxR=r;
			}
			if(c>maxC) {
				maxC=c;
			}
			list.add(new long[] {r,c});
			if(i%2==1) {
				hole.add(new long[] {r,c});
			}
		}
		K = Integer.parseInt(br.readLine());
		boolean[] check = new boolean[hole.size()];
		height = new long[maxC];
		for(int i=0; i<maxC;i++) {
			
		}
		pickHole(K,0,0,check);
		
	}
	private static void pickHole(int K, int cnt, int cur, boolean[] check) {
		if(cnt==K) {// 다 고름
			System.out.println("선택된 홀");
			for(int i=0; i<check.length;i++) {
				if(check[i]) {
					System.out.println(hole.get(i)[0]+","+hole.get(i)[1]);
				}
			}
		}
		for(int i=cur; i<hole.size();i++) {
			if(!check[i]) {
				check[i]=true;
				pickHole(K,cnt+1,i+1,check);
			}
			check[i]=false;
		}
	}
}
