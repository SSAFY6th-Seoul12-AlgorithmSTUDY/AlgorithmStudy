package algo_12class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9095 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i <= 10; i++) {
			dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
		}
		int tc = Integer.parseInt(br.readLine());
		for (int i = 0; i < tc; i++) {
			System.out.println(dp[Integer.parseInt(br.readLine())]);
		}
	}
}
