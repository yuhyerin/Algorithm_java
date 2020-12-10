package com.algo.swea;

import java.util.Scanner;

public class D2_파스칼삼각형 {
	static int T,N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			int[][] paskal = new int[N][N];
			paskal[0][0]=1;
			for(int i=0; i<N; i++) {
				for(int j=0; j<i+1; j++) {
					if(j==0 || j==i) {
						paskal[i][j]=1;
					}else {
						paskal[i][j] = paskal[i-1][j]+paskal[i-1][j-1];
					}
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<i+1; j++) {
					System.out.print(paskal[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
