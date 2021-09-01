package programmers.kakao;

import java.util.*;

public class KAKAO_BLIND_RECRUITMENT_2020_기둥과보설치 {

	static Set<Point> row;
	static Set<Point> col;

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(solution(5, new int[][] { { 1, 0, 0, 1 }, { 1, 1, 1, 1 }, { 2, 1, 0, 1 },
				{ 2, 2, 1, 1 }, { 5, 0, 0, 1 }, { 5, 1, 0, 1 }, { 4, 2, 1, 1 }, { 3, 2, 1, 1 } })));
		// output : [[1,0,0],[1,1,1],[2,1,0],[2,2,1],[3,2,1],[4,2,1],[5,0,0],[5,1,0]]
		System.out.println(Arrays.deepToString(solution(5,
				new int[][] { { 0, 0, 0, 1 }, { 2, 0, 0, 1 }, { 4, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 },
						{ 2, 1, 1, 1 }, { 3, 1, 1, 1 }, { 2, 0, 0, 0 }, { 1, 1, 1, 0 }, { 2, 2, 0, 1 } })));
		// output : [[0,0,0],[0,1,1],[1,1,1],[2,1,1],[3,1,1],[4,0,0]]
	}

	public static int[][] solution(int n, int[][] build_frame) {
		int R = build_frame.length;

		row = new HashSet<>(); // 보 좌표 리스트
		col = new HashSet<>(); // 기둥 좌표 리스트

		for (int i = 0; i < R; i++) {
			int x = build_frame[i][0];
			int y = build_frame[i][1];
			int a = build_frame[i][2];
			int b = build_frame[i][3];

			if (a == 0) { // 기둥
				if (b == 0) { // 삭제
					col.remove(new Point(x, y));
					if (col.contains(new Point(x, y - 1)) && !isAvailableCol(x, y - 1)) {
						col.add(new Point(x, y));
						continue;
					}
					if (col.contains(new Point(x, y + 1)) && !isAvailableCol(x, y + 1)) {
						col.add(new Point(x, y));
						continue;
					}
					if (row.contains(new Point(x - 1, y + 1)) && !isAvailableRow(x - 1, y + 1)) {
						col.add(new Point(x, y));
						continue;
					}
					if (row.contains(new Point(x, y + 1)) && !isAvailableRow(x, y + 1)) {
						col.add(new Point(x, y));
						continue;
					}
				} else { // 설치
					if (isAvailableCol(x, y))
						col.add(new Point(x, y));
				}
			} else { // 보
				if (b == 0) { // 삭제
					row.remove(new Point(x, y));
					if (row.contains(new Point(x - 1, y)) && !isAvailableRow(x - 1, y)) {
						row.add(new Point(x, y));
						continue;
					}
					if (row.contains(new Point(x + 1, y)) && !isAvailableRow(x + 1, y)) {
						row.add(new Point(x, y));
						continue;
					}
					if (col.contains(new Point(x, y)) && !isAvailableCol(x, y)) {
						row.add(new Point(x, y));
						continue;
					}
					if (col.contains(new Point(x + 1, y)) && !isAvailableCol(x + 1, y)) {
						row.add(new Point(x, y));
						continue;
					}
				} else { // 설치
					if (isAvailableRow(x, y))
						row.add(new Point(x, y));
				}
			}
		}

		int[][] answer = new int[row.size() + col.size()][3];
		int idx = 0;
		for (Point p : col) {
			answer[idx][0] = p.x;
			answer[idx][1] = p.y;
			answer[idx++][2] = 0;
		}
		for (Point p : row) {
			answer[idx][0] = p.x;
			answer[idx][1] = p.y;
			answer[idx++][2] = 1;
		}
		Arrays.sort(answer, (o1, o2) -> Integer.compare(o1[0], o2[0]) == 0 ? Integer.compare(o1[1], o2[1])
				: Integer.compare(o1[0], o2[0]));

		return answer;
	}

	static boolean isAvailableCol(int x, int y) { // 기둥 설치 가능여부
		if (y == 0)
			return true;
		if (row.contains(new Point(x, y)) || row.contains(new Point(x - 1, y)))
			return true;
		if (col.contains(new Point(x, y - 1)))
			return true;
		return false;
	}

	static boolean isAvailableRow(int x, int y) { // 보 설치 가능여부
		if (col.contains(new Point(x, y - 1)) || col.contains(new Point(x + 1, y - 1)))
			return true;
		if (row.contains(new Point(x - 1, y)) && row.contains(new Point(x + 1, y)))
			return true;
		return false;
	}

}
