package com.algo.programmers;

public class L1_ü���� {
/**
 * �л���ȣ : ü�ݼ� 
 * ��ü �л� : n
 * �������� �л���ȣ��� �迭: lost
 * ������ �ִ� �л���ȣ��� �迭 : reserve 
 * ��,�� ��ȣ�� ������ �� �ִ�.
 * �������� �� �ִ� �ִ��л��� ���� 
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
        answer = n - lost.length; // �⺻���� ���� �л� ��
        
        for(int i=0; i<lost.length; i++) {
        	if(lost[i]!=0 && lost[i]-1 > 0) { //�� �տ� ������ �� �ִ�? 
        		for(int j=0; j<reserve.length; j++) {
        			if(lost[i]-1 == reserve[j]) {
        				answer++;
        				reserve[j]=0;
        				lost[i]=0;
        				break;
        			}
        		}
        	}
        	if(lost[i]!=0 && lost[i]+1 <= n) { //�� �ڿ� ������ �� �ִ�? 
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
