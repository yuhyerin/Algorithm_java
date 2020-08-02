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

public class L2_���̽�ƽ {

	/**
	 * ó���� A�θ� �̷���� �ֽ��ϴ�. ^ : �������ĺ� v : �������ĺ� (A������ Z��) < : Ŀ���� �������� �̵� > : Ŀ����
	 * ���������� �̵� AAA ���� 9�� : JAA ����1�� : Ŀ���� �ǵڷ� �̵� �Ʒ��� 1��: JAZ ��Ż:11���̵����Ѽ� JAZ����.
	 * (�ּ��̵�)
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
		 * 0. cur = 0�� �ִ�. 1. ������ġ�κ��� ���������� ���ߵǴ��� �˻�. 2. ������ġ�κ��� �������� ���ߵǴ��� �˻�. 3. ����,
		 * ������ �� ���� ���°����� cur�� �̵���Ŵ
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
			System.out.println("dist[" + i + "]�� " + dist[i]);
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
//			System.out.println("ť�� " + i + " �־��� ");
//		}

		int cur = 0; // ���� ��ġ
		while (!que.isEmpty()) {

			int idx = que.poll(); // idx = 0,7,5

			// �̵���
			if (Math.abs(idx - cur) > len / 2) {
				answer += Math.abs(len - idx - cur);
			} else {
				answer += Math.abs(idx - cur);
			}
			cur = idx;
			System.out.println(idx + " ���� �̵���: " + answer);

			// ���ĺ���ȯ��
			int cha = name.charAt(idx) - 'A';
			if (cha > 13) {
				cha = 26 - cha;
			}
			answer += cha;
			System.out.println(idx + " ���ĺ���ȯ�� : " + answer);

		}

		return answer;
	}
	
}
