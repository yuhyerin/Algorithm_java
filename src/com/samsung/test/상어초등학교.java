package com.samsung.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class 상어초등학교 {
	static int N; // 3~20 
	static int[][] map;
	static ArrayList<ArrayList<Integer>> flist;
	static ArrayList<Integer>[] farray;
	static int[] dy = {-1,0,0,1}; // 위 왼 오 아래 
	static int[] dx = {0,-1,1,0}; 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine()); // 길이가 N인 컨베이어 벨트.
		map = new int[N+1][N+1];
		flist = new ArrayList<ArrayList<Integer>>();
		farray = new ArrayList[N*N+1];
		
		for(int i=1; i<=N*N; i++) {
			farray[i] = new ArrayList<>();
		}// end 초기화 
		
		for(int i=1; i<= N*N; i++) {
			ArrayList<Integer> tmp = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int me = Integer.parseInt(st.nextToken()); // 내번호
			tmp.add(me);
			for(int j=0; j<4; j++) { //  좋아하는 학생 4명 
				int friend = Integer.parseInt(st.nextToken());
				tmp.add(friend);
				farray[me].add(friend);
			}
			flist.add(tmp);
		}// end Input ( 초반에 데이터를 저장할 때, flist, farray 2군데에 저장해준다 ) 
		
		/**
		 * 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸 
		 * 2. -> 여러개라면 인접한 칸 중에 비어있는 칸이 제일 많은 칸 
		 * 3. ---> 여러개라면 행의 번호가 가장 작은 칸 -> 열의 번호가 가장 작은 칸 */
		for(ArrayList<Integer> meAndfriends : flist) {
			
			int me = meAndfriends.get(0); // 내번호 
			meAndfriends.remove(0); // 내가 좋아하는 친구들 리스트 
			// 1. 인접한 칸에 친구가 가장많은 자리를 리스트로 받아옴.
			ArrayList<int[]> seats = findFavoriteFriends(meAndfriends); 
			if(seats.size()==0) {//친구가 아무도 없었으면
				int[] finalSeat = justHasManyEmptySeat();
				map[finalSeat[0]][finalSeat[1]] = me; // 착석 
			}else if(seats.size()>1) { // 여러명이거나 
				// 1-2. 인접한 칸 중에 비어있는 칸이 많은 칸 (행,열번호 적은 칸) 
				int[] finalSeat = checkHasManyEmptySeat(seats);
				map[finalSeat[0]][finalSeat[1]] = me; // 착석 
			}else if(seats.size()==1) {
				int[] cur = seats.get(0);
				map[cur[0]][cur[1]] = me; // 착석 
			}
		}
		
		// 만족도 계산 
		int result = getSatisfaction();
		System.out.println(result);
	}

	// 주위에 친구가 가장 많은 자리 
	private static ArrayList<int[]> findFavoriteFriends(ArrayList<Integer> friends) {
		ArrayList<int[]> maxFavoriteFriends = new ArrayList<>();
		int max = -1;
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				int cy = i;
				int cx = j;
				int cnt = 0;
				if(map[cy][cx]!=0) continue; // 자리 이미 있음. 
				ArrayList<int[]> tmp = new ArrayList<>();
				for(int d=0; d<4; d++) {
					int ny = cy+dy[d];
					int nx = cx+dx[d];
					if(!canGo(ny,nx)) continue;
					if(isFavoriteFriend(map[ny][nx], friends)){
						// 좋아하는 친구니?
						cnt++;
						tmp.add(new int[] {i,j});
					}
				}
				if(cnt>max) {
					max = cnt;
					maxFavoriteFriends.clear();
					for(int[] cur : tmp) {
						maxFavoriteFriends.add(cur);
					}
				}else if(cnt==max) {
					for(int[] cur : tmp) {
						maxFavoriteFriends.add(cur); // 추가 
					}
				}
				tmp.clear(); // 초기화 
			}
		}
		return maxFavoriteFriends;
	}
	
	// 주변에 아예 친구가 없었다면 
	private static int[] justHasManyEmptySeat() {
		int max = -1;
		int[] maxPos = new int[2];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(map[i][j]!=0) continue;
				int cnt = 0;
				for(int d=0; d<4; d++) {
					int ny = i+dy[d];
					int nx= j+dx[d];
					if(!canGo(ny,nx)) continue;
					if(map[ny][nx]==0) cnt++;
				}
				if(cnt==4) {
					return new int[] {i,j};
				}else {
					if(max < cnt) {
						max = cnt;
						maxPos[0] = i;
						maxPos[1] = j;
					}
				}
			}
		}
		return maxPos;
	}
	
	// 주위에 빈칸이 많은 칸 
	private static int[] checkHasManyEmptySeat(ArrayList<int[]> seats) {
		int max = -1;
		int[] finalSeat = new int[2];
		
		for(int[] seat : seats) {
			int y = seat[0];
			int x = seat[1];
			int ny = -1;
			int nx = -1;
			if(!canGo(y,x)) continue;
			int cnt = 0;
			for(int d=0; d<4; d++) {
				ny = y+dy[d];
				nx = x+dx[d];
				if(!canGo(ny,nx)) continue;
				if(map[ny][nx]==0) {
					cnt++;
				}
			}// 주위 탐색 
			if(max<cnt) {
				max =cnt;
				finalSeat[0] = y;
				finalSeat[1] = x;
			}
		}
		return finalSeat;
	}

	// 좋아하는 친구인지 여부 
	private static boolean isFavoriteFriend(int f, ArrayList<Integer> friends) {
		for(int friend:friends) {
			if(f==friend) {
				return true;
			}
		}
		return false;
	}

	// 만족도 계산 
	private static int getSatisfaction() {
		int totalSum =0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				int jumsu = 0;
				int me = map[i][j];
				ArrayList<Integer> friends = farray[me];
				for(int d=0; d<4; d++) { // 주변 검사 
					int fy = i+dy[d];
					int fx = j+dx[d];
					if(!canGo(fy,fx)) continue;
					for(int friend: friends) {
						if(map[fy][fx] == friend) {
							jumsu += 1;
						}
					}
				}// end for
				switch(jumsu) {
				case 0:
				case 1:
					totalSum += 1;
					break;
				case 2:
					totalSum += 10;
					break;
				case 3:
					totalSum += 100;
					break;
				case 4:
					totalSum +=1000;
					break;
				}
				
			}
		}
		return totalSum;
	}

	private static boolean canGo(int y, int x) {
		if(1<= y && y<=N && 1<= x && x<=N) {
			return true;
		}
		return false;
	}
}
