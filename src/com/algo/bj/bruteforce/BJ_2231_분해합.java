package com.algo.bj.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2231_분해합 {

	/** 어떤 자연수 M의 분해합이 N
	 * M은 N의 생성자.
	 * M = 245 (생성자)
	 * N = 256 ( 245+2+4+5=256 )  (분해합)
	 *  N = 1~1,000,000*/
	static int N, result;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine()); //216	
		boolean flag =false;
		for(int i=1; i<=N; i++) {
			result = 0;
			int len = Integer.toString(i).length();
			result+=i;
			for(int j=0; j<=len-1;j++) {
				int val = Integer.toString(i).charAt(j)-'0';
				result+=val;
			}
			if(result==N) {
				result = i;
				flag =true;
				break;
			}
		}
		if(!flag) {
			result = 0;
		}
		System.out.println(result);
	}
}
