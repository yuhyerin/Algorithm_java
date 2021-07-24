package com.algo.naver.webtoon;

public class test3_2 {

	public static void main(String[] args) {
		test3_2 tt = new test3_2();
		String s = "aabcbcd";
		String t = "abc";
		int result = tt.solution(s, t);
		System.out.println(result);
	}
	
	public int solution(String s, String t){
        int result = 0;
        while(s.indexOf(t) != -1){
            result++;
            s = s.replaceFirst(t, "");
        }
        return result;
    }

}
