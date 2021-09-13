package programmers.graph;

import java.util.*;

public class Solution_가장먼노드 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(6, new int[][] {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
		//3
	}
	
	public static int solution(int n, int[][] edge) {
		boolean[] visited = new boolean[n+1];
        List<Integer>[] nodes = new ArrayList[n+1];
        
        for (int i = 0; i <= n; i++) {
			nodes[i] = new ArrayList<Integer>();
		}
        
        for (int i = 0; i < edge.length; i++) {
			nodes[edge[i][0]].add(edge[i][1]);
			nodes[edge[i][1]].add(edge[i][0]);
		}
        
        int depth = 0;
        int answer = 0;
        
        ArrayDeque<int[]> que = new ArrayDeque<>();
        que.offer(new int[] {1, 0});
        visited[1] = true;
        
        while(!que.isEmpty()) {
        	int[] node = que.poll();
        	for(int i : nodes[node[0]]) {
        		if (visited[i]) continue;
        		visited[i] = true;
        		que.offer(new int[] {i, node[1]+1});
        	}
        	
        	if (depth < node[1]) {
        		depth = node[1];
        		answer = 1;
        	} else if (depth == node[1]) {
        		answer++;
        	}
        }
        
        return answer;
    }

}
