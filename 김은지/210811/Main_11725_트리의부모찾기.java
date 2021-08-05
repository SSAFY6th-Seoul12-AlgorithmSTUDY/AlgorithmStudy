package baekjoon.dfsbfs;

import java.util.*;
import java.io.*;

public class Main_11725_트리의부모찾기 {
	
	static int N, n[];
	static Map<Integer, LinkedList<Integer>> node;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		n = new int[N+1];
		node = new HashMap<>();
		
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			if (node.get(n1) == null) {
				LinkedList<Integer> l = new LinkedList<>();
				l.add(n2);
				node.put(n1, l);
			} else {
				node.get(n1).add(n2);
			}
			if (node.get(n2) == null) {
				LinkedList<Integer> l = new LinkedList<>();
				l.add(n1);
				node.put(n2, l);
			} else {
				node.get(n2).add(n1);
			}
		}
		
		dfs(1);
		for (int i = 2; i < n.length; i++) {
			sb.append(n[i]).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int p) {
		for (int i : node.get(p)) {
			if (n[i] == 0) {
				n[i] = p;
				dfs(i);
			}
		}
	}

}
