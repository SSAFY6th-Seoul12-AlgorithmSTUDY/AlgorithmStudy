package 알고리즘스터디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5021_왕위계승 {
	static int n, m;
	static String king;
	static HashMap<String, Integer> degree = new HashMap<>(); // 진입차수
	static HashMap<String, Double> blood = new HashMap<>(); // 피의 양
	static HashMap<String, ArrayList<String>> child = new HashMap<>(); // 낳은 자식들
	static Queue<String> q = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		king = br.readLine();
		//
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			String c = st.nextToken();
			// 낳은 자식들 추가
			if (!child.containsKey(b)) {
				child.put(b, new ArrayList<>());
			}
			if (!child.containsKey(c)) {
				child.put(c, new ArrayList<>());
			}
			// 피의 양 추가
			if (!blood.containsKey(a)) {
				blood.put(a, (double) 0);
			}
			if (!blood.containsKey(b)) {
				blood.put(b, (double) 0);
			}
			if (!blood.containsKey(c)) {
				blood.put(c, (double) 0);
			}
			// 진입차수 추가
			if (!degree.containsKey(a)) {
				degree.put(a, 0);
			}
			if (!degree.containsKey(b)) {
				degree.put(b, 0);
			}
			if (!degree.containsKey(c)) {
				degree.put(c, 0);
			}
			child.get(b).add(a);
			child.get(c).add(a);
			degree.put(a, 2);
		}
		// 왕은 피의 양이 1
		blood.put(king, (double) 1);
		// 진입차수가 0인 애들을 큐에 삽입
		for (Map.Entry<String, Integer> entry : degree.entrySet()) {
			String key = entry.getKey();
			int value = entry.getValue();
			if (value == 0) {
				q.offer(key);
			}
		}
		while (!q.isEmpty()) {
			String now = q.poll();
			if (!child.containsKey(now))
				continue;
			// 자식들과의 연결을 해제하면서 진입차수를 -1
			for (String s : child.get(now)) {
				degree.put(s, degree.get(s) - 1);
				// 피를 나눠줌
				blood.put(s, blood.get(s) + blood.get(now));
				// 만약 진입차수가 0이면 큐에 삽입
				if (degree.get(s) == 0) {
					// 삽입 전 2로 나눈다.
					if (blood.get(s) != 0) {
						blood.put(s, (double) (blood.get(s) / 2));
					}
					q.offer(s);
				}
			}
		}
		double max = -1;
		String answer = "";
		for (int i = 0; i < m; i++) {
			String now = br.readLine();
			if(!blood.containsKey(now))continue;
			if (max < blood.get(now)) {
				max = blood.get(now);
				answer = now;
			}
		}
		System.out.println(answer);
	}

}
