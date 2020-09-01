package com.algo.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_��Ÿ�ϸ����鿩����_Ǯ�� {

	/**
	 * ���ĺ�, ��������ȣ, ����(.), ���๮�� ��ȣ�� ¦�� �°� ��� �Ѵ�. ( ) [ ] { } ��ȣ�� ������ Ƚ���� ���� �鿩���⸦ �ϴ�
	 * ������ �޶�����! R,C,S �Ұ��Ұ� ¦�� ���� �ʴ� ������ŭ R���� �߰�ȣ�� ¦�� ���� �ʴ� ������ŭ C����, ���ȣ�� ¦�� ���� �ʴ�
	 * ������ŭ S����
	 * 
	 * �� �ڵ忡�� �� �ٸ��� ����� �鿩���� �ؾ��ϴ��� ���!
	 */
	static int T;
	static int p; // p: ��Ÿ�ϸ����� �������� ��� �ڵ� �ټ�
	static int q; // q: �� �ڵ� �� ��
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
			result = new int[q]; // ���ڵ� �� �ึ�� �鿩���� �ؾߵǴ� �� (-1�̸� �����Ұ��� )
			Arrays.fill(result, -2); // ó�� �鿩���� �õ��ϴ� ������ �Ǵ��ϱ����� -2�� �ʱ�ȭ!
			
			for(int i=0; i<p; i++) {
				master[i] = in.readLine().toCharArray();
			}// end Input master
			
			for(int i=0; i<q;i++) {
				me[i]= in.readLine().toCharArray();
			}// end Input me

			for(int r=1; r<=20; r++) { //��� r,c,s ���� 
				for(int c=1; c<=20; c++) {
					for(int s=1; s<=20; s--) {
						if(isOk(r,c,s)) { // r,c,s ��� �ϳ� ���� ��ȿ�� ������ üũ.
							useRCS(r,c,s); // ���ڵ忡 �������!
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
			
			int dotCnt = 0; // ������ (���鰹��)
			for(char ch : master[i]) {
				if(ch=='.') dotCnt++;
				else break;
			}
			int tab = r*rCnt + c*cCnt + s*sCnt;
			
			if(tab != dotCnt) { // ���� �־��� r,c,s ������ �������� �鿩���� ������ ��Ī�Ǵ��� Ȯ��!
				return false;
			}
			
			for(int j=0; j< master[i].length; j++) { // ���� ���� ��ȣ���� ���� ���.
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
