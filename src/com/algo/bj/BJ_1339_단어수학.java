package com.algo.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class BJ_1339_�ܾ���� {
	// ���ĺ��� 0~9���� �ϳ��� �ٲ���.
	// ���� ���� �ִ밡 �Ǿ���. 
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine()); // 1~10 
		int[] check = new int[26];
		Arrays.fill(check, -1);
		char[][] array = new char[N][8];
		for(int i=0; i<N; i++) {
			Arrays.fill(array[i], '.');
		}//end �ʱ�ȭ
		
		TreeMap<Integer, String> map = new TreeMap<Integer, String>(); 
		for(int i=0; i<N; i++) {
			String word = in.readLine();
			int len = word.length();
			map.put(len, word);
		}// end input
		
		
		int row= 0;
		Iterator<Integer> reverseIter = map.descendingKeySet().iterator();
		while(reverseIter.hasNext()) {
			String word = map.get(reverseIter.next());
			System.out.println(word);
			int wordlen = word.length();
			System.out.println("���ڿ� ����: "+wordlen);
			int col = 7;
			for(int i=wordlen-1; i>=0; i--) {
				array[row][col] = word.charAt(i);
				col--;
			}
			row++;
		}
		
		for(int i=0; i<N; i++) {
			System.out.println(new String(array[i]));
		}
		
		int max = 9;
		for(int j=0; j<8; j++) {
			for(int i=0; i<N; i++) {
				if(array[i][j]!='.' && check[array[i][j]-'A']==-1) {
					System.out.println(array[i][j]);
					array[i][j]= Character.forDigit(max--,10);
				}else if(array[i][j]!='.' && check[array[i][j]-'A']!=-1) {
					System.out.println(array[i][j]);
					array[i][j] = Character.forDigit(check[array[i][j]-'A'],10);
				}
			}
		}// end for 
//		
//		
//		
//		
		int answer = 0;
		for(int i=0; i<N; i++) {
			String strnum = new String(array[i]);
			int d = strnum.lastIndexOf(".");
			strnum = strnum.substring(d+1, strnum.length());
			System.out.println(strnum);
			int num = Integer.parseInt(strnum);
			System.out.println(num);
			System.out.println("==========");
			answer+=num;
		}
		System.out.println(answer);
	}

}
