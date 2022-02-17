package com.algo.bj.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 통나무건너뛰기2 {
	// 최소난이도 출력
	static int T, N;
	static int[] arr;
//	static boolean[] visit;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine()); // 5~10,000
			arr = new int[N];
//			visit = new boolean[N];
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			} // end input

			Arrays.sort(arr); // 정렬하고

			for(int i=0;i<N;i++) {
				int me = arr[i];
				int[] tmp = new int[N];
				boolean[] visit = new boolean[N];
				visit[i]= true;
				pick(me,0,tmp,visit);
			}
			
			System.out.println(min);

		}
	}

	private static void pick(int me, int cnt, int[] lr,boolean[] visit) {
		if(cnt==2) {
			int left = lr[0];
			int right = lr[1];
			int d_left = Math.abs(left-me);
			int d_right = Math.abs(right-me);
			if(d_left>d_right) {
				if(min>d_left) {
					min = d_left;
				}
			}else {
				if(min>d_right) {
					min = d_right;
				}
			}
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				lr[cnt] = arr[i];
				pick(me,cnt+1,lr, visit);
				lr[cnt]=0;
				visit[i] = false;
			}
		}
	}
}
