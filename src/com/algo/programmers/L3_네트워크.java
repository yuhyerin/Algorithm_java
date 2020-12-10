package com.algo.programmers;

import java.util.HashSet;
import java.util.Set;

public class L3_네트워크 {
	
	/** A-B, B-C 연결되어 있을 때, A와 C도 정보교환 가능!
	 * 네트워크 갯수 리턴. 
	 * 컴퓨터갯수 n : 1~200
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
        parents = new int[n]; // 누구팀인지 나타낼 배열.
        
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
        
        Set<Integer> set = new HashSet<>(); //중복없는 자료구조 
        for(int i=0; i<n; i++) {
        	set.add(parents[i]);
        }
       
        answer = set.size();
        return answer;
    }
	
	static int findSet(int x) {

		if (parents[x] == x) { // 내부모가 나라면 내 식별자는 나임.
			return x;
		} else { // 내부모에게 시켜서 내부모의 부모가 자신이 되는애를 재귀적으로 거슬러 올라가면서 찾게 한다.
			parents[x] = findSet(parents[x]); // path compression으로 성능개선..
			return parents[x];
		}
	}
	
}
