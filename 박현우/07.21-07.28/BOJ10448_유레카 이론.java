package algo_12class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10448 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] tri = new int[45];
		int[] dp = new int[1001];
		// 삼각수 삽입
		for (int i = 0; i < 45; i++) {
			tri[i] = (i + 1) * (i + 2) / 2;
		}

		for (int i : tri) {
			for (int j : tri) {
				for (int k : tri) {
					if (i + j + k <= 1000) {
						dp[i + j + k] = 1;
					}
				}
			}
		}
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			System.out.println(dp[Integer.parseInt(br.readLine())]);
		}
	}

}
