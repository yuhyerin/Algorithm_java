package com.cs.copy.shallow.deep;

public class ShallowDeepCopyTest {
	public static void main(String[] args) {
		Information info = new Information();
		info.height = 180;
		info.weight = 80;
		
		System.out.println("원본: "+info.toString());
		
		Information shallow = info;
		Information deep = null;
		try {
			deep = (Information) info.clone();
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		// 값 변경
		info.weight = 68;
		info.height = 170;
		
		System.out.println("변경된 원본: "+info.toString());
		
		System.out.println("얕은복사: "+shallow.toString());
		
		System.out.println("깊은복사: "+deep.toString());
	}

}
