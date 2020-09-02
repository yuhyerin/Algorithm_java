package com.algo.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class L3_단어변환 {
	/** 2개의 단어 begin, target
	 * 단어집합 words
	 * 규칙을 이용하여 begin -> target으로 변환하는 가장 짧은 과정을 찾기 
	 * 규칙1. 한번에 한개의 알파벳만 바꿀 수 있다.
	 * 규칙2. words에 있는 단어로만 변환할 수 있다. 
	 * hit -> hot -> dot -> dog -> cog : 4단계 
	 * 
	 * 단어는 소문자만. (26개) 
	 * 단어의 길이는 3~10. 모든 단어의 길이는 같다!
	 * words에는 3개~50개. 중복X
	 * begin과 target은 같지 않음.
	 * 변환할 수 없다면 0 리턴. */
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog" ;
		String[] words = {"hot", "dog", "dog", "lot", "log", "cog" };
		int result = solution(begin, target, words);
		System.out.println(result);
	}
	
	public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        int min = Integer.MAX_VALUE;
        Queue<String> beginque = new LinkedList<>();
        beginque.add(begin);

        boolean flag = false;
        for(int i=0; i<words.length; i++) {
        	if(words[i].equals(target)) {
        		flag = true;
        		break;
        	}
        }
        if(!flag){
            min = 0;
        }
        outer:while(flag) {
        	
        	int size = beginque.size();
        	System.out.println("begin큐 size: "+size);
        	while(size-- > 0) {// 초기 beginque사이즈만큼만 반복. 
        		
        		Queue<String> wordque = new LinkedList<>();
        		String cur = beginque.poll(); // hit 
        		if(cur.equals(target)) { // 타겟을 발견했으면 종료.
        			System.out.println(target+"을 발견함");
        			if(min>answer) {
        				min = answer;
        			}
        			break outer;
        		}
        		wordque = makeAllword(cur, words); // hot
        		if(wordque.size()==0) { // 알파벳 하나만 바꾼단어가 words에 일치한는 애가 없으면 종료.
        			break outer;
        		}
        		while(!wordque.isEmpty()) {
        			beginque.add(wordque.poll()); // 찾아온 애들을 begin큐에 넣기.
        		}
        	}// end while(beginque size)
        	
        	answer++;
        	
        }
        return min;
    }
	
	public static Queue<String> makeAllword(String begin, String[] words) {
		
		Queue<String> wordque = new LinkedList<String>();
		 StringBuilder sb = null;
	        for(int i=0; i< begin.length(); i++) {
	        	sb=new StringBuilder(begin);
	        	for(int j=97; j< 97+26; j++) {
	        		sb.setCharAt(i, (char)j);
	        		String new_word = sb.toString();
	        		for(int k=0; k<words.length; k++) {
	        			if(words[k].equals(new_word) && !new_word.equals(begin)) {
	        				wordque.add(new_word);
	        			}
	        		}
	        			        		
	        	}
	        }
	        return wordque;
	}
}
