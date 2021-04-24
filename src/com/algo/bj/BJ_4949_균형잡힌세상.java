package com.algo.bj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class BJ_4949_균형잡힌세상 {
	public static void main(String[] args) {
		// 어떤 문자열 -> 괄호들의 균형이 잘 맞는지 판단 
		// ( ) [ ] 2종류 
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<>();
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		
		while(true) {
			String sentence = sc.nextLine();
			if(sentence.equals(".")) {
				break;
			}
			int N = sentence.length(); // 한 문장을 읽어온다.
			for(int i=0; i<N; i++) { // 문자열 길이만큼 반복 
				char s = sentence.charAt(i);
				if(s=='('||s=='[') { // 열린 괄호를 만나면 스택에 넣기 
					stack.add(s);
				}else if(s==')'||s==']') { // 닫힌 괄호를 만나면 
					if(!stack.isEmpty() && map.get(stack.peek())==s) { // 스택 제일위에껄 확인해서 짝이맞는 열린괄호가 있으면 
						stack.pop(); // 꺼내기 
					}else { // 스택이 비어있거나 짝이맞는 열린괄호가 없으면 
						stack.clear(); // 스택을 비우고 
						System.out.println("no"); // no 출력 
						break; // for문 빠져나가기 
					}
				}else if(s=='.') { // .을 만나서 종료 
					if(stack.isEmpty()) { // 스택이 비어있으면? 
						System.out.println("yes"); // 성공 
					}else {
						System.out.println("no"); // 안비어있으면 실패 
					}
					stack.clear(); // 스택비우고 
					break; // for문 빠져나가서 다음문장 준비 
				}
			}
		}
		
	}
}
