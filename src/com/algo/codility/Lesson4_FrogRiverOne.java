package com.algo.codility;

public class Lesson4_FrogRiverOne {
	public static void main(String[] args) {
		int X = 5;
		int[] A = {1,3,1,4,2,3,5,4}; // 8초간 잎이 떨어짐. 
		int result = solution(X,A);
		System.out.println(result);
	}
	public static int solution(int X, int[] A) {
        // 개구리가 건너가려고 함. 
		// 위치0 에서 출발 --> 반대쪽 X+1 에 도달 
		// N : 낙엽 갯수 // N,X  : 1~100,000 
		// A[K] : 시간 K에서 한 잎이 떨어지는 위치를 나타낸다.
		// 개구리가 강 건너편으로 점프할 수 있는 가장 빠른 시간 리턴. 
		// 잎 1~X 까지. 강의 흐름속도는 무시. 잎이 강에 떨어지면 위치바뀌지 X
		int N = A.length;
		boolean[] check = new boolean[100000];
		check[A[0]]=true; // 0초에 떨어진 잎은 고정해두고 시작. 
		int frog = 0;
		int time = 0;
		if(N>1) {
			loop1:
			while(time<=N) {
				while(true) {
					if(check[A[frog+1]]) {// 앞으로 갈수있니?
						frog++;
					}else {// 못가 
						break;
					}
					time++; //시간이 흐르고 
					check[A[time]]=true; // 잎이 떨어짐.
					
					if(frog == X ) {// 개구리 도착함?
						break loop1;
					}
				}
				
			}
		}else {
			// 1초인데 이상한곳에 떨어져서 못건널수 있음. 
			// X가 1이고, 잎이 1에떨어지면 한번에 건넘.
		}
		return time;
    }
	
}
