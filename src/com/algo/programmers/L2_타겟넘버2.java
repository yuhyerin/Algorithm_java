package com.algo.programmers;

public class L2_Ÿ�ٳѹ�2 {
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
	static int answer;
	public static int solution(int[] numbers, int target) {
		answer = 0;
		int N = numbers.length;//5
		int sum =0;
		boolean flag = true;
		for(int i=0; i<N; i++) {
			sum+= numbers[i];
		}
		if(sum==target) {
			flag = false;
			answer++;
		}
		for(int i=1; flag & i<N; i++) {
			int[] pick = new int[i];
			nPr(numbers,pick,sum,target,N,i);
		}
		return answer;
	}
	
	public static void nPr(int[] numbers, int[] pick, int sum, int target,int N, int R) { // 5,1
		
		if(R == 0) {
			int result = sum;
			for(int p : pick) {
				result -= (2*p);
			}
			if(result == target) {
				answer+=1;
			}
			return;
		}
		
		if(N < R) {
			return;
		}
		
		// ����
		pick[R-1]= numbers[N-1];
		nPr(numbers, pick, sum, target, N-1, R-1);
		
		// ����
		nPr(numbers, pick, sum, target, N-1, R);
	}

}
