package com.algo.kakao.internship;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class test3 {

	public static void main(String[] args) {
		test3 t = new test3();
		int n=8;
		int k=2;
		//String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
		String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
		String result = t.solution(n,k,cmd);
		System.out.println(result);
	}

	public String solution(int n, int k, String[] cmd) {
		// 한번에 한행만 선택가능.
		// U X : 현재선택된행에서 X칸 위의 행을 선택 
		// D X : 현재선택된행에서 X칸 아래행 선택 
		// C : 현재행 삭제. 바로아래행 선택. (내가선택한게 맨마지막이면 맨위를 선택)
		// Z : 가장최근 삭제된 행을 복구. ( 현재선택된행은 바뀌지 않는다. )
		// n : 처음 표의 행 갯수 ( 5~1,000,000 )
		// k : 처음 선택된 행의 위치 ( 0~n-1)
		// cmd : 명령어담긴 배열 ( 1~200,000 )
		// cmd의 원소는 "U X", "D X", "C", "Z" 4개뿐. 
		// X는 1~300,000 자연수. X들의 합이 1,000,000 이하인 경우만 입력으로 주어짐. 
		// 행이 하나도 남지않는경우는 주어지지 않음. 
		// 삭제된행이 없을때 Z가 주어지는 경우는 없음. 
		boolean[] check = new boolean[1000001];
		ArrayList<Integer> stk = new ArrayList<>();
		for(int i = 0; i < cmd.length; i++){
	        if(cmd[i].charAt(0) == 'U'){
	        	int num = Integer.parseInt(cmd[i].substring(2)+"");
	            for(int j = 0; j < num; j++){//num만큼 올라가 
	                k--;
	                if(check[k]){// 가는도중 삭제된칸 만나면 
	                    j--; // 더올라가야됨
	                }
	            }
	        }
	        else if(cmd[i].charAt(0) == 'D'){
	        	int num = Integer.parseInt(cmd[i].substring(2)+"");
	            for(int j = 0; j < num; j++){ //num만큼 내려가 
	                k++;
	                if(check[k]){ //삭제된칸 만나면 
	                    j--; // 더내려가야됨 
	                }
	            }
	        }
	        else if(cmd[i].charAt(0) == 'C'){
	            boolean flag = false;
	            stk.add(k);
	            check[k] = true;
	            for(int j = k + 1; !flag && j < n; j++){// 현재가리키는애의 다음꺼를 가리키기 위해서 k+1 부터 
	                if(!check[j]){//삭제된행이 아닌행을 선택 
	                    flag = true;
	                    k = j;
	                }
	            }
	            // 마지막까지도 선택할 행이 없었으면 현재 가리키는애의 앞에애를 선택
	            for(int j = k - 1; !flag && j >= 0; j--){
	                if(!check[j]){
	                    flag = true;
	                    k = j;
	                }
	            }
	        }
	        else{ //복구 
	            check[stk.get(stk.size()-1)] = false;
	            stk.remove(stk.size()-1);
	        }
	    }//end for
		
		char[] array = new char[n];
		Arrays.fill(array, 'O');	    
	    
	    for(int i = 0; i < stk.size(); i++){
	        array[stk.get(i)] ='X';
	    }
	    String answer = new String(array, 0, n);
	    return answer;
    }
}
