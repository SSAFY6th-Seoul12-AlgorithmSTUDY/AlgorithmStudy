import java.util.*;
import java.io.*;

public class Main_다리만들기 {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		Queue<int[]> q = new LinkedList<int[]>();
		Map<Integer, ArrayList<String>> c = new HashMap<Integer, ArrayList<String>>();
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		boolean[][] visit = new boolean[N][N]; 
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = 0;
			while(st.hasMoreTokens()) {
				map[i][idx] = Integer.parseInt(st.nextToken());
				idx++;
			}
		}
		int count = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visit[i][j] && map[i][j] == 1) {
					visit[i][j] = true;
					map[i][j] = count;
					q.offer(new int[] {i,j});
					while(!q.isEmpty()) {
						int[] point = q.poll();
						int x = point[0];
						int y = point[1];
						
						for(int d = 0; d < 4; d++) {
							int nx = x + dx[d];
							int ny = y + dy[d];;
							
							if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visit[nx][ny] && map[nx][ny] == 1) {
								visit[nx][ny] = true;
								map[nx][ny] = count;
								q.offer(new int[] {nx,ny});
							}
						}
					}
					count++;
				}
			}
		}
		/*for(int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}*/
		int min = Integer.MAX_VALUE;
		visit = new boolean[N][N];

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visit[i][j] && map[i][j] != 0) {
					visit[i][j] = true;
					q.offer(new int[] {i, j, 0});
					int type = map[i][j];
					while(!q.isEmpty()) {
						int[] point = q.poll();
						int x = point[0];
						int y = point[1];
						
						for(int d = 0; d < 4; d++) {
							int nx = x + dx[d];
							int ny = y + dy[d];
							
							if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visit[nx][ny] && type != map[nx][ny]) {
								visit[nx][ny] = true;
								if(map[nx][ny] == 0) {
									q.offer(new int[] {nx,ny, point[2]+1});
								}
								else{
									min = Math.min(min, point[2]);
								}
							}
							
						}
					}
					visit = new boolean[N][N];
				}
			}
		}
		System.out.println(min);
	}
}
