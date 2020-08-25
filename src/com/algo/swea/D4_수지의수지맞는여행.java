package com.algo.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_수지의수지맞는여행 {
	
	static int T, R, C;
	static char[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(in.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			for(int i=0; i<R; i++) {
				map[i] = in.readLine().toCharArray();
				
			}// endInput
			
			
		}
		
		
	}
}
