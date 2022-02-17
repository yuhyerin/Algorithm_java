package com.algo.문자열매칭;

public class KMP2 {
	
	public static void main(String[] args) {
		String string = "ABAABBABAABAB";
		String pattern = "ABAABAB";
		//int[] LPS = new KMP2().getLPS(pattern, pattern.length());
//		for(int value:LPS) {
//			System.out.print(value+" ");
//		}
		new KMP2().KMPSearch(string, pattern);
	}
	
	void KMPSearch(String txt, String pat)
    {
		char[] string = txt.toCharArray();
		char[] pattern = pat.toCharArray();
        int N = string.length;
        int M = pattern.length;

        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int lps[] = new int[M];
        int k = 0; // index for pat[]

        // Preprocess the pattern (calculate lps[]
        // array)
        lps = getLPS(pattern, M);

        int i = 0; // index for txt[]
        while (i < N) {
            if (pattern[k] == string[i]) {
                k++;
                i++;
            }
            if (k == M) {
                System.out.println("Found pattern at index " + (i - k));
                k = lps[k - 1];
            }

            // mismatch after j matches
            else if (i < N && pattern[k] != string[i]) {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (k != 0) {
                	k = lps[k - 1];
                }else {
                	i = i + 1;
                }
            }
        }
    }

	int[] getLPS(char[] pattern, int M) {
		// 0 1 2 3 4 5 6 7
		// A B A B A B A C
		int k = 0;
		int[] LPS = new int[M];
		
		for(int i=1; i<M; i++) {
			while(k>0 && pattern[i] != pattern[k]) {
				k = LPS[k-1];
			}
			
			if(pattern[k]==pattern[i]) {
				k++;
				LPS[i] = k;
			}
		}//end for
		
		return LPS;
	}
	
	void printLPS(int[] LPS) {
		for(int value: LPS) {
			System.out.print(value+" ");
		}
		System.out.println();
	}

}
