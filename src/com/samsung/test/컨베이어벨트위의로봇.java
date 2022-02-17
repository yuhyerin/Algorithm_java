package com.samsung.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 컨베이어벨트위의로봇 {

	public static class Belt{
		boolean isRobot; // 로봇 유무
		int dur; // 내구성

		public Belt(int dur) {
			this.isRobot = false;
			this.dur = dur;
		}

		public boolean isRobot() {
			return isRobot;
		}

		public void setRobot() {
			this.isRobot = true;
		}
		
		public void delRobot() {
			this.isRobot = false;
		}

		public int getDur() {
			return dur;
		}

		public void setDur(int dur) {
			this.dur = dur;
		}

		public void minusDur() {
			this.dur-=1;
		}
	}
	static int N, K;
	static Belt[][] map;
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 길이가 N인 컨베이어 벨트.
		K = Integer.parseInt(st.nextToken()); // 내구도가 0인 칸의 갯수가 K개 이상이면 종료.
		map = new Belt[2][N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N; i++) {
			int dur = Integer.parseInt(st.nextToken());
			map[0][i] = new Belt(dur);
		}
		for(int i=N-1; i>=0; i--) {
			int dur = Integer.parseInt(st.nextToken());
			map[1][i] = new Belt(dur);
		}
		//end input 
		
		int level = 0;
		while (true) {
			level++;
			rotateConvayor(); // 1. 벨트 회전
			moveRobot(); // 2. 로봇 이동
			loadNewRobot(); // 3. 새로봇 올리기
			if (getZeroCnt() >= K) { // 4. 종료조건
				break;
			}
		}// end while 
		
		System.out.println(level);
	}
	
	// 컨베이어 벨트 회전 
	public static void rotateConvayor() {
		Belt first = map[1][0];
		Belt last = map[0][N-1];
		
		// 0행 데이터 이동
		for(int i=N-2; i>=0; i--) {
			map[0][i+1] = map[0][i];
		}
		// 1행 데이터 이동
		for(int i=1; i<N; i++) {
			map[1][i-1] = map[1][i]; 
		}
		
		map[0][0] = first;
		map[1][N-1] = last;
		
		map[0][N-1].delRobot(); // 내리는위치로 이동했으면 바로 로봇 없애준다!
	}
	// 로봇 이동
	public static void moveRobot() {
		for(int i=N-2; i>=0; i--) { // 먼저올라간 로봇부터 순차 이동 
			if(map[0][i].isRobot && !map[0][i+1].isRobot && map[0][i+1].getDur() >0) { // 이동할 위치에 로봇이 없고, 내구성이 1이상이어야 함.
				map[0][i].delRobot();
				map[0][i+1].setRobot(); // 이동
				map[0][i+1].minusDur(); // 내구도 감소
			}
		}
		map[0][N-1].delRobot(); // 내리는위치로 이동했으면 바로 로봇 없애준다!
	}
	
	// 새로봇 올리기 
	public static void loadNewRobot() {
		if(map[0][0].getDur() >0 && !map[0][0].isRobot ) {
			map[0][0].setRobot();
			map[0][0].minusDur(); // 내구도 감소
		}
	}
	
	// 내구도가 0인 칸의 갯수 세기
	public static int getZeroCnt() {
		int cnt=0;
		for(int i=0; i<2; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j].getDur() == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
