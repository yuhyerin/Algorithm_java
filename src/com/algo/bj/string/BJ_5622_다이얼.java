package com.algo.bj.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BJ_5622_다이얼 {
	// 앞에 2칸.
	// 1 => 2초
	// 2 ABC
	// 3 DEF
	// 4 GHI
	// 5 JKL
	// 6 MNO
	// 7 PQRS
	// 8 TUV
	// 9 WXYZ
	// 0
	static Map<Character, Integer> map = new HashMap<Character, Integer>();

	public static void main(String[] args) {
		int value = 3;
		for (int a = 65; a < (65 + 26); a++) {
			if ((char) a == 'D') {
				value++;
			} else if ((char) a == 'G') {
				value++;
			} else if ((char) a == 'J') {
				value++;
			} else if ((char) a == 'M') {
				value++;
			} else if ((char) a == 'P') {
				value++;
			} else if ((char) a == 'T') {
				value++;
			} else if ((char) a == 'W') {
				value++;
			}
			map.put((char) a, value);
		} // end for
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int answer = 0;
		for (int i = 0; i < str.length(); i++) {
			answer += map.get(str.charAt(i));
		}
		System.out.println(answer);

	}
}
