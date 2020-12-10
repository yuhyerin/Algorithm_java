package com.algo.jungol.language_coder;

public class 출력_형성평가4 {
	public static void main(String[] args) {
		String[] sub = {"kor", "mat", "eng","sum","avg"};
		int[] jumsu = { 90, 80, 100};
		int sum = 0;
		for(int j=0; j<jumsu.length;j++) {
			sum+= jumsu[j];
		}
		int avg = sum / jumsu.length;
		
		System.out.printf("%-4s%-3s%n",sub[0],jumsu[0]);
		System.out.printf("%-4s%-3s%n",sub[1],jumsu[1]);
		System.out.printf("%-4s%-3s%n",sub[2],jumsu[2]);
		System.out.printf("%-4s%-3s%n",sub[3],sum);
		System.out.printf("%-4s%-3s%n",sub[4],avg);
		
	}

}
