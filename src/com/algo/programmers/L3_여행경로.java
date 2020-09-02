package com.algo.programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class L3_������ {

	/** �װ����� ��� �̿��ؼ� ������ ¥�� 
	 * ICN ���׿��� ���.
	 * �װ��� ���� tickets 2���� �迭
	 * �湮�ϴ� ���� ��θ� �迭�� ��� ����
	 * 
	 * �����̸��� ���ĺ� �빮�� 3����.
	 * ���� ���� : 3 ~ 10,000��
	 * Ƽ��[a][b] : a->b�ΰ��� �װ���
	 * �־��� �װ����� �� ����Ѵ�.
	 * ������ ��ΰ� 2���̻��̶��, ���ĺ� ������ �ռ��� ��θ� ����.
	 * ��絵�ø� �湮�Ҽ� �ִ� ��θ� �־�����.
	 * */
	
	public static void main(String[] args) {
//		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}; // Ƽ�� 3��. 
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		String[] result = solution(tickets);
		System.out.println(Arrays.toString(result));
	}
	
	static String Stringroute = "";
	public static String[] solution(String[][] tickets) {
        int n = tickets.length; //  n = 3
        String[] answer = new String[n+1];
        int wordsize = tickets[0][0].length();
        
        for(int i=0; i<wordsize*2*n; i++) {
        	Stringroute+= "Z";
        }
        int[] result = new int[n];
        go(tickets,n,0,0, result); // 0��Ƽ�Ϻ��� ���.
        
        for(int i=0; i<n+1; i++) {
        	answer[i]= Stringroute.substring(3*i, 3*i+3);
        }
        return answer;
    }

	private static void go(String[][] tickets, int n, int flag, int cnt, int[] result) {
		
		String tmp="";
		if(cnt == n) { // n���� Ƽ���� �� �̾����� ����.
			boolean isValid = true;
			for(int i=0; i<n-1; i++) {
				if(tickets[result[i]][1] == tickets[result[i+1]][0]) { // ������ 2��°��, �������� 1��°�� ������?
					
				}else {
					isValid = false;
				}
			}
			
			if(isValid) {
				for(int i=0; i<n; i++) {
					tmp += tickets[result[i]][0];
				}
				tmp+= tickets[result[n-1]][1];
				
				if(Stringroute.compareTo(tmp) > 0) {
					Stringroute = tmp;
				}
			}
			
			return;
			
		}
		
		for(int i=0; i<n; i++) {
			if( ( flag & 1<<i ) != 0 ) continue;
			result[cnt] = i;
			go(tickets, n, flag | 1<<i, cnt+1, result);
		}
		
	}
	
}
