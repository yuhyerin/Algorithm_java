package com.algo.bj.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class BJ_10809_알파벳찾기 {
	static int[] alpha = new int[26];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Arrays.fill(alpha, -1);
		for(int i=0; i<str.length(); i++) {
			if(alpha[str.charAt(i)-'a']!=-1) continue;
			alpha[str.charAt(i)-'a'] = i;
		}
		for(int a:alpha) {
			System.out.print(a+" ");
		}
		System.out.println();
	}
}
