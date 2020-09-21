package com.algo.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ����_5653_�ٱ⼼����� {
	/** 
	 * �ٱ⼼�� ��Ȱ�� ����.
	 * ����� ��ġ�� x : x�ð� ���� ��Ȱ��ȭ. x�ð� ������ ���� Ȱ������
	 * Ȱ�����µǸ�, x�ð����� ����ְ�, x�ð� ������ �״´�.
	 * Ȱ�����µǸ�, 1�ð����� ��,��,��,�� �׹������� ����
	 * �ΰ��̻��� �ٱ⼼���� �ϳ��� �׸��弿�� ���ù����Ϸ��� ��� ����� ���� �ٱ⼼���� ����.
	 * */
	static int T;
	static int N,M,K;
	static int[][] cell;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(in.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken()); //2 (��)
			M = Integer.parseInt(st.nextToken()); //2 (��)
			K = Integer.parseInt(st.nextToken()); //10 (���ð�: 1~300)
			cell = new int[N][M];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=0; j<M; j++) {
					cell[i][j] = Integer.parseInt(st.nextToken());
				}
			}//end Input
			
			
		}// end testcase
	}

}
