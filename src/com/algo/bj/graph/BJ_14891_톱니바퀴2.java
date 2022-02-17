package com.algo.bj.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14891_톱니바퀴2 {
	static int K;
	static Gear[] gears;
	static boolean[] visit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		gears = new Gear[5];
		visit = new boolean[5];
		
		for(int i=1; i<=4; i++) {
			String value = br.readLine();
			gears[i] = new Gear(value);
		}// end for 
		
		// N:0 / S:1
		K = Integer.parseInt(br.readLine());
		System.out.println();
		for(int i = 1; i <= 4; i++) {
			System.out.println(gears[i].toString());
		}
		System.out.println();
		for(int k = 0; k < K; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()); // 돌릴 바퀴 
			int dir = Integer.parseInt(st.nextToken()); // 방향 (1:시계, -1:반시계)
			gears[start].setDir(dir);
			go(start);
			move();
			for(int i = 1; i <= 4; i++) {
				System.out.println(gears[i].toString());
			}
			System.out.println();
		}
		
		int answer = 0;
		
		
		if(gears[1].getHead()==1) answer+=1;
		if(gears[2].getHead()==1) answer+=2;
		if(gears[3].getHead()==1) answer+=4;
		if(gears[4].getHead()==1) answer+=8;
		
		System.out.println(answer);
	}
	
	static class Gear{
		int no; // 톱니번호 
		int dir; // 방향
		int[] value; // 톱니들의 값
		int head;
		
		@Override
		public String toString() {
			String str = "[";
			for(int i = 0; i < 8; i++) {
				str += Integer.toString(value[(head + i) % 8]);
				str += ", ";
			}
			str += "]";
			return str;
		}
		
		public Gear(String nums) {
			head = 0;
			this.dir = 0;
			this.value = new int[8];
			this.setValue(nums);
		}
		
		public void rotateCCW() {
			head += 1;
			head %= 8;
		}
		
		public void rotateCW() {
			head += 7;
			head %= 8;
		}
		
		public int getLeft() {
			int leftIdx = head + 6;
			leftIdx %= 8;
			return value[leftIdx];
		}
		
		public int getRight() {
			int rightIdx = head + 2;
			rightIdx %= 8;
			return value[rightIdx];
		}
		
		public int getHead() {
			return value[head];
		}
		
		public void setDir(int dir) {
			this.dir = dir;
		}
		
		public void setValue(String nums) {
			for(int i=0; i<8; i++) {
				value[i] = nums.charAt(i)-'0';
			}
		}
	}
	
	static int[] side= {-1,1}; // 왼쪽, 오른쪽
	
	private static void move() {
		for(int i = 1; i <= 4; i++) {
			if(gears[i].dir == 1) {
				gears[i].rotateCW();
			}
			else if (gears[i].dir == -1) {
				gears[i].rotateCCW();
			}
			gears[i].dir = 0;
		}
	}
	
	private static void go(int start) {
		int cur = start;
		int next = start - 1;
		
		while(next > 0) {
			int curDir = gears[cur].dir;
			int nextRight = gears[next].getRight();
			int curLeft = gears[cur].getLeft();
			if(nextRight == curLeft) {
				break;
			}
			gears[next].setDir(curDir * -1);
			cur--;
			next--;
		}
		
		cur = start;
		next = start + 1;
		while(next <= 4) {
			int curDir = gears[cur].dir;
			int nextLeft = gears[next].getLeft();
			int curRight = gears[cur].getRight();
			if(nextLeft == curRight) {
				break;
			}
			gears[next].setDir(curDir * -1);
			cur++;
			next++;
		}
	}

	private static boolean check(int i) {
		if(1<= i && i<=4) return true;
		return false;
	}
}
