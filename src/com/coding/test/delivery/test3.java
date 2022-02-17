package com.coding.test.delivery;

public class test3 {
	
	public static void main(String[] args) {
		test3 t = new test3();
		String S = "ababaaaa";
		int result = t.solution(S);
		System.out.println(result);
		
	}

	// S 는 a, b로 구성된 문자열. 
	// 비어있지 않은 3 등분으로 분리하려고 한다.
	// 각 그룹에 a의 갯수가 똑같아야 함.
	// babaa -> ba|ba|a / bab|a|a|  2가지 가능 => 2
	// ababa -> a|ba|ba / a|bab|a / ab|a|ba / ab|ab|a => 4 
	// aba ->  못나눔. => 0 
	// bbbbb -> b|b|bbb / b|bb|bb / b|bbb|b / bb|b|bb / bb|bb|b / bbb|b|b -> 6 
	public int solution(String S) {
		int n = (int)S.chars().filter(c -> c == 'a').count();
		// a가 하나도 없을 경우 
		if(n==0) {
			return -1;
		}
        if(n % 3 != 0) {
        	return 0;
        }
        int group = n/3;
        int startIdx = 0;
        int endIdx = S.length()-1;
        int cnt= 0;
        for(int i=0; i<S.length(); i++) {
        	if(S.charAt(i)=='a') {
        		cnt++;
        	}
        	if(cnt==group) {
        		cnt=0;
        		startIdx = i;
        		break;
        	}
        }
        
        for(int i=S.length()-1; i>=0; i--) {
        	if(S.charAt(i)=='a') {
        		cnt++;
        	}
        	if(cnt==group) {
        		cnt=0;
        		endIdx = i;
        		break;
        	}
        }
        System.out.println("startIdx "+startIdx+", endIdx "+ endIdx);
        
            
		return 0;
	}
}
