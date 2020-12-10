package com.algo.programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class L3_여행경로 {

	/** 항공권을 모두 이용해서 여행경로 짜기 
	 * ICN 공항에서 출발.
	 * 항공권 정보 tickets 2차원 배열
	 * 방문하는 공항 경로를 배열에 담아 리턴
	 * 
	 * 공항이름은 알파벳 대문자 3글자.
	 * 공항 갯수 : 3 ~ 10,000개
	 * 티켓[a][b] : a->b로가는 항공권
	 * 주어진 항공권은 다 써야한다.
	 * 가능한 경로가 2개이상이라면, 알파벳 순서가 앞서는 경로를 리턴.
	 * 모든도시를 방문할수 있는 경로만 주어진다.
	 * */
	
	public static void main(String[] args) {
//		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}; // 티켓 3개. 
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
        go(tickets,n,0,0, result); // 0번티켓부터 사용.
        
        for(int i=0; i<n+1; i++) {
        	answer[i]= Stringroute.substring(3*i, 3*i+3);
        }
        return answer;
    }

	private static void go(String[][] tickets, int n, int flag, int cnt, int[] result) {
		
		String tmp="";
		if(cnt == n) { // n개의 티켓을 다 뽑았으면 종료.
			boolean isValid = true;
			for(int i=0; i<n-1; i++) {
				if(tickets[result[i]][1] == tickets[result[i+1]][0]) { // 전꺼의 2번째와, 다음꺼의 1번째가 같은가?
					
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
