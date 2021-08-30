package 알고리즘스터디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18352_특정거리의도시찾기 {
	static int[] dist;
	static Queue<Integer> q = new LinkedList<>();
	static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
	static int n, m, k, x;
	static final int inf = 987654321;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		dist = new int[n + 1];
		// 최단거리 테이블 초기화
		Arrays.fill(dist, inf);
		dist[x] = 0;
		// ArrayList 추가
		for (int i = 0; i <= n; i++) {
			arr.add(new ArrayList<>());
		}
		// 간선 연결
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr.get(a).add(b);
		}
		q.offer(x);
		int dis = 0;
		while (!q.isEmpty()) {
			dis++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int start = q.poll();
				for (int a : arr.get(start)) {
					if (dist[a] != inf)
						continue;
					dist[a] = dis;
					q.offer(a);
				}
			}
		}
		ArrayList<Integer> answer = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (dist[i] == k)
				answer.add(i);
		}
		if (answer.size() == 0) {
			System.out.println(-1);
		}
		else {
			for(int a : answer) {
				System.out.println(a);
			}
		}
	}
}
