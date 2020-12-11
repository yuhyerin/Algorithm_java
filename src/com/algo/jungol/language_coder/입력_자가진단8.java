package com.algo.jungol.language_coder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 입력_자가진단8 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double a = Double.parseDouble(br.readLine());
		double b = Double.parseDouble(br.readLine());
		String word = br.readLine();
		System.out.printf("%.2f%n%.2f%n%s%n",a,b,word);
		
	}
}
