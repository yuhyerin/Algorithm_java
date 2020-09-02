package com.algo.basic;

import java.util.Arrays;
import java.util.Scanner;

public class combination {
	
	static int N, R;
	static int[] input, pick;
	static int totalCnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		pick = new int[R];
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		totalCnt=0;
		combi(0,0);
		System.out.println("ÃÑ °æ¿ìÀÇ ¼ö : "+totalCnt);
	}

	private static void combi(int cur, int cnt) {
		if(cnt == R) {
			totalCnt++;
			System.out.println(Arrays.toString(pick));
			return;
		}
		for(int i=cur; i<N; i++) {
			pick[cnt] = input[i];
			combi(i+1, cnt+1);
		}
		// combi(0,0) -> combi(1,1) -> combi(2,2)
	}

}
