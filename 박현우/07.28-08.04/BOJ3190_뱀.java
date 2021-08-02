package 알고리즘스터디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3190_뱀 {
	static int n;
	static int[][] board;
	static Queue<ArrayList<Object>> convert = new LinkedList<>(); // 뱀의 방향전환 정보
	static Deque<Node> snake = new LinkedList<>(); // 뱀의 몸에 대한 위치 정보
	static StringTokenizer st;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int dir = 1;
	static int x = 0, y = 0; // 뱀의 머리

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		board[0][0] = 2; // 뱀이 있는 자리는 2
		snake.offerFirst(new Node(0, 0)); // 머리를 넣어준다.
		int tc = Integer.parseInt(br.readLine());
		for (int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			// 사과가 있는 자리는 1
			board[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
		}
		tc = Integer.parseInt(br.readLine());
		for (int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			ArrayList<Object> a = new ArrayList<>();
			a.add(time);
			a.add(dir);
			convert.offer(a);
		}
		int day = 0;
		// 로직 구현
		while (true) {
			if (!convert.isEmpty() && (int) convert.peek().get(0) == day) { // 방향 바꿀 시간
				ArrayList<Object> l = convert.poll();
				dir = (char)l.get(1) == 'D' ? dir + 1 : dir - 1; // D면 오른쪽, L이면 왼쪽으로 고개 틀어
				if (dir < 0)
					dir += 4;
				if (dir > 3)
					dir -= 4;
			}
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			// 맵을 넘어가거나 자기 몸을 통과하면 종료
			if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 2) {
				break;
			}
			// 일단 머리를 추가
			snake.offerFirst(new Node(nx, ny));
			// 머리부분 2로 바꿔
			// 이동한 곳에 사과가 없으면 꼬리 자름
			if (board[nx][ny] == 0) {
				Node n = snake.pollLast();
				board[n.x][n.y] = 0; // 꼬리부분 원래대로
			}
			board[nx][ny] = 2;
			x = nx;
			y = ny;
			day++;
		}
		System.out.println(day + 1);
	}
}

class Node {
	int x, y;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}