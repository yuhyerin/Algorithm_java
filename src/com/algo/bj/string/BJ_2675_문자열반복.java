package com.algo.bj.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2675_문자열반복 {
	static int T;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			for(int i=0; i<str.length(); i++) {
				for(int n =0; n<num; n++) {
					System.out.print(str.charAt(i));
				}
			}// end for 
			System.out.println();
		}
	}
}	
