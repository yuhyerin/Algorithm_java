package com.algo.jungol.language_coder;

import java.text.DecimalFormat;

public class 출력_형성평가5 {
	public static void main(String[] args) {
		String[] Si = {"Seoul", "Pusan", "Incheon","Daegu","Gwangju"};
		int[] num = { 10312545, 3567910, 2758296, 2511676, 1454636};
		int[] num2 = {91375, 5868, 64888, 17230, 29774};
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		System.out.printf("%15s%15s%15s%n",Si[0],formatter.format(num[0]),"+"+formatter.format(num2[0]));
		System.out.printf("%15s%15s%15s%n",Si[1],formatter.format(num[1]),"+"+formatter.format(num2[1]));
		System.out.printf("%15s%15s%15s%n",Si[2],formatter.format(num[2]),"+"+formatter.format(num2[2]));
		System.out.printf("%15s%15s%15s%n",Si[3],formatter.format(num[3]),"+"+formatter.format(num2[3]));
		System.out.printf("%15s%15s%15s%n",Si[4],formatter.format(num[4]),"+"+formatter.format(num2[4]));
		
	}

}
