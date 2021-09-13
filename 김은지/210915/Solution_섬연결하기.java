package programmers.greedy;

import java.util.*;

public class Solution_섬연결하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(4, new int[][] {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}})); //4
	}
	
	public static int solution(int n, int[][] costs) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]>[] island = new PriorityQueue[n];
        
        for (int i = 0; i < n; i++) {
			island[i] = new PriorityQueue<int[]> ((o1, o2) -> Integer.compare(o1[1], o2[1]));
		}
        
        for (int i = 0; i < costs.length; i++) {
			island[costs[i][0]].add(new int[] {costs[i][1], costs[i][2]});
			island[costs[i][1]].add(new int[] {costs[i][0], costs[i][2]});
		}
        
        visited[0] = true;
        
        PriorityQueue<int[]> connected = new PriorityQueue<int[]> ((o1, o2) -> Integer.compare(o1[1], o2[1]));
        while (!island[0].isEmpty()) {
        	connected.offer(island[0].poll());
        }
        label : while(true) {
        	int[] node = connected.poll();
        	while (!connected.isEmpty()) {
        		if (!visited[node[0]]) break;
        		node = connected.poll();
        	}
        	
        	answer += node[1];
        	visited[node[0]] = true;
        	
        	while (!island[node[0]].isEmpty()) {
        		connected.offer(island[node[0]].poll());
			}

        	for (int i = 0; i < n; i++) {
				if (!visited[i]) continue label;
			}
        	break;
        }
        
        return answer;
    }

}
