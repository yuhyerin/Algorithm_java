package com.algo.jungol.language_coder;

import java.io.IOException;

public class 출력_자가진단4 {
	public static void main(String[] args) throws IOException {
//		System.out.println("(@) (@)");
//		System.out.println("(=^.^=)");
//		System.out.println("(-m-m-)");
		
		StringBuffer sb = new StringBuffer();
		sb.append("(@) (@)\n");
		sb.append("(=^.^=)\n");
		sb.append("(-m-m-)\n");
		System.out.write(sb.toString().getBytes());
	}

}
