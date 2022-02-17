package com.samsung.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마법사상어와토네이도 {

    static int N; // 격자 크기. 홀수. 3~499
    static int[][] map;
    static int[] dr= {0,1,0,-1}; // 0:왼쪽, 1:아래, 2:오른쪽 3:위쪽
    static int[] dc = {-1,0,1,0};
    static int[][] dsr = {
            {-1, 1,-2,-1, 1, 2,-1, 1, 0}, // 0:왼쪽
            { 0, 0, 1, 1, 1, 1, 2, 2, 3}, // 1:아래
            { 1,-1, 2, 1,-1,-2, 1,-1, 0}, // 2:오른쪽
            { 0, 0,-1,-1,-1,-1,-2,-2,-3} // 3:위쪽
    };
    static int[][] dsc = {
            { 0, 0,-1,-1,-1,-1,-2,-2,-3}, // 0:왼쪽
            {-1, 1,-2,-1, 1, 2,-1, 1, 0}, // 1:아래
            { 0, 0, 1, 1, 1, 1, 2, 2, 3}, // 2:오른쪽
            { 1,-1, 2, 1,-1,-2, 1,-1, 0} // 3:위쪽
    };
    static int[] ratio = { 1, 1, 2, 7, 7, 2,10,10, 5};
    static int total; // 벗어난 총 모래양

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }// end Input

        total = 0;
        // 왼쪽: 0, 아래:1, 오른쪽:2, 위쪽:3
        go(N/2, N/2, 0); // 중간점부터 시작
        System.out.println(total);
    }

    private static void go(int xr, int xc, int d) {
        // xr, xc : x좌표
        // d: 방향
        int move = 1; // 한 방향당 움직여야하는 칸 수
        int cnt = 0; // 1 1 2 2 3 3 4 4 . . . 2개방향씩 같은 move만큼 움직여야 함

        while(true) {

            if(cnt==2) {
                cnt = 0;
                move++;
            }

            for(int i=0; i<move; i++) {                                                  // d방향으로 move칸만큼 이동
                int yr = xr+dr[d];
                int yc = xc+dc[d];
                if(!canGo(yr,yc)) break;
                int y_sand = map[yr][yc];

                for(int n=0; n<9; n++) { // 9방향 비율만큼 모래 흩뿌리기
                    int nr = xr+dsr[d][n];
                    int nc = xc+dsc[d][n];
                    int r = ratio[n];
                    int sand = (map[yr][yc]*r/100);
                    y_sand -= sand ;

                    if(!canGo(nr,nc)) { // 벗어나면
                        total += sand;
                    }else {
                        map[nr][nc]+=sand;
                    }
                }// end for
                map[yr][yc]=0; // 모래가 다 날라가버림~~

                // 알파 (남은모래 전부 a에 뿌리기)
                int ar = yr+dr[d];
                int ac = yc+dc[d];
                if(!canGo(ar,ac)) { // 벗어나면
                    total += y_sand;
                }else {
                    map[ar][ac] += y_sand;
                }
                xr = yr;
                xc = yc;

            }// move칸만큼 이동 완료

            cnt++;
            d = (d+1)%4;

            if(xr==0 && xc ==0) { // 종료.
                break;
            }
        }
    }

    private static boolean canGo(int nr, int nc) {
        if(0<= nr && nr <N && 0<= nc && nc <N) {
            return true;
        }
        return false;
    }
}