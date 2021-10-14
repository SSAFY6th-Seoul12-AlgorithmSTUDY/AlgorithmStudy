package baekjoon.dfsbfs;
import java.io.*;
import java.util.*;

public class Main_3055_탈출 {
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static char[][] map;
	static int[] loc;
	static List<int[]> waters;
	static int R, C;
	static String answer;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		answer = "KAKTUS";
		
		waters = new ArrayList<>(); //물 위치
		loc = new int[2]; //고슴도치 위치
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'S') {
					loc[0] = i;
					loc[1] = j;
				} else if (map[i][j] == '*') {
					waters.add(new int[] {i, j});
				}
			}
		}
		
		bfs();
		System.out.println(answer);
	}
	
	static void bfs() {
		ArrayDeque<int[]> wque = new ArrayDeque<>();
		ArrayDeque<int[]> que = new ArrayDeque<>();
		for (int[] i:waters) {
			wque.offer(i);
		}
		visited[loc[0]][loc[1]] = true;
		que.offer(new int[] {loc[0], loc[1], 0});
		
		while(!que.isEmpty()) {
			int size = wque.size();
			for (int i = 0; i < size; i++) {
				int[] p = wque.poll();
				for (int d = 0; d < 4; d++) {
					int nx = p[0] + dx[d];
					int ny = p[1] + dy[d];
					
					if (0<=nx && nx<R && 0<=ny && ny<C && map[nx][ny] == '.') {
						wque.offer(new int[] {nx, ny});
						map[nx][ny] = '*';
					}
				}
			}
			
			size = que.size();
			for (int i = 0; i < size; i++) {
				int[] p = que.poll();
				
				for (int d = 0; d < 4; d++) {
					int nx = p[0] + dx[d];
					int ny = p[1] + dy[d];
					
					if (0<=nx && nx<R && 0<=ny && ny<C && !visited[nx][ny]) {
						if (map[nx][ny] == '.')	{
							visited[nx][ny] = true;
							que.offer(new int[] {nx, ny, p[2]+1});
						} else if (map[nx][ny] == 'D') {
							answer = (p[2]+1)+"";
							return;
						}
					}
				}
			}
			
		}
	}

}
