package com.algo.kakao.internship;

import java.util.ArrayList;
import java.util.HashSet;

public class 불량사용자_2019_겨울인턴쉽 {

	public static void main(String[] args) {
		불량사용자_2019_겨울인턴쉽 t = new 불량사용자_2019_겨울인턴쉽();
//		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
//		String[] banned_id = {"fr*d*", "abc1**"};
		String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
		String[] banned_id = { "fr*d*", "*rodo", "******", "******" };
		int result = t.solution(user_id, banned_id);
		System.out.println(result);
	}
	// 몇가지의 경우의 수가 가능한지 return
	// user_id 배열크기 1~8
	// user_id 각 원소들의 값은 길이가 1~8, 알파벳소문자, 숫자로만 이루어짐
	// 아이디들은 서로 중복 X
	// banned_id 배열크기는 1~user_id크기
	// 불량사용자 아이디는 *문자를 하나이상 포함하고 있다.

	public int solution(String[] user_id, String[] banned_id) {
		int answer = 0;
		int userlen = user_id.length; // 응모자 아이디 수
		int banlen = banned_id.length; // 제재 아이디 수 
		int[] parents = new int[banlen]; // 제재 아디디 패턴이 같은아이디끼리 표시하기 위한 배열
		int[] count = new int[banlen]; // 패턴이 같은게 몇개씩 있는지 카운팅하기 위한 배열
		
		for(int i=0; i<banlen; i++) { // parents 자기자신으로 초기화 
			parents[i]=i;
		}
		
		for (int i = 0; i < banlen - 1; i++) {
			String prev = banned_id[i];
			for (int j = i + 1; j < banlen; j++) {
				String next = banned_id[j];
				if (prev.length() != next.length()) {
					continue;
				} else {// 길이 같으면
					boolean flag = true;
					for (int p = 0; p < prev.length(); p++) {
						if (prev.charAt(p) == '*' || next.charAt(p) == '*') {
							continue;
						}else if (prev.charAt(p) != next.charAt(p)) {
							flag = false;
							break;
						}
					} // end for
					if (flag) {
						parents[j] = parents[i];
					}
				}
			}
		}// end for
		
		ArrayList<String>[] list = new ArrayList[banlen];
		for (int i = 0; i < banlen; i++) {
			String ban_id = banned_id[i]; // 제재 아이디에서 하나 꺼내서 
			ArrayList<String> tmp = new ArrayList<>();
			for (int j = 0; j < userlen; j++) { // 모든 응모자들을 하나씩 비교 
				String user = user_id[j];
				if (ban_id.length() != user.length()) {
					continue;
				} else {// 길이가 같을때
					boolean flag = true;
					for (int k = 0; k < ban_id.length(); k++) {
						if (ban_id.charAt(k) == '*' || user.charAt(k) == '*') {
							continue;
						} else if (ban_id.charAt(k) != user.charAt(k)) {
							flag = false;
							break;
						}
					} // end for
					if (flag) {
						tmp.add(user);
					}
				}
			} // end for
			list[i] = tmp; // 제재 아이디에 대해 해당하는 유저를 넣은 tmp를 list[i]에 넣기.
		} // end for

		
		HashSet<String>[] setlist = new HashSet[banlen]; // 중복제거를 위한 set 
		for(int i=0; i<banlen; i++) { //초기화
			setlist[i] = new HashSet<>();
		}
		for(int i=0; i<banlen; i++) {
			int idx = parents[i];
			count[idx]++;
			for(int j=0; j<list[i].size(); j++) {
				setlist[idx].add(list[i].get(j));
			}
		}
		
		int result[][] = new int[banlen][2];
		for(int i=0; i<banlen; i++) {
			if(setlist[i].size()!=0) {
				result[i][0] = setlist[i].size();
				result[i][1] = count[i];
			}
		}
		int a=1;
		for(int i=0; i<banlen; i++) {
			if(result[i][0]!=0) {
				int N = result[i][0];
				int R = result[i][1];
				int ans = combi(N,R);
				a*= ans;
			}
		}
		answer = a;
		return answer;
	}// end solution
	
	int combi(int N, int R) {
		int numer = 1;
		int de = 1;
		int de2 = 1;
		for(int i=N; i>0; i--) {
			numer*=i;
		}
		for(int i=N-R; i>=1; i--) {
			de*=i;
		}
		for(int i=R; i>= 1; i--) {
			de2*=i;
		}
		return (numer/(de*de2));
	}

}
