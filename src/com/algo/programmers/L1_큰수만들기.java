package com.algo.programmers;

public class L1_큰수만들기 {
	
	/**
	 * 어떤 수에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 수
	 * 1924 ->2개 제거하면 : 19, 12,13,92,94,24  중에 가장 큰수는 94
	 * */
	public static void main(String[] args) {
		String number = "1924";
		int k = 2;
		String result = solution(number, k);
		System.out.println(result);
	}
	
	public static String solution(String number, int k) { //k는 제거할 갯수 
        StringBuffer answer = new StringBuffer(number); // 스트링버퍼 
        for(int i=0; i<k; i++) //삭제할 갯수만큼 반복 
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
