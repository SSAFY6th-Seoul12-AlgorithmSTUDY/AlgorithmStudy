package baekjoon.backtracking;

import java.io.*;
import java.util.*;

public class Main_1182_부분수열의합 {
	
	static int N, S, cnt;
	static boolean[] selected;
	static int[] numbers;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		selected = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		cnt = 0;
		subset(0, 0, 0);
		System.out.println(cnt);
	}
	
	static void subset(int idx, int sum, int selectedCnt) {
		if (idx == N) {
			if (selectedCnt == 0) return;
			if (sum == S) cnt++;
			return;
		}
		
		selected[idx] = true;
		subset(idx+1, sum+numbers[idx], selectedCnt+1);
		selected[idx] = false;
		subset(idx+1, sum, selectedCnt);
	}

}
