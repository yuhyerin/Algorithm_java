package com.algo.kakao.internship;
import java.util.HashMap;
import java.util.Map;

public class test1 {

	public static void main(String[] args) {
		test1 t = new test1();
		//String s = "one4seveneight";
		String s = "23four5six7";
		int result = t.solution(s);
		System.out.println(result);

	}

	class Number{
		String num;
		int len;
		public Number(String num, int len) {
			super();
			this.num = num;
			this.len = len;
		}
		public String getNum() {
			return num;
		}
		public void setNum(String num) {
			this.num = num;
		}
		public int getLen() {
			return len;
		}
		public void setLen(int len) {
			this.len = len;
		}
	}
	
	public int solution(String s) {
		// ze, on, tw, th, fo, fi, si ,se, ei, ni
        String result = "";
        Map<String, Number> map = new HashMap<String, Number>();
        map.put("ze", new Number("0",4));//4
        map.put("on", new Number("1",3));//3
        map.put("tw", new Number("2",3));//3
        map.put("th", new Number("3",5));//5
        map.put("fo", new Number("4",4));//4
        map.put("fi", new Number("5",4));//4
        map.put("si", new Number("6",3));//3
        map.put("se", new Number("7",5));//5
        map.put("ei", new Number("8",5));//5
        map.put("ni", new Number("9",4));//4
        
        int idx = 0;
        while(idx<s.length()){
        	try {
        		int num = Integer.parseInt(s.charAt(idx)+"");
        		result = result + num + "";
        		idx++;
        	}catch(Exception e) {
        		String first = s.charAt(idx)+"";
        		String second = s.charAt(idx+1)+"";
        		String key = first+second+"";
        		result = result + map.get(key).getNum();
        		idx=idx+ map.get(key).getLen();
        	}
        }
        return Integer.parseInt(result);
    }

}
