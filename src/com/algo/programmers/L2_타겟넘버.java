package com.algo.programmers;

public class L2_Ÿ�ٳѹ� {
	/**
	 * n���� ���̾ƴ� ���� �� ������ ���ϰų� ����, Ÿ�ٳѹ� �����.
	 * Ÿ�ٳѹ��� ����� ����� ���� ����.
	 * numbers�� ���� 2~20
	 * �� ������ 1~50������ ��
	 * Ÿ�ٳѹ��� 1~1000������ ��
	 */
	public static void main(String[] args) {
		int[] numbers = { 1, 1, 1, 1, 1 };
		int target = 3;
		int result = solution(numbers, target);
		System.out.println(result);
	}

	public static int solution(int[] numbers, int target) {
        int answer = 0;
        int len = numbers.length; // �־��� ������ ����
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
