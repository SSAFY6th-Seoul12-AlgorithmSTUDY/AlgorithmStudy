package 알고리즘스터디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1541_잃어버린괄호 {
	static ArrayList<Integer> num = new ArrayList<>();
	static ArrayList<Character> op = new ArrayList<>();
	static int answer;
	static boolean flag; // - 만나는 순간부터 true
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str = br.readLine();
		st = new StringTokenizer(str, "+|-"); // +혹은 -로 토큰화
		while (st.hasMoreTokens()) {
			num.add(Integer.parseInt(st.nextToken()));
		}
		answer = num.get(0);
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i)=='-'||str.charAt(i)=='+')
			op.add(str.charAt(i));
		}
		for (int i = 0; i < op.size(); i++) {
			if (op.get(i) == '-')
				flag = true;
			answer = flag ? answer - num.get(i + 1) : answer + num.get(i + 1);
		}
		System.out.println(answer);
	}

}
