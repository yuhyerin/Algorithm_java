package com.algo.leetcode;

public class leetcode_28_implements_strstr {
	public static void main(String[] args) {
		leetcode_28_implements_strstr t = new leetcode_28_implements_strstr();
		String string = "dabcabkabcabd";
		String pattern = "abcabd";
		int result = t.kmp(string, pattern);
		System.out.println(result);
	}
	
	public int kmp(String string, String pattern) {
		char[] parents = string.toCharArray();
		char[] patterns = pattern.toCharArray();
		int[] table = makeTable(pattern);
		int k = 0;
		for(int i=0; i< parents.length; i++) {
			while(parents[i] != patterns[k]) {
				if(k==0) {
					break;
				}
				k = table[k-1];
			}
			if(parents[i] == patterns[k]) {
				if(k == patterns.length - 1) {
					System.out.println((i-patterns.length+1)+"번째에서 발견.");
					k = table[k];
				}else {
					k++;
				}
			}
		}
		return -1;
	}
	
	private int[] makeTable(String pattern) {
		int len = pattern.length();
		char[] patterns = pattern.toCharArray();
		int[] table = new int[len];
		table[0] = 0;
		int j = 0;
		for(int i=1; i< len; i++) {
			while(patterns[i] != patterns[j]) {
				if(j==0) {
					break;
				}
				j = table[j-1];
			}
			if(patterns[i] == patterns[j]) {
				j++;
				table[i] = j;
			}
		}
		return table;
	}
}
