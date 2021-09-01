package 알고리즘스터디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ4386_별자리만들기 {
	static class Node {
		int start, end;
		double cost;

		public Node(int start, int end, double cost) {
			this.start = start;
			this.end = end;
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
	static int n;
	static double[][] stars;
	static int[] parents;
	static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Double.compare(o1.cost, o2.cost));
	static double answer=0.0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		stars = new double[n][2];
		parents = new int[n];
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			double a = Double.parseDouble(st.nextToken());
			double b = Double.parseDouble(st.nextToken());
			stars[i][0] = a;
			stars[i][1] = b;
		}
		// pq에 차이값 삽입
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				double tot = 0.0;
				double a = Math.abs(stars[i][0] - stars[j][0]);
				double b = Math.abs(stars[i][1] - stars[j][1]);
				tot = a*a + b*b;
				pq.offer(new Node(i, j, Math.sqrt(tot)));
			}
		}
		while (!pq.isEmpty()) {
			Node n = pq.poll();
			if(union(n.start, n.end)) {
				answer+=n.cost;
			}
		}
		System.out.println(String.format("%.2f", answer));
	}

}
