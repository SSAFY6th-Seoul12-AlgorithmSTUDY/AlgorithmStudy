package baejoon.MST;

import java.io.*;
import java.util.*;

public class Main_6497_전력난 {

	static Set[] sets;

	static class House implements Comparable<House> {
		int n1, n2, d;

		public House(int n1, int n2, int d) {
			this.n1 = n1;
			this.n2 = n2;
			this.d = d;
		}

		@Override
		public int compareTo(House o) {
			return Integer.compare(this.d, o.d);
		}
	}

	static class Set {
		int n, parent;

		public Set(int n, int parent) {
			this.n = n;
			this.parent = parent;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken()); // 집의 수
			int n = Integer.parseInt(st.nextToken()); // 길의 수
			if (m == 0 && n == 0) break;
			
			House[] houses = new House[n];
			sets = new Set[m];
			int total = 0;

			for (int i = 0; i < m; i++) {
				sets[i] = new Set(i, i);
			}

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				houses[i] = new House(x, y, z);
				total += z;
			}

			Arrays.sort(houses);
			int cnt = 0;

			for (int i = 0; i < n; i++) {
				House h = houses[i];
				if (findSet(h.n1) != findSet(h.n2)) {
					union(sets[h.n1], sets[h.n2]);
					total -= h.d;
					cnt++;
				}
				if (cnt == m - 1) break;
			}
			sb.append(total).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	static int findSet(int n) {
		Set set = sets[n];
		while (set.parent != set.n) {
			set = sets[set.parent];
		}
		return set.parent;
	}

	static void union(Set s1, Set s2) {
		sets[findSet(s2.parent)].parent = findSet(s1.parent);
	}

}
