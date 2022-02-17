package com.algo.bj.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14891_톱니바퀴 {
	static int K;
	static Gear[] gears;
	static boolean[] visit;
//	static int[][] gears;
//	static boolean[] rotate;
//	static int[] dirs;
	static int[] side= {-1,1}; // 왼쪽, 오른쪽
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		gears = new Gear[5];
		visit = new boolean[5];
//		gears = new int[4][8];
//		rotate = new boolean[4];
//		dirs = new int[4];
		
		
		for(int i=1; i<=4; i++) {
			String value = br.readLine();
			for(int j=0; j<8; j++) {
				gears[i] = new Gear(i,0,value);
			}
		}// end for 
		
		// N:0 / S:1
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()); // 돌릴 바퀴 
		int dir = Integer.parseInt(st.nextToken()); // 방향 (1:시계, -1:반시계)
		
		gears[start].setDir(dir);
		gears[start].isRotate = true;
		go(start);
		
		int answer = 0;
//		if(gears[0][0]==1) answer+=1;
//		if(gears[1][0]==1) answer+=2;
//		if(gears[2][0]==1) answer+=3;
//		if(gears[3][0]==1) answer+=4;
		
		System.out.println(answer);
	}
	
	static class Gear{
		int no; // 톱니번호 
		int dir; // 방향
		boolean isRotate; // 회전여부 
		int[] value; // 톱니들의 값
		
		public Gear(int no, int dir, String nums) {
			this.no = no;
			this.dir = dir;
			this.isRotate = false;
			this.value = new int[8];
			this.setValue(nums);
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
	
	private static void go(int start) {
		
		Queue<Gear> que = new LinkedList<Gear>();
		que.add(gears[start]);
		
		while(!que.isEmpty()) {
			Gear cur = que.poll();
			
			if(!visit[cur.no]) {
				visit[cur.no] = true;
				
				for(int i=0; i<2; i++) { // 양방향 검사.
					int new_no = cur.no + side[i];
					if(!check(new_no)) continue;
					if(visit[new_no]) continue;
					
					if(i==0) { // 왼쪽 
						if(gears[new_no].value[2]!=gears[cur.no].value[6]) {
							gears[new_no].dir = -1*gears[cur.no].dir;
							gears[new_no].isRotate = true;
							que.add(gears[new_no]);
						}else {
							
						}
						
					}else { // 오른쪽 
						if(gears[new_no].value[6]!=gears[cur.no].value[2]) {
							gears[new_no].dir = -1*gears[cur.no].dir;
							gears[new_no].isRotate = true;
							que.add(gears[new_no]);
						}
					}
				}// end for
				
			}// end if 
			
		}// end while 
	}

	private static boolean check(int i) {
		if(1<= i && i<=4) return true;
		return false;
	}
}
