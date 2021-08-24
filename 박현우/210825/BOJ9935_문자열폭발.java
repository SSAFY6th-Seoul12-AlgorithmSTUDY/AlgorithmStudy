package 알고리즘스터디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9935_문자열폭발 {
	// sol1. 주어진 문자열을 한칸씩 스택에 담는다.
	// sol2. 스택 사이즈가 폭발길이 이상이면 한칸씩 담을때마다 폭발길이만큼 빼서 폭발문자열인지 검사한다.
	// sol3. 검사는 또 다른 스택을 활용한다.
	static String str, bomb;
	static Stack<Character> s = new Stack<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		str = br.readLine();
		bomb = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			s.push(str.charAt(i));
			label: while (s.size() >= bomb.length()) {
				// 폭발 문자열인지 검사
				for (int j = 0; j < bomb.length(); j++) {
					if (s.get(s.size() - bomb.length() + j) != bomb.charAt(j)) {
						break label;
					}
				}
				// 폭발 문자열이 맞음.
				for (int j = 0; j < bomb.length(); j++) {
					s.pop();
				}
			}
		}
		if (s.isEmpty()) {
			sb.append("FRULA");
		} else {
			for (int i = 0; i < s.size(); i++) {
				sb.append(s.get(i));
			}
		}
		System.out.println(sb);
		br.close();
	}

}
