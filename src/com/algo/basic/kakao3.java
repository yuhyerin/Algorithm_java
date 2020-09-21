package com.algo.basic;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class kakao3 {
	/**
	 * info 배열크기 1~5만
	 * info의 값은 : 개발언어, 직군, 경력, 소울푸드, 점수 */
	public static void main(String[] args) {
		kakao3 a = new kakao3();
		String[] info = {"java backend junior pizza 150",
				"python frontend senior chicken 210",
				"python frontend senior chicken 150",
				"cpp backend senior pizza 260",
				"java backend junior chicken 80",
				"python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200",
				"cpp and - and senior and pizza 250",
				"- and backend and senior and - 150",
				"- and - and - and chicken 100",
				"- and - and - and - 150"};
		int[] result = a.solution(info, query);
		for(int i: result) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	 public int[] solution(String[] info, String[] query) {
	        int info_len = info.length;
	        int query_len = query.length;
	        String[][] check = {{"cpp","java","python"}, //0, 1, 2
	        		{"backend", "frontend"}, //0,1
	        		{"junior", "senior"}, //0,1
	        		{"chicken", "pizza"}}; //0,1 
	        
	        int[][] people = new int[info_len][5]; //개발언어, 직군, 경력, 소울푸드, 점수
	        StringTokenizer st = null;
	        for(int i=0; i<info_len;i++) {// 지원자 수만큼 반복
	        	st = new StringTokenizer(info[i]);
	        	String[] men = new String[5];
	        	for(int j=0; j<5; j++) {
	        		men[j]=st.nextToken();
	        	}
	        	
	        	for(int r=0; r<4; r++) { //4가지 항목
	        		for(int c=0; c< check[r].length; c++) {
	        			if(check[r][c].equals(men[r])) {
	        				people[i][r]=c;
	        			}
	        		}
	        	}
	        	people[i][4]= Integer.parseInt(men[4]); //점수
	        	
	        }// end make people
	        
	        //           0        2           4          6    7
	        // query : "java and backend and junior and pizza 100"
	        // query : "  -  and backend and senior and    -  150"
	        int[][] querys = new int[query_len][5];
	        for(int i=0; i<query_len; i++) {// 쿼리수만큼 반복. 
	        	st = new StringTokenizer(query[i]); // java backend junior pizza 100 
	        	for(int j=0; j<8; j++) {
	        		String q = st.nextToken();
	        		if(j%2==0) {
	        			if(q.equals("-")) {
	        				querys[i][j/2]= 999; // 전부가능한건 999로 표시
	        			}else {
	        				int type = j/2;//0->언어, 1->직군,2->경력,3->푸드 4->점수
	        				for(int k=0; k<check[type].length; k++) {
	        					if(check[type][k].equals(q)) {
	        						querys[i][type] = k;
	        					}
	        				}
	        				
	        			}
	        			
	        		}else if(j==7) {
	        			querys[i][4]= Integer.parseInt(q); //점수 저장.
	        		}
	        		
	        	}//end for j=8
	        }// end make querys
	        
	        ArrayList<Integer> result = new ArrayList<>();
	        for(int i=0; i<query_len; i++) {
	        	result.add(start(querys[i], people));
	        }
	        
	        int idx=0;
	        int[] answer = new int[query_len];
	        for(int n : result) {
	        	answer[idx++]=n;
	        }
	        return answer;
	    }

	private int start(int[] query, int[][] people) {
		
		int count = 0;
		for(int i=0; i<people.length;i++) { //한사람씩 비교 
			
			// 0-언어, 1-직군, 2-경력, 3-푸드, 4-점수
			boolean flag = true;
			for(int j=0; j< query.length-1; j++) { // 쿼리의 한 항목씩 비교 
				if(query[j] == 999 ) { // 통과 시킨다.
					continue;
				}else if( people[i][j] != query[j]) {
					flag = false;
					break;
				}
			}
			if(flag) {
				if(query[4]<= people[i][4]) {
					count++; // 일치하는 사람이면 counting.
				}
			}
		}//end for
		
		return count;
	}
}
