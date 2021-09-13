package 알고리즘스터디;

import java.util.Arrays;

public class PRO_길찾기게임 {
	static int[][] nodeinfo = { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 },
			{ 2, 2 } };

	static int[][] answer;
	static int idx;

	static class Node {
		int x, y, value;
		Node left, right;

		public Node(int x, int y, int value, Node left, Node right) {
			this.x = x;
			this.y = y;
			this.value = value;
			this.left = left;
			this.right = right;
		}

	}

	static void insertNode(Node parent, Node child) {
		if (parent.x > child.x) {
			if (parent.left == null)
				parent.left = child;
			else
				insertNode(parent.left, child);
		} else {
			if (parent.right == null)
				parent.right = child;
			else
				insertNode(parent.right, child);
		}
	}

	static void preorder(Node root) {
		if (root != null) {
			answer[0][idx++] = root.value;
			preorder(root.left);
			preorder(root.right);
		}
	}

	static void postorder(Node root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			answer[1][idx++] = root.value;
		}
	}

	public static void main(String[] args) {
		Node[] list = new Node[nodeinfo.length];
		Node root;
		// nodeinfo 를 입력 받는다.
		for (int i = 0; i < nodeinfo.length; i++) {
			list[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1, null, null);
		}
		// 트리에 저장하기 위해 1.y, 2.x 순으로 정렬
		Arrays.sort(list, (o1, o2) -> o1.y == o2.y ? Integer.compare(o1.x, o2.x) : -Integer.compare(o1.y, o2.y));
		root = list[0];
		// 하나씩 루트부터 삽입
		for (int i = 1; i < list.length; i++) {
			insertNode(root, list[i]);
		}

		answer = new int[2][nodeinfo.length];
		idx = 0;
		preorder(root);
		idx = 0;
		postorder(root);
		for (int[] a : answer) {
			System.out.println(Arrays.toString(a));
		}
	}

}
