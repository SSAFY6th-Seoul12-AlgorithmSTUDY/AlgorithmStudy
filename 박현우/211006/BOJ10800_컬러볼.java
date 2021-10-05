package 알고리즘스터디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10800_컬러볼 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] balls = new int[n][3];
		int[] csum = new int[n + 1];
		int[] mem = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			balls[i][0] = Integer.parseInt(st.nextToken());
			balls[i][1] = Integer.parseInt(st.nextToken());
			balls[i][2] = i;
		}
		int pri = 0;
		int sum = 0;
		Arrays.sort(balls, (o1, o2) -> (o1[1]-o2[1]));
		for (int i = 0; i < n; i++) {
			int[] a = balls[i];
            int[] b = balls[pri];
			// 이전 공이 더 작은 경우만
            while (b[1] < a[1]) {
                sum += b[1];
                csum[b[0]] += b[1]; 
                pri++;
                b = balls[pri]; 
            }
            mem[a[2]] = sum - csum[a[0]];
		}
		StringBuilder sb = new StringBuilder();
        for (int a : mem) {
            sb.append(a).append("\n");
        }

        System.out.println(sb);
	}
}
