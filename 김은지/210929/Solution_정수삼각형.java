package programmers.DP;

public class Solution_정수삼각형 {
	
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
		//30
	}

	static int solution(int[][] triangle) {
        int answer = 0;
        int height = triangle.length;
        int[][] dp = new int[height][];
        dp[0] = new int[] {triangle[0][0]};
        
        for (int i = 1; i < height; i++) {
			dp[i] = new int[i+1];
			for (int j = 0; j < i+1; j++) {
				if (j == 0) dp[i][j] = dp[i-1][j] + triangle[i][j];
				else if (j == i) dp[i][j] = dp[i-1][j-1] + triangle[i][j];
				else dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
			}
		}
        
        for (int i = 0; i < height; i++) {
			answer = Math.max(answer, dp[height-1][i]);
		}
        
        return answer;
    }
	
}
