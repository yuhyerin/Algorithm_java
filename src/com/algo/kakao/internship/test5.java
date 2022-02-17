package com.algo.kakao.internship;

public class test5 {

	public static void main(String[] args) {
		int k =3; // 정확도: 1~20, 효율성: 1~10,000 
		int[] num = {12,30,1,8,8,6,20,7,5,10,4,1}; // num: 응시자수.(k~10,000) num의 원소는 1~10,000 
		int[][] links = {{-1,-1},
						{-1,-1}, 
						{-1,-1},
						{-1,-1}, 
						{8,5},
						{2,10},
						{3,0},
						{6,1}, 
						{11,-1}, 
						{7,4}, 
						{-1,-1},
						{-1,-1}};
		test5 t = new test5();
		int result = t.solution(k,num,links);
		System.out.println(result);
	}
	
	static boolean[] is_not_root;
    static int answer;
    static int N;
    static int[] rootArray; // k개의 각각의 그룹의 루트를 담는 배열 
    static int rootCnt;

    int[] my_stack;
    int my_top;

	public int solution(int k, int[] num, int[][] links) {
        answer = 2147483647;
        is_not_root = new boolean[10001];
        rootArray = new int[10001];
        rootCnt = 0;
        my_stack = new int[10001];
        my_top = -1;
        N = num.length;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < 2; j++){
                if(links[i][j] != -1){ // 자식을 만나면  
                    is_not_root[links[i][j]] = true; // 자식은 루트가 아니라고 표시.
                }
            }
        }
        
        for(int i = 0; i < N; i++){
            if(!is_not_root[i]){ // 최상위루트
                rootArray[rootCnt++] = i; // rootArray[0] = 최상위루트.
                break;
            }
        }
        // 처음에 트리갯수: 1 
        my_recur(k, 1, 0, num, links);
        return answer;
    }
	
	// groupCnt: 현재 몇개의 서브트리가 있는지
	// nodeIdx : 서브트리의 루트로 선택할 노드 index
	public void my_recur(int k, int groupCnt, int nodeIdx, int[] num, int[][] links){
        if(k == groupCnt){
            int localMaximum = 0;
            for(int i = 0; i < rootCnt; i++){
                int sum = 0;
                my_stack[++my_top] = rootArray[i];
                while(my_top >= 0){
                    int idx = my_stack[my_top--];
                    sum += num[idx];
                    for(int j = 0; j < 2; j++) {
                        if(links[idx][j] != -1){
                            my_stack[++my_top] = links[idx][j];
                        }
                    }
                }
                if(localMaximum < sum){ // 각각의 서브트리의 합 최대값 갱신
                    localMaximum = sum;
                }
            }// end for
            if(localMaximum < answer){ // localMaximum 중에 최소값
                answer = localMaximum;
            }
        }// end if
        
        for(int i = nodeIdx; i < N; i++){ // i가 현재노드. 
            for(int j = 0; j < 2; j++){
                if(links[i][j] != -1){ // i의 자식이있으면.
                    int tmp = links[i][j];
                    links[i][j] = -1; // 간선끊고 자식없다고 표시. 
                    rootArray[rootCnt++] = tmp;
                    my_recur(k, groupCnt + 1, i, num, links);
                    --rootCnt;
                    links[i][j] = tmp; // 복구. 
                }
            }
        }
    }


}
