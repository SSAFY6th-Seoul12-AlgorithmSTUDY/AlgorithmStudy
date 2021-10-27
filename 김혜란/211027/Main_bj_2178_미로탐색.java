package com.ssafy.study_1020;

import java.io.*;
import java.util.*;

public class Main_bj_2178_미로탐색 {

	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };
	static int N, M;
	static int[][] miro;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		miro = new int[N][M];
		for (int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine());
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
//				miro[i][j] = Integer.parseInt(st.nextToken());
				miro[i][j] = s.charAt(j) - '0';
			}
		}

		visited = new boolean[N][M];
		visited[0][0] = true;
		bfs(0, 0);
		System.out.println(miro[N - 1][M - 1]);

	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { i, j });

		while (!q.isEmpty()) {
			int cur[] = q.poll();
			int curX = cur[0];
			int curY = cur[1];

			for (int d = 0; d < 4; d++) {
				int nX = curX + di[d];
				int nY = curY + dj[d];

				if (nX < 0 || nY < 0 || nX >= N || nY >= M)
					continue;
				if (visited[nX][nY] || miro[nX][nY] == 0)
					continue;

				q.add(new int[] { nX, nY });
				miro[nX][nY] = miro[curX][curY] + 1;
				visited[nX][nY] = true;
			}

		}

	}

}
//https://wiselog.tistory.com/163