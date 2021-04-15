package com.algo.codility;

public class Lesson2_CyclicRotation {
	public static void main(String[] args) {
		
	}
	public static int[] solution(int[] A, int K) {
		int len = A.length;
        int[] result = new int[len];
        if(len>0){
            K = K % len ;
            for(int i=0; i<len; i++){
                int idx = i+K;
                if(idx >= len){
                    idx = idx-len;
                }
                result[idx]=A[i];
            }
        }else{
            return new int[] {};
        }
        return result;
    }
}
