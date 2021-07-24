package com.algo.bj.kmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1305_광고 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine()); // 전광판 크기 (한번에 보이는 최대 문자수)
		String ad = br.readLine();
		char[] adArray = ad.toCharArray();
		int[] lps = new int[L];
		int k=0;
		for(int i=1; i<L; i++) {
			while(k>0 && adArray[k]!=adArray[i]) {
				k = lps[k-1];
			}
			if(adArray[k] == adArray[i]) {
				k++;
				lps[i] = k;
			}
		}// end for
		
		System.out.println(L-lps[L-1]);
		// 전광판 길이(L)에서 
		// 접두사도 되면서, 접미사도 되는 문자열의 최대길이를 빼면.
		// => 광고하려고 한 내용을 알 수 있음!
	}

}
