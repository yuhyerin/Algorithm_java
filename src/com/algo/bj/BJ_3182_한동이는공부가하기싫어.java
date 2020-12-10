package com.algo.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_3182_한동이는공부가하기싫어 {
	
	static int N;
	static int answer;
	static int max_cnt = Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		int[] sunbae = new int[N+1];
		answer = 0;
		
		for(int i=1; i<=N; i++) {
			sunbae[i] = Integer.parseInt(in.readLine()); // i번째 선배가 ㅇㅇㅇ한테 가래
		}
		
		for(int i=1; i<=N; i++) {
			go(sunbae, i);
		}
		
		System.out.println(answer);
		
	}

	private static void go(int[] sunbae, int cur) {
		
		boolean[] visit = new boolean[N+1];
		int start = cur;
		while(true) {
			if(!visit[cur]) {
				visit[cur]=true;
				int next = sunbae[cur];
				cur = next;
			}else {
				break;
			}
		}// end while
		
		int cnt =0;
		for(int i=0; i<visit.length; i++) {
			if(visit[i]) {
				cnt++;
			}
		}// end for
		
		if(cnt > max_cnt) {
			max_cnt = cnt;
			answer = start;
		}
	}
}
