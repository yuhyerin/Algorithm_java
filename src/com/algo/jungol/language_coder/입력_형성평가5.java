package com.algo.jungol.language_coder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 입력_형성평가5 {	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("yard? " );
		double yard = Double.parseDouble(br.readLine());
		double cm = yard*91.44;
		System.out.printf("%.1fyard = %.1fcm%n",yard,cm);
		
		
		
	}
}
