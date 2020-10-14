package com.algo.programmers;

import java.util.ArrayList;

public class L3_순위 {
	/** n명의 권투선수 1~n번 
	 * A가 B보다 실력이 좋으면 A는 B를 항상 이긴다.
	 * 경기 결과가 주어짐. 몇몇 결과는 분실함.
	 * 순위를 매길 수 있는 선수의 수를 return */
	public static void main(String[] args) {
		L3_순위 t = new L3_순위();
		int n = 5;
		int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		int result = t.solution(n, results);
	}
	
	public int solution(int n, int[][] results) {
        int answer = 0;
        int[] count = new int[n+1];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        for(int i=0; i<results.length; i++) {
        	list.get(results[i][0]).add(results[i][1]);
        }// end for

        
        return answer;
    }
}
