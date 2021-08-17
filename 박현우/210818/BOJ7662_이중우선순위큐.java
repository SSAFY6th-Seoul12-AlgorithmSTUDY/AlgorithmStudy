package 알고리즘스터디;

import java.io.*;
import java.util.*;

public class BOJ7662_이중우선순위큐 {
	// 8:44 ~
	static int n, k;

	// TreeMap은 이진 트리 기반으로 항상 오름차순 정렬된 상태를 유지한다.
	// 따라서 firstKey,firstEntry,lastKey,lastEntry 등과 같은 메소드를 제공한다.
	// 본 문제에서는 주어진 value와 해당 value의 개수를 k-v로 사용한다.
	static TreeMap<Integer, Integer> tm;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			k = Integer.parseInt(br.readLine());
			// 트리맵 생성
			tm = new TreeMap<>();
			for (int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine());
				char command = st.nextToken().charAt(0);
				int value = Integer.parseInt(st.nextToken());
				// 삽입일 때
				if (command == 'I') {
					// getOrDefault : 해당 키가 없다면 다음의 값을 default로 놓고 k-v생성
					tm.put(value, tm.getOrDefault(value, 0) + 1);
				}
				// 제거일 때
				else {
					// 사이즈가 0이면 continue
					if (tm.size() == 0)
						continue;
					// 최소값 제거
					if (value < 0) {
						// 만약 하나 남았으면 제거
						if (tm.get(tm.firstKey()) == 1)
							tm.remove(tm.firstKey());
						else
						tm.put(tm.firstKey(), tm.get(tm.firstKey()) - 1);
					}
					// 최대값 제거
					else {
						// 만약 하나 남았으면 제거
						if (tm.get(tm.lastKey()) == 1)
							tm.remove(tm.lastKey());
						else
						tm.put(tm.lastKey(), tm.get(tm.lastKey()) - 1);
					}
				}
			}
			System.out.println(tm.size() == 0 ? "EMPTY" : tm.lastKey() + " " + tm.firstKey());
		}
	}
}