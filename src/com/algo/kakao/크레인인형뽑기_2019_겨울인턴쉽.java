package com.algo.kakao;

import java.util.Stack;

public class 크레인인형뽑기_2019_겨울인턴쉽 {
	
	public static void main(String[] args) {
		
		크레인인형뽑기_2019_겨울인턴쉽  t = new 크레인인형뽑기_2019_겨울인턴쉽();
		int[][] board = {{0,0,0,0,0},
						{0,0,1,0,3},
						{0,2,5,0,1},
						{4,2,4,4,2},
						{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		int result = t.solution(board, moves);
		System.out.println(result);
	}
	// 터뜨려 사라진 인형의 갯수를 리턴 
	// board 크기 5~30
	// 0 은 빈칸, 숫자는 각기 다른 인형의 모양을 의미 ( 1~100 )
	// moves 크기 1~1000
	public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int len = board.length;
        Stack<Integer> basket = new Stack<>();
        for(int m=0; m<moves.length; m++) {
        	int cur = moves[m]-1;
        	for(int i=0; i<len; i++) {
        		if(board[i][cur] !=0) { // 제일 위에있는 인형을 만나면 
        			if(!basket.isEmpty() && basket.peek() == board[i][cur]) {// 스택의 제일위에 애와 비교해서 같으면 
        				answer+=2;
        				basket.pop(); //바구니에서 제거 
        				board[i][cur]=0; // board에서도 제거
        				break;
        			}else{
        				basket.push(board[i][cur]); // 바구니에 넣기
        				board[i][cur]=0; // board에서 제거 
        				break;
        			}
        		}// end if
        	}
        }
        return answer;
    }

}
