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
		int[] course = { 2, 3, 4 }; // ���ϴ� �ڽ��丮 ����
		String[] result = a.solution(orders, course);
		for (String s : result) {
			System.out.print(s + " ");
		}
		System.out.println();
	}

	/**
	 * �ּ� 2���̻��� �ֹ��� ���տ� ���ؼ��� �ĺ���! orders�� 2~20��. �����ڿ��� �빮��, �ߺ�X, 2~10���� course�� ���ϴ�
	 * �ڽ��丮 ��������. 1~10 �����Ҵ� 2~10. ��������. ����� ������ ������������.
	 */
	public String[] solution(String[] orders, int[] course) {

		String[] answer = {};
		HashMap<Integer, HashMap<String, Integer>> hash = new HashMap<>();
		for(int i=2; i<= 10; i++) {
			hash.put(i, new HashMap<String, Integer>());
		}//�ʱ�ȭ 

		
		for (int j = 0; j < orders.length; j++) {
			String order = orders[j];
			check(0, order,"", hash);
		}//
		
		Set<String> tmp = new HashSet<>();
		ArrayList<String> menus = new ArrayList<>();
		// key�� ���ؼ� ���� Ž��.
		for(int c=0; c<course.length; c++) {
			HashMap<String, Integer> map = hash.get(course[c]);
			int max = 2;
			for(String key : map.keySet()) {
				if(map.get(key) == max) { //counting ���� max���� ������ �׳� �ֱ�. 
					menus.add(key);
				}else if(map.get(key)> max){// counting���� max���� ũ��. arrayList�ѹ�����. max�� ����.
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

		if (idx == order.length()) { // �ִ���̸�ŭ ����������,
			int result_len = result.length();
			if (result_len >= 2) {
				char[] arr = result.toCharArray();
				Arrays.sort(arr); // ���� ��
				result = new String(arr);// �ٽ� ���ڿ�
				System.out.println("���̰� 2�̻��̰�, ���ĵ� ����: "+result);
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
