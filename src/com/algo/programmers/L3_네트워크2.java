package com.algo.programmers;

public class L3_네트워크2 {
	
	/** A-B, B-C 연결되어 있을 때, A와 C도 정보교환 가능!
	 * 네트워크 갯수 리턴. 
	 * 컴퓨터갯수 n : 1~200
	 * */
	public static void main(String[] args) {
		int n = 3;
		int[][] computers = {   {1,1,0},
								{1,1,1},
								{0,1,1}};
		int result = solution(n, computers);
		System.out.println(result);
	}

	public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n]; // 방문체크 

        for(int i=0; i<n; i++) {
        	if(!visit[i]) { // false면,
//        		System.out.println(i+" 처음방문!");
        		dfs(n, computers, visit, i);
        		answer++;
        	}
        }
        
        return answer;

    }

	private static void dfs(int n, int[][] computers, boolean[] visit, int start) {
		visit[start] = true;
//		System.out.println(start+" 방문표시  !");
		for(int i=0; i<n; i++) {
			if(computers[start][i]==1 && !visit[i]) {
//				System.out.println(start+"과 "+i +" 연결되어있음!");
				dfs(n,computers, visit, i);
			}
		}
	}

	
}
