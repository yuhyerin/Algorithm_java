package com.algo.programmers;

public class L2_타겟넘버 {
	/**
	 * n개의 음이아닌 정수 이 수들을 더하거나 빼서, 타겟넘버 만들기.
	 * 타겟넘버를 만드는 방법의 수를 리턴.
	 * numbers의 길이 2~20
	 * 각 수들은 1~50이하의 수
	 * 타겟넘버는 1~1000이하의 수
	 */
	public static void main(String[] args) {
		int[] numbers = { 1, 1, 1, 1, 1 };
		int target = 3;
		int result = solution(numbers, target);
		System.out.println(result);
	}

	public static int solution(int[] numbers, int target) {
        int answer = 0;
        int len = numbers.length; // 주어진 숫자의 갯수
		int totalnum = (int)Math.pow(2, len);
		
		for(int i=0; i<totalnum; i++) { // 00000, 00001, 00010, 00011, . . .
			int val = 0;
			for(int j=0; j<len; j++) {
				if( ((i>>j)&1) == 1) {
					val+= numbers[j];
				}else {
					val -= numbers[j];
				}
			}
			if(val == target) {
				answer++;
			}
		}
        return answer;
    }

}
