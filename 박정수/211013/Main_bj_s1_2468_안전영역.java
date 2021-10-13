package study_09;

import java.util.*;

public class Main_bj_s1_2468_안전영역 {
	static int[] dx= {-1, 0, 1, 0}; //상우하좌
	static int[] dy= {0, 1, 0, -1}; //상우하좌
    static int N, cnt, max;
    static int[][] map;
    static int[][] transmap; //지도 변형
    static boolean[][] v;
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N=sc.nextInt();
		map= new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		//입력확인
		//System.out.println(Arrays.deepToString(map));
		max=1;
		
		for (int i = 1; i < 101; i++) { //높이
			
			transmap= new int[N][N];
			v= new boolean[N][N];
			cnt=0;
			
		for (int a = 0; a < N; a++) {
			for (int b = 0; b < N; b++) {
				if(map[a][b]<=i) transmap[a][b]=0; //높이 이하면 0
				else transmap[a][b]=1; //높이보다 높으면 1
			}
		}
		//System.out.println(Arrays.deepToString(map));
		
		for (int a= 0; a < N; a++) {
			for (int b = 0; b < N; b++) {
				if(transmap[a][b] == 1 && !v[a][b]) {
					dfs(a,b); //1인 위치에서 dfs 시작
					cnt++;//해당 위치에서 dfs 마치면 cnt증가
				}
			}
		}
		max=Math.max(max, cnt);
		}
		System.out.println(max);
		sc.close();
	}

	private static void dfs(int i, int j) {
		v[i][j]=true;
		for (int d = 0; d < 4; d++) {
			int nx=i+dx[d];
			int ny=j+dy[d];
			
			if(nx>=0 && nx<N && ny>=0 && ny<N && transmap[nx][ny] == 1 && !v[nx][ny]) {
				dfs(nx, ny);
			} 
		}		
	}
}
