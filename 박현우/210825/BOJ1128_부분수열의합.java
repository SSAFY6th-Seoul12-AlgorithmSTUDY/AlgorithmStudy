package 알고리즘스터디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1128_부분수열의합 {
	static int n, s, answer = 0;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		// 초기화
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		subset(0, 0);
		System.out.println(s == 0 ? answer - 1 : answer);
	}

	static void subset(int depth, int tot) {
		if (depth == n) {
			if(tot == s) {
				answer++;
			}
			return;
		}
		subset(depth + 1, tot + arr[depth]);
		subset(depth + 1, tot);
	}

}
