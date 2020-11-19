package com.algo.kakao;

import java.util.ArrayList;
import java.util.HashSet;

public class �ҷ������_2019_�ܿ����Ͻ� {

	public static void main(String[] args) {
		�ҷ������_2019_�ܿ����Ͻ� t = new �ҷ������_2019_�ܿ����Ͻ�();
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

	public int solution(String[] user_id, String[] banned_id) {
		int answer = 0;
		int userlen = user_id.length; // ������ ���̵� ��
		int banlen = banned_id.length; // ���� ���̵� �� 
		int[] parents = new int[banlen]; // ���� �Ƶ�� ������ �������̵𳢸� ǥ���ϱ� ���� �迭
		int[] count = new int[banlen]; // ������ ������ ��� �ִ��� ī�����ϱ� ���� �迭
		
		for(int i=0; i<banlen; i++) { // parents �ڱ��ڽ����� �ʱ�ȭ 
			parents[i]=i;
		}
		
		for (int i = 0; i < banlen - 1; i++) {
			String prev = banned_id[i];
			for (int j = i + 1; j < banlen; j++) {
				String next = banned_id[j];
				if (prev.length() != next.length()) {
					continue;
				} else {// ���� ������
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
			String ban_id = banned_id[i]; // ���� ���̵𿡼� �ϳ� ������ 
			ArrayList<String> tmp = new ArrayList<>();
			for (int j = 0; j < userlen; j++) { // ��� �����ڵ��� �ϳ��� �� 
				String user = user_id[j];
				if (ban_id.length() != user.length()) {
					continue;
				} else {// ���̰� ������
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
			list[i] = tmp; // ���� ���̵� ���� �ش��ϴ� ������ ���� tmp�� list[i]�� �ֱ�.
		} // end for

		
		HashSet<String>[] setlist = new HashSet[banlen]; // �ߺ����Ÿ� ���� set 
		for(int i=0; i<banlen; i++) { //�ʱ�ȭ
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
