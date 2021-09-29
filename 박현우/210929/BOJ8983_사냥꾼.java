package 알고리즘스터디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ8983_사냥꾼 {
	static int n, m, l, answer = 0;
	static int[] archers;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());

		archers = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			archers[i] = Integer.parseInt(st.nextToken());
		}
		// 이분 탐색을 위한 정렬
		Arrays.sort(archers);
		// 동물을 기준으로 y축 다 내리고 남은 거리로 이분탐색해서 사대의 개수를 찾는다.
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dist = l - y;
			// 아무 사대에서도 이 동물은 잡지 못한다.
			if (dist < 0) {
				continue;
			}
			// 왼쪽, 오른쪽 범위를 구한다.
			int left = x - dist;
			int right = x + dist;
			// 사대 배열에서 left, right를 이분탐색해서 총 몇개의 사대가 포함되어있는지 구한다.
			left = Arrays.binarySearch(archers, left);
			right = Arrays.binarySearch(archers, right);
			// 아무 사대도 범위 안에 있지 않은 경우
			if ((left < 0 && right < 0 && left == right) || right == -1 || left == -(m + 1)) {
				continue;
			}
			answer ++;
		}
		System.out.println(answer);
	}

}
