package 알고리즘스터디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2493_탑 {
	static Stack<Integer> top = new Stack<>(); // 스택에 높이 저장
	static Stack<int[]> s = new Stack<>(); // 스택에 [높이, 인덱스 번호] 저장
	static int[] answer;
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		answer = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			// 탑 높이 스택에 저장
			top.push(Integer.parseInt(st.nextToken()));
		}
		// 모든 탑을 전부 봐야 한다.
		for (int i = n; i > 0; i--) {
			// 1. 탑에서 하나씩 뽑아 스택과 비교한다. 스택은 반드시 정렬되어있다.
			while (!s.isEmpty() && s.peek()[0] < top.peek()) {
				// 2. 스택에서 현재 바라보는 타워의 높이보다 작다면 전부 빼고 인덱스 값 삽입
				int[] tmp = s.pop();
				answer[tmp[1]] = i;
			}
			s.push(new int[] { top.pop(), i - 1 });
		}
		for(int i : answer) {
			System.out.print(i+" ");
		}
	}
}
