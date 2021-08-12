package baekjoon.greedy;

import java.io.*;

public class Main_1343_폴리오미노 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st = br.readLine()+" ";
		String answer = "";
		int cnt = 0;
		
		for (int i = 0; i < st.length(); i++) {
			if (cnt == 4) {
				answer += "AAAA";
				cnt = 0;
			}
			if (st.charAt(i) == 'X') cnt++;
			else {
				if (cnt == 2) {
					answer += "BB";
					cnt = 0;
				}
				if (cnt == 0) {
					if (st.charAt(i) == '.') answer += ".";
				} else {
					answer = "-1";
					break;
				}
			}
		}
		
		System.out.println(answer);
	}

}
