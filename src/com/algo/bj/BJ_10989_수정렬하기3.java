package com.algo.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_10989_수정렬하기3 {
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		int[] count = new int[10001];
		
		for(int i=0; i<N; i++) {
			count[Integer.parseInt(in.readLine())]++;
		}
		for(int i=1; i<=10000; i++) {
			while(count[i]>0) {
				count[i]--;
				bw.write(Integer.toString(i)+"\n");
//				bw.newLine();
//				sb.append(i+'\n');
			}
		}
//		System.out.println(sb.toString());
		bw.flush();
		bw.close();
	}
}
