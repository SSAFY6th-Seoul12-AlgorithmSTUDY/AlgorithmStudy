package 알고리즘스터디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ6497_전력난 {
	static class Node {
		int start, dest, cost;

		public Node(int start, int dest, int cost) {
			this.start = start;
			this.dest = dest;
			this.cost = cost;
		}

	}

	static int find(int x) {
		if (parents[x] == x)
			return x;
		return parents[x] = find(parents[x]);
	}

	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b)
			return false;
		if (a < b)
			parents[b] = a;
		else
			parents[a] = b;
		return true;
	}

	// 11:55 ~
	static int n, m, answer;
	static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			answer = 0;
			if (n == 0 && m == 0)
				break;
			parents = new int[n];
			for (int i = 0; i < n; i++) {
				parents[i] = i;
			}

			// 입력받기
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				answer += c;
				pq.offer(new Node(a, b, c));
			}
			while (!pq.isEmpty()) {
				Node n = pq.poll();
				// 시작점과 도착점이 다른 그룹인지 판단
				if (union(n.start, n.dest)) {
					answer -= n.cost;
				}
			}
			sb.append(answer + "\n");
		}
		System.out.println(sb);
		br.close();
	}

}
