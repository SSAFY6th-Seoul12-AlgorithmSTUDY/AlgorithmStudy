package algo_12class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1966_프린터큐 {
	static Queue<ArrayList<Object>> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());

		for (int c = 0; c < tc; c++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			// 큐에 자료 삽입
			st = new StringTokenizer(br.readLine());
			int idx = 0;
			// ArrayList에 number, index 저장
			while (st.hasMoreTokens()) {
				ArrayList<Object> l = new ArrayList<>();
				l.add(Integer.parseInt(st.nextToken()));
				l.add(idx++);
				q.offer(l);
			}
			while (!q.isEmpty()) {
				int max = 0;
				int target = (int) q.peek().get(0);
				// 1. 맨 앞의 요소가 가장 큰지 확인
				for (int i = 0; i < q.size(); i++) {
					// 큐를 빼서 확인하고 다시 넣는 것을 size만큼 반복한다.
					ArrayList a = q.poll();
					max = Math.max(max, (int) a.get(0));
					q.add(a);
				}
				// 2. 제일 큰 값이라면 큐에서 pop
				if (max == target) {
					ArrayList a = q.poll();
					// 해당 인덱스가 m과 같다면 종료
					if ((int) a.get(1) == m) {
						System.out.println(n - q.size());
						q.clear();
						break;
					}
				}
				// 3. 제일 큰 값이 아니면 poll & offer
				else{
					q.add(q.poll());
				}
			}
		}
	}
}
