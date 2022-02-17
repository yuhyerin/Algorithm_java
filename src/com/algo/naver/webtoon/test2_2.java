package com.algo.naver.webtoon;

import java.util.ArrayList;

class test2_2 {
    private static ArrayList<Character> headToTail;
    private static ArrayList<Character> tailToHead;

    private boolean checkValid(){
        int len = tailToHead.size();
        for(int i = 0; i < len; i++){
            if(headToTail.get(i) != tailToHead.get(len - 1 - i)){
                return false;
            }
        }
        return true;
    }

    public String[] solution(String s){
        headToTail = new ArrayList<>();
        tailToHead = new ArrayList<>();
        ArrayList<String> answerArrayList = new ArrayList<>();
        int len = s.length();
        for(int i = 0; i < len/2; i++){
            headToTail.add(s.charAt(i));
            tailToHead.add(s.charAt(len-i-1));
            if(checkValid()){
                StringBuilder sb = new StringBuilder();
                for (Character ch: headToTail) {
                    sb.append(ch);
                }
                answerArrayList.add(sb.toString());
                headToTail = new ArrayList<>();
                tailToHead = new ArrayList<>();
            }
        }
        int answerArrayListSize = answerArrayList.size();
        if(headToTail.size() != 0){
            if(len % 2 != 0) {
                headToTail.add(s.charAt(len/2 + 1));
            }
            int tailToHeadLen = tailToHead.size();
            for(int i = 0; i < tailToHeadLen; i++) {
                headToTail.add(tailToHead.get(tailToHeadLen - 1 - i));
            }
            StringBuilder sb = new StringBuilder();
            for (Character ch: headToTail) {
                sb.append(ch);
            }
            answerArrayList.add(sb.toString());
        }
        for(int i = 0; i < answerArrayListSize; i++){
            answerArrayList.add(answerArrayList.get(answerArrayListSize-1 -i));
        }

        String[] answer = new String[answerArrayList.size()];

        for(int i = 0; i < answerArrayList.size(); i++){
            answer[i] = answerArrayList.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        test2_2 solution = new test2_2();

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