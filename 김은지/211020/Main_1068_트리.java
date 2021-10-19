package baekjoon.tree;
import java.io.*;
import java.util.*;

public class Main_1068_트리 {
	
	static Node[] nodes;
	
	static class Node {
		boolean isRoot;
		int parent;
		Set<Integer> children;
		
		public Node(boolean isRoot, int parent, HashSet<Integer> children) {
			this.isRoot = isRoot;
			this.parent = parent;
			this.children = children;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		nodes = new Node[N];
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			nodes[i] = new Node(false, 0, new HashSet<>());
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			nodes[i].parent = n;
			if (n == -1) {
				nodes[i].isRoot = true;
			} else {
				nodes[n].children.add(i);
			}
		}
		
		int num = Integer.parseInt(br.readLine());
		if (!nodes[num].isRoot) nodes[nodes[num].parent].children.remove(num);
		remove(num);
		for (int i = 0; i < N; i++) {
			if (nodes[i] == null) continue;
			if (nodes[i].children.size() == 0) answer++;
		}
		System.out.println(answer);
		br.close();
	}

	static void remove(int idx) {
		for (int i : nodes[idx].children) remove(i);
		nodes[idx] = null;
	}
}
