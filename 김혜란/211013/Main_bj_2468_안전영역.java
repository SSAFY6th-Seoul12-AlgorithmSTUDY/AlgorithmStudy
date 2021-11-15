package com.ssafy.study_1013;

import java.util.Scanner;

public class Main_bj_2468_안전영역 {
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = { 0, 1, 0,-1};
	static int N;
	static int[][] map;
	static boolean[][] checked;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //지역 사이즈
		map = new int[N][N]; //지역 상태정보 받을 배열
		
		int maxH = 0; // 제일 높은 지대
		for (int i = 0; i < N; i++) { //입력받기
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if(maxH < map[i][j]) {
					maxH = map[i][j];
				}
			}
		}
		
		int max = 0; //최대 안전영역 비교 위해
		//모든 지역 탐색
		for (int height = 0; height <= maxH; height++) {
			checked = new boolean[N][N];
			int cnt = 0; //각 높이마다의 안전영역 수
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					//안전 영역 탐지
					if(!checked[i][j] && map[i][j] >height) {
						cnt += dfs(i,j,height);
					}
				}
			}
			max = Math.max(max, cnt);
		}
		System.out.println(max);
		sc.close();
	}

	private static int dfs(int x, int y, int height) { //안전지대 찾기
		checked[x][y] = true; //방문처리
		
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx<0 || ny<0 || nx>=N || ny>=N || checked[nx][ny]) continue;
			if(map[nx][ny] > height) { //높이보다 높으면 
				dfs(nx, ny, height); //다시 dfs
			}
		}
		return 1; //해당 부분이 인접한 안전지대면 +1
	}
}
//https://loosie.tistory.com/297