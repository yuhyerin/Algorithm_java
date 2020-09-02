package com.algo.programmers;

import java.util.HashSet;
import java.util.Set;

public class L3_��Ʈ��ũ {
	
	/** A-B, B-C ����Ǿ� ���� ��, A�� C�� ������ȯ ����!
	 * ��Ʈ��ũ ���� ����. 
	 * ��ǻ�Ͱ��� n : 1~200
	 * */
	public static void main(String[] args) {
		int n = 3;
		int[][] computers = {   {1,1,0},
								{1,1,1},
								{0,1,1}};
		int result = solution(n, computers);
		System.out.println(result);
	}
	static int[] parents;
	public static int solution(int n, int[][] computers) {
        int answer = 0;
        parents = new int[n]; // ���������� ��Ÿ�� �迭.
        
        for(int i=0; i<n;i++) {
        	parents[i] = i; // parents = { 0, 1, 2 } 
        }
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		if(i!=j && computers[i][j]==1) {
        			if(i<=j) {
        				parents[j]=findSet(i);
        			}else {
        				parents[i]=findSet(j);
        			}
        		}
        	}
        }
        
        Set<Integer> set = new HashSet<>(); //�ߺ����� �ڷᱸ�� 
        for(int i=0; i<n; i++) {
        	set.add(parents[i]);
        }
       
        answer = set.size();
        return answer;
    }
	
	static int findSet(int x) {

		if (parents[x] == x) { // ���θ� ����� �� �ĺ��ڴ� ����.
			return x;
		} else { // ���θ𿡰� ���Ѽ� ���θ��� �θ� �ڽ��� �Ǵ¾ָ� ��������� �Ž��� �ö󰡸鼭 ã�� �Ѵ�.
			parents[x] = findSet(parents[x]); // path compression���� ���ɰ���..
			return parents[x];
		}
	}
	
}
