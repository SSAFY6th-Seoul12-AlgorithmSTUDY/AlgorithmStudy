package 알고리즘스터디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4963_섬의개수 {
	static int n, m;
	static ArrayList<Integer> answer = new ArrayList<>();
	static boolean[][] visited;
	static int[][] map;
	// 8방 탐색
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int cnt = 0;
			// 종료 조건
			if (n == 0 && m == 0)
				break;
			visited = new boolean[n][m];
			map = new int[n][m];
			// 맵 다운로드
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 모든 칸을 탐색하여 1을 찾는다.
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					// 아직 방문하지 않았고, 1이면 bfs탐색 시작
					if (!visited[i][j] && map[i][j] == 1) {
						cnt++;
						bfs(i, j);
					}
				}
			}
			answer.add(cnt);
		}
		for(int i : answer) {
			System.out.println(i);
		}
		br.close();
	}

	static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		visited[x][y] = true;
		q.offer(new Node(x, y)); // 큐에 x,y 삽입
		// 큐가 모두 빌때까지
		while (!q.isEmpty()) {
			Node node = q.poll();
			// 8방 탐색 시작
			for (int i = 0; i < 8; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				// 범위 핸들링, 방문하지않은 1만 탐색
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || map[nx][ny] ==0) {
					continue;
				}
				visited[nx][ny] = true;
				q.offer(new Node(nx, ny));
			}
		}
	}
}

class Node {
	int x, y;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
