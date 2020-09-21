package com.algo.swea;

import java.util.Scanner;

public class 모의_4008_숫자만들기 {
	/**
	 * N개의 숫자 (3~12개), 1~9숫자카드 + - x / 사칙연산자 연산자우선순위X 왼쪽-->오른쪽 차례로 계산 숫자는 주어진 대로
	 * 순서고정. 연산자는 사이사이 위치. 나눗셈할때는, 몫만 !
	 * 
	 * 최소값, 최대값 의 차이를 출력
	 */
	static int T, N;
	static int[] numbers, giho, pickgiho;
	static int min, max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();// 5
			numbers = new int[N];
			giho = new int[4]; 
			pickgiho = new int[N-1];
			for (int i = 0; i < 4; i++) {
				giho[i] = sc.nextInt(); //  2 1 0 1
			}
			for (int i = 0; i < N; i++) {
				numbers[i] = sc.nextInt(); // 3 5 3 7 9
			} // end Input
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			
			pick(0); // 현재 뽑은 갯수 0
			int result= max - min;
			System.out.println("#"+t+" "+result);
		}
	}

	private static void pick(int count) {
		
		if (count == N - 1) {//종료
			int sum=numbers[0];
			for(int i=0; i<N-1; i++) {
				int g = pickgiho[i];
				switch(g) {
				case 0: sum+= numbers[i+1]; break;
				case 1: sum-= numbers[i+1]; break;
				case 2: sum*= numbers[i+1]; break;
				case 3: sum/= numbers[i+1]; break;
				}
			}
			min = min>sum? sum : min ;
			max = max<sum? sum : max ;
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(giho[i]>0) {
				giho[i]--;
				pickgiho[count]=i;
				pick(count+1);
				giho[i]++;
			}
		}

	}
}
