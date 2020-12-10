package com.algo.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_1620_포켓몬마스터 {
	
	static int N; // 포켓몬 수 
	static int M; // 문제의 수 
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken()); //26
		M = Integer.parseInt(st.nextToken()); //5
		String[] names = new String[N+1];
		Map<String, Integer> map = new HashMap<String, Integer>();
		// 포켓몬 이름은 첫글자 대문자, 나머지 소문자, 최대길이 20
		for(int i=1; i<=N; i++) {
//			names[i]=in.readLine();
			String nm = in.readLine();
			names[i]=nm;
			map.put(nm, i);
		}
		// 문제 
		String[] ques = new String[M+1];
		for(int i=1; i<=M; i++) {
			ques[i]=in.readLine();
			try {
				int num = Integer.parseInt(ques[i]);
				System.out.println(names[num]);
				
			}catch(NumberFormatException e) {
				System.out.println(map.get(ques[i]));
			}
		}

	}

}
