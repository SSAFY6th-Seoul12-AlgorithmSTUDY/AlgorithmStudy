package 알고리즘스터디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ14891_톱니바퀴 {
	static LinkedList<Integer>[] gear = new LinkedList[5];
	static int k;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int i = 1; i <= 4; i++) {
			gear[i] = new LinkedList<>();
			String tmp = br.readLine();
			for (int j = 0; j < 8; j++) {
				gear[i].offerLast(Integer.parseInt(tmp.substring(j, j + 1)));
			}
		}

		k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			visited = new boolean[5];
			visited[num] = true;
			lotate(dir, num);

		}
		int tot = 0;
		for (int i = 1; i <= 4; i++) {
			if (gear[i].get(0) == 1)
				tot += 1 << (i - 1);
		}
		System.out.println(tot);
	}

	// dir = 시계,반시계 now = 현재 기어 넘버
	static void lotate(int dir, int now) {
		// 왼쪽, 오른쪽 기어를 회전해야하는지 판단
		boolean left = false, right = false;
		if (now - 1 > 0 && !visited[now - 1] && gear[now - 1].get(2) != gear[now].get(6)) {
			left = true;
		}
		if (now + 1 < 5 && !visited[now + 1] && gear[now + 1].get(6) != gear[now].get(2)) {
			right = true;
		}
		// 반시계 방향 회전, 앞에서 빼서 뒤에 삽입
		if (dir < 0) {
			gear[now].offerLast(gear[now].pollFirst());
		}
		// 시계 방향 회전, 뒤에서 빼서 앞에 삽입
		else {
			gear[now].offerFirst(gear[now].pollLast());
		}
		if (left) {
			visited[now - 1] = true;
			lotate(-dir, now - 1);
		}
		if (right) {
			visited[now + 1] = true;
			lotate(-dir, now + 1);
		}
	}

}
