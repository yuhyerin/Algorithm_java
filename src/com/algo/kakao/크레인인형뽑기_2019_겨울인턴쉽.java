package com.algo.kakao;

import java.util.Stack;

public class ũ���������̱�_2019_�ܿ����Ͻ� {
	
	public static void main(String[] args) {
		
		ũ���������̱�_2019_�ܿ����Ͻ�  t = new ũ���������̱�_2019_�ܿ����Ͻ�();
		int[][] board = {{0,0,0,0,0},
						{0,0,1,0,3},
						{0,2,5,0,1},
						{4,2,4,4,2},
						{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		int result = t.solution(board, moves);
		System.out.println(result);
	}
	// �Ͷ߷� ����� ������ ������ ���� 
	// board ũ�� 5~30
	// 0 �� ��ĭ, ���ڴ� ���� �ٸ� ������ ����� �ǹ� ( 1~100 )
	// moves ũ�� 1~1000
	public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int len = board.length;
        Stack<Integer> basket = new Stack<>();
        for(int m=0; m<moves.length; m++) {
        	int cur = moves[m]-1;
        	for(int i=0; i<len; i++) {
        		if(board[i][cur] !=0) { // ���� �����ִ� ������ ������ 
        			if(!basket.isEmpty() && basket.peek() == board[i][cur]) {// ������ �������� �ֿ� ���ؼ� ������ 
        				answer+=2;
        				basket.pop(); //�ٱ��Ͽ��� ���� 
        				board[i][cur]=0; // board������ ����
        				break;
        			}else{
        				basket.push(board[i][cur]); // �ٱ��Ͽ� �ֱ�
        				board[i][cur]=0; // board���� ���� 
        				break;
        			}
        		}// end if
        	}
        }
        return answer;
    }

}
