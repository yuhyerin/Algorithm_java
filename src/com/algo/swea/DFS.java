package com.algo.swea;

public class DFS {
	
	/** DFS
	 * - Recursion ( 자신이 자신 부르는거 ! )
	 * 가장 흔한 예 : f(5) 팩토리얼5
	 * while
	 * DFS는 overflow 조심하기! recursion 끝나는 조건을 꼭 명시하기!
	 * DFS는 끝까지 간다는게 중요하다! 
	 * f(5) = 5xf(4)
	 * 			4x f(3)
	 * 				3xf(2)
	 * 					2xf(1)
	 * 						1
	 * Recursion을 이해하면, 백트래킹도 자연스럽게 이해된다... 
	 * 일단 끝까지 갔다가(멀~리까지 깊게 간다 DFS), 바로 전으로 돌아와서 다른 가지로 간다.
	 * 백트래킹 : 표시해주면, 끝에서 바로 전으로 돌아와서 다른가지로 수행한다.
	 * 가기전에 true해두고, recursion하고, 갔다와서 false 하기
	 * 하지만, call stack... 은 잘 터진다.*/
	public static void main(String[] args) {
		
	}
}
