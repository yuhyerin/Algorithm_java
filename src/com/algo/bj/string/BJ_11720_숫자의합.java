package com.algo.bj.string;

import java.util.Scanner;

public class BJ_11720_숫자의합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.next());
		int sum = 0;
		String str = sc.next();
		for(int i=0; i<N; i++) {
			sum+= Integer.parseInt(str.charAt(i)+"");
		}
		System.out.println(sum);
	}
}
