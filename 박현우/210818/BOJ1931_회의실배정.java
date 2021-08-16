package 알고리즘스터디;

import java.io.*;
import java.util.*;

public class BOJ1931_회의실배정 {
	// 우선순위를 끝나는 시간으로 정한다. 다음 순위로 시작하는 시간
	static PriorityQueue<int[]> pq = new PriorityQueue<>(
			// 끝나는 시간이 동일하면 시작하는 시간이 빠른걸로 정렬
			(s1, s2) -> s1[1] == s2[1] ? Integer.compare(s1[0], s2[0]) : Integer.compare(s1[1], s2[1]));
	static int n, answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			// 두개 넣어줘
			pq.offer(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}
		int time = 0;
		// 큐가 모두 빌때까지
		while (!pq.isEmpty()) {
			// 현재 시간까지 이미 시작한 회의들을 모두 꺼내서 제거한다
			while (!pq.isEmpty() && pq.peek()[0] < time) {
				pq.poll();
			}
			// 이제 가장 앞에있는 요소는 시작가능한 회의임과 동시에 가장 빨리 끝나는 회의이다
			// 근데 큐가 비어있으면 종료
			if (pq.isEmpty())
				break;
			// 아니면 뽑아서 종료시간으로 현재 시간을 갱신
			else {
				time = pq.poll()[1];
				answer++;
			}
		}
		System.out.println(answer);
	}

}
