package com.algo.kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class �ҷ������_2019_�ܿ����Ͻ�2 {

	public static void main(String[] args) {
		�ҷ������_2019_�ܿ����Ͻ�2 t = new �ҷ������_2019_�ܿ����Ͻ�2();
//		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
//		String[] banned_id = {"fr*d*", "abc1**"};
		String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
		String[] banned_id = { "fr*d*", "*rodo", "******", "******" };
		int result = t.solution(user_id, banned_id);
		System.out.println(result);
	}
	// ����� ����� ���� �������� return
	// user_id �迭ũ�� 1~8
	// user_id �� ���ҵ��� ���� ���̰� 1~8, ���ĺ��ҹ���, ���ڷθ� �̷����
	// ���̵���� ���� �ߺ� X
	// banned_id �迭ũ��� 1~user_idũ��
	// �ҷ������ ���̵�� *���ڸ� �ϳ��̻� �����ϰ� �ִ�.
	
	static int N;
	static int R;
	static boolean[] checked;
	static HashSet<LinkedList<String>> hashSet;
	
	public int solution(String[] user_id, String[] banned_id) {
		int answer = 0;
		N = user_id.length; // ������ ���̵� �� 
		hashSet = new HashSet<>();
		checked = new boolean[N];
		R = banned_id.length; // ���� ���̵� �� 
		LinkedList<String> path = new LinkedList<>();
		doProcess(user_id, banned_id, R, path);
		answer = hashSet.size();
		return answer;
	}// end solution
	
	
	private void doProcess(String[] user_id, String[] banned_id, int r, LinkedList<String> path) {
		
		if(r==0) { // ������̵� ������ŭ ������̵� ����������, 
			 // ���� ������̵� ������̵�� ������ ���Ѵ�.
			if(isCorrect(user_id, banned_id, path)) {
				LinkedList<String> tmp = new LinkedList<>();
				for(int i=0; i<path.size(); i++) {
					tmp.add(path.get(i));
				}
				Collections.sort(tmp); // �ߺ����Ÿ� ���� �����ϰ� �־��ش�.
				hashSet.add(tmp);
			}
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!checked[i]) { // i��° ������̵� �湮���� �ʾ����� 
				checked[i] = true; // �湮üũ
				path.add(user_id[i]); // LinkedList�� �ֱ�.
				doProcess(user_id, banned_id, r-1, path);
				path.removeLast(); // ��� ������ ����. 
				checked[i]= false;
			}
		}
	}


	private boolean isCorrect(String[] user_id, String[] banned_id, LinkedList<String> path) {
		
		for(int i=0; i<R; i++) {
			String userId = path.get(i);
			String bannedId = banned_id[i];
			
			// ���ڼ��� �ٸ��� false
			if(userId.length() != bannedId.length()) {
				return false;
			}else { // ���ڼ� ������ �� ���� 
				for(int s=0; s< userId.length(); s++) { // �ѱ��ھ� ���ϸ鼭 *������ ��� ���� 
					String word_user = userId.substring(s,s+1);
					String word_banned = bannedId.substring(s, s+1);
					
					// ������ڰ� *�̶�� continue
					if(word_banned.equals("*")) continue;
					
					// ���� ���ڰ� �ٸ��� false
					if(!word_user.equals(word_banned)) {
						return false;
					}
					
				}
			}
			
		}
		return true;
	}
	
	

}
