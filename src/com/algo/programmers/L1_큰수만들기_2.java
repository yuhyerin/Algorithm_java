package com.algo.programmers;

import java.util.Stack;

public class L1_큰수만들기_2 {

	public static void main(String[] args) {
		String number = "123456789";
		int k = 5;
		String result = solution(number, k);
		System.out.println(result);
	}
	
	public static String solution(String number, int k) { //k는 제거할 갯수 
        
		 char[] result = new char[number.length() - k];
	        Stack<Character> stack = new Stack<>();

	        for (int i=0; i<number.length(); i++) {
	            char c = number.charAt(i);
	            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
	                stack.pop();
	            }
	            stack.push(c);
	        }
	        for (int i=0; i<result.length; i++) {
	            result[i] = stack.get(i);
	            System.out.println(result[i]);
	        }
	        return new String(result);

    }
	
}
