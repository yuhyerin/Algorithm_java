import java.util.Stack;

public class N개중에R개뽑기_재귀_스택 {

	Stack<Integer> stack = new Stack<Integer>();
	int global_avg = 0;
	public static void main(String[] args) {
		N개중에R개뽑기_재귀_스택 t = new N개중에R개뽑기_재귀_스택();
	}
	
	public int solution() {
		int answer = 0;
		int N = 10;
		int R = 3;
		int d = 1;
		int[] prices = new int[N];
		boolean[] visit = new boolean[N];
		go(prices,d,N,R,0);
		if(global_avg != 0) {
			return global_avg;
		}else {
			// 4번조건 
		}
		return answer;
	}
	
	public boolean go(int[] prices,int d,int N, int R, int cnt) {
		if(cnt==R) {
			if(prices[stack.get(stack.size()-1)] - prices[stack.get(0)] <= d) {
				int tmp_sum = 0;
				for(int i=0; i<stack.size();i++) {
					tmp_sum += stack.get(i);
				}
				global_avg = tmp_sum / stack.size();
				return true;
			}
			return false;
		}
		
		for(int i=cnt;i<N; i++) {
			stack.push(i);
			if(go(prices,d,N,R,cnt+1)) {
				return true;
			}
			stack.pop();
		}
		return false;
	}

}
