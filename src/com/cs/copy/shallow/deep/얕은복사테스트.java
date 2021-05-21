package com.cs.copy.shallow.deep;

public class 얕은복사테스트 {

	public static void main(String[] args) {
		A a1,a2 =null;
		a1 = new A(10, new int[] {1,2,3},"riri");
		try {
			a2 = a1.copy();
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		System.out.println("hash 코드가 다름. 둘은 다른 객체임 ");
		System.out.println(a1.hashCode());
		System.out.println(a2.hashCode());
		
		a1.i = 99;
		a1.arr[0]=99;
		a1.name = "changed riri";
		
		System.out.println("====");
		System.out.println(a1.i);
		System.out.println(a2.i);
		
		System.out.println("====");
		System.out.println(a1.arr[0]);
		System.out.println(a2.arr[0]); // 얘는 참조값을 복사했기 때문에, 같은 배열을 가리키고 있음!!!!! (헉!)
		
		System.out.println("====");
		System.out.println(a1.name);
		System.out.println(a2.name); // string은 영향이 없네요. 
	}
}
