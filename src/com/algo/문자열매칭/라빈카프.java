package com.algo.문자열매칭;

import java.util.ArrayList;
import java.util.List;

public class 라빈카프 {
	public static void main(String[] args) {
		String string = "abaaccdaabacaba";
		String pattern = "accdaa";
		List<Integer> list = new 라빈카프().solve(string, pattern);
		for(Integer value:list) {
			System.out.println(value+" 번째에서 발견!");
		}
	}
	
	List<Integer> solve(String string, String pattern) {
		
		int strLen = string.length();
		int patternLen = pattern.length();
		
		double stringHash = 0;
		double patternHash = 0;
		double power = 1;
		
		// 패턴이 일치하는 index를 저장할 리스트.
		List<Integer> findedList = new ArrayList<Integer>();
		
		// 전체 문자열에 첫 파트의 hash코드 구하기 
		// 패턴의 hash코드 구하기 
		for(int j=0; j<patternLen; j++) {
			stringHash = stringHash + string.charAt(patternLen-1-j)*power;
			patternHash = patternHash + pattern.charAt(patternLen-1-j)*power;
			
			if(j<patternLen-1) {
				power = power*2;
			}
		}
		for(int i=1; i< strLen - patternLen ; i++) {
			
			// 전체문자열에서 hash = 2*(첫 파트 해시값 - 가장 앞에있는 문자) + 새롭게 들어온 문자
			stringHash = 2*(stringHash - (string.charAt(i-1)*power)) + string.charAt(patternLen-1+i);
			
			if(stringHash == patternHash) {
				// hash가 같아도 문자열이 다를 수 있기 때문(충돌)에 정말로 일치하는지 한번 확인.
				boolean finded = true;
				for(int j=0; j<patternLen; j++) {
					if(string.charAt(i+j)!= pattern.charAt(j)) {
						finded=false;
						break;
					}
				}
				if(finded) {
					findedList.add(i);
				}
			}
		}// end for
		return findedList;
	}
	
}
