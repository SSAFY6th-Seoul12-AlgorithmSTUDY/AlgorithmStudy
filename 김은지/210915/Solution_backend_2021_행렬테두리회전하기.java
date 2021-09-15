package programmers.dev_matching;

import java.util.Arrays;

public class Solution_backend_2021_행렬테두리회전하기 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(6, 6, new int[][] {{2,2,5,4},{3,3,6,6},{5,1,6,3}})));
		//[8, 10, 25]
		System.out.println(Arrays.toString(solution(3, 3, new int[][] {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}})));
		//[1, 1, 5, 3]
		System.out.println(Arrays.toString(solution(100, 97, new int[][] {{1,1,100,97}})));
		//[1]
	}
	
	public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] matrix = new int[rows][columns];
        int n = 1;
        for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix[i][j] = n++;
			}
		}
        
        for (int i = 0; i < queries.length; i++) {
			answer[i] = changeReturnMin(matrix, queries[i][0]-1, queries[i][1]-1, queries[i][2]-1, queries[i][3]-1);
		}
        
        return answer;
    }
	
	static int changeReturnMin(int[][] m, int sx, int sy, int ex, int ey) {
		int x = sx;
		int y = sy;
		int temp = m[sx][sy];
		int min = m[sx][sy];
		
		while (x <= ex && y <= ey) {
			if (y == sy && x < ex) {
				m[x][y] = m[x+1][y];
				x = x+1;
			} else if (x == ex && y < ey) {
				m[x][y] = m[x][y+1];
				y = y+1;
			} else if (y == ey && x > sx) {
				m[x][y] = m[x-1][y];
				x = x-1;
			} else if (x == sx && y > sy) {
				m[x][y] = m[x][y-1];
				y = y-1;
			}
			min = Math.min(min, m[x][y]);
			if (x == sx && y == sy) break;
		}
		m[x][y+1] = temp;
		
		return min;
	}
}
