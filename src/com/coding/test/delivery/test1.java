package com.coding.test.delivery;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class test1 {

	public static void main(String[] args) {
		test1 t = new test1();
		String S = "John Doe, Peter Benjamin Parker, Mary Jane Watson-Parker, John Elvis Doe, John Evan Doe, Jane Doe, Peter Brian Parker";
		String C = "Example"; // 회사
		String result = t.solution(S, C);
		System.out.println(result);
	}

	// 이름.성@회사.com
	public String solution(String S, String C) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		StringTokenizer st = null;
		StringBuffer sb = new StringBuffer();
		String[] names = S.split(",");
		for (String fullname : names) {
			String Originalfullname = fullname.trim();
			String Lowerfullname = fullname.trim().toLowerCase();
			st = new StringTokenizer(Lowerfullname);
			int cnt = 0;
			String[] nameArray = new String[3];
			while (st.hasMoreTokens()) {
				nameArray[cnt++] = st.nextToken().replaceAll("-", "");
			}
			String first = nameArray[0];
			String last = nameArray[2] != null ? nameArray[2] : nameArray[1];
			System.out.println(first + "   " + last);
			String key = first + last;
			sb.append(Originalfullname);
			sb.append(" <");
			if (!map.containsKey(key)) {
				map.put(key, 1);
				sb.append(first + "." + last);
			} else {
				map.put(key, map.get(key) + 1);
				sb.append(first + "." + last + map.get(key));

			}
			sb.append("@" + C.toLowerCase() + ".com>, ");
		}
		String result = sb.toString().trim();
		result = result.substring(0, result.length() - 1);
		return result;
	}
}
