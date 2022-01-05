package 알고리즘스터디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1966_프린터큐 {
	static int t, n, m;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			String[] temp = br.readLine().split(" ");
			Queue<int[]> q = new LinkedList<>();
			n = Integer.parseInt(temp[0]);
			m = Integer.parseInt(temp[1]);
			temp = br.readLine().split(" ");

			for (int i = 0; i < n; i++) {
				// 큐에 [우선순위, 인덱스번호]를 담는다.
				q.offer(new int[] { Integer.parseInt(temp[i]), i });
			}

			// 큐가 모두 빌때까지
			while (!q.isEmpty()) {
				int maxV = 0;
				// 큐 전체 검사
				for (int i = 0; i < q.size(); i++) {
					// 큐에서 하나 빼서 최대값 갱신
					int[] ele = q.poll();
					maxV = Math.max(maxV, ele[0]);
					// 다시 큐에 넣어줌
					q.offer(ele);
				}
				// 이 값이 가장 큰 값인지 검사
				if (maxV == q.peek()[0]) {
					int[] ele = q.poll();
					// m번째라면
					if (ele[1] == m) {
						System.out.println(n - q.size());
						break;
					}
				} else {
					// 가장 큰값이 아니면 다시 맨뒤로
					q.offer(q.poll());
				}
			}
		}
	}

}
