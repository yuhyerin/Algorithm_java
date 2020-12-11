package com.algo.jungol.language_coder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 입력_형성평가4 {	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int sum = a+b+c;
		int avg = sum/3;
		System.out.println("sum = "+sum);
		System.out.println("avg = "+avg);
		
		
		
	}
}
