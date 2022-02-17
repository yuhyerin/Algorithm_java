package com.algo.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14500_테트로미노 {
	
	static int N,M;
	static int[][] map;
	static int[][][] tetromino = {{{1,0},{2,0},{3,0}}, // 1) 일자막대-가로 
								{{0,1},{0,2},{0,3}}, // 2) 일자막대-세로 
								{{1,0},{0,1},{1,1}}, // 3) 정사각 
								{{0,1},{0,2},{1,2}}, // 4) 니은 ㄴ 
								{{1,0},{2,0},{2,-1}}, // 5) 니은 90
								{{0,-1},{0,-2},{-1,-2}}, // 6) 니은 180 7 
								{{0,1},{-1,1},{-2,1}}, // 7) 니은 270 
								{{0,-1},{0,-2},{1,-2}}, // 8) 니은 대칭 
								{{0,1},{0,2},{-1,2}}, // 9) 니은 90 대칭 
								{{-1,0},{-2,0},{-2,-1}}, // 10) 니은 180 대칭 
								{{-1,0},{-2,0},{-2,1}}, // 11) 니은 270 대칭 
								{{0,1},{1,1},{1,2}}, // 12) 번개 
								{{-1,0},{-1,1},{-2,1}}, // 13) 번개 90 
								{{1,0},{1,-1},{2,-1}}, // 14) 번개 대칭 
								{{0,1},{-1,1},{-1,2}}, // 15) 번개 90 대칭 
								{{1,0},{1,1},{2,0}}, // 16) ㅜ
								{{-1,1},{0,1},{0,2}}, // 17) ㅓ 
								{{-1,1},{0,1},{1,1}}, // 18) ㅗ 
								{{0,1},{1,1},{0,2}}  // 19) ㅏ 
								};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}// end map
		
		int sum = 0;
		int max = 0;
		boolean flag = false;
		for(int i=0;i<N;i++) {
			for(int j=0; j<M; j++) {
				for(int k=0; k<19; k++) {
					sum = map[i][j];
					flag = false;
					for(int q=0; q<3; q++) {
						int ny = i + tetromino[k][q][1];
						int nx = j + tetromino[k][q][0];
						if(!canGo(ny,nx)) { // 하나라도 둘 수 없으면 
							flag = true;
							break; // 다음으로 넘어가 
						}
						sum+=map[ny][nx];
					}// end 3개 연속 블록 
					if(!flag) {
						if(max < sum) {
							max = sum;
						}
					}
				}
			}
		}// end for 
		System.out.println(max);
	}
	
	private static boolean canGo(int ny, int nx) {
		if(0<= ny && ny <N && 0<=nx && nx<M) {
			return true;
		}
		return false;
	}
}
