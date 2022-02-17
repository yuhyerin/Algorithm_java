//package com.coding.test.midas;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.PriorityQueue;
//
//public class test3 {
//	public static void main(String[] args) {
//		test3 t = new test3();
////		int N = 4; //4명 
////		int K = 4; //1~4일 
////		int[][] T = {{1,3},{1,1},{2,3},{3,4}}; // {a,b} 학생이 a~b일중 아무날이나 상담가능하다는뜻.
//		
//		int N = 6;
//		int K = 4;
//		int[][] T = {{1,3},{3,4},{2,4},{2,4},{2,3},{1,2}};
//		int result = t.solution(N,K,T);
//		System.out.println(result);
//	}
//
//	// N명의 학생이 상담받으려고 함.
//	// 상담사의 상담 가능일짜는 1일~K일 
//	// 하루에 1명만 가능.
//	// 한번 상담한 학생은 다시 상담 불가.
//	// 최대한 많은학생을 상담할수 있도록 일정을 짠다.
//	// 가장많은 상담가능 학생수를 리턴. 
//	
//	// N,K: 1000이하 
//	
//	class Student{
//		int startDay;
//		int endDay;
//		int no;
//
//		public Student(int startDay, int endDay, int no) {
//			super();
//			this.startDay = startDay;
//			this.endDay = endDay;
//			this.no = no;
//		}
//		public int getStartDay() {
//			return startDay;
//		}
//		public void setStartDay(int startDay) {
//			this.startDay = startDay;
//		}
//		public int getEndDay() {
//			return endDay;
//		}
//		public void setEndDay(int endDay) {
//			this.endDay = endDay;
//		}
//		public int getNo() {
//			return no;
//		}
//		public void setNo(int no) {
//			this.no = no;
//		} 
//		@Override
//		public String toString() {
//			return "Student [startDay=" + startDay + ", endDay=" + endDay + ", no="+ no + "]";
//		}
//		
//	}
//	
//	private static int max = 0;
//	private static ArrayList<Integer>[] schedule;
//	private static boolean[] check;
//	
//	public int solution(int N, int K, int [][]T) {
//		schedule = new ArrayList[N+1];
//		for(int i=0; i<=N; i++) { // 초기화 
//			schedule[i] = new ArrayList<Integer>();
//		}
//        check = new boolean[K+1];
//        
//        PriorityQueue<Student> que = new PriorityQueue<>(N, new Comparator<Student>() {
//            @Override
//            public int compare(Student p1, Student p2) {
//            	return p1.startDay>=p2.startDay?1:-1;
//            }
//        });
//        
//        for(int i=0; i<N; i++) {
//        	que.add(new Student(T[i][0],T[i][1],i));
//        }
//        
//        while(!que.isEmpty()) {
//        	Student cur = que.poll();
//        	schedule[cur.getStartDay()].add(cur.endDay);
//        }
//        
//        
//       
//        
//        
//        return max;
//    }
//	
//	public void go(int N, int K, boolean[][] schedule, int cur) {
//		
//		boolean isFull = true;
//		for(int i=1; i<=K; i++) {
//			if(!check[i]) { // check[i] true가 이미 예약된거. 
//				isFull = false;
//				break;
//			}
//		}
//		
//		
//		if(cur >= N || isFull) { // 
//			int cnt=0;
//			for(int i=1; i<=K; i++) {
//				if(check[i]) {
//					cnt++;
//				}
//			}
//			if(max < cnt) {
//				max = cnt;
//			}
//			return;
//		}
//		
//		for(int i=1; i<=K; i++) {
//			if(schedule[cur][i]) { // 예약 가능날짜.
//				if(check[i]) continue; // 이미 예약 했으면 넘어가.
//				check[i]=true;
//				go(N, K, schedule,cur+1);
//				check[i]=false;
//			}
//		}
//		
//		
//	}
//}
