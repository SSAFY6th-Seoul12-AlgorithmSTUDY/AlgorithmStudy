package 알고리즘스터디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15998_카카오머니 {
	static int n, gcd_v = 0;
	static long[] a, b;
	static long res = 0;

	// 1. 현재 잔액에서 음수가 되어 얼마를 충전하는지 확인한다.
	// 2. m = 10000 이라면, 10000원, 20000원, ... 이렇게 여러개의 충전량을 확인할 수 있는데
	// 이것들의 최대 공약수를 구하면 된다.
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		a = new long[n + 1];
		b = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			a[i] = Long.parseLong(st.nextToken());
			b[i] = Long.parseLong(st.nextToken());
			res = gcd(res, b[i] - b[i - 1] - a[i]);

		}
		for (int i = 1; i <= n; i++) {
			if (b[i] - b[i - 1] == a[i])
				continue;
			if (res > 0 && res <= b[i] || a[i] > 0 || a[i] < 0 && -a[i] < b[i - 1]) {
				res = -1;
				break;
			}
		}
		if (res < 0) {
			System.out.println(-1);
		} else if (res == 0) {
			System.out.println(1);
		} else {
			System.out.println(res);
		}
	}

	static long gcd(long a, long b) {
		return b > 0 ? gcd(b, a % b) : a;
	}
}
