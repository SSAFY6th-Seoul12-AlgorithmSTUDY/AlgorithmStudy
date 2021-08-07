package 알고리즘스터디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1388_바닥장식 {
	static boolean[][] visited;
	static char[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int n, m;
	static int answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visited = new boolean[n][m];
		// 맵 다운로드
		for (int i = 0; i < n; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = temp[j];
			}
		}
		// 탐색
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 아직 방문하지 않은 곳
				if (!visited[i][j]) {
					visited[i][j] = true;
					answer++;
					// - 인 경우 좌우 탐색
					if (map[i][j] == '-') {
						for (int dir = 1; dir <= 3; dir += 2) {
							int x = i;
							int y = j;
							while (true) {
								int nx = x + dx[dir];
								int ny = y + dy[dir];
								if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || map[nx][ny] == '|') {
									break;
								}
								visited[nx][ny] = true;
								x = nx;
								y = ny;
							}
						}
					} else {
						for (int dir = 0; dir <= 2; dir += 2) {
							int x = i;
							int y = j;
							while (true) {
								int nx = x + dx[dir];
								int ny = y + dy[dir];
								if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || map[nx][ny] == '-') {
									break;
								}
								visited[nx][ny] = true;
								x = nx;
								y = ny;
							}
						}
					}
				}
			}
		}
		System.out.println(answer);
	}
}
