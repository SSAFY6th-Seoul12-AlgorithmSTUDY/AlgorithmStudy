package baekjoon.dijkstra;

import java.io.*;
import java.util.*;

public class Main_18352_특정거리의도시찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //도시의 개수
		int M = Integer.parseInt(st.nextToken()); //도로의 개수
		int K = Integer.parseInt(st.nextToken()); //최단거리 정보
		int X = Integer.parseInt(st.nextToken()); //출발 도시의 번호
		
		List<Integer>[] edge = new ArrayList[N+1];
		boolean[] visited = new boolean[N+1];
		int[] distance = new int[N+1];
		
		for (int i = 0; i < N+1; i++) {
			edge[i] = new ArrayList<Integer>();
			distance[i] = Integer.MAX_VALUE/2;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			edge[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}
		
		distance[X] = 0;
		visited[X] = true;
		ArrayDeque<Integer> que = new ArrayDeque<>();
		que.offer(X);
		while(!que.isEmpty()) {
			int curr = que.poll();
			if (distance[curr] >= K) break;
			for(int i : edge[curr]) {
				if (!visited[i]) {
					que.offer(i);
					distance[i] = distance[curr]+1;
					visited[i] = true;
				}
			}
		}
		
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N+1; i++) {
			if (distance[i] == K) {
				sb.append(i).append("\n");
				cnt++;
			}
		}
		System.out.println(cnt==0?-1:sb);
		br.close();
	}

}
