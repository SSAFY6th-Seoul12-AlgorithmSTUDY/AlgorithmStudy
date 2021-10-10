package 알고리즘스터디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1254_팰린드롬만들기 {
	static String s;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		s = br.readLine();
		// 1. 주어진 문자열 중 가장 긴 팰린드롬을 구한다.
		label: for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < s.length() - i; j++) {
				if (s.charAt(i + j) != s.charAt(s.length() - 1 - j)) {
					continue label;
				}
			}
			// 2. 원래 size * 2 - 가장 긴 팰린드롬의 길이
			System.out.println(s.length() * 2 - (s.length() - i));
			break;
		}
	}
}
