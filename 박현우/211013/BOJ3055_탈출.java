package 알고리즘스터디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3055_탈출 {
	static char[][] board;
	static int r, c;
	static boolean[][] visited;
	static Queue<Node> water = new LinkedList<>(); // 물이 bfs 이동
	static Queue<Node> q = new LinkedList<>(); // 고슴이 bfs 이동
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		board = new char[r][c];
		visited = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
				board[i][j] = temp[j];
				if (board[i][j] == '*') { // 물인경우
					visited[i][j] = true;
					water.offer(new Node(i, j));
				}
				if (board[i][j] == 'S') {// 고슴인경우
					visited[i][j] = true;
					q.offer(new Node(i, j));
				}
			}
		}
		int answer = bfs();
		System.out.println(answer < 0 ? "KAKTUS" : answer);
	}

	static int bfs() {
		int day = 0;
		while (!q.isEmpty()) {
			// 1. 물이 먼저 이동한다.
			int size = water.size();
			for (int i = 0; i < size; i++) {
				Node n = water.poll();
				for (int j = 0; j < 4; j++) {
					int nx = n.x + dx[j];
					int ny = n.y + dy[j];
					if (nx < 0 || ny < 0 || nx >= r || ny >= c || visited[nx][ny] || board[nx][ny] == 'X'
							|| board[nx][ny] == 'D') {
						continue;
					}
					visited[nx][ny] = true;
					water.offer(new Node(nx, ny));
				}
			}
			// 2. 고슴이 이동한다.
			size = q.size();
			for (int i = 0; i < size; i++) {
				Node n = q.poll();
				for (int j = 0; j < 4; j++) {
					int nx = n.x + dx[j];
					int ny = n.y + dy[j];
					if (nx < 0 || ny < 0 || nx >= r || ny >= c || visited[nx][ny] || board[nx][ny] == 'X') {
						continue;
					}
					// 비버 굴을 발견
					if (board[nx][ny] == 'D') {
						return day + 1;
					}
					visited[nx][ny] = true;
					q.offer(new Node(nx, ny));
				}
			}
			day++;
		}
		// 고슴이 도착하지못한 경우 -1 리턴
		return -1;
	}

	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
}
