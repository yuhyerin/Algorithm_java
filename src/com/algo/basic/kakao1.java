package com.algo.basic;


public class kakao1 {
	public static void main(String[] args) {
		kakao1 a = new kakao1();
		String new_id= 	"=.=";
		String result = a.solution(new_id);
		System.out.println(result);
	}
	
	public String solution(String new_id) {
        String answer = "";
        
        //1. 소문자로 바꾸기
        answer = new_id.toLowerCase();
        System.out.println("1단계: 소문자로 바꾸기    "+answer);
        //2. 소문자, 숫자, -, _, . 뺴고 나머지 다 지우기
        answer = answer.replaceAll("[^a-z0-9-_.]", "");
        System.out.println("2단계: 소문자,숫자,-,_,.빼고 지우기   "+answer);
        
        //3. .. 을 . 으로 바꾸기  while replaceAll ..을 찾아서 .으로 바꾸기 
        while(answer.contains("..")) {
        	answer = answer.replace("..", ".");
        }
        System.out.println("3단계: ..을 .으로 바꾸기   "+answer);
        
        //4. 맨앞, 맨끝의 . 제거
        if(answer.charAt(0)=='.') {
        	answer = answer.substring(1, answer.length());
        }
        if(answer.equals("")) {
        	answer = "a";
        }
        if(answer.charAt(answer.length()-1)=='.') {
        	answer = answer.substring(0, answer.length()-1);
        }
        System.out.println("4단계: 맨앞, 맨끝의 .을 제거   "+answer);
        
        //5. 빈문자열에 a 넣기
        if(answer.equals("")) {
        	answer = "a";
        }
        System.out.println("5단계: 빈문자열이면 a 넣기   "+answer);
        
        //6. 16자리 이상일때, 앞에 15자리만 가져오기. (15자리로 짤랐는데 맨끝 . 제거 )
        if(answer.length() >= 16) {
        	answer = answer.substring(0,15);
        }
        if(answer.charAt(answer.length()-1)=='.') {
        	answer = answer.substring(0, answer.length()-1);
        }
        System.out.println("6단계: 16자리 이상이면 15자리까지 끊기   "+answer);
        
        //7. 최소길이3맞추기. 
        if(answer.length() <=2) {
        	char fill = answer.charAt(answer.length()-1);
        	while(answer.length()<3) {
        		answer+= fill;
        	}
        }
        System.out.println("7단계: 길이가 2이하면, 3으로 맞추기   "+answer);
        
        return answer;
    }
}
