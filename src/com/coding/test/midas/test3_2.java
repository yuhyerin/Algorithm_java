package com.coding.test.midas;

import java.util.PriorityQueue;

public class test3_2 {
	public static void main(String[] args) {
		test3_2 t = new test3_2();
//		int N = 4; //4명 
//		int K = 4; //1~4일 
//		int[][] T = {{1,3},{1,1},{2,3},{3,4}}; // {a,b} 학생이 a~b일중 아무날이나 상담가능하다는뜻.
		
		int N = 6;
		int K = 4;
		int[][] T = {{1,3},{3,4},{2,4},{2,4},{2,3},{1,2}};
		int result = t.solution(N,K,T);
		System.out.println(result);
	}
	
	class Schedule implements Comparable<Schedule>{
        int startDate;
        int endDate;
        public Schedule(int start, int end){
            this.startDate = start;
            this.endDate = end;
        }
        boolean isExpired(int curDate){
            return endDate < curDate;
        }
        boolean isExecutable(int curDate){
            return startDate <= curDate && curDate <= endDate;
        }
        @Override
        public int compareTo(Schedule target) {
            if(this.endDate > target.endDate)
                return 1;
            else if(this.endDate == target.endDate)
                if (this.startDate >= target.startDate)
                    return 1;
                else
                    return -1;
            else
                return -1;
        }
        @Override
        public String toString() {
            return "[" + startDate + ", " + endDate + "]";
        }
    }
    public int solution(int N, int K, int[][] T){
        int answer = 0;
        PriorityQueue<Schedule> priorityQueue = new PriorityQueue<>();
        for(int[] student : T){
            priorityQueue.offer(new Schedule(student[0] - 1, student[1] - 1));
        }
        
        for(int day = 0; day < K; day++){
        	System.out.println("day: "+day);
            
        	while (!priorityQueue.isEmpty() && priorityQueue.peek().isExpired(day)){ // Remove expired task
            	System.out.println("que에서 꺼냄!");
                priorityQueue.poll();
            }
        	
            if(priorityQueue.isEmpty())
                break;
            
            if(priorityQueue.peek().isExecutable(day)){
            	System.out.println();
            	System.out.println(priorityQueue.peek());
            	
                priorityQueue.poll();
                answer++;
            }
        }
        return answer;
    }
}
