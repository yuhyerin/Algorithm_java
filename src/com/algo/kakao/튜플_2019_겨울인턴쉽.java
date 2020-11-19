package com.algo.kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;

public class Ʃ��_2019_�ܿ����Ͻ� {

	public static void main(String[] args) {
		Ʃ��_2019_�ܿ����Ͻ� t = new Ʃ��_2019_�ܿ����Ͻ�();
		String s = "{{20,111},{111},{30,111,20}}";
		int[] result = t.solution(s);
		for(int r : result) {
			System.out.print(r+" ");
		}
//		System.out.println();
	}

	// Ʃ���� �ߺ��� ���Ұ� ���� �� �ִ�.
	// ������ �ٸ��� ���� �ٸ� Ʃ���̴�.
	// Ʃ���� ���Ұ����� �����ϴ�.
	// s�� ���� 5 ~ 1,000,000
	// s�� ���� { } , �θ� �̷���� �ִ�.
	// ���ڰ� 0���� �����ϴ� ���� ����.
	// s�� ǥ���ϴ� Ʃ���� ���Ҵ� 1~ 100,000�� �ڿ���
	// return �ϴ� �迭���̰� 1~ 500 �� ��츸 �־���.
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
			} else {// �����϶�
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
