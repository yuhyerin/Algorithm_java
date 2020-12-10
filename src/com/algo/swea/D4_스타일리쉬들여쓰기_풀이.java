package com.algo.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_스타일리쉬들여쓰기_풀이 {

	/**
	 * 알파벳, 세종류괄호, 온점(.), 개행문자 괄호는 짝이 맞게 써야 한다. ( ) [ ] { } 괄호가 등장한 횟수에 따라 들여쓰기를 하는
	 * 정도가 달라진다! R,C,S 소괄소가 짝이 맞지 않는 갯수만큼 R번씩 중괄호가 짝이 맞지 않는 갯수만큼 C번씩, 대괄호가 짝이 맞지 않는
	 * 갯수만큼 S번씩
	 * 
	 * 내 코드에는 각 줄마다 몇번씩 들여쓰기 해야하는지 출력!
	 */
	static int T;
	static int p; // p: 스타일리쉬를 마스터한 사람 코드 줄수
	static int q; // q: 내 코드 줄 수
	static char[][] master;
	static char[][] me;
	static int[] result;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(in.readLine());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			master = new char[p][];
			me = new char[q][];
			result = new int[q]; // 내코드 각 행마다 들여쓰기 해야되는 수 (-1이면 결정불가능 )
			Arrays.fill(result, -2); // 처음 들여쓰기 시도하는 것으로 판단하기위해 -2로 초기화!
			
			for(int i=0; i<p; i++) {
				master[i] = in.readLine().toCharArray();
			}// end Input master
			
			for(int i=0; i<q;i++) {
				me[i]= in.readLine().toCharArray();
			}// end Input me

			for(int r=1; r<=20; r++) { //모든 r,c,s 조합 
				for(int c=1; c<=20; c++) {
					for(int s=1; s<=20; s--) {
						if(isOk(r,c,s)) { // r,c,s 경우 하나 만들어서 유효한 쌍인지 체크.
							useRCS(r,c,s); // 내코드에 적용시켜!
						}
					}
				}
			}
			System.out.print("#"+t+" ");
			for(int r: result) {
				System.out.print(r+" ");
			}
			System.out.println();
		}
	}
	
	private static void useRCS(int r, int c, int s) {
		int rCnt=0, cCnt=0, sCnt=0;
		for(int i=0; i<q; i++) {
			if(result[i] == -2) {
				result[i] = r*rCnt + c*cCnt + s*sCnt;
			}else {
				if(result[i] != r*rCnt + c*cCnt + s*sCnt) {
					result[i] = -1;
				}
			}
			
			for(char ch : me[i]) {
				switch(ch) {
					case '(': rCnt++; break;
					case ')': rCnt--; break;
					case '{': cCnt++; break;
					case '}': cCnt--; break;
					case '[': sCnt++; break;
					case ']': sCnt--; break;
				}
			}
		}
		
	}
	private static boolean isOk(int r, int c, int s) {
		
		int rCnt=0, cCnt=0, sCnt=0;
		for(int i=0; i<p; i++) {
			
			int dotCnt = 0; // 점갯수 (공백갯수)
			for(char ch : master[i]) {
				if(ch=='.') dotCnt++;
				else break;
			}
			int tab = r*rCnt + c*cCnt + s*sCnt;
			
			if(tab != dotCnt) { // 현재 주어진 r,c,s 가지고 마스터의 들여쓰기 갯수와 매칭되는지 확인!
				return false;
			}
			
			for(int j=0; j< master[i].length; j++) { // 현재 행의 괄호들의 차이 계산.
				switch(master[i][j]) {
					case '(': rCnt++; break;
					case ')': rCnt--; break;
					case '{': cCnt++; break;
					case '}': cCnt--; break;
					case '[': sCnt++; break;
					case ']': sCnt--; break;
				}
			}
		}
		return true;
	}
}
