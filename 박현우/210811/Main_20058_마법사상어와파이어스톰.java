package 알고리즘스터디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20058_마법사상어와파이어스톰 {
	// 9:25 ~ 10:24
	static int n, q;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		map = new int[1 << n][1 << n];
		// 초기화
		for (int i = 0; i < 1 << n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 1 << n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// q만큼 회전
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < q; i++) {
			// 1. 회전
			divideRotate(1 << Integer.parseInt(st.nextToken()));
			// 2. 얼음 녹이기
			melt();
		}
		// 3. 남아있는 얼음의 합
		// 4. 가장 큰 얼음 덩어리
		sb.append(cntIce()).append("\n").append(biggest());
		System.out.println(sb);

	}

	// 행렬을 나누고 회전한다.
	static void divideRotate(int len) {
		for (int i = 0; i < 1 << n; i += len) {
			for (int j = 0; j < 1 << n; j += len) {
				rotate(i, j, len);
			}
		}
	}

	// 시작점과 길이를 받아 행렬을 회전시킨다.
	static void rotate(int x, int y, int len) {
		int[][] dup = new int[len][len];
		// 해당 영역을 deepcopy
		for (int i = x; i < x + len; i++) {
			for (int j = y; j < y + len; j++) {
				dup[i - x][j - y] = map[i][j];
			}
		}
		// 원래 맵에 삽입
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				// 첫 행은 마지막 열의 위부터 채우게 된다.
				map[x + j][y + len - 1 - i] = dup[i][j];
			}
		}
	}

	// 얼음 녹이기
	static void melt() {
		// ArrayList를 쓰는 이유는 한꺼번에 정리하기 위해서
		// 한꺼번에 정리하는 이유는 다른 곳에 영향을 끼치지 않기 위해서
		ArrayList<int[]> list = new ArrayList<>();
		// 배열을 하나하나 본다.
		for (int i = 0; i < 1 << n; i++) {
			for (int j = 0; j < 1 << n; j++) {
				// 얼음이 없는 곳은 넘어감.
				if (map[i][j] == 0)
					continue;
				int ice = 0;
				// 4방 탐색 진행후 얼음숫자를 센다.
				for (int dir = 0; dir < 4; dir++) {
					int nx = i + dx[dir];
					int ny = j + dy[dir];
					// 범위 및 얼음이 없는곳 핸들링
					if (nx < 0 || ny < 0 || nx >= 1 << n || ny >= 1 << n || map[nx][ny] == 0) {
						continue;
					}
					ice++;
				}
				// 얼음이 3개 이하면 리스트에 삽입
				if (ice < 3) {
					list.add(new int[] { i, j });
				}
			}
		}
		// 녹여
		for (int[] a : list) {
			map[a[0]][a[1]]--;
		}
	}

	// 얼음의 합을 리턴
	static int cntIce() {
		int cnt = 0;
		for (int i = 0; i < 1 << n; i++) {
			for (int j = 0; j < 1 << n; j++) {
				cnt += map[i][j];
			}
		}
		return cnt;
	}

	// 가장 큰 덩어리를 리턴
	static int biggest() {
		Queue<int[]> q = new LinkedList<>();
		int big = 0;
		// bfs탐색
		for (int i = 0; i < 1 << n; i++) {
			for (int j = 0; j < 1 << n; j++) {
				if (map[i][j] == 0)
					continue;
				int cnt = 1;
				map[i][j] = 0;
				q.offer(new int[] { i, j });
				// 큐가 모두 빌때까지
				while (!q.isEmpty()) {
					int[] tmp = q.poll();
					int x = tmp[0];
					int y = tmp[1];
					for (int dir = 0; dir < 4; dir++) {
						int nx = x + dx[dir];
						int ny = y + dy[dir];
						// 범위 핸들링
						if (nx < 0 || ny < 0 || nx >= 1 << n || ny >= 1 << n || map[nx][ny] == 0) {
							continue;
						}
						// 해당 맵을 0으로 바꾸고 cnt ++
						map[nx][ny] = 0;
						cnt++;
						q.offer(new int[] { nx, ny });
					}
				}
				big = Math.max(big, cnt);
			}
		}
		return big;
	}
}
