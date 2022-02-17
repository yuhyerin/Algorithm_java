package com.algo.bj.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class 강의실배정 {
	static int N;
	static Map<Integer, Integer> map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine()); // 200,000
		Set<Integer> keys = new HashSet<>();
		map = new HashMap<Integer, Integer>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			// S,T 는 0~1,000,000,000
			int S = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			
			// S<T 
			if (map.containsKey(S)) {
				int p = map.get(S);
				if (p < T) {
					map.put(T, p);
				} else {
					map.put(T, T);
					map.put(S, T);
					map.put(p, T);
					keys.add(T);
				}

			} else { // 존재하지 않던 키값이면 
				map.put(S, S);
				map.put(T, S);
				keys.add(S);
			}

		} // end for
		System.out.println(keys.size());
	}

//	private static int find(int s, int t) {
//
//		int p = map.get(s);
//		if (p > t) {
//
//		}
//		return 0;
//	}
}
