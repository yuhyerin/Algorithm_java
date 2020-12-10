package com.algo.programmers;

import java.util.HashMap;

public class L1_완주하지못한선수 {
	
	public static void main(String[] args) {
//		String[] participant = {"leo","kiki","eden"};
		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"}; 
//		String[] completion = {"eden", "kiki"};
		String[] completion = {"josipa", "filipa", "marina", "nikola"};
		String result = Solution(participant, completion);
		System.out.println(result);
	}
	
	public static String Solution(String[] part, String[] comp) {
		String answer ="";
		boolean flag = false;
		HashMap<String, Integer> hash = new HashMap<>();
		for(int i=0; i<comp.length;i++) {
			if(!hash.containsKey(comp[i])) { //없으면 
				hash.put(comp[i], 1);
			}else { //이미 있으면 
				hash.put(comp[i],  hash.get(comp[i])+1);
			}
		}// end make hash
		
		for(int i=0; i<part.length;i++) {
			if(hash.containsKey(part[i])) { // 참가자가 완주hash에 등록되어 있니? 
				hash.put(part[i],  hash.get(part[i])-1);
				if(hash.get(part[i])==0) {
					hash.remove(part[i]);
				}
			}else {
				return part[i];
			}
		}
		
		return answer; 
	}
}
