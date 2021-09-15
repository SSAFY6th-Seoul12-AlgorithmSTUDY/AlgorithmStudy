package 알고리즘스터디;

public class PRO_행렬테두리회전하기 {
	static int[][] board;
	static int[] answer;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static int[] solution(int rows, int columns, int[][] queries) {
		board = new int[rows][columns];
		answer = new int[queries.length];

		// board 초기화
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				board[i][j] = i * columns + j + 1;
			}
		}
		for (int i = 0; i < queries.length; i++) {
			answer[i] = rotate(queries[i][0] - 1, queries[i][1] - 1, queries[i][2] - 1, queries[i][3] - 1);
		}
		return answer;
	}

	static int rotate(int x1, int y1, int x2, int y2) {
		int dir = 0;
		int tmp = board[x1][y1];
		int max = tmp;
		int x = x1;
		int y = y1;
		while (dir < 4) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			// 범위를 벗어나면 방향 전환
			if (nx < x1 || ny < y1 || nx > x2 || ny > y2) {
				dir++;
				continue;
			}
			int temp = board[nx][ny];
			board[nx][ny] = tmp;
			tmp = temp;
			x = nx;
			y = ny;
			max = Math.min(max, tmp);
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(solution(6, 6, new int[][] { { 2, 2, 5, 4 }, { 3, 3, 6, 6 }, { 5, 1, 6, 3 } }));
	}

}
