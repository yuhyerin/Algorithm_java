package com.algo.naver.webtoon;

import java.util.ArrayList;

class test2 {
	// 짝수개의 조각으로 자르되. 좌우대칭되도록. 
	// 홀수개의 조각이여도 좌우대칭. 
    private static String headToTail;
    private static String tailToHead;

    public String[] solution(String s){
        headToTail = "";
        tailToHead = "";
        ArrayList<String> answerArrayList = new ArrayList<>();
        int len = s.length();
        for(int i = 0; i < len/2; i++){
            headToTail = headToTail + s.charAt(i);
            tailToHead = s.charAt(len-i-1) + tailToHead;
            if(headToTail.equals(tailToHead)){
                answerArrayList.add(headToTail);
                headToTail = "";
                tailToHead = "";
            }
        }
        int answerArrayListSize = answerArrayList.size();
        if(!headToTail.equals("")){
            if(len%2 != 0) { //홀수개인 경우에 처리. 
                headToTail = headToTail + s.charAt(len/2 + 1);
            }
            
            for(int i = 0; i < tailToHead.length(); i++){
                headToTail = headToTail + tailToHead.charAt(i);
            }
            answerArrayList.add(headToTail);
        }

        for(int i = 0; i < answerArrayListSize; i++){
            answerArrayList.add(answerArrayList.get(answerArrayListSize - 1 - i));
        }


        String[] answer = new String[answerArrayList.size()];

        for(int i = 0; i < answerArrayList.size(); i++){
            answer[i] = answerArrayList.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        test2 solution = new test2();

        String input1 = "abcxyasdfasdfxyabc";
        String input2 = "abcxyqwertyxyabc";
        String input3 = "abcabcabcabc";
        String input4 = "llttaattll";
        String input5 = "zzzzzz";
        String input6 = "abcdef";

        String[] answer = solution.solution(input2);
        for(int i = 0; i < answer.length; i++){
            System.out.println(answer[i]);
        }
    }
}