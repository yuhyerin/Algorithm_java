package com.algo.programmers;

import java.util.HashMap;
import java.util.Map;

public class L2_위장 {
	
	public static void main(String[] args) {
		// { 이름, 종류 }   종류: headgear(머리), eyewear(눈), face(얼굴), 
		// 머리 - 2, 안경- 1
// 		String[][] clothes = {
// 				{"yellow_hat", "headgear"},
// 				{"blue_hat", "headgear"},
//				{"red_sunglasses", "eyewear"}, 
//				{"blue_sunglasses", "eyewear"}, 
//				{"green_turban", "face"},
//				{"purple_turban", "face"}
//		};
		String[][] clothes = {
				{ "yellow_hat", "headgear"}, 
				{"blue_sunglasses", "eyewear"}, 
				{"green_turban", "headgear"}
			};
		
		int result = solution(clothes);
		System.out.println(result);
		
	}
	public static int solution(String[][] clothes) {
		int answer = 1;
		HashMap<String, Integer> hash = new HashMap<>();
		for(int i=0; i< clothes.length; i++) {
			if(hash.containsKey(clothes[i][1])) { // 이미 있으면? 
				hash.put(clothes[i][1], hash.get(clothes[i][1])+1);
			}else { // 없으면 
				hash.put(clothes[i][1], 1);
			}
		}
		
		for(Map.Entry<String, Integer> entry : hash.entrySet()) {
			answer *= (entry.getValue()+1);
		}

		return answer-1;
	}
}
