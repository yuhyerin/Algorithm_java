package com.algo.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class L3_�ܾȯ {
	/** 2���� �ܾ� begin, target
	 * �ܾ����� words
	 * ��Ģ�� �̿��Ͽ� begin -> target���� ��ȯ�ϴ� ���� ª�� ������ ã�� 
	 * ��Ģ1. �ѹ��� �Ѱ��� ���ĺ��� �ٲ� �� �ִ�.
	 * ��Ģ2. words�� �ִ� �ܾ�θ� ��ȯ�� �� �ִ�. 
	 * hit -> hot -> dot -> dog -> cog : 4�ܰ� 
	 * 
	 * �ܾ�� �ҹ��ڸ�. (26��) 
	 * �ܾ��� ���̴� 3~10. ��� �ܾ��� ���̴� ����!
	 * words���� 3��~50��. �ߺ�X
	 * begin�� target�� ���� ����.
	 * ��ȯ�� �� ���ٸ� 0 ����. */
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
        	System.out.println("beginť size: "+size);
        	while(size-- > 0) {// �ʱ� beginque�����ŭ�� �ݺ�. 
        		
        		Queue<String> wordque = new LinkedList<>();
        		String cur = beginque.poll(); // hit 
        		if(cur.equals(target)) { // Ÿ���� �߰������� ����.
        			System.out.println(target+"�� �߰���");
        			if(min>answer) {
        				min = answer;
        			}
        			break outer;
        		}
        		wordque = makeAllword(cur, words); // hot
        		if(wordque.size()==0) { // ���ĺ� �ϳ��� �ٲ۴ܾ words�� ��ġ�Ѵ� �ְ� ������ ����.
        			break outer;
        		}
        		while(!wordque.isEmpty()) {
        			beginque.add(wordque.poll()); // ã�ƿ� �ֵ��� beginť�� �ֱ�.
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
