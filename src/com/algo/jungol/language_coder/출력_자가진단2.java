package com.algo.jungol.language_coder;

import java.io.IOException;
import java.io.OutputStream;

public class 출력_자가진단2 {

	public static void main(String[] args) throws IOException {
		
		String word = "Programming! It's fun.";
		OutputStream hyerin = System.out;
		hyerin.write(word.getBytes());
		long start_t = System.currentTimeMillis();
//		for(int i=0; i<10000; i++) {
//			System.out.printf("%s",word);
//		}
		long after_t = System.currentTimeMillis();
		long t1 = after_t - start_t;
//		start_t = System.currentTimeMillis();
//		for(int i=0; i<10000; i++) {
//			hyerin.write(word.getBytes());
//		}
		after_t = System.currentTimeMillis();
		long t2 = after_t - start_t;
//		System.out.println();
//		System.out.println("1번의 시간: " + t1 );
//		System.out.println("2번의 시간: " + t2 );
	}
}
