package 알고리즘스터디;

import java.util.Arrays;

public class PRO_섬연결하기 {
	static int n = 4;
	static int[][] costs = { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } };

	static int[] parents;
	static int answer = 0;

	static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b)
			return false;
		// 더 낮은 번호를 가지고 있는 집합에 합친다.
		if (a < b)
			parents[b] = a;
		else
			parents[a] = b;
		return true;
	}

	public static void main(String[] args) {
		parents = new int[n];
		// parents 초기화
		for (int i = 0; i < n; i++) {
			parents[i] = i; // 자기 자신을 부모로 갖는 parents 배열
		}
		// 비용을 기준으로 오름차순 정렬
		Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
		for (int[] infor : costs) {
			// 합칠 수 있다면
			if (union(infor[0], infor[1])) {
				answer += infor[2];
			}
		}
		System.out.println(answer);
	}

}
