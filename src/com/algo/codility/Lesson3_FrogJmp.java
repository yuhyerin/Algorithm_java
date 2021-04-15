package com.algo.codility;

public class Lesson3_FrogJmp {

	/** 개구리 현재위치 X -> Y보다 크거나 같은 위치로 가고싶다. 
	 * 고정된 D 만큼씩 점프한다. */
	public static void main(String[] args) {
		
	}
	public int solution(int X, int Y, int D) {
        // write your code in Java SE 8
		int cnt = 0;
		int tmp = 0;
		if(X<Y) {
			cnt = (Y-X)/D;
			tmp = (Y-X)%D;
		}
		if(tmp>0) {
			cnt++;
		}
		return cnt;
		
    }
}
