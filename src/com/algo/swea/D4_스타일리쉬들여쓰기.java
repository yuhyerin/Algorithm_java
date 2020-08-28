package com.algo.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_��Ÿ�ϸ����鿩���� {

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

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(in.readLine());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			int[] result = new int[p];
			int[][] RCS = new int[p][3];
			int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0;
			int R = 0, C = 0, S = 0;
			for (int i = 0; i < p; i++) {
				String line = in.readLine();
				int cnt = 0;
				for (int j = 0; line.charAt(0) == '.' && j < line.length(); j++) {
					if (line.charAt(j) == '.') {
						cnt++;
					} else {
						break;
					}
				}
				result[i] = cnt; // result�� . ���� ���� �迭
				for(int j=0; j<line.length(); j++) {
					if(line.charAt(j)=='(') {
						a++;
					}
					if(line.charAt(j)==')') {
						b++;
					}
					if(line.charAt(j)=='[') {
						c++;
					}
					if(line.charAt(j)==']') {
						d++;
					}
					if(line.charAt(j)=='{') {
						e++;
					}
					if(line.charAt(j)=='}') {
						f++;
					}
				}
				RCS[i][0] = a - b;
				RCS[i][1] = c - d;
				RCS[i][2] = e - f;
			}// end Input master
			
			String[] mycode = new String[q];
			for(int i=0; i<q;i++) {
				mycode[i]= in.readLine();
			}// end Input mycode

			// �ִ� 10��, 1�ٿ� 80��.
			// R, C,S 1~20
			int Rcount =0;
			int Ccount=0;
			int Scount=0;
			for (int r = 1; r <= 20; r++) {
				for (c = 1; c <= 20; c++) {
					for (int s = 1; s <= 20; s++) {
						int cnt=0;
						// ��� ��츦 �� �����ϴ�??? 
						for (int i = 0; i < p-1 ; i++) {
							if (r*RCS[i][0] + c*RCS[i][1] + s*RCS[i][2] == result[i+1]) {
								cnt++;
							} else {
								break;
							}
						}
						if(cnt==p-1) { //��� ��츦 �� �����ϴ� R,C,S�� ���� 
							if(R != r) Rcount++;
							if(C != c) Ccount++;
							if(S != s) Scount++;
							R = r;
							C = c;
							S = s;
						}
					}
				}
			} // end outer
			
			// ���ڵ�.
			System.out.print("#"+t+" 0 ");
			int a2 = 0, b2 = 0, c2 = 0, d2 = 0, e2 = 0, f2 = 0;
			for (int i = 0; i < q-1; i++) {
				String line = mycode[i];
				for(int j=0; j<line.length(); j++) {
					if(line.charAt(j)=='(') {
						a2++;
					}
					if(line.charAt(j)==')') {
						b2++;
					}
					if(line.charAt(j)=='[') {
						c2++;
					}
					if(line.charAt(j)==']') {
						d2++;
					}
					if(line.charAt(j)=='{') {
						e2++;
					}
					if(line.charAt(j)=='}') {
						f2++;
					}
				}
				
				if(a2-b2 ==0) {
					if(c2-d2==0) {
						if(e2-f2==0) {
							System.out.print((R*(a2-b2)+ C*(c2-d2)+ S*(e2-f2))+" ");
						}else {// S�� ���� 
							if(Scount!=1) { // S�� ��Ȯ��
								System.out.print(-1+" ");
							}else {
								System.out.print((R*(a2-b2)+ C*(c2-d2)+ S*(e2-f2))+" ");
							}
						}
					}else { //C�� ����
						if(Ccount!=1) { // C�� ��Ȯ��
							System.out.print(-1+" ");
						}else {
							System.out.print((R*(a2-b2)+ C*(c2-d2)+ S*(e2-f2))+" ");
						}
						
					}
				}else { // R�� ����
					if(Rcount!=1) { // S�� ��Ȯ��
						System.out.print(-1+" ");
					}else {
						System.out.print((R*(a2-b2)+ C*(c2-d2)+ S*(e2-f2))+" ");
					}
				}

				
			}// end Input 
			System.out.println();
		}
	}
}
