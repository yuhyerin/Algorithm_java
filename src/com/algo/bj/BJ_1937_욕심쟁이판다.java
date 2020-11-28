package com.algo.bj;

import java.util.LinkedList;
import java.util.Queue;

public class BJ_1937_��������Ǵ� {
    public static void main(String[] args) {
        String[][] board = { { "A", "B", "T", "T", "T" },
                { "T", "C", "D", "E", "T" },
                { "T", "T", "T", "F", "T" },
                { "B", "A", "H", "G", "F" },
                {"C","D","E","F","G"}};

        BJ_1937_��������Ǵ� t = new BJ_1937_��������Ǵ�();
        int result = t.solution(board);
        System.out.println("����: " + result);
        // ó���� �ƹ�ĭ������ ���� ����.
        // ��,��,��,�� ��ĭ�� �̵�.
        // �ѹ� �湮�� �� �湮X
        // ���������� �ڿ��ִ� ���ĺ��϶��� �̵�����
        // �� �ѹ���, ������ �տ����� ĭ���� �̵��� �� ����
        // �ִ밪 ���ϱ�.

    }

    static int[] dy = {-1,1,0,0}; // ��,��,��,��
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
        visit[y][x]=true; // ���� ���ĺ� �湮
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
        // �湮���Ѱɷ� �ǵ�����
        visit[y][x]=false;
    }

    private boolean canGo(int ny, int nx) {
        if(0<= nx && nx <5 && 0<= ny && ny <5) {
            return true;
        }
        return false;
    }

}