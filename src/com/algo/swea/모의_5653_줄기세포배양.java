package com.algo.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 모의_5653_줄기세포배양 {
	/** 
	 * 줄기세포 비활성 상태.
	 * 생명력 수치가 x : x시간 동안 비활성화. x시간 지나는 순간 활성상태
	 * 활성상태되면, x시간동안 살아있고, x시간 지나면 죽는다.
	 * 활성상태되면, 1시간동안 상,하,좌,우 네방향으로 번식
	 * 두개이상의 줄기세포가 하나의 그리드셀에 동시번식하려는 경우 생명력 높은 줄기세포가 차지.
	 * */
	static int T;
	static int N,M,K;
	static int[][] cell;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(in.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken()); //2 (행)
			M = Integer.parseInt(st.nextToken()); //2 (열)
			K = Integer.parseInt(st.nextToken()); //10 (배양시간: 1~300)
			cell = new int[N][M];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=0; j<M; j++) {
					cell[i][j] = Integer.parseInt(st.nextToken());
				}
			}//end Input
			
			
		}// end testcase
	}

}
