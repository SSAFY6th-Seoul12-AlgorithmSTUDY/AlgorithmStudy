package 알고리즘스터디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2468_안전영역 {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int n, max = 0, answer = 1;
	static int[][] board;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (max < board[i][j]) { // 지역의 최대 높이 저장
					max = board[i][j];
				}
			}
		}
		for (int height = 1; height < max; height++) {
			visited = new boolean[n][n];
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] <= height) {
						bfs(height, i, j, 0);
					}
				}
			}
			// 탐색
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j]) {
						bfs(height, i, j, 1);
						cnt++;
					}
				}
			}
			answer = Math.max(answer, cnt);
		}
		System.out.println(answer);

	}

	static void bfs(int height, int x, int y, int com) {
		Queue<Node> q = new LinkedList<>();
		visited[x][y] = true;
		q.offer(new Node(x, y));
		while (!q.isEmpty()) {
			Node now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny]) {
					continue;
				}
				// 높이 이하인 애들 체크만 하는 경우 & 물에 잠기지 않은 지역 탐색
				if ((com == 0 && board[nx][ny] <= height) || com == 1) {
					visited[nx][ny] = true;
					q.offer(new Node(nx, ny));
				}
			}
		}
	}

	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
}
