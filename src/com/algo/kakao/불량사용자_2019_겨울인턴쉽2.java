package com.algo.kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class 불량사용자_2019_겨울인턴쉽2 {

	public static void main(String[] args) {
		불량사용자_2019_겨울인턴쉽2 t = new 불량사용자_2019_겨울인턴쉽2();
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
	
	static int N;
	static int R;
	static boolean[] checked;
	static HashSet<LinkedList<String>> hashSet;
	
	public int solution(String[] user_id, String[] banned_id) {
		int answer = 0;
		N = user_id.length; // 응모자 아이디 수 
		hashSet = new HashSet<>();
		checked = new boolean[N];
		R = banned_id.length; // 제재 아이디 수 
		LinkedList<String> path = new LinkedList<>();
		doProcess(user_id, banned_id, R, path);
		answer = hashSet.size();
		return answer;
	}// end solution
	
	
	private void doProcess(String[] user_id, String[] banned_id, int r, LinkedList<String> path) {
		
		if(r==0) { // 제재아이디 갯수만큼 응모아이디를 선택했으면, 
			 // 뽑은 응모아이디가 제재아이디와 같은지 비교한다.
			if(isCorrect(user_id, banned_id, path)) {
				LinkedList<String> tmp = new LinkedList<>();
				for(int i=0; i<path.size(); i++) {
					tmp.add(path.get(i));
				}
				Collections.sort(tmp); // 중복제거를 위해 정렬하고 넣어준다.
				hashSet.add(tmp);
			}
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!checked[i]) { // i번째 응모아이디 방문하지 않았으면 
				checked[i] = true; // 방문체크
				path.add(user_id[i]); // LinkedList에 넣기.
				doProcess(user_id, banned_id, r-1, path);
				path.removeLast(); // 방금 넣은거 빼기. 
				checked[i]= false;
			}
		}
	}


	private boolean isCorrect(String[] user_id, String[] banned_id, LinkedList<String> path) {
		
		for(int i=0; i<R; i++) {
			String userId = path.get(i);
			String bannedId = banned_id[i];
			
			// 글자수가 다르면 false
			if(userId.length() != bannedId.length()) {
				return false;
			}else { // 글자수 같으면 비교 시작 
				for(int s=0; s< userId.length(); s++) { // 한글자씩 비교하면서 *만나면 계속 진행 
					String word_user = userId.substring(s,s+1);
					String word_banned = bannedId.substring(s, s+1);
					
					// 제재글자가 *이라면 continue
					if(word_banned.equals("*")) continue;
					
					// 서로 글자가 다르면 false
					if(!word_user.equals(word_banned)) {
						return false;
					}
					
				}
			}
			
		}
		return true;
	}
	
	

}
