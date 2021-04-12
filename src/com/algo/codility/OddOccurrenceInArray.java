package com.algo.codility;

import java.util.HashMap;
import java.util.Map;

public class OddOccurrenceInArray {
	public static void main(String[] args) {
		int[] A = {9, 3, 9, 3, 9, 7, 9};
		int result = solution(A);
		System.out.println(result);
	}
	public static int solution(int[] A) {
		int N = A.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<N; i++) {
        	if(map.containsKey(A[i])) {
        		map.put(A[i], map.get(A[i])+1);
        	}else {
        		map.put(A[i], 1);
        	}
        }

        for(Integer key : map.keySet()) {
        	if(map.get(key)%2 !=0 ) {
        		return key;
        	}
        }
        return 0;
    }
}
