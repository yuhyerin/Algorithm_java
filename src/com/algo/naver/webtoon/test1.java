package com.algo.naver.webtoon;

import java.util.Comparator;
import java.util.PriorityQueue;

public class test1 {
	
	public static void main(String[] args) {
		test1 t = new test1();
//		int[] prices = {13000, 88000, 10000};
//		int[] discounts = {30, 20};
		int[] prices = {32000, 18000, 42500};
		int[] discounts = {50,20,65};
		int result = t.solution(prices, discounts);
		System.out.println(result);
	}
	
	// prices 길이 1~1000
	// prices 원소 5000~150,000. 항상 100으로 나눠떨어짐. 
	// discounts 길이 1~1000 
	// discounts 원소 1~100 
	public int solution(int[] prices, int[] discounts) {
		PriorityQueue<Integer> priceQue = new PriorityQueue<>(150000 ,new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1< o2) return 1;
				if (o1 >o2) return -1;
				return 0;
			}
		});
		PriorityQueue<Integer> discountQue = new PriorityQueue<Integer>(1000,new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1< o2) return 1;
				if (o1 >o2) return -1;
				return 0;
			}
		});
		
		for(int price: prices) {
			priceQue.add(price);
		}
		
		for(int discount: discounts) {
			discountQue.add(discount);
		}
		
		int answer = 0;
		while(!priceQue.isEmpty()) {
			int price = priceQue.poll();
			if(!discountQue.isEmpty()) {
				int discount = discountQue.poll();
				int discount_price = price*(100-discount)/100;
				answer += discount_price;
			}else {
				answer += price;
			}
		}
		
        return answer;
    }
	
	
}
