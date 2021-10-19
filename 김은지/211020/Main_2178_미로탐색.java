package baekjoon.dfsbfs;
import java.io.*;
import java.util.*;

public class Main_2178_미로탐색 {
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N, M, map[][], answer = 0;
	static boolean[][] visited;
	
	static class Point {
		int x, y, cnt;

		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		bfs();
		System.out.println(answer);
	}

	private static void bfs() {
		ArrayDeque<Point> que = new ArrayDeque<>();
		visited[0][0] = true;
		que.offer(new Point(0, 0, 1));

		while (!que.isEmpty()) {
			Point p = que.poll();
			
			for (int d = 0; d < dx.length; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				
				if (0<=nx && nx<N && 0<=ny && ny<M && !visited[nx][ny] && map[nx][ny] == 1) {
					if (nx == N-1 && ny == M-1) {
						answer = p.cnt+1;
						return;
					}
					visited[nx][ny] = true;
					que.offer(new Point(nx, ny, p.cnt+1));
				}
			}
		}
	}
}
