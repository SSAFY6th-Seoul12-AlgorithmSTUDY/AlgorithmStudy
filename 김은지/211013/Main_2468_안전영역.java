package baekjoon.dfsbfs;
import java.io.*;
import java.util.*;

public class Main_2468_안전영역 {
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] visited;
	static int N, max, map[][], answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		max = 0;
		answer = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}
		
		for (int s = 0; s < max; s++) {
			visited = new boolean[N][N];
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > s && !visited[i][j]) {
						bfs(s, i, j);
						cnt++;
					}
				}
			}
			answer = Math.max(answer, cnt);
		}
		
		System.out.println(answer);
	}
	
	static void bfs(int size, int x, int y) {
		ArrayDeque<int[]> que = new ArrayDeque<>();
		visited[x][y] = true;
		que.offer(new int[] {x, y});
		
		while (!que.isEmpty()) {
			int[] p = que.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = p[0] + dx[d];
				int ny = p[1] + dy[d];
				
				if (0<=nx && nx<N && 0<=ny && ny<N && !visited[nx][ny] && map[nx][ny] > size) {
					visited[nx][ny] = true;
					que.offer(new int[] {nx, ny});
				}
			}
		}
	}

}
