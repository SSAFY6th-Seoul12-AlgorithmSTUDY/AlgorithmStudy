package baekjoon.string;

import java.io.*;

public class Main_1541_잃어버린괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int size = s.length();
		
		StringBuilder sb = new StringBuilder();
		int total = 0;
		char oper = '+';
		for (int i = 0; i < size; i++) {
			if (s.charAt(i) == '-' || s.charAt(i) == '+') {
				if (oper == '+') {
					total += Integer.parseInt(sb.toString());
				} else {
					total -= Integer.parseInt(sb.toString());
				}
				if (oper != '-') oper = s.charAt(i);
				sb = new StringBuilder();
			} else {
				sb.append(s.charAt(i));
			}
		}
		
		if (oper == '+') {
			total += Integer.parseInt(sb.toString());
		} else {
			total -= Integer.parseInt(sb.toString());
		}
		
		System.out.println(total);
	}

}
