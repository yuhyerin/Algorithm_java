package com.algo.programmers;

public class L1_ū������� {
	
	/**
	 * � ������ k���� ���� �������� �� ���� �� �ִ� ���� ū ��
	 * 1924 ->2�� �����ϸ� : 19, 12,13,92,94,24  �߿� ���� ū���� 94
	 * */
	public static void main(String[] args) {
		String number = "1924";
		int k = 2;
		String result = solution(number, k);
		System.out.println(result);
	}
	
	public static String solution(String number, int k) { //k�� ������ ���� 
        StringBuffer answer = new StringBuffer(number); // ��Ʈ������ 
        for(int i=0; i<k; i++) //������ ������ŭ �ݺ� 
        {
        	for(int j=0; j< answer.length();j++) {
        		if( answer.charAt(j) < answer.charAt(j+1)) {
        			answer.deleteCharAt(j);
        			break;
        		}
        	}
        }
        return answer.toString();
    }

}
