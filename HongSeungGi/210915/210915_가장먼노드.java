import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[] v = new boolean[n+1];
        
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        int[] depth = new int[n+1];
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < edge.length; i++){
            int[] node = edge[i];
            
            int start = node[0];
            int end = node[1];
            
            if(graph[start] == null){
                graph[start] = new ArrayList<>();
            }
            if(graph[end] == null){
                graph[end] = new ArrayList<>();
            }
            
            graph[start].add(end);
            graph[end].add(start);
        }
        
        q.offer(new int[] {1,0});
        v[1] = true;
        while(!q.isEmpty()){
            int[] node = q.poll();
            int point = node[0];
            int d = node[1];
            depth[point] = d;
            
            for(int i = 0; i < graph[point].size(); i++){
                if(v[graph[point].get(i)]) continue;
                v[graph[point].get(i)] = true;
                q.offer(new int[] {graph[point].get(i), d+1});
            }
        }
        Arrays.sort(depth);
        int max = depth[depth.length-1];
        for(int i = depth.length-1; i >= 0; i--){
            if(depth[i] == max) answer++;
        }
        return answer;
    }
}