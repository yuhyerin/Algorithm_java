package com.samsung.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 주사위굴리기2 {

	static class Dice {
		int y, x;
		int dir;
		int front;
		int right;
		int bottom;

		public Dice(int y, int x, int dir, int front, int right, int bottom) {
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.front = front;
			this.right = right;
			this.bottom = bottom;
		}

		@Override
		public String toString() {
			return "Dice [y=" + y + ", x=" + x + ", dir=" + dir + ", front=" + front + ", right=" + right + ", bottom="
					+ bottom + "]";
		}



		// 원래 굴리려는 방향으로 굴리면 막혔을 때 반대방향으로 변경해주기
		public void changeDir() {
			if (this.dir == 0) { // 오른쪽이면
				setDir(2);
			} else if (this.dir == 1) { // 아래면
				setDir(3);
			} else if (this.dir == 2) {// 왼쪽이면
				setDir(0);
			} else if (this.dir == 3) { // 위면
				setDir(1);
			}
		}

		public void setDir(int d) {
			this.dir = d;
		}

		public void rotate() {
			int up = -1;
			switch (this.dir) {
			case 0: // 오른쪽으로 회전 
				// up -> right
				// right -> bottom 
				up = 7-this.bottom; // 기존 
				//// 업데이트 
				this.bottom = this.right;
				this.right = up;
				break;
			case 1: // 아래로 회전 
				//up --> front
				// front --> bottom 
				up = 7-this.bottom;
				this.bottom = this.front;
				this.front = up;
				break;
			case 2: // 왼쪽으로 회전 
				// bottom --> right 
				// left --> bottom 
				int left = 7-this.right;
				this.right = this.bottom;
				this.bottom = left;
				break;
			case 3: // 위로 회전 
				// bottom --> front 
				// front --> up 
				// back --> bottom 
				int back = 7-this.front;
				this.front = this.bottom;
				this.bottom = back;
				break;
			}

//			if (this.dir == 0) { // 오른쪽으로 회전
//				// right가 --> bottom으로
//				// up이 --> right로
//				int up = 7 - this.bottom;
//				this.bottom = this.right;
//				this.right = up;
//			} else if (this.dir == 1) { // 아래로 회전
//				// up이 --> front로
//				// front가 --> bottom으로
//				int up = 7 - this.bottom;
//				this.bottom = this.front;
//				this.front = up;
//			} else if (this.dir == 2) {// 왼쪽으로 회전
//				// bottom이 right로
//				// left가 bottom으로
//				int left = 7 - right;
//				this.right = this.bottom;
//				this.bottom = left;
//			} else if (this.dir == 3) { // 위로 회전
//				// bottom이 front로
//				// back이 bottom으로
//				int back = 7 - this.front;
//				this.front = this.bottom;
//				this.bottom = back;
//			}
		}
	}

	static int N, M, K;
	static int[][] map;
	static int[][] jumsuTable;
	static Dice dice;
	static int[] dy = { 0, 1, 0, -1 }; // 0:오른쪽 , 1:아래, 2:왼쪽, 3:위로 (시계방향)
	static int[] dx = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		jumsuTable = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end input

		int sy = 0, sx = 0, dir = 0, front = 2, right = 3, bottom = 6;
		dice = new Dice(sy, sx, dir, front, right, bottom); // 초기 주사위 위치 세팅.
		int score = 0; // 초기 점수 0점 세팅.
		setJumsu(); // 초기 점수판 생성 
//		printJumsu();
		for (int k = 0; k < K; k++) { // K회 시행.
//			System.out.println("== 총 " + K + "회차 중 --> " + (k + 1) + "회차  맵 상태 == ");
//			printMap();
			

			// 1. 주사위가 굴러간다.
			move();

//			System.out.println("== 주사위가 굴렀습니다 == ");
//			printDice();

			// 2. 점수 획득
			int jumsu = getScore();
			score += jumsu;
//			if (k >= 995) {
//				System.out.println(dice.y + "," + dice.x);
//				System.out.println("== 점수 " + jumsu + " 를 얻어 총점: " + score + " ==");
//			}

//			System.out.print("== 현재 주사위바닥면은 "+ dice.bottom+" 이고, "
//					+ "판의 값은 "+ map[dice.y][dice.x]+" 이고 이동방향이 "+dice.dir);
			// 3. 이동방향 변경
			chageDir();
//			System.out.println("에서 "+dice.dir+" 로 바뀌었습니다. == ");
//			System.out.println("0:오른쪽/1:아래/2:왼쪽/3:위 ");
		}
		
		System.out.println(score);
		System.out.println(dice);
		printMap();
		printDice();
		printJumsu();
	}

	private static void setJumsu() {
		boolean[][] visit = new boolean[N][M];
		Queue<int[]> que = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visit[i][j]) continue;
				que.add(new int[] {i,j});
				visit[i][j] = true;
				int value = map[i][j];
				Queue<int[]> group = new LinkedList<>();
				group.add(new int[] {i,j});
				int cnt  = 1;
				while(!que.isEmpty()) {
					int[] cur = que.poll();
					int cy = cur[0];
					int cx = cur[1];
					for(int d=0; d<4; d++) {
						int ny = cy + dy[d];
						int nx = cx + dx[d];
						if(!canGo(ny,nx)) continue;
						if(visit[ny][nx]) continue;
						if(map[ny][nx]==value) {
							visit[ny][nx]=true;
							que.add(new int[] {ny,nx});
							group.add(new int[] {ny,nx});
							cnt++;
						}
					}
				}// end while
				int jumsu = value*cnt;
				while(!group.isEmpty()) {
					int[] pos = group.poll();
					jumsuTable[pos[0]][pos[1]] = jumsu;
				}
			}
		}// end for
//		printJumsu();
	}

	private static void printJumsu() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.printf("%4d", jumsuTable[i][j]);
			}
			System.out.println();
		}
		
	}

	// 3. 이동방향 변경
	private static void chageDir() {
		int A = dice.bottom;
		int B = map[dice.y][dice.x];

		if (A > B) { // (시계방향)
			dice.dir = (dice.dir + 1) % 4;
		} else if (A < B) { // (반시계방향)
			dice.dir = (dice.dir + 3) % 4;
		}
	}

	// 2. 점수획득
	private static int getScore() {
//		boolean[][] visit = new boolean[N][M];
//		Queue<int[]> que = new LinkedList<int[]>();
//		que.add(new int[] { dice.y, dice.x });
//		visit[dice.y][dice.x] = true;
//		int value = map[dice.y][dice.x];
//		int cnt = 1;
//		while (!que.isEmpty()) {
//			int[] cur = que.poll();
////			visit[cur[0]][cur[1]]=true;
//			for (int d = 0; d < 4; d++) { // 주변 탐색
//				int ny = cur[0] + dy[d];
//				int nx = cur[1] + dx[d];
//				if (!canGo(ny, nx))
//					continue;
//				if (visit[ny][nx])
//					continue;
//				if (map[ny][nx] == value) {
//					que.add(new int[] { ny, nx });
//					visit[ny][nx] = true;
//					cnt++;
//				}
//			} // end for
//		}
//		return cnt * value;
		return jumsuTable[dice.y][dice.x];
	}

	// 1. 주사위 굴리기
	private static void move() {

		// 굴렸을때 이동할 위치.
		int ny = dice.y + dy[dice.dir];
		int nx = dice.x + dx[dice.dir];

		// 그 위치가 이동할 수 없으면
		if (!canGo(ny, nx)) {

			// 방향을 반대로 정해주고.
			dice.changeDir();

			// 그 방향 다시 계산.
			ny = dice.y + dy[dice.dir];
			nx = dice.x + dx[dice.dir];
		}
		// 굴려서. 주사위 위치 업데이트됨.
		dice.y = ny;
		dice.x = nx;
		dice.rotate();
	}

	public static boolean canGo(int y, int x) {
		if (0 <= y && y < N && 0 <= x && x < M) {
			return true;
		}
		return false;
	}

	// 맵
	public static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.printf("%2d", map[i][j]);
			}
			System.out.println();
		}
	}

	// 주사위
	public static void printDice() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i == dice.y && j == dice.x) {
					System.out.printf("%2s", "◼︎"); // ◻ ︎◼︎
				} else {
					System.out.printf("%2s", "◻︎");
				}
			}
			System.out.println();
		}
	}
}
