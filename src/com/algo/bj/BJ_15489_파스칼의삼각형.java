package com.algo.bj;

import java.util.Scanner;

public class BJ_15489_파스칼의삼각형 {
	
	static int R,C,W;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt(); // 3행
		C = sc.nextInt(); // 1번째 
		W = sc.nextInt(); // 한변길이 4 
		
		int N = R+W;
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
		}// end make paskal
		
		int result=0;
		int cnt=1;
		for(int i=R-1;i<R+4-1;i++) {
			for(int j=C-1; j<cnt; j++) {
				result+= paskal[i][j];
			}
			cnt++;
		}
		
		System.out.println(result);
		
	}

}
