package com.coding.test.delivery;

public class test3_2 {

	public static void main(String[] args) {
		// 1. a의 개수를 센다: n개
		// => a가 3의 배수개인 경우 문자열의 맨 앞, 맨 뒤로부터 n/3개째의 a를 만나는 지점의 인덱스를 기록
		//
		test3_2 solution = new test3_2();
		int res = solution.solution("babaa");
		System.out.println("babaa: " + res);
		res = solution.solution("ababa");
		System.out.println("ababa: " + res);
		res = solution.solution("aba");
		System.out.println("aba: " + res);
		res = solution.solution("bbbbb");
		System.out.println("bbbbb: " + res);
		res = solution.solution("babbabbbab");
		System.out.println("babbabbbab: " + res);
	}

    public int solution(String S) {
        int n = (int)S.chars().filter(c -> c == 'a').count();
        if(n == 0){
            int res = 0;
            int tmp = S.length() - 2;
            while(tmp > 0){
                res += tmp--;
            }
            return res;
        }
        if(n % 3 != 0)
            return 0;
        int startIdx = 0;
        int frontCnt = 0;
        int endIdx = S.length() - 1;
        int rearCnt = 0;
        while(frontCnt < n/3){
            if(S.charAt(startIdx++) == 'a')
                frontCnt++;
        }
        while(rearCnt < n/3){
            if(S.charAt(endIdx--) == 'a')
                rearCnt++;
        }
        int n1 = 1;
        int n2 = 1;
        while(S.charAt(startIdx + n1 - 1) == 'b'){
            n1++;
        }
        while(S.charAt(endIdx - n2 + 1) == 'b'){
            n2++;
        }
        return n1 * n2;
    }
}
