package baekjoon.dfsbfs;

import java.util.*;
import java.io.*;

public class Main_1388_바닥장식 {
	
	static int cnt = 0;
	static int N, M;
	static char[][] floor;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		floor = new char[N][M];
		
		for (int i = 0; i < floor.length; i++) {
			floor[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (floor[i][j] == '-' || floor[i][j] == '|') dfs(floor[i][j], i, j, false);
			}
		}
		
		System.out.println(cnt);
	}
	
	static void dfs(char c, int x, int y, boolean flag) {
		if (0<=x && x<N && 0<=y && y<M && c == floor[x][y]) {
			if (!flag) cnt++;
			floor[x][y] = '0';
			if (c == '-') dfs(c, x, y+1, true);
			if (c == '|') dfs(c, x+1, y, true);
		} else return;
	}

}
