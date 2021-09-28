package 알고리즘스터디;

public class PRO_정수삼각형 {
	static int[][] triangle = { { 7 }};
	static int answer = triangle[0][0];
	static int[][] dp;

	public static void main(String[] args) {
		dp = new int[triangle.length][];
		// dp 초기화
		for (int i = 0; i < dp.length; i++) {
			dp[i] = new int[i + 1];
		}
		dp[0][0] = triangle[0][0];
		for (int i = 0; i < triangle.length - 1; i++) {
			for (int j = 0; j < triangle[i].length; j++) {
				dp[i + 1][j] = Math.max(triangle[i + 1][j] + dp[i][j], dp[i + 1][j]);
				dp[i + 1][j + 1] = Math.max(triangle[i + 1][j + 1] + dp[i][j], dp[i + 1][j + 1]);
				answer = Math.max(answer, dp[i + 1][j]);
				answer = Math.max(answer, dp[i + 1][j + 1]);
			}
		}
		System.out.println(answer);
	}

}
