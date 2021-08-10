import java.util.*;
import java.io.*;

public class Main_20058_마법사상어와파이어스톰 {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int max;
	public static void bfs(int[][] m,int i, int j) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {i,j});
		int count = 0;
		while(!q.isEmpty()) {
			int[] point = q.poll();
			for(int d = 0; d < 4; d++) {
				int nx = point[0]+dx[d];
				int ny = point[1]+dy[d];
				
				if(nx >= 0 && nx < m.length && ny >= 0 && ny < m.length && m[nx][ny] != 0) {
					m[nx][ny] = 0;
					m[i][j] = 0;
					q.offer(new int[] {nx,ny});
					if(count == 0) count += 2;
					else count++;
				}
			}
		}
		if(count > max) max = count;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int[][]map = new int[(int) Math.pow(2, N)][(int) Math.pow(2, N)];

		for(int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int[] t = new int[Q];
		for(int i = 0; i < Q; i++) {
			t[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < t.length; i++) {
			int L = (int) Math.pow(2,t[i]);
			if(L > 1) {
				for(int i1 = 0; i1 < map.length; i1+=L) {
					for(int j1 = 0; j1 < map.length; j1+=L) {
						int[][] temp = new int[L][L];
						for(int i2 = 0; i2 < temp.length; i2++) {
							for(int j2 = 0; j2 < temp.length; j2++) {
								temp[i2][j2] = map[i1+L-1-j2][j1+i2];
							}
						}
						for(int i2 = 0; i2 < temp.length; i2++) {
							for(int j2 = 0; j2 < temp.length; j2++) {
								map[i1+i2][j1+j2] = temp[i2][j2];
							}
						}
					}
				}
			}
			ArrayList<int[]> delete = new ArrayList<>();
			for(int i1 = 0; i1 < map.length; i1++) {
				for(int j2 = 0; j2 < map.length; j2++) {
					if(map[i1][j2] == 0) continue;
					int count = 0;
					for(int d = 0; d < 4; d++) {
						int nx = i1+dx[d];
						int ny = j2+dy[d];
						if(nx < 0 || nx > map.length-1 || ny < 0 || ny > map.length-1 || map[nx][ny] == 0) {
							//delete.add(new int[] {i1,j2});
							count++;
						}
						if(count == 2) {
							delete.add(new int[] {i1,j2});
							break;
						}
					}
				}
			}
			for(int[] point : delete) {
				int x = point[0];
				int y = point[1];
				map[x][y]--;
			}
		}
		int total = 0;
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map.length; j++) {
				total += map[i][j];
			}
		}
		max = 0;
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map.length; j++) {
				if(map[i][j] == 0) continue;
				bfs(map, i, j);
			}
		}
		
		System.out.println(total);
		System.out.println(max);
		br.close();
	}
}
