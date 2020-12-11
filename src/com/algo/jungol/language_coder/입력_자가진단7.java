package com.algo.jungol.language_coder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 입력_자가진단7 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		System.out.printf("%d * %d = %d%n",a,b,a*b);
		System.out.printf("%d / %d = %d",a,b,a/b);
		
	}
}
