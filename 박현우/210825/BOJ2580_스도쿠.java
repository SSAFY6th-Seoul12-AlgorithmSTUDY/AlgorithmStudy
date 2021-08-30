package 알고리즘스터디;

import java.io.*;
import java.util.*;

public class BOJ2580_스도쿠 {
	static int[][] map = new int[9][9];
	static ArrayList<int[]> arr = new ArrayList<>();

	// 행 검사
	static boolean checkRow(int x, int y, int num) {
		for (int i = 0; i < 9; i++) {
			if (map[x][i] == num)
				return false;
		}
		return true;
	}

	// 열 검사
	static boolean checkCol(int x, int y, int num) {
		for (int i = 0; i < 9; i++) {
			if (map[i][y] == num)
				return false;
		}
		return true;
	}

	// 3x3 사각형 검사
	static boolean checkSqu(int x, int y, int num) {
		for (int i = (x / 3) * 3; i < (x / 3) * 3 + 3; i++) {
			for (int j = (y / 3) * 3; j < (y / 3) * 3 + 3; j++) {
				if (map[i][j] == num)
					return false;
			}
		}
		return true;
	}

	// 백트래킹
	static boolean back(int depth) {
		if (depth == arr.size())
			return true;
		for (int i = 1; i <= 9; i++) {
			int x = arr.get(depth)[0];
			int y = arr.get(depth)[1];
			if (checkCol(x, y, i) && checkRow(x, y, i) && checkSqu(x, y, i)) {
				map[x][y] = i;
				if(back(depth + 1)) {
					return true;
				}
				map[x][y] = 0;
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					arr.add(new int[] { i, j });
			}
		}
		back(0);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(map[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}
