package com.algo.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_8982_수족관1 {

	static class Node {
		int r, c;
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static final int MAX = 40001;
	static int[] surface, depth;
	static Node[] hole;
	static int N, K, ans, lastIdx;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());

		ans = 0;
		surface = new int[MAX];
		depth = new int[MAX];

		// 각 열에 대한 수족관 깊이를 입력한다.
		// 0, 0 제거
		br.readLine();
		for (int i = 0; i < N / 2 - 1; ++i) {
			st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int c2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());

			for (int j = c1; j <= c2; ++j) {
				depth[j] = r1;
			}

			lastIdx = c2 - 1;
		}
		// 마지막 제거
		br.readLine();

		K = Integer.parseInt(br.readLine());

		// 수족관 배수구 데이터 입력
		hole = new Node[K];
		for (int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int dep = Integer.parseInt(st.nextToken());
			hole[i] = new Node(dep, idx);
		}

		for (Node cur : hole) {
			int curDepth = cur.r;
			int col = cur.c;

			// 왼쪽으로 갱신
			for (int i = col; i >= 0; --i) {
				// 현재 깊이를 최소값으로 유지한다.
				curDepth = curDepth > depth[i] ? depth[i] : curDepth;
				surface[i] = curDepth > surface[i] ? curDepth : surface[i];
			}

			curDepth = cur.r;
			col = cur.c;

			// 오른쪽으로 갱신
			for (int i = col; i <= lastIdx; ++i) {
				// 현재 깊이를 최소값으로 유지한다.
				curDepth = curDepth > depth[i] ? depth[i] : curDepth;
				surface[i] = curDepth > surface[i] ? curDepth : surface[i];
			}

		}

		for (int i = 0; i <= lastIdx; ++i) {
			ans += depth[i] - surface[i];
		}

		System.out.println(ans);
	}

}