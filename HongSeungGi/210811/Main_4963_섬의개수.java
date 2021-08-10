import java.util.*;
import java.io.*;


public class Main_4963_섬의개수 {
	static int[] dx = {1,1,1,0,0,-1,-1,-1};
	static int[] dy = {0,1,-1,-1,1,1,-1,0};
	static boolean[][] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int count = 0;
			if(x == 0 && y == 0) {
				break;
			}
			int[][] rand = new int[x][y];
			visit = new boolean[x][y];
			
			for(int i = 0; i < x; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < y; j++) {
					rand[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			Queue<int[]> q = new LinkedList<int[]>();
			for(int i = 0; i < x; i++) {
				for(int j = 0; j < y; j++) {
					if(rand[i][j] == 0 || visit[i][j] == true) continue;
					q.offer(new int[] {i,j});
					//System.out.println(i+" "+j+" "+visit[i][j]);
					while(!q.isEmpty()) {
						int[] cur = q.poll();
						//System.out.println(cur);
						
						for(int d = 0; d < 8; d++) {
							int newx = cur[0]+dx[d];
							int newy = cur[1]+dy[d];
							if(newx < 0 || newy < 0 || newx > x-1 || newy > y-1 || visit[newx][newy] || rand[newx][newy] == 0) {
								continue;
							}
							//System.out.println(newx+" "+newy);
							q.offer(new int[] {newx,newy});
							visit[newx][newy] = true;
							visit[cur[0]][cur[1]] = true;
						}
					}
					count++;
				}
			}
			System.out.println(count);
			
		}
	}
}
