package algo_12class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2503 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans = 0;
		int tc = Integer.parseInt(br.readLine());
		Object[][] input = new Object[tc][3];
		for (int i = 0; i < tc; i++) {
			String[] tmp = br.readLine().split(" ");
			input[i][0] = tmp[0];
			input[i][1] = Integer.parseInt(tmp[1]);
			input[i][2] = Integer.parseInt(tmp[2]);
		}

		label: for (int i = 123; i < 988; i++) {
			int number = i;
			int hun = number / 100;
			number %= 100;
			int ten = number / 10;
			number %= 10;
			int one = number;
			// 숫자 3개가 다 달라야 한다.
			if (hun == ten || hun == one || ten == one||ten==0||one==0)
				continue;
			for (int cnt = 0; cnt < tc; cnt++) {
				int s = 0, b = 0;
				String num = (String)input[cnt][0];
				// 각 자리 숫자가 맞다면 strike++ 다른 자리에 숫자가 있다면 ball++
				if (num.charAt(0) - '0' == hun)
					s++;
				else if (num.charAt(0) - '0' == ten || num.charAt(0) - '0' == one)
					b++;
				if (num.charAt(1) - '0' == ten)
					s++;
				else if (num.charAt(1) - '0' == hun || num.charAt(1) - '0' == one)
					b++;
				if (num.charAt(2) - '0' == one)
					s++;
				else if (num.charAt(2) - '0' == ten || num.charAt(2) - '0' == hun)
					b++;
				// 스트라이크와 볼 숫자가 다르면 라벨로 돌아감
				if (s != (int) input[cnt][1] || b != (int) input[cnt][2])
					continue label;
			}
			ans++;
		}
		System.out.println(ans);
	}

}
