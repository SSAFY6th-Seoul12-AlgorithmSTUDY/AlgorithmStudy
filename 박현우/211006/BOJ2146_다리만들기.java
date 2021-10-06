package 알고리즘스터디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2146_다리만들기 {
	static int[][] board;
	static boolean[][] visited;
	static int n, answer = 100000;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static HashMap<Integer, Integer> hm = new HashMap<>();

	static void numbering(int num, int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });
		board[x][y] = num;
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			x = temp[0];
			y = temp[1];
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
					continue;
				}
				if (board[nx][ny] == 1) {
					board[nx][ny] = num;
					q.offer(new int[] { nx, ny });
				}
			}
		}
	}

	static void extend(int x, int y, int num) {
		visited[x][y] = true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });
		ArrayList<int[]> arr = new ArrayList<>(); // 한꺼번에 확장
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
					continue;
				}
				// 다른 섬을 만났을 경우
				if (board[nx][ny] != 0 && board[nx][ny] != num) {
					answer = Math.min(answer, hm.get(num) + hm.get(board[nx][ny]));
				}
				if (visited[nx][ny])
					continue;
				if (board[nx][ny] == num) {
					visited[nx][ny] = true;
					q.offer(new int[] { nx, ny });
				} else if (board[nx][ny] == 0) {
					visited[nx][ny] = true;
					arr.add(new int[] { nx, ny });
				}
			}
		}
		for (int[] a : arr) {
			board[a[0]][a[1]] = num;
		}
		hm.put(num, hm.get(num) + 1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 1. 섬 넘버링
		int num = 2;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 1) {
					numbering(num, i, j);
					hm.put(num, 0);
					num++;
				}
			}
		}
		// 2. 섬 확장하기
		while (true) {
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j] && board[i][j] != 0) {
						extend(i, j, board[i][j]);
					}
				}
			}
			if (answer != 100000) {
				System.out.println(answer);
				break;
			}
		}
	}
}