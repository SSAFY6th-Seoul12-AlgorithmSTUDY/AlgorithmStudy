import java.util.*;
class Solution {
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[][] graph = new int[n][n];
        int[] min_d = new int[n];
        boolean[] v = new boolean[n];
        Arrays.fill(min_d, Integer.MAX_VALUE);
        for(int i = 0; i < costs.length; i++){
            int[] c = costs[i];
            
            int start = c[0];
            int end = c[1];
            int cost = c[2];
            
            graph[start][end] = cost;
            graph[end][start] = cost;
        }
        int result = 0;
        min_d[0] = 0;
        
        for(int i = 0; i < n; i++){
            int min = Integer.MAX_VALUE;
            int mv = -1;
            
            for(int j = 0; j < n; j++){
                if(!v[j] && min > min_d[j]){
                    mv = j;
                    min = min_d[j];
                }
            }
            v[mv] = true;
            result += min;
            for(int j = 0; j < n; j++){
                if(!v[j] && graph[mv][j] != 0 && min_d[j] > graph[mv][j]){
                    min_d[j] = graph[mv][j];
                }
            }
        }
        answer = result;
        return answer;
        
    }
}