package 알고리즘스터디;

import java.io.*;
import java.util.*;

public class BOJ1202_보석도둑 {
	static int n, k;
	static long answer; // 보석의 가치가 최대 1,000,000 개수가 300,000 이하라 다더하면 int형을 넘어선다.long으로 저장
	// 여기서 반드시 우선순위를 정해줘야 한다. ClassCastException으로 개고생하기 싫으면
	static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[0], o2[0]));
	static PriorityQueue<Integer> maxValue = new PriorityQueue<>(Collections.reverseOrder()); // 이건 최대 값
	static int[] bags;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		bags = new int[k];
		for (int i = 0; i < n; i++) {
			// 무게를 기준으로 pq에 삽입
			st = new StringTokenizer(br.readLine());
			pq.offer(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}
		// 가방을 담는다.
		for (int i = 0; i < k; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		// 가방을 정렬
		Arrays.sort(bags);
		// 현재 가방에 담을 수 있는 보석응ㄹ 모두 꺼냅니다.
		for (int bag : bags) {
			// 꺼내서 보석의 가치만 최대값 우선순위 큐에 넣어. 왜냐면 현재 가방을 기준으로 가장 가치 있는 놈을 꺼내야하니까
			// 그럼 현재 가방은 모두 정렬되어있으니까 보석이 들은 pq를 계속 쳐다보면서 현재 가방에 들어갈 놈들을 다 넣어. 이걸 반복해
			while (!pq.isEmpty() && pq.peek()[0] <= bag) {
				// 가치만 저장
				maxValue.offer(pq.poll()[1]);
			}
			if (!maxValue.isEmpty()) {
				// 하나만 꺼낸다. 그럼 현재 가방에 가방에 들어갈 수 있는 최대 가치의 보석이 들어감
				answer += maxValue.poll();
			}
		}
		System.out.println(answer);
	}
}