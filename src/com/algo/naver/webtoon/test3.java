package com.algo.naver.webtoon;

public class test3 {
	
	public static void main(String[] args) {
		test3 tt = new test3();
		String s = "aabcbcd";
		String t = "abc";
		int result = tt.solution(s, t);
		System.out.println(result);
	}
	// 찾아바꾸기. 
	// 문자열 발견 => 제거 (한번에 한개의 문자열만 제거가능.) 
	// 검색하고자하는 문장 s에서 문자열 t를 찾아 제거할 때, 총 몇번의 찾아바꾸기를 진행해야
	// s에서 t가 존재하지 않는지 계산하기. 
	// s길이 1~ 1,000,000 
	// t길이 1~ 10 (t의 문자들은 중복되지 않음.) 
	public int solution(String s, String t) {
        int count = 0;
        String original = s;
        if(t.length()==1) {
        	for(int i=0; i<s.length(); i++) {
        		if(s.charAt(i)==t.charAt(0)) {
        			count++;
        		}
        	}
        	return count;
        }
        
        while(s.contains(t)) {
        	System.out.println(t+" 가 "+s+" 에 포함되어있음!");
        	char firstChar = t.charAt(0);
        	System.out.println(t+" 의 첫번째 문자=>"+firstChar);
        	int startIdx = s.indexOf(firstChar);
        	System.out.println(s+" 에서 찾은 첫번째 문자의 위치는=>"+startIdx);
        	
        	while(startIdx != -1) { // s에서 t의 시작문자와 일치하는 지점을 발견하면, 
        		boolean flag = true;
        		System.out.println("비교시작!");
        		for(int i=0; i<t.length(); i++) {
        			System.out.println(t.charAt(i)+" 와 "+s.charAt(startIdx+i)+" 를 비교!");
        			if(t.charAt(i)==s.charAt(startIdx+i)) {
        				System.out.println("같음!");
        				continue;
        			}else {
        				System.out.println("다름!");
        				flag =false;
        				break;
        			}
        		}// end for
        		
        		if(flag) {
        			System.out.println("***성공적으로 찾음!!! 문자열 치환!!!***");
        			original = original.replaceFirst(t, "");
        			s = s.replaceFirst(t, "");
        			System.out.println(original);
        			count++;
        		}else {
        			s = s.substring(startIdx+1, s.length());
        			System.out.println(s);
        		}
        		break;
        	}
        	
        }
        return count;
    }
}
