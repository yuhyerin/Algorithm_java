package com.algo.bj;

import java.util.LinkedList;
import java.util.Queue;

public class BJ_1937_욕심쟁이판다 {
    public static void main(String[] args) {
        String[][] board = { { "A", "B", "T", "T", "T" },
                { "T", "C", "D", "E", "T" },
                { "T", "T", "T", "F", "T" },
                { "B", "A", "H", "G", "F" },
                {"C","D","E","F","G"}};

        BJ_1937_욕심쟁이판다 t = new BJ_1937_욕심쟁이판다();
        int result = t.solution(board);
        System.out.println("정답: " + result);
        // 처음에 아무칸에서나 시작 가능.
        // 상,하,좌,우 한칸씩 이동.
        // 한번 방문한 곳 방문X
        // 사전순으로 뒤에있는 알파벳일때만 이동가능
        // 딱 한번만, 사전순 앞에오는 칸으로 이동할 수 있음
        // 최대값 구하기.

    }

    static int[] dy = {-1,1,0,0}; // 상,하,좌,우
    static int[] dx = {0,0,-1,1};
    static boolean[][] visit;
    static int max = 0;
    int solution(String[][] board) {
        int answer = 0;
        int N = board.length;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
            	visit = new boolean[N][N];
            	boolean chance = true;
                dfs(board,i,j, chance, 1);
            }
        }// end for
        return max;
    }

    private void dfs(String[][] board, int y, int x, boolean chance, int cnt) {
        visit[y][x]=true; // 현재 알파벳 방문
        max = max < cnt ? cnt : max;
        for(int d=0; d<4;d++) {
            int ny = y+dy[d];
            int nx = x+dx[d];
            if(canGo(ny,nx) && !visit[ny][nx]) {
                if(chance) {
                    if(board[ny][nx].charAt(0) < board[y][x].charAt(0)){
                        dfs(board, ny, nx, !chance, cnt + 1);
                    }
                    else if(board[ny][nx].charAt(0) > board[y][x].charAt(0)){
                        dfs(board, ny, nx, chance, cnt + 1);
                    }
                }
                else{
                    if (board[y][x].charAt(0) < board[ny][nx].charAt(0)) {
                        dfs(board, ny, nx, chance, cnt + 1);
                    }
                }
            }
        }
        // 방문안한걸로 되돌리기
        visit[y][x]=false;
    }

    private boolean canGo(int ny, int nx) {
        if(0<= nx && nx <5 && 0<= ny && ny <5) {
            return true;
        }
        return false;
    }

}