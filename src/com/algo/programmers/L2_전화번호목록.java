package com.algo.programmers;

import java.util.HashSet;

public class L2_��ȭ��ȣ��� {
	
	/** ��ȭ��ȣ�ο� ���� ��ȭ��ȣ ��, �� ��ȣ�� �ٸ���ȣ�� ���ξ��� ��찡 �ִ���? Ȯ��
	 * ������ false ���� */
	public static void main(String[] args) {
//		String[] phone_book = { "119", "97674223", "1195524421"};
		String[] phone_book = { "12","123","1235","567","88"};
		boolean result = Solution(phone_book);
		System.out.println(result);
	}
	
	public static boolean Solution(String[] phone_book) {
		
		HashSet<String> set = new HashSet<>();
		
		for(String phone : phone_book) {
			
			for(String s : set) {
				if(phone.startsWith(s) || s.startsWith(phone)) { // ���ΰ� ���԰������� ��... 
					return false;
				}
			}
			set.add(phone);
		}
		return true;
	}

}
