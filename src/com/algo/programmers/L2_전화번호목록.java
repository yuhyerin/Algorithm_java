package com.algo.programmers;

import java.util.HashSet;

public class L2_전화번호목록 {
	
	/** 전화번호부에 적힌 전화번호 중, 한 번호가 다른번호의 접두어인 경우가 있는지? 확인
	 * 있으면 false 리턴 */
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
				if(phone.startsWith(s) || s.startsWith(phone)) { // 서로가 포함관계인지 비교... 
					return false;
				}
			}
			set.add(phone);
		}
		return true;
	}

}
