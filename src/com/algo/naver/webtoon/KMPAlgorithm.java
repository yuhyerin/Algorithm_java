package com.algo.naver.webtoon;

public class KMPAlgorithm {

	public static int result, pi[];
	public static String origin, pattern;

	public static void main(String[] args) {
		origin = "aabcbcd";
		pattern = "abc";

		pi = new int[pattern.length()];
		getPi();
		KMP();
	}

	private static void getPi() {
		int j = 0;
		for (int i = 1; i < pattern.length(); i++) {
			// 맞는 위치가 나올때까지 j-1 칸의 공통부분 위치로 이동.
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1];
			}

			// 맞는 경우
			if (pattern.charAt(i) == pattern.charAt(j)) {
				// i길이 문자열의 공통길이는 j의 위치+1
				pi[i] = ++j;
			}
		}
	}

	private static void KMP() {
		int j = 0;
		for (int i = 0; i < origin.length(); i++) {
			// 맞는 위치가 나올때까지 j-1칸의 공통부분 위치로 이동.
			while (j > 0 && origin.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1];
			}
			// 맞는경우.
			if (origin.charAt(i) == pattern.charAt(j)) {
				if (j == pattern.length() - 1) {
					result = 1;
					break;

				} else { // 맞았지만 패턴이 끝나지 않았다면 j를 하나 증가.
					++j;
				}
			}
			
		}
		System.out.println(result);
	}

}
