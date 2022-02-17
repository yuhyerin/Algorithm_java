package com.coding.test.delivery;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class test2 {
	
	public static void main(String[] args) {
		test2 t = new test2();
		String S = "";
		String result = t.solution(S);
		System.out.println(result);
	}
	
	 public String solution(String S) {
	        int totalCnt = 0;
	        String[] lines = S.split("\n");
	        for (String line : lines) {
	            String sizeString = line.substring(0, 10).trim();
	            String dateString = line.substring(11, 22).trim();
	            String filenameString = line.substring(23).trim();

	            int fileSize = Integer.parseInt(sizeString);

	            SimpleDateFormat parser = new SimpleDateFormat("dd MMM yyyy", Locale.US);
	            Date dateCondition = null;
	            Date lastModificationDate = null;

	            try {
	                lastModificationDate = parser.parse(dateString);
	                dateCondition = parser.parse("31 Jan 1990");
	            } catch (ParseException e){
	                e.printStackTrace();
	                continue;
	            }

	            int dateCompare = dateCondition.compareTo(lastModificationDate);
	            if(dateCompare <= 0 && fileSize > 240 * 1024){
	                totalCnt++;
	            }
	        }
	        if(totalCnt == 0){
	            return "NO FILES";
	        }
	        return Integer.toString(totalCnt);
	    }
}
