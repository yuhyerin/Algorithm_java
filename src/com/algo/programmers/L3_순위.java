package com.algo.programmers;

import java.util.ArrayList;

public class L3_���� {
	/** n���� �������� 1~n�� 
	 * A�� B���� �Ƿ��� ������ A�� B�� �׻� �̱��.
	 * ��� ����� �־���. ��� ����� �н���.
	 * ������ �ű� �� �ִ� ������ ���� return */
	public static void main(String[] args) {
		L3_���� t = new L3_����();
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
