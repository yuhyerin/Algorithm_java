package com.algo.programmers;

import java.util.HashMap;
import java.util.Map;

public class L2_���� {
	
	public static void main(String[] args) {
		// { �̸�, ���� }   ����: headgear(�Ӹ�), eyewear(��), face(��), 
		// �Ӹ� - 2, �Ȱ�- 1
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
			if(hash.containsKey(clothes[i][1])) { // �̹� ������? 
				hash.put(clothes[i][1], hash.get(clothes[i][1])+1);
			}else { // ������ 
				hash.put(clothes[i][1], 1);
			}
		}
		
		for(Map.Entry<String, Integer> entry : hash.entrySet()) {
			answer *= (entry.getValue()+1);
		}

		return answer-1;
	}
}
