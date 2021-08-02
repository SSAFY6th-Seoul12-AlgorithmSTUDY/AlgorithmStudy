package 알고리즘스터디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ9375 {
	static int n;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		for (int t = 0; t < n; t++) {
			int answer = 1;
			HashMap<String, ArrayList<String>> hm = new HashMap<>();
			int items = Integer.parseInt(br.readLine());
			for (int i = 0; i < items; i++) {
				st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				String kind = st.nextToken();
				// 이미 해당 종류가 있으면 arrayList에 추가
				if (hm.containsKey(kind)) {
					hm.get(kind).add(name);
				} // 없으면 k, v 추가
				else {
					hm.put(kind, new ArrayList<>());
					hm.get(kind).add(name);
				}
			}
			// 모든 부분집합의 수 계산
			for (String s : hm.keySet()) {
				answer *= (hm.get(s).size() + 1);
			}
			System.out.println(answer-1);
		}
	}
}
