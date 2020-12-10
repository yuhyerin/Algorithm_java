package com.algo.bj;

import java.util.Scanner;

public class BJ_1427_소트인사이드 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.next();
		int len = num.length();
		int[] arr = new int[len+1];
		boolean flag = true;
		for(int i=1; i<=len; i++) {
			arr[i] = num.charAt(i-1)-'0';
		}
		
		// 오름차순 
		for(int i=len; i>=1; i--) {
			if(!flag) {
				break;
			}
			flag = false;
			for(int j=1; j<i; j++) {
				if(arr[j]<arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1]=tmp;
					flag = true;
				}
			}
		}
		
		for(int i=1; i<=len; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
		
	}

}
