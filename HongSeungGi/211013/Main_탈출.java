import java.util.*;
import java.io.*;

public class Main_탈출 {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		boolean[][] v = new boolean[R][C];
		Queue<int[]> water = new LinkedList<int[]>(); 
		Queue<int[]> s = new LinkedList<int []>();
		
		for(int i = 0; i < R; i++) {
			char[] str = br.readLine().toCharArray();
			for(int j = 0; j < C; j++) {
				map[i][j] = str[j];
				if(str[j] == '*') {
					water.offer(new int[] {i,j});
				}
				if(str[j] == 'S') {
					//map[i][j] = '.';
					s.offer(new int[] {i,j});
					v[i][j] = true;
				}
			}
		}
		
		int time = 0;
		Queue<int[]> ns = new LinkedList<int[]>();
		boolean flag = false; 
		while(!s.isEmpty()) {
			int[] cur = s.poll();
			int x = cur[0];
			int y = cur[1];
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] == '.' && !v[nx][ny]) {
					boolean f = false;
					for(int d = 0; d < 4; d++) {
						int nnx = nx + dx[d];
						int nny = ny + dy[d];
						if(nnx >= 0 && nnx < R && nny >= 0 && nny < C && map[nnx][nny] == '*') {
							f = true;
							break;
						}
					}
					if(f) continue;
					ns.offer(new int[] {nx,ny});
					map[nx][ny] = 'S';
					v[nx][ny] = true;
				}
				if(nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] == 'D') {
					flag = true;
				}
			}
			if(flag) break;
			if(s.isEmpty()) {
				if(!ns.isEmpty()) {
					s = ns;
					ns = new LinkedList<int[]>();
					Queue<int[]> nw = new LinkedList<int[]>();
					
					while(!water.isEmpty()) {
						int[] cw = water.poll();
						
						int wx = cw[0];
						int wy = cw[1];
						
						for(int i = 0; i < 4; i++) {
							int nwx = wx+dx[i];
							int nwy = wy+dy[i];
							
							if(nwx >= 0 && nwx < R && nwy >= 0 && nwy < C && (map[nwx][nwy] == '.' || map[nwx][nwy] == 'S')) {
								map[nwx][nwy] = '*';
								nw.offer(new int[] {nwx,nwy});
							}
						}
					}
					water = nw;
					time++;
				}
			}
		}
		if(flag) System.out.println(time+1);
		else System.out.println("KAKTUS");
	}

}
