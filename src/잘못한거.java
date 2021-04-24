
public class 잘못한거 {
	
	public static void main(String[] args) {
		int N = 10;
		int R = 3;
		boolean[] visit = new boolean[N];
		go(N,R,0,visit);
	}
	
	public static void go(int N, int R, int cnt, boolean[] visit) {
		if(cnt==R) {
			for(int i=0; i<N; i++) {
				if(visit[i]) {
					System.out.print(i+" ");
				}
			}
			System.out.println();
		}
		
		for(int i=cnt; i<N; i++) {
			visit[i]=true;
			go(N,R,cnt+1,visit);
			visit[i]=false;
			
		}
	}

}
