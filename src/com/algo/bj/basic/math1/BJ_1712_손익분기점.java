package com.algo.bj.basic.math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJ_1712_손익분기점 {
	// 임대료, 재산세, 보험료, 급여 => A만원  고정지출 
	// 재료비, 인건비 => B만원  가변지출 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken()); // 고정지출 
		int B = Integer.parseInt(st.nextToken()); // 가변지출 
		int C = Integer.parseInt(st.nextToken()); // 노트북 1대 가격. 
		int answer = 1;
		while(true) {
			
		}
	}
}
