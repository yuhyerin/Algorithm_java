package com.algo.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14502_������ {

	/**
	 * ���� 3�� ������ �Ѵ�.
	 * 0 : ��ĭ
	 * 1 : ��
	 * 2 : ���̷����� �ִ� ��. */
	static int N,M;
	static int[][] map;
	static int[] dy = { -1, 0, 1, 0 }; // ��,��,��,��
	static int[] dx = { 0, 1, 0, -1 };
	static int max;
	static Queue<int[]> virus;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		virus = new LinkedList<int[]>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					virus.add(new int[] {i,j});
				}
			}
		}// end Input
		
		max = Integer.MIN_VALUE;
		go(0);
		System.out.println(max);
		
	}
	private static void go(int count) {
		
		if(count==3) {
//			spreadvirus();
			
		}
		
		for(int i=0; i<= N*M; i++) {
			
		}
		
	}
}
