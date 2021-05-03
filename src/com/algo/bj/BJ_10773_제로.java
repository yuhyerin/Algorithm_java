package com.algo.bj;

import java.util.Scanner;
import java.util.Stack;

public class BJ_10773_제로 {
	
	public static void main(String[] args) {
		
		// 잘못된 수를 부를때마다 0을 외쳐서 지우게 한다.
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt(); // 1~100,000
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<K; i++) {
			int num = sc.nextInt();
			if(num!=0) {
				stack.add(num);
			}else {
				stack.pop();
			}
		}
		
		int sum = 0;
		for(int i=0; i<stack.size();i++) {
			sum+=stack.get(i);
		}
		
		System.out.println(sum);
		
	}
	
	

}
