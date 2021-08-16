package 알고리즘스터디;

import java.io.*;

public class BOJ1343_폴리오미노 {
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		// 4:39 ~
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		String input = br.readLine();
		input = input.replaceAll("XXXX", "AAAA");
		input = input.replaceAll("XX", "BB");
		for (int i = 0; i < input.length(); i++) {
			// X가 남아있다면 -1출력 후 종료
			if(input.charAt(i)=='X') {
				System.out.println(-1);
				System.exit(0);
			}
			sb.append(input.substring(i,i+1));
		}
		System.out.println(sb);
	}

}
