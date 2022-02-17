package com.algo.bj.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1157_단어공부 {
	static int[] alpha = new int[26];
	static char[] alphaArr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	static int maxCnt = 0;
	static String maxAlpha = "";
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().toUpperCase();
		for(int i=0; i<str.length();i++) {
			alpha[str.charAt(i)-'A']++;
		}
		boolean flag =true;
		for(int i=0; i<26;i++) {
			if(alpha[i]==maxCnt) {
				flag =false;
				continue;
			}
			if(alpha[i]>maxCnt) {
				maxCnt = alpha[i];
				maxAlpha = alphaArr[i]+"";
				flag = true;
			}
		}
		if(flag) {
			System.out.println(maxAlpha);
		}else {
			System.out.println("?");
		}
		
	}
}
