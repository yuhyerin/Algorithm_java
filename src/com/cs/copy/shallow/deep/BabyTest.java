package com.cs.copy.shallow.deep;

public class BabyTest {
	public static void main(String[] args) {
		Baby[] arr = new Baby[3];
		arr[0] = new Baby("hyerin", 1);
		arr[1] = new Baby("hyerin2", 2);
		arr[2] = new Baby("hyerin3", 3);
		System.out.println("원본배열 arr");
		System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
		System.out.println();

		Baby[] copyArr = new Baby[3];

		for (int i = 0; i < 3; i++) {
			try {
				copyArr[i] = (Baby)arr[i].clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("복사배열 copyarr");
		System.out.println(copyArr[0] + " " + copyArr[1] + " " + copyArr[2]);
		System.out.println();

		System.out.println("원본배열의 첫번째 아기 나이를 99로 변경 ");
		arr[0].name = "개명한riri";
		arr[0].age = 99;
		System.out.println("원본배열 arr");
		System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
		System.out.println("복사배열 copyarr");
		System.out.println(copyArr[0] + " " + copyArr[1] + " " + copyArr[2]);
	}
}
