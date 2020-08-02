package com.algo.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public class L2_조이스틱 {

	/**
	 * 처음엔 A로만 이루어져 있습니다. ^ : 다음알파벳 v : 이전알파벳 (A에서는 Z로) < : 커서를 왼쪽으로 이동 > : 커서를
	 * 오른쪽으로 이동 AAA 위로 9번 : JAA 왼쪽1번 : 커서를 맨뒤로 이동 아래로 1번: JAZ 토탈:11번이동시켜서 JAZ만듬.
	 * (최소이동)
	 */
	public static void main(String[] args) {
		String name = "JAAAABAZ"; // 3
		int result = solution(name);
		System.out.println(result);
	}

	public static int solution(String name) {
		int answer = 0;
		// "JEROEN"
		int len = name.length(); // 3
		Queue<Integer> que = new LinkedList<>();
		que.add(0);
		/**
		 * 0. cur = 0에 있다. 1. 현재위치로부터 오른쪽으로 가야되는지 검사. 2. 현재위치로부터 왼쪽으로 가야되는지 검사. 3. 왼쪽,
		 * 오른쪽 중 적게 가는곳으로 cur을 이동시킴
		 */
		
		Map<Integer, Integer> map = new HashMap<>();
		int curidx = 0;
		int[] dist = new int[len];
		for (int i = 1; i < len; i++) { // i=0
			if (name.charAt(i) != 'A') {
				if (Math.abs(i - curidx) > len / 2) {
					dist[i] = Math.abs(len - i - curidx);
				} else {
					dist[i] = Math.abs(i - curidx);
				}
			}
			System.out.println("dist[" + i + "]는 " + dist[i]);
			if(dist[i]!=0) {
				map.put(i, dist[i]);
			}
		}
		List<Entry<Integer, Integer>> list = new ArrayList<Entry<Integer,Integer>>(map.entrySet());
//		Collections.sort(list, new Comparator<T>() {
//		});
		
//		for (int i = len - 1; i >= len / 2; i--) {
//			if (name.charAt(i) == 'A') {
//				continue;
//			}
//			que.add(i);
//			System.out.println("큐에 " + i + " 넣었음 ");
//		}

		int cur = 0; // 현재 위치
		while (!que.isEmpty()) {

			int idx = que.poll(); // idx = 0,7,5

			// 이동수
			if (Math.abs(idx - cur) > len / 2) {
				answer += Math.abs(len - idx - cur);
			} else {
				answer += Math.abs(idx - cur);
			}
			cur = idx;
			System.out.println(idx + " 현재 이동수: " + answer);

			// 알파벳변환수
			int cha = name.charAt(idx) - 'A';
			if (cha > 13) {
				cha = 26 - cha;
			}
			answer += cha;
			System.out.println(idx + " 알파벳변환함 : " + answer);

		}

		return answer;
	}
	
}
