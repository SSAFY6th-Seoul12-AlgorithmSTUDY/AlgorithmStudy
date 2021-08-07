package 알고리즘스터디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11725_트리의부모찾기 {
	static boolean[] visited;
	static int[] parents;
	static ArrayList<Integer>[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		parents = new int[n + 1];
		arr = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		visited[1] = true;
		// ArrayList초기화
		for (int i = 1; i <= n; i++) {
			arr[i] = new ArrayList<>();
		}

		// 정보 입력
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 양방향 입력
			arr[a].add(b);
			arr[b].add(a);
		}
		dfs(1);
		for(int i = 2;i<=n;i++) {
			System.out.println(parents[i]);
		}
		br.close();
	}

	static void dfs(int parent) {
		for (int i : arr[parent]) {
			// 아직 방문하지 않은 곳만 처리
			if (!visited[i]) {
				visited[i] = true;
				parents[i] = parent;
				dfs(i);
			}
		}
	}
}
