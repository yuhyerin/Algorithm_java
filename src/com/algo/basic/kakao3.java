package com.algo.basic;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class kakao3 {
	/**
	 * info �迭ũ�� 1~5��
	 * info�� ���� : ���߾��, ����, ���, �ҿ�Ǫ��, ���� */
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
	        
	        int[][] people = new int[info_len][5]; //���߾��, ����, ���, �ҿ�Ǫ��, ����
	        StringTokenizer st = null;
	        for(int i=0; i<info_len;i++) {// ������ ����ŭ �ݺ�
	        	st = new StringTokenizer(info[i]);
	        	String[] men = new String[5];
	        	for(int j=0; j<5; j++) {
	        		men[j]=st.nextToken();
	        	}
	        	
	        	for(int r=0; r<4; r++) { //4���� �׸�
	        		for(int c=0; c< check[r].length; c++) {
	        			if(check[r][c].equals(men[r])) {
	        				people[i][r]=c;
	        			}
	        		}
	        	}
	        	people[i][4]= Integer.parseInt(men[4]); //����
	        	
	        }// end make people
	        
	        //           0        2           4          6    7
	        // query : "java and backend and junior and pizza 100"
	        // query : "  -  and backend and senior and    -  150"
	        int[][] querys = new int[query_len][5];
	        for(int i=0; i<query_len; i++) {// ��������ŭ �ݺ�. 
	        	st = new StringTokenizer(query[i]); // java backend junior pizza 100 
	        	for(int j=0; j<8; j++) {
	        		String q = st.nextToken();
	        		if(j%2==0) {
	        			if(q.equals("-")) {
	        				querys[i][j/2]= 999; // ���ΰ����Ѱ� 999�� ǥ��
	        			}else {
	        				int type = j/2;//0->���, 1->����,2->���,3->Ǫ�� 4->����
	        				for(int k=0; k<check[type].length; k++) {
	        					if(check[type][k].equals(q)) {
	        						querys[i][type] = k;
	        					}
	        				}
	        				
	        			}
	        			
	        		}else if(j==7) {
	        			querys[i][4]= Integer.parseInt(q); //���� ����.
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
		for(int i=0; i<people.length;i++) { //�ѻ���� �� 
			
			// 0-���, 1-����, 2-���, 3-Ǫ��, 4-����
			boolean flag = true;
			for(int j=0; j< query.length-1; j++) { // ������ �� �׸� �� 
				if(query[j] == 999 ) { // ��� ��Ų��.
					continue;
				}else if( people[i][j] != query[j]) {
					flag = false;
					break;
				}
			}
			if(flag) {
				if(query[4]<= people[i][4]) {
					count++; // ��ġ�ϴ� ����̸� counting.
				}
			}
		}//end for
		
		return count;
	}
}
