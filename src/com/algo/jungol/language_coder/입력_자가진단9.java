package com.algo.jungol.language_coder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 입력_자가진단9 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double a = Double.parseDouble(br.readLine());
		double b = Double.parseDouble(br.readLine());
		double c = Double.parseDouble(br.readLine());
		System.out.printf("%.3f%n%.3f%n%.3f%n",a,b,c);
		
	}
}
