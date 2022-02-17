package com.algo.bj.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 통나무건너뛰기 {
	// 최소난이도 출력
	static int T, N;
	static int[] arr;
	static boolean[] visit;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine()); // 5~10,000
			arr = new int[N];
			visit = new boolean[N];
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			} // end input

			Arrays.sort(arr); // 정렬하고

			int[] tmp = new int[N];
			perm(0, tmp);
			System.out.println(min);

		}
	}

	private static void perm(int cnt, int[] myNum) {

		if (cnt == N) {
			findMin(myNum);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				myNum[cnt] = arr[i];
				perm(cnt+1, myNum);
				myNum[cnt] = 0;
				visit[i] = false;
			}
		}
	}

	private static void findMin(int[] tmp) {
		int diff = Math.abs(tmp[N-1]-tmp[0]);
		for (int i = 0; i < N - 1; i++) {
			int s = Math.abs(tmp[i + 1] - tmp[i]);
			if (diff < s) {
				diff = s;
			}
		}// end for 
		
		if(min>diff) {
			min = diff;
		}

	}

}
