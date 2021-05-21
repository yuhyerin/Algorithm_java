package com.algo.bj.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJ_9505_엔터프라이즈호탈출 {
	// 가장 빠른시간내에 나갈수 있는 탈출루트 찾기. 시간 출력.
	// 직사각형의 평면이 입력.( 엔터프라이즈호, 클링온 전투선들의 위치 )
	// 클링온 전투선은 몇가지 클래스로 나뉨. 각 클래스의 클링온전투선을 엔터프라이즈호가 무력화시키는데 걸리는 시간.이 입력으로 들어옴. 
	// 
	static int T; //테스트 케이스 갯수 
	static int K,W,H; // K: 클링온 전투선 클래스 갯수 (1~25) , W: 평면의 폭 (1~1000), H: 평면높이 (1~1000) 
	static int[] distance = new int[27];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				
			}
			
			for(int i=0; i<W; i++) {
				String str = br.readLine();
			}
		}
	}
}
