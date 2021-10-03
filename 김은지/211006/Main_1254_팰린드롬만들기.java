package baekjoon.string;

import java.io.*;

public class Main_1254_팰린드롬만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int len = s.length();
		
		label : for (int i = 0; i < len+1; i++) {
			String str = s;
			if (i > 0) {
				for (int j = i-1; j >= 0; j--) {
					str += s.charAt(j);
				}
			}
			int strlen = len + i;
			
			for (int j = 0; j < strlen/2; j++) {
				if (str.charAt(j) != str.charAt(strlen-1-j)) continue label;
			}
			
			System.out.println(strlen);
			break;
		}
		
	}

}
