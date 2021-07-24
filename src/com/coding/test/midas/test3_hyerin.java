package com.coding.test.midas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class test3_hyerin {
	public static void main(String[] args) {
		test3_hyerin t = new test3_hyerin();
//		int N = 6;
//		int K = 4;
//		int[][] T = {{1,3},{3,4},{2,4},{2,4},{2,3},{1,2}};
		int N = 4; // 4명
		int K = 4; // 1~4일
		int[][] T = { { 1, 3 }, { 1, 1 }, { 2, 3 }, { 3, 4 } }; // {a,b} 학생이 a~b일중 아무날이나 상담가능하다는뜻.
		int result = t.solution(N, K, T);
		System.out.println(result);
	}

	private static PriorityQueue<Student>[] schedule;
	private static boolean[] check;

	public int solution(int N, int K, int[][] T) {

		check = new boolean[K+1];
		schedule = new PriorityQueue[K + 1];
		for (int i = 1; i <= K; i++) { // 초기화
			schedule[i] = new PriorityQueue<Student>(N, new Comparator<Student>() {
				@Override
				public int compare(Student o1, Student o2) {
					return o1.startDay > o2.startDay ? 1 : -1;
				}
			});
		}

		PriorityQueue<Student> que = new PriorityQueue<>(N, new Comparator<Student>() {
			@Override
			public int compare(Student p1, Student p2) {
				return p1.endDay >= p2.endDay ? 1 : -1;
			}
		});

		for (int i = 0; i < N; i++) {
			que.add(new Student(T[i][0], T[i][1], i));
		}

		while (!que.isEmpty()) {
			Student cur = que.poll();
			schedule[cur.getEndDay()].add(cur);
		}
		int answer = 0;
		for (int i = 1; i <= K; i++) {
			while (!schedule[i].isEmpty()) {
				Student cur = schedule[i].poll();
				for (int j = cur.getStartDay(); j <= i; j++) {
					if (!check[j]) {
						answer++;
						check[j] = true;
						break;
					}
				}
			}
		}
		return answer;
	}

	class Student {
		int startDay;
		int endDay;
		int no;

		public Student(int startDay, int endDay, int no) {
			super();
			this.startDay = startDay;
			this.endDay = endDay;
			this.no = no;
		}

		public Student(int startDay, int no) {
			super();
			this.startDay = startDay;
			this.no = no;
		}

		public int getStartDay() {
			return startDay;
		}

		public void setStartDay(int startDay) {
			this.startDay = startDay;
		}

		public int getEndDay() {
			return endDay;
		}

		public void setEndDay(int endDay) {
			this.endDay = endDay;
		}

		public int getNo() {
			return no;
		}

		public void setNo(int no) {
			this.no = no;
		}

		@Override
		public String toString() {
			return "Student [startDay=" + startDay + ", endDay=" + endDay + ", no=" + no + "]";
		}

	}

}
