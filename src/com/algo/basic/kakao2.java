package com.algo.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class kakao2 {
	public static void main(String[] args) {
		kakao2 a = new kakao2();
		String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
		int[] course = { 2, 3, 4 }; // 원하는 코스요리 갯수
		String[] result = a.solution(orders, course);
		for (String s : result) {
			System.out.print(s + " ");
		}
		System.out.println();
	}

	/**
	 * 최소 2명이상이 주문한 조합에 대해서만 후보로! orders는 2~20개. 각문자열은 대문자, 중복X, 2~10길이 course는 원하는
	 * 코스요리 구성갯수. 1~10 각원소는 2~10. 오름차순. 출력은 사전순 오름차순으로.
	 */
	public String[] solution(String[] orders, int[] course) {

		String[] answer = {};
		HashMap<Integer, HashMap<String, Integer>> hash = new HashMap<>();
		for(int i=2; i<= 10; i++) {
			hash.put(i, new HashMap<String, Integer>());
		}//초기화 

		
		for (int j = 0; j < orders.length; j++) {
			String order = orders[j];
			check(0, order,"", hash);
		}//
		
		Set<String> tmp = new HashSet<>();
		ArrayList<String> menus = new ArrayList<>();
		// key에 대해서 전부 탐색.
		for(int c=0; c<course.length; c++) {
			HashMap<String, Integer> map = hash.get(course[c]);
			int max = 2;
			for(String key : map.keySet()) {
				if(map.get(key) == max) { //counting 값이 max값과 같으면 그냥 넣기. 
					menus.add(key);
				}else if(map.get(key)> max){// counting값이 max보다 크면. arrayList한번비우고. max값 갱신.
					max= map.get(key);
					menus.clear();
					menus.add(key);
				}
			}
			for(String s : menus) {
				tmp.add(s);
			}
		}
		
		
		answer = tmp.toArray(new String[tmp.size()]);
		Arrays.sort(answer);
		
		return answer;
	}

	private void check(int idx, String order, String result, HashMap<Integer, HashMap<String, Integer>> hash) {

		if (idx == order.length()) { // 최대길이만큼 진행했으면,
			int result_len = result.length();
			if (result_len >= 2) {
				char[] arr = result.toCharArray();
				Arrays.sort(arr); // 정렬 후
				result = new String(arr);// 다시 문자열
				System.out.println("길이가 2이상이고, 정렬된 조합: "+result);
				HashMap<String, Integer> menu = new HashMap<>();
				menu = hash.get(result_len);
				if(menu.containsKey(result)){
					menu.put(result, menu.get(result)+1);
				}else {
					menu.put(result, 1);
				}
			}
			return;
		}
		
		check(idx+1, order, result, hash);
		check(idx+1, order, result+order.charAt(idx), hash);
	}

}
