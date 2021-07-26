package algo_12class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2231 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			int num = i;
			int tot = num;
			// num이 0이 될때까지 자리수 계산
			while (num != 0) {
				tot += num % 10;
				num /= 10;
			}
			if(tot == n) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}

}
