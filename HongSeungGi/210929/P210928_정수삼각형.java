import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][];
        for(int i = 0; i < triangle.length; i++){
            dp[i] = new int[triangle[i].length];
        }
        dp[0][0] = triangle[0][0];
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < dp[i].length; j++){
                if(j != 0 && j < dp[i].length-1){
                   // System.out.println(Math.max(dp[i-1][j-1]+triangle[i][j], dp[i-1][j]+triangle[i][j]));
                    dp[i][j] = Math.max(dp[i-1][j-1]+triangle[i][j], dp[i-1][j]+triangle[i][j]);
                    //continue;
                }
                else if(j == 0){
                    dp[i][j] = dp[i-1][j]+triangle[i][j];
                }
                else{
                    dp[i][j] = dp[i-1][j-1]+triangle[i][j];
                }
                //System.out.println(dp[i][j]+" "+i+" "+j);
                answer = Math.max(answer,dp[i][j]);
            }

        }
        return answer;
    }
}