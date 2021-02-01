package com.algo.bj.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_7568_덩치 {
	/** (몸무게,키) (x,y) 
	 * N명의 집단에서 각 사람의 덩치등수는 자신보다 큰덩치 사람 수 
	 * 자신보다 큰덩치 사람이 k명이면, 등수는 k+1
	 *  2 ≤ N ≤ 50
		10 ≤ x, y ≤ 200
	 *  [입력]
	 *  5
		55 185
		58 183
		88 186
		60 175
		46 155
		
		[출력]
		2 2 1 2 5
	 * */
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		ArrayList<Person> list = new ArrayList<>();
		int[] result = new int[N];
		StringTokenizer st = null;
		int x_val,y_val;
		for(int t=1; t<=N; t++) {
			st = new StringTokenizer(in.readLine());
			x_val = Integer.parseInt(st.nextToken());
			y_val = Integer.parseInt(st.nextToken());
			list.add(new Person(x_val,y_val));
		}
		
		for(int i=0; i<N; i++) {
			Person me = list.get(i);
			for(int j=0; j<N; j++) {
				if(me.compareTo(list.get(j)) >0) {
					result[i]++;
				}
			}
		}
		
		for(int i: result) {
			System.out.print((i+1)+" ");
		}
		System.out.println();
		
	}
	
	static class Person implements Comparable<Person>{
		int x;
		int y;
		
		public Person(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		@Override
		public int compareTo(Person o) {
			if(this.x < o.x && this.y < o.y) {
				return 1; // 나보다 쟤가 더 크다.
			}
			return -1;
		}
		@Override
		public String toString() {
			return "Person [x=" + x + ", y=" + y + "]";
		}
		
	}
}
