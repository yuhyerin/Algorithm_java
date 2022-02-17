package com.algo.bj.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1316_그룹단어체커 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int group = 0;
		for(int i=0; i<N; i++) {
			boolean[] check = new boolean[26];
			String word = br.readLine();
			int len = word.length();
			boolean isSuccess = true;
			for(int j=0; j<len; j++) {
				if(!check[word.charAt(j)-'a']) {
					check[word.charAt(j)-'a']=true;
				}else {
					if(word.charAt(j)==word.charAt(j-1)) {
						continue;
					}else {
						isSuccess = false;
						break;
					}
				}
			}// end for 
			if(isSuccess) {
				group++;
			}
			
		}// end for
		System.out.println(group);
	}
}
