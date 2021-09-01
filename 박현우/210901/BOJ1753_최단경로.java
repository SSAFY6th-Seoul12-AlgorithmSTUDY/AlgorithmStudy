package 알고리즘스터디;

import java.io.*;
import java.util.*;

public class BOJ1753_최단경로 {
	static int v, e, start;
	static int[] dist;
	static List<int[]>[] list;
	static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
	static final int inf = 987654321;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		dist = new int[v + 1];
		list = new ArrayList[v + 1];
		Arrays.fill(dist, inf);
		dist[start] = 0;
		for (int i = 1; i <= v; i++) {
			list[i] = new ArrayList<>();
		}
		visited = new boolean[v + 1];
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // start
			int b = Integer.parseInt(st.nextToken()); // destination
			int c = Integer.parseInt(st.nextToken()); // cost
			list[a].add(new int[] { b, c });
		}
		pq.offer(new int[] { start, 0 });
		while (!pq.isEmpty()) {
			int[] temp = pq.poll();
			if (visited[temp[0]])
				continue;
			visited[temp[0]] = true;
			// 꺼낸 노드를 기준으로 최단 거리 갱신
			for (int[] a : list[temp[0]]) {
				if (dist[a[0]] > dist[temp[0]] + a[1]) {
					dist[a[0]] = dist[temp[0]] + a[1];
					pq.offer(new int[] { a[0], dist[a[0]] });
				}
			}
		}
		for (int i = 1; i <= v; i++) {
			System.out.println(dist[i] == inf ? "INF" : dist[i]);
		}
	}
}
