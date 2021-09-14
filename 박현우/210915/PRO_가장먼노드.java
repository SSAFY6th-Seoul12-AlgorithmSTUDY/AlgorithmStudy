package 알고리즘스터디;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PRO_가장먼노드 {
	static int n = 6;
	static int[][] vertex = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };

	static boolean[] visited;
	static ArrayList<Integer>[] arr;

	public static void main(String[] args) {
		int answer = 0;
		visited = new boolean[n + 1];
		arr = new ArrayList[n + 1];
		visited[1] = true;
		for (int i = 1; i <= n; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < vertex.length; i++) {
			arr[vertex[i][0]].add(vertex[i][1]);
			arr[vertex[i][1]].add(vertex[i][0]);
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);

		while (!q.isEmpty()) {
			int size = q.size();
			answer = size;
			for (int i = 0; i < size; i++) {
				int now = q.poll();
				for (int next : arr[now]) {
					// 방문하지 않은 곳만 탐색
					if (!visited[next]) {
						visited[next] = true;
						q.offer(next);
					}
				}
			}
		}
		System.out.println(answer);
	}

}
