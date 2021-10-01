package baekjoon.dfsbfs;

import java.io.*;
import java.util.*;

public class Main_2146_다리만들기 {
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N, map[][], answer;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		answer = N*N;
		visited = new boolean[N][N];
		int num = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					map[i][j] = num;
					bfs(i, j, num++, true);
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] > 1) {
					visited = new boolean[N][N];
					bfs(i, j, map[i][j], false);
				}
			}
		}
		
		System.out.println(answer);
	}

	static void bfs(int x, int y, int n, boolean island) {
		ArrayDeque<int[]> que = new ArrayDeque<>();
		visited[x][y] = true;
		que.offer(new int[] {x, y, 0});
		
		while (!que.isEmpty()) {
			int[] p = que.poll();
			x = p[0];
			y = p[1];
			
			for (int d = 0; d < dx.length; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if (0<=nx && nx<N && 0<=ny && ny<N && !visited[nx][ny]) {
					if (island) { //섬 만들기
						if (map[nx][ny] == 1) {
							map[nx][ny] = n;
							visited[nx][ny] = true;
							que.offer(new int[] {nx, ny, 0});
						}
					} else { //다리 만들기
						if (map[nx][ny] == 0) {
							visited[nx][ny] = true;
							que.offer(new int[] {nx, ny, p[2]+1});
						} else if (map[nx][ny] != n) {
							answer = Math.min(answer, p[2]);
							return;
						}
					}
				}
			}
		}
	}

}
