package com.algo.kakao.internship;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;

public class 튜플_2019_겨울인턴쉽 {

	public static void main(String[] args) {
		튜플_2019_겨울인턴쉽 t = new 튜플_2019_겨울인턴쉽();
		String s = "{{20,111},{111},{30,111,20}}";
		int[] result = t.solution(s);
		for(int r : result) {
			System.out.print(r+" ");
		}
//		System.out.println();
	}

	// 튜플은 중복된 원소가 있을 수 있다.
	// 순서가 다르면 서로 다른 튜플이다.
	// 튜플의 원소갯수는 유한하다.
	// s의 길이 5 ~ 1,000,000
	// s는 숫자 { } , 로만 이루어져 있다.
	// 숫자가 0으로 시작하는 경우는 없다.
	// s가 표현하는 튜플의 원소는 1~ 100,000의 자연수
	// return 하는 배열길이가 1~ 500 인 경우만 주어짐.
	public int[] solution(String s) {
		int[] answer = {};
		s = s.substring(1, s.length() - 1);
		int cur = 0;
		int len = s.length();
		String word = "";
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> tmp = new ArrayList<>();
		while (cur < len) {
			char curword = s.charAt(cur);
			if (curword == '{') {
				tmp = new ArrayList<>();
				cur++;
				continue;
			} else if (curword == ',') {
				tmp.add(Integer.parseInt(word));
				word = "";
			} else if (curword == '}' && cur != len - 1) {
				list.add(tmp);
			} else if (curword == '}' && cur == len - 1) {
				tmp.add(Integer.parseInt(word));
				list.add(tmp);
			} else {// 숫자일때
				word += curword;
			}
			cur++;
		}//
		LinkedHashSet<Integer> set = new LinkedHashSet<>();
		Collections.sort(list, new hyerinsort());
		for(int i=0; i<list.size();i++) {
			for(int j=0; j<list.get(i).size(); j++) {
				set.add(list.get(i).get(j));
			}
		}
		answer = new int[set.size()];
		int idx=0;
		for(int ss : set) {
			answer[idx]=ss;
			idx++;
		}
		return answer;
	}//end solution
	
	class hyerinsort implements Comparator<ArrayList<Integer>>{
		
		@Override
		public int compare(ArrayList<Integer> A, ArrayList<Integer>B) {
			Integer b = B.size();
			Integer a = A.size();
			return a.compareTo(b);
		}
	}
}
