package com.algo.programmers;

public class L3_��Ʈ��ũ2 {
	
	/** A-B, B-C ����Ǿ� ���� ��, A�� C�� ������ȯ ����!
	 * ��Ʈ��ũ ���� ����. 
	 * ��ǻ�Ͱ��� n : 1~200
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
        boolean[] visit = new boolean[n]; // �湮üũ 

        for(int i=0; i<n; i++) {
        	if(!visit[i]) { // false��,
//        		System.out.println(i+" ó���湮!");
        		dfs(n, computers, visit, i);
        		answer++;
        	}
        }
        
        return answer;

    }

	private static void dfs(int n, int[][] computers, boolean[] visit, int start) {
		visit[start] = true;
//		System.out.println(start+" �湮ǥ��  !");
		for(int i=0; i<n; i++) {
			if(computers[start][i]==1 && !visit[i]) {
//				System.out.println(start+"�� "+i +" ����Ǿ�����!");
				dfs(n,computers, visit, i);
			}
		}
	}

	
}
