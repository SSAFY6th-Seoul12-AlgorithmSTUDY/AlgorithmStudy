package baekjoon.simulation;
import java.io.*;
import java.util.*;

public class Main_21608_상어초등학교 {
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		Set<Integer>[] like = new HashSet[N*N];
		int[] order = new int[N*N];
		int answer = 0;
		
		for (int i = 0; i < N*N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int idx = Integer.parseInt(st.nextToken())-1;
			like[idx] = new HashSet<>();
			like[idx].add(Integer.parseInt(st.nextToken()));
			like[idx].add(Integer.parseInt(st.nextToken()));
			like[idx].add(Integer.parseInt(st.nextToken()));
			like[idx].add(Integer.parseInt(st.nextToken()));
			order[i] = idx+1;
		}
		
		map[1][1] = order[0];
		for (int i = 1; i < N*N; i++) {
			int x = 0;
			int y = 0;
			int max = -1;
			int maxEmpty = -1;
			label : for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (map[j][k] != 0) continue;
					
					int cnt = 0;
					int empty = 0;
					for (int d = 0; d < dx.length; d++) {
						int nx = j + dx[d];
						int ny = k + dy[d];
						
						if (0<=nx && nx<N && 0<=ny && ny<N) {
							if (map[nx][ny] == 0) {
								empty++;
							} else if (like[order[i]-1].contains(map[nx][ny])) {
								cnt++;
							}
						}
					}
					if (max < cnt || (max == cnt && maxEmpty < empty)) {
						x = j;
						y = k;
						max = cnt;
						maxEmpty = empty;
						if (cnt == 4) break label;
					} 
				}
			}
			
			map[x][y] = order[i];
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cnt = 0;
				for (int d = 0; d < dx.length; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					
					if (0<=nx && nx<N && 0<=ny && ny<N) {
						if (like[map[i][j]-1].contains(map[nx][ny])) {
							cnt++;
						}
					}
				}
				
				answer += cnt==0?0:Math.pow(10, cnt-1);
			}
		}
		System.out.println(answer);
	}

}
