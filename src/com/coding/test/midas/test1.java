package com.coding.test.midas;

public class test1 {

	public static void main(String[] args) {
        test1 t = new test1();
        int N = 9;
        int[][] mine = { // 지뢰 위치
                {1, 1},
                {1, 7},
                {2, 7},
                {3, 6},
                {4, 1},
                {4, 4},
                {4, 8},
                {8, 4},
                {8, 5},
                {9, 6}
        };
        
        int[][] result = { // 결과 배열
                {-1,  1,  0,  0,  0,  2, -1,  2,  0},
                { 1,  1,  0,  0,  1,  3, -1,  2,  0},
                { 1,  1,  1,  1,  2, -1,  3,  2,  1},
                {-1,  1,  1, -1,  2,  1,  2, -1,  1},
                { 1,  1,  1,  1,  1,  0,  1,  1,  1},
                { 0,  0,  0,  0,  0,  0,  0,  0,  0},
                { 0,  0,  1,  2,  2,  1,  0,  0,  0},
                { 0,  0,  1, -1, -1,  2,  1,  0,  0},
                { 0,  0,  1,  2,  3, -1,  1,  0,  0},
        };
        
        int[][] answer = t.soulution(N, mine);
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++) {
                if (result[i][j] == answer[i][j]){
                    System.out.print("1 ");
                }
                else{
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

	private static int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 };
	private static int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public int[][] soulution(int N, int[][] mine) {
		int[][] answer = new int[N][N];
		for (int[] pos : mine) {
			int y = pos[0] - 1;
			int x = pos[1] - 1;
			answer[y][x] = -1;
			for (int i = 0; i < 8; i++) {
				int newY = y + dy[i];
				int newX = x + dx[i];
				if (isIn(N, newY, newX) && answer[newY][newX] != -1) {
					answer[newY][newX]++;
				}
			}
		}
		return answer;
	}

	private boolean isIn(int N, int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < N;
	}

}
