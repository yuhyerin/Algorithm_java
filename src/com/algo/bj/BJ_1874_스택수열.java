package com.algo.bj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BJ_1874_스택수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 1~100,000
		Queue<Integer> originalQueue = new LinkedList<>();
		Stack<Integer> numStack = new Stack<>();
		Queue<String> pushpopQueue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			originalQueue.add(sc.nextInt());
		} // end input

		for (int i = 1; i <= n; i++) { // 1부터 순차적으로 담을지 안담을지 결정.
			if (i < originalQueue.peek()) { // 하나 훔쳐봣는데 지금 넣을지말지 결정할 숫자보다 크다면
				numStack.add(i); // 지금숫자 넣기
				pushpopQueue.add("+");
			} else { // 하나훔쳐봤는데 지금 넣을지말지 결정할 숫자랑 같다면
				originalQueue.poll(); // 같은애는 꺼내주고
				pushpopQueue.add("+");
				pushpopQueue.add("-");
				while (true) { // 그 다음애를 비교
					if (originalQueue.isEmpty() && numStack.isEmpty()) { // 둘다 비어있으면 끝. 성공.
						while (!pushpopQueue.isEmpty()) {
							System.out.println(pushpopQueue.poll());
						}
						return;
					}

					if (!originalQueue.isEmpty() && numStack.isEmpty()) { // 비교할 애가 없으면 넘어가.
						break;
					}

					if (originalQueue.peek() == numStack.peek()) { // 비교했는데 꺼낼애면
						originalQueue.poll(); // 꺼내주기
						numStack.pop();
						pushpopQueue.add("-");
					} else { // 빼낼애 아니면 다음순서 진행
						break;
					}
				} // end while
			}
		} // end for
		System.out.println("NO");
	}

}
