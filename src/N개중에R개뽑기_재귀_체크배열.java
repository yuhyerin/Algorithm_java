
public class N개중에R개뽑기_재귀_체크배열 {
	
	public static void main(String[] args) {
		int N = 10;
		int R = 3;
		boolean[] visit = new boolean[N];
		go(N,R,0,0,visit);
	}
	
	public static void go(int N, int R, int cnt, int cur, boolean[] visit) {
		if(cnt==R) {
			for(int i=0; i<N; i++) {
				if(visit[i]) {
					System.out.print(i+" ");
				}
			}
			System.out.println();
		}
		
		for(int i=cur; i<N; i++) {
			visit[i]=true;
			go(N,R,cnt+1,i+1,visit);
			visit[i]=false;
			
		}
	}

}
