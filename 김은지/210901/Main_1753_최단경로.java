package baekjoon.dijkstra;

import java.io.*;
import java.util.*;

public class Main_1753_최단경로 {
	
	static class Node implements Comparable<Node>{
		int n, w;

		public Node(int n, int w) {
			this.n = n;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken()); //정점의 개수
		int E = Integer.parseInt(st.nextToken()); //간선의 개수
		int K = Integer.parseInt(br.readLine()); //시작 정점의 번호
		PriorityQueue<Node>[] edge = new PriorityQueue[V+1];
		boolean[] visited = new boolean[V+1];
		int[] distance = new int[V+1];
		
		for (int i = 0; i <= V; i++) {
			edge[i] = new PriorityQueue<Node>();
			distance[i] = Integer.MAX_VALUE/2;
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			edge[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		distance[K] = 0;
		PriorityQueue<Node> que = new PriorityQueue<>();
		que.offer(new Node(K, 0));
		while(!que.isEmpty()) {
			Node node = que.poll();
			for(Node i : edge[node.n]) {
				if (!visited[i.n] && distance[i.n] > distance[node.n] + i.w) {
					distance[i.n] = distance[node.n] + i.w;
					que.offer(new Node(i.n, distance[i.n]));
				}
			}
			visited[node.n] = true;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			if (distance[i] == Integer.MAX_VALUE/2) sb.append("INF\n");
			else sb.append(distance[i]).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}
