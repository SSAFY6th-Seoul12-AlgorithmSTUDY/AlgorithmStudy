import java.util.*;
import java.io.*;

public class Main_안전영역 {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		boolean[][] v = new boolean[n][n];
		StringTokenizer st = null;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<int[]> q = new LinkedList<int[]>();
		int answer = 1;
		for(int cur = 1; cur <= 100; cur++) {
			int count = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(v[i][j] || map[i][j] <= cur) continue;
					q.offer(new int[] {i,j});
					v[i][j] = true;
					
					while(!q.isEmpty()) {
						int[] point = q.poll();
						int x = point[0];
						int y = point[1];
						
						for(int d = 0; d < 4; d++) {
							int nx = x+dx[d];
							int ny = y+dy[d];
							
							if(nx>=0 && nx < n && ny >= 0 && ny < n && map[nx][ny] > cur && !v[nx][ny]) {
								q.offer(new int[] {nx,ny});
								v[nx][ny] = true;
							}
						}
					}
					count++;
				}
			}
			v = new boolean[n][n];
			if(count > answer) {
				answer = count;
			}
		}
		System.out.println(answer);
	}

}
