package com.cs.arraylinkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListCollection {
	/** ArrayList와 LinkedList가 내부적으로 어떻게 동작하는지 보기 
	 * 
	 * ArrayList는 사이즈가 동적인 배열. add 하면 임시배열을 생성해 데이터를 복사하는 방법으로 동작.
	 * LinkedList는 이전노드, 다음노드의 상태만 알고 있음. 그래서 추가,삭제시에는 유리하지만 검색시에는 처음부터
	 * 노드를 순회해야 하기때문에 성능상 불리함. */
	public static void main(String[] args) {
		
//		ArrayList<String> list = new ArrayList<>();
		LinkedList<String> list = new LinkedList<>();
		
		list.add("Yoo");
		list.add("Hye");
		list.add("Rin");
		
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i));
		}
		System.out.println();
		
		list.remove(0); //첫번째 인스턴스 삭제
		System.out.println("===== 삭제 후 =====");
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i));
		}
		System.out.println();
	}

}
