package com.algo.bj.kmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_1786_찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String T = br.readLine();
		String P = br.readLine();
		char[] text = T.toCharArray();
		char[] pattern = P.toCharArray();
		int N = T.length();
		int M = P.length();
		int count = 0;
		ArrayList<Integer> indexArrayList = new ArrayList<Integer>();
		
		// 전처리 
		int[] lps = new int[M];
		computeLps(pattern, lps, M);
		
		// kmp
		int p = 0; // index for pattern[]
		int t = 0; // index for text[] 
		while(t<N) {
			if(text[t] == pattern[p]) {
				p++;
				t++;
			}
			if(p == M) {
				count++;
				indexArrayList.add((t-p+1));
				p = lps[p-1];
			}else if(t<N && text[t] != pattern[p]) {
				if(p != 0) {
					p = lps[p-1];
				}else {
					t++;
				}
			}
		}
		
		// P가 몇번 나타나는지 출력. 
		// P가 나타나는 위치를 공백으로 출력.
		System.out.println(count);
		for(int value : indexArrayList) {
			System.out.print(value+" ");
		}
		System.out.println();
	}

	private static void computeLps(char[] pattern, int[] lps, int M) {
		int k = 0;
		for(int i=1; i<M; i++) {
			while(k>0 && pattern[i] != pattern[k]) {
				k = lps[k-1];
			}
			if(pattern[i]==pattern[k]) {
				lps[i]=++k;
			}
		}//end for
	}
}
