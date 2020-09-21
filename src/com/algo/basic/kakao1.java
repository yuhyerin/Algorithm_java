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
        
        //1. �ҹ��ڷ� �ٲٱ�
        answer = new_id.toLowerCase();
        System.out.println("1�ܰ�: �ҹ��ڷ� �ٲٱ�    "+answer);
        //2. �ҹ���, ����, -, _, . ���� ������ �� �����
        answer = answer.replaceAll("[^a-z0-9-_.]", "");
        System.out.println("2�ܰ�: �ҹ���,����,-,_,.���� �����   "+answer);
        
        //3. .. �� . ���� �ٲٱ�  while replaceAll ..�� ã�Ƽ� .���� �ٲٱ� 
        while(answer.contains("..")) {
        	answer = answer.replace("..", ".");
        }
        System.out.println("3�ܰ�: ..�� .���� �ٲٱ�   "+answer);
        
        //4. �Ǿ�, �ǳ��� . ����
        if(answer.charAt(0)=='.') {
        	answer = answer.substring(1, answer.length());
        }
        if(answer.equals("")) {
        	answer = "a";
        }
        if(answer.charAt(answer.length()-1)=='.') {
        	answer = answer.substring(0, answer.length()-1);
        }
        System.out.println("4�ܰ�: �Ǿ�, �ǳ��� .�� ����   "+answer);
        
        //5. ���ڿ��� a �ֱ�
        if(answer.equals("")) {
        	answer = "a";
        }
        System.out.println("5�ܰ�: ���ڿ��̸� a �ֱ�   "+answer);
        
        //6. 16�ڸ� �̻��϶�, �տ� 15�ڸ��� ��������. (15�ڸ��� ©���µ� �ǳ� . ���� )
        if(answer.length() >= 16) {
        	answer = answer.substring(0,15);
        }
        if(answer.charAt(answer.length()-1)=='.') {
        	answer = answer.substring(0, answer.length()-1);
        }
        System.out.println("6�ܰ�: 16�ڸ� �̻��̸� 15�ڸ����� ����   "+answer);
        
        //7. �ּұ���3���߱�. 
        if(answer.length() <=2) {
        	char fill = answer.charAt(answer.length()-1);
        	while(answer.length()<3) {
        		answer+= fill;
        	}
        }
        System.out.println("7�ܰ�: ���̰� 2���ϸ�, 3���� ���߱�   "+answer);
        
        return answer;
    }
}
