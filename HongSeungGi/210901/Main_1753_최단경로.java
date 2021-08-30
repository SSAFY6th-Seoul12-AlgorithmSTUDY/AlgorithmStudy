import java.util.*;
import java.io.*;

public class Main_1753_최단경로 {
	static class Node{
		int v;
		int cost;
		public Node(int v,int cost) {
			this.v = v;
			this.cost = cost;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		ArrayList<Node>[] graph = new ArrayList[v];
		boolean[] visit = new boolean[v];
		int[] min = new int[v];
		int s = Integer.parseInt(br.readLine());
		Arrays.fill(min, Integer.MAX_VALUE);
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if(graph[start-1] == null) {
				graph[start-1] = new ArrayList<>();
			}
			graph[start-1].add(new Node(end-1,cost));
		}
		
		PriorityQueue<Node> q = new PriorityQueue<>((a,b)->{
			return a.cost-b.cost;
		});
		
		q.offer(new Node(s-1,0));		
		min[s-1] = 0;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int v1 = cur.v;
			if(graph[v1] == null) continue;
			
			for(int i = 0; i < graph[v1].size(); i++) {
				if(min[graph[v1].get(i).v] > min[v1]+graph[v1].get(i).cost) {
					min[graph[v1].get(i).v] = min[v1]+graph[v1].get(i).cost;
					q.offer(new Node(graph[v1].get(i).v, min[graph[v1].get(i).v]));
				}
			}
		}
		for(int i = 0; i < min.length; i++) {
			if(min[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
				continue;
			}
			System.out.println(min[i]);
		}
	}

}
