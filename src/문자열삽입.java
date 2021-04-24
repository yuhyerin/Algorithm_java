
public class 문자열삽입 {
	
	private String Solution(String sentence, String keyword, int[] skips) {
		String answer = sentence;
		int ans_idx = 0;
		int key_idx = 0;
		for(int ski_idx = 0; ski_idx < skips.length; ski_idx++) {
			for(int i = 0; i < skips[ski_idx]; i++) {
				if(answer.charAt(ans_idx) == keyword.charAt(key_idx)) {
					ans_idx++;
					break;
				}
				ans_idx++;
				if(ans_idx > answer.length())
					return answer;
			}
			answer = answer.substring(0, ans_idx).concat(keyword.charAt(key_idx) + "").concat(answer.substring(ans_idx, answer.length()));
			key_idx++;
			if(key_idx == keyword.length())
				key_idx = 0;
			ans_idx++;
			if(ans_idx > answer.length())
				return answer;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		문자열삽입 test= new 문자열삽입();
		System.out.println(test.Solution("i love coding", "mask", new int[]{0, 0, 3, 2, 3, 4}));
	}
}
