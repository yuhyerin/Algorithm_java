package com.algo.basic;

import java.util.Arrays;
import java.util.Scanner;

public class permutation {
	
	static int[] input, pick;
	static int N;
	static int R, totalCnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		pick = new int[R];
		for(int i=0; i<N; i++) {
			input[i]=sc.nextInt();
		}// end Input
		
		totalCnt =0;
		nPr(0,0);
		System.out.println("ÃÑ °æ¿ìÀÇ ¼ö : "+ totalCnt);
	}

	private static void nPr(int flag, int cnt) {
		if(cnt == R) {
			totalCnt++;
			System.out.println(Arrays.toString(pick));
			return;
		}
		
		for(int i=0; i<N; i++) {
			if( (flag & 1<<i) != 0) continue;
			
			pick[cnt]= input[i];
			nPr(cnt+1, flag | 1<<i );
		}
	}

}
