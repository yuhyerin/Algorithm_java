package com.algo.programmers;

public class L1_체육복 {
/**
 * 학생번호 : 체격순 
 * 전체 학생 : n
 * 도난당한 학생번호담긴 배열: lost
 * 여러벌 있는 학생번호담긴 배열 : reserve 
 * 앞,뒤 번호만 빌려줄 수 있다.
 * 수업들을 수 있는 최대학생수 리턴 
 * */
	
	public static void main(String[] args) {
		int n = 5; // 2~30 
		int[] lost = {2,4};
		int[] reserve = {1,3,5};
		int result = solution(n, lost, reserve);
		System.out.println(result);
	}
	
	public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        answer = n - lost.length; // 기본참여 가능 학생 수
        
        for(int i=0; i<lost.length; i++) {
        	if(lost[i]!=0 && lost[i]-1 > 0) { //내 앞에 빌려줄 애 있니? 
        		for(int j=0; j<reserve.length; j++) {
        			if(lost[i]-1 == reserve[j]) {
        				answer++;
        				reserve[j]=0;
        				lost[i]=0;
        				break;
        			}
        		}
        	}
        	if(lost[i]!=0 && lost[i]+1 <= n) { //내 뒤에 빌려줄 애 있니? 
        		for(int j=0; j<reserve.length; j++) {
        			if(lost[i]+1 == reserve[j]) {
        				answer++;
        				reserve[j]=0;
        				lost[i]=0;
        				break;
        			}
        		}
        	}
        	
        }
                return answer;
    }
}
